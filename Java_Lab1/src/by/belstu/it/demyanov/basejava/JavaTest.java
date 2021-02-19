package by.belstu.it.demyanov.basejava;

import by.belstu.it.demyanov.TextFunction;
import by.belstu.it.demyanov.basejava.WrapperString;

import java.io.Console;
import java.util.Arrays;
import java.util.Objects;

import static java.lang.Math.*; // благодаря статическому импорту мы можем использовать без названия класса

/**
 * @author VDemyanov
 * @version 1.0
 */
public class JavaTest {

    static int sint;

    final int finalInt = 0;
    public final int publicFinalInt = 1;
    public static final int publicStaticFinalInt = 2;

    /**
     *
     * @param args массив параметров передаваемых из консоли
     * @return метод ничего не возвращает
     */
    public static void main(String[] args) {
        //TODO add a new method
        TextFunction obj = new TextFunction();
        System.out.println(obj.getValue());
        System.out.println("Test");

        Task_3b();
        Task_3d();
        Task_3e();
        Task_3f();
        Task_3g();
        Task_3h();
    }

    public static void Task_3b() {

        System.out.println("\n\nЗадание 3b\n");

        /**
         * @value 'M'
         * @see
         */
        char charVariable = 'M';
        int intVariable = 32768;
        short shortVariable = 128;
        byte byteVariable = 10;
        long longVariable = 2147483627;
        boolean booleanVariable = true;
        String stringVariable = "str";
        double doubleVariable = 2.2;

        System.out.println("String + int = " + (stringVariable + intVariable));
        System.out.println("String + char = " + (stringVariable + charVariable));
        System.out.println("String + double = " + (stringVariable + doubleVariable));

        byte byteResult = (byte) (byteVariable + intVariable);
        int intResult = (int) (doubleVariable + longVariable);
        long longResult = intVariable + 2147483647;

        System.out.println("byte = byte + int: " + byteResult);
        System.out.println("int = double + long: " + intResult);
        System.out.println("long = int + 2147483647: " + longResult);

        System.out.println("static int sint вывод без инициализации: " + sint);

        boolean boolResult = true && false;
        boolean boolResult2 = true ^ false;
        System.out.println("boolean && boolean = " + boolResult);
        System.out.println("boolean ^ boolean = " + boolResult2);
        //System.out.println(booleanVariable + booleanVariable); // булевые значения нельзя складывать

        // по умолчанию все целочиленные значения имеют тип int
        long longMax = 9223372036854775807L;
        long longValue = 0x7fff_ffff_fffL;  // с помощью '_' мы можем разделять число на разряды
        System.out.println("9223372036854775807L: " + longMax + "\n" + "0x7fff_ffff_fffL: " + longValue);
        //---------
        char a = 'a';
        char b = '\u0061';
        char c = 97;
        int result_a_b_c = a + b + c;
        System.out.println("\'a\'+\'\u0061\'+97 = " + result_a_b_c);
        //---------
        System.out.println("3.45 % 2.4 = " + 3.45 % 2.411);
        //---------
        System.out.println("1.0/0.0 = " + 1.0/0.0);
        //---------
        System.out.println("0.0/0.0 = " + 0.0/0.0);
        //---------
        System.out.println("log(-345) = " + log(-345));
        //---------
        System.out.println("Float.intBitsToFloat(0x7F800000) = " + Float.intBitsToFloat(0x7F800000));
        //---------
        System.out.println("Float.intBitsToFloat(0xFF800000) = " + Float.intBitsToFloat(0xFF800000));
    }

    public static void Task_3d() {
        System.out.println("\n\nЗадание 3d\n");
        System.out.println("PI: " + PI);
        System.out.println("E: " + E);
        System.out.println("Math.round(PI и E): " + round(E) +  " " + round(PI));
        System.out.println("Math.min(PI, E): " + min(PI, E));
        System.out.println("Рандомное число (0,1]: " + Math.random());
    }

