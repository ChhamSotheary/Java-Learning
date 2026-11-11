# មេរៀនទី ៥៖ Conditions ក្នុង Java

## 1. តើ Condition គឺជាអ្វី?

**Condition (លក្ខខណ្ឌ)** គឺជាការពិនិត្យថា statement មួយពិត (`true`) ឬមិនពិត (`false`)។ យើងប្រើ condition ដើម្បីឱ្យកម្មវិធីសម្រេចចិត្តថាត្រូវធ្វើអ្វី។

ឧទាហរណ៍៖

```java
int age = 20;

if (age >= 18) {
    System.out.println("You are an adult.");
}
```

ដោយសារ `age >= 18` មានតម្លៃ true ដូច្នេះកម្មវិធីបង្ហាញសារនោះ។

## 2. if Statement

`if` ប្រើសម្រាប់ដំណើរការកូដ នៅពេល condition ជា true។

ទម្រង់៖

```java
if (condition) {
    // code runs when condition is true
}
```

ឧទាហរណ៍៖

```java
int score = 85;

if (score >= 50) {
    System.out.println("Passed");
}
```

បើ score តិចជាង 50 នោះ block ក្នុង `if` មិនដំណើរការទេ។

## 3. if...else Statement

ប្រើ `else` នៅពេលចង់កំណត់អ្វីដែលត្រូវធ្វើ ប្រសិនបើ condition មិនពិត។

```java
int score = 40;

if (score >= 50) {
    System.out.println("Passed");
} else {
    System.out.println("Failed");
}
```

កម្មវិធីជ្រើសរើសដំណើរការ block មួយក្នុងចំណោមពីរ។

## 4. if...else if...else

ប្រើនៅពេលមានលក្ខខណ្ឌច្រើន៖

```java
int score = 85;

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
```

Java ពិនិត្យពីលើចុះក្រោម។ ពេលជួប condition ដំបូងដែល true វាដំណើរការ block នោះ ហើយរំលងលក្ខខណ្ឌនៅសល់។

**ចំណាំ៖** រៀបលំដាប់ពីពិន្ទុខ្ពស់ទៅទាប ដើម្បីកុំឱ្យលក្ខខណ្ឌទូលំទូលាយចាប់មុន។

## 5. Nested if (if នៅក្នុង if)

យើងអាចដាក់ `if` មួយនៅក្នុង `if` មួយទៀត នៅពេលមានការត្រួតពិនិត្យជាច្រើនជាន់។

```java
int age = 20;
boolean hasID = true;

if (age >= 18) {
    if (hasID) {
        System.out.println("You can enter.");
    } else {
        System.out.println("Please show your ID.");
    }
} else {
    System.out.println("You are too young.");
}
```

## 6. switch Statement

`switch` មានប្រយោជន៍នៅពេលចង់ប្រៀបធៀប variable មួយជាមួយតម្លៃជាក់លាក់ជាច្រើន។

```java
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
```

- `case` កំណត់តម្លៃដែលត្រូវផ្គូផ្គង។
- `break` បញ្ឈប់ switch បន្ទាប់ពី case ដែលត្រូវគ្នាដំណើរការ។
- `default` ដំណើរការនៅពេលគ្មាន case ណាមួយត្រូវគ្នា។

បើភ្លេច `break` ក្នុង traditional switch កូដអាចបន្តដំណើរការទៅ case បន្ទាប់ទៀត (fall-through)។

## 7. switch Expression (ទម្រង់ថ្មី)

Java ជំនាន់ថ្មីគាំទ្រ switch expression ដែលអាចផ្តល់តម្លៃត្រឡប់មក variable បាន។ ឧទាហរណ៍៖

```java
int day = 2;

String dayName = switch (day) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 3 -> "Wednesday";
    default -> "Unknown day";
};

System.out.println(dayName);
```

បើ JDK របស់អ្នកមិនគាំទ្រទម្រង់នេះ សូមប្រើ traditional switch នៅផ្នែកទី 6។

## 8. Ternary Operator

Ternary operator គឺជាវិធីសរសេរ if...else ខ្លីៗ នៅពេលមានតែពីរលទ្ធផល។

ទម្រង់៖

```java
condition ? valueIfTrue : valueIfFalse;
```

ឧទាហរណ៍៖

```java
int age = 20;
String result = (age >= 18) ? "Adult" : "Minor";

System.out.println(result);
```

កុំប្រើ ternary សម្រាប់ logic ស្មុគស្មាញពេក ព្រោះអាចធ្វើឱ្យកូដពិបាកអាន។

## 9. ការប្រើ Logical Operators ក្នុង Conditions

អ្នកអាចភ្ជាប់លក្ខខណ្ឌច្រើនដោយ `&&` និង `||`៖

```java
int age = 22;
boolean hasTicket = true;

if (age >= 18 && hasTicket) {
    System.out.println("You can enter.");
}

if (age < 18 || !hasTicket) {
    System.out.println("You cannot enter.");
}
```

- `&&` ត្រូវឱ្យលក្ខខណ្ឌទាំងអស់ true។
- `||` ត្រូវឱ្យមានយ៉ាងហោចណាស់មួយ true។
- `!` បញ្ច្រាសលទ្ធផល boolean។

## 10. កំហុសដែលជួបញឹកញាប់

1. ប្រើ `=` ជំនួស `==` ក្នុងការប្រៀបធៀប។
2. ភ្លេចស្លាបក្រចក `()` ក្រោយ `if`។
3. ភ្លេចស្លាបកង់ `{}` ឬដាក់វាខុសទីតាំង។
4. រៀបលំដាប់ condition ខុស ធ្វើឱ្យ condition ទូទៅចាប់មុន condition ជាក់លាក់។
5. ភ្លេច `break` ក្នុង traditional switch។
6. ប្រើ `&&` នៅកន្លែងដែលត្រូវការ `||` ឬផ្ទុយមកវិញ។

## 11. ឧទាហរណ៍ និងរបៀប Run

សូមបើក `ConditionsExample.java` ក្នុង folder នេះ រួចបើក Terminal នៅ folder ដូចគ្នា៖

```powershell
javac ConditionsExample.java
java ConditionsExample
```

សាកល្បងប្តូរ `score`, `age`, និង `day` ដើម្បីមើលថាលទ្ធផលផ្លាស់ប្តូរយ៉ាងដូចម្តេច។

## 12. សង្ខេប

- `if`: ដំណើរការកូដពេល condition true។
- `else`: ដំណើរការពេល condition false។
- `else if`: ពិនិត្យលក្ខខណ្ឌបន្ថែម។
- Nested if: ដាក់ if នៅក្នុង if។
- `switch`: ជ្រើសរើសតាមតម្លៃ case។
- Ternary: សរសេរ if...else ខ្លីៗ។

## 13. ពាក្យបច្ចេកទេស

| English | អត្ថន័យ |
|---|---|
| Condition | លក្ខខណ្ឌ |
| Decision | ការសម្រេចចិត្ត |
| Branch | ផ្លូវដំណើរការកូដ |
| Nested if | if នៅក្នុង if |
| Case | តម្លៃសម្រាប់ផ្គូផ្គង |
| Default | តម្លៃ/ផ្លូវលំនាំដើម |
| Fall-through | បន្តទៅ case បន្ទាប់ |
| Ternary operator | ប្រមាណវិធីមានបីផ្នែក |

សូមធ្វើលំហាត់ក្នុង `exercise.md` មុនមើលចម្លើយក្នុង `Answer.java`។
