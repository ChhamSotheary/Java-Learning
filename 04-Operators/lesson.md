# មេរៀនទី ៤៖ Operators ក្នុង Java

## 1. តើ Operator គឺជាអ្វី?

**Operator** គឺជានិមិត្តសញ្ញាដែលប្រើសម្រាប់ធ្វើប្រតិបត្តិការលើតម្លៃ ឬ variables។ ឧទាហរណ៍ `+` ប្រើសម្រាប់បូកលេខ និង `>` ប្រើសម្រាប់ប្រៀបធៀបលេខ។

```java
int a = 10;
int b = 3;
int result = a + b;

System.out.println(result); // 13
```

នៅទីនេះ `+` ជា operator ហើយ `a` និង `b` ជា operands (តម្លៃដែល operator ធ្វើប្រតិបត្តិការ)។

## 2. Arithmetic Operators (គណិតវិទ្យា)

| Operator | អត្ថន័យ | ឧទាហរណ៍ | លទ្ធផល |
|---|---|---|---|
| `+` | បូក | `10 + 3` | 13 |
| `-` | ដក | `10 - 3` | 7 |
| `*` | គុណ | `10 * 3` | 30 |
| `/` | ចែក | `10 / 3` | 3 |
| `%` | សំណល់ពីការចែក | `10 % 3` | 1 |

**ចំណាំអំពីការចែក៖** នៅពេលចែក `int` ជាមួយ `int` លទ្ធផលជាចំនួនគត់ ដោយកាត់ផ្នែកទសភាគចោល។

```java
System.out.println(10 / 3);        // 3
System.out.println(10.0 / 3);      // 3.3333333333333335
```

Operator `%` មានប្រយោជន៍ក្នុងការពិនិត្យលេខគូ និងលេខសេស៖

```java
int number = 8;
System.out.println(number % 2); // 0 មានន័យថាជាលេខគូ
```

## 3. Assignment Operators (ដាក់តម្លៃ)

Assignment operator ប្រើសម្រាប់ដាក់ ឬធ្វើបច្ចុប្បន្នភាពតម្លៃក្នុង variable។

| Operator | ស្មើនឹង | ឧទាហរណ៍ |
|---|---|---|
| `=` | ដាក់តម្លៃ | `x = 5` |
| `+=` | `x = x + 3` | `x += 3` |
| `-=` | `x = x - 3` | `x -= 3` |
| `*=` | `x = x * 3` | `x *= 3` |
| `/=` | `x = x / 3` | `x /= 3` |
| `%=` | `x = x % 3` | `x %= 3` |

ឧទាហរណ៍៖

```java
int score = 10;
score += 5;
System.out.println(score); // 15
```

## 4. Comparison Operators (ប្រៀបធៀប)

Comparison operators ប្រៀបធៀបតម្លៃពីរ ហើយផ្តល់លទ្ធផលជា `boolean` គឺ `true` ឬ `false`។

| Operator | អត្ថន័យ |
|---|---|
| `==` | ស្មើគ្នា |
| `!=` | មិនស្មើគ្នា |
| `>` | ធំជាង |
| `<` | តូចជាង |
| `>=` | ធំជាង ឬស្មើ |
| `<=` | តូចជាង ឬស្មើ |

ឧទាហរណ៍៖

```java
int age = 20;
System.out.println(age >= 18); // true
System.out.println(age == 15); // false
```

**សូមចងចាំ៖** `=` គឺដាក់តម្លៃ។ `==` គឺពិនិត្យថាតម្លៃស្មើគ្នាឬអត់។

## 5. Logical Operators (តក្កវិជ្ជា)

Logical operators ប្រើជាមួយលក្ខខណ្ឌ boolean។

| Operator | អត្ថន័យ | ឧទាហរណ៍ |
|---|---|---|
| `&&` | AND — ទាំងពីរត្រូវ true | `age >= 18 && hasID` |
| `||` | OR — យ៉ាងហោចណាស់មួយ true | `isWeekend || isHoliday` |
| `!` | NOT — បញ្ច្រាស true/false | `!isRaining` |

ឧទាហរណ៍៖

```java
int age = 20;
boolean hasID = true;

System.out.println(age >= 18 && hasID); // true
System.out.println(age < 18 || hasID);  // true
System.out.println(!hasID);             // false
```

- `&&` ត្រូវការ condition ទាំងពីរ true។
- `||` ត្រូវការតែ condition មួយ true ក៏គ្រប់គ្រាន់។
- `!` បម្លែង true ទៅ false និង false ទៅ true។

## 6. Increment និង Decrement

- `++` បន្ថែម 1។
- `--` ដក 1។

```java
int count = 5;
count++;
System.out.println(count); // 6

count--;
System.out.println(count); // 5
```

មានពីរទម្រង់៖

- `++count` (prefix) បន្ថែមមុនពេលយកតម្លៃទៅប្រើ។
- `count++` (postfix) យកតម្លៃចាស់ទៅប្រើសិន រួចទើបបន្ថែម។

```java
int x = 5;
int a = ++x; // x ក្លាយជា 6 រួច a ទទួល 6

int y = 5;
int b = y++; // b ទទួល 5 រួច y ក្លាយជា 6
```

## 7. Operator Precedence (លំដាប់ប្រតិបត្តិការ)

Java គណនាតាមលំដាប់អាទិភាព។ ឧទាហរណ៍ គុណ និងចែកមានអាទិភាពខ្ពស់ជាងបូក និងដក។

```java
int result = 2 + 3 * 4;
System.out.println(result); // 14
```

បើប្រើ parentheses `()` វានឹងគណនាផ្នែកក្នុងវង់ក្រចកមុន៖

```java
int result = (2 + 3) * 4;
System.out.println(result); // 20
```

សម្រាប់អ្នកចាប់ផ្តើម សូមប្រើ parentheses នៅពេល expression ស្មុគស្មាញ ដើម្បីឱ្យកូដងាយអាន។

## 8. ឧទាហរណ៍ពេញលេញ

សូមបើក `OperatorsExample.java` ហើយសាកល្បង compile និង run៖

```powershell
javac OperatorsExample.java
java OperatorsExample
```

## 9. សង្ខេប

- Arithmetic: គណនាបូក ដក គុណ ចែក និងសំណល់។
- Assignment: ដាក់ ឬធ្វើបច្ចុប្បន្នភាពតម្លៃ។
- Comparison: ប្រៀបធៀប ហើយទទួលបាន true/false។
- Logical: ភ្ជាប់ ឬបញ្ច្រាសលក្ខខណ្ឌ។
- Increment/Decrement: បន្ថែម ឬដក 1។
- Parentheses: កំណត់លំដាប់គណនា។

## 10. ពាក្យបច្ចេកទេស

| English | អត្ថន័យ |
|---|---|
| Operator | ប្រមាណវិធី |
| Operand | តម្លៃដែល operator ធ្វើប្រតិបត្តិការ |
| Arithmetic | គណិតវិទ្យា |
| Comparison | ការប្រៀបធៀប |
| Logical | តក្កវិជ្ជា |
| Assignment | ការដាក់តម្លៃ |
| Precedence | លំដាប់អាទិភាព |
| Remainder | សំណល់ពីការចែក |

សូមធ្វើលំហាត់ក្នុង `exercise.md` មុនមើល `Answer.java`។
