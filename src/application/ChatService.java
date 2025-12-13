package application;

import com.rabbitmq.client.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ChatService {
	private static final String EXCHANGE_NAME = "chat_exchange";
	private static final String USER_QUEUE_PREFIX = "chat_user_";
	private static final String ADMIN_ROUTING_KEY = "admin";
	private static final String ADMIN_QUEUE = "chat_admin";

	private Connection connection;
	private Channel channel;
	private Map<String, String> consumerTags = new HashMap<>(); // Lưu trữ consumerTag

	public ChatService() throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		connection = factory.newConnection();
		channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, true);
		channel.queueDeclare(ADMIN_QUEUE, true, false, false, null);
		channel.queueBind(ADMIN_QUEUE, EXCHANGE_NAME, ADMIN_ROUTING_KEY);
	}

	public void closeConsumer(String queueName) throws Exception {
		if (channel != null && channel.isOpen() && consumerTags.containsKey(queueName)) {
			channel.basicCancel(consumerTags.get(queueName)); // Hủy bằng consumerTag
			consumerTags.remove(queueName);
			System.out.println("❌ Consumer của " + queueName + " đã bị hủy.");
		}
	}

	public void deleteQueue(String queueName) throws Exception {
		if (channel != null && channel.isOpen()) {
			channel.queueDelete(queueName, false, false); // Buộc xóa queue
			System.out.println("🗑 Queue " + queueName + " đã bị xóa.");
		}
	}

	public void sendMessageFromUser(String userId, String message) throws Exception {
		saveMessageToDatabase(userId, "admin", message); // Lưu tin nhắn trước khi gửi
		if (channel == null || !channel.isOpen()) {
			channel = connection.createChannel();
		}
		AMQP.BasicProperties props = new AMQP.BasicProperties.Builder().deliveryMode(2)
				.headers(Map.of("userId", userId)).build();
		channel.basicPublish(EXCHANGE_NAME, ADMIN_ROUTING_KEY, props, message.getBytes("UTF-8"));
	}

	public void sendMessageToUser(String userId, String message) throws Exception {
		saveMessageToDatabase("admin", userId, message); // Lưu tin nhắn trước khi gửi
		String queueName = USER_QUEUE_PREFIX + userId;
		if (channel == null || !channel.isOpen()) {
			System.out.println("⚠ Channel bị đóng, tạo lại...");
			channel = connection.createChannel();
		}
		AMQP.BasicProperties props = new AMQP.BasicProperties.Builder().deliveryMode(2)
				.headers(Map.of("sender", "admin")).build();
		channel.basicPublish(EXCHANGE_NAME, queueName, props, message.getBytes("UTF-8"));
	}

	public void setupUserQueue(String userId, DeliverCallback callback) throws Exception {
		String queueName = USER_QUEUE_PREFIX + userId;

		if (channel == null || !channel.isOpen()) {
//			System.out.println("⚠ Channel bị đóng, tạo lại...");
			channel = connection.createChannel();
		}

		// Hủy consumer cũ nếu tồn tại
		if (consumerTags.containsKey(queueName)) {
			try {
				channel.basicCancel(consumerTags.get(queueName));
				consumerTags.remove(queueName);
				System.out.println("⚠ Đã hủy consumer cũ cho user: " + userId);
			} catch (Exception ignored) {
			}
		}

		channel.basicQos(1);
		channel.queueDeclare(queueName, true, false, false, null);
		channel.queueBind(queueName, EXCHANGE_NAME, queueName);

		String consumerTag = channel.basicConsume(queueName, false, (ct, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			System.out.println("📩 [DEBUG] Nhận tin nhắn từ user: " + userId + " -> " + message);
			callback.handle(ct, delivery);
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
			System.out.println("✅ [DEBUG] Đã xác nhận tin nhắn.");
		}, ct -> {
		});

		consumerTags.put(queueName, consumerTag); // Lưu consumerTag
	}

	public void setupAdminQueue(DeliverCallback callback) throws Exception {
		if (channel == null || !channel.isOpen()) {
			System.out.println("⚠ Channel bị đóng, tạo lại...");
			channel = connection.createChannel();
		}

		// Hủy consumer cũ nếu tồn tại
		if (consumerTags.containsKey(ADMIN_QUEUE)) {
			try {
				channel.basicCancel(consumerTags.get(ADMIN_QUEUE));
				consumerTags.remove(ADMIN_QUEUE);
				System.out.println("⚠ Đã hủy consumer cũ cho Admin");
			} catch (Exception ignored) {
			}
		}

		channel.basicQos(1);

		String consumerTag = channel.basicConsume(ADMIN_QUEUE, false, (ct, delivery) -> {
			callback.handle(ct, delivery);
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		}, ct -> {
		});

		consumerTags.put(ADMIN_QUEUE, consumerTag); // Lưu consumerTag
	}

	private void saveMessageToDatabase(String sender, String receiver, String message) {
		String sql = "INSERT INTO messages (sender, receiver, message) VALUES (?, ?, ?)";
		try (java.sql.Connection conn = DataBaseConnect.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, sender);
			stmt.setString(2, receiver);
			stmt.setString(3, message);
			stmt.executeUpdate();
			System.out.println("Đã lưu tin nhắn: " + sender + " -> " + receiver + ": " + message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() throws Exception {
		if (channel != null && channel.isOpen())
			channel.close();
		if (connection != null && connection.isOpen())
			connection.close();
	}
}