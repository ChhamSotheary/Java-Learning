# មេរៀនទី ១២៖ File I/O និង NIO.2

Java អាចអាន និងសរសេរ file តាម API ចាស់ក្នុង java.io និង API ទំនើបក្នុង java.nio.file។ ចាប់ផ្តើមពី Path និង Files សម្រាប់ការងារទូទៅ។

~~~java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("notes.txt");
        Files.writeString(path, "រៀន Java\n");
        List<String> lines = Files.readAllLines(path);
        lines.forEach(System.out::println);
    }
}
~~~

ឧទាហរណ៍នេះប្រើ Java 11+។ readAllLines ងាយស្រួលសម្រាប់ file តូច; សម្រាប់ file ធំ កុំទាញទាំងអស់ចូល memory។ ប្រើ BufferedReader ឬ Files.lines ហើយបិទ stream ត្រឹមត្រូវ។

## Path និង Files
Path ជាតំណាងទីតាំង file; Files ជា utility សម្រាប់អាន, សរសេរ, copy, move និងពិនិត្យ metadata។ កុំភ្ជាប់ path ពី user input ដោយមិន validate; path traversal អាចធ្វើឱ្យ app ចូល file ក្រៅ directory ដែលចង់អនុញ្ញាត។

## Resource management
ប្រើ try-with-resources សម្រាប់ stream/reader/writer ដែលត្រូវបិទ។ កំណត់ encoding ជាក់លាក់ (ជាទូទៅ UTF-8) នៅពេលទាក់ទង file text ដើម្បីជៀសវាងភាពខុសគ្នាតាម platform។

## លំហាត់
ធ្វើ [exercise.md](exercise.md) មុនមើល [Answer.java](Answer.java)។
