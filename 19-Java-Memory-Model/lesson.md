# មេរៀនទី ១៩៖ Java Memory Model និង Happens-before

## ១. ហេតុអ្វីត្រូវការ JMM?
Thread ចែករំលែក heap objects ប៉ុន្តែ compiler និង processor អាចប្តូរលំដាប់ operation ដែលមិនប៉ះ observable behavior ក្នុង thread តែមួយ។ JMM កំណត់ថា behavior ណាដែលកម្មវិធី multi-thread អាចឃើញ។ កុំសន្មតថា source lines ត្រូវបានប្រតិបត្តិតាមលំដាប់ដូចគ្នាដោយ thread ទាំងអស់។

## ២. Data race
Data race កើតពេល thread ពីរចូលប្រើ variable ដូចគ្នា concurrently, យ៉ាងហោចណាស់មួយសរសេរ, ហើយមិនមាន synchronization ដែលធានាលំដាប់។ កម្មវិធីអាចបង្ហាញ stale value ឬ lost update។

count++ ត្រូវបានបំបែកជា read → add → write ដូច្នេះ volatile មិនធ្វើវាឱ្យ atomic ទេ។

## ៣. Happens-before
Happens-before ជាទំនាក់ទំនងដែលធានា visibility និង order។ ឧទាហរណ៍ unlock monitor happens-before lock បន្ទាប់លើ monitor ដូចគ្នា; write ទៅ volatile happens-before read បន្ទាប់ដែលមើលឃើញតម្លៃនោះ; Thread.start និង Thread.join ក៏មាន guarantees តាម spec។ បើគ្មាន happens-before ការអានអាចឃើញតម្លៃចាស់។

## ៤. volatile flag

~~~java
class Worker {
    private volatile boolean running = true;

    void stop() {
        running = false;
    }

    void work() {
        while (running) {
            doSmallUnitOfWork();
        }
    }

    private void doSmallUnitOfWork() { }
}
~~~

volatile សមស្របសម្រាប់ flag មួយនេះ ព្រោះ thread មួយសរសេរ ហើយមួយទៀតអាន។ វាមិនសមសម្រាប់ការធ្វើ invariant ច្រើន field ដែលត្រូវប្ដូរជាក្រុម។

## ៥. Atomic និង synchronized
ប្រើ AtomicInteger សម្រាប់ counter ឬ compare-and-set pattern; ប្រើ synchronized/Lock សម្រាប់ invariant ដែលពាក់ព័ន្ធ state ច្រើន។ Concurrent collections សម្រាប់ structure ដែលចែករំលែក។ ត្រូវចងចាំថា thread-safe method មួយមិនធ្វើ sequence នៃ calls ច្រើនឱ្យ atomic ដោយស្វ័យប្រវត្តិទេ។

## ៦. Safe publication និង final fields
បង្កើត object ឱ្យរួច មុនបង្ហោះ reference ទៅ thread ផ្សេង។ ប្រើ final fields, synchronized/volatile handoff ឬ concurrent queues។ កុំចេញ this ពី constructor មុន initialization ចប់ ព្រោះ thread ផ្សេងអាចឃើញ object មិនទាន់ពេញលេញ។

## ៧. លំហាត់
1. ពន្យល់ហេតុអ្វី volatile int មិនធ្វើ count++ ឱ្យ atomic។
2. ជ្រើស happens-before mechanism សម្រាប់ worker thread ផ្ញើ result ទៅ main។
3. បែងចែក visibility, atomicity និង ordering ដោយឧទាហរណ៍។
