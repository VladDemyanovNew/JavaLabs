package by.VDemyanov.JMS_Lab14.P2Phabr;

import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.Destination;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;

@Stateless
public class Producer {
    //получаем ресурсы сервера для отправки сообщений
    @Resource(name="jms/TutorialPool")
    private ConnectionFactory connectionFactory;

    @Resource(name="jms/TutorialTopic")
    private Destination destination;

    private String enterString;

    public String getEnterString() {
        return enterString;
    }

    public void sendString(String enterString) {
        try {
            //создаем подключение
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            //добавим в JMS сообщение собственное свойство в поле сообщения со свойствами
            message.setStringProperty("clientType", "web clien");
            //добавляем payload в сообщение
            message.setText(enterString);
            //отправляем сообщение
            producer.send(message);
            System.out.println("message sent");
            //закрываем соединения
            session.close();
            connection.close();

        } catch (JMSException ex) {
            System.err.println("Sending message error");
            ex.printStackTrace();
        }
    }
}
