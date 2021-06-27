package by.VDemyanov.JMS_Lab14.models;

import java.util.ArrayList;

public class MessageList extends ArrayList<Message> {
    {
        this.add(new Message(1, "Hello"));
        this.add(new Message(5, "Bye"));
    }

    public MessageList() {}

    @Override
    public String toString() {
        String str = "";
        for (Message msg: this) {
            str += msg;
        }
        return str;
    }
}
