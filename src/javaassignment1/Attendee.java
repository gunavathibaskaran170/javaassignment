package javaassignment1;
import java.util.ArrayList;
import java.util.List;

public class Attendee {
    private String attendeeId;
    private String name;
    private String email;
    private String ticketType;
    private boolean checkInStatus;
    private List<String> eventIds;
    

    public Attendee(String attendeeId, String name, String email, String ticketType, boolean checkInStatus) {
        this.attendeeId = attendeeId;
        this.name = name;
        this.email = email;
        this.ticketType = ticketType;
        this.checkInStatus = checkInStatus;
        this.eventIds = new ArrayList<>();
    }
    
    public void addEvent(String eventId) {
        eventIds.add(eventId);
    }
    
    public void removeEvent(String eventId) {
        eventIds.remove(eventId);
    }
    
    public void checkIn() {
        this.checkInStatus = true;
        System.out.println(name + " has been checked in.");
    }
    
    public void displayInfo() {
        System.out.println("Attendee: " + name);
        System.out.println("Email: " + email);
        System.out.println("Ticket Type: " + ticketType);
        System.out.println("Checked In: " + (checkInStatus ? "Yes" : "No"));
    }
    
    // Getters and setters
    public String getAttendeeId() {
        return attendeeId;
    }
    
    public void setAttendeeId(String attendeeId) {
        this.attendeeId = attendeeId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTicketType() {
        return ticketType;
    }
    
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    
    public boolean isCheckInStatus() {
        return checkInStatus;
    }
    
    public void setCheckInStatus(boolean checkInStatus) {
        this.checkInStatus = checkInStatus;
    }
    
    public List<String> getEventIds() {
        return eventIds;
    }
    
    public void setEventIds(List<String> eventIds) {
        this.eventIds = eventIds;
    }
}