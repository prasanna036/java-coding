package app;
import java.util.*;
public class UserManager {
	private Map<String,Admin>admins=new HashMap<>();
	private Map<String,Customer>customer=new HashMap<>();
	 public void RegisterAdmin(int userId, String username, String password) {
		 Admin admi=new Admin(userId,username,password);
		 admins.put(username,admi);
	 }
	 public void RegisterCustomer(int userId, String username, String password) {
		 Customer cus=new Customer(userId,username,password);
		 customer.put(username,cus);
	 }
	 public Admin AdminLogin(String username,String Password) {
		 Admin admin=admins.get(username);
		 if(admin!=null && admin.checkpassword(Password)) {
			 System.out.println("Login Succesful");
			 return admin;
		 }
		 else {
			 System.out.println("Invalid credentials");
			 return null;
		 }
	 }
	 public Customer CustomerLogin(String username,String Password) {
		 Customer cus=customer.get(username);
		 if(cus!=null && cus.checkpassword(Password)) {
			 System.out.println("Login Succesful");
			 return cus;
		 }
		 else {
			 System.out.println("Invalid credentials");
			 return null;
		 }
	 }
	 
	 
}
