package behavioral.mediator;

public class Admin extends BaseUser {

    public Admin(Chat chat, String username) {
        super(chat, username, "ADMIN");
    }

}