package app;
import java.util.*;
public class Admin extends User {

	public Admin(int userId, String username, String password) {
		super(userId, username, password);
	}
	private List<Item> items=new ArrayList<>();
	
	public void additem(Item item) {
		items.add(item);
	}
	
	public void viewItem() {
		for(Item item :items) {
			System.out.println(item);
		}
	}
	public List<Item> getItems() {
		return items;
	}
	
}
