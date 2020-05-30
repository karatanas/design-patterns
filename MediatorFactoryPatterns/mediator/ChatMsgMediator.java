package mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMsgMediator implements MediatorMsg {
	
    private List<User> users;

    public ChatMsgMediator() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMsg(User user, String message) {
        for (User newUser : users) {
            if (newUser != user) 
            	newUser.receiveMsg(user.name, message);
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void removeUser(String userName) {
        User userToRemove = this.users.stream()
                .filter(user -> userName.equals(user.name))
                .findFirst()
                .get();
        users.remove(userToRemove);
    }
}
