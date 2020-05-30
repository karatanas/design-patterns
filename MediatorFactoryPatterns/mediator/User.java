package mediator;

import mediator.MediatorMsg;

public abstract class User {
    protected String name;
    public String role;
    protected MediatorMsg mediator;

    public User(String name, MediatorMsg mediator ) {
        this.name = name;
    	this.mediator = mediator;
    }

    public abstract void sendMsg(String message);

    public abstract void receiveMsg(String senderName, String message);

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getUserType() {
        return role;
    }

    public void setUserType(String userType) {
        this.role = userType;
    }
}
