package javaassignment1;

import java.util.ArrayList;
import java.util.List;

public class EventService {
    private List<Event> events;
    private List<Attendee> attendees;
    private List<Ticket> tickets;
    
    public EventService() {
        this.events = new ArrayList<>();
        this.attendees = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }
    
    public Event createEvent(String eventId, String name, String date, String venue, int capacity) {
        Event event = new Event(eventId, name, date, venue, capacity);
        events.add(event);
        System.out.println("Event created: " + name);
        return event;
    }
    
    public Ticket sellTicket(Event event, String type, double basePrice) {
        if (event.isSoldOut()) {
            System.out.println("Sorry, " + event.getName() + " is sold out.");
            return null;
        }
        
        Ticket ticket;
        if ("VIP".equalsIgnoreCase(type)) {
            ticket = new Vipticket(event.getEventId(), basePrice);
        } else {
            ticket = new RegularTicket(event.getEventId(), basePrice);
        }
        
        ticket.sell();
        event.incrementTicketsSold();
        tickets.add(ticket);
        return ticket;
    }
    
    // Method overloading: rsvp by attendeeId
    public void rsvp(String attendeeId) {
        for (Attendee attendee : attendees) {
            if (attendee.getAttendeeId().equals(attendeeId)) {
                System.out.println(attendee.getName() + " has RSVP'd.");
                return;
            }
        }
        System.out.println("Attendee with ID " + attendeeId + " not found.");
    }
    
    // Method overloading: rsvp by name and email
    public void rsvp(String name, String email) {
        for (Attendee attendee : attendees) {
            if (attendee.getName().equals(name) && attendee.getEmail().equals(email)) {
                System.out.println(attendee.getName() + " has RSVP'd.");
                return;
            }
        }
        System.out.println("Attendee " + name + " with email " + email + " not found.");
    }
    
    public void checkIn(String attendeeId) {
        for (Attendee attendee : attendees) {
            if (attendee.getAttendeeId().equals(attendeeId)) {
                attendee.checkIn();
                return;
            }
        }
        System.out.println("Attendee with ID " + attendeeId + " not found.");
    }
    
    public void attendeeList(Event event) {
        System.out.println("Attendee list for " + event.getName() + ":");
        boolean hasAttendees = false;
        
        for (Attendee attendee : attendees) {
            if (attendee.getEventIds().contains(event.getEventId())) {
                attendee.displayInfo();
                System.out.println();
                hasAttendees = true;
            }
        }
        
        if (!hasAttendees) {
            System.out.println("No attendees registered for this event yet.");
        }
    }
    
    public double calculateRevenue(Event event) {
        double revenue = 0.0;
        for (Ticket ticket : tickets) {
            if (ticket.getEventId().equals(event.getEventId()) && 
                !"Available".equals(ticket.getState())) {
                revenue += ticket.getPrice();
            }
        }
        return revenue;
    }
    
    public double calculateTotalRevenue() {
        double totalRevenue = 0.0;
        for (Ticket ticket : tickets) {
            if (!"Available".equals(ticket.getState())) {
                totalRevenue += ticket.getPrice();
            }
        }
        return totalRevenue;
    }
    
    public List<Event> getEvents() {
        return events;
    }
    
    public List<Attendee> getAttendees() {
        return attendees;
    }
    
    public List<Ticket> getTickets() {
        return tickets;
    }
    
    public void addAttendee(Attendee attendee) {
        attendees.add(attendee);
    }
}