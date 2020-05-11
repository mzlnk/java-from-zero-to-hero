public interface Chat {

    void sendMessage(String message, User user);
    void addUser(User user);

}