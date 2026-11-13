# មេរៀនទី ១៦៖ Modern Java — Enum, Record, Sealed Type និង Pattern Matching

ឧទាហរណ៍នៅទីនេះប្រើ syntax តាម JDK version។ Record និង sealed classes ជា feature មូលដ្ឋានក្នុង Java 17; pattern matching ក្នុង switch ជា feature final ក្នុង Java 21។ បញ្ជាក់ project source/target version មុនប្រើ។

## ១. Enum សម្រាប់ជម្រើសមានកំណត់

~~~java
enum OrderStatus {
    NEW, PAID, SHIPPED, CANCELLED
}
~~~

Enum មាន instances ថេរដែលបានកំណត់។ វាអាចមាន fields, constructor និង methods ផងដែរ។ ប្រើ enum ជំនួស String ដើម្បីទប់ typo និងឱ្យ switch ដឹងជម្រើសដែលគ្រប់គ្រងបាន។

## ២. Record សម្រាប់ data carrier

~~~java
record Product(String name, int priceCents) {
    Product {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name ត្រូវមានតម្លៃ");
        }
        if (priceCents < 0) {
            throw new IllegalArgumentException("price មិនអាចអវិជ្ជមាន");
        }
    }
}
~~~

Record ផ្តល់ constructor, accessor methods, equals/hashCode និង toString តាម components។ Compact constructor អាច validate input។ Record មិនមែនជា immutable magic សម្រាប់ object graph ទាំងមូលទេ: reference field មិនអាចប្ដូរទៅ object ផ្សេង ប៉ុន្តែ mutable List ដែលវាយោងនៅតែអាចកែបាន។ ប្រើ List.copyOf ក្នុង constructor បើចង់ការពារ collection ពីការកែតាមក្រៅ។

## ៣. Sealed class/interface
Sealed types បញ្ជាក់ subclasses ដែលអនុញ្ញាតតាម permits។ Subclass ត្រូវបន្ត sealed, non-sealed ឬ final។ វាសមស្របសម្រាប់ domain model ដែលមានករណីជាក់លាក់ ដូចជា PaymentResult = Success/Declined/Unavailable។

## ៤. Pattern matching
Pattern matching សម្រាប់ instanceof បញ្ចូល type check និង cast៖

~~~java
if (value instanceof String text) {
    System.out.println(text.length());
}
~~~

ក្នុង Java 21 switch អាច pattern-match sealed hierarchy ហើយ compiler អាចពិនិត្យ exhaustiveness។ Pattern matching ជួយកាត់ cast និងធ្វើ branch ឱ្យមើលងាយ ប៉ុន្តែត្រូវគោរព null behavior និង JDK release។

## ៥. កុំប្រើ feature ដោយគ្មានហេតុផល
Record មិនសមជំនួស entity ដែលមាន lifecycle និង identity។ Enum មិនគួររក្សាទុក user-defined dynamic list។ Sealed hierarchy មិនសមបើ plugin ខាងក្រៅត្រូវបន្ថែម subtype។ ជ្រើសតាម domain និង compatibility។

## ៦. លំហាត់
ធ្វើ [exercise.md](exercise.md) និងបញ្ជាក់ version ត្រូវការរបស់កូដនីមួយៗ។
