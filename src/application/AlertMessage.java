package application;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class AlertMessage {

    // Hiển thị thông báo lỗi với các hiệu ứng và tắt khi nhấn vào bất kỳ đâu
    public void errorMessage(String message) {
        showCustomAlert("Thông báo lỗi", message, true, true);
    }

    // Hiển thị thông báo thành công với các hiệu ứng và tắt khi nhấn vào bất kỳ đâu
    public void successMessage(String message) {
        showCustomAlert("Thành công", message, true, false);
    }

    // Hiển thị hộp xác nhận và trả về true nếu người dùng nhấn "Xác nhận", false nếu "Hủy"
    // Ở hộp xác nhận, không cho phép tắt khi click bên ngoài để đảm bảo lựa chọn rõ ràng.
    public boolean ConfirmMessage(String message) {
        final boolean[] result = { false };
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED); // Bỏ khung hệ thống
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Xác nhận hành động");

        // Tạo container bên ngoài (StackPane) với nền mờ
        StackPane rootStack = new StackPane();
        rootStack.setStyle("-fx-background-color: rgba(0, 0, 0, 0.3);");

        // Container hộp thoại (VBox)
        VBox dialog = new VBox(10);
        dialog.setAlignment(Pos.CENTER);
        dialog.setPadding(new Insets(20));

        Label header = new Label("Bạn có chắc với hành động này không?");
        header.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #0096C9;");
        Label content = new Label(message);
        content.setStyle("-fx-font-size: 14px; -fx-text-fill: #333;");

        Button btnYes = new Button("Xác nhận");
        Button btnNo = new Button("Hủy");
        btnYes.setDefaultButton(true);
        String btnStyle = "-fx-background-color: #0096C9; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 0;";
        btnYes.setStyle(btnStyle);
        btnNo.setStyle(btnStyle);

        btnYes.setOnAction(e -> {
            result[0] = true;
            stage.close();
        });
        btnNo.setOnAction(e -> {
            result[0] = false;
            stage.close();
        });

        HBox buttonBox = new HBox(10, btnYes, btnNo);
        buttonBox.setAlignment(Pos.CENTER);

        dialog.getChildren().addAll(header, content, buttonBox);
        // Giao diện hộp xác nhận (không bo góc)
        dialog.setStyle(
            "-fx-font-family: 'Segoe UI';" +
            "-fx-font-size: 14px;" +
            "-fx-background-color: #f0f0f0;" +
            "-fx-border-color: #0096C9;" +
            "-fx-border-width: 2px;" +
            "-fx-background-radius: 0;" +
            "-fx-border-radius: 0;"
        );
        
        // Với Confirm, không cho phép click để tắt
        rootStack.getChildren().add(dialog);

        Scene scene = new Scene(rootStack);
        stage.setScene(scene);
        // Không thiết lập sự kiện click cho confirm để tránh đóng nhầm
        // rootStack.setOnMouseClicked(e -> stage.close());

        // Hiệu ứng fade-in
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), rootStack);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        stage.showAndWait();
        return result[0];
    }

    /**
     * Tạo cửa sổ thông báo tùy chỉnh cho lỗi hoặc thành công.
     * Khi click vào bất kỳ đâu (bao gồm cả bên trong hộp thông báo), thông báo sẽ tắt ngay.
     * 
     * @param title       Tiêu đề ("Thông báo lỗi" hoặc "Thành công")
     * @param message     Nội dung thông báo
     * @param onAutoClose Nếu true, tự đóng sau 2 giây với fade-out
     * @param isError     Nếu true, áp dụng giao diện lỗi; nếu false, giao diện thành công.
     */
    private void showCustomAlert(String title, String message, boolean onAutoClose, boolean isError) {
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED); // Bỏ khung hệ thống
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);

        // Container nền bao phủ toàn màn hình với nền mờ
        StackPane rootStack = new StackPane();
        rootStack.setStyle("-fx-background-color: rgba(0, 0, 0, 0.3);");

        // Hộp thoại chính (VBox)
        VBox dialog = new VBox(10);
        dialog.setAlignment(Pos.CENTER);
        dialog.setPadding(new Insets(20));

        // Tiêu đề và icon
        Label lblTitle = new Label(title);
        lblTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label icon = new Label();
        Label lblMessage = new Label(message);
        lblMessage.setStyle("-fx-font-size: 14px; -fx-text-fill: #333;");

        if (isError) {
            // Giao diện lỗi: nền hồng nhạt, viền đỏ, không bo góc, icon lỗi
            lblTitle.setStyle(lblTitle.getStyle() + " -fx-text-fill: #ff0000;");
            icon.setText("❌");
            icon.setStyle("-fx-font-size: 20px; -fx-text-fill: #ff0000;");
            HBox contentBox = new HBox(10, icon, lblMessage);
            contentBox.setAlignment(Pos.CENTER);
            dialog.getChildren().addAll(lblTitle, contentBox);
            dialog.setStyle(
                "-fx-font-family: 'Segoe UI';" +
                "-fx-font-size: 14px;" +
                "-fx-background-color: #ffcccc;" +  // nền hồng nhạt
                "-fx-border-color: #ff0000;" +
                "-fx-border-width: 2px;" +
                "-fx-background-radius: 0;" +
                "-fx-border-radius: 0;"
            );
        } else {
            // Giao diện thành công: nền xanh nhạt, viền xanh, không bo góc, icon thành công
            lblTitle.setStyle(lblTitle.getStyle() + " -fx-text-fill: #008000;");
            icon.setText("✅");
            icon.setStyle("-fx-font-size: 20px; -fx-text-fill: #008000;");
            HBox contentBox = new HBox(10, icon, lblMessage);
            contentBox.setAlignment(Pos.CENTER);
            dialog.getChildren().addAll(lblTitle, contentBox);
            dialog.setStyle(
                "-fx-font-family: 'Segoe UI';" +
                "-fx-font-size: 14px;" +
                "-fx-background-color: #ccffcc;" +  // nền xanh nhạt
                "-fx-border-color: #008000;" +
                "-fx-border-width: 2px;" +
                "-fx-background-radius: 0;" +
                "-fx-border-radius: 0;"
            );
        }

        // Đặt hộp thoại vào giữa rootStack
        rootStack.getChildren().add(dialog);

        // Khi click vào bất kỳ đâu trên rootStack (bao gồm cả bên trong hộp thông báo),
        // sẽ đóng luôn thông báo.
        rootStack.setOnMouseClicked(e -> stage.close());

        Scene scene = new Scene(rootStack);
        stage.setScene(scene);

        // Hiệu ứng fade-in
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), rootStack);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        stage.show();

        if (onAutoClose) {
            // Sau 2 giây, thực hiện fade-out rồi đóng stage
            PauseTransition delay = new PauseTransition(Duration.seconds(3));
            delay.setOnFinished(e -> {
                FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), rootStack);
                fadeOut.setFromValue(1.0);
                fadeOut.setToValue(0.0);
                fadeOut.setOnFinished(ev -> stage.close());
                fadeOut.play();
            });
            delay.play();
        }
    }
}
