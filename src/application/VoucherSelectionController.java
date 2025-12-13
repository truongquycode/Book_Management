package application;

import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class VoucherSelectionController {

    @FXML
    private Button comfirmButton;

    @FXML
    private ToggleGroup mafreeship;

    @FXML
    private ToggleGroup magiamgia;

    @FXML
    private RadioButton magiamgia1;

    @FXML
    private RadioButton magiamgia2;

    @FXML
    private RadioButton magiamgia3;

    @FXML
    private RadioButton magiamgia4;

    @FXML
    private RadioButton mavanchuyen1;

    @FXML
    private RadioButton mavanchuyen2;

    @FXML
    private RadioButton mavanchuyen3;

    @FXML
    private RadioButton mavanchuyen4;
    
    private String tongdonhang;
    private String giavanchuyen;
    private double priceTongDonHang;
    private double pricePhiVanChuyen;
    private double priceGiamGia = 0.0;
    private String nameVoucher = "";
    
    private DecimalFormat df = new DecimalFormat("#,###");

    @FXML
    public void initialize() {
    	
        comfirmButton.setOnAction(event -> handleConfirm());
    }

    private void handleConfirm() {
        if (magiamgia1.isSelected()) {
        	priceGiamGia += 10000.0;
        	nameVoucher = "Mã giảm giá 10k cho đơn tối thiểu 0đ\n";
        } else if (magiamgia2.isSelected()) {
            double temp = priceTongDonHang * 12 / 100.0;
            if(temp > 30000.0) {
            	temp = 30000.0;
            }
            priceGiamGia += temp;
            nameVoucher = "Mã giảm giá 12% giảm tối đa 30k cho đơn tối thiểu 100k\n";
        } else if (magiamgia3.isSelected()) {
        	priceGiamGia += 100000.0;
        	nameVoucher = "Mã giảm giá 100k cho đơn hàng tối thiểu 500k\n";
        } else {
        	double temp = priceTongDonHang * 50 / 100.0;
            if(temp > 50000.0) {
            	temp = 50000.0;
            }
            priceGiamGia += temp;
            nameVoucher = "Mã giảm giá 50% tối đa 50k cho đơn tối thiểu 300k\n";
        }
        
        if (mavanchuyen1.isSelected()) {
        	double temp = pricePhiVanChuyen * 20 / 100.0;
        	priceGiamGia += temp;
        	nameVoucher+="Mã giảm phí vận chuyển 20% cho đơn tối thiểu 0đ";
        } else if (mavanchuyen2.isSelected()) {
        	double temp = pricePhiVanChuyen * 50 / 100.0;
        	priceGiamGia += temp;
        	nameVoucher+="Mã giảm phí vận chuyển 50% cho đơn tối thiểu 100k";
        } else if (mavanchuyen3.isSelected()) {
        	double temp = pricePhiVanChuyen * 70 / 100.0;
        	priceGiamGia += temp;
        	nameVoucher+="Mã giảm phí vận chuyển 70% cho đơn tối thiểu 300k";
        } else {
        	priceGiamGia += pricePhiVanChuyen;
        	nameVoucher+="Mã giảm giá Free Ship cho đơn trên 500k";
        }
        // Đóng cửa sổ hiện tại
        Stage stage = (Stage) comfirmButton.getScene().getWindow();
        stage.close();
    }
    public void setData(String tongdonhang, String giavanchuyen) {
        if (tongdonhang != null && !tongdonhang.isEmpty()) {
            this.tongdonhang = tongdonhang.replaceAll("[,.]", "");
            this.priceTongDonHang = Double.parseDouble(this.tongdonhang);
        } else {
            this.priceTongDonHang = 0.0; // Gán giá trị mặc định nếu không có dữ liệu hợp lệ
        }

        if (giavanchuyen != null && !giavanchuyen.isEmpty()) {
            this.giavanchuyen = giavanchuyen.replaceAll("[,.]", "");
            this.pricePhiVanChuyen = Double.parseDouble(this.giavanchuyen);

        } else {
            this.pricePhiVanChuyen = 0.0;
        }
        
        if(priceTongDonHang < 500000.0) {
    		magiamgia3.setDisable(true);
    		mavanchuyen4.setDisable(true);
    	}
    	if(priceTongDonHang < 300000.0) {
    		magiamgia4.setDisable(true);
    		magiamgia3.setDisable(true);
    		mavanchuyen4.setDisable(true);
    		mavanchuyen3.setDisable(true);
    	}
    	
    	if(priceTongDonHang < 100000.0) {
    		magiamgia2.setDisable(true);
    		magiamgia4.setDisable(true);
    		magiamgia3.setDisable(true);
    		mavanchuyen2.setDisable(true);
    		mavanchuyen4.setDisable(true);
    		mavanchuyen3.setDisable(true);
    	}
    }

    public String getNameVoucher() {
    	return nameVoucher;
    }

    public double getPriceGiamGia() {
        return priceGiamGia;
    }
}
