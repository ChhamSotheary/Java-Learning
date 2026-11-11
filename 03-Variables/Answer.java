public class Answer {
    public static void main(String[] args) {
        // Exercise 1: My information
        String myName = "Sokha";
        int myAge = 20;
        double myHeight = 1.70;
        char myGrade = 'A';
        boolean isStudent = true;

        System.out.println("My Information");
        System.out.println("Name: " + myName);
        System.out.println("Age: " + myAge);
        System.out.println("Height: " + myHeight);
        System.out.println("Grade: " + myGrade);
        System.out.println("Student: " + isStudent);

        // Exercise 2: Suitable data types
        int studentCount = 35;
        double productPrice = 12.75;
        String city = "Phnom Penh";
        char grade = 'B';
        boolean isPaid = true;

        // Exercise 4: Constant
        final double TAX_RATE = 0.10;

        System.out.println("\nExercise Answers");
        System.out.println("Students: " + studentCount);
        System.out.println("Price: " + productPrice);
        System.out.println("City: " + city);
        System.out.println("Grade: " + grade);
        System.out.println("Paid: " + isPaid);
        System.out.println("Tax rate: " + TAX_RATE);

        // Exercise 3: Corrected statements
        int age = 20;             // int ត្រូវផ្ទុកចំនួនគត់
        String name = "Sokha";   // String ប្រើ double quotes
        float price = 10.5f;      // float ត្រូវមាន f
        int score = 90;           // ឈ្មោះ variable មិនអាចចាប់ផ្តើមដោយលេខ
    }
}
