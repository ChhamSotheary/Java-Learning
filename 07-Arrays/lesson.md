# មេរៀនទី ៧៖ Arrays ក្នុង Java

## គោលបំណងមេរៀន

បន្ទាប់ពីរៀនមេរៀននេះ អ្នកនឹងអាច៖

- ពន្យល់ថា Array គឺជាអ្វី និងហេតុអ្វីត្រូវប្រើវា។
- ប្រកាស និងបង្កើត Array។
- ចូលប្រើ និងកែប្រែតម្លៃតាមរយៈ Index។
- ប្រើ `length` ដើម្បីដឹងចំនួនធាតុ។
- ប្រើ Loop ដើម្បីបង្ហាញ និងគណនាទិន្នន័យក្នុង Array។
- ស្គាល់ Two-Dimensional Array និងកំហុស Index។

---

## 1. តើ Array គឺជាអ្វី?

**Array** គឺជា Structure មួយសម្រាប់រក្សាទុកតម្លៃច្រើន ដែលមានប្រភេទទិន្នន័យដូចគ្នា នៅក្នុង Variable តែមួយ។

ឧទាហរណ៍ បើអ្នកចង់រក្សាទុកពិន្ទុសិស្ស 5 នាក់ អ្នកអាចបង្កើត Variable ចំនួន 5៖

```java
int score1 = 80;
int score2 = 90;
int score3 = 75;
int score4 = 85;
int score5 = 95;
```

ប៉ុន្តែយើងអាចប្រើ Array ដើម្បីសរសេរឱ្យខ្លីជាងនេះ៖

```java
int[] scores = {80, 90, 75, 85, 95};
```

ឥឡូវនេះ យើងអាចរក្សាទុកពិន្ទុទាំង 5 ក្នុង Array ឈ្មោះ `scores`។

## 2. របៀបប្រកាស Array

មានរបៀបប្រកាស Array ដូចខាងក្រោម៖

```java
dataType[] arrayName;
```

ឧទាហរណ៍៖

```java
int[] numbers;
String[] names;
double[] prices;
```

- `int[]`៖ Array ដែលរក្សាទុកចំនួនគត់។
- `String[]`៖ Array ដែលរក្សាទុកអត្ថបទ។
- `double[]`៖ Array ដែលរក្សាទុកចំនួនទសភាគ។

## 3. បង្កើត Array និងកំណត់តម្លៃ

### វិធីទី 1៖ កំណត់តម្លៃភ្លាមៗ

```java
int[] numbers = {10, 20, 30, 40, 50};
String[] fruits = {"Apple", "Banana", "Orange"};
```

### វិធីទី 2៖ កំណត់ទំហំជាមុន

```java
int[] numbers = new int[5];
```

វាបង្កើត Array ដែលអាចរក្សាទុកចំនួនធាតុបាន 5។ សម្រាប់ `int` តម្លៃដំបូងរបស់ធាតុនីមួយៗគឺ 0។

បន្ទាប់មកអាចកំណត់តម្លៃតាម Index៖

```java
numbers[0] = 10;
numbers[1] = 20;
numbers[2] = 30;
numbers[3] = 40;
numbers[4] = 50;
```

ចំណាំ៖ ទំហំ Array ត្រូវបានកំណត់ពេលបង្កើត ហើយមិនអាចបន្ថែម ឬដកធាតុដោយផ្ទាល់បានទេ។ បើត្រូវការទំហំដែលអាចប្រែប្រួល យើងនឹងរៀន `ArrayList` នៅមេរៀន Collections ពេលក្រោយ។

## 4. Array Index

**Index** គឺជាលេខទីតាំងរបស់ធាតុនៅក្នុង Array។ នៅក្នុង Java Index ចាប់ផ្តើមពី **0** មិនមែន 1 ទេ។

ឧទាហរណ៍៖

```java
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers[0]); // 10
System.out.println(numbers[1]); // 20
System.out.println(numbers[2]); // 30
```

តារាងទីតាំង៖

| Index | Value |
|---:|---:|
| 0 | 10 |
| 1 | 20 |
| 2 | 30 |
| 3 | 40 |
| 4 | 50 |

ដើម្បីយកធាតុចុងក្រោយ អាចប្រើ៖

```java
System.out.println(numbers[numbers.length - 1]);
```

## 5. កែប្រែតម្លៃក្នុង Array

ប្រើ Index ដើម្បីកែប្រែតម្លៃ៖

```java
int[] numbers = {10, 20, 30};

numbers[1] = 99;

System.out.println(numbers[1]);
```

លទ្ធផល៖

```text
99
```

តម្លៃនៅ Index 1 ត្រូវបានប្តូរពី 20 ទៅ 99។

## 6. Array Length

`length` គឺជា Property ដែលប្រាប់ចំនួនធាតុសរុបក្នុង Array។

```java
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers.length);
```

លទ្ធផល៖

```text
5
```

ចំណាំ៖ Array ប្រើ `length` ដោយគ្មានវង់ក្រចក។ វាខុសពី String ដែលប្រើ Method `length()`។

## 7. ប្រើ For Loop ជាមួយ Array

យើងអាចប្រើ `for` Loop ដើម្បីបង្ហាញធាតុទាំងអស់ក្នុង Array៖

```java
public class ArrayLoop {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
```

