package application;

public class Cart {
	private String name;
	private Double price;
	private int quantity;
	private String fullname;
	private boolean selected;
	private String loaisach;

	public String getLoaisach() {
		return loaisach;
	}

	public void setLoaisach(String loaisach) {
		this.loaisach = loaisach;
	}
	
	public Cart(String name, Double price, int quantity, String fullname, boolean selected, String loaisach) {
	    this.name = name;
	    this.price = price;
	    this.quantity = quantity;
	    this.fullname = fullname;
	    this.selected = selected;
	    this.loaisach = loaisach;
	}

	public Cart(String name, Double price, int quantity, String fullname, boolean selected) {
	    this.name = name;
	    this.price = price;
	    this.quantity = quantity;
	    this.fullname = fullname;
	    this.selected = selected;
	}

	public boolean isSelected() {
	    return selected;
	}

	public void setSelected(boolean selected) {
	    this.selected = selected;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	
	
	
	
	
}
