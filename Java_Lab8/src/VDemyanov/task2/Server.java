package VDemyanov.task2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    public static void main(String args[])throws Exception{
        System.out.println("Waiting for client...");


        // создание сокета сервера на 3333 порту
        ServerSocket serverSocket =new ServerSocket(3333);
        // установка сервера в режим прослушивания
        Socket clientSocket = serverSocket.accept();
        // создание экземляра класса для работы с потоком ввода клиента
        DataInputStream din=new DataInputStream(clientSocket.getInputStream());
        // создание экземляра класса для работы с потоком вывода клиента
        DataOutputStream dout=new DataOutputStream(clientSocket.getOutputStream());
        // создание экземпляра класса для считывания текста из символьнаго потока ввода
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //---------------------------------------------------------------------

        // Загаданное число
        String targetStr = getTargetStr();
        // Флаг отгадки
        boolean guessed = false;
        // Количество попыток отгадки
        int guesses = 0;

        // количество совпавших цифр и стоящих на том же месте
        int bulls = 0;
        // количество совпавших чисел, но стоящих на другом месте
        int cows = 0;
        // число - догадка
        int guess = 0;

        //---------------------------------------------------------------------
        String guesssStr ="",str2="";
        while(!guessed && !guesssStr.equals("stop")) {

            guesssStr =din.readUTF();

            try
            {
                guess = Integer.parseInt(guesssStr);
            }
            catch(NumberFormatException nfe)
            {
                dout.writeUTF("Entered value is not a number.");
                continue;
            }

            if(hasDupes(guess) || guess < 1000) {
                dout.writeUTF("Input correct num.");
                dout.flush();
                continue;
            }

            guesses++;
            String guessStr = guess + "";

            for(int i= 0;i < 4;i++){
                if(guessStr.charAt(i) == targetStr.charAt(i)){
                    bulls++;
                }else if(targetStr.contains(guessStr.charAt(i)+"")){
                    cows++;
                }
            }
            if(bulls == 4){
                guessed = true;
            }else{
                dout.writeUTF(cows + " Cows and " + bulls + " Bulls.");
            }

            bulls = 0;
            cows = 0;
            dout.flush();
        }
        //---------------------------------------------------------------------

        dout.writeUTF("You won after "+guesses+" guesses!");
        dout.writeUTF("\nEnd\n");

        // закрытие потоков
        din.close();
        clientSocket.close();
        serverSocket.close();
    }

    /**
     * Возвращает загаданное число в виде строки
     * @return
     */
    public static String getTargetStr() {
        Random gen= new Random();
        int target = 0;
        while(hasDupes(target = (gen.nextInt(9000) + 1000)));
        String targetStr = target +"";
        System.out.println("Guessed num: " + targetStr);
        return targetStr;
    }

    /**
     * Проверяет число на повторяющиеся цифры
     * @param num
     * @return
     */
    public static boolean hasDupes(int num){
        boolean[] digs = new boolean[10];
        while(num > 0){
            if(digs[num%10]) return true;
            digs[num%10] = true;
            num/= 10;
        }
        return false;
    }

}
