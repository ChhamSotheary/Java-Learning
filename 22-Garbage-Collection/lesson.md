# មេរៀនទី ២២៖ Heap, Reachability និង Garbage Collection

## ១. តើ GC សម្អាតអ្វី?
GC អាចយក heap memory របស់ object ដែលមិនអាចចូលដល់តាម GC roots មកប្រើឡើងវិញ។ Root examples រួមមាន local references របស់ active threads, static references និង JNI handles។ GC មិនដឹងថា object “មិនចង់បាន” តាម business meaning ទេ; បើកម្មវិធីនៅមាន reference វានៅតែ reachable។

## ២. Heap និង non-heap memory
Java heap មាន object allocation ជាចម្បង។ Process ក៏ប្រើ metaspace/class metadata, thread stacks, code cache, direct buffers និង native memory ផងដែរ។ ដូច្នេះ heap មិនស្មើនឹង memory ទាំងអស់របស់ process។ OutOfMemoryError អាចកើតក្នុង resource ផ្សេងៗ មិនតែ heap ទេ។

## ៣. Generational intuition
Generational collectors ពឹងលើការសង្កេតថា object ជាច្រើនរស់ខ្លី។ Young collection ផ្តោតលើ objects ថ្មី; objects ដែលនៅរស់បានយូរអាច promote។ វាជាការពិពណ៌នាទូទៅ មិនមែនជា layout តែមួយសម្រាប់ GC គ្រប់ប្រភេទ/JDK ទេ។

## ៤. GC pause, throughput និង footprint
GC បង្កើត trade-off រវាង pause latency, application throughput និង memory footprint។ កុំប្តូរ GC flags ព្រោះបានឮថា “លឿន”; ប្រមូល GC logs/metrics, heap size, allocation rate និង latency percentiles ជាមុន។ ចាប់ផ្តើមពី default ដែល JDK ជ្រើស ហើយកែតែមាន evidence និង benchmark តំណាង។

## ៥. Leak ក្នុង garbage-collected language
Memory leak អាចកើតនៅ Java បើ references នៅជាប់ unintentionally: static collection មិនកំណត់ទំហំ, listener មិនដកចេញ, cache គ្មាន eviction ឬ ThreadLocal មិនសម្អាតក្នុង pooled thread។ GC មិនអាចសម្អាត object ដែលនៅ reachable ទេ។

## ៦. សង្កេត
ប្រើ GC logging ដូចជា -Xlog:gc ក្នុង JDK 9+ លើកម្មវិធីសាកល្បង។ jcmd <pid> GC.heap_info និង Java Flight Recorder អាចជួយ inspect process ដែលអ្នកគ្រប់គ្រង។ Dump អាចមាន data រសើប; រក្សាទុក/ចែករំលែកដោយប្រុងប្រយ័ត្ន។

## លំហាត់
1. ពន្យល់ថា object មួយអាចស្លាប់តាម business logic តែ reachable នៅតាម cache ដូចម្តេច។
2. បែងចែក heap OOM និង native memory pressure។
3. សរសេរផែនការប្រមូល evidence មុនកែ -Xmx ឬ GC algorithm។
