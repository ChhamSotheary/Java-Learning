# Spring Boot មេរៀនទី ១៤៖ Scheduling, Async និង Messaging

## ១. Scheduled tasks
@EnableScheduling និង @Scheduled អាចរត់ task តាម interval/cron។ Task ដំណើរការក្នុង process របស់ app; បើ app មាន replicas ច្រើន នោះ task អាចរត់ម្តងក្នុង replica នីមួយៗ។ សម្រាប់ job ដែលត្រូវរត់តែមួយ ឬមាន locking/retry/durable state សូមប្រើ scheduler/queue ដែលសមស្រប មិនពឹង @Scheduled មួយមុខ។

## ២. Async execution
@Async ឬ TaskExecutor បញ្ជូនការងារទៅ thread pool។ ត្រូវកំណត់ pool size, queue capacity, rejection policy, shutdown និង exception handling។ Default executor configuration មិនចាំបាច់សមនឹង workload។ Context ដែលពឹង ThreadLocal (security, tracing, MDC) ត្រូវ propagate តាម mechanism ត្រឹមត្រូវ។

ការប្រើ @Async មាន proxy behavior; self-invocation អាចមិនឆ្លង proxy។ Return CompletableFuture អាចឱ្យ caller observe failure/cancel ប៉ុន្តែ cancellation មិនតែងឈប់ task ពិតភ្លាមៗទេ។

## ៣. Messaging
Message broker ដូច Kafka/RabbitMQ បំបែក producer និង consumer តាម queue/topic។ Message delivery អាច at-least-once, ដូច្នេះ consumer ត្រូវ idempotent និងគ្រប់គ្រង duplicate។ Ordering អាចមានត្រឹម partition/key scope មិនមែនទូទាំង topic។ Retry/DLQ ត្រូវមាន policy និង monitoring។

## ៤. Database + message dual-write
ការសរសេរ database ហើយ publish message ជាបន្ទាប់អាចកើត partial failure។ Transactional outbox រក្សា business update និង event record ក្នុង DB transaction តែមួយ; worker បញ្ជូន event បន្ត ហើយ consumer deduplicate។ វាបន្ថយ dual-write gap ប៉ុន្តែបន្ថែម outbox cleanup/monitoring។

## ៥. លំហាត់
1. រចនា scheduled cleanup ដែលអាចដំណើរការលើ replicas ច្រើន។
2. កំណត់ pool/queue behavior សម្រាប់ async report generation។
3. រចនា consumer ដែល safe ចំពោះ duplicate message។
4. គូរ outbox flow ពី transaction រហូតដល់ consumer។
