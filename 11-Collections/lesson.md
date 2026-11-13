# មេរៀនទី ១១៖ Collections និង Generics

Array មានទំហំថេរ។ Collections ផ្តល់ structure សម្រាប់បន្ថែម ដក និងស្វែងរកទិន្នន័យដោយទំហំប្រែប្រួល។ Interface ជួយឱ្យ code អាស្រ័យលើ contract ជំនួស implementation មួយជាក់លាក់។

## List, Set និង Map

~~~java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Sophea");
        names.add("Dara");
        System.out.println(names.get(0));

        Set<String> uniqueNames = new HashSet<>(names);
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Sophea", 90);
        System.out.println(scores.get("Sophea"));
    }
}
~~~

- List រក្សា sequence និងអនុញ្ញាតធាតុស្ទួន។
- Set តំណាងឱ្យធាតុមិនស្ទួន; HashSet មិនធានាលំដាប់ iteration។
- Map ផ្គូផ្គង key ទៅ value; key មិនស្ទួន។

## Generics

List<String> បញ្ជាក់ថា list នេះរក្សាទុក String។ Generics ផ្តល់ type safety នៅពេល compile និងកាត់បន្ថយ cast។ Java generic types ប្រើ reference types; ប្រើ Integer ជំនួស int ក្នុង List<Integer>។

## ស្វែងរក និងតម្រៀប
ប្រើ Collections.sort(list) ឬ Comparator ដើម្បីកំណត់លំដាប់។ ការប្រើ object ជា key ក្នុង HashMap ត្រូវយល់សារៈសំខាន់របស់ equals() និង hashCode(): object ដែល equals ជា true ត្រូវមាន hashCode ដូចគ្នា។

## ជ្រើសរើស implementation
ចាប់ផ្តើមពី interface ដូចជា List/Set/Map។ ជ្រើស ArrayList សម្រាប់ការចូលតាម index ជាញឹកញាប់; LinkedList មិនមែនតែងតែលឿនជាងទេ។ ជ្រើស HashMap សម្រាប់ lookup តាម key ដោយមិនត្រូវការលំដាប់។

## លំហាត់
ធ្វើ [exercise.md](exercise.md) មុនមើល [Answer.java](Answer.java)។
