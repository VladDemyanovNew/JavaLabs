package by.VDemyanov.JMS_Lab14.P2Phabr;

import com.sun.messaging.jms.JMSException;

import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(
        //имя topic, на который подписан бин
        mappedName="jms/TutorialTopic",
        name = "ExampleMDB")
public class Consumer implements MessageListener {
    //метод, вызываемый при получении нового сообщения
    @Override
    public void onMessage(Message msg) {
        try {
            TextMessage message = (TextMessage)msg;
            //считываем свойство из соответствующего поля, заданное вручную в consumer
            System.out.println("FROM MDB - client type IS " + message.getStringProperty("clientType"));
            //считываем  само сообщение
            System.out.println("FROM MDB - payload  IS" + message.getText());
        } catch (JMSException ex) {
            ex.printStackTrace();
        } catch (javax.jms.JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Consumer();
    }
}
