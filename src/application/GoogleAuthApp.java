package application;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponseException;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfoplus;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Collection;

public class GoogleAuthApp {
    private static final String CLIENT_SECRET_FILE = "client_secret.json"; // Tải từ Google Cloud Console
    private static final Collection<String> SCOPES = Collections.singleton("https://www.googleapis.com/auth/userinfo.email"); // Scope lấy email
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens"; // Thư mục lưu token
    private GoogleAuthorizationCodeFlow flow;

    // Biến lưu email xác thực thành công
    private String authEmail;
    // Dialog sẽ trả về email (kiểu String)
    private Dialog<String> authDialog;

    // Phương thức này tạo và trả về một Dialog chứa giao diện xác thực Google
    public Dialog<String> authenticateWithGoogle(Stage primaryStage) throws IOException, GeneralSecurityException {
    	AlertMessage alert = new AlertMessage();
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        InputStream in = getClass().getResourceAsStream("/client_secret.json");
        if (in == null) {
            throw new FileNotFoundException("Không tìm thấy file client_secret.json trong resources.");
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));


        // Xây dựng luồng xác thực
        flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();

        // Tạo WebView để hiển thị trang xác thực
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        // Tạo URL xác thực
        String authUrl = flow.newAuthorizationUrl()
                .setRedirectUri("urn:ietf:wg:oauth:2.0:oob")
                .build();

        // Tải trang xác thực Google trong WebView
        webEngine.load(authUrl);

        // Tạo nút điều hướng
        Button backButton = new Button("<");
        backButton.getStyleClass().add("btn-mac-dinh");
        backButton.setOnAction(e -> {
            if (webEngine.getHistory().getCurrentIndex() > 0) {
                webEngine.getHistory().go(-1);
            }
        });

        Button forwardButton = new Button(">");
        forwardButton.getStyleClass().add("btn-mac-dinh");
        forwardButton.setOnAction(e -> {
            if (webEngine.getHistory().getCurrentIndex() < webEngine.getHistory().getEntries().size() - 1) {
                webEngine.getHistory().go(1);
            }
        });

        HBox navigationPane = new HBox(10, backButton, forwardButton);
        navigationPane.setAlignment(Pos.CENTER);

        // Giao diện nhập mã ủy quyền thủ công
        VBox inputPane = new VBox(10);
        inputPane.setPadding(new Insets(10));
        inputPane.setAlignment(Pos.CENTER);

