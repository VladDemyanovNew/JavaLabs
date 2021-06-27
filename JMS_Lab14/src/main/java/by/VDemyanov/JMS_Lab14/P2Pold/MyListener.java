package by.VDemyanov.JMS_Lab14.P2Pold;

import com.sun.messaging.jms.JMSException;

import javax.jms.MessageListener;
import javax.jms.ObjectMessage;


public class MyListener implements MessageListener {
    @Override
    public void onMessage(javax.jms.Message m) {
        if (m instanceof ObjectMessage) {
            ObjectMessage objectMessage = (ObjectMessage) m;
            MyClass msg = null;
            try {
                msg = (MyClass) objectMessage.getObject();
            } catch (JMSException e) {
                e.printStackTrace();
            } catch (javax.jms.JMSException e) {
                e.printStackTrace();
            }
            System.out.println("following message is received: " + msg.toString());
        }
    }
}
