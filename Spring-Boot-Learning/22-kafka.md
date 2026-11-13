# Spring Boot មេរៀនទី ២២៖ Kafka Messaging

## Kafka model
Kafka រក្សា records ក្នុង topics ដែលបំបែកជា partitions។ Consumer group ចែក partitions ទៅ consumers; ordering មាននៅក្នុង partition តែមួយ។ Key ជួយកំណត់ partition និងអាចរក្សា order សម្រាប់ entity មួយ។ Broker retention មិនដូច queue ដែលលុប message ក្រោយអានជានិច្ចទេ។

## Producer/consumer
Spring for Apache Kafka ផ្តល់ listener និង template integrations។ Configure bootstrap servers, serializer/deserializer, consumer group និង error handler តាម environment។ Version compatibility រវាង Spring Boot, Spring Kafka និង Kafka broker ត្រូវពិនិត្យ official compatibility docs។

## Delivery និង idempotency
Consumer អាចទទួល message ម្តងច្រើនដងពេល failure/rebalance។ Design handler ឱ្យ idempotent ដោយ unique event ID/processed-event table ឬ domain constraint។ Offset commit semantics, transaction និង retry policy កំណត់ថា message ត្រូវបានបាត់ ឬ duplicate នៅពេលណា។

## Schema evolution
កំណត់ schema/compatibility policy សម្រាប់ producer និង consumer version ខុសគ្នា។ កុំ rename/remove field ដោយមិនគិត old readers។ Schema Registry ជា optional platform choice មិនមែន prerequisite របស់ Kafka core ទេ។

## Operations និង security
ប្រើ TLS/authentication តាម broker, ACL តាម topic/group, credential rotation និង monitoring consumer lag, rebalance, retries, DLQ។ កុំ log payload មាន secret/PII។ កំណត់ max message size និង retention តាម requirement។

## លំហាត់
1. គូរ order event ពី DB update ទៅ Kafka consumer។
2. កំណត់ partition key សម្រាប់ order events និងមូលហេតុ។
3. រចនា idempotency ក្នុង consumer។
4. កំណត់ metric/alert សម្រាប់ consumer lag និង DLQ។
