# មេរៀនទី ១៨៖ Concurrency ជាមួយ Thread និង ExecutorService

## ១. Concurrency និង Parallelism
Concurrency មានន័យថាការងារច្រើនកំពុងដំណើរការជាន់គ្នាតាមទស្សនៈកម្មវិធី; parallelism ជាការដំណើរការពិតក្នុងពេលតែមួយលើ processor ច្រើន។ Concurrency មានប្រយោជន៍សម្រាប់ I/O wait និងការឆ្លើយតប; parallelism អាចជួយ CPU work ប្រសិនបើបែងចែកបានល្អ។

## ២. Thread និង Runnable
Thread ជាខ្សែការងារ។ ការបង្កើត thread មួយក្នុងមួយ task ដោយគ្មានដែនកំណត់អាចប្រើ memory និង OS resource ច្រើន។ កម្មវិធីទូទៅប្រើ ExecutorService ដើម្បីគ្រប់គ្រងចំនួន worker និង task queue។

~~~java
ExecutorService executor = Executors.newFixedThreadPool(2);
try {
    Future<Integer> future = executor.submit(() -> 20 + 22);
    System.out.println(future.get());
} finally {
    executor.shutdown();
}
~~~

shutdown មិនបង្ខំឱ្យឈប់ភ្លាមៗទេ; វាឈប់ទទួល task ថ្មី ហើយបញ្ចប់ task ដែលបាន submit។ បើចាំបាច់បិទក្នុងពេលកំណត់ ប្រើ awaitTermination ហើយមានផែនការសម្រាប់ shutdownNow/interruption។

## ៣. Race condition និង atomicity
count++ មិនមែន operation atomic មួយទេ៖ វាអាន, គណនា, សរសេរ។ Thread ពីរអាចអានតម្លៃដូចគ្នា ហើយសរសេរលទ្ធផលជាន់គ្នា។ ការប្រើ synchronized ឬ AtomicInteger ជួយការពារករណីសាមញ្ញ។

~~~java
AtomicInteger counter = new AtomicInteger();
counter.incrementAndGet();
~~~

AtomicInteger សមសម្រាប់ atomic counter; វាមិនធ្វើឱ្យ transaction ដែលកែ fields ច្រើន atomic ទេ។

## ៤. Visibility និង synchronization
synchronized ផ្តល់ mutual exclusion និង visibility នៅពេលចូល/ចេញ monitor ដូចគ្នា។ volatile ផ្តល់ visibility/order សម្រាប់ variable មួយ ប៉ុន្តែមិនធានា compound update។ Immutable data និង message passing ជួយកាត់ shared mutable state។

## ៥. Deadlock និង starvation
Deadlock អាចកើតពេល thread កាន់ lock មួយ ហើយរង់ចាំ lock មួយទៀត ខណៈ thread មួយទៀតធ្វើបញ្ច្រាស។ ប្រើ lock ordering ថេរ, កុំកាន់ lock ពេលហៅ network/user code និងរក្សា critical section ខ្លី។ Starvation កើតពេល thread មួយមិនទទួលឱកាសដំណើរការគ្រប់គ្រាន់។

## ៦. Interruption និង cancellation
Interruption ជាសញ្ញាសហការ។ Task ត្រូវពិនិត្យ interrupt status ឬបញ្ជូន InterruptedException ឡើង; កុំចាប់ហើយលុបសញ្ញានេះ។ Future.cancel(true) ព្យាយាម interrupt មិនធានាថា code ឈប់ភ្លាមៗទេ។

## ៧. លំហាត់
ធ្វើ [exercise.md](exercise.md)។ បង្កើត counter test តូចដែលអាចបង្ហាញ race បាន ហើយកែវាដោយ AtomicInteger ឬ synchronized។
