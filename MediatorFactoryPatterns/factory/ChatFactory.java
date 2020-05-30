package factory;

import mediator.MediatorMsg;
import mediator.User;

public class ChatFactory {
	
    private static final String CREATE_BOT_COMMAND = "Bot";
    private static final String CREAT_CUSTOMER_COMMAND = "Customer";

    public User createUser(String userName, String role, MediatorMsg mediator) {
        User user = null;
        switch (role) {
            case CREATE_BOT_COMMAND:
                user = Bot.getSingletonBot(role, mediator);
                user.setName(userName);
                user.setUserType(role);
                break;
            case CREAT_CUSTOMER_COMMAND:
                user = new Customer(role,mediator);
                user.setName(userName);
                user.setUserType(role);
                break;
            default:
                break;

        }
        return user;
    }
}
