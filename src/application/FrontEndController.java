package application;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;

public class FrontEndController implements Initializable {

	@FXML
	private VBox menuBox;

	@FXML
	private GridPane centerContent;

	@FXML
	private BorderPane FE_DangNhapForm;

	@FXML
	private Button FE_btnDangNhap;

	@FXML
	private Button FE_btnGioHang;

	@FXML
	private Button FE_btnHoTro;
	
	@FXML
	private Button FE_btnThuVien;

	@FXML
	private Button FE_btnLogout;

	@FXML
	private Button menuButton;

	@FXML
	private Button FE_btnSanPham;

	@FXML
	private Button FE_btnTrangChu;

	@FXML
	private AnchorPane FE_chiTietForm;

	@FXML
	private Label FE_chiTiet_authorText;

	@FXML
	private Label priceShippingText;

	@FXML
	private RadioButton radioBtn_Bank;

	@FXML
	private RadioButton radioBtn_Home;

	@FXML
	private Button FE_chiTiet_btnThemGioHang;

	@FXML
	private Label FE_chiTiet_genreText;

	@FXML
	private ImageView FE_chiTiet_imageView;

	@FXML
	private Label FE_chiTiet_moTaText;

	@FXML
	private Label FE_chiTiet_nameText;

	@FXML
	private Label FE_chiTiet_priceText;

	@FXML
	private Label priceGiamGiaText;

	@FXML
	private Label loaiMaGiamGiaText;

	@FXML
	private Label FE_chiTiet_pubYearText;

	@FXML
	private Spinner<Integer> FE_chiTiet_spinnerQuantity;

	@FXML
	private AnchorPane FE_gioHangForm;

	@FXML
	private FlowPane flowpane_chiTiet;

	@FXML
	private AnchorPane FE_hoTroForm;

	@FXML
	private FontAwesomeIconView FE_iconSearch;

	@FXML
	private ImageView FE_imageViewAccount;

	@FXML
	private Label FE_logoText;

	@FXML
	private Pagination pagination;

	@FXML
	private Label loaivanchuyenText;

	@FXML
	private Label FE_nameTextAccount;

	@FXML
	private Label FE_titelTextSP;

	@FXML
	private AnchorPane FE_sanPhamForm;

	@FXML
	private TextField FE_textFeildSearch;

	@FXML
	private FlowPane FE_trangChuFlowPane;

	@FXML
	private AnchorPane FE_trangChuForm;

	@FXML
	private ScrollPane scrollpaneBanChayNhat;
	
	@FXML
	private ScrollPane scrollpaneTrangChu;

	@FXML
	private FlowPane CartList;

	@FXML
	private Label totalPriceAllText;

	@FXML
	private Label totalPriceAllPayText;

	@FXML
	private Button btn_homeBaCK;

	@FXML
	private Label addressText;

	@FXML
	private Label totalQuantityAllText;

	@FXML
	private HBox hboxChonDiaChi;
	
	@FXML
	private HBox nhanTinForm;
	
	@FXML
	private HBox hBoxSapXep;
	
	@FXML
	private HBox hboxChonVanChuyen;

	@FXML
	private Button btn_homeBack1;

	@FXML
	private CheckBox checkBoxAll;

	@FXML
	private Label startcheck;

	@FXML
	private Label startcheck1;

	@FXML
	private ToggleButton TgBtn_LoaiSachDienTu;

	@FXML
	private ToggleButton TgBtn_LoaiSachGiay;

	@FXML
	private ToggleGroup loaisach;

	@FXML
	private TextArea chatArea;

	@FXML
	private ScrollPane scrollpaneChat;
	
	@FXML
	private ScrollPane scrollpaneSanPham;

	@FXML
	private VBox chatBox;

	@FXML
	private Button BtnThongTinCaNhan;

	@FXML
	private Button btnBackFromUser;

	@FXML
	private TextArea inputField;

	@FXML
	private AnchorPane thongTinTaiKhoanForm;

	@FXML
	private TextField soTKNganHangText;

	@FXML
	private TextField sdtText;

	@FXML
	private TextField fullnameText;

	@FXML
	private TextField diachigiaohangText;

	@FXML
	private TextField emailText;

	@FXML
	private ComboBox<String> NganHangComboBox;
	
	@FXML
	private ComboBox<String> comboBoxSapXepTheoGia;
	
    @FXML
    private AnchorPane FE_sanPhamForm1;

    @FXML
    private Label FE_titelTextSP1;

    @FXML
    private FlowPane FE_trangChuFlowPane1;

    @FXML
    private Button btn_homeBack11;
    
    @FXML
    private Button btnBackHoTro;
    
    @FXML
    private VBox cauHoiPhoBienForm;

    @FXML
    private ScrollPane scrollpaneSanPham1;
    
    @FXML
    private HBox HboxChinhSuaThongTin;

    @FXML
    private HBox HboxLuuThongTin;
    
    @FXML
    private VBox VboxThongTinTaiKhoan;

	private ChatService chatService;

	private Connection connect;
	private PreparedStatement prepare;
	private ResultSet result;

	private ObservableList<Book> cardListData = FXCollections.observableArrayList();

	private List<CardBookController> cardControllers = new ArrayList<>();
	
	private List<CardBookLibraryController> cardLibratyControllers = new ArrayList<>();

	private ObservableList<Cart> cartListData = FXCollections.observableArrayList();

	private Book selectedBook;

	private String fullname;
	private String username;

	private int scene = 1;
	private double VvalueTruoc = 0.0;
	private int currentPage = 0;
	
	private GoogleAuthApp googleAuthApp = new GoogleAuthApp();
	
	DecimalFormat df = new DecimalFormat("#,###");


	private double originalPaperBookPrice = 0.0;
	//TODO KHỞI TẠO
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		refresh();
		startAutoScroll();
		capnhatGiaLoaiSachGiHang();
		
		pagination.currentPageIndexProperty().addListener((obs, oldIndex, newIndex) -> {
			currentPage = newIndex.intValue();
		    System.out.println("Giá trị trước: "+oldIndex);
		    System.out.println("Giá trị hiện tại: "+newIndex);
		});

