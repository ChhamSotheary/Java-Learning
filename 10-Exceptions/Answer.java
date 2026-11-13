import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class Answer {
    static int safeDivide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("b មិនអាចសូន្យ");
        }
        return a / b;
    }

    static int parseNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException exception) {
            System.out.println("Input មិនមែនជាលេខត្រឹមត្រូវ: " + text);
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(parseNumber("123"));
        System.out.println(parseNumber("abc"));

        try {
            System.out.println(safeDivide(10, 0));
        } catch (IllegalArgumentException exception) {
            System.out.println("កំហុស: " + exception.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new StringReader("សួស្តី"))) {
            System.out.println(reader.readLine());
        } catch (IOException exception) {
            System.out.println("អានមិនបាន: " + exception.getMessage());
        }
    }
}
