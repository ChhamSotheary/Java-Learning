# មេរៀនទី ១២៖ File I/O និង NIO.2

## គោលបំណង
អាចបង្កើត Path, អាន/សរសេរ text ដោយ encoding ច្បាស់, ប្រើ try-with-resources និងសម្គាល់ហានិភ័យនៃ path ពី user input។

## ១. Path និង Files
Path តំណាងទីតាំង file ដោយមិនចាំបាច់បើក file។ Files ផ្តល់ static methods សម្រាប់អាន សរសេរ ចម្លង លុប និងពិនិត្យ metadata។ Path.of និង readString/writeString មាននៅ Java 11+។

~~~java
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

Path path = Path.of("notes.txt");
Files.writeString(path, "រៀន Java\n", StandardCharsets.UTF_8);
String text = Files.readString(path, StandardCharsets.UTF_8);
System.out.println(text);
~~~

File ទាំងមូលត្រូវបានអានចូល memory ដូច្នេះវិធីនេះសមសម្រាប់ file តូច/មធ្យម។ សម្រាប់ file ធំ ប្រើ BufferedReader ឬ stream ជាបន្ទាត់។

## ២. Resource cleanup
Stream និង reader ត្រូវបិទ ដើម្បីបញ្ចេញ file descriptor និង resource។ try-with-resources បិទ AutoCloseable ដោយស្វ័យប្រវត្តិ៖

~~~java
try (var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
}
~~~

IOException ជា checked exception; អ្នកអាច catch នៅ boundary ដែលអាចបង្ហាញសារសមរម្យ ឬប្រកាស throws ទៅ caller ដែលអាចសម្រេចចិត្ត។

## ៣. Relative path និង working directory
Relative path ត្រូវបានបកស្រាយពី working directory របស់ process មិនមែនចាំបាច់ពីទីតាំង source file។ ពេល debug មើល System.getProperty("user.dir")។ Path separator ខុសតាម OS; Java Path គ្រប់គ្រង separator តាម platform ជាង concatenate string ផ្ទាល់។

## ៤. Path traversal និង symlink
បើ app ទទួល file name ពីអ្នកប្រើ កុំធ្វើ base.resolve(userInput) ហើយសន្មតថាមានសុវត្ថិភាព។ Normalize និងធានាថា resolved path នៅក្រោម directory ដែលអនុញ្ញាត; គិតពី symlinks និង race condition ផងដែរ។ កុំទុក path មិនទុកចិត្តឱ្យសរសេរទៅ config/system files។

## ៥. Atomic និង durability
Files.move អាចគាំទ្រ ATOMIC_MOVE នៅលើ filesystem មួយចំនួនប៉ុណ្ណោះ។ Atomic rename មិនមានន័យថាទិន្នន័យ durable ក្រោយ power loss ដោយស្វ័យប្រវត្តិទេ។ សម្រាប់ការរក្សាទុកសំខាន់ៗ ត្រូវរចនាផ្លូវ temp-file, validate, replace និង recovery ឱ្យត្រឹមត្រូវតាម OS/filesystem។

## ៦. កំហុសទូទៅ
- អាន file ធំទាំងមូលហើយអស់ memory។
- មិនកំណត់ charset ហើយអត្ថបទខូចពេលប្ដូរ OS។
- ដាក់ path ពី user ដោយមិន validate។
- មិនបិទ stream។
- catch IOException ហើយមិនប្រាប់អ្នកប្រើឬ log context។
- សន្មតថាការសរសេរមួយលើកតែងតែបានទិន្នន័យទាំងអស់។

## លំហាត់
ធ្វើ [exercise.md](exercise.md) មុនមើល [Answer.java](Answer.java)។
