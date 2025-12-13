package application;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.drive.Drive;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class GoogleDriveServiceHelper {
    private static final String APPLICATION_NAME = "Desktop client EBook Save Driver";
	private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    @SuppressWarnings("deprecation")
	public static Drive getDriveService() throws GeneralSecurityException, IOException {
        // Đọc file credentials.json từ thư mục resources
        InputStream in = GoogleDriveServiceHelper.class.getResourceAsStream("/credentials.json");
        if (in == null) {
            throw new IOException("File credentials.json không tồn tại trong classpath");
        }
        // Tạo đối tượng GoogleCredential từ file JSON
        GoogleCredential credential = GoogleCredential.fromStream(in)
            .createScoped(Collections.singleton("https://www.googleapis.com/auth/drive"));

        return new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
}
