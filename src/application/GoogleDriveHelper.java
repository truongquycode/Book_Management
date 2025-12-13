package application;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.Permission;
import java.io.IOException;

public class GoogleDriveHelper {

    /**
     * Cấp quyền truy cập đọc cho file trên Google Drive.
     *
     * @param driveService   Đối tượng Drive đã được xác thực
     * @param fileId         ID của file trên Google Drive
     * @param userEmail      Email của người dùng cần cấp quyền
     * @throws IOException   Nếu có lỗi trong quá trình gọi API
     */
    public static void grantFileAccess(Drive driveService, String fileId, String userEmail) throws IOException {
        Permission permission = new Permission();
        permission.setType("user");       // Cấp quyền cho một user cụ thể
        permission.setRole("reader");     // Quyền xem (reader)
        permission.setEmailAddress(userEmail);

        // Tùy chọn: nếu bạn không muốn gửi email thông báo, có thể tắt notification
        driveService.permissions()
            .create(fileId, permission)
            .setSendNotificationEmail(false)
            .execute();
        
        System.out.println("Đã cấp quyền cho " + userEmail + " đối với file: " + fileId);
    }
    
    // Ví dụ sử dụng:
    public static void main(String[] args) {
        // Giả sử bạn đã có đối tượng Drive được khởi tạo và xác thực
		Drive driveService;
		
		try {
			driveService = GoogleDriveServiceHelper.getDriveService();
			String fileId = "1tUfHRCoCK6pO9fowu9HnQwzgAm2XBibt"; // ID của file ebook trên Google Drive
		    String userEmail = "quy5704quy@gmail.com"; // Email người mua
		    
		    grantFileAccess(driveService, fileId, userEmail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
