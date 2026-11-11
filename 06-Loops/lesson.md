# មេរៀនទី ៦៖ Loops ក្នុង Java

## គោលបំណងមេរៀន

បន្ទាប់ពីរៀនមេរៀននេះ អ្នកនឹងអាច៖

- ពន្យល់ថា Loop គឺជាអ្វី និងហេតុអ្វីយើងប្រើវា។
- ប្រើ `for`, `while` និង `do...while`។
- ប្រើ `break` ដើម្បីបញ្ឈប់ Loop។
- ប្រើ `continue` ដើម្បីរំលងការធ្វើម្តងណាមួយ។
- យល់ពី Nested Loop និងការប្រុងប្រយ័ត្នចំពោះ Infinite Loop។

---

## 1. តើ Loop គឺជាអ្វី?

**Loop** គឺជារបៀបបញ្ជាឱ្យកម្មវិធីដំណើរការកូដដដែលៗច្រើនដង ដោយមិនចាំបាច់សរសេរកូដដដែលៗម្តងហើយម្តងទៀត។

ឧទាហរណ៍ បើអ្នកចង់បង្ហាញលេខពី 1 ដល់ 5 អ្នកអាចសរសេរ `System.out.println()` ចំនួន 5 ដង។ ប៉ុន្តែការប្រើ Loop ធ្វើឱ្យកូដខ្លី និងងាយកែប្រែជាង។

Java មាន Loop សំខាន់ៗចំនួន 3៖

1. `for`
2. `while`
3. `do...while`

## 2. For Loop

ប្រើ `for` នៅពេលអ្នកដឹងចំនួនដងដែលចង់ឱ្យកូដដំណើរការ។

### Syntax

```java
for (initialization; condition; update) {
    // code to repeat
}
```

- **Initialization**៖ កំណត់តម្លៃចាប់ផ្តើម។
- **Condition**៖ ពិនិត្យថាតើត្រូវបន្ត Loop ឬអត់។
- **Update**៖ កែប្រែតម្លៃរាប់ បន្ទាប់ពីដំណើរការកូដមួយជុំ។

### ឧទាហរណ៍

```java
public class ForExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number: " + i);
        }
    }
}
```

លទ្ធផល៖

```text
Number: 1
Number: 2
Number: 3
Number: 4
Number: 5
```

ការដំណើរការ៖

1. កំណត់ `i = 1`។
2. ពិនិត្យ `i <= 5`។
3. បើពិត បង្ហាញលេខ `i`។
4. បន្ថែម `i++` (មានន័យថា `i = i + 1`)។
5. ត្រឡប់ទៅពិនិត្យលក្ខខណ្ឌម្តងទៀត។
6. ពេល `i` ក្លាយជា 6 លក្ខខណ្ឌមិនពិត ហើយ Loop បញ្ចប់។

## 3. While Loop

ប្រើ `while` នៅពេលអ្នកចង់ឱ្យកូដដំណើរការដរាបណាលក្ខខណ្ឌនៅតែពិត។ វាពិនិត្យលក្ខខណ្ឌមុនពេលដំណើរការកូដ។

### Syntax

```java
while (condition) {
    // code to repeat
}
```

### ឧទាហរណ៍

```java
public class WhileExample {
    public static void main(String[] args) {
        int count = 1;

        while (count <= 5) {
            System.out.println("Count: " + count);
            count++;
        }
    }
}
```

លទ្ធផល៖

```text
Count: 1
Count: 2
Count: 3
Count: 4
Count: 5
```

ចំណាំ៖ ត្រូវកែប្រែអថេរដែលប្រើក្នុងលក្ខខណ្ឌ ដើម្បីឱ្យ Loop អាចបញ្ចប់បាន។ បើមិនដូច្នោះទេ វាអាចក្លាយជា **Infinite Loop**។

## 4. Do-While Loop

`do...while` ស្រដៀងនឹង `while` ប៉ុន្តែវាដំណើរការកូដក្នុង `do` ម្តងជាមុនសិន រួចទើបពិនិត្យលក្ខខណ្ឌ។ ដូច្នេះវាដំណើរការយ៉ាងតិចមួយដងជានិច្ច។

### Syntax

```java
do {
    // code to repeat
} while (condition);
```

សូមចំណាំថា ត្រូវមានសញ្ញា semicolon `;` នៅចុងបន្ទាត់ `while (condition);`។

### ឧទាហរណ៍

```java
public class DoWhileExample {
    public static void main(String[] args) {
        int number = 1;

        do {
            System.out.println("Number: " + number);
            number++;
        } while (number <= 5);
    }
}
```

### ភាពខុសគ្នារវាង While និង Do-While

```java
int value = 10;

while (value < 5) {
    System.out.println("While");
}

do {
    System.out.println("Do-While");
} while (value < 5);
```

លទ្ធផល៖

```text
Do-While
```

មូលហេតុ៖ `while` ពិនិត្យលក្ខខណ្ឌមុន ដូច្នេះមិនដំណើរការទេ។ ចំណែក `do...while` ដំណើរការម្តងមុនពេលពិនិត្យ។

## 5. Break Statement

`break` ប្រើសម្រាប់បញ្ឈប់ Loop ភ្លាមៗ ទោះបីលក្ខខណ្ឌនៅតែពិតក៏ដោយ។

