public class Answer {
    public static void main(String[] args) {
        // Exercise 1: Arithmetic operators
        int x = 17;
        int y = 5;

        System.out.println("Addition: " + (x + y));       // 22
        System.out.println("Subtraction: " + (x - y));    // 12
        System.out.println("Multiplication: " + (x * y)); // 85
        System.out.println("Division: " + (x / y));       // 3
        System.out.println("Remainder: " + (x % y));      // 2

        // Exercise 2: Comparison operators
        int age = 16;
        System.out.println("Age is 16: " + (age == 16));
        System.out.println("Age > 18: " + (age > 18));
        System.out.println("Age <= 18: " + (age <= 18));
        System.out.println("Age != 20: " + (age != 20));

        // Exercise 3: Logical operators
        boolean isStudent = true;
        boolean hasCard = false;
        System.out.println("AND: " + (isStudent && hasCard));
        System.out.println("OR: " + (isStudent || hasCard));
        System.out.println("NOT: " + (!isStudent));

        // Exercise 4: Assignment and increment
        int points = 10;
        points += 5;
        System.out.println("After += 5: " + points); // 15
        points -= 3;
        System.out.println("After -= 3: " + points); // 12
        points++;
        System.out.println("After ++: " + points);  // 13
        points--;
        System.out.println("After --: " + points);  // 12

        // Exercise 5: Precedence
        int a = 4;
        int b = 6;
        int result = a + b * 2;
        System.out.println("Result: " + result); // 16

        // Bonus: Entry check
        int visitorAge = 20;
        boolean hasTicket = true;
        boolean canEnter = visitorAge >= 18 && hasTicket;
        System.out.println("Can enter: " + canEnter);
    }
}
