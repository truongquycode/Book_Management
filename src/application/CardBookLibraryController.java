package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CardBookLibraryController implements Initializable {
    @FXML
    private VBox book_form;
    
    @FXML
    private Button book_detailBtn;
    
    public Button getBookDetailButton() {
        return book_detailBtn;
    }

    @FXML
    private ImageView book_imageView;

    @FXML
    private Label book_nameText;
    
    @FXML
    private Label book_detail_id;
    
    private Book book;
    
    private Image image;
    
    private FrontEndController frontEndController; // tham chiếu tới controller giao diện chính

    // Setter để truyền FrontEndController từ bên ngoài
    public void setFrontEndController(FrontEndController frontEndController) {
        this.frontEndController = frontEndController;
    }
    
    public void setData(Book book) {
        this.book = book;
        book_nameText.setText(book.getName());
        String path = getClass().getResource(book.getImage()).toExternalForm();
        image = new Image(path, 139, 192, false, true);
        book_imageView.setImage(image);
    }
    
    public Book getBook() {
        return this.book;
    }
    
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
    
    private List<ChapterRecord> getChaptersForBook(String bookName) {
        List<ChapterRecord> list = new ArrayList<>();
        String sql = "SELECT c.chapter_id, c.chapter_number, c.title, cc.content " +
                     "FROM chapters c " +
                     "JOIN chapter_contents cc ON c.chapter_id = cc.chapter_id " +
                     "WHERE c.name = ? " +
                     "ORDER BY c.chapter_number";
        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bookName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int chapterId = rs.getInt("chapter_id");
                int chapterNumber = rs.getInt("chapter_number");
                String title = rs.getString("title");
                String content = rs.getString("content");
                list.add(new ChapterRecord(chapterId, chapterNumber, title, content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void showDetailBook() {
        if (book == null) {
            System.out.println("Lỗi: Chưa chọn sách.");
            return;
        }
        
        // Lấy danh sách chương của sách đã chọn từ DB
        List<ChapterRecord> chapters = getChaptersForBook(book.getName());
        if (chapters.isEmpty()){
            AlertMessage alert = new AlertMessage();
            alert.errorMessage("Sách này chưa có nội dung!!!");
            return;
        }
        
        // Label hiển thị tiêu đề chương in đậm
        Label chapterTitleLabel = new Label();
        chapterTitleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333;");
        chapterTitleLabel.setAlignment(Pos.CENTER);
        
        // TextArea hiển thị nội dung chương
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setEditable(false);
        textArea.setPrefSize(600, 400);
        textArea.setStyle("-fx-font-size: 14px; -fx-text-fill: #333; -fx-control-inner-background: #fafafa; -fx-border-color: #ccc;");
        
        // ScrollPane chứa TextArea
        ScrollPane scrollPane = new ScrollPane(textArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setPrefSize(600, 400);
        scrollPane.setStyle("-fx-background-color: transparent;");
        
        // ComboBox chứa danh sách chương hiện có
        ComboBox<ChapterRecord> chapterComboBox = new ComboBox<>();
        chapterComboBox.getItems().addAll(chapters);
        chapterComboBox.getSelectionModel().selectFirst();
        chapterComboBox.setStyle("-fx-font-size: 14px; -fx-padding: 5px;");
        
        // Hàm cập nhật nội dung và tiêu đề chương dựa trên ChapterRecord được chọn
        Runnable updateUI = () -> {
            ChapterRecord selected = chapterComboBox.getSelectionModel().getSelectedItem();
            if (selected != null) {
                chapterTitleLabel.setText("Chương " + selected.getChapterNumber() + ": " + selected.getChapterTitle());
                textArea.setText(selected.getChapterContent());
            }
        };
        
        // Khi người dùng thay đổi lựa chọn trong ComboBox
        chapterComboBox.setOnAction(e -> updateUI.run());
        
        // Nút "Trước" và "Tiếp" để điều hướng chương
        Button btnPrevious = new Button("Trước");
        Button btnNext = new Button("Tiếp");
        btnPrevious.setStyle("-fx-font-size: 14px; -fx-background-color: #0096C9; -fx-text-fill: white; -fx-padding: 5 10 5 10;");
        btnNext.setStyle("-fx-font-size: 14px; -fx-background-color: #0096C9; -fx-text-fill: white; -fx-padding: 5 10 5 10;");
        
        btnPrevious.setOnAction(e -> {
            int idx = chapterComboBox.getSelectionModel().getSelectedIndex();
            if (idx > 0) {
                chapterComboBox.getSelectionModel().select(idx - 1);
                updateUI.run();
            }
        });
        
        btnNext.setOnAction(e -> {
            int idx = chapterComboBox.getSelectionModel().getSelectedIndex();
            if (idx < chapterComboBox.getItems().size() - 1) {
                chapterComboBox.getSelectionModel().select(idx + 1);
                updateUI.run();
            }
        });
        
        // HBox chứa các nút và ComboBox, căn giữa
        HBox navigationBox = new HBox(10, btnPrevious, chapterComboBox, btnNext);
        navigationBox.setAlignment(Pos.CENTER);
        navigationBox.setStyle("-fx-padding: 10; -fx-background-color: transparent;");
        
        // Sắp xếp giao diện: tiêu đề chương (Label) ở trên, sau đó là ScrollPane, và cuối cùng là điều hướng
        VBox contentBox = new VBox(10, chapterTitleLabel, scrollPane, navigationBox);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setStyle("-fx-padding: 20; -fx-background-color: #ffffff;");
        
        // Tạo Alert với nội dung chi tiết chương
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Nội dung Chương");
        alert.setHeaderText("Sách: " + book.getName());
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setContent(contentBox);
        dialogPane.setPrefSize(650, 600);
        // Áp dụng CSS trực tiếp cho DialogPane nếu cần
        dialogPane.setStyle(
            "-fx-font-family: 'Segoe UI';" +
            "-fx-background-color: #fafafa;" +
            "-fx-border-color: #ccc;" +
            "-fx-border-width: 1px;"
        );
        
     // Sử dụng Platform.runLater để đảm bảo các node đã được render, sau đó cập nhật CSS cho header
        javafx.application.Platform.runLater(() -> {
            Label headerLabel = (Label) dialogPane.lookup(".header-panel .label");
            if (headerLabel != null) {
                headerLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #336699; -fx-alignment: center;");
            }
        });
        
        // Load nội dung của chương đầu tiên
        updateUI.run();
        
        alert.showAndWait();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Khởi tạo, nếu cần
    }
}