		totalPriceAllText.textProperty().addListener((obs, oldVal, newVal) -> updateTotalOrder(oldVal));
		priceShippingText.textProperty().addListener((obs, oldVal, newVal) -> updateTotalOrder());
		priceGiamGiaText.textProperty().addListener((obs, oldVal, newVal) -> updateTotalOrder());
		capNhatGiaoDienTrangSanPham();
		Platform.runLater(() -> {
			Stage stage = (Stage) FE_DangNhapForm.getScene().getWindow();
			stage.setOnCloseRequest(event -> {
				try {
					connect = DataBaseConnect.getConnection();
					String sqlUpdate = "update accounts set status = 0 where username = ?";
					prepare = connect.prepareStatement(sqlUpdate);
					prepare.setString(1, username);
					int check = prepare.executeUpdate();
					if(check > 0) {
						System.out.println("Cập nhật trạng thái xuất thành công cho user:" + username);
					}else {
						System.out.println("Lỗi khi cập nhật trạng thái đăng nhập");
					}
					DataBaseConnect.closeConnection(connect);
					if(chatService != null) {
						String queueName = "chat_user_" + username;
						chatService.closeConsumer(queueName); // Hủy consumer
						chatService.deleteQueue(queueName); // Xóa queue
						System.out.println("Queue của user đã được xóa khi đóng scene.");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		});
		handleComboBoxSapXepTheoGiaSelection();
		setXacThucEmail();
		
		FE_btnTrangChu.getStyleClass().add("selected");

		
	}
	
	public void setcomboBoxSapXepTheoGia() {
	    ObservableList<String> danhSachKhoangGia = FXCollections.observableArrayList(
	            "Chọn khoảng giá",
	            "50000 - 79999 VND",
	            "80000 - 109999 VND",
	            "110000 - 139999 VND",
	            "140000 - 169999 VND",
	            "> 170000 VND"
	    );
	    comboBoxSapXepTheoGia.setItems(danhSachKhoangGia);
	    comboBoxSapXepTheoGia.setValue("Chọn khoảng giá");
	    comboBoxSapXepTheoGia.setPromptText("Chọn khoảng giá");
	    
	    comboBoxSapXepTheoGia.setCellFactory(lv -> new ListCell<String>() {
	        @Override
	        protected void updateItem(String item, boolean empty) {
	            super.updateItem(item, empty);
	            if (empty || item == null) {
	                setText(null);
	            } else {
	                setText(item);
	                if ("Chọn khoảng giá".equals(item)) {
	                    // Định dạng cho item mặc định và vô hiệu hóa lựa chọn của nó
	                    setStyle("-fx-text-fill: gray;");
	                    setDisable(true);
	                    setMouseTransparent(true);
	                } else {
	                    setStyle("");
	                    setDisable(false);
	                    setMouseTransparent(false);
	                }
	            }
	        }
	    });
	}
	
	public void handleComboBoxSapXepTheoGiaSelection() {
	    comboBoxSapXepTheoGia.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
	        if (newValue != null && !newValue.equals("Chọn khoảng giá")) {
	            double minPrice = 0.0;
	            double maxPrice = Double.MAX_VALUE;

	            // Xử lý định dạng khoảng giá: "50000 - 80000 VND" hoặc "> 170000 VND"
	            if (newValue.contains("-")) {
	                String[] parts = newValue.split("-");
	                try {
	                    minPrice = Double.parseDouble(parts[0].trim());
	                    String maxPart = parts[1].replace("VND", "").trim();
	                    maxPrice = Double.parseDouble(maxPart);
	                } catch (NumberFormatException e) {
	                    e.printStackTrace();
	                }
	            } else if (newValue.startsWith(">")) {
	                try {
	                    minPrice = Double.parseDouble(newValue.substring(1).replace("VND", "").trim());
	                    maxPrice = Double.MAX_VALUE;
	                } catch (NumberFormatException e) {
	                    e.printStackTrace();
	                }
	            }

	            // Lấy danh sách tất cả sách từ csdl hoặc nguồn dữ liệu (giả sử menuGetData() trả về ObservableList<Book>)
	            ObservableList<Book> allBooks = menuGetData();
	            // Tạo danh sách lọc dựa trên điều kiện giá
	            cardListData.clear();
	            for (Book book : allBooks) {
	                if (book.getPrice() >= minPrice && book.getPrice() <= maxPrice) {
	                    cardListData.add(book);
	                }
	            }
	            
	            FXCollections.sort(cardListData, (b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()));
	            // Cập nhật giao diện hiển thị danh sách sách theo list đã lọc
	            displayBooks();
	            setButtonDetail();
	        } else {
	        	menuDisplayCard();
	    		setButtonDetail();
	    		setQuantity();
	        }
	    });
	}			

	public void displayBooks() {
		pagination.setPageCount(1);
	    // Xóa các phần tử hiển thị cũ trong FlowPane (hoặc container bạn đang sử dụng)
	    FE_trangChuFlowPane.getChildren().clear();
	    
	    // Duyệt qua danh sách sách đã lọc và load từng card hiển thị
	    for (Book book : cardListData) {
	        try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("CardBook.fxml"));
	            VBox box = loader.load();
	            CardBookController controller = loader.getController();
	            controller.setData(book);
	            controller.setFrontEndController(this);
	         // Thêm controller vào danh sách để set sự kiện sau này
	            cardControllers.add(controller);
	            FE_trangChuFlowPane.getChildren().add(box);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}



	
	public void refresh() {
		hBoxSapXep.setVisible(true);
		menuDisplayCard();
		setButtonDetail();
		setQuantity();
		menuCartDisplayCard();
		Platform.runLater(() -> updateCheckboxAllState());
		setcomboBoxSapXepTheoGia();
	}
	

	public void setFullname(String fullname, String username) {
		this.username = username;
		this.fullname = fullname;
		FE_nameTextAccount.setText(fullname);
	}

	public CheckBox getCheckBoxAll() {
		return checkBoxAll;
	}

	public void logout(ActionEvent event) {
		AlertMessage alert = new AlertMessage();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
			Parent parent = loader.load();

			if (parent != null) {
				alert.successMessage("Đăng xuất thành công");
				connect = DataBaseConnect.getConnection();
				String sqlUpdate = "update accounts set status = 0 where username = ?";
				prepare = connect.prepareStatement(sqlUpdate);
				prepare.setString(1, username);
				int check = prepare.executeUpdate();
				if(check > 0) {
					System.out.println("Cập nhật trạng thái xuất thành công cho user: "+ username);
				}else {
					System.out.println("Lỗi khi cập nhật trạng thái đăng nhập");
				}
				DataBaseConnect.closeConnection(connect);
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				Scene scene = new Scene(parent);
				stage.setScene(scene);

				// Hủy consumer và xóa queue
				stopRabbitMQ();
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

	public void stopRabbitMQ() {
		
		if (chatService == null) {
			return;
		}
		String queueName = "chat_user_" + username;
		try {
			
			chatService.closeConsumer(queueName);
			chatService.deleteQueue(queueName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setChuyenTrang(Button a, AnchorPane b) {
		BtnThongTinCaNhan.getStyleClass().remove("selected");
		FE_btnTrangChu.getStyleClass().remove("selected");
		FE_btnSanPham.getStyleClass().remove("selected");
		FE_btnGioHang.getStyleClass().remove("selected");
		FE_btnHoTro.getStyleClass().remove("selected");
		FE_btnThuVien.getStyleClass().remove("selected");
		a.getStyleClass().add("selected");
		FE_trangChuForm.setVisible(false);
		FE_sanPhamForm.setVisible(false);
		FE_gioHangForm.setVisible(false);
		FE_sanPhamForm1.setVisible(false);
		FE_hoTroForm.setVisible(false);
		FE_chiTietForm.setVisible(false);
		thongTinTaiKhoanForm.setVisible(false);
		
		b.setVisible(true);
	}

	// PHẦN DÙNG CHUNG CHO VIỆC CHUYỂN ĐỔI CÁC SCENE
	public void switchForm(ActionEvent event) {
		hBoxSapXep.setVisible(true);
		if (event.getSource() == BtnThongTinCaNhan) {
			getThongTinTaiKhoan();
			stopRabbitMQ();
			setChuyenTrang(BtnThongTinCaNhan, thongTinTaiKhoanForm);

		} else
		// KHI NHẤN VÀO BUTTON TRANGCHU
		if (event.getSource() == FE_btnTrangChu) {
			stopRabbitMQ();
			scene = 1;
			setChuyenTrang(FE_btnTrangChu, FE_trangChuForm);
		}
		// KHI NHẤN VÀO BUTTON GIOHANG
		else if (event.getSource() == FE_btnSanPham) {
			stopRabbitMQ();
			scene = 2;
			setChuyenTrang(FE_btnSanPham, FE_sanPhamForm);
			FE_titelTextSP.setText("Danh sách truyện");
			btn_homeBack1.setVisible(false);
			scrollpaneSanPham.setVvalue(0);
			refresh();
		}
		// KHI NHẤN VÀO BUTTON THUVIEN
		else if (event.getSource() == FE_btnGioHang) {
			stopRabbitMQ();
			scene = 3;
			setChuyenTrang(FE_btnGioHang, FE_gioHangForm);
			refresh();
			selectDiachi();

		}
		
		else if (event.getSource() == FE_btnThuVien) {
			stopRabbitMQ();
			scene = 2;
			setChuyenTrang(FE_btnThuVien, FE_sanPhamForm1);
			menuDisplayCardLibrary();

		}
		// KHI NHẤN VÀO BUTTON NHANTIN
		else if (event.getSource() == FE_btnHoTro) {
			scene = 4;
			setChuyenTrang(FE_btnHoTro, FE_hoTroForm);
//			Platform.runLater(() -> {
				try {
					chatService = new ChatService();
					chatService.setupUserQueue(username, (consumerTag, delivery) -> {
						String msg = new String(delivery.getBody(), "UTF-8");
						Platform.runLater(() -> {
							addMessageToChatBox(msg, false);
							Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), ae -> scrollpaneChat.setVvalue(1.0)));
						    timeline.play();
						});
					});
					loadChatHistory();
					Stage stage = (Stage) FE_DangNhapForm.getScene().getWindow();
					stage.setOnCloseRequest(ev -> {
						try {
							stopRabbitMQ();
							System.out.println("Queue của user " + username + " đã được xóa khi đóng scene.");
							connect = DataBaseConnect.getConnection();
							String sqlUpdate = "update accounts set status = 0 where username = ?";
							prepare = connect.prepareStatement(sqlUpdate);
							prepare.setString(1, username);
							int check = prepare.executeUpdate();
							if(check > 0) {
								System.out.println("Cập nhật trạng thái xuất thành công cho user: "+ username);
							}else {
								System.out.println("Lỗi khi cập nhật trạng thái đăng nhập");
							}
							DataBaseConnect.closeConnection(connect);
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
//			});
		} else if (event.getSource() == btn_homeBaCK || event.getSource() == btn_homeBack1
				|| event.getSource() == btnBackFromUser) {
			
			if (scene == 1) {
				setChuyenTrang(FE_btnTrangChu, FE_trangChuForm);
			} else if (scene == 2) {
				setChuyenTrang(FE_btnSanPham, FE_sanPhamForm);
				FE_titelTextSP.setText("Danh sách truyện");
				System.out.println("Trang dự kiến lấy: " + currentPage);
				int save = currentPage;
				refresh();
				System.out.println("Trang lấy sau khi refresh: " + save);
				updatePage(save);
				setButtonDetail();
				pagination.setVisible(true);
				pagination.setCurrentPageIndex(save);

//				System.out.println(VvalueTruoc);
				//phai co flatform de cap nhat giao dien truoc
				Platform.runLater(() -> scrollpaneSanPham.setVvalue(VvalueTruoc));
				if(scrollpaneTrangChu != null) {
					Platform.runLater(() -> scrollpaneTrangChu.setVvalue(VvalueTruoc));
				}
				
			} else if (scene == 3) {
				scene = 3;
				setChuyenTrang(FE_btnGioHang, FE_gioHangForm);
				refresh();
				selectDiachi();
			} else {
				scene = 4;
				setChuyenTrang(FE_btnHoTro, FE_hoTroForm);
//				Platform.runLater(() -> {
					try {
						chatService = new ChatService();
						chatService.setupUserQueue(username, (consumerTag, delivery) -> {
							String msg = new String(delivery.getBody(), "UTF-8");
							Platform.runLater(() -> {
								addMessageToChatBox(msg, false);
								Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), ae -> scrollpaneChat.setVvalue(1.0)));
							    timeline.play();
							});
						});
						loadChatHistory();

						Stage stage = (Stage) FE_DangNhapForm.getScene().getWindow();
						stage.setOnCloseRequest(ev -> {
							try {
								stopRabbitMQ();
								System.out.println("Queue của user " + username + " đã được xóa khi đóng scene.");
								connect = DataBaseConnect.getConnection();
								String sqlUpdate = "update accounts set status = 0 where username = ?";
								prepare = connect.prepareStatement(sqlUpdate);
								prepare.setString(1, username);
								int check = prepare.executeUpdate();
								if(check > 0) {
									System.out.println("Cập nhật trạng thái xuất thành công cho user: "+ username);
								}else {
									System.out.println("Lỗi khi cập nhật trạng thái đăng nhập");
								}
								DataBaseConnect.closeConnection(connect);
							} catch (Exception e) {
								e.printStackTrace();
							}
						});
					} catch (Exception e) {
						e.printStackTrace();
					}
//				});
			}

		}
	}
	
	//TODO Chức năng ẩn hiện menu
	private double step = 0.1455;
	private boolean isMenuVisible = true;

	public void HandelMenu(ActionEvent event) {
		if (menuBox == null || centerContent == null)
			return;
		double menuWidth = menuBox.getWidth();
		double centerWidth = centerContent.getWidth();
		Stage stage = (Stage) centerContent.getScene().getWindow();
		if (isMenuVisible) {
			scrollpaneBanChayNhat.setHvalue(0.0);
			if ((stage.isFullScreen() || stage.isMaximized())) {
				FE_trangChuFlowPane.setVgap(15);
				FE_trangChuFlowPane.setHgap(15);
				step = 0.1455 * 1.9;
			} else {
				FE_trangChuFlowPane.setVgap(20);
				FE_trangChuFlowPane.setHgap(20);
				step = 0.1455 * 1.17;
			}
			TranslateTransition hideMenu = new TranslateTransition(Duration.seconds(0.5), menuBox);
			hideMenu.setToX(-menuWidth);
			hideMenu.setOnFinished(e -> FE_DangNhapForm.setLeft(null));
			Timeline expandCenter = new Timeline(new KeyFrame(Duration.seconds(0.5),
					new KeyValue(centerContent.prefWidthProperty(), centerWidth + menuWidth)));

			ParallelTransition parallelTransition = new ParallelTransition(hideMenu, expandCenter);
			parallelTransition.play();

			isMenuVisible = false;
		} else {
			scrollpaneBanChayNhat.setHvalue(0.0);
			FE_DangNhapForm.setLeft(menuBox);
			TranslateTransition showMenu = new TranslateTransition(Duration.seconds(0.5), menuBox);
			showMenu.setToX(0);

			Timeline shrinkCenter = new Timeline(new KeyFrame(Duration.seconds(0.5),
					new KeyValue(centerContent.prefWidthProperty(), centerWidth - menuWidth)));

			ParallelTransition parallelTransition = new ParallelTransition(showMenu, shrinkCenter);
			parallelTransition.play();
			FE_trangChuFlowPane.setVgap(10);
			FE_trangChuFlowPane.setHgap(10);
			if ((stage.isFullScreen() || stage.isMaximized())) {
				step = 0.1455 * 1.5;
			} else {
				step = 0.1455;
			}
			isMenuVisible = true;
		}
	}
	// Hàm thiết lập chức năng cho các nút "Xem chi tiết"
	public void setButtonDetail() {
		for (CardBookController controller : cardControllers) {
			Button btn = controller.getBookDetailButton();
			btn.setOnAction(event -> {
				selectedBook = controller.getBook();
				showBookDetail(selectedBook);
			});
		}
	}
	
	//TODO Chức năng tìm kiếm
	public void handelGenreButton(ActionEvent e) {
		hBoxSapXep.setVisible(false);
		if (e.getSource() == FE_textFeildSearch) {
			String textSearh = FE_textFeildSearch.getText();
			FE_titelTextSP.setText("Danh sách truyện: '" + textSearh + "'");
			menuDisplayCard(textSearh);
			
			btn_homeBack1.setVisible(true);
		} else {
			Button clickedButton = (Button) e.getSource();
			String btnText = clickedButton.getText();
			FE_titelTextSP.setText("Danh sách truyện: '" + btnText + "'");
			menuDisplayCard(btnText);
			btn_homeBack1.setVisible(true);
		}
		setButtonDetail();
		setQuantity();
		stopRabbitMQ();
		if(scrollpaneTrangChu != null) {
			VvalueTruoc = scrollpaneTrangChu.getVvalue();
		}
		
		setChuyenTrang(FE_btnSanPham, FE_sanPhamForm);
	}

	public void handelGenreButtonForMouse(MouseEvent e) {
		hBoxSapXep.setVisible(false);
		String textSearh = FE_textFeildSearch.getText();
		FE_titelTextSP.setText("Danh sách truyện: '" + textSearh + "'");
		menuDisplayCard(textSearh);
		setButtonDetail();
		setQuantity();
		if(scrollpaneTrangChu != null) {
			VvalueTruoc = scrollpaneTrangChu.getVvalue();
		}
		setChuyenTrang(FE_btnSanPham, FE_sanPhamForm);
		btn_homeBack1.setVisible(true);
		stopRabbitMQ();
	}
	
	public ObservableList<Book> menuGetData(String s) {
		ObservableList<Book> listData = FXCollections.observableArrayList();
		String sql = "SELECT * FROM books WHERE (genre like ? or name like ? or author like ?) and status = 1";
		connect = DataBaseConnect.getConnection();
		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, "%" + s + "%");
			prepare.setString(2, "%" + s + "%");
			prepare.setString(3, "%" + s + "%");
			result = prepare.executeQuery();
			while (result.next()) {
				Book book = new Book(result.getInt("id_auto"), result.getString("id"), result.getString("image"),
						result.getString("name"),result.getDouble("price"));
				listData.add(book);
			}
			DataBaseConnect.closeConnection(connect);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listData;
	}

	

	public void menuDisplayCard(String s) {
		cardListData.clear();
		cardListData.addAll(menuGetData(s));
		int totalPage = (int) Math.ceil((double) cardListData.size() / 24);
		pagination.setPageCount(totalPage);
		FE_trangChuFlowPane.getChildren().clear();
		pagination.setPageFactory(pageIndex -> {
		    updatePage(pageIndex);
		    setButtonDetail();
		    return new VBox();
		});
	}
	
	
	
	//TODO chức năng chỉnh sửa thông tin khách hàng
	
	public void switchLuuThongTin() {
		HboxLuuThongTin.setVisible(true);
		HboxChinhSuaThongTin.setVisible(false);
		VboxThongTinTaiKhoan.setMouseTransparent(false);
	}
	
	private void setXacThucEmail() {
		emailText.setOnMouseClicked(event -> {
	        Stage primaryStage = (Stage) emailText.getScene().getWindow();
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
	        				emailText.setText(email);
	        				
	        			}
					} catch (Exception e) {
					}
	            });
	        } catch (IOException | GeneralSecurityException e) {
	            e.printStackTrace();
	        }
	    });
	}
	
	public void getThongTinTaiKhoan() {
		ObservableList<String> danhSachNganHang = FXCollections.observableArrayList("Chọn ngân hàng", "Vietcombank",
				"BIDV", "Techcombank", "Sacombank", "ACB", "MB Bank", "VIB", "VPBank");
		NganHangComboBox.setItems(danhSachNganHang);
		NganHangComboBox.setPromptText("Chọn ngân hàng");
		NganHangComboBox.setCellFactory(lv -> new ListCell<String>() {
			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText(null);
				} else {
					setText(item);
					if ("Chọn ngân hàng".equals(item)) {
						setStyle("-fx-text-fill: gray;");
					} else {
						setStyle("");
					}
				}
			}
		});

		String sql = "select * from accounts where username = ?";
		connect = DataBaseConnect.getConnection();
		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, username);
			result = prepare.executeQuery();
			if (result.next()) {
				fullnameText.setText(result.getString("fullname"));
				emailText.setText(result.getString("email"));
				sdtText.setText(result.getString("phone"));
				diachigiaohangText.setText(result.getString("address"));
				if (result.getString("typeBank").isEmpty()) {
					NganHangComboBox.setPromptText("Chọn ngân hàng");
				} else {
					NganHangComboBox.setValue(result.getString("typeBank"));
				}

				soTKNganHangText.setText(result.getString("numberBank"));
			}
		} catch (Exception e) {
		}
		DataBaseConnect.closeConnection(connect);
	}

	// Hàm kiểm tra email hợp lệ bằng Regex
	private boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		return email.matches(emailRegex);
	}

	// Hàm kiểm tra số điện thoại hợp lệ bằng Regex
	private boolean isValidPhone(String phone) {
		String phoneRegex = "^(0[0-9]{9,10})$";
		return phone.matches(phoneRegex);
	}

	// Hàm kiểm tra số tài khoản ngân hàng hợp lệ bằng Regex
	private boolean isValidBankNumber(String numberBank) {
		String bankNumberRegex = "^[0-9]{8,16}$";
		return numberBank.matches(bankNumberRegex);
	}

	public void addressSelectTTCaNhan(MouseEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AddressSelection.fxml"));
		try {
			Parent root = loader.load();
			Stage stage = new Stage();
			stage.setTitle("Thiết lập Địa Chỉ Giao Hàng");
			stage.setScene(new Scene(root));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setResizable(false);
			stage.showAndWait();

			AddressSelectionController controller = loader.getController();
			String selectedAddress = controller.getSelectedAddress();
			diachigiaohangText.setText(selectedAddress);
//	        if(!addressText.getText().equalsIgnoreCase("")) {
//	        	startcheck.setText("");
//	        }else {
//	        	startcheck.setText("*");
//	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setThongTinTaiKhoan() {
		AlertMessage alert = new AlertMessage();
		String fullname = fullnameText.getText();
		String email = emailText.getText();
		String phone = sdtText.getText();
		String address = diachigiaohangText.getText();
		String typeBank = NganHangComboBox.getValue();
		String numberBank = soTKNganHangText.getText();
		if (fullname.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || typeBank == null
				|| typeBank.isEmpty() || numberBank.isEmpty()) {
			alert.errorMessage("Vui lòng nhập đầy đủ thông tin!");
			return;
		}

		if (!isValidEmail(email)) {
			alert.errorMessage("Email không đúng định dạng");
			return;
		}
		if (!isValidPhone(phone)) {
			alert.errorMessage("Số điện thoại không đúng định dạng");
			return;
		}
		if (NganHangComboBox.getValue().equals("Chọn ngân hàng")) {
			alert.errorMessage("Vui lòng chọn loại ngân hàng bạn đang sử dụng");
			return;
		}

		if (!isValidBankNumber(numberBank)) {
			alert.errorMessage("Số tài khoản ngân hàng không đúng định dạng");
			return;
		}
		String sql = "UPDATE accounts SET fullname = ?, email = ?, phone = ?, "
				+ "address = ?, typeBank = ?, numberBank = ? WHERE username = ?";
		connect = DataBaseConnect.getConnection();
		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, fullname);
			prepare.setString(2, email);
			prepare.setString(3, phone);
			prepare.setString(4, address);
			prepare.setString(5, typeBank);
			prepare.setString(6, numberBank);
			prepare.setString(7, username);
			int checkUpdate = prepare.executeUpdate();
			if (checkUpdate > 0) {
				alert.successMessage("Cập nhật thông tin thành công!");
				VboxThongTinTaiKhoan.setMouseTransparent(true);
				HboxChinhSuaThongTin.setVisible(true);
				HboxLuuThongTin.setVisible(false);
				FE_nameTextAccount.setText(fullname);
			} else {
				alert.errorMessage("Không tìm thấy tài khoản để cập nhật.");
			}
		} catch (Exception e) {
			alert.errorMessage("Cột nào đó có thể bị trùng");
		}
		DataBaseConnect.closeConnection(connect);
	}

	public void resetThongTinTaiKhoan() {
		fullnameText.setText("");
		emailText.setText("");
		sdtText.setText("");
		diachigiaohangText.setText("");
		NganHangComboBox.setValue("Chọn ngân hàng");
		soTKNganHangText.setText("");
	}
	
	@SuppressWarnings("unchecked")
	public void showDonHangByUser() {
	    ObservableList<DonHang> donHangList = FXCollections.observableArrayList();

	    String sql = "SELECT * FROM donhang WHERE nguoiMua = ?";
	    connect = DataBaseConnect.getConnection();

	    try {
	        prepare = connect.prepareStatement(sql);
	        prepare.setString(1, username);

	        result = prepare.executeQuery();
	        while (result.next()) {
	            int id = result.getInt("Id");
	            double tongTien = result.getDouble("tongtienhang");
	            double phivanchuyen = result.getDouble("phivanchuyen");
	            double voucher = result.getDouble("voucher");
	            double thanhTien = result.getDouble("thanhtien");
	            String hinhThucTT = result.getString("hinhthucthanhtoan");
	            String diachi = result.getString("diachi");
	            Timestamp thoiGianDatHang = result.getTimestamp("thoigiandathang");
	            String formattedTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(thoiGianDatHang);

	            donHangList.add(new DonHang(id, tongTien, phivanchuyen, voucher, thanhTien, hinhThucTT, formattedTime,diachi));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DataBaseConnect.closeConnection(connect);
	    }

	    TableView<DonHang> tableView = new TableView<>(donHangList);
	    tableView.setPrefSize(850, 500);

	    TableColumn<DonHang, Number> idCol = new TableColumn<>("ID");
	    idCol.setCellValueFactory(data -> data.getValue().idProperty());

	    TableColumn<DonHang, Number> tongTienCol = new TableColumn<>("Tổng");
	    tongTienCol.setCellValueFactory(data -> data.getValue().tongTienProperty());

	    TableColumn<DonHang, Number> phiVCCol = new TableColumn<>("Phí VC");
	    phiVCCol.setCellValueFactory(data -> data.getValue().phiVanChuyenProperty());

	    TableColumn<DonHang, Number> voucherCol = new TableColumn<>("Voucher");
	    voucherCol.setCellValueFactory(data -> data.getValue().voucherProperty());

	    TableColumn<DonHang, Number> thanhTienCol = new TableColumn<>("Thành tiền");
	    thanhTienCol.setCellValueFactory(data -> data.getValue().thanhTienProperty());

	    TableColumn<DonHang, String> ttCol = new TableColumn<>("Thanh toán");
	    ttCol.setCellValueFactory(data -> data.getValue().hinhThucTTProperty());

	    TableColumn<DonHang, String> ngayCol = new TableColumn<>("Ngày đặt");
	    ngayCol.setCellValueFactory(data -> data.getValue().ngayDatProperty());
	    
	    TableColumn<DonHang, String> dcCol = new TableColumn<>("Địa chỉ");
	    dcCol.setCellValueFactory(data -> data.getValue().diaChiProperty());

	    tableView.getColumns().addAll(idCol, tongTienCol, phiVCCol, voucherCol, thanhTienCol, ttCol, ngayCol,dcCol);

	    // Xử lý double-click
	    tableView.setRowFactory(tv -> {
	        TableRow<DonHang> row = new TableRow<>();
	        row.setOnMouseClicked(event -> {
	            if (!row.isEmpty() && event.getClickCount() == 2) {
	                DonHang selected = row.getItem();
	                showChiTietDonHang(selected.getId());
	            }
	        });
	        return row;
	    });

	    Dialog<ButtonType> dialog = new Dialog<>();
	    dialog.setTitle("Danh sách đơn hàng của " + username);
	    dialog.setHeaderText("Danh sách đơn hàng đã đặt:");
	    dialog.getDialogPane().setContent(tableView);
	    dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

	    dialog.showAndWait();
	}


	// Hiển thị chi tiết đơn hàng
	private void showChiTietDonHang(int orderId) {
	    ObservableList<String> chiTietList = FXCollections.observableArrayList();
	    String sql = "SELECT * FROM chitietdonhang WHERE gioHangId = ?";

	    connect = DataBaseConnect.getConnection();
	    try {
	        prepare = connect.prepareStatement(sql);
	        prepare.setInt(1, orderId);
	        result = prepare.executeQuery();

	        while (result.next()) {
	            String sanPham = result.getString("sanPham");
	            int soLuong = result.getInt("soLuong");
	            double gia = result.getDouble("gia");
	            String loaiSach = result.getString("loaisach");

	            String chiTiet = "Sản phẩm: " + sanPham + " | Số lượng: " + soLuong + 
	                             " | Giá: " + gia + " | Loại sách: " + loaiSach;
	            chiTietList.add(chiTiet);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DataBaseConnect.closeConnection(connect);
	    }

	    // Hiển thị danh sách chi tiết
	    ListView<String> listView = new ListView<>(chiTietList);
	    listView.setPrefSize(600, 400);

	    Dialog<ButtonType> dialog = new Dialog<>();
	    dialog.setTitle("Chi tiết đơn hàng");
	    dialog.setHeaderText("Thông tin chi tiết đơn hàng ID: " + orderId);
	    dialog.getDialogPane().setContent(listView);
	    dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

	    dialog.showAndWait();
	}
	
	public boolean isValidPassword(String password) {
		String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
		Pattern pattern = Pattern.compile(passwordRegex);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
	
	public void doiMatKhau() {
		AlertMessage alert = new AlertMessage();
	    Dialog<ButtonType> dialog = new Dialog<>();
	    dialog.setTitle("Đổi Mật Khẩu");
	    dialog.setHeaderText("Nhập thông tin để đổi mật khẩu");

	    // Tạo các ô nhập dữ liệu
	    PasswordField oldPasswordField = new PasswordField();
	    oldPasswordField.setPromptText("Nhập mật khẩu cũ");

	    PasswordField newPasswordField = new PasswordField();
	    newPasswordField.setPromptText("Nhập mật khẩu mới");

	    PasswordField confirmPasswordField = new PasswordField();
	    confirmPasswordField.setPromptText("Xác nhận mật khẩu mới");

	    VBox layout = new VBox(10);
	    layout.getChildren().addAll(new Label("Mật khẩu cũ:"), oldPasswordField,
	                                new Label("Mật khẩu mới:"), newPasswordField,
	                                new Label("Xác nhận mật khẩu mới:"), confirmPasswordField);
	    dialog.getDialogPane().setContent(layout);

	    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

	    // Xử lý sự kiện khi nhấn OK
	    dialog.setResultConverter(button -> {
	        if (button == ButtonType.OK) {
	            String oldPassword = oldPasswordField.getText();
	            String newPassword = newPasswordField.getText();
	            String confirmPassword = confirmPasswordField.getText();

	            if (!checkOldPassword(username, oldPassword)) {
	            	alert.errorMessage("Sai mật khẩu cũ!");
	                return null;
	            }
	            
	            if(!isValidPassword(newPassword)) {
	            	alert.errorMessage("Mật khẩu chưa đủ mạnh!");
	                return null;
	            }

	            if (!newPassword.equals(confirmPassword)) {
	            	alert.errorMessage("Mật khẩu xác nhận không khớp!");
	                return null;
	            }

	            // Cập nhật mật khẩu mới
	            if (updatePassword(username, newPassword)) {
	            	alert.successMessage("Đổi mật khẩu thành công!");
	            } else {
	            	alert.errorMessage("Có lỗi xảy ra, vui lòng thử lại!");
	            }
	        }
	        return null;
	    });

	    dialog.showAndWait();
	}
	
	private boolean checkOldPassword(String username, String oldPassword) {
	    String sql = "SELECT password FROM accounts WHERE username = ?";
	    try (Connection connect = DataBaseConnect.getConnection();
	         PreparedStatement prepare = connect.prepareStatement(sql)) {
	        prepare.setString(1, username);
	        ResultSet result = prepare.executeQuery();
	        
	        if (result.next()) {
	            String storedPassword = result.getString("password");
	            
	            return BCrypt.checkpw(oldPassword, storedPassword);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	private boolean updatePassword(String username, String newPassword) {
	    String sql = "UPDATE accounts SET password = ? WHERE username = ?";
	    try (Connection connect = DataBaseConnect.getConnection();
	         PreparedStatement prepare = connect.prepareStatement(sql)) {
	    	String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
	        prepare.setString(1, hashedPassword);
	        prepare.setString(2, username);
	        
	        int rowsUpdated = prepare.executeUpdate();
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	//TODO TRANG CHỦ
	//hàm hiển thị trang chi tiết khi nhấn vào top bán chạy nhất
	public void showDetailTrend(ActionEvent event) {
		String sql = "select * from books where name = ? and status = 1";
		connect = DataBaseConnect.getConnection();
		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, ((Button) event.getSource()).getText());
			result = prepare.executeQuery();
			Book book = new Book();
			if (result.next()) {
				book = new Book(result.getInt("id_auto"), result.getString("id"), result.getString("image"),
						result.getString("name"), result.getString("author"), result.getString("genre"),
						result.getDouble("price"), result.getInt("stock"), result.getInt("pub_year"),
						result.getString("des"));
				String path = getClass().getResource(book.getImage()).toExternalForm();
//				String path = "file:" + book.getImage();
				Image image = new Image(path, 205, 294, false, true);
				FE_chiTiet_nameText.setText(book.getName());
				FE_chiTiet_authorText.setText(book.getAuthor());
				FE_chiTiet_genreText.setText(book.getGenre());
				FE_chiTiet_priceText.setText(df.format(book.getPrice()));
				FE_chiTiet_pubYearText.setText(String.valueOf(book.getPub_year()));
				FE_chiTiet_moTaText.setText(book.getDes());
				FE_chiTiet_imageView.setImage(image);

				menuDisplayCardChiTiet(book.getName());
				setChuyenTrang(FE_btnSanPham, FE_chiTietForm);
				TgBtn_LoaiSachGiay.setSelected(true);
				TgBtn_LoaiSachGiay.setMouseTransparent(true);
				TgBtn_LoaiSachDienTu.setMouseTransparent(false);
				setBtgButton();
				if (!TgBtn_LoaiSachGiay.isSelected()) {
					TgBtn_LoaiSachGiay.setSelected(true);
				}
				FE_chiTiet_spinnerQuantity.setDisable(false);
				Platform.runLater(() -> originalPaperBookPrice = Double
						.parseDouble(FE_chiTiet_priceText.getText().replaceAll("[,.]", "")));
			}
			DataBaseConnect.closeConnection(connect);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//chức năng scroll và tự scroll bán chạy nhất TRANG CHỦ
		private boolean isScrolling = false;
		public void scrollRight() {
			if (isScrolling)
				return;

			double currentValue = scrollpaneBanChayNhat.getHvalue();
			double newValue = currentValue + step;
			if (newValue > 1.0)
				newValue = 0; // Quay về đầu khi đến cuối
			animateScroll(currentValue, newValue);
		}

		public void scrollLeft() {
			if (isScrolling)
				return;

			double currentValue = scrollpaneBanChayNhat.getHvalue();
			double newValue = currentValue - step;
			if (newValue < 0)
				newValue = 1.0; // Quay về cuối khi đến đầu
			animateScroll(currentValue, newValue);
		}

		private void animateScroll(double from, double to) {
			isScrolling = true;
			Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5),
					new KeyValue(scrollpaneBanChayNhat.hvalueProperty(), to, Interpolator.EASE_BOTH)));
			timeline.setOnFinished(e -> isScrolling = false);
			timeline.play();
		}

		private Timeline autoScrollTimeline;

		private void startAutoScroll() {
			autoScrollTimeline = new Timeline(new KeyFrame(Duration.seconds(5), e -> scrollRight()));
			autoScrollTimeline.setCycleCount(Animation.INDEFINITE);
			autoScrollTimeline.play();
		}
	
	//TODO TRANG SẢN PHẨM
	//hàm lấy
	public ObservableList<Book> menuGetData() {
		ObservableList<Book> listData = FXCollections.observableArrayList();
		String sql = "select * from books where status = 1";
		connect = DataBaseConnect.getConnection();
		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			Book book;
			while (result.next()) {
				book = new Book(result.getInt("id_auto"), result.getString("id"), result.getString("image"),
						result.getString("name"), result.getDouble("price"));
				listData.add(book);
			}
			DataBaseConnect.closeConnection(connect);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listData;
	}
	//hàm hiển thị
	public void menuDisplayCard() {
		cardListData.clear();
		cardListData.addAll(menuGetData());
		int totalPage = (int) Math.ceil((double) cardListData.size() / 24);
		pagination.setPageCount(totalPage);
		pagination.setPageFactory(pageIndex -> {
		    updatePage(pageIndex);
		    setButtonDetail();
		    return new VBox();
		});
	}

	// Hàm chia số lượng item tối đa trong trang
	private void updatePage(int pageIndex) {
		int fromIndex = pageIndex * 24;
		int toIndex = Math.min(fromIndex + 24, cardListData.size());

		List<Book> pageData = cardListData.subList(fromIndex, toIndex);
		cardControllers.clear();
		FE_trangChuFlowPane.getChildren().clear();
		for (Book book : pageData) {
			try {
				FXMLLoader load = new FXMLLoader(getClass().getResource("CardBook.fxml"));
				VBox box = load.load();
				CardBookController cardC = load.getController();
				cardC.setData(book);
				cardC.setFrontEndController(this);
				cardControllers.add(cardC);
				FE_trangChuFlowPane.getChildren().add(box);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (FE_trangChuFlowPane.getChildren().isEmpty()) {
			FE_trangChuFlowPane.getChildren().add(new Label("Không tìm thấy"));
			pagination.setPageCount(1);
		}
	}
	
	//hàm capNhatGiaoDienTrangSanPham
	public void capNhatGiaoDienTrangSanPham() {
		centerContent.sceneProperty().addListener((obs, oldScene, newScene) -> {
			if (newScene != null) {
				Platform.runLater(() -> {
					Stage stage = (Stage) newScene.getWindow();
					if (stage != null) {
						stage.fullScreenProperty().addListener((obsFull, oldFull, isFullScreen) -> {
							scrollpaneBanChayNhat.setHvalue(0.0);
							if (isFullScreen && !isMenuVisible) {
								FE_trangChuFlowPane.setHgap(15);
								FE_trangChuFlowPane.setVgap(15);
								step = 0.1455 * 1.9;
							} else if (!isFullScreen && !isMenuVisible) {
								FE_trangChuFlowPane.setHgap(20);
								FE_trangChuFlowPane.setVgap(20);
								step = 0.1455 * 1.17;
							} else if (isMenuVisible && isFullScreen) {
								
								step = 0.1455 * 1.5;
							} else if (isMenuVisible && !isFullScreen) {
								step = 0.1455 * 1.17;
							}
						});
						stage.maximizedProperty().addListener((obsMax, oldMax, isMaximized) -> {
							scrollpaneBanChayNhat.setHvalue(0.0);
							if (isMaximized && !isMenuVisible) {
								FE_trangChuFlowPane.setHgap(15);
								FE_trangChuFlowPane.setVgap(15);
								step = 0.1455 * 1.9;
							} else if (!isMaximized && !isMenuVisible) {
								FE_trangChuFlowPane.setHgap(20);
								FE_trangChuFlowPane.setVgap(20);
								step = 0.1455;
							} else if (isMenuVisible && isMaximized) {
								step = 0.1455 * 1.5;
							} else if (isMenuVisible && !isMaximized) {
								step = 0.1455;
							}
						});
					}
				});
			}
		});
	}
	
	//TODO TRANG CHI TIẾT SÁCH
	public void setBtgButton() {
		TgBtn_LoaiSachGiay.setOnAction(event -> {
		    if (TgBtn_LoaiSachGiay.isSelected()) {
		    	TgBtn_LoaiSachGiay.setMouseTransparent(true);
		    	TgBtn_LoaiSachDienTu.setMouseTransparent(false);
		    	FE_chiTiet_spinnerQuantity.setDisable(false);
		    }
		});

		TgBtn_LoaiSachDienTu.setOnAction(event -> {
		    if (TgBtn_LoaiSachDienTu.isSelected()) {
		    	TgBtn_LoaiSachDienTu.setMouseTransparent(true);
		    	TgBtn_LoaiSachGiay.setMouseTransparent(false);
		    	SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
				FE_chiTiet_spinnerQuantity.setValueFactory(valueFactory);
				FE_chiTiet_spinnerQuantity.setDisable(true);
		    }
		});
	}
	// hàm lây sách từ csdl để hiện thị các sản phẩm cùng series
	public ObservableList<Book> menuGetDataChiTiet(String s) {
		ObservableList<Book> listData = FXCollections.observableArrayList();
		String sql = "SELECT * FROM books WHERE name like ? and name != ? and status = 1";
		connect = DataBaseConnect.getConnection();
		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, "%" + s.substring(0, s.length() - 2) + "%");
			prepare.setString(2, s);
			result = prepare.executeQuery();
			while (result.next()) {
				Book book = new Book(result.getInt("id_auto"), result.getString("id"), result.getString("image"),
						result.getString("name"), result.getDouble("price"));
				listData.add(book);
			}
			DataBaseConnect.closeConnection(connect);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listData;
	}
	//hàm hiện thị các sản phẩm cùng series
	public void menuDisplayCardChiTiet(String s) {
		cardListData.clear();
		cardListData.addAll(menuGetDataChiTiet(s));
		flowpane_chiTiet.getChildren().clear();
		cardControllers.clear();
		for (int i = 0; i < cardListData.size(); i++) {
			FXMLLoader load = new FXMLLoader(getClass().getResource("CardBook.fxml"));
			try {
				VBox box = load.load();
				CardBookController cardC = load.getController();
				cardC.setData(cardListData.get(i));
				cardC.setFrontEndController(this);
				// Thêm controller vào danh sách để sử dụng sau này
				cardControllers.add(cardC);
				flowpane_chiTiet.getChildren().add(box);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		setButtonDetail();
		if (flowpane_chiTiet.getChildren().isEmpty()) {
			flowpane_chiTiet.getChildren().add(new Label("Không tìm thấy"));
		}
	}

	//hàm hiển thị trang CHI TIET SAN PHAM
	public void showBookDetail(Book book) {
		if (book != null) {
			String sql = "select * from books where id = ? and status = 1";
			connect = DataBaseConnect.getConnection();
			try {
				prepare = connect.prepareStatement(sql);
				prepare.setString(1, book.getId());
				result = prepare.executeQuery();
				if (result.next()) {
					book = new Book(result.getInt("id_auto"), result.getString("id"), result.getString("image"),
							result.getString("name"), result.getString("author"), result.getString("genre"),
							result.getDouble("price"), result.getInt("stock"), result.getInt("pub_year"),
							result.getString("des"));
				}
				DataBaseConnect.closeConnection(connect);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String path = getClass().getResource(book.getImage()).toExternalForm();
//			String path = "file:" + book.getImage();
			Image image = new Image(path, 205, 294, false, true);
			FE_chiTiet_imageView.setImage(image);
			FE_chiTiet_nameText.setText(book.getName());
			FE_chiTiet_authorText.setText(book.getAuthor());
			FE_chiTiet_genreText.setText(book.getGenre());

			FE_chiTiet_priceText.setText(df.format(book.getPrice()));
			FE_chiTiet_pubYearText.setText(String.valueOf(book.getPub_year()));
			FE_chiTiet_moTaText.setText(book.getDes());
			

			menuDisplayCardChiTiet(book.getName());
//			pagination.setVisible(false);
			VvalueTruoc = scrollpaneSanPham.getVvalue();
			setChuyenTrang(FE_btnSanPham, FE_chiTietForm);
			TgBtn_LoaiSachGiay.setSelected(true);
			TgBtn_LoaiSachGiay.setMouseTransparent(true);
			TgBtn_LoaiSachDienTu.setMouseTransparent(false);
			setBtgButton();
			if (!TgBtn_LoaiSachGiay.isSelected()) {
				TgBtn_LoaiSachGiay.setSelected(true);
			}
			FE_chiTiet_spinnerQuantity.setDisable(false);
			Platform.runLater(() -> originalPaperBookPrice = Double
					.parseDouble(FE_chiTiet_priceText.getText().replaceAll("[,.]", "")));
		}
	}
	//hàm thiết lập spinnerQuantity cho trang chi tiết
	public void setQuantity() {
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
		FE_chiTiet_spinnerQuantity.setValueFactory(valueFactory);
		FE_chiTiet_spinnerQuantity.setEditable(true);
		FE_chiTiet_spinnerQuantity.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			try {
				int value = Integer.parseInt(newValue);
				if (value < 1) {
					FE_chiTiet_spinnerQuantity.getValueFactory().setValue(1);
				} else if (value > 100) {
					FE_chiTiet_spinnerQuantity.getValueFactory().setValue(100);
				}
			} catch (NumberFormatException e) {
				FE_chiTiet_spinnerQuantity.getValueFactory().setValue(1);
			}
		});
	}
	
	//TODO TRANG GIỎ HÀNG
	//thiết lập địa chỉ có sẵn
	private void selectDiachi() {
		String sql = "select * from accounts where username = ?";
		connect = DataBaseConnect.getConnection();
		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, username);
			result = prepare.executeQuery();
			if(result.next()) {
				addressText.setText(result.getString("address"));
				if(!addressText.getText().isEmpty()) {
					startcheck.setText("");
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		DataBaseConnect.closeConnection(connect);
	}
	//Chức năng thêm sách vào giỏ hàng
	private List<CartCardController> cartCardController = new ArrayList<>();
	public void addItemCard(ActionEvent event) {
		int rs = 0;
		connect = DataBaseConnect.getConnection();
		AlertMessage alertM = new AlertMessage();
		try {
			String name = FE_chiTiet_nameText.getText();
			
			
			String loaisach = "";
			if (TgBtn_LoaiSachGiay.isSelected()) {
				loaisach = "Sách giấy";
			} else loaisach = "Sách điện tử";
			
			if(loaisach.equals("Sách điện tử")) {
				String kiemtra = "Select * from libraries where name = ? and of_username = ?";
				prepare = connect.prepareStatement(kiemtra);
				prepare.setString(1, name);
				prepare.setString(2, username);
				ResultSet kq = prepare.executeQuery();
				if(kq.next()) {
					alertM.errorMessage("Bản sách điện tử này đã tồn tại trong thư viện của bạn");
					return;
				}
			}
				
			int quantity = FE_chiTiet_spinnerQuantity.getValue();
			double price = Double.parseDouble(FE_chiTiet_priceText.getText().replaceAll("[,.]", ""));
			
			ObservableList<Cart> listData = FXCollections.observableArrayList();
			listData = menuCartGetData();
			
			for (Cart cart : listData) {
				if (cart.getName().equalsIgnoreCase(name) && cart.getLoaisach().equalsIgnoreCase(loaisach)) {
					String sql = "update cart set quantity = ? where  name = ? and loaisach = ? and of_fullname = ?";
					connect = DataBaseConnect.getConnection();
					prepare = connect.prepareStatement(sql);
					if (cart.getLoaisach().equalsIgnoreCase("Sách điện tử")) {
						prepare.setInt(1, 1);
					} else
						prepare.setInt(1, quantity + cart.getQuantity());

					prepare.setString(2, cart.getName());
					prepare.setString(3, cart.getLoaisach());
					prepare.setString(4, cart.getFullname());
					rs = prepare.executeUpdate();
					
					if (rs != 0) {
						alertM.successMessage("Cập nhật số lượng giỏ hàng thành công");

						menuCartDisplayCard();

						Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
						alert.setTitle("Xác nhận chuyển trang");
						alert.setHeaderText("Bạn có chắc muốn chuyển trang không?");
						ButtonType buttonYes = new ButtonType("Xác nhận", ButtonBar.ButtonData.OK_DONE);
						ButtonType buttonNo = new ButtonType("Hủy", ButtonBar.ButtonData.CANCEL_CLOSE);
						alert.getButtonTypes().setAll(buttonYes, buttonNo);
						alert.showAndWait().ifPresent(response -> {
							if (response == buttonYes) {
								setChuyenTrang(FE_btnGioHang, FE_gioHangForm);
								refresh();
								selectDiachi();
							}
						});
						return;
					}
				}
			}

			connect = DataBaseConnect.getConnection();

			String sql = "insert into cart (name,price, quantity, of_fullname, selected, loaisach) values (?,?,?,?,?,?)";
			try {
				prepare = connect.prepareStatement(sql);
				prepare.setString(1, name);
				prepare.setDouble(2, price);
				prepare.setInt(3, quantity);
				prepare.setString(4, username);
				prepare.setBoolean(5, true);
				prepare.setString(6, loaisach);
				rs = prepare.executeUpdate();
				DataBaseConnect.closeConnection(connect);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (rs != 0) {
				alertM.successMessage("Thêm giỏ hàng thành công");
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Xác nhận chuyển trang");
				alert.setHeaderText("Bạn có chắc muốn chuyển trang không?");
				ButtonType buttonYes = new ButtonType("Xác nhận", ButtonBar.ButtonData.OK_DONE);
				ButtonType buttonNo = new ButtonType("Hủy", ButtonBar.ButtonData.CANCEL_CLOSE);
				alert.getButtonTypes().setAll(buttonYes, buttonNo);
				alert.showAndWait().ifPresent(response -> {
					if (response == buttonYes) {
						setChuyenTrang(FE_btnGioHang, FE_gioHangForm);
						refresh();
						selectDiachi();
					}
				});
				menuCartDisplayCard();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DataBaseConnect.closeConnection(connect);
	}
	// Hàm lấy giỏ hàng theo username từ csdl
	public ObservableList<Cart> menuCartGetData() {
		ObservableList<Cart> listData = FXCollections.observableArrayList();
		String sql = "select * from cart where of_fullname = ?";
		connect = DataBaseConnect.getConnection();
		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, username);
			result = prepare.executeQuery();
			Cart cart;
			while (result.next()) {
				cart = new Cart(result.getString("name"), result.getDouble("price"), result.getInt("quantity"),
						result.getString("of_fullname"), result.getBoolean("selected"), result.getString("loaisach"));
				listData.add(cart);
			}
			DataBaseConnect.closeConnection(connect);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listData;
	}
	
	// hàm hiển thị item lên giỏ hàng theo username
	public void menuCartDisplayCard() {
		cartListData.clear();
		cartListData.addAll(menuCartGetData());
		CartList.getChildren().clear();
		cartCardController.clear();
		boolean isSachDienTuFull = true;
		int save = 0;
		int i;
		for (i = 0; i < cartListData.size(); i++) {
			FXMLLoader load = new FXMLLoader(getClass().getResource("CardCart.fxml"));
			try {
				HBox box = load.load();
				CartCardController cardC = load.getController();
				cardC.setData(cartListData.get(i));
				if (cartListData.get(i).getLoaisach().equalsIgnoreCase("Sách giấy")) {
					isSachDienTuFull = false;
				}
				if (cartListData.get(i).isSelected()) {
					save += cartListData.get(i).getQuantity();
				}
				cardC.setFrontEndController(this);
				cartCardController.add(cardC);
				CartList.getChildren().add(box);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		totalQuantityAllText.setText(String.valueOf(save));
		hboxChonDiaChi.setDisable(isSachDienTuFull);
		hboxChonVanChuyen.setDisable(isSachDienTuFull);
		if(hboxChonVanChuyen.isDisable()) {
			loaivanchuyenText.setText("");
			priceShippingText.setText("0");
		}
		if (!radioBtn_Bank.isSelected()) {
			radioBtn_Bank.setSelected(true);
		}
		radioBtn_Home.setDisable(isSachDienTuFull);
		updateCheckboxAllState();
	}
	
	//hàm cập nhật giá khi thay đổi loại sách trong giỏ hàng
	public void capnhatGiaLoaiSachGiHang() {
		loaisach.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null && newValue != oldValue) {
				if (newValue == TgBtn_LoaiSachDienTu) {
					FE_chiTiet_priceText.setText(df.format(originalPaperBookPrice * 60 / 100.0));
				} else if (newValue == TgBtn_LoaiSachGiay) {
					FE_chiTiet_priceText.setText(df.format(originalPaperBookPrice));
				}
			}
		});
	}

	//hàm cập nhật số lượng tổng và giá tổng của giỏ hàng
	public void updateTotalPriceAll() {
		double sum = 0.0;
		int save = 0;
		boolean checkLoaiSach = true;
		for (CartCardController cartCard : cartCardController) {
			if (cartCard.getCheckBox().isSelected()) {
				Cart cart = cartCard.getCart();
				sum += cart.getQuantity() * cart.getPrice();
				save += cart.getQuantity();
				if(cart.getLoaisach().equals("Sách giấy")) {
					checkLoaiSach = false;
				}
			}
			
		}
		hboxChonDiaChi.setDisable(checkLoaiSach);
		hboxChonVanChuyen.setDisable(checkLoaiSach);
		radioBtn_Home.setDisable(checkLoaiSach);
		totalQuantityAllText.setText(String.valueOf(save));
		totalPriceAllText.setText(df.format(sum));
	}
	
	// chức năng thanh toán giỏ háng
	public void payCart(ActionEvent event) {
		AlertMessage alert = new AlertMessage();
		if (!hboxChonDiaChi.isDisable()) {
			if(addressText.getText().equalsIgnoreCase("")) {
				alert.errorMessage("Thông tin địa chỉ chưa điền");
				return;
			}
			
		}
		if (loaivanchuyenText.getText().equalsIgnoreCase("")) {
			connect = DataBaseConnect.getConnection();
			String select = "select * from cart where of_fullname = ? and selected = 1";
			int check = 1;
			String warning = "";
			try {
				prepare = connect.prepareStatement(select);
				prepare.setString(1, username);
				ResultSet kq = prepare.executeQuery();
				
				while(kq.next()) {
					if(kq.getString("loaisach").equals("Sách giấy")) {
						check = 0;
					}
					String sqlSelect = "select * from books where name = ?";
					prepare = connect.prepareStatement(sqlSelect);
					prepare.setString(1, kq.getString("name"));
					ResultSet KqBook = prepare.executeQuery();
					if(KqBook.next()) {
						if(KqBook.getInt("stock") < kq.getInt("quantity")) {
							warning += "Sách " + KqBook.getString("name")+ " chỉ còn "+ KqBook.getInt("stock") + ", không đủ bán cho bạn\n";
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			DataBaseConnect.closeConnection(connect);
			if(check != 1) {
				alert.errorMessage("Thông tin loại vận chuyển chưa điền");
				return;
			}
			if(!warning.equals("")) {
				alert.errorMessage(warning);
				return;
			}
			
		}
		if (totalPriceAllText.getText().equals("0")) {
			alert.errorMessage("Chưa có sản phẩm được chọn trong giỏ hàng");
			return;
		}
		
		connect = DataBaseConnect.getConnection();
		String select = "select * from cart where of_fullname = ? and selected = 1 and loaisach = ?";
		String warning = "";
		try {
			prepare = connect.prepareStatement(select);
			prepare.setString(1, username);
			prepare.setString(2, "Sách giấy");
			ResultSet kq = prepare.executeQuery();
			
			while(kq.next()) {
				String sqlSelect = "select * from books where name = ?";
				prepare = connect.prepareStatement(sqlSelect);
				prepare.setString(1, kq.getString("name"));
				ResultSet KqBook = prepare.executeQuery();
				if(KqBook.next()) {
					if(KqBook.getInt("stock") < kq.getInt("quantity")) {
						warning += "Sách " + KqBook.getString("name")+ " chỉ còn "+ KqBook.getInt("stock") + ", không đủ bán cho bạn\n";
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		DataBaseConnect.closeConnection(connect);
		if(!warning.equals("")) {
			alert.errorMessage(warning);
			return;
		}
		
		String diachi = addressText.getText();
		if(hboxChonDiaChi.isDisable()) {
			diachi = "";
		}
		String pttt = "";
		double tienthua = 0.0;
		if (radioBtn_Bank.isSelected()) {
			pttt = "Thanh toán trực tiếp qua Ngân hàng";

			// Tạo Dialog tùy chỉnh cho thanh toán
			Dialog<Pair<String, String>> dialog = new Dialog<>();
			dialog.setTitle("Thông tin thanh toán");
			dialog.setHeaderText("Chọn loại ngân hàng và nhập số thẻ");

			// Thêm nút OK và Cancel
			ButtonType thanhToanButtonType = new ButtonType("Thanh toán", ButtonBar.ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().addAll(thanhToanButtonType, ButtonType.CANCEL);

			// Tạo GridPane chứa các trường nhập
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(20, 150, 10, 10));
			
			// Tắt nút thanh toán nếu chưa nhập đủ thông tin
			Node thanhToanButton = dialog.getDialogPane().lookupButton(thanhToanButtonType);
			thanhToanButton.setDisable(true);

			// Tạo ComboBox cho loại ngân hàng
			ComboBox<String> bankTypeComboBox = new ComboBox<>();
			ObservableList<String> danhSachNganHang = FXCollections.observableArrayList("Vietcombank",
					"BIDV", "Techcombank", "Sacombank", "ACB", "MB Bank", "VIB", "VPBank");
			bankTypeComboBox.getItems().addAll(danhSachNganHang);
			bankTypeComboBox.setPromptText("Chọn ngân hàng");
			
			// Tạo TextField cho số thẻ
			TextField cardNumberField = new TextField();
			cardNumberField.setPromptText("Số thẻ ngân hàng");
			
			// Theo dõi thay đổi để kích hoạt nút khi có dữ liệu
			bankTypeComboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
			    thanhToanButton.setDisable(newVal == null || cardNumberField.getText() == null);
			});
			cardNumberField.textProperty().addListener((obs, oldVal, newVal) -> {
			    thanhToanButton.setDisable(newVal == null || bankTypeComboBox.getValue() == null);
			});
			
			String sql = "select typeBank, numberBank from accounts where username = ?";
			connect = DataBaseConnect.getConnection();
			try {
				prepare = connect.prepareStatement(sql);
				prepare.setString(1, username);
				result = prepare.executeQuery();
				if(result.next()) {
					bankTypeComboBox.setValue(result.getString("typeBank"));
					cardNumberField.setText(result.getString("numberBank"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DataBaseConnect.closeConnection(connect);
			
			grid.add(new Label("Loại ngân hàng:"), 0, 0);
			grid.add(bankTypeComboBox, 1, 0);
			grid.add(new Label("Số thẻ:"), 0, 1);
			grid.add(cardNumberField, 1, 1);

			dialog.getDialogPane().setContent(grid);

			// Đưa con trỏ vào ComboBox khi dialog hiển thị
			Platform.runLater(() -> bankTypeComboBox.requestFocus());

			// Xử lý kết quả khi nhấn OK
			dialog.setResultConverter(dialogButton -> {
			    if (dialogButton == thanhToanButtonType) {
			        return new Pair<>(bankTypeComboBox.getValue(), cardNumberField.getText());
			    }
			    return null;
			});

			Optional<Pair<String, String>> result = dialog.showAndWait();
			if (!result.isPresent()) {
			    alert.errorMessage("Bạn cần chọn loại ngân hàng và nhập số thẻ để thanh toán!");
			    return;
			}

			Pair<String, String> bankInfo = result.get();
			String bankType = bankInfo.getKey();
			String cardNumber = bankInfo.getValue();

			if (bankType.trim().isEmpty() || cardNumber.trim().isEmpty()) {
			    alert.errorMessage("Bạn cần nhập đầy đủ thông tin thanh toán!");
			    return;
			}

			// Tiếp tục xử lý thanh toán với thông tin: bankType và cardNumber


			TextInputDialog amountDialog = new TextInputDialog(totalPriceAllPayText.getText());
			amountDialog.setTitle("Nhập số tiền thanh toán");
			amountDialog.setHeaderText("Nhập số tiền bạn muốn thanh toán:");
			amountDialog.setContentText("Số tiền:");

			Optional<String> amount = amountDialog.showAndWait();
			if (!amount.isPresent() || amount.get().trim().isEmpty()) {
				alert.errorMessage("Bạn cần nhập số tiền để thanh toán!");
				return;
			}

			try {
				double amountValue = Double.parseDouble(amount.get().replaceAll("[,.]", ""));
				double totalValue = Double.parseDouble(totalPriceAllPayText.getText().replaceAll("[,.]", ""));
				if (amountValue < totalValue) {
					alert.errorMessage("Số tiền thanh toán không đủ!");
					return;
				} else {
					tienthua = amountValue - totalValue;
				}
			} catch (NumberFormatException e) {
				alert.errorMessage("Số tiền nhập không hợp lệ!");
				return;
			}
		} else {
			pttt = "Thanh toán tiền mặt khi nhận hàng";
		}

		Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
		confirmAlert.setTitle("Thanh toán giỏ hàng");
		confirmAlert.setHeaderText(null);
		Label lblFullname = new Label("Người nhận là: " + fullname);
		Label lblDiaChi = new Label(diachi == null ? "" : "Địa chỉ nhận là: " + diachi);
		Label lbHTThanhToan = new Label("Hình thức thanh toán là: " + pttt);
		Label lblPrice = new Label(
				"Bạn có chắc chắn muốn thanh toán với giá " + totalPriceAllPayText.getText() + " VNĐ");

		VBox contentBox = new VBox(lblDiaChi, lblFullname, lbHTThanhToan, lblPrice);
		contentBox.setSpacing(5);
		confirmAlert.getDialogPane().setContent(contentBox);

		// Xác nhận thanh toán
		Optional<ButtonType> result = confirmAlert.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.OK) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = LocalDate.now().format(formatter);
			connect = DataBaseConnect.getConnection();
			String sqlThongKe = "select * from thongke where ngayThangNam = ?";
			
            try {
				prepare = connect.prepareStatement(sqlThongKe,ResultSet.TYPE_SCROLL_INSENSITIVE, 
					    ResultSet.CONCUR_READ_ONLY);
				prepare.setString(1, formattedDate);
	            ResultSet r = prepare.executeQuery();
	            if(r.next()) {
					String sqlUpdate = "UPDATE thongke SET doanhThu = ? WHERE ngayThangNam = ?";
                    prepare = connect.prepareStatement(sqlUpdate);
                    double priceAll = Double.parseDouble(totalPriceAllPayText.getText().replaceAll("[,.]", ""));
                    prepare.setDouble(1,r.getDouble("doanhThu")+priceAll);
                    prepare.setString(2, formattedDate);
                    int rowUpdate = prepare.executeUpdate();
                    if(rowUpdate > 0) {
                    	
                    } else {
                        alert.errorMessage("Lỗi khi cập nhật!");
                    }
				}
	            
	            String sqlSelectSachDienTu = "select * from cart WHERE of_fullname = ? and selected = 1 and loaisach = ?";
	            prepare = connect.prepareStatement(sqlSelectSachDienTu);
				prepare.setString(1, username);
				prepare.setString(2, "Sách điện tử");
				ResultSet rsSachDienTu = prepare.executeQuery();
				cardListData.clear();
				List<String> bookNames = new ArrayList<>();
				List<String> downloadLinks = new ArrayList<>();
				while(rsSachDienTu.next()) {
				    addSQLLibraries(rsSachDienTu.getString("name"), username);
				    
				    String nameEbook = rsSachDienTu.getString("name");
				    String sqlSelectEbook = "Select ebooklink from books where name = ?";
				    prepare = connect.prepareStatement(sqlSelectEbook);
					prepare.setString(1, nameEbook);
					ResultSet rschecknameEbook = prepare.executeQuery();
					if(rschecknameEbook.next()) {
						bookNames.add(nameEbook);
						downloadLinks.add(rschecknameEbook.getString("ebookLink"));
						
						connect = DataBaseConnect.getConnection();
			            String sqlGetLinkEbook  = "select email from accounts where username = ?";
			            prepare = connect.prepareStatement(sqlGetLinkEbook);
						prepare.setString(1, username);
						ResultSet rscheckEmail = prepare.executeQuery();
						String email = "";
						if(rscheckEmail.next()) {
							email = rscheckEmail.getString("email");
						}
			            boolean checkGuiLink = EbookEmailSender.sendEbookEmail(email, bookNames, downloadLinks);
			            if(!checkGuiLink) {
			            	alert.errorMessage("Lỗi gửi link cho email");
			            }
					}else {
						alert.errorMessage("Lỗi gửi link cho email");
					}
				    
				}

				menuDisplayCardLibrary();
				connect = DataBaseConnect.getConnection();
	            
	            String sqlLayGioHang = "select * from cart WHERE of_fullname = ? and selected = 1 and loaisach = ?";
					prepare = connect.prepareStatement(sqlLayGioHang);
					prepare.setString(1, username);
					prepare.setString(2, "Sách giấy");
					this.result = prepare.executeQuery();
					while(this.result.next()) {
	                	String sqlQuantityAll = "select stock from books where name = ?";
						prepare = connect.prepareStatement(sqlQuantityAll);
						prepare.setString(1,this.result.getString("name"));
						ResultSet rs = prepare.executeQuery();
						int quantityAll = 0;
						if(rs.next()) {
							quantityAll = rs.getInt("stock");
						}
						int sum = quantityAll-this.result.getInt("quantity");
						int status = 1;
						if(sum <= 0) status = 0;
						String sqlCapNhatSLTonKho = "update books set stock = ?, status = ? where  name = ?";
						prepare = connect.prepareStatement(sqlCapNhatSLTonKho);
						prepare.setInt(1, quantityAll-this.result.getInt("quantity"));
						prepare.setInt(2, status);
						prepare.setString(3,this.result.getString("name"));
						int check = prepare.executeUpdate();
						if(check > 0) {
							System.out.println("Cập nhật số lượng tồn kho khi mua thành công của sách"+ this.result.getString("name"));
			                r.beforeFirst();
							if(r.next()) {
			                	String sqlUpdate = "UPDATE thongke SET soLuongSachDuocBan = ? WHERE ngayThangNam = ?";
		                        prepare = connect.prepareStatement(sqlUpdate);
		                        prepare.setInt(1, r.getInt("soLuongSachDuocBan") + this.result.getInt("quantity"));
		                        prepare.setString(2, formattedDate);
		                        int rowUpdate = prepare.executeUpdate();
		                        if(rowUpdate > 0) {
		                        	
		                        } else {
		                            alert.errorMessage("Lỗi khi cập nhật!");
		                        }
			                }
						}else {
							System.out.println("lỗi cập nhật");
						}
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            String sqlInsertDonHang = "INSERT INTO donhang (nguoiMua, tongtienhang, phivanchuyen, voucher, thanhtien,hinhthucthanhtoan, diachi) VALUES (?,?,?,?,?,?,?)";
            try {
            	prepare = connect.prepareStatement(sqlInsertDonHang, Statement.RETURN_GENERATED_KEYS);
            	prepare.setString(1, username);
            	prepare.setDouble(2, Double.parseDouble(totalPriceAllText.getText().replaceAll("[,.]", "")));
            	prepare.setDouble(3, Double.parseDouble(priceShippingText.getText().replaceAll("[,.]", "")));
            	prepare.setDouble(4,Double.parseDouble(priceGiamGiaText.getText().replaceAll("[,.]", "")));
            	prepare.setDouble(5, Double.parseDouble(totalPriceAllPayText.getText().replaceAll("[,.]", "")));
            	if(radioBtn_Bank.isSelected()) {
            		prepare.setString(6, radioBtn_Bank.getText());
            	}else {
            		prepare.setString(6, radioBtn_Home.getText());
            	}
            	if(!hboxChonDiaChi.isDisabled()) {
            		prepare.setString(7, addressText.getText());
            	}else prepare.setString(7, "");
            	
            	int check = prepare.executeUpdate();
            	if(check > 0) {
            		System.out.println("Thêm đơn hàng thành công");
            		ResultSet generatedKeys = prepare.getGeneratedKeys();
            		if (generatedKeys.next()) {
                        int lastInsertedId = generatedKeys.getInt(1);
                        System.out.println("Mã đơn hàng vừa tạo: " + lastInsertedId);
	            		String sqlSelectSachDienTu = "select * from cart WHERE of_fullname = ? and selected = 1";
	            		prepare = connect.prepareStatement(sqlSelectSachDienTu);
	    				prepare.setString(1, username);
	    				ResultSet rsSelect = prepare.executeQuery();
	    				while(rsSelect.next()) {
	    					String insertChiTietDonHang = "INSERT INTO chitietdonhang (gioHangId, sanPham, soLuong, gia,loaisach) "
	    							+ "VALUES (?, ?, ?,?,?)";
	    					prepare = connect.prepareStatement(insertChiTietDonHang);
	    					prepare.setInt(1, lastInsertedId);
	    					prepare.setString(2, rsSelect.getString("name"));
	    					prepare.setInt(3, rsSelect.getInt("quantity"));
	    					prepare.setDouble(4, rsSelect.getDouble("price"));
	    					prepare.setString(5, rsSelect.getString("loaisach"));
	    					int checkThemChiTiet = prepare.executeUpdate();
	    					if(checkThemChiTiet > 0) {
	    						System.out.println("Cập nhật chi tiết đơn hàng thành công");
	    					}else {
	    						System.out.println("lỗi Cập nhật chi tiết đơn hàng");
	    					}
	    				}
                    }
            		

            	}else {
            		System.out.println("Thêm đơn hàng thất bại");
            	}
			} catch (Exception e) {
				// TODO: handle exception
			}
            
            
            
			
            
			
			String sql = "DELETE FROM cart WHERE of_fullname = ? and selected = 1";
			
			try {
				prepare = connect.prepareStatement(sql);
				prepare.setString(1, username);
				int affectedRows = prepare.executeUpdate();
				if (affectedRows > 0) {
					
					totalPriceAllText.setText("0");
					priceShippingText.setText("0");
					priceGiamGiaText.setText("0");
					totalPriceAllPayText.setText("0");
					addressText.setText("");
					loaivanchuyenText.setText("");
					loaiMaGiamGiaText.setText("");
					menuCartDisplayCard();
					if(alert.ConfirmMessage("Quay về trang chủ???")) {
						setChuyenTrang(FE_btnTrangChu, FE_trangChuForm);
					}
					alert.successMessage(String
							.format("Thanh toán thành công!\nChúc quý khách đọc sách vui vẻ\n" + ""));
				} else {
					alert.errorMessage("Giỏ hàng trống hoặc có lỗi xảy ra khi thanh toán.");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DataBaseConnect.closeConnection(connect);
		}

	}
	//chức năng SelectAll
	@FXML
	private void toggleSelectAll(ActionEvent event) {
		boolean isSelected = checkBoxAll.isSelected();
		for (CartCardController card : cartCardController) {
			card.getCheckBox().setSelected(isSelected);

			card.updateCheckboxState(isSelected);
		}
	}
	public void updateCheckboxAllState() {
		boolean allSelected = true;
		for (CartCardController cartCard : cartCardController) {
			if (!cartCard.getCheckBox().isSelected()) {
				allSelected = false;
			}
		}
		checkBoxAll.setSelected(allSelected);
	}
	
	//TODO LẤY ĐỊA CHỈ, LOẠI VẬN CHUYỂN, VOUCHER
	//hàm lấy địa chỉ
	public void addressSelect(MouseEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AddressSelection.fxml"));
		try {
			Parent root = loader.load();
			// Lấy stage hiện tại từ đối tượng nguồn của sự kiện
	        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        Scene currentScene = currentStage.getScene();

	        // Tạo hiệu ứng blur
	        GaussianBlur blur = new GaussianBlur(5);
	        currentScene.getRoot().setEffect(blur); // Áp dụng hiệu ứng blur
			Stage stage = new Stage();
			stage.setTitle("Chọn Địa Chỉ Giao Hàng");
			stage.setScene(new Scene(root));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setResizable(false);
			
			stage.showAndWait();
			currentScene.getRoot().setEffect(null);

			AddressSelectionController controller = loader.getController();
			String selectedAddress = controller.getSelectedAddress();
			addressText.setText(selectedAddress);
			if (!addressText.getText().equalsIgnoreCase("")) {
				startcheck.setText("");
				updateAddressToSQL(selectedAddress);
			} else {
				startcheck.setText("*");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	private void setInfoGioHang() {
//		String sql = "select address, "
//	}
	
	private void updateAddressToSQL(String address) {
		String sql = "update accounts set address = ? where username = ?";
		connect = DataBaseConnect.getConnection();
		try {
			prepare =connect.prepareStatement(sql);
			prepare.setString(1, address);
			prepare.setString(2, username);
			int check = prepare.executeUpdate();
			if(check > 0) {
				System.out.println("Cập nhật thành công địa chỉ vào csdl");
			}else System.out.println("Lỗi Cập nhật địa chỉ vào csdl");
		} catch (Exception e) {
		}
		DataBaseConnect.closeConnection(connect);
	}

	// hàm lấy loại vận chuyển
	public void shippingSelect(MouseEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ShippingSelection.fxml"));
		try {
			Parent root = loader.load();
			Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        Scene currentScene = currentStage.getScene();

	        // Tạo hiệu ứng blur
	        GaussianBlur blur = new GaussianBlur(5);
	        currentScene.getRoot().setEffect(blur);
			Stage stage = new Stage();
			stage.setTitle("Chọn loại vận chuyển");
			stage.setScene(new Scene(root));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setResizable(false);
			stage.showAndWait();
			currentScene.getRoot().setEffect(null);
			ShippingOptionsController controller = loader.getController();
			String selectedShippingOption = controller.getSelectedShippingOption();
			double price;
			try {
				price = Double.parseDouble(selectedShippingOption);
			} catch (NumberFormatException e) {
				price = 0.0;
			}
			priceShippingText.setText(df.format(price));
			loaivanchuyenText.setText(controller.getLoaiVanChuyen());
			if (!loaivanchuyenText.getText().equalsIgnoreCase("")) {
				startcheck1.setText("");
			} else {
				startcheck1.setText("*");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Hàm lấy voucher
	public void voucherSelect(MouseEvent event) {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("VoucherSelection.fxml"));
		try {
			Parent root = loader.load();
			Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        Scene currentScene = currentStage.getScene();

	        // Tạo hiệu ứng blur
	        GaussianBlur blur = new GaussianBlur(5);
	        currentScene.getRoot().setEffect(blur);
			VoucherSelectionController controller = loader.getController();
			controller.setData(totalPriceAllText.getText(), priceShippingText.getText());

			Stage stage = new Stage();
			stage.setTitle("Chọn Voucher");
			stage.setScene(new Scene(root));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setResizable(false);
			stage.showAndWait();
			currentScene.getRoot().setEffect(null);
			double magiamgia = controller.getPriceGiamGia();
			priceGiamGiaText.setText(df.format(0.0 - magiamgia));
			String tengiamgia = controller.getNameVoucher();
			loaiMaGiamGiaText.setText(tengiamgia);

			updateDiscount(totalPriceAllText.getText(), tengiamgia);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//hàm cập nhật voucher lên tóm tắt thanh toán
	private void updateDiscount(String t, String tengiamgia) {
		try {
			double tongDonHang = Double.parseDouble(t.replaceAll("[,.]", ""));
			double giaVanChuyen = Double.parseDouble(priceShippingText.getText())*1000;
			double giamGia = 0.0;

			String loaiGiamGia = tengiamgia;

			if (loaiGiamGia.contains("10k cho đơn tối thiểu 0đ")) {
				giamGia = 10000;
			} else if (loaiGiamGia.contains("12% giảm tối đa 30k")) {
				giamGia = Math.min(tongDonHang * 0.12, 30000.0);
			} else if (loaiGiamGia.contains("100k cho đơn hàng tối thiểu 500k")) {
				giamGia = 100000;
			} else if (loaiGiamGia.contains("50% tối đa 50k")) {
				giamGia = Math.min(tongDonHang * 0.5, 50000.0);
			}

			if (loaiGiamGia.contains("20% cho đơn tối thiểu 0đ")) {
				giamGia += giaVanChuyen * 0.2;
			} else if (loaiGiamGia.contains("50% cho đơn tối thiểu 100k")) {
				giamGia += giaVanChuyen * 0.5;
			} else if (loaiGiamGia.contains("70% cho đơn tối thiểu 300k")) {
				giamGia += giaVanChuyen * 0.7;
			} else if (loaiGiamGia.contains("Free Ship cho đơn trên 500k")) {
				giamGia += giaVanChuyen;
			}

			System.out.println("Tổng giảm giá cuối cùng: " + giamGia);

			priceGiamGiaText.setText(df.format(0.0 - giamGia));

		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Lỗi khi chuyển đổi số3: " + e.getMessage());
		}
	}

	private void updateTotalOrder(String old) {
	    try {
	        // Loại bỏ dấu phân tách hàng nghìn nếu có
	        String totalText = totalPriceAllText.getText().replaceAll("[,.]", "");
	        String shippingText = priceShippingText.getText().replaceAll("[,.]", "");
	        String discountText = priceGiamGiaText.getText().replaceAll("[,.]", "");

	        double oldTotalLabel = Double.parseDouble(old.replaceAll("[,.]", ""));
	        double totalLabel = Double.parseDouble(totalText);
	        double shippingFee = Double.parseDouble(shippingText);
	        double discount = Double.parseDouble(discountText);

	        if ((oldTotalLabel >= 500000.0 && totalLabel < 500000.0 && totalLabel >= 300000.0)
	                || (oldTotalLabel >= 300000.0 && totalLabel < 300000.0 && totalLabel >= 100000.0)
	                || (oldTotalLabel >= 100000.0 && totalLabel < 100000.0 && totalLabel >= 0)) {
	            loaiMaGiamGiaText.setText("");
	            startcheck1.setText("*");
	            updateDiscount(totalPriceAllText.getText(), loaiMaGiamGiaText.getText());
	            discount = 0.0;
	        }
	        if (totalLabel == 0.0) {
	            priceShippingText.setText("0");
	            shippingFee = 0.0;
	            loaivanchuyenText.setText("");
	        }

	        double finalTotal = totalLabel + shippingFee + discount;
	        System.out.println(finalTotal);

	        // Định dạng lại số trước khi hiển thị
	        DecimalFormat df = new DecimalFormat("#,###");
	        totalPriceAllPayText.setText(df.format(finalTotal));
	    } catch (NumberFormatException e) {
	        System.err.println("Lỗi chuyển đổi số: " + e.getMessage());
	    }
	}

	
	//hàm cập nhật giá tổng phải trả 
	private void updateTotalOrder() {
		try {
			
			// Loại bỏ dấu phân tách hàng nghìn nếu có
	        String totalText = totalPriceAllText.getText().replaceAll("[,.]", "");
	        String shippingText = priceShippingText.getText().replaceAll("[,.]", "");
	        String discountText = priceGiamGiaText.getText().replaceAll("[,.]", "");
	        
			double totalLabel = Double.parseDouble(totalText);
			double shippingFee = Double.parseDouble(shippingText);
			double discount = Double.parseDouble(discountText);

			double finalTotal = totalLabel + shippingFee + discount;

			totalPriceAllPayText.setText(df.format(finalTotal));
		} catch (NumberFormatException e) {
			System.err.println("Lỗi chuyển đổi số1: " + e.getMessage());
		}
	}
	
	//TODO TRANG THƯ VIÊN
	private void addSQLLibraries(String name, String of_username) {
		String sqlSelect = "select image from books where name = ?";
		String image = "";
		try {
			prepare = connect.prepareStatement(sqlSelect);
			prepare.setString(1, name);
			ResultSet kq = prepare.executeQuery();
			if(kq.next()) {
				image = kq.getString("image");
				String sql = "insert into libraries (name, image, of_username) values (?,?,?)";
				try {
					prepare = connect.prepareStatement(sql);
					prepare.setString(1, name);
					prepare.setString(2, image);
					prepare.setString(3, of_username);
					int r = prepare.executeUpdate();
					if(r > 0) {
						System.out.println("Cap nhat thu vien thành công");
					}else {
						System.out.println("Cap nhat thu vien thất bại");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ObservableList<Book> menuGetDataLibrary() {
		ObservableList<Book> listData = FXCollections.observableArrayList();
		connect = DataBaseConnect.getConnection();
		String sql = "SELECT * FROM libraries WHERE of_username = ?";
		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1,username);
			result = prepare.executeQuery();
			while (result.next()) {
				Book book = new Book(result.getString("image"),
						result.getString("name"));
				listData.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DataBaseConnect.closeConnection(connect);
		return listData;
	}

	

	public void menuDisplayCardLibrary() {
		cardListData.clear();
		cardListData.addAll(menuGetDataLibrary());
		FE_trangChuFlowPane1.getChildren().clear();
		for (Book book : cardListData) {
			try {
				FXMLLoader load = new FXMLLoader(getClass().getResource("CardBookLibrary.fxml"));
				VBox box = load.load();
				CardBookLibraryController cardC = load.getController();
				cardC.setData(book);
				cardC.setFrontEndController(this);
				cardLibratyControllers.add(cardC);
				FE_trangChuFlowPane1.getChildren().add(box);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (FE_trangChuFlowPane1.getChildren().isEmpty()) {
			FE_trangChuFlowPane1.getChildren().add(new Label("Thư viên chưa có sách"));
		}
	}
	
	
	//TODO TRANG HỖ TRỢ
	
	public void chuyenTrang(ActionEvent event) {
		if(event.getSource() == btnBackHoTro) {
			cauHoiPhoBienForm.setVisible(true);
			nhanTinForm.setVisible(false);
		}
	}
	
	private LocalDateTime lastMessageTime; // Thời gian của tin nhắn cuối cùng
	private static final long SESSION_DURATION_MINUTES = 5; // Thời gian phiên (5 phút)
	//chức năng gửi tin nhắn đến admin
	@FXML
	private void sendMessage(ActionEvent event) {
		final String message;
		if(!((Button)event.getSource()).getText().equals("Gửi") && !((Button)event.getSource()).getText().equals("Hỏi trực tiếp >")) {
		    message = ((Button)event.getSource()).getText();
		    cauHoiPhoBienForm.setVisible(false);
			nhanTinForm.setVisible(true);
		}else if(((Button)event.getSource()).getText().equals("Hỏi trực tiếp >")) {
			message = "";
			cauHoiPhoBienForm.setVisible(false);
			nhanTinForm.setVisible(true);
		}else message = inputField.getText().trim();
		

	    
	    if (message.isEmpty()) {
	        return;
	    }
	    
	    Platform.runLater(() -> {
	        try {
	            if (chatService != null) {
	                LocalDateTime now = LocalDateTime.now();
	                boolean isNewSession = false;

	                // Kiểm tra xem có phải phiên mới không
	                if (lastMessageTime == null || now.isAfter(lastMessageTime.plusMinutes(SESSION_DURATION_MINUTES))) {
	                    isNewSession = true; // Đánh dấu là phiên mới
	                }

	                // Nếu là phiên mới, thêm dòng thời gian bắt đầu
	                if (isNewSession) {
	                    addSessionStartTime(now);
	                }

	                // Gửi tin nhắn và cập nhật giao diện
	                chatService.sendMessageFromUser(username, message);
	                addMessageToChatBox(message, true);
	                lastMessageTime = now; // Cập nhật thời gian tin nhắn cuối cùng

	                // Cuộn xuống cuối chatBox
	                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), ae -> scrollpaneChat.setVvalue(1.0)));
	                timeline.play();
	                inputField.clear();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    });
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
	//chức năng đẩy tin nhắn lên giao diện
	private void addMessageToChatBox(String message, boolean isUser) {
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

		if (isUser) {
			messageLabel.setStyle("-fx-background-color: #3a9cff;" + "-fx-background-radius: 20px;"
					+ "-fx-text-fill: #fff;" + "-fx-font-size: 17px;" + "-fx-font-weight: bold;");
			messageContainer.setAlignment(Pos.CENTER_RIGHT);
			timeLabel.setMaxWidth(messageLabel.getMaxWidth());
			timeLabel.setAlignment(Pos.CENTER_RIGHT);
		} else {
			messageLabel.setStyle("-fx-background-color: #686868;" + "-fx-background-radius: 20px;"
					+ "-fx-font-size: 17px;" + "-fx-font-weight: bold;" + "-fx-text-fill: #fff;");
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

		
	}
	// Hàm load lịch sử chat
	private HBox lastUserMessageBox; // Biến để lưu HBox của tin nhắn cuối cùng từ admin
	private void loadChatHistory() {
	    String sql = "SELECT * FROM messages WHERE (sender = ? AND receiver = 'admin') OR (sender = 'admin' AND receiver = ?) ORDER BY timestamp DESC";
	    chatBox.getChildren().clear();
	    connect = DataBaseConnect.getConnection();
	    try {
	        // Tạo PreparedStatement với ResultSet hỗ trợ di chuyển hai chiều
	        prepare = connect.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        prepare.setString(1, username);
	        prepare.setString(2, username);
	        result = prepare.executeQuery();

	        // Tìm thời gian của tin nhắn cuối cùng từ admin
	        String lastUserMessageTime = null;
	        boolean checkLast = false;
	        if (result.next()) {
	            String sender = result.getString("sender");
	            
	            if (sender.equalsIgnoreCase(username)) {
	            	lastUserMessageTime = result.getTimestamp("timestamp").toString();
	                checkLast = true;
	            }else {
	            	while(result.next()) {
	            		String sender1 = result.getString("sender");
	    	            if (sender1.equalsIgnoreCase(username)) {
	    	            	lastUserMessageTime = result.getTimestamp("timestamp").toString();
	    	                break;
	    	            }
	            	}
	            }
	        }
	        System.out.println(lastUserMessageTime);
	        String sqlShow = "SELECT * FROM messages WHERE (sender = ? AND receiver = 'admin') OR (sender = 'admin' AND receiver = ?) ORDER BY timestamp ASC";
	        
	        prepare = connect.prepareStatement(sqlShow, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        prepare.setString(1, username);
	        prepare.setString(2, username);
	        result = prepare.executeQuery();
	        
	        lastUserMessageBox = null; // Reset biến trước khi tải tin nhắn

	        // Hiển thị tất cả tin nhắn
	        while (result.next()) {
	            String sender = result.getString("sender");
	            String message = result.getString("message");
	            String check = result.getTimestamp("timestamp").toString();
	            LocalDateTime messageTime = result.getTimestamp("timestamp").toLocalDateTime();
	            String formattedTime = messageTime.format(DateTimeFormatter.ofPattern("HH:mm"));
	            String date = messageTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	            
	            // Kiểm tra xem đây có phải là tin nhắn cuối cùng từ admin không
	            boolean isLastUserMessage = sender.equalsIgnoreCase(username) && 
	            		check.toString().equals(lastUserMessageTime) && !checkLast;
	            HBox messageBox = LoadMessageToChatBox(sender, message, formattedTime,date, isLastUserMessage);
	            if (isLastUserMessage) {
	                lastUserMessageBox = messageBox; // Lưu HBox của tin nhắn cuối cùng từ admin
	            }
	        }

	     // Cuộn đến tin nhắn cuối cùng từ admin nếu có
	        if (lastUserMessageBox != null) {
	            scrollToMessage(lastUserMessageBox);
	        } else {
	            // Nếu không có tin nhắn từ admin, cuộn xuống cuối
	            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), ae -> scrollpaneChat.setVvalue(1.0)));
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

	private HBox LoadMessageToChatBox(String sender, String message, String time, String date,boolean isLastUserMessage) {
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

	    if (sender.equals(username)) {
			messageLabel.setStyle("-fx-background-color: #3a9cff;" + "-fx-background-radius: 20px;"
					+ "-fx-text-fill: #fff;" + "-fx-font-size: 17px;" + "-fx-font-weight: bold;");
			messageContainer.setAlignment(Pos.CENTER_RIGHT);
			timeLabel.setMaxWidth(messageLabel.getMaxWidth());
			timeLabel.setAlignment(Pos.CENTER_RIGHT);
		} else {
			messageLabel.setStyle("-fx-background-color: #686868;" + "-fx-background-radius: 20px;"
					+ "-fx-font-size: 17px;" + "-fx-font-weight: bold;" + "-fx-text-fill: #fff;");
			messageContainer.setAlignment(Pos.CENTER_LEFT);
		}

	    messageContainer.getChildren().add(messageWithTime);
	    chatBox.getChildren().add(messageContainer);
	    
	    if (isLastUserMessage) {
	        Label unreadLabel = new Label("--------------Tin nhắn chưa đọc--------------");
	        unreadLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
	        
	        HBox unreadContainer = new HBox();
	        unreadContainer.setPadding(new Insets(5, 30, 5, 20));
	        unreadContainer.setAlignment(Pos.CENTER);
	        unreadContainer.getChildren().add(unreadLabel);
	        
	        chatBox.getChildren().add(unreadContainer);
	    }
	    
	    messageLabel.setCursor(Cursor.HAND);
	    Tooltip tooltip = new Tooltip("Ngày gửi: " + date);
	    tooltip.setShowDelay(Duration.millis(100));
	    tooltip.setHideDelay(Duration.millis(200));
	    Tooltip.install(messageLabel, tooltip);

	    messageLabel.setOnMouseClicked(event -> {
	        tooltip.show(messageLabel, event.getScreenX(), event.getScreenY());
	    });

	    messageLabel.setOnMouseExited(event -> tooltip.hide());

	    return messageContainer;
	}
}
