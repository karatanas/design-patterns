package factory;

import mediator.MediatorMsg;
import mediator.User;

public class Bot extends User {

    private static Bot singletonBot;

    private Bot(String name, MediatorMsg med) {
        super(name, med);
        mediator.addUser(this);
    }

    public static Bot getSingletonBot(String name, MediatorMsg med) {
        if (singletonBot == null) {
            singletonBot = new Bot(name, med);
        }
        return singletonBot;
    }
    
    public void checkCommand(String senderName, String message) {
    	switch (message) {
    	case "I love you, Bot":
    		sendMsg("I love you, " + senderName);
    		break;
    	case "cat":
    		 mediator.removeUser(senderName);
             sendMsg("Member " + senderName + " was kicked!");
             break;
    	default:
    		break;
    	}
    	
    }

    @Override
    public void sendMsg(String message) {
        System.out.println(this.name + " -> " + message);
        mediator.sendMsg(this, message);
    }

    @Override
    public void receiveMsg(String senderName, String message) {
        System.out.println(this.name + " <- " + message);
        checkCommand(senderName, message);
    }
}
