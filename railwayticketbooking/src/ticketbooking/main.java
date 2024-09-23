package ticketbooking;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        TicketBooker ticketBooker = new TicketBooker();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Print Available Tickets");
            System.out.println("4. Print Booked Tickets");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Name:");
                    String name = sc.next();
                    System.out.println("Enter Age:");
                    int age = sc.nextInt();
                    System.out.println("Preferred Berth (L/M/U):");
                    String berth = sc.next();
                    ticketBooker.bookticket(name, age, berth);
                    break;
                case 2:
                    System.out.println("Enter Passenger ID to Cancel:");
                    int id = sc.nextInt();
                    ticketBooker.cancelticket(id);
                    break;
                case 3:
                    ticketBooker.printAvailable();
                    break;
                case 4:
                    ticketBooker.printPassengers();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
