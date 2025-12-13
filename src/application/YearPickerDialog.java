package application;

import javafx.scene.control.*;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.util.Pair;

import java.time.Year;
import java.util.Optional;
import java.util.stream.IntStream;

public class YearPickerDialog {

    public static Pair<String, Void> showYearPicker() {
        int currentYear = Year.now().getValue();
        
        Dialog<Pair<String, Void>> dialog = new Dialog<>();
        dialog.setTitle("Chọn Năm");
        dialog.setHeaderText("Vui lòng chọn năm để xem doanh thu");

        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

        ChoiceBox<String> yearChoice = new ChoiceBox<>();

        // Thêm danh sách năm (20 năm trước đến 10 năm sau)
        IntStream.rangeClosed(currentYear - 20, currentYear + 10)
                .forEach(year -> yearChoice.getItems().add(String.valueOf(year)));
        yearChoice.setValue(String.valueOf(currentYear));

        // Thêm sự kiện lăn chuột để thay đổi năm
        yearChoice.addEventFilter(ScrollEvent.SCROLL, e -> {
            int index = yearChoice.getItems().indexOf(yearChoice.getValue());
            if (e.getDeltaY() > 0 && index > 0) {
                yearChoice.setValue(yearChoice.getItems().get(index - 1));
            } else if (e.getDeltaY() < 0 && index < yearChoice.getItems().size() - 1) {
                yearChoice.setValue(yearChoice.getItems().get(index + 1));
            }
            e.consume();
        });

        HBox content = new HBox(10, new Label("Năm:"), yearChoice);
        dialog.getDialogPane().setContent(content);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == okButtonType) {
                return new Pair<>(yearChoice.getValue(), null);
            }
            return null;
        });

        Optional<Pair<String, Void>> result = dialog.showAndWait();
        return result.orElse(null);
    }
}
