# មេរៀនទី ២៣៖ Java Performance — Benchmark និង Profiling

## ១. វាស់មុន optimize
កំណត់រោគសញ្ញា និង target (latency, throughput, memory, startup) ជាមុន។ ប្រើ representative workload និង baseline។ កុំបង្កើន performance metric មួយដោយបំផ្លាញ metric ផ្សេងដោយមិនដឹងខ្លួន។

## ២. Microbenchmark មានអន្ទាក់
JIT អាច optimize កូដដែលមិនប្រើលទ្ធផលចោល, constant-fold ឬ inline method។ System.nanoTime ក្នុង loop មួយមិនគ្រប់គ្រាន់សម្រាប់ប្រៀបធៀប implementation។ ប្រើ JMH សម្រាប់ microbenchmark ដោយបំបែក forks, warmup និង measurement; benchmark application end-to-end ដាច់ដោយឡែក។

## ៣. Profiling
CPU sampling បង្ហាញ stack ដែលចំណាយ CPU; allocation profiling ជួយរក object churn; lock profiling បង្ហាញ contention។ Java Flight Recorder (JFR) ជា event recording សម្រាប់ runtime, មាន overhead ដែលត្រូវវាយតម្លៃតាម setting/workload។ Profile តែ process ដែលអ្នកគ្រប់គ្រង និងការពារឯកជនភាពនៃ dump។

## ៤. គន្លឹះកែលម្អជាប្រព័ន្ធ
1. ប្រមូល CPU, allocation, GC, I/O, lock និង request latency។
2. រក hot path ដែលភ្ជាប់នឹងរោគសញ្ញា។
3. បង្កើត hypothesis ដែលអាចវាស់បាន។
4. កែចំណុចតូចមួយ។
5. rerun benchmark ដូចគ្នា និងប្រៀបធៀប confidence/variance។
6. រក្សាកូដសាមញ្ញ បើការកែលម្អមិនសំខាន់។

## ៥. Latency percentiles
Average អាចលាក់ tail latency។ ពិនិត្យ p50/p95/p99 និង sample size។ Queueing, GC pause, downstream latency និង retry storm អាចប៉ះ p99 ខ្លាំង។ កុំសន្និដ្ឋានពី run តែមួយ។

## លំហាត់
បង្កើត benchmark រវាង loop និង Stream លើ dataset តូច/ធំ។ កុំសន្និដ្ឋានថាមួយឈ្នះទូទៅ; កត់ JDK, warmup, forks, data size និងលទ្ធផល។ រៀបចំ hypothesis មួយសម្រាប់ profiling បន្ទាប់។
