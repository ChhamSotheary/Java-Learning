# មេរៀនទី ១៨៖ Concurrency ជាមួយ Thread និង ExecutorService

Concurrency អនុញ្ញាតឱ្យមានការងារច្រើនកំពុងរង់ចាំ ឬដំណើរការជាន់គ្នា; parallelism មានន័យការដំណើរការពិតក្នុងពេលតែមួយលើ processor ច្រើន។ ការចែករំលែក mutable state អាចបង្ក race condition។

## ExecutorService
ជាទូទៅប្រើ ExecutorService ជំនួសការបង្កើត thread ច្រើនដោយដៃ។ Pool គ្រប់គ្រងការប្រតិបត្តិ task និងចំនួន thread។

~~~java
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try (var executor = Executors.newFixedThreadPool(2)) {
            Future<Integer> result = executor.submit(() -> 20 + 22);
            System.out.println(result.get());
        }
    }
}
~~~

ExecutorService AutoCloseable អាស្រ័យលើ JDK version; បើប្រើ JDK ដែលមិនគាំទ្រ try-with-resources សម្រាប់វា ត្រូវ shutdown និង awaitTermination តាម API របស់ version នោះ។ កុំសន្មតថា cancel task មានន័យថាវាឈប់ភ្លាមៗ; task ត្រូវគោរព interruption។

## Synchronization
synchronized និង Lock អាចការពារ critical section ប៉ុន្តែ lock ទូលំទូលាយអាចបន្ថយ throughput ឬបង្ក deadlock។ Concurrent collections និង atomic classes ជាជម្រើសសម្រាប់ use case ជាក់លាក់។

## លំហាត់
1. បង្កើត executor មាន worker ចំនួនកំណត់ ហើយ submit task ច្រើន។
2. បង្កើត race condition លើ counter ក្នុង toy program ហើយពិពណ៌នាហេតុអ្វីកើត។
3. បន្ថែម synchronization ឬ AtomicInteger ហើយប្រៀបធៀប។
4. ពន្យល់ graceful shutdown និង interruption។
