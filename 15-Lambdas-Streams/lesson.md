# មេរៀនទី ១៥៖ Lambdas, Functional Interfaces និង Streams

## Functional Interface និង Lambda
Functional interface មាន abstract method មួយដែលត្រូវ implement។ Lambda ជា syntax ខ្លីសម្រាប់បញ្ជូន behavior។

~~~java
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Sophea", "Dara", "Sokha");
        names.forEach(name -> System.out.println(name));
    }
}
~~~

Method reference អាចខ្លីជាង lambda នៅពេលគ្រាន់តែហៅ method ដែលមានស្រាប់៖ names.forEach(System.out::println)។

## Stream Pipeline
Stream ដំណើរការទិន្នន័យជាបីជំហាន៖ source → intermediate operations → terminal operation។ Intermediate operations ដូចជា filter/map ជាទូទៅ lazy ហើយចាប់ផ្តើមពេល terminal operation ដំណើរការ។

~~~java
var result = names.stream()
    .filter(name -> name.length() >= 5)
    .map(String::toUpperCase)
    .sorted()
    .toList();
~~~

Stream មិនមែនជា collection ថ្មីដោយស្វ័យប្រវត្តិទេ ហើយ stream មួយមិនគួរប្រើម្តងហើយម្តងទៀត។ ជៀស side effect ក្នុង map/filter ដើម្បីឱ្យ pipeline ងាយយល់ និងអាចប្តូររបៀបដំណើរការបាន។

## Reduce និង Parallel
reduce សង្ខេបទិន្នន័យទៅតម្លៃមួយ; collect បង្កើត result structure។ parallelStream មិនធានាថាលឿនជាងទេ ហើយ side effect/order អាចបង្កបញ្ហា។ វាស់ workload មុនប្តូរទៅ parallel។

## លំហាត់
1. ពី List<Integer>, filter តែលេខគូ បម្លែងទៅការេ ហើយរក្សាទុកជា List។
2. ប្រើ stream គណនាផលបូក។
3. ពន្យល់ intermediate និង terminal operation ខុសគ្នាដូចម្តេច។
4. តើហេតុអ្វី stream side effect អាចបង្ក bug?
