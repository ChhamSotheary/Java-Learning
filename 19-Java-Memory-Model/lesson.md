# មេរៀនទី ១៩៖ Java Memory Model និង Visibility

Java Memory Model (JMM) កំណត់ថា thread មួយអាចមើលឃើញការសរសេររបស់ thread មួយទៀតនៅពេលណា។ ការមាន shared variable មិនមានន័យថា updates ត្រូវបានមើលឃើញភ្លាមៗដោយ thread ទាំងអស់ទេ។

## Race Condition
បើ thread ច្រើនអាន/កែ shared state ដោយគ្មានការរៀបចំ តម្លៃចុងក្រោយអាចពឹងលើ timing។ សូម្បី count++ ក៏មិនមែនជា operation atomic មួយទេ; វាមាន read, add និង write។

## Happens-before
synchronized unlock/lock ដូចគ្នា និង volatile write/read មានទំនាក់ទំនង happens-before តាមច្បាប់ JMM។ វាផ្តល់ visibility/order guarantees តែ volatile មិនធ្វើ compound operation ដូចជា count++ ឱ្យ atomic ទេ។

~~~java
private volatile boolean running = true;

void stop() {
    running = false;
}

void work() {
    while (running) {
        // do work
    }
}
~~~

សម្រាប់ counter ដែលត្រូវបន្ថែមជាន់គ្នា ប្រើ AtomicInteger ឬ lock ដែលសមស្រប។ Immutable objects និង message passing ជួយកាត់ shared mutable state។

## Safe Publication
ការបង្ហោះ reference ទៅ object មុនពេល initialize ចប់អាចឱ្យ thread ផ្សេងឃើញ state មិនពេញលេញ។ ប្រើ final fields, synchronized/volatile handoff, concurrent collection ឬ framework API ដែលធានា thread-safety។

## លំហាត់
1. ពន្យល់ហេតុអ្វី volatile int count មិនធ្វើ count++ ឱ្យ atomic។
2. បង្កើត toy example សម្រាប់ visibility និងពន្យល់ថាហេតុអ្វី test ម្តងអាចមិនបង្ហាញ bug។
3. ជ្រើស AtomicInteger, synchronized ឬ immutable design សម្រាប់ shared counter ហើយបញ្ជាក់មូលហេតុ។
