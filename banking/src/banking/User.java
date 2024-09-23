package banking;

public class User {
	private int id;
	private String Username;
	private String Password;
	private int balance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public User(int id, String username, String password, int balance) {
		super();
		this.id = id;
		Username = username;
		Password = password;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", Username=" + Username + ", Password=" + Password + ", balance=" + balance + "]";
	}
	public boolean checkPassword(String Password) {
		return this.Password.equals(Password);
	}
	public void deposit(int depositAmount) {
		balance+=depositAmount;
	}
	public void withdraw(int withdrawAmount) {
		balance-=withdrawAmount;
	}
	
}
