# លំហាត់មេរៀនទី ៨៖ Methods

សូមសាកសរសេរកូដដោយខ្លួនឯងជាមុនសិន។ ចម្លើយគំរូមាននៅក្នុង [Answer.java](Answer.java)។

## លំហាត់ទី ១៖ Method ស្វាគមន៍

សរសេរ method ឈ្មោះ greet ដែលទទួល String name ហើយបង្ហាញ៖

~~~text
សួស្តី [name]!
~~~

ហៅ method នេះពី main ដោយប្រើឈ្មោះផ្ទាល់ខ្លួន។

## លំហាត់ទី ២៖ បូកលេខ

សរសេរ method ឈ្មោះ add ដែលទទួល int ពីរ ហើយ return ផលបូក។ ក្នុង main ហៅវាជាមួយ 12 និង 8 រួចបង្ហាញលទ្ធផល។

## លំហាត់ទី ៣៖ ពិនិត្យលេខគូ

សរសេរ method isEven ដែលទទួល int ហើយ return boolean។ វាគួរត្រឡប់ true បើលេខចែកដាច់នឹង 2 បើមិនដូច្នោះទេ return false។

សាកល្បងជាមួយ 7 និង 12។

## លំហាត់ទី ៤៖ គណនាមធ្យមភាគ

សរសេរ method average ដែលទទួលពិន្ទុចំនួនបីជា int ហើយ return មធ្យមភាគជា double។ ប្រើការចែកទសភាគ។ សាកល្បង 80, 90 និង 85។

## លំហាត់ទី ៥៖ Method Overloading

បង្កើត method printInfo ដែលមានពីរទម្រង់៖

- ទទួល String name ហើយបង្ហាញឈ្មោះ។
- ទទួល String name និង int age ហើយបង្ហាញឈ្មោះជាមួយអាយុ។

## លំហាត់ទី ៦៖ យល់ពី Scope និង Argument

1. សរសេរពន្យល់ថាហេតុអ្វី local variable ក្នុង method មួយមិនអាចប្រើផ្ទាល់ក្នុង main។
2. ហៅ method ដែលទទួល int ដោយផ្ញើអថេរ n; បន្ទាប់មក method ប្តូរ parameter ទៅ 99។ តើ n នៅ main ប្រែប្រួលទេ? ពន្យល់។

## Challenge៖ ស្វែងរកធាតុធំបំផុត

សរសេរ method findMax ដែលទទួល int[] ហើយ return តម្លៃធំបំផុត។ សាកល្បងជាមួយ array {4, 15, 2, 9}។

## របៀប Compile និង Run

រក្សាទុកចម្លើយក្នុង Answer.java រួចវាយ៖

~~~powershell
javac Answer.java
java Answer
~~~
