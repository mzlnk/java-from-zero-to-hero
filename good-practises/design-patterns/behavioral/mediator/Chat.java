package pl.mzlnk.javafromzerotohero.designpatterns.behavioral.mediator;

public interface Chat {

    void sendMessage(String message, User user);
    void addUser(User user);

}