        Label instructionLabel = new Label("Sao chép TOÀN BỘ mã ủy quyền từ trang Google (bắt đầu bằng '4/') và dán vào đây:");
        TextField codeField = new TextField();
        codeField.setPromptText("Ví dụ: 4/xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        Button submitButton = new Button("Xác nhận mã");
        submitButton.getStyleClass().add("btn-mac-dinh");
        submitButton.setOnAction(e -> {
            String authCode = codeField.getText().trim();
            if (!authCode.isEmpty()) {
                if (authCode.startsWith("4/")) {
                    processAuthorizationCode(authCode);
                } else {
                	alert.errorMessage("Lỗi Mã ủy quyền không đúng định dạng. Đảm bảo mã bắt đầu bằng '4/'.");
                }
            } else {
            	alert.errorMessage("Lỗi Vui lòng nhập mã ủy quyền.");
            }
        });

        inputPane.getChildren().addAll(instructionLabel, codeField, submitButton);

        // Tạo giao diện chính của Dialog
        VBox mainPane = new VBox(10, navigationPane, webView, inputPane);
        mainPane.setPrefSize(500, 600);

        // Tạo Dialog mới và set nội dung giao diện
        authDialog = new Dialog<>();
        authDialog.setTitle("Google Authentication");
        authDialog.setHeaderText("Vui lòng xác thực tài khoản Google của bạn.");
        authDialog.getDialogPane().setContent(mainPane);
        
        // Thêm nút Cancel để người dùng có thể tắt dialog
        authDialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        
        // Thiết lập result converter: nếu người dùng nhấn Cancel trả về null, nếu không trả về authEmail.
        authDialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.CANCEL) {
                return null;
            }
            return authEmail;
        });
        
     // Style nút
        String buttonStyle = """
            -fx-background-color: linear-gradient(to right, #00c6ff, #0072ff);
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 0;
            -fx-border-radius: 0;
            -fx-border-width: 0;
            -fx-cursor: hand;
            -fx-padding: 6 16;
        """;

        // Style TextField
        String codeFieldStyle = """
            -fx-border-color: #0072ff;
            -fx-border-width: 1;
            -fx-background-radius: 0;
            -fx-border-radius: 0;
            -fx-padding: 6;
            -fx-font-size: 14px;
        """;

        // Style WebView
        String webViewStyle = """
            -fx-border-color: #cccccc;
            -fx-border-width: 1;
            -fx-background-radius: 0;
            -fx-border-radius: 0;
        """;

        // Style DialogPane
        String dialogPaneStyle = """
            -fx-background-color: #f9f9f9;
            -fx-background-radius: 0;
            -fx-border-radius: 0;
            -fx-border-color: #cccccc;
            -fx-border-width: 1;
        """;

        // Áp dụng style
        backButton.setStyle(buttonStyle);
        forwardButton.setStyle(buttonStyle);
        submitButton.setStyle(buttonStyle);
        codeField.setStyle(codeFieldStyle);
        webView.setStyle(webViewStyle);
        authDialog.getDialogPane().setStyle(dialogPaneStyle);

        // Ẩn tiêu đề và nút mặc định
        authDialog.setTitle(null);
        authDialog.setHeaderText(null);

        
        return authDialog;
    }
    
    
    
    public void clearTokens() {
        File tokenDirectory = new File(TOKENS_DIRECTORY_PATH);
        if (tokenDirectory.exists() && tokenDirectory.isDirectory()) {
            for (File file : tokenDirectory.listFiles()) {
                file.delete();
            }
        }
    }

    // Xử lý mã ủy quyền nhập vào và sau đó lấy thông tin người dùng từ Google
    private void processAuthorizationCode(String authCode) {
    	AlertMessage alert = new AlertMessage();
        try {
//            System.out.println("Đang xử lý mã ủy quyền: " + authCode);
            // Đổi mã ủy quyền lấy token
            GoogleTokenResponse tokenResponse = flow.newTokenRequest(authCode)
                    .setRedirectUri("urn:ietf:wg:oauth:2.0:oob")
                    .execute();

            // Tạo Credential từ token
            Credential credential = flow.createAndStoreCredential(tokenResponse, "user");

            if (credential != null && credential.getAccessToken() != null) {
//                System.out.println("Xác thực thành công! Access Token: " + credential.getAccessToken());

                // Lấy thông tin email từ Google
                Oauth2 oauth2 = new Oauth2.Builder(
                        GoogleNetHttpTransport.newTrustedTransport(),
                        JSON_FACTORY,
                        credential).setApplicationName("YourAppName").build();
                Userinfoplus userinfo = oauth2.userinfo().get().execute();
                String email = userinfo.getEmail();

                // Hiển thị thông báo thành công (có thể bỏ qua nếu không cần)
                
                alert.successMessage("Email " + email + " đã được xác thực.");

                // Lưu email vào biến authEmail và đóng dialog
                authEmail = email;
                if (authDialog != null) {
                    authDialog.setResult(email);  // Cũng được sử dụng để thiết lập kết quả trả về
                    authDialog.close();
                }
            } else {
                alert.errorMessage("Lỗi xác thực Không thể tạo credential từ mã ủy quyền.");
            }
        } catch (TokenResponseException ex) {
            if (ex.getDetails() != null && "invalid_grant".equals(ex.getDetails().getError())) {
            	alert.errorMessage("Lỗi xác thực Mã ủy quyền không hợp lệ hoặc đã hết hạn. Vui lòng lấy mã mới từ trang Google.");
            } else {
            	alert.errorMessage("Lỗi xác thực Có lỗi xảy ra khi xử lý mã ủy quyền: " + ex.getMessage());
            }
//            ex.printStackTrace();
        } catch (IOException | GeneralSecurityException ex) {
        	alert.errorMessage("Lỗi xác thực Có lỗi không xác định khi xử lý mã ủy quyền.");
            ex.printStackTrace();
        }
    }


}
