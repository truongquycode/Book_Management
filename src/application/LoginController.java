package application;

import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;

import org.mindrot.jbcrypt.BCrypt;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class LoginController implements Initializable {
	@FXML
	private Button changePass_btnBack;

	@FXML
	private Button changePass_btnProceed;

	@FXML
	private PasswordField changePass_confirmPassword;

	@FXML
	private AnchorPane changePass_form;

	@FXML
	private PasswordField changePass_password;

	@FXML
	private TextField forgot_answer;
	
	@FXML
	private TextField forgot_OTPText;
	

	@FXML
	private Button forgot_bntBack;

	@FXML
	private Button forgot_bntProceed;

	@FXML
	private AnchorPane forgot_form;

	@FXML
	private ComboBox<?> forgot_selectQuestion;

	@FXML
	private TextField forgot_email;

	@FXML
	private Button login_btn;

	@FXML
	private Button login_createAccount;

	@FXML
	private Hyperlink login_forgotPassword;
	
	@FXML
	private Hyperlink getOTPHyperlink;
	
	@FXML
	private Hyperlink getOTPHyperLink1;

	@FXML
	private AnchorPane login_form;

	@FXML
	private PasswordField login_password;

	@FXML
	private CheckBox login_selectShowPassword;

	@FXML
	private TextField login_showPassword;

	@FXML
	private TextField login_uername;

	@FXML
	private AnchorPane main_form;

	@FXML
	private HBox signup_hBoxCountdown;
	
	@FXML
	private HBox signup_hBoxCountdown1;
	
	@FXML
	private Label signup_countDownText;
	
	@FXML
	private Label signup_countDownText1;
	

	@FXML
	private Button signup_btn;

	@FXML
	private PasswordField signup_confirmPassword;

	@FXML
	private TextField signup_email;

	@FXML
	private AnchorPane signup_form;

	@FXML
	private Button signup_loginAccount;

	@FXML
	private PasswordField signup_password;

	@FXML
	private ComboBox<?> signup_selectQuestion;

	@FXML
	private TextField signup_username;
	@FXML
	private TextField signup_OTPText;

	@FXML
	private TextField signup_fullname;

	private Connection connect;
	private PreparedStatement prepare;
	private ResultSet result;
	private Statement statement;
	
	private String generatedOTP = "";
	
	private GoogleAuthApp googleAuthApp = new GoogleAuthApp();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	    signup_email.setOnMouseClicked(event -> {
	        Stage primaryStage = (Stage) signup_email.getScene().getWindow();
	        googleAuthApp.clearTokens(); // Clear old tokens
	        try {
	            Dialog<String> authDialog = googleAuthApp.authenticateWithGoogle(primaryStage);
	            // Hiển thị Dialog và lấy kết quả (email) trả về
	            authDialog.showAndWait().ifPresent(email -> {
	                // Ở đây bạn có thể sử dụng email mà không cần gọi setEmailFromGoogle
	                
	                
	                String checkUsername = "select * from accounts where email = ?";
	        		connect = DataBaseConnect.getConnection();
	        		try {
	        			prepare = connect.prepareStatement(checkUsername);
	        			prepare.setString(1, email);
	        			result = prepare.executeQuery();
	        			AlertMessage alert = new AlertMessage();
	        			if (result.next()) {
	        				alert.errorMessage(email + " đã tồn tại");
	        			}else {
	        				signup_email.setText(email);
	        				
	        			}
					} catch (Exception e) {
						// TODO: handle exception
					}
	            });
	        } catch (IOException | GeneralSecurityException e) {
	            e.printStackTrace();
	        }
	    });
	}



	// TRANG LOGIN//
	// SỰ KIỆN KHI NHẤN NÚT LOGIN
	public void login(ActionEvent event) {
		AlertMessage alert = new AlertMessage();
		if (login_selectShowPassword.isSelected()) {
			login_password.setText(login_showPassword.getText());
		}

		if (login_uername.getText().isEmpty() || login_password.getText().isEmpty()) {
			alert.errorMessage("Lỗi chưa nhập đủ thông tin");
			return;
		}

		String selectData = "select * from accounts where username = ?";
		connect = DataBaseConnect.getConnection();

		try {
			prepare = connect.prepareStatement(selectData);
			prepare.setString(1, login_uername.getText());
			result = prepare.executeQuery();
			if (result.next()) {
				if(result.getBoolean("status")) {
					alert.errorMessage("Tài khoản đã đăng nhập ở đâu đó");
					return;
				}
				String storedHashedPassword = result.getString("password");

				// Kiểm tra mật khẩu nhập vào với mật khẩu đã mã hóa
				if (BCrypt.checkpw(login_password.getText(), storedHashedPassword)) {
					alert.successMessage("Đăng nhập thành công");
					String currentAccount = login_uername.getText();
					String sqlUpdate = "update accounts set status = 1 where username = ?";
					prepare = connect.prepareStatement(sqlUpdate);
					prepare.setString(1, currentAccount);
					int check = prepare.executeUpdate();
					if(check > 0) {
						System.out.println("Cập nhật trạng thái đăng nhập thành công cho user: "+ currentAccount);
					}else {
						System.out.println("Lỗi khi cập nhật trạng thái đăng nhập");
					}
					int capnhatSLKhachTruyCap = selectSLKhachHangTruyCap();
					System.out.println(capnhatSLKhachTruyCap);
					DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		            String nowTimestamp = LocalTime.now().format(timeFormatter);
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		            String formattedDate = LocalDate.now().format(formatter);
		            System.out.println(formattedDate);
		            try {
		                String sqlSelect = "SELECT * FROM thongke WHERE ngayThangNam = ?";
		                prepare = connect.prepareStatement(sqlSelect);
		                prepare.setString(1, formattedDate);
		                ResultSet rs = prepare.executeQuery();
		                if(rs.next()) {
		                	if(capnhatSLKhachTruyCap > rs.getInt("soLuongKhachTruyCap")) {
		                		String sqlUpdateThongKe = "UPDATE thongke SET soLuongKhachTruyCap = ?, khoangThoiGian = ? WHERE ngayThangNam = ?";
			                    prepare = connect.prepareStatement(sqlUpdateThongKe);
			                    prepare.setInt(1, capnhatSLKhachTruyCap);
			                    prepare.setString(2, nowTimestamp);
			                    prepare.setString(3, formattedDate);
			                    int rowcheck = prepare.executeUpdate();
			                    if(rowcheck > 0) {
//			                        alert.successMessage("Cập nhật số lượng khách truy cập thành công");
			                    } else {
			                        alert.errorMessage("Lỗi khi cập nhật!");
			                    }
		                	}
		                    
		                } else {
		                    String sqlInsert = "INSERT INTO thongke (soLuongKhachTruyCap, ngayThangNam,khoangThoiGian) VALUES (?, ?,?)";
		                    prepare = connect.prepareStatement(sqlInsert);
		                    prepare.setInt(1, 1);
		                    prepare.setString(2, formattedDate);
		                    prepare.setString(3, nowTimestamp);
		                    int rowcheck = prepare.executeUpdate();
		                    if(rowcheck > 0) {
//		                        alert.successMessage("Thêm số lượng khách truy cập thành công");
		                    } else {
		                        alert.errorMessage("Lỗi khi thêm!");
		                    }
		                }
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
					

					if (currentAccount.equals("admin")) {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("BackEnd.fxml"));
						Parent parent;
						try {
							parent = loader.load();

							Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
							Scene scene = new Scene(parent);
							stage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontEnd.fxml"));
						Parent parent;
						try {
							parent = loader.load();
							FrontEndController frontEndController = loader.getController();

							frontEndController.setFullname(result.getString("fullname"), currentAccount);

							Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
							Scene scene = new Scene(parent);
							stage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} else {
					alert.errorMessage("Sai mật khẩu!");
				}

			} else {
				alert.errorMessage("Tài khoản không tồn tại");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DataBaseConnect.closeConnection(connect);

	}
	private int selectSLKhachHangTruyCap() {
		int count = 0;
		String sql = "select * from accounts where status = 1 and username != ?";
//		connect = DataBaseConnect.getConnection();
		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, "admin");
			ResultSet rs = prepare.executeQuery();
			while(rs.next()) {
				count++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
//		DataBaseConnect.closeConnection(connect);
		return count; 
		
	}

	// SỰ KIỆN KHI NHẤN CHECKBOX HIỂN THỊ MẬT KHẨU
	public void showPassword() {

		if (login_selectShowPassword.isSelected()) {
			login_showPassword.setText(login_password.getText());
			login_showPassword.setVisible(true);
			login_password.setVisible(false);
		} else {
			login_password.setText(login_showPassword.getText());
			login_showPassword.setVisible(false);
			login_password.setVisible(true);
		}

	}

	// SỰ KIỆN KHI NHẤN HYPERLINK QUÊN MẬT KHẨU
	public void forgotPassword() {
		AlertMessage alert = new AlertMessage();

		if (forgot_email.getText().isEmpty() || forgot_OTPText.getText().isEmpty()) {
			alert.errorMessage("Vui lòng nhập đầy đủ thông tin");
			return;
		}
		String checkData = "select * from accounts where email = ?";
		connect = DataBaseConnect.getConnection();

		try {
			prepare = connect.prepareStatement(checkData);
			prepare.setString(1, forgot_email.getText());

			result = prepare.executeQuery();

			if (result.next()) {
				if(generatedOTP.equals(forgot_OTPText.getText())) {
					signup_form.setVisible(false);
					login_form.setVisible(false);
					forgot_form.setVisible(false);
					changePass_form.setVisible(true);
				}else {
					alert.errorMessage("OTP không đúng");
				}
				
			} else {
				alert.errorMessage("Email không đúng");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DataBaseConnect.closeConnection(connect);

	}

	// HẾT TRANG LOGIN//

	// PHẦN DÙNG CHUNG CHO VIỆC CHUYỂN ĐỔI CÁC SCENE
	public void switchForm(ActionEvent event) {
		// KHI NHẤN VÀO BUTTON CREATEACCOUNT TỪ TRANG ĐĂNG NHẬP
		if (event.getSource() == login_createAccount) {
			signup_form.setVisible(true);
			login_form.setVisible(false);
			forgot_form.setVisible(false);
			changePass_form.setVisible(false);
			// KHI NHẤN VÀO BUTTON LOGINACCOUNT TỪ TRANG ĐĂNG KÝ
			// HOẶC KHI NHẤN VÀO NÚT BACK TỪ TRANG FORGOTPASSWORD
		} else if (event.getSource() == signup_loginAccount || event.getSource() == forgot_bntBack) {
			signup_form.setVisible(false);
			login_form.setVisible(true);
			forgot_form.setVisible(false);
			changePass_form.setVisible(false);
			// KHI NHẤN VÀO HYPERLINK FORGOTPASSWORD TỪ TRANG ĐĂNG NHẬP
			// HOẶC KHI NHẤN VÀO NÚT BACK TỪ TRANG CHANGEPASSWORD
		} else if (event.getSource() == login_forgotPassword || event.getSource() == changePass_btnBack) {
			signup_form.setVisible(false);
			login_form.setVisible(false);
			forgot_form.setVisible(true);
			changePass_form.setVisible(false);
			// KHI NHẤN VÀO NÚT PROCEED TỪ TRANG FORGOTPASSWORD
		} else if (event.getSource() == forgot_bntProceed) {
			signup_form.setVisible(false);
			login_form.setVisible(false);
			forgot_form.setVisible(false);
			changePass_form.setVisible(true);
		}
	}

	// TRANG ĐĂNG KÝ//
	// SỰ KIỆN KHI NHẤN VÀO NÚT SIGN UP
	public boolean isValidEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public boolean isValidPassword(String password) {
		String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
		Pattern pattern = Pattern.compile(passwordRegex);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

	public void register() {
		AlertMessage alert = new AlertMessage();

		if (signup_email.getText().isEmpty() || signup_username.getText().isEmpty()
				|| signup_fullname.getText().isEmpty() || signup_password.getText().isEmpty()
				|| signup_confirmPassword.getText().isEmpty()) {
			alert.errorMessage("Không được bỏ trống thông tin");
			return;

		}
		if (!isValidEmail(signup_email.getText())) {
			alert.errorMessage("Email không đúng định dạng");
			return;
		}

		if (!isValidPassword(signup_password.getText())) {
			alert.errorMessage("Mật khẩu phải có ít nhất 8 ký tự, một chữ in hoa, một số và một ký tự đặc biệt");
			return;
		}
		if (!signup_password.getText().equals(signup_confirmPassword.getText())) {
			alert.errorMessage("Xác nhận mật khẩu không khớp");
			return;
		}
//		if(!signup_OTPText.getText().equals(generatedOTP)) {
//			alert.errorMessage("Xác thực OTP theo email "+ signup_email.getText()+ " không đúng");
//			return;
//		}

		String checkUsername = "select * from accounts where username = ?";
		connect = DataBaseConnect.getConnection();

		try {
			prepare = connect.prepareStatement(checkUsername);
			prepare.setString(1, signup_username.getText());
			result = prepare.executeQuery();

			if (result.next()) {
				alert.errorMessage(signup_username.getText() + "đã tồn tại");
				return;
			}
			String hashedPassword = BCrypt.hashpw(signup_password.getText(), BCrypt.gensalt());

			String insertData = "INSERT INTO accounts (email, fullname, username, password, date) VALUES (?, ?, ?, ?, ?)";
			prepare = connect.prepareStatement(insertData);
			prepare.setString(1, signup_email.getText());
			prepare.setString(2, signup_fullname.getText());
			prepare.setString(3, signup_username.getText());
			prepare.setString(4, hashedPassword); // Lưu mật khẩu đã mã hóa
			prepare.setDate(5, Date.valueOf(LocalDate.now()));

			prepare.executeUpdate();
			alert.successMessage("Đăng ký thành công");

			registerClearFeilds();
			// CHUYỂN ĐỔI SANG SCENE KHI ĐĂNG KÝ THÀNH CÔNG
			signup_form.setVisible(false);
			login_form.setVisible(true);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DataBaseConnect.closeConnection(connect);

	}

	// XÓA THÔNG TIN TRÊN CÁC FEILDS KHI ĐK THÀNH CÔNG
	public void registerClearFeilds() {
		signup_email.setText("");
		signup_fullname.setText("");
		signup_username.setText("");
		signup_password.setText("");
		signup_confirmPassword.setText("");
//		signup_OTPText.setText("");
	}


	// SK KHI NHẤN NÚT PROCEED XÁC NHẬN THÔNG TIN TÀI KHOẢN TRC KHI THAY ĐỔI MK
	public void changePassword() {
		AlertMessage alert = new AlertMessage();

		if (changePass_password.getText().isEmpty() || changePass_confirmPassword.getText().isEmpty()) {
			alert.errorMessage("Vui lòng nhập đầy đủ thông tin");
			return;

		}
		if (!changePass_password.getText().equals(changePass_confirmPassword.getText())) {
			alert.errorMessage("Xác nhận mật khẩu không khớp");
			return;

		}
		if (!isValidPassword(changePass_password.getText())) {
			alert.errorMessage("Mật khẩu chưa đủ mạnh");
			return;

		}
		String newHashedPassword = BCrypt.hashpw(changePass_password.getText(), BCrypt.gensalt());
		String updateData = "UPDATE accounts SET password = ?, update_date = ? WHERE email = ?";
		connect = DataBaseConnect.getConnection();
		try {
			prepare = connect.prepareStatement(updateData);
			prepare = connect.prepareStatement(updateData);
			prepare.setString(1, newHashedPassword);
			prepare.setDate(2, Date.valueOf(LocalDate.now()));
			prepare.setString(3, forgot_email.getText());
			prepare.executeUpdate();
			alert.successMessage("Đổi mật khẩu thành công");
			refreshForgot();
			signup_form.setVisible(false);
			login_form.setVisible(true);
			forgot_form.setVisible(false);
			changePass_form.setVisible(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DataBaseConnect.closeConnection(connect);
		
	}
	
	public void refreshForgot() {
		forgot_email.setText("");
		forgot_OTPText.setText("");
		getOTPHyperLink1.setDisable(false);
        signup_countDownText1.setText("0");
        signup_hBoxCountdown1.setVisible(false);
	}
	
	public void GetOTP_Forgot() throws MessagingException {
		String email = forgot_email.getText();
		
		AlertMessage alert = new AlertMessage();
        if (!isValidEmail(email)) {
            alert.errorMessage("Lỗi, Vui lòng nhập email hợp lệ!");
            return;
        }
        connect = DataBaseConnect.getConnection();
        String sql = "select * from accounts where email = ?";
        
        try {
        	prepare = connect.prepareStatement(sql);
			prepare.setString(1, forgot_email.getText());
			result = prepare.executeQuery();
			
			if(result.next()) {
				generatedOTP = "";
		        generatedOTP = generateOTP();
		        Boolean check = EmailSender.sendOTPEmail(email, generatedOTP);
		        if(check) {
		        	alert.successMessage("Thành công, Mã OTP đã được gửi, vào email của bạn để lấy mã OTP");
		        }else {
		        	alert.successMessage("Email này không tồn tại!!!");
		        	return;
		        }
				signup_hBoxCountdown1.setVisible(true);
				getOTPHyperLink1.setDisable(true);
       // Khởi tạo đếm ngược từ 60
				IntegerProperty timeSeconds = new SimpleIntegerProperty(60);
				// Gán giá trị ban đầu cho text hiển thị countdown
				signup_countDownText1.setText(String.valueOf(timeSeconds.get()));

				// Tạo Timeline để cập nhật mỗi giây
				Timeline timeline = new Timeline();
				timeline.setCycleCount(Timeline.INDEFINITE);
				timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
				    timeSeconds.set(timeSeconds.get() - 1);
				    signup_countDownText1.setText(String.valueOf(timeSeconds.get()));
				    if (timeSeconds.get() <= 0) {
				        timeline.stop();
				        getOTPHyperLink1.setDisable(false);
				        signup_countDownText1.setText("0");
				        signup_hBoxCountdown1.setVisible(false);
				        generatedOTP = "ghdfhj";
				    }
				}));
				timeline.play();
			}else {
				alert.errorMessage("Lỗi, Email này không có tài khoản sử dụng!");
	            
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        DataBaseConnect.closeConnection(connect);
        
	}
	
	public void GetOTP_SignUp() throws MessagingException {
		String email = signup_email.getText();
		
		AlertMessage alert = new AlertMessage();
        if (!isValidEmail(email)) {
            alert.errorMessage("Lỗi, Vui lòng nhập email hợp lệ!");
            return;
        }
        connect = DataBaseConnect.getConnection();
        String sql = "select * from accounts where email = ?";
        
        try {
        	prepare = connect.prepareStatement(sql);
			prepare.setString(1, signup_email.getText());
			result = prepare.executeQuery();
			
			if(result.next()) {
				alert.errorMessage("Lỗi, Email này đã có tài khoản sử dụng!");
				DataBaseConnect.closeConnection(connect);
	            return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        generatedOTP = "";
        generatedOTP = generateOTP();
        Boolean check = EmailSender.sendOTPEmail(email, generatedOTP);
        if(check) {
        	alert.successMessage("Thành công, Mã OTP đã được gửi, vào email của bạn để lấy mã OTP");
        }else {
        	alert.successMessage("Email này không tồn tại!!!");
        	return;
        }
		
		
		signup_hBoxCountdown.setVisible(true);
		getOTPHyperlink.setDisable(true);
       // Khởi tạo đếm ngược từ 60
		IntegerProperty timeSeconds = new SimpleIntegerProperty(60);
		// Gán giá trị ban đầu cho text hiển thị countdown
		signup_countDownText.setText(String.valueOf(timeSeconds.get()));

		// Tạo Timeline để cập nhật mỗi giây
		Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
		    timeSeconds.set(timeSeconds.get() - 1);
		    signup_countDownText.setText(String.valueOf(timeSeconds.get()));
		    if (timeSeconds.get() <= 0) {
		        timeline.stop();
		        getOTPHyperlink.setDisable(false);
		        signup_countDownText.setText("0");
		        signup_hBoxCountdown.setVisible(false);
		        generatedOTP = "ghdfhj";
		    }
		}));
		timeline.play();
	}
	
	// Tạo mã OTP ngẫu nhiên
    private String generateOTP() {
        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }
}
