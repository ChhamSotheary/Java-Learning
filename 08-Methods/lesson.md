# មេរៀនទី ៨៖ Methods ក្នុង Java

## គោលបំណងមេរៀន

បន្ទាប់ពីរៀនមេរៀននេះ អ្នកនឹងអាច៖

- ពន្យល់ថា Method គឺជាអ្វី និងហេតុអ្វីត្រូវប្រើ។
- បង្កើត Method ដែលគ្មាន return value និង Method ដែលត្រឡប់តម្លៃ។
- ប្រើ parameter និង argument។
- ហៅ Method ពី main។
- ស្គាល់ Method overloading, scope និងកំហុសដែលជួបញឹកញាប់។

---

## 1. តើ Method គឺជាអ្វី?

**Method** គឺជាក្រុមសេចក្ដីបញ្ជាដែលដាក់ឈ្មោះឱ្យ ហើយអាចហៅប្រើឡើងវិញ។ វាជួយបំបែកកម្មវិធីធំទៅជាផ្នែកតូចៗដែលមានតួនាទីច្បាស់។

បើត្រូវបង្ហាញសារដដែលៗច្រើនកន្លែង អាចសរសេរ Method ម្តង ហើយហៅវាច្រើនដង ជំនួសការចម្លងកូដ។

~~~java
public class MethodExample {
    static void sayHello() {
        System.out.println("Hello!");
    }

    public static void main(String[] args) {
        sayHello();
        sayHello();
    }
}
~~~

Method របស់យើងស្ថិតក្នុង class។ ក្នុងឧទាហរណ៍នេះ main ហៅ sayHello() ពីរដង។

## 2. រចនាសម្ព័ន្ធ Method

~~~text
accessModifier static returnType methodName(parameters) {
    // statements
    return value;
}
~~~

- **accessModifier**៖ កំណត់ថាផ្នែកណាអាចប្រើ method បាន ដូចជា public ឬ private។
- **static**៖ អាចហៅតាម class ដោយមិនចាំបាច់បង្កើត object ជាមុន។
- **returnType**៖ ប្រភេទតម្លៃដែល method ត្រឡប់មកវិញ ដូចជា int, double, String ឬ void។
- **methodName**៖ ឈ្មោះ method; ជាទូទៅចាប់ផ្តើមដោយអក្សរតូច និងប្រើ camelCase។
- **parameters**៖ តម្លៃបញ្ចូលដែល method ត្រូវការ។
- **return**៖ បញ្ជូនលទ្ធផលត្រឡប់ទៅអ្នកហៅ method។

## 3. Method ដែលមិនត្រឡប់តម្លៃ៖ void

ប្រើ void នៅពេល method ធ្វើសកម្មភាព ប៉ុន្តែមិនត្រូវការផ្ញើលទ្ធផលត្រឡប់។

~~~java
public class Greeting {
    static void greet() {
        System.out.println("សួស្តី!");
    }

    public static void main(String[] args) {
        greet();
    }
}
~~~

## 4. Parameter និង Argument

**Parameter** ជាអថេរដែលកំណត់ក្នុងសញ្ញាវង់ក្រចករបស់ method។ **Argument** ជាតម្លៃពិតដែលផ្ញើពេលហៅ method។

~~~java
public class GreetingWithName {
    static void greet(String name) {
        System.out.println("សួស្តី " + name);
    }

    public static void main(String[] args) {
        greet("សុភា");
        greet("ដារ៉ា");
    }
}
~~~

នៅក្នុង greet(String name), name ជា parameter។ ពេលហៅ greet("សុភា"), "សុភា" ជា argument។

Method អាចទទួល parameter ច្រើន៖

~~~java
static void printPerson(String name, int age) {
    System.out.println(name + " អាយុ " + age);
}
~~~

ពេលហៅ ត្រូវផ្ញើ argument តាមលំដាប់ និងប្រភេទដែលត្រូវគ្នា៖

~~~java
printPerson("សុភា", 20);
~~~

## 5. Method ដែលត្រឡប់តម្លៃ

បើ method គណនា ឬរកលទ្ធផលដែល caller ត្រូវប្រើ សូមកំណត់ return type ជាប្រភេទទិន្នន័យនោះ ហើយប្រើ return។

~~~java
public class Calculator {
    static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result = add(5, 3);
        System.out.println(result);
    }
}
~~~

លទ្ធផល៖

~~~text
8
~~~

នៅក្នុង method ដែល return int គ្រប់ផ្លូវដំណើរការត្រូវត្រឡប់ int មកវិញ។ បើប្រើ void អ្នកមិនអាច return តម្លៃ int ដូចគ្នានេះបានទេ។

## 6. Return type ផ្សេងៗ

~~~java
static double calculateAverage(int total, int count) {
    return (double) total / count;
}

static String makeGreeting(String name) {
    return "សួស្តី " + name;
}

static boolean isAdult(int age) {
    return age >= 18;
}
~~~

ប្រើប្រភេទ return ដែលត្រូវនឹងលទ្ធផល។ ក្នុង calculateAverage យើង cast total ទៅ double មុនចែក ដើម្បីមិនឱ្យការចែក int បាត់ខ្ទង់ទសភាគ។

> មុនប្រើ calculateAverage ត្រូវគិតពីករណី count = 0 ផងដែរ។ កម្មវិធីគួរត្រួតពិនិត្យ input ដើម្បីជៀសវាងការចែកនឹងសូន្យ។

## 7. Static Method និង Object Method

នៅក្នុងមេរៀននេះ យើងប្រើ static method ដើម្បីអាចហៅពី main ដោយផ្ទាល់។

~~~java
static void showMessage() {
    System.out.println("Hello");
}
~~~

