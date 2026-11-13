# Spring Boot មេរៀនទី ២៣៖ Spring Batch

## Batch processing ជាអ្វី?
Batch ដំណើរការទិន្នន័យជាក្រុម ជាធម្មតាច្រើន records ដោយមាន restartability, checkpoint និង error handling។ វាខុសពី HTTP request ដែលជាទូទៅត្រូវឆ្លើយក្នុងពេលខ្លី។

## Job និង Step
Spring Batch model មាន Job ជាការងារធំ និង Step ជាដំណាក់កាល។ Chunk-oriented step អាន items, process, ហើយសរសេរជាបាច់ក្នុង transaction។ Reader/processor/writer បំបែកទំនួលខុសត្រូវ និងធ្វើឱ្យ test ងាយ។

~~~text
Job
 ├─ Step: read CSV → validate/transform → write database
 └─ Step: create summary report
~~~

## Restart, idempotency និង skip
Job repository រក្សា execution metadata។ Restart policy និង checkpoint ជួយបន្តក្រោយ failure ប៉ុន្តែ side effects ក្រៅ DB អាចកើតឡើងស្ទួន។ ប្រើ idempotency key, chunk transaction និង skip/retry policy ដែលមានកំណត់។ កុំ skip bad records ដោយស្ងៀមស្ងាត់; រាយការណ៍ rejection reason។

## Scheduling និង concurrency
Scheduler ចាប់ផ្តើម job; Spring Batch គ្រប់គ្រង execution semantics។ ការដាក់ job មួយដំណើរការជាន់គ្នាអាចបង្ក duplicate work ឬ lock conflicts។ កំណត់ job parameters, uniqueness និង concurrent execution rules។

## លំហាត់
1. រចនា CSV import job មាន read/validate/write។
2. បញ្ជាក់ថាតើ restart នៅ record ណា និងរបៀបជៀស duplicate។
3. កំណត់ policy សម្រាប់ malformed rows។
4. គូរ metrics: records/sec, failures, skips និង duration។
