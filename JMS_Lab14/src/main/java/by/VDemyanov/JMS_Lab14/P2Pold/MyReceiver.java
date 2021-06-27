package by.VDemyanov.JMS_Lab14.P2Pold;

import com.sun.messaging.Queue;
import com.sun.messaging.QueueConnectionFactory;
import com.sun.messaging.jms.Session;

import javax.jms.*;
import javax.naming.InitialContext;

public class MyReceiver {
    public static void main(String[] args) {
        try{
            //1) создать и стартовать connection
            InitialContext ctx=new InitialContext();
            QueueConnectionFactory f= (QueueConnectionFactory)ctx.lookup("java:comp/DefaultJMSConnectionFactory");
            QueueConnection con=f.createQueueConnection();
            con.start();
            //2) создать Queue session
            QueueSession session=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            //3) полуситьQueue object
            Queue queue=(Queue)ctx.lookup("BankCard");
            //4)создаь QueueReceiver
            QueueReceiver receiver=session.createReceiver(queue);
            //синхронно
            MessageConsumer consumer = session.createConsumer(queue);
            Message message = consumer.receive();
            if (message instanceof ObjectMessage) {
                ObjectMessage objectMessage = (ObjectMessage) message;
                MyClass msg = null;
                try {
                    msg = (MyClass)objectMessage.getObject();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
                System.out.println(msg.toString());
            }
            //асинхронно
            //5) создать listener object
            MyListener listener=new MyListener();
            //6) регистрируем listener object приемником
            receiver.setMessageListener(listener);
            System.out.println("Waiting for messages...");
            System.out.println("press Ctrl+c to shutdown...");
            while(true){
                Thread.sleep(1000);
            }
        }catch(Exception e){System.out.println(e);}
    }
}
