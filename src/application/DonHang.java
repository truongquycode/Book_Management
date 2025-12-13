package application;
import javafx.beans.property.*;

public class DonHang {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final DoubleProperty tongTien = new SimpleDoubleProperty();
    private final DoubleProperty phiVanChuyen = new SimpleDoubleProperty();
    private final DoubleProperty voucher = new SimpleDoubleProperty();
    private final DoubleProperty thanhTien = new SimpleDoubleProperty();
    private final StringProperty hinhThucTT = new SimpleStringProperty();
    private final StringProperty ngayDat = new SimpleStringProperty();
    private final StringProperty diachi = new SimpleStringProperty();

    public DonHang(int id, double tongTien, double phiVC, double voucher, double thanhTien, String hinhThucTT, String ngayDat, String diachi) {
        this.id.set(id);
        this.tongTien.set(tongTien);
        this.phiVanChuyen.set(phiVC);
        this.voucher.set(voucher);
        this.thanhTien.set(thanhTien);
        this.hinhThucTT.set(hinhThucTT);
        this.ngayDat.set(ngayDat);
        this.diachi.set(diachi);
    }
    
    

    public int getId() { return id.get(); }
    public double getTongTien() { return tongTien.get(); }
    public double getPhiVanChuyen() { return phiVanChuyen.get(); }
    public double getVoucher() { return voucher.get(); }
    public double getThanhTien() { return thanhTien.get(); }
    public String getHinhThucTT() { return hinhThucTT.get(); }
    public String getDiaChi() { return diachi.get(); }
    public String getNgayDat() { return ngayDat.get(); }

    public IntegerProperty idProperty() { return id; }
    public DoubleProperty tongTienProperty() { return tongTien; }
    public DoubleProperty phiVanChuyenProperty() { return phiVanChuyen; }
    public DoubleProperty voucherProperty() { return voucher; }
    public DoubleProperty thanhTienProperty() { return thanhTien; }
    public StringProperty hinhThucTTProperty() { return hinhThucTT; }
    public StringProperty diaChiProperty() { return diachi; }
    public StringProperty ngayDatProperty() { return ngayDat; }
}

