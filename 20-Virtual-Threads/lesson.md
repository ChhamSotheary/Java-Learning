# មេរៀនទី ២០៖ Virtual Threads និង Structured Concurrency

Virtual threads (Java 21+) ជា thread ស្រាលដែល Java runtime កំណត់លើ platform threads។ វាមានប្រយោជន៍សម្រាប់កម្មវិធីដែលមាន concurrent tasks ច្រើន និងភាគច្រើនរង់ចាំ I/O។ វាមិនធ្វើឱ្យ CPU-bound computation លឿនដោយស្វ័យប្រវត្តិទេ។

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

កុំប្រើ thread pool តូចៗសម្រាប់ virtual threads ដោយគិតថាត្រូវកំណត់ចំនួនដូច platform threads; ជំនួសវិញកំណត់ resource ពិត ដូចជា database connections និង remote service concurrency។ កុំបង្កើត virtual thread មួយក្នុងមួយ CPU loop សម្រាប់ compute-heavy work។

Structured concurrency ជួយកំណត់ lifecycle និង error handling របស់ subtasks ជាក្រុម ប៉ុន្តែ API និង status អាចប្រែប្រួលតាម JDK release។ ពិនិត្យ JEP និង documentation តាម version មុនប្រើ production។

## លំហាត់
1. រត់ virtual thread example លើ JDK 21+។
2. ប្រៀបធៀប workload ដែលរង់ចាំ I/O ជាមួយ workload គណនា CPU។
3. ពន្យល់ថា virtual threads មិនមានន័យថា resource របស់ database អាចគ្មានដែនកំណត់។
