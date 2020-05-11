import java.util.ArrayList;
import java.util.List;

public class HeroChat implements Chat {

    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        this.users
                .stream()
                .filter(u -> u != user)
                .forEach(u -> u.receiveMessage(message));
    }

}