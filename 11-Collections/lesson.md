# មេរៀនទី ១១៖ Collections និង Generics

## គោលបំណង
ជ្រើស List, Set, Map; ប្រើ generics ដោយ type-safe; ស្វែងយល់ពី equals/hashCode និងគិតពី complexity ជាមូលដ្ឋាន។

## ១. ហេតុអ្វី Collections?
Array មានទំហំថេរ និងអាចប្រើ index។ Collections framework ផ្តល់ interface និង implementation សម្រាប់ទិន្នន័យដែលប្រែប្រួល។ ប្រើ interface ជា type របស់ variable ដើម្បីឱ្យអាចប្ដូរ implementation បាន៖

~~~java
List<String> names = new ArrayList<>();
names.add("សុភា");
names.add("ដារ៉ា");
~~~

## ២. List, Set និង Map
- List រក្សាលំដាប់តាម encounter/insertion behavior របស់ implementation និងអាចមាន duplicates។ ArrayList សមស្របសម្រាប់ការបន្ថែមចុងក្រោយ និងចូលតាម index ជាញឹកញាប់។
- Set តំណាងឱ្យ unique elements។ HashSet មិនធានាលំដាប់; LinkedHashSet រក្សាលំដាប់បញ្ចូល; TreeSet តម្រៀប។
- Map ផ្គូផ្គង key ទៅ value។ HashMap មិនធានាលំដាប់; TreeMap តម្រៀបតាម key។

~~~java
List<Integer> scores = new ArrayList<>(List.of(80, 90, 80));
Set<Integer> unique = new HashSet<>(scores);
Map<String, Integer> byName = new HashMap<>();
byName.put("សុភា", 95);
Integer score = byName.get("សុភា");
~~~

get(key) អាចត្រឡប់ null ប្រសិនបើ key មិនមាន ឬតម្លៃបានដាក់ជា null; ប្រើ containsKey ឬ Optional pattern តាម API design ប្រសិនបើភាពខុសគ្នានេះសំខាន់។

## ៣. Generics និង type safety
List<Integer> ប្រាប់ compiler ថា list មាន Integer ប៉ុណ្ណោះ។ Primitive មិនអាចជ type argument បាន ដូច្នេះប្រើ wrapper Integer/Double។ Autoboxing បម្លែង int ↔ Integer តាមសមស្រប ប៉ុន្តែអាចបង្ក null-unboxing error ប្រសិនបើ Integer ជា null។

Generic type ភាគច្រើនត្រូវបាន erase នៅ runtime; compiler ពិនិត្យប្រភេទជាចម្បងនៅ compile time។ ដូច្នេះមិនអាចប្រើ new T() ឬ instanceof List<String> ដោយផ្ទាល់បានទេ។

## ៤. equals និង hashCode
HashMap/HashSet ប្រើ hashCode ដើម្បីរក bucket ហើយ equals ដើម្បីបញ្ជាក់ស្មើ។ ប្រសិនបើ equals() true នោះ hashCode() ត្រូវតែដូចគ្នា។ កុំប្រើ mutable fields ជា key ប្រសិនបើវាអាចប្ដូរបន្ទាប់ពីដាក់ក្នុង map; map អាចរកវាមិនឃើញតាម key ថ្មី។

## ៥. Complexity ជាចំណេះដឹងជាក់ស្តែង
ArrayList ចូលតាម index ជាទូទៅ O(1) ហើយស្វែងរកតាមតម្លៃ O(n)។ HashMap lookup ជាមធ្យមជិត O(1) ប៉ុន្តែមិនមែនជាការធានាគ្រប់ input/implementation ទាំងអស់។ TreeMap operations ជាទូទៅ O(log n)។ កុំជ្រើស structure ដោយប្រើពាក្យ “លឿនជាង” ដាច់ខាត; គិតពី workload, order, memory និងការអានកូដ។

## ៦. Iteration និងការកែប្រែ
ការលុប element ក្នុង foreach អាចបង្ក ConcurrentModificationException។ ប្រើ Iterator.remove ឬ methods ដែលសមស្រប។ ConcurrentModificationException ជា fail-fast detection មិនមែនជា thread synchronization។

## លំហាត់
ធ្វើ [exercise.md](exercise.md) មុនមើល [Answer.java](Answer.java)។
