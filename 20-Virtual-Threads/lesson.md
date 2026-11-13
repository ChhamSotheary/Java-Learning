# មេរៀនទី ២០៖ Virtual Threads និង Structured Concurrency

## ១. Virtual thread ជាអ្វី?
Virtual thread ជា thread ដែល Java runtime គ្រប់គ្រង ហើយអាច multiplex លើ platform threads។ វាត្រូវបានរចនាឱ្យបង្កើតបានច្រើនសម្រាប់ task ដែលភាគច្រើនរង់ចាំ I/O។ វាមិនបង្កើត CPU cores បន្ថែម ហើយមិនធ្វើឱ្យ CPU-bound loop លឿនដោយស្វ័យប្រវត្តិទេ។

Virtual threads មាននៅ Java 21។ កូដឧទាហរណ៍មិន compile លើ JDK ចាស់ជាងនេះទេ។

~~~java
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.ofVirtual().start(() ->
            System.out.println("Hello from virtual thread")
        );
        thread.join();
    }
}
~~~

## ២. បង្កើត task ច្រើន
ExecutorService.newVirtualThreadPerTaskExecutor() បង្កើត virtual thread មួយក្នុងមួយ task ហើយបិទ executor បន្ទាប់ពី task បញ្ចប់។ ប្រើ try-with-resources លើ JDK 21+។

~~~java
try (var executor = java.util.concurrent.Executors
        .newVirtualThreadPerTaskExecutor()) {
    for (int i = 0; i < 100; i++) {
        int taskId = i;
        executor.submit(() -> {
            System.out.println("Task " + taskId);
            return null;
        });
    }
}
~~~

កុំបង្កើត task រាប់លានក្នុង memory ដោយគ្មាន backpressure ឬ capacity planning។ Resource ពិតនៅតែមានកំណត់។

## ៣. តើវាសមស្របពេលណា?
សមស្របសម្រាប់ blocking I/O ដែលមាន concurrent request ច្រើន ហើយ code ងាយសរសេរជា sequential style។ មិនសមសម្រាប់ CPU-intensive parallel computation ដែលត្រូវការកំណត់ worker តាម CPU។ ក៏មិនជំនួស connection pool, rate limit ឬ database capacity ទេ។

## ៤. Pinning និង blocking
Virtual thread ត្រូវបាន mount លើ carrier platform thread។ ករណី blocking ខ្លះអាច pin carrier ឬបន្ថយ scalability អាស្រ័យលើ JDK/library version។ វាស់លើ JDK ដែល deploy ពិត ហើយពិនិត្យ JEP/version-specific docs; កុំប្រើ heuristic ចាស់ដោយគ្មានផ្ទៀងផ្ទាត់។

## ៥. Structured concurrency
គំនិត structured concurrency គឺកំណត់ child tasks ជាក្រុមដែល lifecycle, cancellation និង error propagation ត្រូវបានគ្រប់គ្រងជាមួយ parent។ API នេះអាចមាន status preview/ឬអភិវឌ្ឍតាម JDK release ដូច្នេះកុំយក syntax មួយទៅគ្រប់ version។ ចាប់ផ្តើមពី virtual threads ដែលជា stable feature ហើយបន្ទាប់មកពិនិត្យ JEP សម្រាប់ structured concurrency version ដែលអ្នកប្រើ។

## ៦. លំហាត់
1. រត់ example លើ JDK 21+។
2. ប្រៀបធៀប 100 tasks ដែលចាំ I/O ជាមួយ 100 CPU loops។
3. រាយ resource limits ដែលនៅតែត្រូវគ្រប់គ្រង ទោះប្រើ virtual threads ក៏ដោយ។