ការយល់ដឹង៖

- `int i = 0` ចាប់ផ្តើមពី Index 0។
- `i < numbers.length` ឱ្យ Loop ដំណើរការដរាបណា Index នៅក្នុងទំហំ Array។
- `numbers[i]` យកតម្លៃតាម Index បច្ចុប្បន្ន។
- `i++` ទៅ Index បន្ទាប់។

## 8. Enhanced For Loop (For-Each)

Java មាន Loop មួយទៀតឈ្មោះ **Enhanced For Loop** ឬ **For-Each Loop**។ វាងាយស្រួលសម្រាប់អានតម្លៃទាំងអស់ក្នុង Array នៅពេលមិនចាំបាច់ប្រើ Index។

Syntax៖

```java
for (dataType item : arrayName) {
    // use item
}
```

ឧទាហរណ៍៖

```java
public class ForEachExample {
    public static void main(String[] args) {
        String[] fruits = {"Apple", "Banana", "Orange"};

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
```

លទ្ធផល៖

```text
Apple
Banana
Orange
```

ភាពខុសគ្នា៖
- ប្រើ `for` ធម្មតា នៅពេលត្រូវការ Index ឬចង់គ្រប់គ្រងទីតាំង។
- ប្រើ `for-each` នៅពេលគ្រាន់តែចង់អានធាតុទាំងអស់។

## 9. គណនាតម្លៃក្នុង Array

ឧទាហរណ៍៖ គណនាផលបូក និងមធ្យមភាគពិន្ទុ។

```java
public class ArrayTotal {
    public static void main(String[] args) {
        int[] scores = {80, 90, 75, 85, 95};
        int total = 0;

        for (int score : scores) {
            total += score;
        }

        double average = (double) total / scores.length;

        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
    }
}
```

លទ្ធផល៖

```text
Total: 425
Average: 85.0
```

យើងប្រើ `(double)` ដើម្បីបម្លែង `total` ទៅជា double មុនចែក ដើម្បីរក្សាលទ្ធផលទសភាគ។

## 10. Two-Dimensional Array (2D Array)

**2D Array** គឺជា Array ដែលមានជួរដេក (Rows) និងជួរឈរ (Columns)។ វាអាចប្រើសម្រាប់តារាងពិន្ទុ ឬទិន្នន័យជាទម្រង់ Grid។

ឧទាហរណ៍៖

```java
public class TwoDArrayExample {
    public static void main(String[] args) {
        int[][] scores = {
            {80, 90, 85},
            {70, 75, 88}
        };

        System.out.println(scores[0][0]); // 80
        System.out.println(scores[1][2]); // 88
    }
}
```

- `scores[0][0]` មានន័យថា Row 0, Column 0។
- `scores[1][2]` មានន័យថា Row 1, Column 2។

ប្រើ Nested Loop ដើម្បីបង្ហាញតម្លៃទាំងអស់៖

```java
for (int row = 0; row < scores.length; row++) {
    for (int column = 0; column < scores[row].length; column++) {
        System.out.print(scores[row][column] + " ");
    }
    System.out.println();
}
```

លទ្ធផល៖

```text
80 90 85
70 75 88
```

## 11. កំហុសដែលជួបញឹកញាប់

### ArrayIndexOutOfBoundsException

កំហុសនេះកើតឡើងនៅពេលចូលប្រើ Index ដែលមិនមានក្នុង Array។

```java
int[] numbers = {10, 20, 30};

System.out.println(numbers[3]); // Error
```

Array នេះមាន Index ត្រឹម 0, 1 និង 2 ប៉ុណ្ណោះ។ ដូច្នេះ `numbers[3]` មិនមានទេ។

ត្រូវចងចាំ៖ បើ Array មាន `length = 3` នោះ Index ចុងក្រោយគឺ `2` ឬ `length - 1`។

## 12. របៀប Compile និង Run

បើឯកសាររបស់អ្នកមានឈ្មោះ `ArraysExample.java`៖

```powershell
javac ArraysExample.java
java ArraysExample
```

## 13. ពាក្យសំខាន់ៗ

| English | អត្ថន័យជាខ្មែរ |
|---|---|
| Array | អថេរសម្រាប់រក្សាទុកតម្លៃច្រើន |
| Element | ធាតុមួយក្នុង Array |
| Index | លេខទីតាំងរបស់ធាតុ |
| Length | ចំនួនធាតុសរុប |
| Row | ជួរដេក |
| Column | ជួរឈរ |
| For-Each | Loop សម្រាប់អានធាតុទាំងអស់ |

## សង្ខេប

- Array រក្សាទុកតម្លៃច្រើនដែលមាន Data Type ដូចគ្នា។
- Index ចាប់ផ្តើមពី 0។
- ប្រើ `arrayName[index]` ដើម្បីអាន ឬកែប្រែតម្លៃ។
- ប្រើ `arrayName.length` ដើម្បីដឹងចំនួនធាតុ។
- ប្រើ `for` ឬ `for-each` ដើម្បីដំណើរការធាតុទាំងអស់។
- 2D Array មាន Rows និង Columns។
- កុំប្រើ Index លើសពីទំហំ Array។

សូមធ្វើលំហាត់នៅក្នុង [exercise.md](exercise.md) មុនពេលមើលចម្លើយ។
