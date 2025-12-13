package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.StageStyle;

public class CartCardController implements Initializable {
    
    @FXML
    private Button btnXoa;

    @FXML
    private HBox cartForm;

    @FXML
    private ImageView imageText;

    @FXML
    private Label nameText;

    @FXML
    private Label priceText;

    @FXML
    private Label priceTotalText;

    @FXML
    private Spinner<Integer> spinnerQuantity;

    @FXML
    private CheckBox checkbox;
    
    @FXML
    private Label theLoaiText;
    
    public CheckBox getCheckBox() {
    	return checkbox;
    }

    private Cart cart;
    private Image image;
    
    private Connection connect;
	private PreparedStatement prepare;
	private ResultSet result;
	String path ="";
	String imageSql = "";
	DecimalFormat df = new DecimalFormat("#,###");
	
	private FrontEndController frontEndController;

    public void setFrontEndController(FrontEndController frontEndController) {
        this.frontEndController = frontEndController;
    }

    public Button getBtnXoa() {
        return btnXoa;
    }

    public void setData(Cart cart) {
        this.cart = cart;
        String sql = "SELECT * FROM books WHERE name = ?";
        connect = DataBaseConnect.getConnection();
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, cart.getName());
            result = prepare.executeQuery();

            if (result.next()) {
                imageSql = result.getString("image");
                
                if(cart.getLoaisach().equalsIgnoreCase("Sách điện tử")) {
                	priceText.setText(df.format(result.getDouble("price")*60/100.0));
                }else priceText.setText(df.format(result.getDouble("price")));
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataBaseConnect.closeConnection(connect);
        checkbox.setSelected(cart.isSelected());
        nameText.setText(cart.getName());
        String path = getClass().getResource(imageSql).toExternalForm();
        image = new Image(path, 70, 100, false, true);
        imageText.setImage(image);
        theLoaiText.setText(cart.getLoaisach());
        if(cart.getLoaisach().equalsIgnoreCase("Sách điện tử")) {
        	spinnerQuantity.setDisable(true);
        }else spinnerQuantity.setDisable(false);
        
        spinnerQuantity.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, cart.getQuantity()));
        spinnerQuantity.valueProperty().addListener((obs, oldValue, newValue) -> updateTotalPrice());
        updateTotalPrice();
    }
    
    public void updateCheckboxState(boolean isSelected) {
        String sql = "UPDATE cart SET selected = ? WHERE name = ?  and loaisach = ? and of_fullname = ?";
        connect = DataBaseConnect.getConnection();
        try {
        	prepare = connect.prepareStatement(sql);
            prepare.setBoolean(1, isSelected);
            cart.setSelected(isSelected);
            prepare.setString(2, cart.getName());
            prepare.setString(3, cart.getLoaisach());
            prepare.setString(4, cart.getFullname());
            prepare.executeUpdate();
            if (frontEndController != null) {
                frontEndController.updateTotalPriceAll();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataBaseConnect.closeConnection(connect);
    }

    private void updateTotalPrice() {
        int quantity = spinnerQuantity.getValue();
        double total = quantity * Double.parseDouble(priceText.getText().replaceAll("[,.]", ""));
        priceTotalText.setText(df.format(total));
        
        if (frontEndController != null) {
        	if(cart.isSelected())
        		frontEndController.updateTotalPriceAll();
        }
    }
    
    public Cart getCart() {
        return this.cart;
    }
    
    public void delete(ActionEvent event) {
    	String sql = "DELETE FROM cart WHERE name = ? and loaisach = ? and of_fullname = ?";
        connect = DataBaseConnect.getConnection();
        AlertMessage alert1 = new AlertMessage();
        try {
        	prepare = connect.prepareStatement(sql);
            prepare.setString(1, cart.getName());
            prepare.setString(2, cart.getLoaisach());
            prepare.setString(3, cart.getFullname());
            int affectedRows = prepare.executeUpdate();
            if (affectedRows > 0) {
                if (frontEndController != null) {
                    frontEndController.menuCartDisplayCard();
                    frontEndController.updateTotalPriceAll();
                } else {
                	alert1.errorMessage("FrontEndController chưa được thiết lập.");
                }
            } else {
                alert1.errorMessage("Không tìm thấy item trong cart với tên: " + cart.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataBaseConnect.closeConnection(connect);     
    }

    private void updateQuantityInDatabase(int newQuantity) {
        String sql = "UPDATE cart SET quantity = ? WHERE name = ? and loaisach = ? and of_fullname = ?";
        connect = DataBaseConnect.getConnection();
        try {
        	prepare = connect.prepareStatement(sql);
            prepare.setInt(1, newQuantity);
            prepare.setString(2, cart.getName());
            prepare.setString(3, cart.getLoaisach());
            prepare.setString(4, cart.getFullname());
            int affectedRows = prepare.executeUpdate();
            if (affectedRows > 0) {
               
                if (frontEndController != null) {
                    frontEndController.menuCartDisplayCard();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataBaseConnect.closeConnection(connect);
    }
    
    public void updateLoaiSach(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Chọn Loại Sách");
        alert.setHeaderText("Hãy chọn lại loại sách:");

        ToggleButton sachDienTu = new ToggleButton("Sách điện tử");
        ToggleButton sachGiay = new ToggleButton("Sách giấy");

        ToggleGroup toggleGroup = new ToggleGroup();
        sachDienTu.setToggleGroup(toggleGroup);
        sachGiay.setToggleGroup(toggleGroup);

        // Trạng thái ban đầu
        if (cart.getLoaisach().equals("Sách điện tử")) {
            sachGiay.setSelected(true);
            sachGiay.setMouseTransparent(true);
            sachDienTu.setMouseTransparent(false);
        } else {
            sachDienTu.setSelected(true);
            sachDienTu.setMouseTransparent(true);
            sachGiay.setMouseTransparent(false);
        }

        sachDienTu.setOnAction(e -> {
            if (sachDienTu.isSelected()) {
                sachDienTu.setMouseTransparent(true);
                sachGiay.setMouseTransparent(false);
            }
        });

        sachGiay.setOnAction(e -> {
            if (sachGiay.isSelected()) {
                sachGiay.setMouseTransparent(true);
                sachDienTu.setMouseTransparent(false);
            }
        });

        // CSS cho cả 2 nút
        String cssCommon = "-fx-background-radius: 0;" +
                           "-fx-border-radius: 0;" +
                           "-fx-cursor: hand;" +
                           "-fx-font-size: 14px;" +
                           "-fx-pref-width: 150px;" +
                           "-fx-padding: 10 20;" +
                           "-fx-border-width: 0;" +
                           "-fx-background-insets: 0;" +
                           "-fx-effect: none;";

        // Style cho nút chưa chọn
        String cssUnselected = cssCommon +
                               "-fx-background-color: linear-gradient(to right, #dddddd, #cccccc);" +
                               "-fx-text-fill: #333;" +
                               "-fx-font-weight: normal;";

        // Style cho nút đang chọn
        String cssSelected = cssCommon +
                             "-fx-background-color: linear-gradient(to right, #00c6ff, #0072ff);" +
                             "-fx-text-fill: white;" +
                             "-fx-font-weight: bold;";

        // Áp dụng style ban đầu
        sachDienTu.setStyle(sachDienTu.isSelected() ? cssSelected : cssUnselected);
        sachGiay.setStyle(sachGiay.isSelected() ? cssSelected : cssUnselected);

        // Thay đổi style khi chuyển đổi
        toggleGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle == sachDienTu) {
                sachDienTu.setStyle(cssSelected);
                sachGiay.setStyle(cssUnselected);
            } else if (newToggle == sachGiay) {
                sachGiay.setStyle(cssSelected);
                sachDienTu.setStyle(cssUnselected);
            }
        });

        HBox hbox = new HBox(20, sachDienTu, sachGiay);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20));

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setContent(hbox);
        dialogPane.setPrefWidth(400);
        dialogPane.setStyle(
            "-fx-background-color: #f4f4f4;" +
            "-fx-border-color: transparent;" +  // Xóa khung hệ thống
            "-fx-background-radius: 0;" +
            "-fx-border-radius: 0;"
        );

        // Style cho tiêu đề trong Dialog
        Platform.runLater(() -> {
            Label headerLabel = (Label) dialogPane.lookup(".header-panel .label");
            if (headerLabel != null) {
                headerLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #0066cc; -fx-alignment: center;");
            }
        });

        alert.initStyle(StageStyle.UTILITY);
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                String loaiSachMoi = sachDienTu.isSelected() ? "Sách điện tử" : "Sách giấy";
                capNhatVaoCSDL(loaiSachMoi);
            }
        });
    }



    private void capNhatVaoCSDL(String loaiSachMoi) {
    	connect = DataBaseConnect.getConnection();
    	AlertMessage alert = new AlertMessage();
    	if(!loaiSachMoi.equals(cart.getLoaisach())) {
    		if(loaiSachMoi.equalsIgnoreCase("Sách điện tử")) {
    			
    			String kiemtra = "Select * from libraries where name = ? and of_username = ?";
				try {
					prepare = connect.prepareStatement(kiemtra);
					prepare.setString(1, cart.getName());
					prepare.setString(2, cart.getFullname());
					ResultSet kq = prepare.executeQuery();
					if(kq.next()) {
						alert.errorMessage("Bản sách điện tử này đã tồn tại trong thư viện của bạn");
						return;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
        		String sqlSelect = "select * from cart where name = ? and loaisach = ? and of_fullname = ?";
            	try {
        			prepare = connect.prepareStatement(sqlSelect);
        			prepare.setString(1, cart.getName());
                    prepare.setString(2, loaiSachMoi);
                    prepare.setString(3, cart.getFullname());
                    result = prepare.executeQuery();
                    if(result.next()) {
                    	
                    	alert.errorMessage("Sách này đã có bản điện tử trong giỏ hàng rồi");
                    	
                    }else {
                    	String sql = "UPDATE cart SET loaisach = ?, price = ?, quantity = 1 where name = ? and loaisach = ? and of_fullname = ?";
                        
                        try {
                        	prepare = connect.prepareStatement(sql);
                            prepare.setString(1, loaiSachMoi);
                            prepare.setDouble(2, cart.getPrice()*60/100.0);
                            prepare.setString(3, cart.getName());
                            prepare.setString(4, cart.getLoaisach());
                            prepare.setString(5, cart.getFullname());
                            int affectedRows = prepare.executeUpdate();
                            if (affectedRows > 0) {
                               
                                if (frontEndController != null) {
                                    frontEndController.menuCartDisplayCard();
                                    frontEndController.updateTotalPriceAll();
                                }
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        int rs = 0;
                        if(cart.getQuantity()-1!=0) {
                        	
                        	String sqlInsert = "insert into cart (name,price, quantity, of_fullname, selected, loaisach) values (?,?,?,?,?,?)";
                            
                            try {
                				prepare = connect.prepareStatement(sqlInsert);
                				prepare.setString(1, cart.getName());
                				prepare.setDouble(2, cart.getPrice());
                				prepare.setInt(3, cart.getQuantity()-1);
                				prepare.setString(4, cart.getFullname());
                				prepare.setBoolean(5, cart.isSelected());
                				prepare.setString(6, "Sách giấy");
                				rs = prepare.executeUpdate();
                				if(rs != 0) {
                					if (frontEndController != null) {
                                        frontEndController.menuCartDisplayCard();
                                        frontEndController.updateTotalPriceAll();
                                    }
                				}
                				
                			} catch (SQLException e) {
                				e.printStackTrace();
                			}
                        }
                        
                    }
        		} catch (Exception e) {
        			// TODO: handle exception
        		}
        	}else {
        		int quantitySelect = 0;
        		String sqlSelect = "select quantity,name from cart where name = ? and loaisach = ? and of_fullname = ?";
        		try {
        			prepare = connect.prepareStatement(sqlSelect);
        			prepare.setString(1, cart.getName());
                    prepare.setString(2, loaiSachMoi);
                    prepare.setString(3, cart.getFullname());
                    result = prepare.executeQuery();
                    if(result.next()) {
                    	quantitySelect = result.getInt("quantity");
                    	System.out.println(quantitySelect);
                    	String sql = "DELETE FROM cart WHERE name = ? and loaisach = ? and of_fullname = ?";
                        
                        AlertMessage alert1 = new AlertMessage();
                        try {
                        	prepare = connect.prepareStatement(sql);
                            prepare.setString(1, cart.getName());
                            prepare.setString(2, loaiSachMoi);
                            prepare.setString(3, cart.getFullname());
                            int affectedRows = prepare.executeUpdate();
                            if (affectedRows > 0) {
                                if (frontEndController != null) {
                                    frontEndController.menuCartDisplayCard();
                                    frontEndController.updateTotalPriceAll();
                                } else {
                                	alert1.errorMessage("FrontEndController chưa được thiết lập.");
                                }
                            } else {
                                alert1.errorMessage("Không tìm thấy item trong cart với tên: " + cart.getName());
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    	String sqlUpdate = "UPDATE cart SET quantity = ?, loaisach = ?, price = ? where name = ? and loaisach = ? and of_fullname = ?";
                    	try {
                			prepare = connect.prepareStatement(sqlUpdate);
                			prepare.setInt(1, quantitySelect+cart.getQuantity());
                			prepare.setString(2, loaiSachMoi);
                			prepare.setDouble(3, cart.getPrice()/60.0*100);
                            prepare.setString(4,cart.getName() );
                            prepare.setString(5, cart.getLoaisach());
                            prepare.setString(6, cart.getFullname());

                            int affectedRows = prepare.executeUpdate();
                            System.out.println(affectedRows);
                            if (affectedRows > 0) {
                               
                                if (frontEndController != null) {
                                	frontEndController.menuCartDisplayCard();
                                    frontEndController.updateTotalPriceAll();
                                }
                            }
                		} catch (Exception e) {
                			// TODO: handle exception
                		}
                    	
                    }else {
                    	System.out.println("Here");
                    	String sql = "UPDATE cart SET loaisach = ?,price = ? where name = ? and loaisach = ? and of_fullname = ?";
                        
                        try {
                        	prepare = connect.prepareStatement(sql);
                            prepare.setString(1, loaiSachMoi);
                            prepare.setDouble(2, cart.getPrice()/60.0*100);
                            prepare.setString(3, cart.getName());
                            prepare.setString(4, cart.getLoaisach());
                            prepare.setString(5, cart.getFullname());
                            int affectedRows = prepare.executeUpdate();
                            if (affectedRows > 0) {
                               
                                if (frontEndController != null) {
                                	frontEndController.menuCartDisplayCard();
                                    frontEndController.updateTotalPriceAll();
                                }
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        
                    }
    			} catch (Exception e) {
    				// TODO: handle exception
    			}
            	
        	}
    	}
    	DataBaseConnect.closeConnection(connect);
    }
  
	@Override
    public void initialize(URL arg0, ResourceBundle arg1) {
		spinnerQuantity.valueProperty().addListener((obs, oldValue, newValue) -> {
	        updateTotalPrice();
	        updateQuantityInDatabase(newValue);
	    });	
		checkbox.selectedProperty().addListener((obs, oldValue, newValue) -> {
	        updateCheckboxState(newValue);
	        Platform.runLater(() -> {
	            frontEndController.updateCheckboxAllState();
	            frontEndController.updateTotalPriceAll();
	        });
	    });	
    }
}
