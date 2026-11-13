# Spring Boot មេរៀនទី ២៥៖ AOT និង Native Image

## AOT ជាអ្វី?
Ahead-of-time processing ជួយរៀបចំ metadata/code មុន runtime។ GraalVM Native Image បង្ក executable native binary ពី Java application ដោយ build-time analysis; វាអាចបន្ថយ startup time និង memory ក្នុង workload ខ្លះ ប៉ុន្តែ build complexity/compatibility constraints ខ្ពស់ជាង JVM JAR។

## Reflection និង dynamic features
Native image analysis ត្រូវដឹង classes/resources/reflection/proxies ដែលប្រើ។ Dynamic class loading, reflection និង serialization អាចត្រូវការ runtime hints។ Spring Boot AOT processing បង្កើត hints សម្រាប់ផ្នែកដែលស្គាល់ ប៉ុន្តែ custom library អាចត្រូវ configure បន្ថែម។

## Trade-offs
Native build អាចយូរ និង artifact អាស្រ័យ platform/architecture។ JIT JVM អាចមាន peak throughput ល្អជាងក្រោយ warmup។ ត្រូវវាស់ startup, RSS memory, throughput, latency និង build time តាម deployment requirement មិនសន្និដ្ឋានថា native តែងតែប្រសើរ។

## Workflow
1. បង្ក baseline JVM JAR។
2. បើក AOT/native support តាម Spring Boot version។
3. Build native executable ក្នុង compatible environment/container។
4. Run integration/security tests លើ binary។
5. ប្រៀបធៀប production-like workload និង observability។
6. រៀបចំ fallback JVM artifact និង rollback។

## លំហាត់
សរសេរ decision record ថាតើ service របស់អ្នកត្រូវការ native image ដែរឬទេ។ បញ្ចូល startup target, memory limit, throughput, reflection use, build platform និង maintenance cost។
