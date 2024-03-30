package sofe3980;

public class Ticket {
    private String ticketNumber;
    private String ticketDetails; // flight, booking, name, price etc.

    // Constructor
    public Ticket(String ticketNumber, String ticketDetails) {
        this.ticketNumber = ticketNumber;
        this.ticketDetails = ticketDetails;
    }

    // Getters

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getTicketDetails() {
        return ticketDetails;
    }

    // Setters

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setTicketDetails(String ticketDetails) {
        this.ticketDetails = ticketDetails;
    }
}
