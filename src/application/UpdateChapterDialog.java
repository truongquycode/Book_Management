package application;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UpdateChapterDialog {

    // Lớp chứa thông tin chương được chọn và chỉnh sửa
    public static class UpdateChapterInfo {
        private final int chapterId;
        private final String chapterTitle;
        private final String chapterContent;

        public UpdateChapterInfo(int chapterId, String chapterTitle, String chapterContent) {
            this.chapterId = chapterId;
            this.chapterTitle = chapterTitle;
            this.chapterContent = chapterContent;
        }

        public int getChapterId() {
            return chapterId;
        }

        public String getChapterTitle() {
            return chapterTitle;
        }

        public String getChapterContent() {
            return chapterContent;
        }
    }

    // Lớp đại diện cho một chương trong ComboBox
    public static class ChapterRecord {
        private final int chapterId;
        private final int chapterNumber;
        private final String chapterTitle;
        private final String chapterContent;

        public ChapterRecord(int chapterId, int chapterNumber, String chapterTitle, String chapterContent) {
            this.chapterId = chapterId;
            this.chapterNumber = chapterNumber;
            this.chapterTitle = chapterTitle;
            this.chapterContent = chapterContent;
        }

        public int getChapterId() {
            return chapterId;
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

        @Override
        public String toString() {
            return "Chương " + chapterNumber + ": " + chapterTitle;
        }
    }

    // Phương thức lấy danh sách các chương của sách từ DB
    private static List<ChapterRecord> getChaptersForBook(String bookName) {
        List<ChapterRecord> list = new ArrayList<>();
        Connection conn = DataBaseConnect.getConnection();
        try {
            String sql = "SELECT c.chapter_id, c.chapter_number, c.title, cc.content " +
                         "FROM chapters c " +
                         "JOIN chapter_contents cc ON c.chapter_id = cc.chapter_id " +
                         "WHERE c.name = ? " +
                         "ORDER BY c.chapter_number";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, bookName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int chapterId = rs.getInt("chapter_id");
                int chapterNumber = rs.getInt("chapter_number");
                String title = rs.getString("title");
                String content = rs.getString("content");
                list.add(new ChapterRecord(chapterId, chapterNumber, title, content));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseConnect.closeConnection(conn);
        }
        return list;
    }

    // Phương thức hiển thị dialog cập nhật chương, trả về thông tin cập nhật
    public static Optional<UpdateChapterInfo> showDialog(String bookName) {
        List<ChapterRecord> chapters = getChaptersForBook(bookName);
        if (chapters.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Sách chưa có chương nào để cập nhật.");
            alert.showAndWait();
            return Optional.empty();
        }

        Dialog<UpdateChapterInfo> dialog = new Dialog<>();
        dialog.setTitle("Cập nhật Chương");
        dialog.setHeaderText("Chọn và cập nhật chương cho sách: " + bookName);

        ButtonType updateButtonType = new ButtonType("Cập nhật", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(updateButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        ComboBox<ChapterRecord> chapterComboBox = new ComboBox<>();
        chapterComboBox.getItems().addAll(chapters);
        chapterComboBox.setPromptText("Chọn chương");

        TextField titleField = new TextField();
        titleField.setPromptText("Tiêu đề chương");

        TextArea contentArea = new TextArea();
        contentArea.setPromptText("Nội dung chương");
        contentArea.setPrefRowCount(10);

        // Khi người dùng chọn chương, cập nhật tiêu đề và nội dung
        chapterComboBox.setOnAction(e -> {
            ChapterRecord selected = chapterComboBox.getSelectionModel().getSelectedItem();
            if (selected != null) {
                titleField.setText(selected.getChapterTitle());
                contentArea.setText(selected.getChapterContent());
            }
        });

        grid.add(new Label("Chọn chương:"), 0, 0);
        grid.add(chapterComboBox, 1, 0);
        grid.add(new Label("Tiêu đề:"), 0, 1);
        grid.add(titleField, 1, 1);
        grid.add(new Label("Nội dung:"), 0, 2);
        grid.add(contentArea, 1, 2);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == updateButtonType) {
                ChapterRecord selected = chapterComboBox.getSelectionModel().getSelectedItem();
                if (selected != null) {
                    return new UpdateChapterInfo(selected.getChapterId(), titleField.getText().trim(),
                            contentArea.getText().trim());
                }
            }
            return null;
        });

        return dialog.showAndWait();
    }
}
