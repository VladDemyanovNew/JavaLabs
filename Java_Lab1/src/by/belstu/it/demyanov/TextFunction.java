package by.belstu.it.demyanov;

public class TextFunction {
    public int getValue() {
        return extracted();
    }

    private int extracted() {
        int result = 0;
        int b = 5;
        int a = 6;
        for (int i = 0; i < 10; i++) {
            result += a + b;
        }
        return result;
    }
}
