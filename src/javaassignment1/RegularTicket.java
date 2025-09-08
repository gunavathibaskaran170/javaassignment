package javaassignment1;

public class RegularTicket extends Ticket {
    private String seatNumber;
    

    public RegularTicket(String eventId, double price) {
        super(eventId, "Regular", price);
        this.seatNumber = generateSeatNumber();
    }
    
    @Override
    public void printBadge() {
        System.out.println("Ticket ID: " + getTicketId());
        System.out.println("Event ID: " + getEventId());
        System.out.println("Type: " + getType());
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Regular Admission - Please proceed to general seating");
    }
    
    private String generateSeatNumber() {
        int row = (int) (Math.random() * 26) + 1; // 1-26
        char seat = (char) ('A' + (int) (Math.random() * 10)); // A-J
        return row + String.valueOf(seat);
    }
    
   
    public String getSeatNumber() {
        return seatNumber;
    }
    
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}
