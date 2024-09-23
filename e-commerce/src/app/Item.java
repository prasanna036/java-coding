package app;

public class Item {
	private int itemId;
    private String name;
    private double price;
    private double discount;
	public Item(int itemId, String name, double price, double discount) {
		this.itemId = itemId;
		this.name = name;
		this.price = price;
		this.discount = discount;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", price=" + price + ", discount=" + discount + "]";
	}
	
    
    
}
