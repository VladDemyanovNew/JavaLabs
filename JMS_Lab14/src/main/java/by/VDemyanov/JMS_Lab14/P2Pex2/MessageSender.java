package by.VDemyanov.JMS_Lab14.P2Pex2;

import com.sun.messaging.Queue;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

@Stateless
public class MessageSender {
    @Resource(mappedName = "jms/myConnectionFactory")
    private static ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/myQueue")
    private static Queue queue;

    public static void main(String[] args) throws NamingException {
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory" );
        Context initialContext = new InitialContext(props);
        JMSContext jmsContext = connectionFactory.createContext();

        JMSProducer jmsProducer = jmsContext.createProducer();

        String message = "Hello JMS!";
        System.out.println("Sending message to JMS...");

        jmsProducer.send(queue, message);

        System.out.println("Message Send Successfully!");

    }
}
