package application;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddressSelectionController {

    @FXML
    private ComboBox<Province> provinceComboBox;

    @FXML
    private ComboBox<District> districtComboBox;

    @FXML
    private ComboBox<Ward> wardComboBox;

    @FXML
    private TextField streetTextField;

    @FXML
    private TextField houseNumberTextField;

    @FXML
    private Button confirmButton;

    private String selectedAddress = "";

    @FXML
    public void initialize() {
        // Ban đầu disable các ComboBox của huyện và xã
        districtComboBox.setDisable(true);
        wardComboBox.setDisable(true);

        // Tải danh sách tỉnh trên background
        Task<ObservableList<Province>> loadProvincesTask = new Task<ObservableList<Province>>() {
            @Override
            protected ObservableList<Province> call() throws Exception {
                return AddressAPI.getProvinces();
            }
        };
        loadProvincesTask.setOnSucceeded(e -> provinceComboBox.setItems(loadProvincesTask.getValue()));
        new Thread(loadProvincesTask).start();

        // Khi chọn tỉnh, tải danh sách huyện
        provinceComboBox.setOnAction(event -> {
            Province province = provinceComboBox.getValue();
            if (province != null) {
                districtComboBox.setDisable(false);
                Task<ObservableList<District>> loadDistrictsTask = new Task<ObservableList<District>>() {
                    @Override
                    protected ObservableList<District> call() throws Exception {
                        return AddressAPI.getDistricts(province.getCode());
                    }
                };
                loadDistrictsTask.setOnSucceeded(ev -> {
                    districtComboBox.setItems(loadDistrictsTask.getValue());
                    // Reset lại danh sách xã khi tỉnh thay đổi
                    wardComboBox.getItems().clear();
                    wardComboBox.setDisable(true);
                });
                new Thread(loadDistrictsTask).start();
            }
        });

        // Khi chọn huyện, tải danh sách xã
        districtComboBox.setOnAction(event -> {
            District district = districtComboBox.getValue();
            if (district != null) {
                wardComboBox.setDisable(false);
                Task<ObservableList<Ward>> loadWardsTask = new Task<ObservableList<Ward>>() {
                    @Override
                    protected ObservableList<Ward> call() throws Exception {
                        return AddressAPI.getWards(district.getCode());
                    }
                };
                loadWardsTask.setOnSucceeded(ev -> wardComboBox.setItems(loadWardsTask.getValue()));
                new Thread(loadWardsTask).start();
            }
        });

        // Khi nhấn nút xác nhận, ghép chuỗi địa chỉ và đóng cửa sổ
        confirmButton.setOnAction(event -> {
            Province province = provinceComboBox.getValue();
            District district = districtComboBox.getValue();
            Ward ward = wardComboBox.getValue();
            String street = streetTextField.getText();
            String houseNumber = houseNumberTextField.getText();

            if (province != null && district != null && ward != null 
                    && street != null && !street.isEmpty() 
                    && houseNumber != null && !houseNumber.isEmpty()) {
                selectedAddress = houseNumber + ", " + street + ", " 
                                  + ward.getName() + ", " + district.getName() + ", " + province.getName();
                Stage stage = (Stage) confirmButton.getScene().getWindow();
                stage.close();
            } else {
            	selectedAddress = "";
            }
        });
    }

    public String getSelectedAddress() {
        return selectedAddress;
    }
}
