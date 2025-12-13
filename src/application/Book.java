package application;

public class Book {
	private int id_auto;
	private String id;
	private String image;
	private String name;
	private String author;
	private String genre;
	private double price;
	private int stock;
	private int pub_year;
	private String des;
	private boolean status;
	private String linkEbook;
	
	
	
	
	

	public String getLinkEbook() {
		return linkEbook;
	}

	public void setLinkEbook(String linkEbook) {
		this.linkEbook = linkEbook;
	}

	public Book(int id_auto, String id, String image, String name, String author, String genre, double price, int stock,
			int pub_year, String des, boolean status) {
		super();
		this.id_auto = id_auto;
		this.id = id;
		this.image = image;
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.price = price;
		this.stock = stock;
		this.pub_year = pub_year;
		this.des = des;
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId_auto() {
		return id_auto;
	}
	public void setId_auto(int id_auto) {
		this.id_auto = id_auto;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPub_year() {
		return pub_year;
	}
	public void setPub_year(int pub_year) {
		this.pub_year = pub_year;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public Book(int id_auto, String id, String image, String name, String author, String genre, double price, int stock,
			int pub_year, String des) {
		super();
		this.id_auto = id_auto;
		this.id = id;
		this.image = image;
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.price = price;
		this.stock = stock;
		this.pub_year = pub_year;
		this.des = des;
	}
	public Book() {
		super();
	}
	public Book(String id, String image, String name, String author, String genre, double price, int stock,
			int pub_year, String des, boolean status, String link) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.price = price;
		this.stock = stock;
		this.pub_year = pub_year;
		this.des = des;
		this.status = status;
		this.linkEbook = link;
	}
	
	public Book(String id, String image, String name, String author, String genre, double price, int stock,
			int pub_year, String des) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.price = price;
		this.stock = stock;
		this.pub_year = pub_year;
		this.des = des;
	}
	
	
	
	public Book(String image, String name) {
		super();
		this.image = image;
		this.name = name;
	}

	public Book(int id_auto, String id, String image, String name, Double price) {
		super();
		this.id_auto = id_auto;
		this.id = id;
		this.image = image;
		this.name = name;
		this.price = price;
	}
	public Book(String image, String name, Double price) {
		super();
		this.image = image;
		this.name = name;
		this.price = price;
	}
	
	
	
	
	
	
}
