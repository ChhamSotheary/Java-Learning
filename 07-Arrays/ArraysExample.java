public class ArraysExample {
    public static void main(String[] args) {

        // 1. Create an array
        int[] numbers = {10, 20, 30, 40, 50};

        // 2. Access values using index
        System.out.println("First number: " + numbers[0]);
        System.out.println("Last number: " + numbers[numbers.length - 1]);

        // 3. Change an array value
        numbers[1] = 99;
        System.out.println("Updated second number: " + numbers[1]);

        // 4. Print all values using a for loop
        System.out.println("\nFor Loop:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // 5. Print all values using for-each
        String[] fruits = {"Apple", "Banana", "Orange"};
        System.out.println("\nFor-Each Loop:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 6. Calculate total and average
        int[] scores = {80, 90, 75, 85, 95};
        int total = 0;

        for (int score : scores) {
            total += score;
        }

        double average = (double) total / scores.length;
        System.out.println("\nTotal: " + total);
        System.out.println("Average: " + average);

        // 7. Two-dimensional array
        int[][] table = {
            {1, 2, 3},
            {4, 5, 6}
        };

        System.out.println("\nTwo-Dimensional Array:");
        for (int row = 0; row < table.length; row++) {
            for (int column = 0; column < table[row].length; column++) {
                System.out.print(table[row][column] + " ");
            }
            System.out.println();
        }
    }
}
