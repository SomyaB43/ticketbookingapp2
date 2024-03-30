package sofe3980;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BookingManagerTest {

    private BookingManager bookingManager;

    @Before
    public void setUp() throws Exception {
        bookingManager = new BookingManager();
        // Setup necessary mock data for flights and users, if required
    }

    @Test
    public void testCreateBooking() {
        User user = new User(1, "John Doe", "john.doe@example.com", "password", null, "123456789");
        Flight flight1 = new Flight(1, null, null, "A", "B", 100.00);
        List<Flight> flights = Arrays.asList(flight1);
        
        Booking result = bookingManager.createBooking(user, flights, "one-way");
        assertNotNull("Booking should be created", result);
    }

    @Test
    public void testCancelBooking() {
        // Assuming there is a booking with ID 1 already created
        boolean result = bookingManager.cancelBooking(1);
        assertTrue("Booking should be canceled successfully", result);
    }

    @Test
    public void testGetBookingById() {
        // Assuming there is a booking with ID 1
        Optional<Booking> result = bookingManager.getBookingById(1);
        assertTrue("Booking should be found", result.isPresent());
    }

    @Test
    public void testIsCyclicItinerary() {
        Flight flight1 = new Flight(1, null, null, "A", "B", 100.00);
        Flight flight2 = new Flight(2, null, null, "B", "C", 150.00);
        Flight flight3 = new Flight(3, null, null, "C", "A", 200.00);
        List<Flight> cyclicItinerary = Arrays.asList(flight1, flight2, flight3);

        boolean result = bookingManager.isCyclicItinerary(cyclicItinerary);
        assertTrue("Itinerary should be cyclic", result);
    }
}
