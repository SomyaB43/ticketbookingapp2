import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserManager {

    private List<User> users;
    private long nextUserId; // Use long type for userId

    public UserManager() {
        this.users = new ArrayList<>();
        this.nextUserId = 1L; // Start with user ID 1
    }

    public User registerUser(String name, String email, String password, LocalDate dob, String passportNumber) {
        long userId = nextUserId++; // Assign the current value of nextUserId and then increment it
        User newUser = new User(userId, name, email, password, dob, passportNumber);
        users.add(newUser);
        return newUser;
    }

    public Optional<User> loginUser(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
