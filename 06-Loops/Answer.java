public class Answer {
    public static void main(String[] args) {

        // Exercise 1: For loop from 1 to 10
        System.out.println("Exercise 1:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        // Exercise 2: Even numbers from 2 to 10
        System.out.println("\nExercise 2:");
        int number = 2;
        while (number <= 10) {
            System.out.println(number);
            number += 2;
        }

        // Exercise 3: Print Hello Java three times
        System.out.println("\nExercise 3:");
        int count = 1;
        do {
            System.out.println("Hello Java");
            count++;
        } while (count <= 3);

        // Exercise 4: Stop before 6
        System.out.println("\nExercise 4:");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                break;
            }
            System.out.println(i);
        }

        // Exercise 5: Skip number 5
        System.out.println("\nExercise 5:");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                continue;
            }
            System.out.println(i);
        }

        // Exercise 6: Three rows with five stars
        System.out.println("\nExercise 6:");
        for (int row = 1; row <= 3; row++) {
            for (int column = 1; column <= 5; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