    public static void Task_3e() {
        System.out.println("\n\nЗадание 3d\n");
        Boolean boolVar = Boolean.FALSE;
        Character charVar = Character.MAX_VALUE;
        Integer intVar = Integer.MIN_VALUE;
        Byte byteVar = Byte.MAX_VALUE;
        Short shortVar = Short.MIN_VALUE;
        Long longVar = Long.MIN_VALUE;
        Double doubleVar = Double.MAX_VALUE;

        Integer ia = 2;
        Integer ib = 5;
        System.out.println("ia & ib = " + (ia & ib));
        System.out.println("ia | ib = " + (ia | ib));
        System.out.println("ia ^ ib = " + (ia ^ ib));
        System.out.println("~ia = " + (~ia));
        System.out.println("ia << 1 = " + (ia << 1));
        System.out.println("(ia * 4) >> 1 = " + ((ia * 4) >> 1));
        System.out.println("-8 >>> 2 = " + (-8 >>> 2));

    }

    public static void Task_3f() {
        System.out.println("\n\nЗадание 3f\n");
        String s34 = "2345";

        //Выполните преобразование числа типа String (String s34 = "2345";)
        //к int
        int intS34 = Integer.parseInt(s34);
        System.out.println("(from String in int) + 1 = " + (intS34 + 1));

        //переводите строку в массив байтов и обратно из массива байтов в
        //строку
        byte[] byteArray = s34.getBytes();
        s34 = byteArray.toString();

        //преобразуйте строку в логический тип 2-мя способами
        boolean boolS34_1 = s34.isEmpty();
        boolean boolS34_2 = s34 == "2345";

        //определите две строки (String) с одинаковыми инициализаторами.
        //Выполите ==, equals, compareTo. В чем разница, поясните
        //результат. Одной из строк присвойте null. Повторите все три
        //варианта сравнения
        String str1 = "12345";
        String str2 = "12345";
        //сравнивает два объекта, чтобы увидеть, указывают ли они на одну и ту же ячейку памяти
        System.out.println("Сравнение с использованием \'==\': s" + (str1 == str2));
        //сравнивает строки с учётом регистра
        System.out.println("Сравнение с использованием \'equals\': " + (str1.equals(str2)));
        //возвращает целое число меньше/равен/больше
        System.out.println("Сравнение с использованием \'compareTo\': " + (str1.compareTo(str2)));

        //для произвольной строки выполните функции split, contains,
        //hashCode, indexOf, length, replace
        String myStr = "Hello World!";
        String[] myStrWords = myStr.split(" ");
        System.out.println("split: " + String.join(",", myStrWords));
        System.out.println("contains: " + myStr.contains("l"));
        System.out.println("hashCode: " + myStr.hashCode());
        System.out.println("indexOf: " + myStr.indexOf("rl"));
        System.out.println("length: " + myStr.length());
        System.out.println("replace: " + myStr.replace("World", "Hello"));
    }

    public static void Task_3g() {
        System.out.println("\n\nЗадание 3g\n");
        char[][] c1;
        char[] c2[];
        char c3[][];

        int nums[];
        nums = new int[0];
//        nums[0] = 1;
//        System.out.println(nums[0]);

        c1 = new char[3][];
        for (int i = 0; i < c1.length; i++)
            c1[i] = new char[i + 1];
        for (char[] i: c1)
            System.out.println(i.length);

        c2 = new char[3][];
        c3 = new char[3][];
        System.out.println(c2 == c3);
        c2 = c3;
        System.out.println(c2 == c3);
        //System.out.println(c2[3]);
    }

    public static void Task_3h() {
        System.out.println("\n\nЗадание 3h\n");
        WrapperString wrapperString = new WrapperString("Hello world!");
        wrapperString.replace('H', 'A');
        System.out.println(wrapperString.getStr());

        //  анонимный класс
        WrapperString wrapperString1 = new WrapperString("Word1 Word2 Word3...") {

            @Override
            public void replace(char oldchar, char newchar) {
                System.out.println("Метод переопределён");
                super.replace(oldchar, newchar);
            }

            public void delete(char newchar) {
                String str = super.getStr();
                str = str.substring(0, str.indexOf(newchar)) + str.substring(str.indexOf(newchar) + 1);
                super.setStr(str);
            }
        };
    }
}
