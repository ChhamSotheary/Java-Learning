# មេរៀនទី ៩៖ Object-Oriented Programming — Class និង Object

## គោលបំណង
ចប់មេរៀន អ្នកអាចបែងចែក class/object, field/method, constructor/ordinary method, reference/value និងរៀបចំ model មួយដោយមិនបញ្ចូលការងារទាំងអស់ក្នុង main។

## ១. ហេតុអ្វីត្រូវប្រើ OOP?
កម្មវិធីមានទិន្នន័យ និងសកម្មភាពដែលទាក់ទងគ្នា។ ប្រសិនបើរក្សាទិន្នន័យសៀវភៅក្នុង variables ដាច់ៗ កូដនឹងពិបាកគ្រប់គ្រងពេលមានសៀវភៅច្រើន។ Class ប្រមូល state និង behavior ដែលពាក់ព័ន្ធគ្នាទៅជាប្រភេទមួយ។ OOP មិនមានន័យថាគ្រប់បន្ទាត់ត្រូវតែជា class ស្មុគស្មាញទេ; ប្រើវាពេលវាជួយ model បញ្ហាឱ្យច្បាស់។

## ២. Class ជាគំរូ, Object ជាតម្លៃជាក់ស្តែង

~~~java
class Book {
    String title;
    String author;
    int pages;

    Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    void printInfo() {
        System.out.println(title + " ដោយ " + author + " (" + pages + " ទំព័រ)");
    }
}

public class Main {
    public static void main(String[] args) {
        Book first = new Book("Java មូលដ្ឋាន", "ដារ៉ា", 250);
        Book second = new Book("Java ជ្រៅ", "សុភា", 420);
        first.printInfo();
        second.printInfo();
    }
}
~~~

Book ជា class; first និង second ជា references ដែលនីមួយៗចង្អុលទៅ object ផ្សេងគ្នា។ Object មួយៗមាន field values ផ្ទាល់ខ្លួន។

## ៣. Field, constructor និង this
Field ជា state របស់ object។ Constructor ដំណើរការពេលបង្កើត object ដោយ new។ Constructor គ្មាន return type; បើដាក់ void នោះវាក្លាយជា method ធម្មតា មិនមែន constructor។ this.title បញ្ជាក់ field របស់ object បច្ចុប្បន្ន ព្រោះ parameter title មានឈ្មោះដូច field។

Compiler ផ្តល់ no-argument constructor តែពេលអ្នកមិនបានសរសេរ constructor ណាមួយ។ ពេលបានសរសេរ constructor ផ្ទាល់ អ្នកត្រូវបន្ថែម no-argument constructor ដោយខ្លួនឯង ប្រសិនបើត្រូវការ។

## ៤. Instance និង static
Instance method ដំណើរការលើ object មួយ ហើយអាចប្រើ field របស់ object។ Static method ជារបស់ class ហើយមិនមាន this; វាសមស្របសម្រាប់ utility ដែលមិនពឹង state របស់ object។ កុំដាក់ state ដែលគួរជាកម្មសិទ្ធិរបស់មនុស្ស/object ម្នាក់ៗទៅក្នុង static field ព្រោះ object ទាំងអស់នឹងចែករំលែកតម្លៃតែមួយ។

## ៥. Reference និង equality
អថេរ object ផ្ទុក reference មិនមែន object ចម្លងទាំងមូលទេ។ បើ assign reference មួយទៅអថេរផ្សេង អថេរទាំងពីរអាចចង្អុល object ដូចគ្នា។ == ពិនិត្យ identity; equals() ពិនិត្យ logical equality ប្រសិនបើ class override វា។ Object class ទូទៅត្រូវបង្កើត equals() និង hashCode() ជាគូ ប្រសិនបើប្រើជា key ក្នុង HashMap/Set។

## ៦. កំហុសដែលជួបញឹកញាប់
- ភ្លេច new មុនប្រើ constructor។
- ច្រឡំ constructor ជាមួយ method មាន return type។
- ប្រើ reference ដែលជា null។
- ប្រើ == ដើម្បីប្រៀបធៀបអត្ថន័យរបស់ String/object។
- បង្កើត class ធំមួយដែលទទួលខុសត្រូវច្រើនពេក។
- បើក field ទាំងអស់ជាសាធារណៈ ហើយធ្វើឱ្យ state មិនត្រឹមត្រូវងាយកើត។

## ៧. Compile និង Run
public class ត្រូវមានឈ្មោះដូច file។ ប្រសិនបើ public class Main នោះ file គួរឈ្មោះ Main.java។

## លំហាត់
ធ្វើ [exercise.md](exercise.md) មុនមើល [Answer.java](Answer.java)។