Method ដែលមិនមាន static ជា instance method។ ដើម្បីហៅវា ត្រូវបង្កើត object ជាមុន៖

~~~java
class Greeter {
    void greet() {
        System.out.println("Hello");
    }
}

public class Main {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        greeter.greet();
    }
}
~~~

ការប្រើ object និង instance method នឹងសិក្សាបន្ថែមក្នុងមេរៀន Object-Oriented Programming។

## 8. Method Overloading

**Method overloading** គឺមាន method ឈ្មោះដូចគ្នា តែ parameter list ខុសគ្នា ដូចជា ចំនួន ឬប្រភេទ parameter។

~~~java
public class Printer {
    static void printValue(int value) {
        System.out.println("ចំនួនគត់: " + value);
    }

    static void printValue(String value) {
        System.out.println("អត្ថបទ: " + value);
    }

    public static void main(String[] args) {
        printValue(10);
        printValue("Java");
    }
}
~~~

ការផ្លាស់ប្តូរ return type តែមួយមុខមិនគ្រប់គ្រាន់សម្រាប់ overloading ទេ។ ឧទាហរណ៍ method ដូចគ្នាដែលមានឈ្មោះ និង parameters ដូចគ្នា តែ return type មួយ int មួយ double នឹងមិន compile បាន។

## 9. Variable Scope ក្នុង Method

អថេរដែលប្រកាសក្នុង method ឬ block ជា local variable ហើយប្រើបានតែក្នុង scope នោះ។

~~~java
static void printNumber() {
    int number = 10;
    System.out.println(number);
}
~~~

អថេរ number មិនអាចប្រើដោយផ្ទាល់ពី main បានទេ ព្រោះវានៅក្នុង scope របស់ printNumber។

## 10. Java បញ្ជូន Argument ដោយតម្លៃ

Java បញ្ជូន argument ទាំងអស់ **by value**។ សម្រាប់ primitive ដូចជា int វាចម្លងតម្លៃ។ សម្រាប់ object reference វាចម្លងតម្លៃរបស់ reference; ដូច្នេះ method អាចកែប្រែ state របស់ object ដដែល តែការកំណត់ parameter reference ទៅ object ថ្មីមិនប្ដូរ variable របស់ caller ទេ។

ចំណុចនេះសំខាន់ ប៉ុន្តែអាចចាំមុនថា៖ ការផ្លាស់ប្តូរ primitive parameter មិនប្ដូរអថេរដើមនៅ caller ទេ។

~~~java
static void changeNumber(int value) {
    value = 99;
}

public static void main(String[] args) {
    int number = 10;
    changeNumber(number);
    System.out.println(number); // 10
}
~~~

## 11. កំហុសដែលជួបញឹកញាប់

- ហៅ method ប៉ុន្តែភ្លេចបញ្ចូល argument ដែលត្រូវការ។
- ប្រភេទ ឬលំដាប់ argument មិនត្រូវនឹង parameters។
- ប្រកាស method ជា int ប៉ុន្តែភ្លេច return តម្លៃគ្រប់ផ្លូវ។
- ព្យាយាមហៅ instance method ពី static main ដោយមិនបង្កើត object។
- គិតថា method អាចប្រើ local variable របស់ method ផ្សេងដោយផ្ទាល់។
- ប្រើឈ្មោះ method ឬអក្សរធំ/តូចមិនដូចគ្នា។ Java case-sensitive។

## 12. ឧទាហរណ៍ពេញលេញ

~~~java
public class StudentScore {
    static double calculateAverage(int first, int second, int third) {
        int total = first + second + third;
        return total / 3.0;
    }

    static void printResult(String name, double average) {
        System.out.println(name + " មានមធ្យមភាគ " + average);
    }

    public static void main(String[] args) {
        double average = calculateAverage(80, 90, 85);
        printResult("សុភា", average);
    }
}
~~~

លទ្ធផល៖

~~~text
សុភា មានមធ្យមភាគ 85.0
~~~

## 13. Compile និង Run

រក្សាទុកកូដក្នុងឯកសារ StudentScore.java៖

~~~powershell
javac StudentScore.java
java StudentScore
~~~

ឈ្មោះ public class ត្រូវតែដូចឈ្មោះឯកសារ។

## 14. ពាក្យសំខាន់ៗ

| English | អត្ថន័យជាខ្មែរ |
|---|---|
| Method | ក្រុមកូដដែលមានឈ្មោះ និងអាចហៅប្រើ |
| Parameter | អថេរទទួល input ក្នុងការកំណត់ method |
| Argument | តម្លៃដែលផ្ញើពេលហៅ method |
| Return type | ប្រភេទលទ្ធផលដែល method ត្រឡប់ |
| void | Method មិនត្រឡប់តម្លៃ |
| Scope | តំបន់ដែលអថេរ ឬឈ្មោះអាចប្រើបាន |
| Overloading | Method ឈ្មោះដូចគ្នា តែ parameter ខុសគ្នា |

## សង្ខេប

- Method ជួយរៀបចំកូដ និងប្រើ logic ដដែលឡើងវិញ។
- Parameter ទទួល input; argument ជាតម្លៃដែលផ្ញើទៅ។
- ប្រើ void បើមិនចាំបាច់ return value។
- ប្រើ return type ដូចប្រភេទលទ្ធផល។
- Method overloading ត្រូវមាន parameter list ខុសគ្នា។
- Local variable អាចប្រើតែក្នុង scope ដែលវាត្រូវបានប្រកាស។
- Java បញ្ជូន argument ដោយតម្លៃ។

សូមសាកល្បង [លំហាត់មេរៀនទី ៨](exercise.md) មុនមើល [ចម្លើយគំរូ](Answer.java)។
