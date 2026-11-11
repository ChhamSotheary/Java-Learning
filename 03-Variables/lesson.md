# មេរៀនទី ៣៖ Variables and Data Types ក្នុង Java

## 1. តើ Variable គឺជាអ្វី?

**Variable (អថេរ)** គឺជាកន្លែងមួយនៅក្នុង memory ដែលយើងប្រើសម្រាប់ផ្ទុកទិន្នន័យ។ យើងអាចយកតម្លៃដែលផ្ទុកក្នុង variable មកប្រើនៅពេលក្រោយ ហើយអាចផ្លាស់ប្តូរតម្លៃវាបាន។

ឧទាហរណ៍៖

```java
int age = 20;
System.out.println(age);
```

- `int` ជា data type បញ្ជាក់ថាតម្លៃនេះជាចំនួនគត់។
- `age` ជាឈ្មោះ variable។
- `=` ជា assignment operator សម្រាប់ដាក់តម្លៃ។
- `20` ជាតម្លៃដែលយើងផ្ទុក។
- `; ` (semicolon) បញ្ចប់ statement ក្នុង Java។ ក្នុងកូដត្រូវសរសេរ `;` ដោយគ្មានចន្លោះ។

## 2. របៀបប្រកាស Variable

ទម្រង់ទូទៅ៖

```java
dataType variableName = value;
```

ឧទាហរណ៍៖

```java
int score = 90;
double price = 12.50;
String studentName = "Dara";
char grade = 'A';
boolean isPassed = true;
```

### Declaration និង Initialization

**Declaration** គឺការប្រកាស variable ដោយមិនទាន់ដាក់តម្លៃ៖

```java
int age;
```

**Initialization** គឺការដាក់តម្លៃឱ្យ variable៖

```java
age = 20;
```

យើងក៏អាចធ្វើទាំងពីរនៅក្នុងបន្ទាត់តែមួយបាន៖

```java
int age = 20;
```

ចំណាំ៖ Local variable ត្រូវតែមានតម្លៃមុនពេលយើងយកវាទៅប្រើ។

## 3. Data Types ដែលប្រើញឹកញាប់

Data type កំណត់ថា variable អាចផ្ទុកទិន្នន័យប្រភេទណា។

| Data type | ប្រើសម្រាប់ | ឧទាហរណ៍ |
|---|---|---|
| `int` | ចំនួនគត់ | `int age = 20;` |
| `double` | ចំនួនមានក្បៀស | `double price = 9.99;` |
| `float` | ចំនួនមានក្បៀស | `float height = 1.75f;` |
| `long` | ចំនួនគត់ធំ | `long population = 8000000L;` |
| `char` | តួអក្សរតែមួយ | `char grade = 'A';` |
| `boolean` | true ឬ false | `boolean isStudent = true;` |
| `String` | អត្ថបទ | `String name = "Sokha";` |

ចំណាំសំខាន់៖
- `String` ត្រូវសរសេរអក្សរ S ជាអក្សរធំ ហើយត្រូវប្រើ double quotes `" "`។
- `char` ប្រើ single quotes `' '` ហើយផ្ទុកតួអក្សរតែមួយ។
- `float` ត្រូវការអក្សរ `f` នៅខាងក្រោយតម្លៃ ដូចជា `1.75f`។
- `long` អាចប្រើ `L` នៅខាងក្រោយ ដូចជា `8000000L`។
- `boolean` មានតែ `true` ឬ `false` ប៉ុណ្ណោះ។

## 4. Primitive និង Reference Types

Java មាន data types សំខាន់ពីរប្រភេទ៖

### Primitive types

Primitive types ផ្ទុកតម្លៃជាមូលដ្ឋាន។ មាន 8 ប្រភេទ៖

- ចំនួនគត់៖ `byte`, `short`, `int`, `long`
- ចំនួនមានក្បៀស៖ `float`, `double`
- តួអក្សរ៖ `char`
- តម្លៃពិត/មិនពិត៖ `boolean`

### Reference types

Reference types ប្រើសម្រាប់យោងទៅកាន់ object។ ឧទាហរណ៍៖ `String`, arrays និង class ដែលយើងបង្កើតដោយខ្លួនឯង។

```java
String city = "Phnom Penh";
int[] numbers = {10, 20, 30};
```

