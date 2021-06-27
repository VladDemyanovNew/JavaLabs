package by.VDemyanov.JMS_Lab14.P2Pold;

import com.sun.messaging.Queue;
import com.sun.messaging.QueueConnectionFactory;
import com.sun.messaging.jms.Session;

import javax.jms.ObjectMessage;
import javax.jms.QueueConnection;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

public class MySender {
    public static void main(String[] args) {
        try { //создать соединение
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory" );
            InitialContext ctx = new InitialContext(props);
            QueueConnectionFactory f = (QueueConnectionFactory) ctx.lookup("java:comp/DefaultJMSConnectionFactory");
            QueueConnection con = f.createQueueConnection();
            con.start();
            //2) создать queue session
            QueueSession session = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            //3) получить Queue object
            Queue queue = (Queue) ctx.lookup("BankCard");
            //4)создать QueueSender object
            QueueSender sender = session.createSender(queue);
            //5) создатть TextMessage object
            ObjectMessage msg = session.createObjectMessage();
            //6) записать сообщение
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Enter Msg, end to terminate:");
                String s = b.readLine();
                if (s.equals("end"))
                    break;
                MyClass myClass = new MyClass();
                myClass.setId(1);
                myClass.setText(s);
                msg.setObject(myClass);
                //7) послать
                sender.send(msg);
                System.out.println("Message successfully sent.");
            }
            //8) закрыть
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
