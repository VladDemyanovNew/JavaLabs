package by.VDemyanov.JMS_Lab14.P2Phabr;

public class Main {
    public static void main(String[] args){
        Producer producer = new Producer();
        producer.sendString("test");
    }
}
