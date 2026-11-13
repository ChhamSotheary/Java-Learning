# មេរៀនទី ១០៖ Exception Handling

Exception ជាវត្ថុដែល runtime បោះឡើងនៅពេលការប្រតិបត្តិធម្មតាត្រូវបានរំខាន។ ការគ្រប់គ្រង exception ត្រឹមត្រូវអាចបម្លែងបញ្ហាដែលរំពឹងទុកទៅជាកំហុសដែលអ្នកប្រើយល់បាន; កុំ catch ទាំងអស់ហើយលាក់បញ្ហា។

## try, catch, finally

~~~java
try {
    int value = Integer.parseInt("abc");
    System.out.println(value);
} catch (NumberFormatException exception) {
    System.out.println("សូមបញ្ចូលលេខត្រឹមត្រូវ");
} finally {
    System.out.println("បញ្ចប់ការសាកល្បង");
}
~~~

catch ដែលជាក់លាក់ជួយឱ្យដោះស្រាយបានត្រឹមត្រូវ។ finally ប្រើសម្រាប់ cleanup ប៉ុន្តែសម្រាប់ resource ដែលត្រូវបិទ គួរប្រើ try-with-resources។

## Checked និង Unchecked
Checked exception ត្រូវបាន compiler ទាមទារឱ្យ catch ឬប្រកាសដោយ throws។ RuntimeException និង subclass របស់វា ជា unchecked exceptions។ កុំជ្រើស exception type ដោយគិតតែឱ្យ compile; គិតថាអ្នកហៅ API អាចដោះស្រាយវាបានយ៉ាងដូចម្តេច។

## បោះ exception និងបង្កើត exception ផ្ទាល់ខ្លួន

~~~java
static int divide(int a, int b) {
    if (b == 0) {
        throw new IllegalArgumentException("ភាគបែងមិនអាចសូន្យ");
    }
    return a / b;
}
~~~

កុំប្រើ exception សម្រាប់ flow ធម្មតាដែលអាចពិនិត្យបានងាយ។ កុំ catch Exception ជុំវិញកម្មវិធីដោយមិន log ឬដោះស្រាយ។

## try-with-resources
ប្រើសម្រាប់ resource ដែល implements AutoCloseable ដូចជា file streams និង JDBC connection។ Java បិទ resource ដោយស្វ័យប្រវត្តិ ទោះមាន exception ក៏ដោយ។

## លំហាត់
ធ្វើ [exercise.md](exercise.md) មុនមើល [Answer.java](Answer.java)។
