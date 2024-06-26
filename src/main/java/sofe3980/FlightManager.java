package sofe3980;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightManager {

    // If we are using a database, this will change to use that instead for storing
    // flights
    private List<Flight> flights;

    public FlightManager() {
        this.flights = new ArrayList<>();
        // Initialize the flights list with some dummy data later for testing
    }

    // for adding flights to the list of all flights (used for adding dummy flights
    // for testing)
    public void addFlight(Flight flight) {
        this.flights.add(flight);
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
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDepartureLocation().equals(from) &&
                    flight.getDestinationLocation().equals(to) &&
                    flight.getDepartureTime().toLocalDate().equals(date)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }

    /**
     * Searches for multi-stop flights based on the provided paraneters.
     * 
     * @param from The departure location.
     * @param to   The destination location.
     * @param date The date of the flight.
     * @return returns a list of lists, where each inner list represents a sequence
     *         of flights forming a multi-stop journey.
     */
    public List<List<Flight>> searchMultiStopFlights(String from, String to, LocalDate date) {
        List<List<Flight>> multiStopFlights = new ArrayList<>();

        // First, find all flights departing from the origin on the specified date
        List<Flight> departingFlights = flights.stream()
                .filter(f -> f.getDepartureLocation().equals(from) && f.getDepartureTime().toLocalDate().equals(date))
                .collect(Collectors.toList());

        // Then, for each departing flight, find connecting flights from the arrival
        // location to the final destination
        for (Flight firstLeg : departingFlights) {
            List<Flight> connectingFlights = flights.stream()
                    .filter(f -> f.getDepartureLocation().equals(firstLeg.getDestinationLocation()) &&
                            f.getDestinationLocation().equals(to) &&
                            f.getDepartureTime().isAfter(firstLeg.getArrivalTime()))
                    .collect(Collectors.toList());

            // For each connecting flight found, add a new list containing the first leg and
            // the connecting flight to the results
            for (Flight secondLeg : connectingFlights) {
                List<Flight> multiStopFlight = new ArrayList<>();
                multiStopFlight.add(firstLeg);
                multiStopFlight.add(secondLeg);
                multiStopFlights.add(multiStopFlight);
            }
        }

        return multiStopFlights;
    }

    /**
     * Retrieves the list of weekly flights.
     * 
     * @return A list of weekly flights.
     */
    public List<Flight> getWeeklyFlights() {
        LocalDate today = LocalDate.now(ZoneId.systemDefault());
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate endOfWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        return flights.stream()
                .filter(flight -> {
                    LocalDate flightDate = flight.getDepartureTime().toLocalDate();
                    return (!flightDate.isBefore(startOfWeek)) && (!flightDate.isAfter(endOfWeek));
                })
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a flight by its ID.
     * 
     * @param flightId The ID of the flight to retrieve.
     * @return The Flight object if found, or null otherwise.
     */
    public Flight getFlightById(int flightId) {
        for (Flight flight : flights) {
            if (flight.getFlightId() == flightId) {
                return flight;
            }
        }
        return null; // Return null if no flight with the given ID is found
    }

    /**
     * Calculates the total flight time for a given list of flights.
     * 
     * @param flights List of flights for which to calculate the total time.
     * @return Total flight time as a string formatted as "H:MM".
     */
    public String calculateTotalFlightTime(List<Flight> flights) {
        int totalMinutes = 0;

        // using the calculateDuration() Flight method, we have to parse the String
        // result it provides in H:MM format
        for (Flight flight : flights) {
            String duration = flight.calculateDuration();
            String[] parts = duration.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            totalMinutes += (hours * 60) + minutes;
        }

        int totalHours = totalMinutes / 60;
        int remainingMinutes = totalMinutes % 60;

        return String.format("%d:%02d", totalHours, remainingMinutes);
    }
}
