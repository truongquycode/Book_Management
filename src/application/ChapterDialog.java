package application;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ChapterDialog {

    // Lớp chứa thông tin chương
    public static class ChapterInfo {
        private final int chapterNumber;
        private final String chapterTitle;
        private final String chapterContent;

        public ChapterInfo(int chapterNumber, String chapterTitle, String chapterContent) {
            this.chapterNumber = chapterNumber;
            this.chapterTitle = chapterTitle;
            this.chapterContent = chapterContent;
        }

        public int getChapterNumber() {
            return chapterNumber;
        }

        public String getChapterTitle() {
            return chapterTitle;
        }

        public String getChapterContent() {
            return chapterContent;
        }
    }

    // Phương thức hiển thị dialog và trả về thông tin chương mới
    // Tự động truy xuất DB để lấy số chương lớn nhất hiện tại của sách, dùng làm mặc định cho trường "Chương số"
    public static Optional<ChapterInfo> showDialog(String bookName) {
        // Lấy số chương lớn nhất hiện tại của sách từ DB
        int lastChapterNumber = 0;
        Connection conn = DataBaseConnect.getConnection();
        try {
            String sql = "SELECT MAX(chapter_number) AS maxChapter FROM chapters WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, bookName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                lastChapterNumber = rs.getInt("maxChapter"); // Nếu không có bản ghi nào thì trả về 0
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseConnect.closeConnection(conn);
        }

        // Tạo dialog mới
        Dialog<ChapterInfo> dialog = new Dialog<>();
        dialog.setTitle("Thêm Chương Mới");
        dialog.setHeaderText("Nhập thông tin chương mới cho sách: " + bookName);

        // Định nghĩa nút Tạo và Hủy
        ButtonType createButtonType = new ButtonType("Tạo", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButtonType, ButtonType.CANCEL);

        // Tạo giao diện nhập liệu
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField chapterNumberField = new TextField();
        chapterNumberField.setPromptText("Chương số");
        // Thiết lập mặc định là chương kế tiếp
        chapterNumberField.setText(String.valueOf(lastChapterNumber + 1));

        TextField chapterTitleField = new TextField();
        chapterTitleField.setPromptText("Tiêu đề chương");

        TextArea chapterContentArea = new TextArea();
        chapterContentArea.setPromptText("Nội dung chương");
        chapterContentArea.setPrefRowCount(10);

        grid.add(new Label("Chương số:"), 0, 0);
        grid.add(chapterNumberField, 1, 0);
        grid.add(new Label("Tiêu đề:"), 0, 1);
        grid.add(chapterTitleField, 1, 1);
        grid.add(new Label("Nội dung:"), 0, 2);
        grid.add(chapterContentArea, 1, 2);

        dialog.getDialogPane().setContent(grid);

        // Chuyển đổi kết quả khi nhấn nút Tạo
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButtonType) {
                int chapterNumber = 0;
                try {
                    chapterNumber = Integer.parseInt(chapterNumberField.getText().trim());
                } catch (NumberFormatException e) {
                    // Nếu nhập không hợp lệ, trả về null
                    return null;
                }
                return new ChapterInfo(chapterNumber, chapterTitleField.getText().trim(),
                        chapterContentArea.getText().trim());
            }
            return null;
        });

        return dialog.showAndWait();
    }
}
