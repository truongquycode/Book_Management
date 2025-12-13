package application;

import com.google.api.services.drive.Drive;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EbookEmailSender {
    private static final String FROM_EMAIL = "quy5704quy@gmail.com";
    private static final String PASSWORD = "ppzo qesh ippw yxxs";

    /**
     * Gửi email chứa danh sách tên sách và các link tải sách điện tử.
     * Trước khi gửi email, cấp quyền truy cập cho email người mua trên các file (Google Drive)
     * được trích xuất từ các link tải.
     *
     * @param toEmail       Địa chỉ email người nhận.
     * @param bookNames     Danh sách tên sách đã mua.
     * @param downloadLinks Danh sách các link tải sách tương ứng.
     * @return true nếu gửi thành công, false nếu có lỗi.
     */
    public static boolean sendEbookEmail(String toEmail, List<String> bookNames, List<String> downloadLinks) {
        // Bước 1: Cấp quyền truy cập trên Google Drive cho các file ebook
        try {
            // Lấy đối tượng Drive đã được xác thực
            Drive driveService = GoogleDriveServiceHelper.getDriveService();
            for (String downloadLink : downloadLinks) {
                String fileId = extractFileIdFromUrl(downloadLink);
                if (fileId != null) {
                    GoogleDriveHelper.grantFileAccess(driveService, fileId, toEmail);
                } else {
                    System.err.println("Không thể trích xuất fileId từ link: " + downloadLink);
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi cấp quyền truy cập file trên Google Drive: ");
            e.printStackTrace();
            // Bạn có thể chọn không gửi email nếu cấp quyền không thành công
            return false;
        }

        // Bước 2: Gửi email chứa thông tin sách và link tải
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Tạo Session với xác thực SMTP
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
            message.setSubject("Link tải sách điện tử của bạn");

            // Xây dựng nội dung email
            StringBuilder contentBuilder = new StringBuilder();
            contentBuilder.append("Cảm ơn bạn đã mua sách!\n\n")
                          .append("Danh sách sách bạn đã mua:\n");
            int count = 1;
            for (String name : bookNames) {
                contentBuilder.append(count++).append(". ").append(name).append("\n");
            }
            contentBuilder.append("\nDưới đây là các link tải sách điện tử:\n");
            count = 1;
            for (String link : downloadLinks) {
                contentBuilder.append(count++).append(". ").append(link).append("\n");
            }
            contentBuilder.append("\nLưu ý: Link này chỉ có hiệu lực với tài khoản email khi mua sách.");

            message.setText(contentBuilder.toString());

            Transport.send(message);
            System.out.println("Đã gửi email chứa tên sách và các link tải đến " + toEmail);
            return true;
        } catch (MessagingException e) {
            System.err.println("Lỗi khi gửi email: ");
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Trích xuất fileId từ URL của Google Drive.
     * Giả sử URL có định dạng: https://drive.google.com/file/d/{fileId}/view?usp=sharing
     *
     * @param url URL chứa fileId.
     * @return fileId nếu tìm thấy, ngược lại trả về null.
     */
    public static String extractFileIdFromUrl(String url) {
        if (url.contains("/folders/")) {
            // Ví dụ: https://drive.google.com/drive/u/0/folders/1tUfHRCoCK6pO9fowu9HnQwzgAm2XBibt
            String[] parts = url.split("/folders/");
            if (parts.length > 1) {
                String folderId = parts[1];
                // Loại bỏ bất kỳ ký tự thừa nào sau folderId (ví dụ: dấu '/' hoặc query string)
                int slashIndex = folderId.indexOf("/");
                if (slashIndex != -1) {
                    folderId = folderId.substring(0, slashIndex);
                }
                return folderId;
            }
        } else if (url.contains("/d/")) {
            // Ví dụ: https://drive.google.com/file/d/1A2B3C4D5E6F7G8H9I0/view?usp=sharing
            String[] parts = url.split("/d/");
            if (parts.length > 1) {
                String remaining = parts[1];
                // File ID nằm trước dấu '/'
                String[] parts2 = remaining.split("/");
                return parts2[0];
            }
        }
        return null; // Không tìm thấy fileId
    }

    
    // Ví dụ sử dụng hàm
    public static void main(String[] args) {
        String toEmail = "truongb2204976@student.ctu.edu.vn"; // Địa chỉ email nhận
        List<String> bookNames = List.of("Sách Lập Trình Java", "Sách Thiết Kế Hệ Thống", "Sách Kiến Thức Tổng Hợp");
        // Giả sử các link tải là link file Google Drive có định dạng chuẩn
        List<String> downloadLinks = List.of(
            "https://drive.google.com/file/d/1A2B3C4D5E6F7G8H9I0/view?usp=sharing",
            "https://drive.google.com/file/d/2B3C4D5E6F7G8H9I0J1/view?usp=sharing",
            "https://drive.google.com/file/d/3C4D5E6F7G8H9I0J1K2/view?usp=sharing"
        );
        boolean result = sendEbookEmail(toEmail, bookNames, downloadLinks);
        System.out.println("Kết quả gửi email: " + result);
    }
}
