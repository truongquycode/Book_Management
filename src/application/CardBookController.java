package application;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class CardBookController implements Initializable{
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
    private Label priceText;
    
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
    	book_detail_id.setText(book.getId());
    	book_nameText.setText(book.getName());
    	double price = book.getPrice();
//    	System.out.println(price);
    	DecimalFormat df = new DecimalFormat("#,###");
//    	System.out.println(df.format(price));
    	priceText.setText(df.format(price));
    	String path = getClass().getResource(book.getImage()).toExternalForm();
//    	String path = "file:"+ book.getImage();
    	image = new Image(path, 139, 192, false, true);
    	book_imageView.setImage(image);
    	
    }
    
    public Book getBook() {
        return this.book;
    }
    
    public void showDetailBook() {
    	if (frontEndController != null) {
            frontEndController.showBookDetail(book);
        } else {
        	System.out.println("Loi chua thiet lap frontend");
        }
    }
    


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
