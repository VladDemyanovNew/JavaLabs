package VDemyanov.task1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) throws IOException {

        String selection;
        try (Scanner in = new Scanner(System.in)) {
            do {
                System.out.print("Введите: \n\t1 для downloadImg()\n\t2 для readHTML()\n\t3 для выхода\n");
                System.out.println("Input: ");
                selection = in.nextLine();
                switch (selection) {
                    case "1":
                        downloadImg();
                        break;
                    case "2":
                        readHTML();
                        break;
                    case "3":
                        break;
                    default:
                        System.out.println("Вы ввели неправильное значение");
                        break;
                }
            } while(!selection.equals("3"));
        }
    }

    public static void downloadImg() {
        try {
            URL url = new URL("https://sun9-48.userapi.com/impg/KXEhXMzDIEuXRvb3gjQZX4d0o2jb_bRR8S9Xog/x8S4cphPaHg.jpg?size=1080x1196&quality=96&sign=7bad89d22526c021ea81f2c0f0a83449&type=album");
            BufferedImage img = ImageIO.read(url);
            File file = new File("data\\downloaded.jpg");
            ImageIO.write(img, "jpg", file);
            System.out.println("Картинка загружена");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readHTML() {
        URL tut = null;
        String urlName = "http://www.tut.by";

        try {
            tut  =  new URL(urlName);
        } catch (MalformedURLException e) {
            // некорректно заданы протокол, доменное имя или путь к файлу
            e.printStackTrace();
        }

        if (tut == null) {
            throw new RuntimeException();
        }

        try (BufferedReader d = new BufferedReader (new InputStreamReader(tut.openStream()))) {
            String line = "";
            try (FileWriter writer = new FileWriter("data\\resultReadHTML.txt", false)) {
                while ((line = d.readLine()) != null) {
                    writer.write(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
