package ticketbooking;
import java.util.*;
public class TicketBooker {
	private final int MAX_LOWER=21;
	private final int MAX_MIDDLE=21;
	private final int MAX_UPPER=21;
	private final int MAX_RAC=18;
	private final int MAX_WL=10;
	
	private int availableLower=MAX_LOWER;
	private int availableMiddle=MAX_MIDDLE;
	private int availableUpper=MAX_UPPER;
	private int availableRac=MAX_RAC;
	private int availableWl=MAX_WL;
	private int passengercount=1;
	
	private Map<Integer,Passenger> passengers=new HashMap<>();
	private Queue<Integer> racqueue=new LinkedList<>();
	private Queue<Integer> waitinglist=new LinkedList<>();
	
	private List<Integer>lowerberths=new ArrayList<>(MAX_LOWER);
	private List<Integer>middleberths=new ArrayList<>(MAX_MIDDLE);
	private List<Integer>upperberths=new ArrayList<>(MAX_UPPER);
	private List<Integer>racpositions=new ArrayList<>(MAX_RAC);
	private List<Integer>waitinglistpositions=new ArrayList<>(MAX_WL);
	public TicketBooker() {
        for (int i = 1; i <= MAX_LOWER; i++) lowerberths.add(i);
        for (int i = 1; i <= MAX_MIDDLE; i++) middleberths.add(i);
        for (int i = 1; i <= MAX_UPPER; i++) upperberths.add(i);
        for (int i = 1; i <= MAX_RAC; i++) racpositions.add(i);
        for (int i = 1; i <= MAX_WL; i++) waitinglistpositions.add(i);
    }
	public void bookticket(String name,int age,String Preferedberth) {
		Passenger p=new Passenger(passengercount++,name,age);
		if(assignberth(p,Preferedberth)) {
			System.out.println("Booked Succesfully");
		}
		else if(assignberth(p,"Rac")) {
			System.out.println("Rac Booked Succesfully");
		}
		else if(assignberth(p,"Wl")) {
			System.out.println("waiting List Booked Succesfully");
		}
		else {
			System.out.println("Tickets Not Available");
		}
		
	}
	private boolean assignberth(Passenger p,String preferedberth) {
		switch(preferedberth) {
		case "L":
			if(availableLower>0) {
				p.berthnumber=lowerberths.remove(--availableLower);
				p.berthType="L";
				passengers.put(p.id,p);
				return true;
			}
		case "M":
			if(availableMiddle>0) {
				p.berthnumber=middleberths.remove(--availableMiddle);
				p.berthType="M";
				passengers.put(p.id,p);
				return true;
			}
		case "U":
			if(availableUpper>0) {
				p.berthnumber=upperberths.remove(--availableUpper);
				p.berthType="U";
				passengers.put(p.id,p);
				return true;
			}
		default:
			if(availableRac>0) {
				p.berthnumber=racpositions.remove(--availableRac);
				p.berthType="RAC";
				passengers.put(p.id,p);
				racqueue.add(p.id);
				return true;
			}
			else if(availableWl>0) {
				
				p.berthnumber=waitinglistpositions.remove(--availableWl);
				p.berthType="WL";
				passengers.put(p.id,p);
				racqueue.add(p.id);
				return true;
			}
			else {
				return false;
			}
		}
	}
	public void cancelticket(int id) {
		Passenger p=passengers.remove(id);
		switch(p.berthType) {
		case "L":
			availableLower++;
			lowerberths.add(p.berthnumber);
			break;
		case "M":
			availableMiddle++;
			middleberths.add(p.berthnumber);
			break;
		case "U":
			availableUpper++;
			upperberths.add(p.berthnumber);
			break;
		case "RAC":
			racpositions.add(p.berthnumber);
            racqueue.remove(id);
            moveFromWaitingListToRAC();
            break;
        case "WL":
            availableWl++;
            waitinglistpositions.add(p.berthnumber);
            waitinglist.remove(id);
            break;
			
		}
		if (!racqueue.isEmpty() && !lowerberths.isEmpty()) {
            moveFromRACToConfirmed();
        }
        System.out.println("Ticket Cancelled Successfully");
	}
	private void moveFromRACToConfirmed() {
        int racPassengerId = racqueue.poll();
        Passenger racPassenger = passengers.get(racPassengerId);

        if (assignberth(racPassenger, "L") || assignberth(racPassenger, "M") || assignberth(racPassenger, "U")) {
            System.out.println("RAC Passenger " + racPassengerId + " moved to Confirmed");
        }
    }

    private void moveFromWaitingListToRAC() {
        if (!waitinglist.isEmpty()) {
            int wlPassengerId = waitinglist.poll();
            Passenger wlPassenger = passengers.get(wlPassengerId);
            assignberth(wlPassenger, "RAC");
            System.out.println("Waiting List Passenger " + wlPassengerId + " moved to RAC");
        }
    }
    public void printAvailable() {
        System.out.println("Available Lower Berths: " + availableLower);
        System.out.println("Available Middle Berths: " + availableMiddle);
        System.out.println("Available Upper Berths: " + availableUpper);
        System.out.println("Available RAC: " + availableRac);
        System.out.println("Available Waiting List: " + availableWl);
    }
    public void printPassengers() {
        if (passengers.isEmpty()) {
            System.out.println("No details of passengers");
        } else {
            for (Passenger p : passengers.values()) {
                System.out.println("Passenger ID: " + p.id);
                System.out.println("Name: " + p.name);
                System.out.println("Age: " + p.age);
                System.out.println("Status: " + p.berthType);
                System.out.println("Berth Number: " + p.berthnumber);
                System.out.println("--------------------------");
            }
        }
    }
	
}
