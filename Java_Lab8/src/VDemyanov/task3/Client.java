package VDemyanov.task3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String args[])throws Exception {
        // создание сокета для прослушивания порта 4445
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();

        // создание экземпляра класса для считывания текста из символьнаго потока ввода
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte buf[] = null;
        String str = "";

        while (true) {
            System.out.println("Enter something: ");
            str = br.readLine();
            buf = str.getBytes(StandardCharsets.UTF_8);
            // создание датаграммы для отправки данных
            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 4445);
            // отправка данных
            datagramSocket.send(DpSend);
            if (str.equals("stop"))
                break;
        }

    }
}
