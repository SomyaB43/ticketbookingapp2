package sofe3980;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// this class will be used to serve the web page UI
@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingManager bookingManager;
    private final FlightManager flightManager;

    @Autowired
    public BookingController(BookingManager bookingManager, FlightManager flightManager) {
        this.bookingManager = bookingManager;
        this.flightManager = flightManager;
    }

    /**
     * Displays the main menu options to the user.
     * 
     */
    @GetMapping("/")
    public void displayMainMenu() {
    }

    /**
     * Handles the request to view weekly flights.
     * Fetch available flights from the FlightManager and display them.
     */
    @GetMapping("/flights")
    public void viewWeeklyFlights() {
    }

    /**
     * Processes the booking request from the user.
     * Take booking details from the request, create a booking via the
     * BookingManager,
     * 
     * @param bookingDetails Details of the booking submitted by the user.
     */
    @PostMapping("/makeBooking")
    public void createBooking(@RequestBody Booking bookingDetails) {
    }

    /**
     * Displays booking confirmation details to the user.
     * After a booking is successfully made, show the user their confirmed booking
     * details.
     * 
     * @param booking The booking to confirm.
     */
    public void displayBookingConfirmation(Booking booking) {
    }
}
