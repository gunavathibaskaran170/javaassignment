package javaassignment1;

public class Ticket {
    private static int nextId = 1;
    
    private String ticketId;
    private String eventId;
    private String type;
    private double price;
    private String state; 
    

    public Ticket(String eventId, String type, double price) {
        this.ticketId = "T" + String.format("%04d", nextId++);
        this.eventId = eventId;
        this.type = type;
        this.price = price;
        this.state = "Available";
    }
    
    
    public void sell() {
        if ("Available".equals(state)) {
            state = "Sold";
            System.out.println("Ticket " + ticketId + " has been sold.");
        } else {
            System.out.println("Ticket " + ticketId + " is not available for sale.");
        }
    }
    
    public void use() {
        if ("Sold".equals(state)) {
            state = "Used";
            System.out.println("Ticket " + ticketId + " has been used.");
        } else {
            System.out.println("Ticket " + ticketId + " cannot be used in its current state.");
        }
    }
    
    public double getPrice() {
        return price;
    }
    
    public void printBadge() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Event ID: " + eventId);
        System.out.println("Type: " + type);
        System.out.println("Standard Ticket");
    }
    
    // Getters and setters
    public String getTicketId() {
        return ticketId;
    }
    
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
    
    public String getEventId() {
        return eventId;
    }
    
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
}