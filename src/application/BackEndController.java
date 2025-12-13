package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;
//import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.UnaryOperator;

import javax.swing.SwingUtilities;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

public class BackEndController implements Initializable {

	@FXML
	private Label SLKhachHangText;

	@FXML
	private Label SLSanPhamText;

	@FXML
	private TableColumn<Book, String> authorColumn;

	@FXML
	private TextField authorText;

	@FXML
	private TextField authorText1;

	@FXML
	private Button btnCapNhat;

	@FXML
	private Button btnHoTro;

	@FXML
	private Button btnHuy;

	@FXML
	private Button btnInforAdmin;

	@FXML
	private Button btnLogout;

	@FXML
	private Button btnSua;

	@FXML
	private Button btnThem;

	@FXML
	private Button btnThongKe;

	@FXML
	private Button btnTongQuan;

	@FXML
	private Button btnXoa;

	@FXML
	private AnchorPane capNhatForm;

	@FXML
	private Button chooseImageImport;

	@FXML
	private TableColumn<Book, String> desColumn;

	@FXML
	private TextArea desText;

	@FXML
	private TextArea desText1;

	@FXML
	private LineChart<String, Number> doanhThuLineChart;

	@FXML
	private TableColumn<Book, String> genreColumn;

	@FXML
	private TextField genreText;
	
	@FXML
	private TextField numberChapterText;
	
	@FXML
	private TextField titleText;

	@FXML
	private TextField genreText1;

	@FXML
	private AnchorPane hoTroForm;
	
	@FXML
	private AnchorPane chiTietLichSuForm;
	
	@FXML
	private BorderPane borderpaneMain;

	@FXML
	private TableColumn<Book, String> idColumn;

	@FXML
	private TextField idText;

	@FXML
	private TextField idText1;

	@FXML
	private TableColumn<Book, ImageView> imageColum;

	@FXML
	private ImageView imageText;

	@FXML
	private ImageView imageText1;

	@FXML
	private ToggleButton TgBtn_False;

	@FXML
	private ToggleButton TgBtn_False1;

	@FXML
	private ToggleButton TgBtn_True;

	@FXML
	private ToggleButton TgBtn_True1;

	@FXML
	private StackedBarChart<String, Number> khachHangStackBarChart;

	@FXML
	private Label logoText;
	
	@FXML
	private Label sumBook;
	
	@FXML
	private Label tongDonHangTheoNgay;

	@FXML
	private FontAwesomeIconView logout;

	@FXML
	private TableColumn<Book, String> nameColumn;

	@FXML
	private TextField nameText;

	@FXML
	private TextField nameText1;

	@FXML
	private TableColumn<Book, Double> priceColumn;

	@FXML
	private TextField priceText;

	@FXML
	private TextField priceText1;
	
    @FXML
    private TextArea linkText;

    @FXML
    private TextArea linkText1;

	@FXML
	private TextField stockText;

	@FXML
	private TextField stockText1;

	@FXML
	private TableColumn<Book, Integer> pub_yearColumn;

	@FXML
	private TableColumn<Book, Integer> stockColumn;

	@FXML
	private TextField pub_yearText;

	@FXML
	private TextField pub_yearText1;

	@FXML
	private TableColumn<Book, Boolean> statusColumn;

	@FXML
	private TableColumn<Book, Void> updateColumn;
	
    @FXML
    private TableColumn<Book, String> contentColumn;

    @FXML
    private TextArea contentText1;

    @FXML
    private TextArea contentText;

	@FXML
	private TableView<Book> table;

	@FXML
	private AnchorPane thongKeForm;

	@FXML
	private AnchorPane tongQuanForm;

	@FXML
	private Label tongThuNhapNgayText;
	
	@FXML
	private Label khoangThoiGian;

	@FXML
	private Label tongThuNhapThang;
	
	@FXML
	private Label currentYearThongKe;
	
	@FXML
	private Label timeCurrentDay;
	
	@FXML
	private Label tongSoKhachHang;

	@FXML
	private AnchorPane formInsertBook;

	@FXML
	private AnchorPane formUpdate;

	@FXML
	private AnchorPane AnchorPaneTableView;
	
	@FXML
	private AnchorPane anchorpaneFlowPaneCapNhat;

	@FXML
	private TextField textSearch;

	@FXML
	private Button btnHuySearh;
	
	@FXML
	private Button btnXemChiTiet;

	@FXML
	private TextField statusText;

	@FXML
	private TextField statusText1;

	@FXML
	private ListView<String> chatUserListView;
	
	@FXML
	private ListView<String> chatUserListView1;
	@FXML
	private Label currentChatUserLabel;
	@FXML
	private TextArea chatArea;
	@FXML
	private TextArea chatInputField;
	@FXML
	private Button sendChatButton;
	
	@FXML
	private Button btnThemChuongMoi;
	
	@FXML
	private Button btnBackTongQuan;
	
	@FXML
	private Button btnCapNhatChuong;

	@FXML
	private VBox chatBox;
	
	@FXML
	private HBox hboxCapNhatChuong;
	
	@FXML
	private VBox chatForm;

	private ChatService chatService;
	
    @FXML
    private ScrollPane scrollpaneChat;
    
    @FXML
    private FlowPane flowpaneCapNhat;
    
    @FXML
    private FlowPane flowpaneThem;
    
    @FXML
    private AnchorPane anchorpaneFlowPaneThem;
    

	private Connection connect;
	private PreparedStatement prepare;
	private ResultSet result;
	String imageTextPath = "";

	ObservableList<Book> bookList = FXCollections.observableArrayList();

	private Map<String, StringBuilder> chatHistories = new HashMap<>();
	
	private Timer timer;
	
	DecimalFormat df = new DecimalFormat("#,###");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		renderBook();
		table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				updateFormFields(newSelection);
				btnThemChuongMoi.setDisable(false);
				btnCapNhatChuong.setDisable(false);
				btnHuySearh.setDisable(false);
			}else {
				btnThemChuongMoi.setDisable(true);
				btnCapNhatChuong.setDisable(true);
				btnHuySearh.setDisable(true);
			}
		});
		
		setToolipForChapterButton();
		
		refresh();
		onlyNumbers(priceText);
		onlyNumbers(priceText1);
		onlyNumbers(stockText);
		onlyNumbers(stockText1);
		onlyNumbers(pub_yearText);
		onlyNumbers(pub_yearText1);

		getListView();
		getListViewChiTietLichSu();
		Platform.runLater(() -> {
			try {
				chatService = new ChatService();
				chatService.setupAdminQueue((consumerTag, delivery) -> {
				    String message = new String(delivery.getBody(), "UTF-8");
				    Object headerObj = delivery.getProperties().getHeaders().get("userId");
				    String senderUserId = (headerObj != null) ? headerObj.toString() : "unknown";
				    System.out.println(senderUserId);
				    Platform.runLater(() -> {
				        if (chatUserListView == null) return;

				        chatHistories.putIfAbsent(senderUserId, new StringBuilder());
				        chatHistories.get(senderUserId).append(message + "\n");
				        if(!currentChatUserLabel.getText().equals("")) {
				        	if (senderUserId.equals(currentChatUserLabel.getText().substring(0,currentChatUserLabel.getText().indexOf(" ")))) {
					            addMessageToChatBox(senderUserId, message);
					            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), ae -> scrollpaneChat.setVvalue(1.0)));
							    timeline.play();
					        }
				        }else {
				        	for (int i = 0; i < chatUserListView.getItems().size(); i++) {
				                String item = chatUserListView.getItems().get(i).substring(0,chatUserListView.getItems().get(i).indexOf(" "));
				                if (item.equals(senderUserId)) {
				                	if(chatUserListView.getItems().get(i).contains("*")) break;
				                    chatUserListView.getItems().set(i, chatUserListView.getItems().get(i) + " *");
				                    break;
				                }
				            }
				        }
				        
				    });
				});

				Stage stage = (Stage) SLKhachHangText.getScene().getWindow();
				stage.setOnCloseRequest(event -> {
					try {
						connect = DataBaseConnect.getConnection();
						String sqlUpdate = "update accounts set status = 0 where username = ?";
						prepare = connect.prepareStatement(sqlUpdate);
						prepare.setString(1, "admin");
						int check = prepare.executeUpdate();
						if(check > 0) {
							System.out.println("Cập nhật trạng thái xuất thành công cho user: admin");
						}else {
							System.out.println("Lỗi khi cập nhật trạng thái đăng nhập");
						}
						DataBaseConnect.closeConnection(connect);
					
						chatService.closeConsumer("chat_admin"); // Hủy consumer
						chatService.deleteQueue("chat_admin"); // Xóa queue
						System.out.println("Queue của admin đã được xóa khi đóng scene.");
					} catch (Exception e) {
						e.printStackTrace();
					}
				});

				if (chatUserListView != null) {
					chatUserListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
						if (newVal != null) {
							
							String cleanUser = newVal.replace(" *", "");
							currentChatUserLabel.setText(cleanUser);
							chatUserListView.setVisible(false);
							chatForm.setVisible(true);
							chatBox.getChildren().clear();
							loadChatHistoryForUser(cleanUser);
							Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), ae -> scrollpaneChat.setVvalue(1.0)));
				            timeline.play();
							for (int i = 0; i < chatUserListView.getItems().size(); i++) {
								String item = chatUserListView.getItems().get(i);
								if (item.equals(newVal)) {
									chatUserListView.getItems().set(i, cleanUser);
									break;
								}
							}
						}
					});
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		MessageCleaner cleaner = new MessageCleaner();
		cleaner.startCleaning();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		timeCurrentDay.setText(LocalDate.now().format(formatter));
		currentYearThongKe.setText(LocalDate.now().format(formatter));
		
		chatUserListView1.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
		    if (newVal != null) {
		        // Tách username từ item chọn (do item có dạng "username (fullname)")
		        String selectedUser = newVal.split(" ")[0];
		        System.out.println(selectedUser);

		        String timeCurrentDay1 = timeCurrentDay.getText();
		        System.out.println(timeCurrentDay1);

		        // Hiển thị lịch sử đơn hàng trong ListView (ShowAndWait)
		        showLichSuDonHangDialog(selectedUser, timeCurrentDay1);
		    }
		});
		
