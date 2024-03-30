package sofe3980;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RunWith(Parameterized.class)
public class BookingTest {

    private User user;
    private List<Flight> flights;
    private String bookingType;
    private double expectedTotalPrice;

    // Constructor for parameterized test
    public BookingTest(String userStr, String flightsStr, String bookingType, double expectedTotalPrice) {
        this.user = parseUser(userStr);
        this.flights = parseFlights(flightsStr);
        this.bookingType = bookingType;
        this.expectedTotalPrice = expectedTotalPrice;
    }

    // Parameters for the test
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"User1", "Flight1:100;Flight2:200", "round-trip", 300.00},
            {"User2", "Flight3:150", "one-way", 150.00}
        });
    }

    @Test
    public void testCalculateTotalPrice() {
        Booking booking = new Booking(this.user, this.flights, this.bookingType);
        double actualTotalPrice = booking.calculateTotalPrice();
        assertEquals("Total price calculation should match expected value.", this.expectedTotalPrice, actualTotalPrice, 0.01);
    }

    // Method to parse User from a string (placeholder)
    private User parseUser(String userStr) {
        // create User object
        return new User(1, "Example User", "example@email.com", "password", LocalDate.now(), "passportNumber");
    }

    // Method to parse List<Flight> from a string (placeholder)
    private List<Flight> parseFlights(String flightsStr) {
        // create list of flights
        List<Flight> flights = new ArrayList<>();
        return flights;
    }
}
