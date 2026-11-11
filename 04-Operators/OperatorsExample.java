public class OperatorsExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        // Arithmetic operators
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Integer division: " + (a / b));
        System.out.println("Remainder: " + (a % b));

        // Assignment operators
        int score = 10;
        score += 5;
        System.out.println("Score after += 5: " + score);

        // Comparison operators
        System.out.println("a is greater than b: " + (a > b));
        System.out.println("a equals b: " + (a == b));

        // Logical operators
        int age = 20;
        boolean hasID = true;
        System.out.println("Can enter: " + (age >= 18 && hasID));

        // Increment and decrement
        int count = 5;
        count++;
        System.out.println("After increment: " + count);
        count--;
        System.out.println("After decrement: " + count);

        // Operator precedence
        int result = 2 + 3 * 4;
        System.out.println("2 + 3 * 4 = " + result);

        int groupedResult = (2 + 3) * 4;
        System.out.println("(2 + 3) * 4 = " + groupedResult);
    }
}
