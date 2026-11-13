# មេរៀនទី ១៦៖ Modern Java — Enum, Record, Sealed Type និង Pattern Matching

## Enum
ប្រើ enum សម្រាប់ជម្រើសមានកំណត់ជាមុន ដូចជា status៖ NEW, PAID, CANCELLED។ វាល្អជាង String ចៃដន្យ ព្រោះ compiler អាចជួយរកកំហុស។

## Record
Record ជា data carrier ដែលបង្កើត constructor, accessor, equals/hashCode និង toString សម្រាប់ components របស់វា។

~~~java
record Point(int x, int y) {}

public class Main {
    public static void main(String[] args) {
        Point point = new Point(3, 4);
        System.out.println(point.x());
    }
}
~~~

Record components ជា final references ប៉ុន្តែ object ដែល field យោងទៅមិនចាំបាច់ immutable ទាំងស្រុងទេ។ ត្រូវប្រុងប្រយ័ត្នជាមួយ mutable components។

## Sealed Classes
Sealed type កំណត់ថា class/interface ណាអាច extend ឬ implement វា។ វាជួយបង្ហាញចំនួន subtype ដែលអនុញ្ញាតនៅពេលរចនា domain model។

## Pattern Matching
Java ថ្មីបន្ថែម pattern matching ក្នុង instanceof និង switch ជាបន្តបន្ទាប់តាម release។ ពិនិត្យ JDK/version ដែល project គាំទ្រ មុនប្រើ syntax ថ្មី។

## លំហាត់
1. បង្កើត enum OrderStatus។
2. បង្កើត record Product(String name, int price) និង validate price មិនអវិជ្ជមានក្នុង compact constructor។
3. ពន្យល់ភាពខុសគ្នារវាង immutable object និង final reference។
