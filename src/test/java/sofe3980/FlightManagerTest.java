package sofe3980;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.List;

public class FlightManagerTest {

    private FlightManager flightManager;

    // @Before
    public void setUp() {
        flightManager = new FlightManager();
        // initialize the flightManager with some dummy flights for testing 
    }

    // @Test
    public void testSearchDirectFlights() {
        List<Flight> results = flightManager.searchDirectFlights("Origin", "Destination", LocalDate.now());
        assertNotNull("Result should not be null", results);
    }

    // @Test
    public void testSearchMultiStopFlights() {
        List<Flight> results = flightManager.searchMultiStopFlights("Origin", "Destination", LocalDate.now());
        assertNotNull("Result should not be null", results);
    }

    // @Test
    public void testGetWeeklyFlights() {
        List<Flight> weeklyFlights = flightManager.getWeeklyFlights();
        assertNotNull("Weekly flights list should not be null", weeklyFlights);
    }

    // @Test
    public void testGetFlightById() {
        // Assuming there's a flight with ID 1
        Flight flight = flightManager.getFlightById(1);
        assertNotNull("Flight should be found by ID", flight);
        assertEquals("Flight ID should match", 1, flight.getFlightId());
    }

    // @Test
    public void testCalculateTotalFlightTime() {
        // Assuming flights list is initialized with some flights
        String totalFlightTime = flightManager.calculateTotalFlightTime(flightManager.getWeeklyFlights());
        assertNotNull("Total flight time should be calculated", totalFlightTime);
    }
}
