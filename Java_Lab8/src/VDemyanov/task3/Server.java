package VDemyanov.task3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String args[])throws Exception {
        // создание сокета для прослушивания порта 4445
        DatagramSocket datagramSocket = new DatagramSocket(4445);
        byte[] receive = new byte[255];

        while(true) {
            // создание датаграммы для получение данных
            DatagramPacket DpReceive = new DatagramPacket(receive, receive.length);
            // получение данных в буффер
            datagramSocket.receive(DpReceive);
            System.out.println("Client says: " + data(receive));
            if (data(receive).toString().equals("stop"))
            {
                System.out.println("Closing connection...");
                break;
            }
        }
    }

    /**
     * Преобразует byte array в строку
     * @param a
     * @return
     */
    public static StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}
