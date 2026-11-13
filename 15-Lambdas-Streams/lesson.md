# មេរៀនទី ១៥៖ Lambdas, Functional Interfaces និង Streams

## គោលបំណង
ចប់មេរៀន អ្នកអាចប្រើ lambda និង method reference, អាន stream pipeline, បែងចែក intermediate/terminal operations និងជៀសការប្រើ side effect ឬ parallel stream ដោយមិនចាំបាច់។

## ១. Functional Interface
Functional interface មាន abstract method មួយ។ ឧទាហរណ៍ Runnable មាន run() និង Predicate<T> មាន test(T)។ Annotation @FunctionalInterface ជាជម្រើស ប៉ុន្តែជួយឱ្យ compiler ពិនិត្យថា interface នៅតែមាន abstract method តែមួយ។

~~~java
java.util.function.Predicate<Integer> isEven =
    number -> number % 2 == 0;
System.out.println(isEven.test(8));
~~~

Lambda ទទួល parameters នៅខាងឆ្វេង arrow ហើយ expression/block នៅខាងស្តាំ។ Type អាចត្រូវបាន infer ពី target interface។

## ២. Method reference
បើ lambda គ្រាន់តែហៅ method ដែលមានស្រាប់ អាចប្រើ method reference៖

~~~java
List<String> names = List.of("Sophea", "Dara");
names.forEach(System.out::println);
~~~

Method reference មានទម្រង់ static method, instance method របស់ object ដែលមានស្រាប់ ឬ constructor reference។ ជ្រើសវាពេលអានងាយ; កុំបង្ខំខ្លីជាងដែលធ្វើឱ្យ logic លាក់។

## ៣. Stream pipeline
Stream មិនមែនជាកន្លែងផ្ទុកទិន្នន័យទេ។ វាជាផ្លូវដំណើរការទិន្នន័យពី source មួយ។ Intermediate operations ដូចជា filter/map/sorted ត្រូវបានភ្ជាប់; terminal operation ដូចជា toList/forEach/count/reduce ជាអ្នកបញ្ចប់ pipeline និងបង្កឱ្យវាដំណើរការ។

~~~java
List<Integer> result = List.of(3, 8, 5, 12, 4).stream()
    .filter(number -> number % 2 == 0)
    .map(number -> number * number)
    .sorted()
    .toList();

System.out.println(result);
~~~

លទ្ធផលគឺ [16, 64, 144]។ toList() មាននៅ Java 16+; Java ជំនាន់ចាស់អាចប្រើ collect(Collectors.toList())។

## ៤. map, filter, flatMap និង reduce
map បម្លែង element មួយទៅមួយ; filter ជ្រើស element; flatMap បម្លែង element មួយទៅ stream ច្រើន រួចបញ្ចូល; reduce សង្ខ summary ទៅតម្លៃមួយ។ ប្រើ collect ដើម្បីបង្កើត collection/result structure។ ប្រសិនបើមានវិធី loop ច្បាស់ជាង សូមប្រើ loop—មិនចាំបាច់បម្លែងគ្រប់កូដទៅ stream ទេ។

## ៥. Laziness និង stream ម្តងតែមួយ
Intermediate operations lazy; បើគ្មាន terminal operation នោះ source មិនទាន់ដំណើរការ។ Stream ត្រូវប្រើម្តងតែប៉ុណ្ណោះ។ កុំរក្សា stream object ទុកហើយប្រើម្ដងទៀតក្រោយ terminal operation។

## ៦. Side effects និង parallel streams
កុំកែ mutable list ខាងក្រៅក្នុង map/forEach ដែលមាន parallel execution។ Side effects ធ្វើឱ្យ order និង thread safety ពិបាកយល់។ parallelStream មិនធានាលឿនជាង; overhead, workload, ordering និង shared resource អាចធ្វើឱ្យយឺតជាង។ វាស់ជាមួយ workload តំណាងមុនប្រើ។

## ៧. លំហាត់
ធ្វើ [exercise.md](exercise.md)។ កត់ output ដែលរំពឹងមុនរត់ code។
