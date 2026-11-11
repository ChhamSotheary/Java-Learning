public class ConditionsExample {
    public static void main(String[] args) {
        // if statement
        int age = 20;

        if (age >= 18) {
            System.out.println("You are an adult.");
        }

        // if...else statement
        int score = 45;

        if (score >= 50) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        // if...else if...else statement
        if (score >= 90) {
            System.out.println("Grade A");
        } else if (score >= 80) {
            System.out.println("Grade B");
        } else if (score >= 70) {
            System.out.println("Grade C");
        } else if (score >= 50) {
            System.out.println("Grade D");
        } else {
            System.out.println("Grade F");
        }

        // Nested if
        boolean hasID = true;

        if (age >= 18) {
            if (hasID) {
                System.out.println("Entry allowed.");
            } else {
                System.out.println("Please show your ID.");
            }
        } else {
            System.out.println("Too young to enter.");
        }

        // Traditional switch
        int day = 2;

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
            default:
                System.out.println("Unknown day");
        }

        // Ternary operator
        String ageGroup = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Age group: " + ageGroup);
    }
}
