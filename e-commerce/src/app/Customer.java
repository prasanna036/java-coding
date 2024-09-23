package app;
import java.util.*;
public class Customer extends User {

	public Customer(int userId, String username, String password) {
		super(userId, username, password);
		// TODO Auto-generated constructor stub
	}
	
	private List<Order> orderHistory=new ArrayList<>();
	public void buyItem(Admin admin,int Itemid,int quantity) {
		List<Item> items=admin.getItems();
		for(Item item:items) {
			if(item.getItemId()==Itemid) {
				double discount = item.getDiscount();
                double totalPrice = item.getPrice() * quantity;
                boolean discountApplied = false;

                if (discount > 0) {
                    totalPrice = totalPrice - (totalPrice * discount / 100);
                    discountApplied = true;
                }
                Order order=new Order(orderHistory.size() + 1, item, quantity, totalPrice, discountApplied);
                orderHistory.add(order);
			}
			
		}
		
	}
	public void viewOrderHistory() {
		for(Order order:orderHistory) {
			System.out.println(order);
		}
	}
}
