package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ShippingOptionsController {

    @FXML
    private RadioButton standardRadio;

    @FXML
    private RadioButton fastRadio;

    @FXML
    private RadioButton superFastRadio;

    @FXML
    private Label priceTieuChuan;

    @FXML
    private Label priceNhanh;

    @FXML
    private Label priceNhanhPlus;

    @FXML
    private Button comfirmButton;

    @FXML
    private ToggleGroup shipping;

    private String selectedShippingOption = "";
    private String loaivanchuyen = "";

    @FXML
    public void initialize() {
        comfirmButton.setOnAction(event -> handleConfirm());
    }

    private void handleConfirm() {
        if (standardRadio.isSelected()) {
        	loaivanchuyen = "Vận chuyển tiêu chuẩn: 40,000 vnđ";
            selectedShippingOption = "40000";
        } else if (fastRadio.isSelected()) {
        	loaivanchuyen = "Vận chuyển nhanh: 60,000 vnđ";
        	selectedShippingOption = "60000";
        } else if (superFastRadio.isSelected()) {
        	loaivanchuyen = "Vận chuyển nhanh+: 80,000 vnđ";
        	selectedShippingOption = "80000";
        } else {
            selectedShippingOption = "";
        }
        // Đóng cửa sổ hiện tại
        Stage stage = (Stage) comfirmButton.getScene().getWindow();
        stage.close();
    }

    public String getSelectedShippingOption() {
        return selectedShippingOption;
    }
    
    public String getLoaiVanChuyen() {
        return loaivanchuyen;
    }
}
