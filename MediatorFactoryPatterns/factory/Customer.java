package factory;

import mediator.MediatorMsg;
import mediator.User;

public class Customer extends User {

    public Customer(String name, MediatorMsg mediator) {
        super(name, mediator);
        mediator.addUser(this);
    }

    @Override
    public void sendMsg(String message) {
        System.out.println(this.name + " -> " + message);
        mediator.sendMsg(this, message);
        if (message.equals("addBot")) {
            ChatFactory chatFactory = new ChatFactory();
            chatFactory.createUser("Bot", "Bot", mediator);
        }
    }

    @Override
    public void receiveMsg(String senderName, String message) {
        System.out.println(this.name + " <- " + message);
    }
}
