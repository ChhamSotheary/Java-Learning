public class LoopsExample {
    public static void main(String[] args) {

        // 1. For loop
        System.out.println("For Loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // 2. While loop
        System.out.println("\nWhile Loop:");
        int count = 1;
        while (count <= 5) {
            System.out.println(count);
            count++;
        }

        // 3. Do-while loop
        System.out.println("\nDo-While Loop:");
        int number = 1;
        do {
            System.out.println(number);
            number++;
        } while (number <= 5);

        // 4. Break
        System.out.println("\nBreak Example:");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println(i);
        }

        // 5. Continue
        System.out.println("\nContinue Example:");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println(i);
        }

        // 6. Nested loop
        System.out.println("\nNested Loop:");
        for (int row = 1; row <= 3; row++) {
            for (int column = 1; column <= 4; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
