package banking;
import java.util.*;
public class app extends UserManager {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int usercounter=1;
		User currentuser=null;
        UserManager usermanager=new UserManager();
        while (true) {
            System.out.println("\nWelcome to the Banking App");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                	System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    int balance=0;
                    usermanager.registeruser(usercounter, username, password, balance);
                    break;
                case 2:
                	System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    currentuser=usermanager.loginuser(username, password);
                    if(currentuser!=null) {
                    	usermenu(currentuser);
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the Banking App.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
    }
	public static void usermenu(User user) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
            System.out.println("\nWelcome, " + user.getUsername());
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
            case 1:
            	System.out.println("Balance"+user.getBalance());
            	break;
            case 2:
            	 System.out.print("Enter amount to deposit: ");
                 int depositAmount = sc.nextInt();
                 user.deposit(depositAmount);
                 System.out.println("Deposit successful. Your new balance is: " + user.getBalance());
                 break;
            case 3:
            	System.out.print("Enter amount to withdraw: ");
                int withdrawAmount = sc.nextInt();
                user.withdraw(withdrawAmount);
                System.out.println("Withdraw successful. Your new balance is: " + user.getBalance());
                break;
            case 4:
            	return;
            default:
            	System.out.println("Invalid choice");
            }
            
		}
    }
	

}
