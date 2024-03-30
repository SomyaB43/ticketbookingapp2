package sofe3980;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BookingController.class)
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingManager bookingManager;

    @MockBean
    private FlightManager flightManager;

    @Before
    public void setUp() {
        // Setup for each test, if necessary
    }

    @Test
    public void testViewWeeklyFlights() throws Exception {
        mockMvc.perform(get("/booking/flights"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(content().string("[]")); // Assuming the controller method returns an empty list for simplicity
    }

    @Test
    public void testCreateBooking() throws Exception {
        String bookingJson = "{\"userId\":1,\"flights\":[{\"flightId\":101}],\"bookingType\":\"one-way\"}";

        mockMvc.perform(post("/booking/makeBooking")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookingJson))
               .andExpect(status().isOk());
    }
}
