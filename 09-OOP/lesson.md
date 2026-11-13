# មេរៀនទី ៩៖ Object-Oriented Programming — Class និង Object

## គោលបំណង
យល់ពី class, object, field, constructor និង instance method ហើយអាចបង្កើត object តាម model សាមញ្ញ។

## Class និង Object
Class ជាគម្រោងកំណត់ទិន្នន័យ និង behavior។ Object ជា instance ដែលបង្កើតពី class។

~~~java
class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void introduce() {
        System.out.println("ខ្ញុំឈ្មោះ " + name + ", អាយុ " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student("សុភា", 20);
        student.introduce();
    }
}
~~~

## Field និង Constructor
Field រក្សា state របស់ object។ Constructor មានឈ្មោះដូច class ហើយគ្មាន return type។ this.name សំដៅ field របស់ object បច្ចុប្បន្ន; name សំដៅ parameter។

បើមិនសរសេរ constructor ណាមួយ compiler អាចផ្តល់ default no-argument constructor។ ប៉ុន្តែបើអ្នកសរសេរ constructor មួយរួច compiler មិនបង្កើត no-argument constructor ដោយស្វ័យប្រវត្តិទេ។

## Encapsulation ជាការរចនា
នៅមេរៀនបន្ទាប់នឹងរៀនធ្វើ field private និងផ្តល់ method សម្រាប់ការគ្រប់គ្រង state។ កុំបង្ហាញ field សាធារណៈទាំងអស់ ព្រោះ object អាចទៅជាស្ថានភាពមិនត្រឹមត្រូវ។

## Object Identity
អថេរដែលកាន់ object គឺ reference ទៅ object។ ការប្រៀបធៀប reference ដោយ == ពិនិត្យថាវាសំដៅ object ដូចគ្នាឬអត់; សម្រាប់តម្លៃខ្លឹមសារ ត្រូវប្រើ equals() ដែល class កំណត់។

## លំហាត់
សូមធ្វើ [exercise.md](exercise.md) ហើយសាក run ចម្លើយពី [Answer.java](Answer.java)។