```java
public class BreakExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;
            }

            System.out.println(i);
        }
    }
}
```

លទ្ធផល៖

```text
1
2
3
4
```

នៅពេល `i == 5` កម្មវិធីជួប `break` ហើយចាកចេញពី Loop។

## 6. Continue Statement

`continue` ប្រើសម្រាប់រំលងការធ្វើការនៅជុំបច្ចុប្បន្ន ហើយបន្តទៅជុំបន្ទាប់នៃ Loop។

```java
public class ContinueExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;
            }

            System.out.println(i);
        }
    }
}
```

លទ្ធផល៖

```text
1
2
4
5
```

លេខ 3 មិនត្រូវបានបង្ហាញទេ ព្រោះ `continue` រំលងការបង្ហាញនៅជុំនោះ។

**ចងចាំ៖**
- `break` = ចាកចេញពី Loop ទាំងស្រុង។
- `continue` = រំលងជុំបច្ចុប្បន្ន ហើយបន្តជុំបន្ទាប់។

## 7. Nested Loop

**Nested Loop** មានន័យថា Loop មួយស្ថិតនៅខាងក្នុង Loop មួយទៀត។ វាមានប្រយោជន៍សម្រាប់ការងារដែលមានជួរដេក និងជួរឈរ ឬការបង្ហាញតារាង។

ឧទាហរណ៍៖

```java
public class NestedLoopExample {
    public static void main(String[] args) {
        for (int row = 1; row <= 3; row++) {
            for (int column = 1; column <= 4; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
```

លទ្ធផល៖

```text
* * * *
* * * *
* * * *
```

Loop ខាងក្រៅគ្រប់គ្រងចំនួនជួរដេក (row)។ Loop ខាងក្នុងគ្រប់គ្រងចំនួនផ្កាយក្នុងមួយជួរដេក (column)។

## 8. Infinite Loop

**Infinite Loop** គឺជា Loop ដែលមិនបញ្ចប់ ព្រោះលក្ខខណ្ឌនៅតែពិតជានិច្ច ឬអថេរមិនត្រូវបានកែប្រែត្រឹមត្រូវ។

ឧទាហរណ៍នេះនឹងមិនបញ្ចប់ដោយខ្លួនឯងទេ៖

```java
int count = 1;

while (count <= 5) {
    System.out.println(count);
    // ភ្លេចសរសេរ count++
}
```

ដើម្បីជៀសវាងបញ្ហានេះ ត្រូវពិនិត្យថា៖

- លក្ខខណ្ឌអាចក្លាយជាមិនពិតបាន។
- អថេរដែលប្រើក្នុងលក្ខខណ្ឌត្រូវបានកែប្រែត្រឹមត្រូវ។
- តម្លៃចាប់ផ្តើម និងលក្ខខណ្ឌមិនមានកំហុស។

## 9. តើគួរប្រើ Loop មួយណា?

| Loop | ពេលណាគួរប្រើ |
|---|---|
| `for` | ដឹងចំនួនដងដែលត្រូវធ្វើ |
| `while` | បន្តធ្វើដរាបណាលក្ខខណ្ឌពិត |
| `do...while` | ត្រូវការឱ្យធ្វើយ៉ាងតិចមួយដងសិន |

## 10. របៀប Compile និង Run

បើក Terminal នៅក្នុង Folder ដែលមានឯកសារ `LoopsExample.java` រួចវាយ៖

```powershell
javac LoopsExample.java
java LoopsExample
```

ត្រូវប្រាកដថាឈ្មោះ `public class` និងឈ្មោះឯកសារ Java ដូចគ្នា។

## 11. ពាក្យសំខាន់ៗ

| English | អត្ថន័យជាខ្មែរ |
|---|---|
| Loop | ការធ្វើកូដដដែលៗ |
| Iteration | ការធ្វើមួយជុំ |
| Condition | លក្ខខណ្ឌ |
| Initialization | ការកំណត់តម្លៃដំបូង |
| Update | ការកែប្រែតម្លៃ |
| Break | បញ្ឈប់ Loop |
| Continue | រំលងជុំបច្ចុប្បន្ន |
| Nested Loop | Loop នៅក្នុង Loop |
| Infinite Loop | Loop ដែលមិនចេះបញ្ចប់ |

## សង្ខេប

- ប្រើ `for` នៅពេលដឹងចំនួនដង។
- ប្រើ `while` នៅពេលចង់ពិនិត្យលក្ខខណ្ឌមុនរាល់ជុំ។
- ប្រើ `do...while` នៅពេលចង់ឱ្យកូដដំណើរការយ៉ាងតិចមួយដង។
- ប្រើ `break` ដើម្បីចាកចេញពី Loop។
- ប្រើ `continue` ដើម្បីរំលងជុំបច្ចុប្បន្ន។
- ប្រើ Nested Loop សម្រាប់ Loop ច្រើនជាន់។

បន្ទាប់ពីអានមេរៀននេះ សូមធ្វើលំហាត់នៅក្នុង [exercise.md](exercise.md) ដោយព្យាយាមសរសេរកូដដោយខ្លួនឯងជាមុនសិន។
