package banking;

import java.util.HashMap;
import java.util.Map;


import java.util.*;

public class UserManager {

	private Map<String,User>users=new HashMap<>();
	public void registeruser(int userId,String username,String password,int balance) {
		User user=new User(userId,username,password,balance);
		users.put(username,user);
	}
	public User loginuser(String username,String password) {
		User user=users.get(username);
		if(user!=null && user.checkPassword(password)) {
			System.out.println("Login Succesfull");
			return user;
		}
		else {
			System.out.println("Invalid Credentials");
			return null;
		}
	}
}
