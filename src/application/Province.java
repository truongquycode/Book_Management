package application;

public class Province {
    private int code;
    private String name;

    public Province(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    
    // Hiển thị tên trong ComboBox
    @Override
    public String toString() {
        return name;
    }
}
