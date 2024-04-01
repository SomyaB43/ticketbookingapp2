package sofe3980;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Optional;

public class UserManagerTest {

    private UserManager userManager;

    @Before
    public void setUp() throws Exception {
        userManager = new UserManager();
    }

    @Test
    public void testRegisterUser() {
        String name = "John Doe";
        String email = "johndoe@example.com";
        String password = "password";
        LocalDate dob = LocalDate.now();
        String passportNumber = "AA123456789";

        User user = userManager.registerUser(name, email, password, dob, passportNumber);

        assertNotNull("User should be registered successfully", user);
        assertEquals("Registered user should have the correct name", name, user.getName());
        assertEquals("Registered user should have the correct email", email, user.getEmail());
    }

    @Test
    public void testLoginUserSuccessful() {
        // Register a user
        String name = "John Doe";
        String email = "johndoe@example.com";
        String password = "password";
        LocalDate dob = LocalDate.now();
        String passportNumber = "AA123456789";
        User user = userManager.registerUser(name, email, password, dob, passportNumber);

        // System.out.println(user.toString());
    
        // Attempt to log in
        Optional<User> result = userManager.loginUser(email, password);
        assertTrue("User should be able to log in successfully", result.isPresent());
        assertEquals("Logged in user should have the correct email", email, result.get().getEmail());
    }
    

    @Test
    public void testLoginUserUnsuccessful() {
        // Register a user
        String name = "John Doe";
        String email = "johndoe@example.com";
        String password = "password";
        LocalDate dob = LocalDate.now();
        String passportNumber = "AA123456789";
        User user = userManager.registerUser(name, email, password, dob, passportNumber);

        // System.out.println(user.toString()); 

        // attempt login with wrong email, but correct password
        Optional<User> result1 = userManager.loginUser("wrongemail@email.com", password);
        assertFalse("User should not be able to log in with incorrect email", result1.isPresent());

        // attempt login with correct email, but wrong password
        Optional<User> result2 = userManager.loginUser(email, "wrongpassword");
        assertFalse("User should not be able to log in with incorrect password", result2.isPresent());
    }
}
