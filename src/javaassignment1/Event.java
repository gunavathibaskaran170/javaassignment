package javaassignment1;

public class Event {
    private String eventId;
    private String name;
    private String date;
    private String venue;
    private int capacity;
    private int ticketsSold;
    
    
    public Event(String eventId, String name, String date, String venue, int capacity) {
        this.eventId = eventId;
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.capacity = capacity;
        this.ticketsSold = 0;
    }
    

    public boolean isSoldOut() {
        return ticketsSold >= capacity;
    }
    
    public void incrementTicketsSold() {
        if (ticketsSold < capacity) {
            ticketsSold++;
        }
    }
    
    public void displayEventInfo() {
        System.out.println("Event: " + name);
        System.out.println("Date: " + date);
        System.out.println("Venue: " + venue);
        System.out.println("Capacity: " + capacity);
        System.out.println("Tickets Sold: " + ticketsSold);
        System.out.println("Available: " + (capacity - ticketsSold));
    }
    
    // Getters and setters
    public String getEventId() {
        return eventId;
    }
    
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getVenue() {
        return venue;
    }
    
    public void setVenue(String venue) {
        this.venue = venue;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public int getTicketsSold() {
        return ticketsSold;
    }
    
    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }
}