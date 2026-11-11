public class Answer {
    public static void main(String[] args) {
        // Exercise 1: Positive, negative, or zero
        int number = -5;

        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }

        // Exercise 2: Even or odd
        int checkNumber = 12;

        if (checkNumber % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }

        // Exercise 3: Grade
        int score = 78;

        if (score < 0 || score > 100) {
            System.out.println("Invalid score");
        } else if (score >= 90) {
            System.out.println("Grade A");
        } else if (score >= 80) {
            System.out.println("Grade B");
        } else if (score >= 70) {
            System.out.println("Grade C");
        } else if (score >= 60) {
            System.out.println("Grade D");
        } else {
            System.out.println("Grade F");
        }

        // Exercise 4: Switch and weekdays
        int day = 5;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
        }

        // Exercise 5: Entry check
        int age = 19;
        boolean hasTicket = true;

        if (age >= 18 && hasTicket) {
            System.out.println("Entry allowed");
        } else {
            System.out.println("Entry denied");
        }

        // Exercise 6: Ternary operator
        int temperature = 35;
        String weather = (temperature >= 30) ? "Hot" : "Cool";
        System.out.println(weather);

        // Bonus: Ticket price category
        int visitorAge = 12;

        if (visitorAge < 0) {
            System.out.println("Invalid age");
        } else if (visitorAge < 5) {
            System.out.println("Free");
        } else if (visitorAge <= 17) {
            System.out.println("Child ticket");
        } else {
            System.out.println("Adult ticket");
        }
    }
}
