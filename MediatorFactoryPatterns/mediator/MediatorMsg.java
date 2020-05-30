package mediator;

public interface MediatorMsg {
    void sendMsg(User user, String message);

    void addUser(User user);

    void removeUser(String userName);
}
