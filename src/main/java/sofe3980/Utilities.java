package sofe3980;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Utilities {

    /**
     * Converts time from 24-hour format to 12-hour format.
     * 
     * @param time The time in 24-hour format.
     * @return The time in 12-hour format.
     */
    public static String convertTo12HourFormat(LocalTime time) {
        // Format the time using a DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        // Format the time to 12-hour format
        String formattedTime = time.format(formatter);
        return formattedTime;
    }

    /**
     * Converts time from 12-hour format to 24-hour format.
     * 
     * @param time The time in 12-hour format.
     * @return The time in 24-hour format.
     */
    public static LocalTime convertTo24HourFormat(String time) {
        // Define the formatter for 12-hour format
        DateTimeFormatter formatter12Hour = DateTimeFormatter.ofPattern("h:mm a");

        // Parse the input time string in 12-hour format
        LocalTime parsedTime = LocalTime.parse(time, formatter12Hour);

        // Format the parsed time into 24-hour format
        DateTimeFormatter formatter24Hour = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = parsedTime.format(formatter24Hour);

        // Parse the formatted time into LocalTime object with 24-hour format
        return LocalTime.parse(formattedTime);
    }
}
