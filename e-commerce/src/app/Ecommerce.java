package app;

import java.util.*;

public class Ecommerce {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		UserManager userManager = new UserManager();
		 Admin currentAdmin = null;
	     Customer currentCustomer = null;
		int currentadminid=1;
		int currentcusid=1;
		while(true) {
			
			System.out.println("1. Admin Registration\n2. Customer Registration\n3. Admin Login\n4. Customer Login\n5. Exit");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.print("Enter admin username: ");
                String adminUsername = sc.next();
                System.out.print("Enter admin password: ");
                String adminPassword = sc.next();
                userManager.RegisterAdmin(currentadminid++, adminUsername, adminPassword);
                break;
			case 2:
				System.out.print("Enter customer username: ");
				String cusUsername = sc.next();
				System.out.print("Enter customer password: ");
				String cusPassword = sc.next();
				userManager.RegisterCustomer(currentcusid++, cusUsername,cusPassword);
				break;
			case 3:
				System.out.print("Enter admin username: ");
                adminUsername = sc.next();
                System.out.print("Enter admin password: ");
                adminPassword = sc.next();
                currentAdmin = userManager.AdminLogin(adminUsername, adminPassword);
                if (currentAdmin != null) {
                    adminMenu(currentAdmin);
                }
                break;
            case 4:
                System.out.print("Enter customer username: ");
                String customerUsername = sc.next();
                System.out.print("Enter customer password: ");
                String customerPassword = sc.next();
                currentCustomer = userManager.CustomerLogin(customerUsername, customerPassword);
                if (currentCustomer != null) {
                    customerMenu(currentCustomer, currentAdmin);
                }
                break;
            case 5:
                System.out.println("Exiting...");
                sc.close();
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void adminMenu(Admin admin) {
		Scanner scanner=new Scanner(System.in);
		while (true) {
            System.out.println("1. Add Item\n2. View Items\n3. Logout");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item ID: ");
                    int itemId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double itemPrice = scanner.nextDouble();
                    System.out.print("Enter item discount: ");
                    double itemDiscount = scanner.nextDouble();
                    Item item = new Item(itemId, itemName, itemPrice, itemDiscount);
                    admin.additem(item);
                    break;
                case 2:
                    admin.viewItem();
                    break;
                case 3:
                    return; // Logout
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
		}
		
	}

	private static void customerMenu(Customer customer, Admin admin) {
		Scanner sc=new Scanner(System.in);
		while (true) {
            System.out.println("1. Buy Item\n2. View Order History\n3. Logout");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (admin == null) {
                        System.out.println("No admin available to add items.");
                        return;
                    }
                    System.out.print("Enter item ID to buy: ");
                    int itemId = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    customer.buyItem(admin, itemId, quantity);
                    break;
                case 2:
                    customer.viewOrderHistory();
                    break;
                case 3:
                    return; // Logout
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
		
	}

}