//		setThongKe();
		getThongKe();
		refreshThongKe();
		capNhatGiaoDienTrangCapNhat();
		setBtgButton();
		getTongSoKhachHang();
		getTongDonHangNgay();
	}
	
	private void showLichSuDonHangDialog(String username, String timeCurrentDay) {
		// Chuyển từ dd/MM/yyyy -> yyyy-MM-dd
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate localDate = LocalDate.parse(timeCurrentDay, inputFormatter);
        String formattedDate = localDate.format(outputFormatter);
        
        // Chuyển thành java.sql.Date
        java.sql.Date sqlDate = java.sql.Date.valueOf(formattedDate);

	    // Truy vấn danh sách đơn hàng
	    ObservableList<String> donHangList = FXCollections.observableArrayList();
	    String sql = "SELECT * " +
	                 "FROM donhang " +
	                 "WHERE nguoiMua = ? AND DATE(thoigiandathang) = ?";

	    connect = DataBaseConnect.getConnection();
	    try {
	        prepare = connect.prepareStatement(sql);
	        prepare.setString(1, username);
	        prepare.setDate(2, sqlDate);

	        result = prepare.executeQuery();
	        while (result.next()) {
	            System.out.println("check");
	            int id = result.getInt("Id");
	            double tongTien = result.getDouble("tongtienhang");
	            double phivanchuyen = result.getDouble("phivanchuyen");
	            double voucher = result.getDouble("voucher");
	            double thanhTien = result.getDouble("thanhtien");
	            String hinhThucTT = result.getString("hinhthucthanhtoan");
	            
	            // Lấy thời gian đặt hàng
	            Timestamp thoiGianDatHang = result.getTimestamp("thoigiandathang");
	            String formattedTime = new SimpleDateFormat("HH:mm:ss").format(thoiGianDatHang);

	            // Hiển thị thêm thời gian đặt hàng
	            String donHangInfo = "ID: " + id + " | " +
	                                 "Tổng: " + tongTien + " | " +
	                                 "Phí VC: " + phivanchuyen + " | " +
	                                 "Voucher: " + voucher + " | " +
	                                 "Thành tiền: " + thanhTien + " | " +
	                                 "TT: " + hinhThucTT + " | " +
	                                 "Giờ đặt: " + formattedTime;
	            
	            donHangList.add(donHangInfo);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DataBaseConnect.closeConnection(connect);
	    }

	    // Tạo ListView
	    ListView<String> listView = new ListView<>(donHangList);
	    listView.setPrefSize(700, 400);

	    // Hiển thị trong Dialog
	    Dialog<ButtonType> dialog = new Dialog<>();
	    dialog.setTitle("Lịch sử đơn hàng - " + username);
	    dialog.setHeaderText("Danh sách đơn hàng ngày: " + timeCurrentDay);
	    dialog.getDialogPane().setContent(listView);
	    dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
	    
	    dialog.setOnHidden(event -> {
	    	Platform.runLater(() -> {
	    	    if (!chatUserListView1.getItems().isEmpty()) {
	    	        chatUserListView1.getSelectionModel().clearSelection();
	    	    }
	    	});

	    });
	    
	 // Thêm xử lý sự kiện khi chọn đơn hàng
	    listView.setOnMouseClicked(event -> {
	        String selectedItem = listView.getSelectionModel().getSelectedItem();
	        if (selectedItem != null) {
	            // Trích xuất ID từ chuỗi (giả sử ID là số đầu tiên trong chuỗi)
	            int id  = Integer.parseInt(selectedItem.split(" ")[1]);
	            showChiTietDonHangDialog(id);
	            listView.getSelectionModel().clearSelection();
	        }
	    });


	    
	    dialog.showAndWait();
	}
	
	private void showChiTietDonHangDialog(int orderId) {
	    ObservableList<String> chiTietDonHangList = FXCollections.observableArrayList();
	    
	    String sql = "SELECT * " +
	                 "FROM chitietdonhang " +
	                 "WHERE giohangid = ?";
	    
	    Connection connect = DataBaseConnect.getConnection();
	    try {
	        PreparedStatement prepare = connect.prepareStatement(sql);
	        prepare.setInt(1, orderId);
	        
	        ResultSet result = prepare.executeQuery();
	        while (result.next()) {
	            String tenSanPham = result.getString("SanPham");
	            int soLuong = result.getInt("soLuong");
	            double giaBan = result.getDouble("gia");
	            String loaisach = result.getString("loaisach");
	            
	            String chiTiet = "Sản phẩm: " + tenSanPham + " | Số lượng: " + soLuong + " | Giá: " + giaBan + " | Loại sách: " + loaisach;
	            chiTietDonHangList.add(chiTiet);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DataBaseConnect.closeConnection(connect);
	    }

	    // Tạo ListView để hiển thị chi tiết đơn hàng
	    ListView<String> listView = new ListView<>(chiTietDonHangList);
	    listView.setPrefSize(500, 400);

	    // Hiển thị trong Dialog
	    Dialog<ButtonType> dialog = new Dialog<>();
	    dialog.setTitle("Chi tiết đơn hàng - ID: " + orderId);
	    dialog.setHeaderText("Danh sách sản phẩm trong đơn hàng");
	    dialog.getDialogPane().setContent(listView);
	    dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
	    
	    
	    dialog.showAndWait();
	}



	
	private void getTongDonHangNgay() {
		connect = DataBaseConnect.getConnection();
		String sql = "SELECT COUNT(*) AS tongDonHang FROM donhang WHERE DATE(thoigiandathang) = ?";
		try {
			prepare = connect.prepareStatement(sql);
			LocalDate localDate = LocalDate.now();
	        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
	        prepare.setDate(1, sqlDate);
	        result = prepare.executeQuery();
	        if (result.next()) {
	            int tongDonHang = result.getInt("tongDonHang");
	            System.out.println("Tổng số đơn hàng hôm nay: " + tongDonHang);
	            tongDonHangTheoNgay.setText(String.valueOf(tongDonHang));
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataBaseConnect.closeConnection(connect);
		
	}
	
	private void getTongDonHangNgay(String date) {
	    connect = DataBaseConnect.getConnection();
	    String sql = "SELECT COUNT(*) AS tongDonHang FROM donhang WHERE DATE(thoigiandathang) = ?";
	    
	    try {
	        prepare = connect.prepareStatement(sql);
	        
	        // Chuyển từ dd/MM/yyyy -> yyyy-MM-dd
	        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	        LocalDate localDate = LocalDate.parse(date, inputFormatter);
	        String formattedDate = localDate.format(outputFormatter);
	        
	        // Chuyển thành java.sql.Date
	        java.sql.Date sqlDate = java.sql.Date.valueOf(formattedDate);
	        prepare.setDate(1, sqlDate);
	        
	        result = prepare.executeQuery();
	        if (result.next()) {
	            int tongDonHang = result.getInt("tongDonHang");
	            System.out.println("Tổng số đơn hàng ngày " + date + ": " + tongDonHang);
	            tongDonHangTheoNgay.setText(String.valueOf(tongDonHang));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (DateTimeParseException e) {
	        System.out.println("Lỗi: Định dạng ngày không hợp lệ! Cần nhập theo định dạng dd/MM/yyyy.");
	    } finally {
	        DataBaseConnect.closeConnection(connect);
	    }
	}
	
	private void getTongSoKhachHang() {
		String sql = "Select * from accounts where username != ?";
		connect = DataBaseConnect.getConnection();
		int count = 0;
		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, "admin");
			result = prepare.executeQuery();
			while(result.next()) {
				count++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		DataBaseConnect.closeConnection(connect);
		tongSoKhachHang.setText(String.valueOf(count));
	}
	
	public void setBtgButton() {
		TgBtn_True.setOnAction(event -> {
		    if (TgBtn_True.isSelected()) {
		        TgBtn_True.setMouseTransparent(true);
		        TgBtn_False.setMouseTransparent(false);
		    }
		});
		TgBtn_True1.setOnAction(event -> {
		    if (TgBtn_True1.isSelected()) {
		        TgBtn_True1.setMouseTransparent(true);
		        TgBtn_False1.setMouseTransparent(false);
		    }
		});
		TgBtn_False.setOnAction(event -> {
		    if (TgBtn_False.isSelected()) {
		    	TgBtn_False.setMouseTransparent(true);
		    	TgBtn_True.setMouseTransparent(false);
		    }
		});
		TgBtn_False1.setOnAction(event -> {
		    if (TgBtn_False1.isSelected()) {
		    	TgBtn_False1.setMouseTransparent(true);
		    	TgBtn_True1.setMouseTransparent(false);
		    }
		});
	}
	public void refeshTongQuan(ActionEvent event) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = LocalDate.now().format(formatter);
        timeCurrentDay.setText(formattedDate);
        getThongKe();
        getTongDonHangNgay();
        getTongSoKhachHang();
        getListViewChiTietLichSu();
//        setThongKe();
		
	}
	
	private void getThongKe(String date) {
		
		String month = date.split("/")[1]+"/"+date.split("/")[2];
		System.out.println(month);
		connect = DataBaseConnect.getConnection();
		String sql = "select * from thongke where ngayThangNam = ?";
		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, date);
			result = prepare.executeQuery();
			if(result.next()) {
				SLSanPhamText.setText(String.valueOf(result.getInt("soLuongSachDuocBan")));
				tongThuNhapNgayText.setText(df.format(result.getDouble("doanhThu")));
	            khoangThoiGian.setText(result.getString("khoangThoiGian"));
				SLKhachHangText.setText(result.getString("soLuongKhachTruyCap"));
			}else {
				SLSanPhamText.setText("0");
				tongThuNhapNgayText.setText("0");
				khoangThoiGian.setText("");
				SLKhachHangText.setText("0");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		String sqlSekect = "select * from thongke where ngayThangNam like ?";
		try {
			prepare = connect.prepareStatement(sqlSekect);
			prepare.setString(1, "%"+ month+ "%");
			result = prepare.executeQuery();
			double sum = 0.0;
			while(result.next()) {
				sum+=result.getDouble("doanhThu");
			}
			tongThuNhapThang.setText(df.format(sum));
		} catch (Exception e) {
			// TODO: handle exception
		}
		DataBaseConnect.closeConnection(connect);
	}
	
	private void getThongKe() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String time = LocalDate.now().format(formatter);
		String month = time.split("/")[1]+"/"+time.split("/")[2];
//		System.out.println(month);
		connect = DataBaseConnect.getConnection();
		String sql = "select * from thongke where ngayThangNam = ?";
		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, time);
			result = prepare.executeQuery();
			if(result.next()) {
				SLSanPhamText.setText(String.valueOf(result.getInt("soLuongSachDuocBan")));
				tongThuNhapNgayText.setText(df.format(result.getDouble("doanhThu")));
	            khoangThoiGian.setText(result.getString("khoangThoiGian"));
				SLKhachHangText.setText(result.getString("soLuongKhachTruyCap"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		String sqlSekect = "select * from thongke where ngayThangNam like ?";
		try {
			prepare = connect.prepareStatement(sqlSekect);
			prepare.setString(1, "%"+ month+ "%");
			result = prepare.executeQuery();
			double sum = 0.0;
			while(result.next()) {
				sum+=result.getDouble("doanhThu");
			}
			tongThuNhapThang.setText(df.format(sum));
		} catch (Exception e) {
			// TODO: handle exception
		}
		DataBaseConnect.closeConnection(connect);
	}
	
	public void SelectTongThuNhapThang(ActionEvent event) {
		Pair<String, Void> selectedDate = DatePickerDialog.showDatePicker(timeCurrentDay.getText());

		if (selectedDate != null) {
		    String date = selectedDate.getKey();
		    System.out.println(date);
		    if(!date.equals(timeCurrentDay.getText())) {
		    	timeCurrentDay.setText(date);
		    	getThongKe(date);
		    	getTongDonHangNgay(date);
		    	getListViewChiTietLichSu();
		    }
		}
	}
	
	
	
	
	private List<Pair<String, Double>> getDoanhThuTheoThang(String nam) {
	    List<Pair<String, Double>> data = new ArrayList<>();
	    String sql = "SELECT SUBSTRING(ngayThangNam, 4, 7) AS thangNam, SUM(doanhThu) AS tongDoanhThu " +
	                 "FROM thongke " +
	                 "WHERE SUBSTRING(ngayThangNam, 7, 4) = ? " +  // Lọc theo năm
	                 "GROUP BY SUBSTRING(ngayThangNam, 4, 7) " +
	                 "ORDER BY thangNam";
	    connect = DataBaseConnect.getConnection();
	    try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, nam);
			result = prepare.executeQuery();
			while (result.next()) {
                String thang = result.getString("thangNam").split("/")[0];
                double tongDoanhThu = result.getDouble("tongDoanhThu");
                data.add(new Pair<>(thang, tongDoanhThu));
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    DataBaseConnect.closeConnection(connect);
	    return data;
	}
	
	public void loadThongKe(ActionEvent event) {
		Pair<String, Void> selectedDate = DatePickerDialog.showDatePicker(currentYearThongKe.getText());

		if (selectedDate != null) {
		    String date = selectedDate.getKey();
		    System.out.println(date);
		    String month = date.split("/")[1]+"/"+date.split("/")[2];
		    String year = date.split("/")[2];
		    if(!date.equals(currentYearThongKe.getText())) {
		    	currentYearThongKe.setText(date);
		    	
		    	String query = "SELECT * FROM thongke where ngayThangNam like ?";
			    connect = DataBaseConnect.getConnection();
			    try {
					prepare = connect.prepareStatement(query);
					prepare.setString(1, "%"+month+"%");
					result = prepare.executeQuery();
					XYChart.Series<String, Number> series1 = new XYChart.Series<>();
			        series1.setName("Số lượng khách truy cập");
			        
			        while (result.next()) {
			        	String date1 = result.getString("ngayThangNam");
			            String ngay = date1.split("/")[0]+"\n"+result.getString("khoangThoiGian");
			            int soLuongKhach = result.getInt("soLuongKhachTruyCap");
			            
			            series1.getData().add(new XYChart.Data<>(ngay, soLuongKhach));
			        }

			        khachHangStackBarChart.getData().clear();
			        khachHangStackBarChart.getData().add(series1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
			    List<Pair<String, Double>> data = getDoanhThuTheoThang(year);
			    
			    String seriesName = "Doanh thu " + year;

		        // Kiểm tra xem series có tồn tại hay không
		        for (XYChart.Series<String, Number> existingSeries : doanhThuLineChart.getData()) {
		            if (existingSeries.getName().equals(seriesName)) {
		                System.out.println("Dữ liệu năm " + year + " đã tồn tại.");
		                return; // Không thêm nếu đã có
		            }
		        }
				XYChart.Series<String, Number> series = new XYChart.Series<>();
		        series.setName("Doanh thu " + year);
			    

//			    XYChart.Series<String, Number> series = new XYChart.Series<>();
//			    series.setName("Doanh thu theo tháng");

			    for (Pair<String, Double> entry : data) {
			        series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
			    }

			    doanhThuLineChart.getData().clear(); 
			    doanhThuLineChart.getData().add(series);
			    
			    
			    DataBaseConnect.closeConnection(connect);
		    }
		}
		
	}
	
	public void refreshThongKe() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String time = LocalDate.now().format(formatter);
		currentYearThongKe.setText(LocalDate.now().format(formatter));
		String month = time.split("/")[1]+"/"+time.split("/")[2];
		String query = "SELECT * FROM thongke where ngayThangNam like ?";
	    connect = DataBaseConnect.getConnection();
	    try {
			prepare = connect.prepareStatement(query);
			prepare.setString(1, "%"+month+"%");
			result = prepare.executeQuery();
			XYChart.Series<String, Number> series = new XYChart.Series<>();
	        series.setName("Số lượng khách truy cập");
	        
	        while (result.next()) {
	        	String date = result.getString("ngayThangNam");
	            String ngay = date.split("/")[0]+"\n"+result.getString("khoangThoiGian");
	            int soLuongKhach = result.getInt("soLuongKhachTruyCap");
	            
	            series.getData().add(new XYChart.Data<>(ngay, soLuongKhach));
	        }

	        khachHangStackBarChart.getData().clear();
	        khachHangStackBarChart.getData().add(series);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    DataBaseConnect.closeConnection(connect);
		
		String year = time.split("/")[2];
	    List<Pair<String, Double>> data = getDoanhThuTheoThang(year);

	    XYChart.Series<String, Number> series = new XYChart.Series<>();
	    series.setName("Doanh thu "+ year);

	    for (Pair<String, Double> entry : data) {
	        series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
	    }

	    doanhThuLineChart.getData().clear(); // Xóa dữ liệu cũ
	    doanhThuLineChart.getData().add(series); // Thêm dữ liệu mới
	}
	
	public void addYearLineChart() {
		Pair<String, Void> selectedDate = YearPickerDialog.showYearPicker();
		if (selectedDate != null) {
			String year = selectedDate.getKey();
			System.out.println(year);
			String seriesName = "Doanh thu " + year;

	        // Kiểm tra xem series có tồn tại hay không
	        for (XYChart.Series<String, Number> existingSeries : doanhThuLineChart.getData()) {
	            if (existingSeries.getName().equals(seriesName)) {
	                System.out.println("Dữ liệu năm " + year + " đã tồn tại.");
	                return; // Không thêm nếu đã có
	            }
	        }
			XYChart.Series<String, Number> series = new XYChart.Series<>();
	        series.setName("Doanh thu " + year);

	        // Gọi phương thức lấy dữ liệu từ BackEndController
	        List<Pair<String, Double>> revenueData = getDoanhThuTheoThang(year);
	        
	        for (Pair<String, Double> data : revenueData) {
	            series.getData().add(new XYChart.Data<>(data.getKey(), data.getValue()));
	        }

	        doanhThuLineChart.getData().add(series);
		}
	}

	public void switchForm(ActionEvent event) {
		// KHI NHẤN VÀO BUTTON TRANGCHU
		if (event.getSource() == btnCapNhat) {
			btnTongQuan.setStyle("-fx-background-color: #fff;");
			btnThongKe.setStyle("-fx-background-color: #fff;");
			btnCapNhat.setStyle("-fx-background-color: #f3f3f3;");
			btnHoTro.setStyle("-fx-background-color: #fff;");
			tongQuanForm.setVisible(false);
			thongKeForm.setVisible(false);
			capNhatForm.setVisible(true);
			hoTroForm.setVisible(false);
			chiTietLichSuForm.setVisible(false);
		}
		// KHI NHẤN VÀO BUTTON GIOHANG
		else if (event.getSource() == btnThongKe) {
			btnTongQuan.setStyle("-fx-background-color: #fff;");
			btnThongKe.setStyle("-fx-background-color: #f3f3f3;");
			btnCapNhat.setStyle("-fx-background-color: #fff;");
			btnHoTro.setStyle("-fx-background-color: #fff;");
			tongQuanForm.setVisible(false);
			thongKeForm.setVisible(true);
			capNhatForm.setVisible(false);
			hoTroForm.setVisible(false);
			chiTietLichSuForm.setVisible(false);
			refreshThongKe();
		}
		// KHI NHẤN VÀO BUTTON THUVIEN
		else if (event.getSource() == btnTongQuan) {
			btnTongQuan.setStyle("-fx-background-color: #f3f3f3;");
			btnThongKe.setStyle("-fx-background-color: #fff;");
			btnCapNhat.setStyle("-fx-background-color: #fff;");
			btnHoTro.setStyle("-fx-background-color: #fff;");
			tongQuanForm.setVisible(true);
			thongKeForm.setVisible(false);
			capNhatForm.setVisible(false);
			hoTroForm.setVisible(false);
			chiTietLichSuForm.setVisible(false);
			refeshTongQuan(event);
			getTongSoKhachHang();

		}
		// KHI NHẤN VÀO BUTTON NHANTIN
		else if (event.getSource() == btnHoTro) {
			btnTongQuan.setStyle("-fx-background-color: #fff;");
			btnThongKe.setStyle("-fx-background-color: #fff;");
			btnCapNhat.setStyle("-fx-background-color: #fff;");
			btnHoTro.setStyle("-fx-background-color: #f3f3f3;");
			tongQuanForm.setVisible(false);
			thongKeForm.setVisible(false);
			capNhatForm.setVisible(false);
			chiTietLichSuForm.setVisible(false);
			hoTroForm.setVisible(true);
		}else if(event.getSource() ==  btnXemChiTiet) {
			tongQuanForm.setVisible(false);
			thongKeForm.setVisible(false);
			capNhatForm.setVisible(false);
			chiTietLichSuForm.setVisible(true);
			hoTroForm.setVisible(false);
		}else if(event.getSource() == btnBackTongQuan) {
			tongQuanForm.setVisible(true);
			thongKeForm.setVisible(false);
			capNhatForm.setVisible(false);
			chiTietLichSuForm.setVisible(false);
			hoTroForm.setVisible(false);
			
		}
	}

	public void changeChat(ActionEvent event) {
		chatUserListView.setVisible(true);
		chatForm.setVisible(false);
		chatUserListView.getSelectionModel().clearSelection();
		currentChatUserLabel.setText("");
		chatBox.getChildren().clear();

	}
	
	private void addMessageToChatBox(String sender, String message) {
		String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
		String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Label messageLabel = new Label(message);
		messageLabel.setMaxWidth(300);
	    messageLabel.setWrapText(true);
	    messageLabel.setPadding(new Insets(8));
	    messageLabel.setStyle("-fx-background-radius: 10; -fx-padding: 10px;");
	    
	    Label timeLabel = new Label(time);
	    timeLabel.setStyle("-fx-text-fill: gray; -fx-font-size: 12px;");

	    VBox messageWithTime = new VBox(messageLabel, timeLabel);
	    messageWithTime.setSpacing(2);
	    messageWithTime.prefWidth(300);

	    HBox messageContainer = new HBox();
	    messageContainer.setPadding(new Insets(5, 30, 5, 20));

	    if (sender.equalsIgnoreCase("admin")) {
	    	messageLabel.setStyle("-fx-background-color: #3a9cff;"
	        		+ "-fx-background-radius: 20px;"
	        		+ "-fx-text-fill: #fff;"
	        		+ "-fx-font-size: 17px;"
	        		+ "-fx-font-weight: bold;");
	        messageContainer.setAlignment(Pos.CENTER_RIGHT);
	        timeLabel.setMaxWidth(messageLabel.getMaxWidth());
	        timeLabel.setAlignment(Pos.CENTER_RIGHT);
	    } else {
	    	messageLabel.setStyle("-fx-background-color: #686868;"
	        		+ "-fx-background-radius: 20px;"
	        		+ "-fx-font-size: 17px;"
	        		+ "-fx-font-weight: bold;"
	        		+ "-fx-text-fill: #fff;");
	        messageContainer.setAlignment(Pos.CENTER_LEFT);
	    }

	    messageContainer.getChildren().add(messageWithTime);
	    chatBox.getChildren().add(messageContainer);
	    
	    messageLabel.setCursor(Cursor.HAND);
	    Tooltip tooltip = new Tooltip("Ngày gửi: " + date);
	    tooltip.setShowDelay(Duration.millis(100));
	    tooltip.setHideDelay(Duration.millis(200));
	    Tooltip.install(messageLabel, tooltip);

	    messageLabel.setOnMouseClicked(event -> {
	        tooltip.show(messageLabel, event.getScreenX(), event.getScreenY());
	    });

	    messageLabel.setOnMouseExited(event -> tooltip.hide());
	    
	    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), ae -> scrollpaneChat.setVvalue(1.0)));
	    timeline.play();
	}
	private HBox lastAdminMessageBox; // Biến để lưu HBox của tin nhắn cuối cùng từ admin
	private void loadChatHistoryForUser(String userId) {
	    String sql = "SELECT * FROM messages WHERE (sender = 'admin' AND receiver = ?) OR (sender = ? AND receiver = 'admin') ORDER BY timestamp DESC";
	    chatBox.getChildren().clear();
	    connect = DataBaseConnect.getConnection();
	    try {
	        // Tạo PreparedStatement với ResultSet hỗ trợ di chuyển hai chiều
	        prepare = connect.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        prepare.setString(1, userId.substring(0, userId.indexOf(" ")));
	        prepare.setString(2, userId.substring(0, userId.indexOf(" ")));
	        result = prepare.executeQuery();

	        // Tìm thời gian của tin nhắn cuối cùng từ admin
	        String lastAdminMessageTime = null;
	        boolean checkLast = false;
	        if (result.next()) {
	            String sender = result.getString("sender");
	            
	            if (sender.equalsIgnoreCase("admin")) {
	                lastAdminMessageTime = result.getTimestamp("timestamp").toString();
	                checkLast = true;
	            }else {
	            	while(result.next()) {
	            		String sender1 = result.getString("sender");
	    	            if (sender1.equalsIgnoreCase("admin")) {
	    	                lastAdminMessageTime = result.getTimestamp("timestamp").toString();
	    	                break;
	    	            }
	            	}
	            }
	        }
	        System.out.println(lastAdminMessageTime);
	        String sqlShow = "SELECT * FROM messages WHERE (sender = 'admin' AND receiver = ?) OR (sender = ? AND receiver = 'admin') ORDER BY timestamp ASC";
	        
	        prepare = connect.prepareStatement(sqlShow, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        prepare.setString(1, userId.substring(0, userId.indexOf(" ")));
	        prepare.setString(2, userId.substring(0, userId.indexOf(" ")));
	        result = prepare.executeQuery();
	        
	        lastAdminMessageBox = null; // Reset biến trước khi tải tin nhắn

	        // Hiển thị tất cả tin nhắn
	        while (result.next()) {
	            String sender = result.getString("sender");
	            String message = result.getString("message");
	            String check = result.getTimestamp("timestamp").toString();
	            LocalDateTime messageTime = result.getTimestamp("timestamp").toLocalDateTime();
	            String formattedTime = messageTime.format(DateTimeFormatter.ofPattern("HH:mm"));
	            String date = messageTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	            // Kiểm tra xem đây có phải là tin nhắn cuối cùng từ admin không
	            boolean isLastAdminMessage = sender.equalsIgnoreCase("admin") && 
	            		check.toString().equals(lastAdminMessageTime) && !checkLast;
	            HBox messageBox = LoadMessageToChatBox(sender, message, formattedTime,date, isLastAdminMessage);
	            if (isLastAdminMessage) {
	                lastAdminMessageBox = messageBox; // Lưu HBox của tin nhắn cuối cùng từ admin
	            }
	        }

	     // Cuộn đến tin nhắn cuối cùng từ admin nếu có
	        if (lastAdminMessageBox != null) {
	            scrollToMessage(lastAdminMessageBox);
	        } else {
	            // Nếu không có tin nhắn từ admin, cuộn xuống cuối
	            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), ae -> scrollpaneChat.setVvalue(1.0)));
	            timeline.play();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    DataBaseConnect.closeConnection(connect);
	}
	
	private void scrollToMessage(HBox messageBox) {
	    Platform.runLater(() -> {
	        double totalHeight = chatBox.getHeight();
	        double messageY = messageBox.getBoundsInParent().getMinY();
	        double viewportHeight = scrollpaneChat.getViewportBounds().getHeight();
	        
	        // Tính toán Vvalue để cuộn đến tin nhắn
	        double vValue = messageY / (totalHeight - viewportHeight);
	        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), ae -> scrollpaneChat.setVvalue(vValue)));
            timeline.play();
	        
	    });
	}

	private HBox LoadMessageToChatBox(String sender, String message, String time,String date, boolean isLastAdminMessage) {
	    Label messageLabel = new Label(message);
	    messageLabel.setMaxWidth(300);
	    messageLabel.setWrapText(true);
	    messageLabel.setPadding(new Insets(8));
	    messageLabel.setStyle("-fx-background-radius: 10; -fx-padding: 10px;");

	    Label timeLabel = new Label(time);
	    timeLabel.setStyle("-fx-text-fill: gray; -fx-font-size: 12px;");

	    VBox messageWithTime = new VBox(messageLabel, timeLabel);
	    messageWithTime.setSpacing(2);
	    messageWithTime.prefWidth(300);

	    HBox messageContainer = new HBox();
	    messageContainer.setPadding(new Insets(5, 30, 5, 20));

	    if (sender.equalsIgnoreCase("admin")) {
	        messageLabel.setStyle("-fx-background-color: #3a9cff;"
	                + "-fx-background-radius: 20px;"
	                + "-fx-text-fill: #fff;"
	                + "-fx-font-size: 17px;"
	                + "-fx-font-weight: bold;");
	        messageContainer.setAlignment(Pos.CENTER_RIGHT);
	        timeLabel.setMaxWidth(messageLabel.getMaxWidth());
	        timeLabel.setAlignment(Pos.CENTER_RIGHT);
	    } else {
	        messageLabel.setStyle("-fx-background-color: #686868;"
	                + "-fx-background-radius: 20px;"
	                + "-fx-font-size: 17px;"
	                + "-fx-font-weight: bold;"
	                + "-fx-text-fill: #fff;");
	        messageContainer.setAlignment(Pos.CENTER_LEFT);
	    }

	    messageContainer.getChildren().add(messageWithTime);
	    chatBox.getChildren().add(messageContainer);
	    
	    messageLabel.setCursor(Cursor.HAND);
	    Tooltip tooltip = new Tooltip("Ngày gửi: " + date);
	    tooltip.setShowDelay(Duration.millis(100));
	    tooltip.setHideDelay(Duration.millis(200));
	    Tooltip.install(messageLabel, tooltip);

	    messageLabel.setOnMouseClicked(event -> {
	        tooltip.show(messageLabel, event.getScreenX(), event.getScreenY());
	    });

	    messageLabel.setOnMouseExited(event -> tooltip.hide());
	    
	    if (isLastAdminMessage) {
	        Label unreadLabel = new Label("--------------Tin nhắn chưa trả lời--------------");
	        unreadLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
	        
	        HBox unreadContainer = new HBox();
	        unreadContainer.setPadding(new Insets(5, 30, 5, 20));
	        unreadContainer.setAlignment(Pos.CENTER);
	        unreadContainer.getChildren().add(unreadLabel);
	        
	        chatBox.getChildren().add(unreadContainer);
	    }

	    return messageContainer;
	}


	public void getListView() {
		String sql = "SELECT fullname,username FROM accounts where username != ?";
		connect = DataBaseConnect.getConnection();
		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, "admin");
			result = prepare.executeQuery();
			chatUserListView.getItems().clear();
			while (result.next()) {
				
				chatUserListView.getItems().add(result.getString("username")+" ("+result.getString("fullname")+")");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DataBaseConnect.closeConnection(connect);
	}
	
	public void getListViewChiTietLichSu() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate currentLocalDate = LocalDate.parse(timeCurrentDay.getText(), formatter);
		java.sql.Date sqlDate = java.sql.Date.valueOf(currentLocalDate);

		String sql = "SELECT DISTINCT a.fullname, a.username, " +
		             "CASE WHEN EXISTS (SELECT 1 FROM donhang d2 " +
		             "                 WHERE d2.nguoiMua = a.username " +
		             "                   AND DATE(d2.thoigiandathang) = ?) " +
		             "THEN 1 ELSE 0 END AS isToday " +
		             "FROM accounts a " +
		             "JOIN donhang d ON a.username = d.nguoiMua " +
		             "WHERE a.username != ?";

		connect = DataBaseConnect.getConnection();
		try {
		    prepare = connect.prepareStatement(sql);
		    // Tham số 1 cho ngày hiện tại, tham số 2 cho "admin"
		    prepare.setDate(1, sqlDate);
		    prepare.setString(2, "admin");
		    result = prepare.executeQuery();
		    
		    chatUserListView1.getItems().clear();
		    while (result.next()) {
		        String username = result.getString("username");
		        String fullname = result.getString("fullname");
		        int isToday = result.getInt("isToday");
		        
		        String displayText = username + " (" + fullname + ")";
		        if (isToday == 1) {
		            displayText += " *";
		        }
		        chatUserListView1.getItems().add(displayText);
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    DataBaseConnect.closeConnection(connect);
		}


	}

	
	private LocalDateTime lastMessageTime; // Thời gian của tin nhắn cuối cùng
	private static final long SESSION_DURATION_MINUTES = 5; // Thời gian phiên (10 phút)

	@FXML
	private void sendChatMessage() {
	    String targetUser = currentChatUserLabel.getText().substring(0, currentChatUserLabel.getText().indexOf(" "));
	    String message = chatInputField.getText().trim();
	    if (message.isEmpty()) return;

	    try {
	        LocalDateTime now = LocalDateTime.now();
	        boolean isNewSession = false;

	        // Kiểm tra xem có phải phiên mới không
	        if (lastMessageTime == null || now.isAfter(lastMessageTime.plusMinutes(SESSION_DURATION_MINUTES))) {
	            isNewSession = true;
	        }

	        // Nếu là phiên mới, thêm dòng thời gian bắt đầu
	        if (isNewSession) {
	            addSessionStartTime(now);
	        }

	        // Gửi tin nhắn và cập nhật giao diện
	        chatService.sendMessageToUser(targetUser, message);
	        chatHistories.putIfAbsent(targetUser, new StringBuilder());
	        chatHistories.get(targetUser).append("Admin: ").append(message).append("\n");
	        addMessageToChatBox("Admin", message);
	        lastMessageTime = now; // Cập nhật thời gian tin nhắn cuối cùng

	        // Cuộn xuống cuối chatBox
	        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), ae -> scrollpaneChat.setVvalue(1.0)));
	        timeline.play();
	        chatInputField.clear();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	private void addSessionStartTime(LocalDateTime time) {
	    String formattedTime = time.format(DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy"));
	    Label sessionLabel = new Label("--- Bắt đầu phiên chat: " + formattedTime + " ---");
	    sessionLabel.setStyle("-fx-text-fill: gray; -fx-font-weight: bold;");

	    HBox sessionContainer = new HBox();
	    sessionContainer.setPadding(new Insets(5, 30, 5, 20));
	    sessionContainer.setAlignment(Pos.CENTER);
	    sessionContainer.getChildren().add(sessionLabel);

	    chatBox.getChildren().add(sessionContainer);
	}
	
	public void themChuongMoi(ActionEvent event) {
	    // Lấy sách được chọn từ TableView
	    Book selectedBook = table.getSelectionModel().getSelectedItem();
	    if (selectedBook == null) {
	        Alert alert = new Alert(Alert.AlertType.WARNING, "Vui lòng chọn một sách từ bảng!");
	        alert.showAndWait();
	        return;
	    }
	    
	    // Gọi dialog để nhập thông tin chương mới, sử dụng tên sách của dòng đã chọn
	    Optional<ChapterDialog.ChapterInfo> chapterInfoOptional = ChapterDialog.showDialog(selectedBook.getName());
	    chapterInfoOptional.ifPresent(chapterInfo -> {
	        Connection conn = null;
	        PreparedStatement stmtChapter = null;
	        PreparedStatement stmtContent = null;
	        try {
	            conn = DataBaseConnect.getConnection();
	            conn.setAutoCommit(false); // Bắt đầu transaction

	            // 1. Thêm chương mới vào bảng chapters
	            String sqlChapter = "INSERT INTO chapters (name, chapter_number, title) VALUES (?, ?, ?)";
	            stmtChapter = conn.prepareStatement(sqlChapter, java.sql.Statement.RETURN_GENERATED_KEYS);
	            stmtChapter.setString(1, selectedBook.getName());
	            stmtChapter.setInt(2, chapterInfo.getChapterNumber());
	            stmtChapter.setString(3, chapterInfo.getChapterTitle());
	            stmtChapter.executeUpdate();

	            // Lấy chapter_id vừa được tạo
	            int chapterId = 0;
	            ResultSet rs = stmtChapter.getGeneratedKeys();
	            if (rs.next()) {
	                chapterId = rs.getInt(1);
	            }
	            rs.close();

	            // 2. Thêm nội dung chương vào bảng chapter_contents
	            String sqlContent = "INSERT INTO chapter_contents (chapter_id, content) VALUES (?, ?)";
	            stmtContent = conn.prepareStatement(sqlContent);
	            stmtContent.setInt(1, chapterId);
	            stmtContent.setString(2, chapterInfo.getChapterContent());
	            stmtContent.executeUpdate();

	            // Commit transaction nếu mọi thứ thành công
	            conn.commit();

	            Alert successAlert = new Alert(Alert.AlertType.INFORMATION, "Thêm chương mới thành công cho sách: " + selectedBook.getName());
	            successAlert.showAndWait();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            try {
	                if (conn != null) {
	                    conn.rollback(); // Rollback nếu có lỗi
	                }
	            } catch (SQLException rollbackEx) {
	                rollbackEx.printStackTrace();
	            }
	            Alert errorAlert = new Alert(Alert.AlertType.ERROR, "Có lỗi xảy ra khi thêm chương mới!");
	            errorAlert.showAndWait();
	        } finally {
	            DataBaseConnect.closeConnection(conn);
	        }
	    });
	}
	
	public void capNhatChuongMoi(ActionEvent event) {
	    // Lấy sách được chọn từ bảng
	    Book selectedBook = table.getSelectionModel().getSelectedItem();
	    if (selectedBook == null) {
	        Alert alert = new Alert(Alert.AlertType.WARNING, "Vui lòng chọn một sách từ bảng!");
	        alert.showAndWait();
	        return;
	    }

	    // Hiển thị dialog cập nhật chương
	    Optional<UpdateChapterDialog.UpdateChapterInfo> updateInfoOptional = 
	            UpdateChapterDialog.showDialog(selectedBook.getName());
	    updateInfoOptional.ifPresent(updateInfo -> {
	        // Sau khi người dùng chỉnh sửa và nhấn "Cập nhật", tiến hành cập nhật DB
	        Connection conn = null;
	        PreparedStatement stmtUpdateChapter = null;
	        PreparedStatement stmtUpdateContent = null;
	        try {
	            conn = DataBaseConnect.getConnection();
	            conn.setAutoCommit(false);

	            // Cập nhật tiêu đề chương trong bảng chapters
	            String sqlChapter = "UPDATE chapters SET title = ? WHERE chapter_id = ?";
	            stmtUpdateChapter = conn.prepareStatement(sqlChapter);
	            stmtUpdateChapter.setString(1, updateInfo.getChapterTitle());
	            stmtUpdateChapter.setInt(2, updateInfo.getChapterId());
	            stmtUpdateChapter.executeUpdate();

	            // Cập nhật nội dung chương trong bảng chapter_contents
	            String sqlContent = "UPDATE chapter_contents SET content = ? WHERE chapter_id = ?";
	            stmtUpdateContent = conn.prepareStatement(sqlContent);
	            stmtUpdateContent.setString(1, updateInfo.getChapterContent());
	            stmtUpdateContent.setInt(2, updateInfo.getChapterId());
	            stmtUpdateContent.executeUpdate();

	            conn.commit();
	            Alert successAlert = new Alert(Alert.AlertType.INFORMATION, "Cập nhật chương thành công!");
	            successAlert.showAndWait();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            try {
	                if (conn != null) {
	                    conn.rollback();
	                }
	            } catch (SQLException rollbackEx) {
	                rollbackEx.printStackTrace();
	            }
	            Alert errorAlert = new Alert(Alert.AlertType.ERROR, "Lỗi khi cập nhật chương!");
	            errorAlert.showAndWait();
	        } finally {
	            DataBaseConnect.closeConnection(conn);
	        }
	    });
	}
	
	public void setToolipForChapterButton() {
	    Tooltip tooltip = new Tooltip("Chọn đối tượng từ bảng để thêm hoặc chỉnh sửa chương");
	    tooltip.setShowDelay(Duration.millis(100));
	    tooltip.setHideDelay(Duration.millis(200));
	    Tooltip.install(hboxCapNhatChuong, tooltip);

	    hboxCapNhatChuong.setOnMouseClicked(event -> {
	        tooltip.show(hboxCapNhatChuong, event.getScreenX(), event.getScreenY());
	    });
	    hboxCapNhatChuong.setOnMouseExited(event -> tooltip.hide());
	}




	@SuppressWarnings("static-access")
	public void visiableThemMoi() {
		formInsertBook.setVisible(true);
		formUpdate.setVisible(false);
		TgBtn_True.setMouseTransparent(true);
		TgBtn_False.setMouseTransparent(false);
		AnchorPaneTableView.setBottomAnchor(table, -1.0);
	}

	private void updateFormFields(Book selected) {
		if (selected == null)
			return;
		if (formInsertBook.isVisible()) {
			idText.setText(selected.getId());
			imageTextPath = selected.getImage();
			
			String path = getClass().getResource(imageTextPath).toExternalForm();
			Image image = new Image(path, 134, 205, false, true);
			imageText.setImage(image);
			nameText.setText(selected.getName());
			authorText.setText(selected.getAuthor());
			genreText.setText(selected.getGenre());
			priceText.setText(String.valueOf((int) selected.getPrice()));
			stockText.setText(String.valueOf(selected.getStock()));
			pub_yearText.setText(String.valueOf(selected.getPub_year()));
			desText.setText(selected.getDes());
			linkText.setText(selected.getLinkEbook());
			if (selected.isStatus()) {
				TgBtn_True.setSelected(true);
//				TgBtn_True.setDisable(true);
//				TgBtn_False.setDisable(false);
			} else {
				TgBtn_False.setSelected(true);
//				TgBtn_True.setDisable(false);
//				TgBtn_False.setDisable(true);
			}
		} else {
			idText1.setText(selected.getId());
			imageTextPath = selected.getImage();
			String path = getClass().getResource(imageTextPath).toExternalForm();
			Image image = new Image(path, 134, 205, false, true);
			imageText1.setImage(image);
			nameText1.setText(selected.getName());
			authorText1.setText(selected.getAuthor());
			genreText1.setText(selected.getGenre());
			priceText1.setText(String.valueOf((int) selected.getPrice()));
			stockText1.setText(String.valueOf(selected.getStock()));
			pub_yearText1.setText(String.valueOf(selected.getPub_year()));
			desText1.setText(selected.getDes());
			linkText1.setText(selected.getLinkEbook());
			if (selected.isStatus()) {
				TgBtn_True1.setSelected(true);
//				TgBtn_True1.setDisable(true);
//				TgBtn_False1.setDisable(false);
			} else {
				TgBtn_False1.setSelected(true);
//				TgBtn_True1.setDisable(false);
//				TgBtn_False1.setDisable(true);
			}
		}
	}

	public void onlyNumbers(TextField textField) {
		UnaryOperator<TextFormatter.Change> filter = change -> {
			String newText = change.getControlNewText();
			if (newText.matches("\\d*")) {
				return change;
			}
			return null;
		};
		TextFormatter<Integer> textFormatter = new TextFormatter<>(new IntegerStringConverter(), 0, filter);
		textField.setTextFormatter(textFormatter);
	}

	public ObservableList<Book> selectAll() {
		ObservableList<Book> rs = FXCollections.observableArrayList();
		String sql = "SELECT * FROM books";
		connect = DataBaseConnect.getConnection();
		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			while (result.next()) {
				String id = result.getString("id");
				String name = result.getString("name");
				String image = result.getString("image");
				String author = result.getString("author");
				String genre = result.getString("genre");
				Double price = result.getDouble("price");
				int stock = result.getInt("stock");
				int pub_year = result.getInt("pub_year");
				String des = result.getString("des");
				boolean status = result.getBoolean("status");
				String link = result.getString("ebooklink");
				Book book = new Book(id, image, name, author, genre, price, stock, pub_year, des, status, link);
				rs.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DataBaseConnect.closeConnection(connect);
		return rs;
	}

	@SuppressWarnings("static-access")
	public void renderBook() {
		imageColum.setCellValueFactory(cellData -> {
			Book book = cellData.getValue();
			String path = getClass().getResource(book.getImage()).toExternalForm();
			Image image = new Image(path, 30, 40, false, true);
			ImageView imageView = new ImageView(image);
			return new SimpleObjectProperty<>(imageView);
		});
		pub_yearColumn.setCellValueFactory(new PropertyValueFactory<>("pub_year"));
		desColumn.setCellValueFactory(new PropertyValueFactory<>("des"));
		stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
		genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
		statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

		statusColumn.setCellFactory(column -> new TableCell<Book, Boolean>() {
		    @Override
		    protected void updateItem(Boolean status, boolean empty) {
		        super.updateItem(status, empty);
		        if (empty || status == null) {
		            setText(null);
		        } else {
		            setText(status ? "Đang hoạt động" : "Không hoạt động");
		        }
		    }
		});


		updateColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(null));
		updateColumn.setCellFactory(column -> new TableCell<>() {
		    private final Button updateButton = new Button("Cập nhật");
		    private final Button deleteButton = new Button("Xóa");
		    private final HBox buttonContainer = new HBox(updateButton, deleteButton);
		    {
		        buttonContainer.setSpacing(10);
		        
		        // Set style cho nút cập nhật: nền xanh dương, chữ trắng
		        updateButton.setStyle("-fx-background-color: #3a9cff; -fx-text-fill: white;");
		        
		        // Set style cho nút xóa: nền đỏ, chữ trắng
		        deleteButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		        
		        updateButton.setOnAction(event -> {
		            Book book = getTableView().getItems().get(getIndex());
		            formUpdate.setVisible(true);
		            formInsertBook.setVisible(false);
		            AnchorPaneTableView.setBottomAnchor(table, -1.0);
		            updateFormFields(book);
		        });
		        deleteButton.setOnAction(event -> {
		            Book book = getTableView().getItems().get(getIndex());
		            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		            alert.setTitle("Xác nhận xóa");
		            alert.setHeaderText("Bạn có chắc muốn xóa sách này?");
		            alert.setContentText("Tên sách: " + book.getName());
		            ButtonType buttonYes = new ButtonType("Xóa", ButtonBar.ButtonData.OK_DONE);
		            ButtonType buttonNo = new ButtonType("Hủy", ButtonBar.ButtonData.CANCEL_CLOSE);
		            alert.getButtonTypes().setAll(buttonYes, buttonNo);
		            alert.showAndWait().ifPresent(response -> {
		                if (response == buttonYes) {
		                    delete(book);
		                }
		            });
		        });
		    }
		    
		    @Override
		    protected void updateItem(Void item, boolean empty) {
		        super.updateItem(item, empty);
		        if (empty) {
		            setGraphic(null);
		        } else {
		            setGraphic(buttonContainer);
		        }
		    }
		});

		bookList = selectAll();
		sumBook.setText(String.valueOf(bookList.size()));
		table.setItems(bookList);
	}

	public void logout(ActionEvent event) {
		Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
		confirmationAlert.setTitle("Xác nhận đăng xuất");
		confirmationAlert.setHeaderText(null);
		confirmationAlert.setContentText("Bạn có chắc chắn muốn đăng xuất không?");
		AlertMessage alert = new AlertMessage();
		Optional<ButtonType> result = confirmationAlert.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.OK) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
				Parent parent = loader.load();

				if (parent != null) {
					connect = DataBaseConnect.getConnection();
					String sqlUpdate = "update accounts set status = 0 where username = ?";
					prepare = connect.prepareStatement(sqlUpdate);
					prepare.setString(1, "admin");
					int check = prepare.executeUpdate();
					if(check > 0) {
						System.out.println("Cập nhật trạng thái đăng xuất thành công cho user: admin");
					}else {
						System.out.println("Lỗi khi cập nhật trạng thái đăng nhập");
					}
					DataBaseConnect.closeConnection(connect);
					alert.successMessage("Đăng xuất thành công");
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					Scene scene = new Scene(parent);
					stage.setScene(scene);

					// Hủy consumer và xóa queue
					chatService.closeConsumer("chat_admin");
					chatService.deleteQueue("chat_admin");
				} else {
					alert.errorMessage("Không thể tải màn hình đăng nhập.");
				}
			} catch (IOException e) {
				e.printStackTrace();
				alert.errorMessage("Lỗi khi tải giao diện đăng nhập.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void chooseImage(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg",
				"*.jpeg");
		fileChooser.getExtensionFilters().add(extFilter);
		File defaultDirectory = new File("src/images");
		if (defaultDirectory.exists()) {
			fileChooser.setInitialDirectory(defaultDirectory);
		}
		File file = fileChooser.showOpenDialog(null);

		if (file != null) {
			File projectDir = new File(System.getProperty("user.dir")); // Thư mục gốc của project
			URI projectURI = projectDir.toURI();
			URI fileURI = file.toURI();
			String relativePath = projectURI.relativize(fileURI).getPath();
			imageTextPath = relativePath.replace("src/images", "/images");
			String path = getClass().getResource(imageTextPath).toExternalForm();
			System.out.println(path);
			Image image = new Image(path, 134, 205, false, true);
			if (formInsertBook.isVisible()) {
				imageText.setImage(image);
			} else if (formUpdate.isVisible()) {
				imageText1.setImage(image);
			}
		}
	}

	public void insertBook(ActionEvent event) {
		Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
		alert1.setTitle("Xác nhận thêm sách");
		alert1.setHeaderText("Bạn có chắc muốn thêm sách này?");
		alert1.setContentText("Tên sách: " + idText.getText());
		ButtonType buttonYes = new ButtonType("Thêm", ButtonBar.ButtonData.OK_DONE);
		ButtonType buttonNo = new ButtonType("Hủy", ButtonBar.ButtonData.CANCEL_CLOSE);
		alert1.getButtonTypes().setAll(buttonYes, buttonNo);
		alert1.showAndWait().ifPresent(response -> {
			if (response == buttonYes) {
				Book newBook = new Book();
				AlertMessage alert = new AlertMessage();
				String id = "", image = "", name = "", author = "", genre = "", des = "", link = "";
				int pub_year = -1, stock = -1;
				double price = -1;
				boolean status = true;
				if (formInsertBook.isVisible()) {
					id = idText.getText();
					image = imageTextPath;
					name = nameText.getText();
					author = authorText.getText();
					genre = genreText.getText();
					try {
						price = Double.parseDouble(priceText.getText());
						pub_year = Integer.parseInt(pub_yearText.getText());
						stock = Integer.parseInt(stockText.getText());
					} catch (NumberFormatException e) {
					}
					des = desText.getText();
					link = linkText.getText();
					if (TgBtn_True.isSelected()) {
//						TgBtn_True.setDisable(true);
//						TgBtn_False.setDisable(false);
						status = true;
					} else {
						status = false;
//						TgBtn_True.setDisable(false);
//						TgBtn_False.setDisable(true);
					}

				} else if (formUpdate.isVisible()) {
					id = idText1.getText();
					image = imageTextPath;
					name = nameText1.getText();
					author = authorText1.getText();
					genre = genreText1.getText();
					try {
						price = Double.parseDouble(priceText1.getText());
						pub_year = Integer.parseInt(pub_yearText1.getText());
						stock = Integer.parseInt(stockText1.getText());
					} catch (NumberFormatException e) {

					}
					des = desText1.getText();
					link = linkText1.getText();
					if (TgBtn_True1.isSelected()) {
						status = true;
//						TgBtn_True1.setDisable(true);
//						TgBtn_False1.setDisable(false);
					} else {
						status = false;
//						TgBtn_True1.setDisable(false);
//						TgBtn_False1.setDisable(true);
					}
				}

				if (id.isEmpty() || image.isEmpty() || name.isEmpty() || author.isEmpty() || genre.isEmpty() || link.isEmpty()
						|| price == -1 || pub_year == -1 || des.isEmpty() || stock == -1) {
					alert.errorMessage("Còn thiếu ô chưa nhập thông tin");
				} else {
					for (Book book : selectAll()) {
						if (book.getId().equalsIgnoreCase(id)) {
							alert.errorMessage("Mã sách này đã tồn tại");
							return;
						}
					}
					newBook.setId(id);
					newBook.setImage(image);
					newBook.setName(name);
					newBook.setAuthor(author);
					newBook.setGenre(genre);
					newBook.setPrice(price);
					newBook.setStock(stock);
					newBook.setPub_year(pub_year);
					newBook.setDes(des);
					newBook.setLinkEbook(link);

					String sql = "insert into books (id, image, name, author, genre, price, stock, pub_year, des, status,created_at, ebooklink)"
							+ " values (?,?,?,?,?,?,?,?,?, ?,?,?)";
					connect = DataBaseConnect.getConnection();
					try {
						prepare = connect.prepareStatement(sql);
						prepare.setString(1, id);
						prepare.setString(2, image);
						prepare.setString(3, name);
						prepare.setString(4, author);
						prepare.setString(5, genre);
						prepare.setDouble(6, price);
						prepare.setInt(7, stock);
						prepare.setInt(8, pub_year);
						prepare.setString(9, des);
						prepare.setBoolean(10, status);
						prepare.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
						prepare.setString(12, link);
						prepare.executeUpdate();

					} catch (SQLException e) {
						e.printStackTrace();
					}

					DataBaseConnect.closeConnection(connect);

					bookList.add(newBook);
					alert.successMessage("Thêm sách thành công");
					refresh();
				}
			}
		});
	}

	@SuppressWarnings("static-access")
	public void refresh() {
		bookList.clear();
		bookList.addAll(selectAll());
		sumBook.setText(String.valueOf(bookList.size()));
		table.setItems(bookList);
		idText.setText("");
		nameText.setText("");
		imageText.setImage(null);
		authorText.setText("");
		priceText.setText("");
		genreText.setText("");
		stockText.setText("");
		pub_yearText.setText("");
		desText.setText("");
		idText1.setText("");
		nameText1.setText("");
		imageText1.setImage(null);
		authorText1.setText("");
		linkText.setText("");
		linkText1.setText("");
		priceText1.setText("");
		genreText1.setText("");
		stockText1.setText("");
		pub_yearText1.setText("");
		desText1.setText("");
		formInsertBook.setVisible(false);
		formUpdate.setVisible(false);
		AnchorPaneTableView.setBottomAnchor(table, -324.0);
		btnHuySearh.setDisable(true);
		textSearch.setText("");
		TgBtn_True.setSelected(true);
		TgBtn_True.setMouseTransparent(true);
		TgBtn_False.setMouseTransparent(false);
		TgBtn_True1.setSelected(true);
		TgBtn_True.setMouseTransparent(false);
		TgBtn_False.setMouseTransparent(true);
	}

	public void delete(Book book) {
		AlertMessage alert = new AlertMessage();
		if (book != null) {
			String sql = "UPDATE books SET status = 0 WHERE id = ?";
			connect = DataBaseConnect.getConnection();
			try {
				prepare = connect.prepareStatement(sql);
				prepare.setString(1, book.getId());
				prepare.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DataBaseConnect.closeConnection(connect);
			alert.successMessage("Cập nhật trạng thái sách thành công");
			bookList.remove(book);
			refresh();
		} else {
			alert.errorMessage("Vui lòng chọn sách cần xóa trong bảng");
		}
	}

	public void update() {
		Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
		alert1.setTitle("Xác nhận cập nhật sách");
		alert1.setHeaderText("Bạn có chắc muốn cập nhật sách này?");
		alert1.setContentText("Tên sách: " + idText.getText());
		ButtonType buttonYes = new ButtonType("Cập nhật", ButtonBar.ButtonData.OK_DONE);
		ButtonType buttonNo = new ButtonType("Hủy", ButtonBar.ButtonData.CANCEL_CLOSE);
		alert1.getButtonTypes().setAll(buttonYes, buttonNo);
		alert1.showAndWait().ifPresent(response -> {
			if (response == buttonYes) {
				AlertMessage alert = new AlertMessage();
				String id = "", image = "", name = "", author = "", genre = "", des = "", link = "";
				int pub_year = -1, stock = -1;
				double price = -1;
				boolean status = true;
				if (formInsertBook.isVisible()) {
					id = idText.getText();
					image = imageTextPath;
					name = nameText.getText();
					author = authorText.getText();
					genre = genreText.getText();
					try {
						price = Double.parseDouble(priceText.getText());
						pub_year = Integer.parseInt(pub_yearText.getText());
						stock = Integer.parseInt(stockText.getText());
					} catch (NumberFormatException e) {
					}
					des = desText.getText();
					link = linkText.getText();
					if (TgBtn_True.isSelected()) {
//						TgBtn_True.setDisable(true);
//						TgBtn_False.setDisable(false);
						status = true;
					} else {
						status = false;
//						TgBtn_True.setDisable(false);
//						TgBtn_False.setDisable(true);
					}
				} else if (formUpdate.isVisible()) {
					id = idText1.getText();
					image = imageTextPath;
					name = nameText1.getText();
					author = authorText1.getText();
					genre = genreText1.getText();
					try {
						price = Double.parseDouble(priceText1.getText());
						pub_year = Integer.parseInt(pub_yearText1.getText());
						stock = Integer.parseInt(stockText1.getText());
					} catch (NumberFormatException e) {
					}
					des = desText1.getText();
					link = linkText1.getText();
					if (TgBtn_True1.isSelected()) {
						status = true;
//						TgBtn_True1.setDisable(true);
//						TgBtn_False1.setDisable(false);
					} else {
						status = false;
//						TgBtn_True1.setDisable(false);
//						TgBtn_False1.setDisable(true);
					}
				}
				if (id.isEmpty() || image.isEmpty() || name.isEmpty() || author.isEmpty() || genre.isEmpty() || link.isEmpty()
						|| price == -1 || pub_year == -1 || des.isEmpty() || stock == -1) {
					alert.errorMessage("Còn thiếu ô chưa nhập thông tin");
				} else {
					connect = DataBaseConnect.getConnection();
					String sqlGetID = "select id_auto from books where id = ?";
					int id_auto = 0;
					try {
						prepare = connect.prepareStatement(sqlGetID);
						prepare.setString(1, id);
						result = prepare.executeQuery();
						if (result.next()) {
							id_auto = result.getInt("id_auto");
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					String sql = "update books set id = ?, image = ?, name = ?, author = ?, genre = ?, price = ?, stock = ?,"
							+ " pub_year = ?, des = ?, status = ?, updated_at = ?, ebooklink = ? where id_auto = ?";
					
					try {
						prepare = connect.prepareStatement(sql);
						prepare.setString(1, id);
						prepare.setString(2, image);
						prepare.setString(3, name);
						prepare.setString(4, author);
						prepare.setString(5, genre);
						prepare.setDouble(6, price);
						prepare.setInt(7, stock);
						prepare.setInt(8, pub_year);
						prepare.setString(9, des);
						prepare.setBoolean(10, status);
						prepare.setTimestamp(11, new Timestamp(System.currentTimeMillis())); // Cập nhật thời gian
						prepare.setString(12, link);
						prepare.setInt(13, id_auto);
						prepare.executeUpdate();
						
						alert.successMessage("Cập nhật thành công");
						refresh();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					DataBaseConnect.closeConnection(connect);
				}
			}
		});
	}

	public void search() {
		try {
			String SearchText = textSearch.getText().trim();
			AlertMessage alert = new AlertMessage();
			if (SearchText.isEmpty()) {
				alert.errorMessage("Vui lòng nhập đầy đủ thông tin");
				return;
			}
			ObservableList<Book> rs = FXCollections.observableArrayList();

			String sql = "select * from books where id like ? or genre like ? or author like ? or name like ?";
			connect = DataBaseConnect.getConnection();
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, "%" + SearchText + "%");
			prepare.setString(2, "%" + SearchText + "%");
			prepare.setString(3, "%" + SearchText + "%");
			prepare.setString(4, "%" + SearchText + "%");
			result = prepare.executeQuery();
			while (result.next()) {
				Book book;
				String id = result.getString("id");
				String image = result.getString("image");
				String name = result.getString("name");
				String author = result.getString("author");
				String genre = result.getString("genre");
				double price = result.getDouble("price");
				int stock = result.getInt("stock");
				int pub_year = result.getInt("pub_year");
				String des = result.getString("des");
				book = new Book(id, image, name, author, genre, price, stock, pub_year, des);
				rs.add(book);
			}
			DataBaseConnect.closeConnection(connect);
			if (rs != null && !rs.isEmpty()) {
				table.getItems().clear();
				table.getItems().addAll(rs);
				btnHuySearh.setDisable(false);
			} else {
				alert.errorMessage("Không tìm thấy");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	public void capNhatGiaoDienTrangCapNhat() {
		borderpaneMain.sceneProperty().addListener((obs, oldScene, newScene) -> {
			if (newScene != null) {
				Platform.runLater(() -> {
					Stage stage = (Stage) newScene.getWindow();
					if (stage != null) {
						stage.fullScreenProperty().addListener((obsFull, oldFull, isFullScreen) -> {
							if (isFullScreen) {
								flowpaneCapNhat.setVgap(35);
								anchorpaneFlowPaneCapNhat.setTopAnchor(flowpaneCapNhat, 25.0);
								anchorpaneFlowPaneCapNhat.setLeftAnchor(flowpaneCapNhat, 40.0);
								flowpaneThem.setVgap(35);
								anchorpaneFlowPaneThem.setTopAnchor(flowpaneThem, 25.0);
								anchorpaneFlowPaneThem.setLeftAnchor(flowpaneThem, 40.0);
							}else {
								flowpaneCapNhat.setVgap(5);
								anchorpaneFlowPaneCapNhat.setTopAnchor(flowpaneCapNhat, 0.0);
								anchorpaneFlowPaneCapNhat.setLeftAnchor(flowpaneCapNhat, 0.0);
								flowpaneThem.setVgap(5);
								anchorpaneFlowPaneThem.setTopAnchor(flowpaneThem, 0.0);
								anchorpaneFlowPaneThem.setLeftAnchor(flowpaneThem, 0.0);
							}
						});
						stage.maximizedProperty().addListener((obsMax, oldMax, isMaximized) -> {
							
							if (isMaximized) {
								flowpaneCapNhat.setVgap(35);
								anchorpaneFlowPaneCapNhat.setTopAnchor(flowpaneCapNhat, 25.0);
								anchorpaneFlowPaneCapNhat.setLeftAnchor(flowpaneCapNhat, 40.0);
								flowpaneThem.setVgap(35);
								anchorpaneFlowPaneThem.setTopAnchor(flowpaneThem, 25.0);
								anchorpaneFlowPaneThem.setLeftAnchor(flowpaneThem, 40.0);
							} else {
								flowpaneCapNhat.setVgap(5);
								anchorpaneFlowPaneCapNhat.setTopAnchor(flowpaneCapNhat, 0.0);
								anchorpaneFlowPaneCapNhat.setLeftAnchor(flowpaneCapNhat, 0.0);
								flowpaneThem.setVgap(5);
								anchorpaneFlowPaneThem.setTopAnchor(flowpaneThem, 0.0);
								anchorpaneFlowPaneThem.setLeftAnchor(flowpaneThem, 0.0);
							}
						});
					}
				});
			}
		});
	}
}
