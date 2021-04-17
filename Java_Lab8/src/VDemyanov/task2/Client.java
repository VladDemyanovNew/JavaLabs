package VDemyanov.task2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String args[])throws Exception{
        Socket serverSocket =new Socket("localhost",3333);
        DataInputStream din=new DataInputStream(serverSocket.getInputStream());
        DataOutputStream dout=new DataOutputStream(serverSocket.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str="",str2="";
        while(!str.equals("stop")){
            System.out.println("Enter the four-digit number.");
            str=br.readLine();

            dout.writeUTF(str);
            dout.flush();
            str2=din.readUTF();
            System.out.println("Server says: " + str2);
        }

        dout.close();
        serverSocket.close();
    }
}
