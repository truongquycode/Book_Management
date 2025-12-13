package application;

import javafx.scene.control.*;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.util.Pair;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;
import java.util.stream.IntStream;

public class DatePickerDialog {

    public static Pair<String, Void> showDatePicker(String date) {
        Dialog<Pair<String, Void>> dialog = new Dialog<>();
        dialog.setTitle("Chọn Ngày, Tháng và Năm");
        dialog.setHeaderText("Vui lòng chọn ngày, tháng và năm để xem doanh thu");

        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

        ChoiceBox<Integer> dayChoice = new ChoiceBox<>();
        ChoiceBox<String> monthChoice = new ChoiceBox<>();
        ChoiceBox<Integer> yearChoice = new ChoiceBox<>();
        

        // Lấy ngày hiện tại làm giá trị mặc định
        int currentYear = Integer.parseInt(date.split("/")[2]);
        int currentMonth = Integer.parseInt(date.split("/")[1]);
        int currentDay = Integer.parseInt(date.split("/")[0]);

        // Thêm danh sách tháng theo định dạng 01, 02, ..., 12
        IntStream.rangeClosed(1, 12).forEach(i -> monthChoice.getItems().add(String.format("%02d", i)));
        monthChoice.setValue(String.format("%02d", currentMonth));

        // Thêm danh sách năm (10 năm trước đến năm hiện tại)
        IntStream.rangeClosed(currentYear - 10, currentYear).forEach(yearChoice.getItems()::add);
        yearChoice.setValue(currentYear);

        // Cập nhật danh sách ngày theo tháng và năm được chọn
        Runnable updateDays = () -> {
            int selectedMonth = Integer.parseInt(monthChoice.getValue());
            int selectedYear = yearChoice.getValue();
            int maxDays = YearMonth.of(selectedYear, selectedMonth).lengthOfMonth();
            dayChoice.getItems().clear();
            IntStream.rangeClosed(1, maxDays).forEach(dayChoice.getItems()::add);
            // Đặt lại giá trị ngày sao cho không vượt quá số ngày của tháng mới
            dayChoice.setValue(Math.min(currentDay, maxDays));
        };

        // Lắng nghe thay đổi tháng hoặc năm để cập nhật ngày khi dùng chuột click (hoặc arrow keys)
        monthChoice.setOnAction(e -> updateDays.run());
        yearChoice.setOnAction(e -> updateDays.run());

        // Khởi tạo danh sách ngày
        updateDays.run();

        // Thêm sự kiện lăn chuột cho dayChoice
        dayChoice.addEventFilter(ScrollEvent.SCROLL, e -> {
            int index = dayChoice.getItems().indexOf(dayChoice.getValue());
            if (e.getDeltaY() > 0 && index > 0) {
                dayChoice.setValue(dayChoice.getItems().get(index - 1));
            } else if (e.getDeltaY() < 0 && index < dayChoice.getItems().size() - 1) {
                dayChoice.setValue(dayChoice.getItems().get(index + 1));
            }
            e.consume();
        });

        // Thêm sự kiện lăn chuột cho monthChoice
        monthChoice.addEventFilter(ScrollEvent.SCROLL, e -> {
            int index = monthChoice.getItems().indexOf(monthChoice.getValue());
            if (e.getDeltaY() > 0 && index > 0) {
                monthChoice.setValue(monthChoice.getItems().get(index - 1));
                updateDays.run();
            } else if (e.getDeltaY() < 0 && index < monthChoice.getItems().size() - 1) {
                monthChoice.setValue(monthChoice.getItems().get(index + 1));
                updateDays.run();
            }
            e.consume();
        });

        // Thêm sự kiện lăn chuột cho yearChoice
        yearChoice.addEventFilter(ScrollEvent.SCROLL, e -> {
            int index = yearChoice.getItems().indexOf(yearChoice.getValue());
            if (e.getDeltaY() > 0 && index > 0) {
                yearChoice.setValue(yearChoice.getItems().get(index - 1));
                updateDays.run();
            } else if (e.getDeltaY() < 0 && index < yearChoice.getItems().size() - 1) {
                yearChoice.setValue(yearChoice.getItems().get(index + 1));
                updateDays.run();
            }
            e.consume();
        });

        HBox content = new HBox(10, new Label("Ngày:"), dayChoice, new Label("Tháng:"), monthChoice, new Label("Năm:"), yearChoice);
        dialog.getDialogPane().setContent(content);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == okButtonType) {
                String formattedDate = String.format("%02d/%s/%d", dayChoice.getValue(), monthChoice.getValue(), yearChoice.getValue());
                return new Pair<>(formattedDate, null);
            }
            return null;
        });

        Optional<Pair<String, Void>> result = dialog.showAndWait();
        return result.orElse(null);
    }
}
