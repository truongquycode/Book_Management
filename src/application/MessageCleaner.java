package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MessageCleaner {
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void startCleaning() {
        scheduler.scheduleAtFixedRate(() -> {
            String sql = "DELETE FROM messages WHERE timestamp < NOW() - INTERVAL 14 DAY";
            try (Connection conn = DataBaseConnect.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                int rowsDeleted = stmt.executeUpdate();
                System.out.println("Đã xóa " + rowsDeleted + " tin nhắn cũ hơn 14 ngày.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }, 0, 1, TimeUnit.DAYS); // Chạy mỗi ngày 1 lần
    }
}