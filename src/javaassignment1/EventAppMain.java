package javaassignment1;


public class EventAppMain {
    public static void main(String[] args) {
       
        EventService eventService = new EventService();
        
        Event concert = eventService.createEvent("C001", "Summer Concert", "2023-07-15", "City Hall", 500);
        Event conference = eventService.createEvent("C002", "Tech Conference", "2023-08-20", "Convention Center", 300);
        
        Ticket t1 = eventService.sellTicket(concert, "Regular", 50.0);
        Ticket t2 = eventService.sellTicket(concert, "VIP", 120.0);
        Ticket t3 = eventService.sellTicket(conference, "Regular", 75.0);
        Ticket t4 = eventService.sellTicket(conference, "VIP", 200.0);
        
        Attendee a1 = new Attendee("A001", "John Doe", "john@example.com", "Regular", false);
        Attendee a2 = new Attendee("A002", "Jane Smith", "jane@example.com", "VIP", false);
        Attendee a3 = new Attendee("A003", "Bob Johnson", "bob@example.com", "Regular", false);
        Attendee a4 = new Attendee("A004", "Alice Brown", "alice@example.com", "VIP", false);
        
        a1.addEvent(concert.getEventId());
        a2.addEvent(concert.getEventId());
        a3.addEvent(conference.getEventId());
        a4.addEvent(conference.getEventId());
        
        eventService.addAttendee(a1);
        eventService.addAttendee(a2);
        eventService.addAttendee(a3);
        eventService.addAttendee(a4);
        
        eventService.rsvp(a1.getAttendeeId());
        eventService.rsvp(a2.getName(), a2.getEmail());
        eventService.rsvp(a3.getAttendeeId());
        eventService.rsvp(a4.getName(), a4.getEmail());
        
        eventService.checkIn(a1.getAttendeeId());
        eventService.checkIn(a2.getAttendeeId());
        
        // Display event information
        System.out.println("=== EVENT MANAGEMENT SYSTEM ===");
        System.out.println();
        
        concert.displayEventInfo();
        System.out.println();
        conference.displayEventInfo();
        System.out.println();
        
        // Display attendee lists
        System.out.println("=== ATTENDEE LISTS ===");
        System.out.println("\nConcert Attendees:");
        eventService.attendeeList(concert);
        
        System.out.println("\nConference Attendees:");
        eventService.attendeeList(conference);
        
        System.out.println("\n=== REVENUE REPORT ===");
        System.out.printf("Concert Revenue: $%.2f%n", eventService.calculateRevenue(concert));
        System.out.printf("Conference Revenue: $%.2f%n", eventService.calculateRevenue(conference));
        System.out.printf("Total Revenue: $%.2f%n", eventService.calculateTotalRevenue());
        
        System.out.println("\n=== TICKET INFORMATION (POLYMORPHISM) ===");
        Ticket[] tickets = {t1, t2, t3, t4};
        for (Ticket ticket : tickets) {
            System.out.println("Ticket Type: " + ticket.getType());
            System.out.println("Price: $" + ticket.getPrice());
            ticket.printBadge();
            System.out.println();
        }
    }
}