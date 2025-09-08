package javaassignment1;

public class Vipticket extends Ticket {
    private String loungeAccess;
    private String priorityEntry;
    
    // Constructor
    public Vipticket(String eventId, double price) {
        super(eventId, "VIP", price);
        this.loungeAccess = "Yes";
        this.priorityEntry = "Yes";
    }
    
    // Method overriding
    @Override
    public void printBadge() {
        System.out.println("Ticket ID: " + getTicketId());
        System.out.println("Event ID: " + getEventId());
        System.out.println("Type: " + getType());
        System.out.println("Lounge Access: " + loungeAccess);
        System.out.println("Priority Entry: " + priorityEntry);
        System.out.println("VIP Access - Welcome to exclusive benefits!");
    }
    
    @Override
    public double getPrice() {
        // VIP tickets have a 10% service charge
        return super.getPrice() * 1.10;
    }
    
    // Getters and setters
    public String getLoungeAccess() {
        return loungeAccess;
    }
    
    public void setLoungeAccess(String loungeAccess) {
        this.loungeAccess = loungeAccess;
    }
    
    public String getPriorityEntry() {
        return priorityEntry;
    }
    
    public void setPriorityEntry(String priorityEntry) {
        this.priorityEntry = priorityEntry;
    }
}
