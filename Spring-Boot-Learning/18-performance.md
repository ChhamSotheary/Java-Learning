# Spring Boot មេរៀនទី ១៨៖ Performance និង Troubleshooting

## ចាប់ផ្តើមពីរោគសញ្ញា
កំណត់ថាបញ្ហាជា latency, throughput, startup, memory ឬ resource saturation។ ប្រមូល baseline និង request mix។ ពិនិត្យ p50/p95/p99 មិនមើល average តែមួយ។ បំបែក app time, DB time, network/downstream និង queue wait។

## Thread និង connection pools
Tomcat/Jetty thread pool, async executor និង DB connection pool ជា resource ផ្សេងគ្នា។ Pool ធំពេកអាចបង្ក queueing នៅ DB និង memory use; pool តូចពេកអាចបិទ throughput។ វាស់ active/idle/waiting connections, request queue និង saturation មុនកែទំហំ។

## Database performance
ពិនិត្យ query count, slow queries, indexes, N+1, pagination និង execution plan។ Index អាចលឿន read ប៉ុន្តែធ្វើឱ្យ write/storage ថ្លៃ។ កុំដោះស្រាយ query issue ដោយបង្កើន pool ទៅដល់ DB មិនទប់ទល់។

## JVM និង allocation
មើល heap, GC pauses, allocation rate, thread count, direct/native memory និង container limits។ Heap dump/JFR អាចមាន data រសើប; កំណត់ access/retention។ កែ GC flags បន្ទាប់ពីមាន evidence ថា GC ជា bottleneck មែន។

## Load testing
បង្ក workload តំណាង, warmup, concurrency និង duration ឱ្យពិត។ Load test ទៅ staging/local system ដែលអ្នកមានសិទ្ធិ; កុំបាញ់ traffic ទៅ production ដោយគ្មានការអនុម័ត។ តាមដាន downstreams ដើម្បីកុំច្រឡំ app bottleneck ជា DB/network bottleneck។

## លំហាត់
1. បង្កើត dashboard សម្រាប់ latency percentiles, error rate, JVM/GC និង DB pool។
2. សរសេរ hypothesis បីសម្រាប់ API p99 ខ្ពស់។
3. កំណត់ benchmark plan មួយដែលមាន baseline, warmup, load pattern និង success criteria។
