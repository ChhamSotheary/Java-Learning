public class Answer {
    static void greet(String name) {
        System.out.println("សួស្តី " + name + "!");
    }

    static int add(int first, int second) {
        return first + second;
    }

    static boolean isEven(int number) {
        return number % 2 == 0;
    }

    static double average(int first, int second, int third) {
        return (first + second + third) / 3.0;
    }

    static void printInfo(String name) {
        System.out.println("ឈ្មោះ: " + name);
    }

    static void printInfo(String name, int age) {
        System.out.println("ឈ្មោះ: " + name + ", អាយុ: " + age);
    }

    static int findMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array មិនអាច null ឬទទេបានទេ");
        }

        int max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    static void changeValue(int value) {
        value = 99;
        System.out.println("ក្នុង method: " + value);
    }

    public static void main(String[] args) {
        System.out.println("លំហាត់ទី ១៖");
        greet("សុភា");

        System.out.println("\nលំហាត់ទី ២៖");
        System.out.println(add(12, 8));

        System.out.println("\nលំហាត់ទី ៣៖");
        System.out.println("7 ជាលេខគូ? " + isEven(7));
        System.out.println("12 ជាលេខគូ? " + isEven(12));

        System.out.println("\nលំហាត់ទី ៤៖");
        System.out.println("មធ្យមភាគ: " + average(80, 90, 85));

        System.out.println("\nលំហាត់ទី ៥៖");
        printInfo("ដារ៉ា");
        printInfo("ដារ៉ា", 20);

        System.out.println("\nChallenge៖");
        int[] numbers = {4, 15, 2, 9};
        System.out.println("តម្លៃធំបំផុត: " + findMax(numbers));

        System.out.println("\nលំហាត់ទី ៦៖");
        int n = 10;
        changeValue(n);
        System.out.println("ក្រៅ method: " + n);
    }
}
