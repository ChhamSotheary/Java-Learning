public class Answer {
    public static void main(String[] args) {

        // Exercise 1: Create an array and access selected indexes
        System.out.println("Exercise 1:");
        int[] numbers = {5, 10, 15, 20, 25};
        System.out.println(numbers[0]);
        System.out.println(numbers[2]);
        System.out.println(numbers[4]);

        // Exercise 2: Change a value and print all values
        System.out.println("\nExercise 2:");
        int[] ages = {18, 20, 22, 24};
        ages[1] = 21;
        for (int age : ages) {
            System.out.println(age);
        }

        // Exercise 3: Use a for loop
        System.out.println("\nExercise 3:");
        int[] evenNumbers = {2, 4, 6, 8, 10};
        for (int i = 0; i < evenNumbers.length; i++) {
            System.out.println(evenNumbers[i]);
        }

        // Exercise 4: Use a for-each loop
        System.out.println("\nExercise 4:");
        String[] fruits = {"Apple", "Banana", "Mango", "Orange"};
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Exercise 5: Calculate the total
        System.out.println("\nExercise 5:");
        int[] prices = {10, 20, 30, 40, 50};
        int priceTotal = 0;
        for (int price : prices) {
            priceTotal += price;
        }
        System.out.println("Total: " + priceTotal);

        // Exercise 6: Calculate the average
        System.out.println("\nExercise 6:");
        int[] scores = {70, 80, 90, 85, 75};
        int scoreTotal = 0;
        for (int score : scores) {
            scoreTotal += score;
        }
        double average = (double) scoreTotal / scores.length;
        System.out.println("Average: " + average);

        // Exercise 7: Print a two-dimensional array
        System.out.println("\nExercise 7:");
        int[][] table = {
            {1, 2, 3},
            {4, 5, 6}
        };

        for (int row = 0; row < table.length; row++) {
            for (int column = 0; column < table[row].length; column++) {
                System.out.print(table[row][column] + " ");
            }
            System.out.println();
        }
    }
}