សម្រាប់អ្នកចាប់ផ្តើម សូមចងចាំថា `String` ប្រើសម្រាប់អត្ថបទ ចំណែក `int` និង `double` ប្រើសម្រាប់លេខ។

## 5. ច្បាប់ដាក់ឈ្មោះ Variable

ឈ្មោះ variable ត្រូវគោរពច្បាប់ទាំងនេះ៖

1. អាចប្រើអក្សរ លេខ underscore `_` និង dollar sign `$`។
2. មិនអាចចាប់ផ្តើមដោយលេខបានទេ។
3. មិនអាចប្រើ Java reserved keywords ដូចជា `class`, `int`, `public` ជាឈ្មោះ variable។
4. Java ប្រកាន់អក្សរធំ និងអក្សរតូចខុសគ្នា។ `age` និង `Age` ជាឈ្មោះពីរផ្សេងគ្នា។
5. គួរប្រើឈ្មោះដែលមានន័យ និងសរសេរតាម camelCase។

ឧទាហរណ៍ឈ្មោះត្រឹមត្រូវ៖

```java
int studentAge = 18;
String firstName = "Dara";
double totalPrice = 25.75;
```

ឧទាហរណ៍ឈ្មោះមិនត្រឹមត្រូវ៖

```java
// int 2age = 20;       // ចាប់ផ្តើមដោយលេខ
// int class = 10;      // class ជា keyword
// int student age = 18; // មានចន្លោះ
```

## 6. Constant ដោយប្រើ final

បើមិនចង់ឱ្យតម្លៃ variable ផ្លាស់ប្តូរ អ្នកអាចប្រើ keyword `final`។

```java
final double PI = 3.14159;
```

បន្ទាប់ពីកំណត់តម្លៃឱ្យ `PI` រួច អ្នកមិនអាច assign តម្លៃថ្មីឱ្យវាបានទេ។

តាមទម្លាប់ ឈ្មោះ constant ច្រើនប្រើអក្សរធំ និង underscore៖ `MAX_SCORE`, `TAX_RATE`។

## 7. ឧទាហរណ៍ពេញលេញ

បើក file `VariablesExample.java` នៅក្នុង folder នេះ។ កូដបង្ហាញពី data types និងការបង្ហាញតម្លៃតាម `System.out.println()`។

ដើម្បី compile និង run តាម Terminal នៅក្នុង folder ដែលមាន file៖

```powershell
javac VariablesExample.java
java VariablesExample
```

## 8. កំហុសដែលអ្នកចាប់ផ្តើមជួបញឹកញាប់

- ដាក់អត្ថបទក្នុង `int` ដូចជា `int name = "Dara";` — type មិនត្រូវគ្នា។
- ប្រើ double quotes សម្រាប់ `char` ឬ single quotes សម្រាប់ `String`។
- ភ្លេច `f` នៅក្រោយតម្លៃ `float`។
- ប្រើ variable មុនពេលដាក់តម្លៃឱ្យវា។
- ប្រកាស `final` ហើយព្យាយាមប្តូរតម្លៃវាម្តងទៀត។

## 9. សង្ខេប

- Variable គឺជាកន្លែងផ្ទុកទិន្នន័យ។
- Data type កំណត់ប្រភេទតម្លៃដែល variable អាចផ្ទុក។
- `int` សម្រាប់ចំនួនគត់, `double` សម្រាប់ចំនួនមានក្បៀស, `String` សម្រាប់អត្ថបទ។
- `char` សម្រាប់តួអក្សរមួយ និង `boolean` សម្រាប់ true/false។
- `final` ប្រើសម្រាប់តម្លៃដែលមិនចង់ឱ្យផ្លាស់ប្តូរ។

## 10. ពាក្យបច្ចេកទេស

| English | អត្ថន័យ |
|---|---|
| Variable | អថេរ |
| Data type | ប្រភេទទិន្នន័យ |
| Declaration | ការប្រកាស |
| Initialization | ការកំណត់តម្លៃដំបូង |
| Assignment | ការដាក់តម្លៃ |
| Constant | តម្លៃថេរ |
| Primitive type | ប្រភេទទិន្នន័យមូលដ្ឋាន |
| Reference type | ប្រភេទយោងទៅ object |

បន្ទាប់ពីអានមេរៀននេះ សូមសរសេរកូដដោយខ្លួនឯង មុនពេលមើលចម្លើយក្នុង `Answer.java`។
