package application;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.SendFailedException;
import javax.mail.Address;

public class EmailSender {
    private static final String FROM_EMAIL = "quy5704quy@gmail.com";
    private static final String PASSWORD = "ppzo qesh ippw yxxs";

    public static boolean sendOTPEmail(String toEmail, String otp) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Mã OTP xác thực");
            message.setText("Mã OTP của bạn là: " + otp + "\nMã này có hiệu lực trong 1 phút.");

            Transport.send(message);
            System.out.println("Đã gửi mã OTP đến " + toEmail);
            return true;
        } catch (SendFailedException sfe) {
            // Lấy danh sách các địa chỉ không hợp lệ từ ngoại lệ
            Address[] invalidAddresses = sfe.getInvalidAddresses();
            if (invalidAddresses != null) {
                for (Address address : invalidAddresses) {
                    if (address.toString().equals(toEmail)) {
                        System.out.println("Email " + toEmail + " không tồn tại.");
                        return false;
                    }
                }
            }
            sfe.printStackTrace();
            return false;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
    
 // Ví dụ sử dụng hàm
    public static void main(String[] args) {
        String toEmail = "huhu24035@gmail.com"; // Thay bằng email cần kiểm tra
        String otp = "123456";
        boolean result = sendOTPEmail(toEmail, otp);
        System.out.println("Kết quả gửi email: " + result);
    }
}