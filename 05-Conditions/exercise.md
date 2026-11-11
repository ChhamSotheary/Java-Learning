# លំហាត់មេរៀនទី ៥៖ Conditions

សូមសាកល្បងសរសេរកូដ និងគិតពីលទ្ធផលមុនពេល run។

## លំហាត់ទី ១៖ ពិនិត្យលេខវិជ្ជមាន ឬអវិជ្ជមាន

បង្កើត variable `int number = -5;` ហើយប្រើ `if...else if...else` ដើម្បីបង្ហាញ៖

- Positive ប្រសិនបើធំជាង 0។
- Negative ប្រសិនបើតូចជាង 0។
- Zero ប្រសិនបើស្មើ 0។

## លំហាត់ទី ២៖ ពិនិត្យលេខគូ និងលេខសេស

ប្រកាស `int number = 12;`។ ប្រើ operator `%` និង `if...else` ដើម្បីពិនិត្យថាលេខនេះជា Even ឬ Odd។

គន្លឹះ៖ លេខគូមានសំណល់ 0 ពេលចែកនឹង 2។

## លំហាត់ទី ៣៖ ពិន្ទុ និង Grade

ប្រកាស `int score = 78;` ហើយបង្កើតលក្ខខណ្ឌ៖

- 90 ដល់ 100: Grade A
- 80 ដល់ 89: Grade B
- 70 ដល់ 79: Grade C
- 60 ដល់ 69: Grade D
- 0 ដល់ 59: Grade F
- ក្រៅពី 0 ដល់ 100: Invalid score

សូមប្រើ `if...else if...else` ហើយរៀប condition ពីពិន្ទុខ្ពស់ទៅទាប។

## លំហាត់ទី ៤៖ switch និងថ្ងៃក្នុងសប្តាហ៍

ប្រកាស `int day = 5;`។ ប្រើ `switch` ដើម្បីបង្ហាញឈ្មោះថ្ងៃ៖

1 = Monday, 2 = Tuesday, 3 = Wednesday, 4 = Thursday, 5 = Friday, 6 = Saturday, 7 = Sunday។

ប្រើ `default` សម្រាប់លេខមិនត្រឹមត្រូវ។

## លំហាត់ទី ៥៖ ពិនិត្យសិទ្ធិចូល

ប្រកាស៖

```java
int age = 19;
boolean hasTicket = true;
```

ប្រើ logical operator `&&` ដើម្បីអនុញ្ញាតឱ្យចូល លុះត្រាតែអាយុចាប់ពី 18 ឆ្នាំឡើងទៅ និងមានសំបុត្រ។

## លំហាត់ទី ៦៖ Ternary Operator

ប្រកាស `int temperature = 35;`។ ប្រើ ternary operator ដើម្បីកំណត់៖

- "Hot" ប្រសិនបើ temperature >= 30។
- "Cool" ប្រសិនបើ temperature < 30។

## លំហាត់បន្ថែម

បង្កើតកម្មវិធីគណនាតម្លៃសំបុត្រ៖

- អាយុតិចជាង 5 ឆ្នាំ: Free
- អាយុពី 5 ដល់ 17 ឆ្នាំ: Child ticket
- អាយុ 18 ឆ្នាំឡើងទៅ: Adult ticket

បើអាយុតិចជាង 0 សូមបង្ហាញ Invalid age។
