# មេរៀនទី ១៧៖ Testing, Debugging និង Build Tools

## ១. Test ជាអ្វី?
Test គឺជា code ដែលពិនិត្យ behavior ដែលរំពឹង។ Unit test ពិនិត្យ logic តូចៗដោយមិនពឹង network/database ពិត។ Integration test ពិនិត្យការភ្ជាប់ component ឬ infrastructure។ End-to-end test ធ្វើ flow ជិតអ្នកប្រើ ប៉ុន្តែជាទូទៅថ្លៃ និងងាយ flaky ជាង។

## ២. រៀបចំ test case
សម្រាប់ function គិតពី normal case, boundary case និង invalid case។ Test គួរមាន Arrange (រៀបចំ), Act (ហៅ), Assert (ពិនិត្យ)។ ឈ្មោះ test បញ្ជាក់ scenario និង expected result។ កុំសរសេរ test ដែលគ្រាន់តែបញ្ជាក់ថា method មិន throw ដោយគ្មានការពិនិត្យ behavior។

~~~java
@Test
void addsTwoNumbers() {
    int result = Calculator.add(2, 3);
    assertEquals(5, result);
}
~~~

JUnit 5 និង AssertJ ជាឧបករណ៍ពេញនិយម; ត្រូវបន្ថែម test dependencies តាម Maven/Gradle។

## ៣. Mock និង test boundary
Mock dependency អាច isolate logic ប៉ុន្តែ mock ច្រើនពេកអាចធ្វើឱ្យ test ពិនិត្យ implementation ជំនួស behavior។ ប្រើ fake/in-memory implementation សម្រាប់ logic; integration test សម្រាប់ SQL/serialization/framework wiring ដែល mock មិនអាចបញ្ជាក់បាន។

## ៤. Debugging ដោយ debugger
ដាក់ breakpoint នៅជិតកន្លែងដែល state ខុស។ ពិនិត្យ call stack, local variables, expression និង path ដែលចូល branch។ កុំបន្ថែម log សម្ងាត់; log មិនជំនួស debugger ហើយការមើល state អាចបង្ក timing changes ក្នុង concurrent program។

## ៥. Build tools
Maven និង Gradle អាន project metadata, ទាញ dependencies, compile, test និង package artifact។ Build file គួរបញ្ជាក់ JDK target និង dependencies។ កុំប្រើ dynamic version ដោយមិនយល់ពី reproducibility; dependency tree ជួយរក version conflict។

ពាក្យបញ្ជាមូលដ្ឋាន៖

~~~text
mvn test
mvn package
./gradlew test
./gradlew build
~~~

Gradle wrapper របស់ project គួរត្រូវប្រើដើម្បីរក្សា build tool version។ Maven/Gradle commands អាចខុសតាម project។

## ៦. Test ពេលវេលា និង nondeterminism
កុំឱ្យ test ពឹងលើ current time, random seed, filesystem ordering, network availability ឬ shared state ដោយមិនគ្រប់គ្រង។ Inject Clock, seed random ឬប្រើ local test fixture ដើម្បីធ្វើ test ស្ថិរភាព។

## ៧. លំហាត់
ធ្វើ [exercise.md](exercise.md)។ បន្ថែម test មួយសម្រាប់ edge case ហើយពន្យល់ថាវាការពារការថយក្រោយអ្វី។
