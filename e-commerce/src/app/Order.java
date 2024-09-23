package app;

public class Order {
	private int orderId;
    private Item item;
    private int quantity;
    private double totalPrice;
    private boolean discountApplied;
	
	public Order(int orderId, Item item, int quantity, double totalPrice, boolean discountApplied) {
		this.orderId = orderId;
		this.item = item;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.discountApplied = discountApplied;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public boolean isDiscountApplied() {
		return discountApplied;
	}
	public void setDiscountApplied(boolean discountApplied) {
		this.discountApplied = discountApplied;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", item=" + item + ", quantity=" + quantity + ", totalPrice=" + totalPrice
				+ ", discountApplied=" + discountApplied + "]";
	}
	
    
}
