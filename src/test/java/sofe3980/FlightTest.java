package sofe3980;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlightTest {

    // @Test
    public void testCalculateDuration() {
        // Create a flight with a known duration
        LocalDateTime departureTime = LocalDateTime.of(2021, 1, 1, 10, 0); // 10:00 AM
        LocalDateTime arrivalTime = LocalDateTime.of(2021, 1, 1, 12, 30); // 12:30 PM
        Flight flight = new Flight(1, departureTime, arrivalTime, "Origin", "Destination", 100.00);
        
        // Expected duration format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        long hours = java.time.Duration.between(departureTime, arrivalTime).toHours();
        long minutes = java.time.Duration.between(departureTime, arrivalTime).toMinutes();
        
        String expectedDuration = String.format("%d:%02d", hours, minutes);

        // Call calculateDuration and check the result
        String calculatedDuration = flight.calculateDuration();
        assertEquals("Duration should be correctly calculated", expectedDuration, calculatedDuration);
    }
}
