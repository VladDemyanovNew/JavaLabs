package VDemyanov.Mail.entity;

import java.sql.Date;
import java.util.Objects;

public class Letter {
    private int id;
    private int sender;
    private int recipient;
    private String topic;
    private String text;
    private Date shippingDate;

    public Letter() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getRecipient() {
        return recipient;
    }

    public void setRecipient(int recipient) {
        this.recipient = recipient;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return id == letter.id && sender == letter.sender && recipient == letter.recipient && Objects.equals(topic, letter.topic) && Objects.equals(text, letter.text) && Objects.equals(shippingDate, letter.shippingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sender, recipient, topic, text, shippingDate);
    }

    @Override
    public String toString() {
        return "Letter{" +
                "id=" + id +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", topic='" + topic + '\'' +
                ", text='" + text + '\'' +
                ", shippingDate=" + shippingDate +
                '}';
    }
}
