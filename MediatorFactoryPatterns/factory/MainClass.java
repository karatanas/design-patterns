package factory;

import mediator.ChatMsgMediator;
import mediator.MediatorMsg;
import mediator.User;

public class MainClass {
    public static void main(String[] args) {
        MediatorMsg mediator = new ChatMsgMediator();
        ChatFactory chatFactory = new ChatFactory();
        User customer1 = chatFactory.createUser("Anna", "Customer", mediator);

        customer1.sendMsg("Hey Chat!");
        customer1.sendMsg("addBot");
        customer1.sendMsg("I love you, Bot");

        User customer2 = chatFactory.createUser("Jasmin", "Customer", mediator);
        customer2.sendMsg("Hello, guys!");
        customer2.sendMsg("cat");
        User bot = chatFactory.createUser("Bot", "Bot", mediator);
        System.out.println(bot.getName());
    }
}