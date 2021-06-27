package by.VDemyanov.JMS_Lab14.P2Pexample1;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.ConnectionConfiguration;
import javax.jms.JMSContext;
import javax.jms.Queue;

public class DirectMessageSender{
    public static void main(String[] args){
        ConnectionFactory factory;
        factory = new ConnectionFactory();
        try( JMSContext context = factory.createContext("admin","admin")){
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
            Destination cardsQueue = context.createQueue("BankCardQueue");
            JMSProducer producer = context.createProducer();
// Send msg about card
            producer.send(cardsQueue,"PNV 100 5634234");
            System.out.println("Placed an information about card transaction to BankCardQueue");
        } catch (JMSException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
