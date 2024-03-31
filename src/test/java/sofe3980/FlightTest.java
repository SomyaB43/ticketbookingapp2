package sofe3980;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class FlightTest {

    @Test
    public void testCalculateDuration() {
        // Create a flight with a known duration
        LocalDateTime departureTime = LocalDateTime.of(2021, 1, 1, 10, 0); // 10:00 AM
        LocalDateTime arrivalTime = LocalDateTime.of(2021, 1, 1, 12, 30); // 12:30 PM
        Flight flight = new Flight(1, departureTime, arrivalTime, "Origin", "Destination", 100.00);

        // Calculate the total duration in minutes
        long totalMinutes = java.time.Duration.between(departureTime, arrivalTime).toMinutes();
        // Calculate hours and the remaining minutes
        long hours = totalMinutes / 60;
        long minutes = totalMinutes % 60; // Use modulo to find the remaining minutes after hours

        String expectedDuration = String.format("%d:%02d", hours, minutes);

        System.out.println(expectedDuration);

        // Call calculateDuration and check the result, they should match if the test is successful
        String calculatedDuration = flight.calculateDuration();
        assertEquals("Duration should be correctly calculated", expectedDuration, calculatedDuration);
    }
}
