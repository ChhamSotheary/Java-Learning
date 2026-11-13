# មេរៀនទី ១០៖ Exception Handling និង Error Design

## គោលបំណង
អាចអាន stack trace, ប្រើ try/catch/finally, ប្រើ try-with-resources, បែងចែក exception ប្រភេទសំខាន់ៗ និងរចនា error message ដែលមានប្រយោជន៍។

## ១. Exception ជាអ្វី?
Exception ជា object ដែល runtime បោះឡើងនៅពេលការប្រតិបត្តិធម្មតាត្រូវបានរំខាន។ ពេល exception មិនត្រូវបាន catch នៅ method បច្ចុប្បន្ន វាឡើងតាម call stack រហូតរក handler ឬចប់កម្មវិធី។ Stack trace ជួយបង្ហាញប្រភព; ចាប់ផ្តើមអានពីបន្ទាត់ exception និង call site ក្នុង code របស់អ្នក មិនមើលតែបន្ទាត់ចុងក្រោយទេ។

## ២. Checked, unchecked និង Error
Checked exceptions ដូចជា IOException ត្រូវ catch ឬប្រកាស throws។ RuntimeException ជា unchecked ហើយជាញឹកញាប់បង្ហាញការប្រើ API/input មិនត្រឹមត្រូវ។ Error ជាបញ្ហាធ្ងន់នៅ runtime/VM ដែលកម្មវិធីធម្មតាមិនគួរចាប់ដើម្បីបន្តដំណើរការ។ កុំ catch Throwable ឬ Error ជាទម្លាប់។

## ៣. try/catch និងការដោះស្រាយតាមប្រភេទ

~~~java
try {
    int number = Integer.parseInt(input);
    System.out.println(number);
} catch (NumberFormatException exception) {
    System.out.println("សូមបញ្ចូលចំនួនគត់");
}
~~~

Catch តែ exception ដែលអ្នកអាចដោះស្រាយបាន។ បើមិនអាចដោះស្រាយបាន សូមបញ្ជូនឡើងដោយ throws ឬ wrap ជាមួយ context និងរក្សា cause៖

~~~java
throw new IllegalStateException("មិនអាចរក្សាទុក order", exception);
~~~

កុំ catch ហើយមិនធ្វើអ្វី; វាលាក់កំហុស។ កុំបង្ហាញ stack trace, SQL, path ឯកជន ឬ secret ទៅអ្នកប្រើចុងក្រោយ។

## ៤. finally និង try-with-resources
finally ប្រើ cleanup ដែលត្រូវដំណើរការទោះជោគជ័យឬបរាជ័យ។ សម្រាប់ resource ដែល implements AutoCloseable ប្រើ try-with-resources៖

~~~java
try (var reader = java.nio.file.Files.newBufferedReader(
        java.nio.file.Path.of("notes.txt"))) {
    System.out.println(reader.readLine());
} catch (java.io.IOException exception) {
    System.out.println("អាន file មិនបាន");
}
~~~

Java បិទ reader ដោយស្វ័យប្រវត្តិ។ បើ close ក៏បរាជ័យ ខណៈ body ក៏បោះ exception នោះ exception មួយអាចត្រូវបាន suppressed; នេះជាហេតុមួយដែល try-with-resources ល្អជាង close ដោយដៃ។

## ៥. throw និង throws
throw បោះ exception object នៅទីតាំងណាមួយ។ throws ប្រកាសក្នុង method signature ថា method អាចបញ្ជូន checked exception ឡើងទៅ caller។ ជ្រើស exception ឱ្យតំណាងកំហុសដែល caller អាចយល់ និងធ្វើអ្វីបាន។

~~~java
static int divide(int a, int b) {
    if (b == 0) throw new IllegalArgumentException("b មិនអាចសូន្យ");
    return a / b;
}
~~~

## ៦. ការរចនាល្អ
Exception គួរតំណាងលក្ខខណ្ឌពិសេស មិនមែនលំហូរធម្មតា។ Validate input ជិត boundary។ កុំប្រើ exception ជំនួស if សាមញ្ញក្នុង loop ធំ។ កុំ log exception ដដែលនៅគ្រប់ layer ព្រោះវាបង្ក log ស្ទួន; ជ្រើស layer ដែលមាន context គ្រប់គ្រាន់។

## លំហាត់
ធ្វើ [exercise.md](exercise.md) ហើយសាកចម្លើយនៅ [Answer.java](Answer.java)។
