package sofe3980;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightManager {

    // If we are using a database, this will change to use that instead for storing
    // flights
    private List<Flight> flights;

    public FlightManager() {
        this.flights = new ArrayList<>();
        // Initialize the flights list with some dummy data later for testing
    }

    /**
     * Searches for direct flights based on the provided criteria.
     * 
     * @param from The departure location.
     * @param to   The destination location.
     * @param date The date of the flight.
     * @return A list of flights matching the criteria.
     */
    public List<Flight> searchDirectFlights(String from, String to, LocalDate date) {
        return null;
    }

    /**
     * Searches for multi-stop flights based on the provided paraneters.
     * 
     * @param from The departure location.
     * @param to   The destination location.
     * @param date The date of the flight.
     * @return A list of flights matching the parameters for multi-stop flights.
     */
    public List<Flight> searchMultiStopFlights(String from, String to, LocalDate date) {
        // Put multi-stop flight search functionality here
        return new ArrayList<>();
    }

    /**
     * Retrieves the list of weekly flights.
     * 
     * @return A list of weekly flights.
     */
    public List<Flight> getWeeklyFlights() {
        return new ArrayList<>();
    }

    /**
     * Retrieves a flight by its ID.
     * 
     * @param flightId The ID of the flight to retrieve.
     * @return The Flight object if found, or null otherwise.
     */
    public Flight getFlightById(int flightId) {
        return null;
    }

    /**
     * Calculates the total flight time for a given flight or a series of connecting flights.
     * @param flights List of flights for which to calculate the total time.
     * @return Total flight time as a string
     */
    public String calculateTotalFlightTime(List<Flight> flights) {
        return null;
    }
}
