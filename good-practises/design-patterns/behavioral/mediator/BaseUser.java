public abstract class BaseUser implements User {

    private Chat chat;
    private String username;
    private String rank;

    public BaseUser(Chat chat, String username, String rank) {
        this.chat = chat;
        this.username = username;
        this.rank = rank;
    }

    @Override
    public void sendMessage(String message) {
        this.chat.sendMessage("[ " + this.rank + "] " + this.username + ": " + message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(message);
    }

}