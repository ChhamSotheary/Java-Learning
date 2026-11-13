# មេរៀនទី ១៧៖ Testing, Debugging និង Build Tools

## Test ជា specification ដែលរត់បាន
Unit test ពិនិត្យ logic តូចដោយញែក dependency។ Integration test ពិនិត្យការភ្ជាប់ផ្នែកច្រើន។ End-to-end test ពិនិត្យ flow ជិតនឹងការប្រើប្រាស់ពិត។ កុំ mock អ្វីគ្រប់យ៉ាង; test គួរបញ្ជាក់ behavior ដែលសំខាន់។

~~~java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void addsTwoNumbers() {
        assertEquals(5, Calculator.add(2, 3));
    }
}
~~~

## Build Tools
Maven/Gradle គ្រប់គ្រង dependencies, compile, test និង package។ Pin versions តាម dependency management ហើយកុំទាញ jar ចៃដន្យមក commit បើមិនចាំបាច់។ Locking/reproducible build អាស្រ័យលើ build tool និង project config។

## Debugging
ប្រើ debugger breakpoint ដើម្បីពិនិត្យ state/stack ជាជាងបន្ថែម print ច្រើន។ Log សម្រាប់ diagnosis; កុំ log password, token ឬ personal data។ Test failure គួរមាន assertion ច្បាស់ និង deterministic។

## លំហាត់
1. សរសេរ unit test សម្រាប់ method average និងករណីគែម។
2. រៀបចំ test cases សម្រាប់ empty input និង invalid input។
3. ពន្យល់ unit test ខុសពី integration test។
4. ស្វែងរក dependency tree ក្នុង Maven ឬ Gradle project មួយ។
