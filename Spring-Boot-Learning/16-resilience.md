# Spring Boot មេរៀនទី ១៦៖ Timeout, Retry និង Resilience

## Failure កើតជាធម្មតា
Network, database និង downstream services អាចយឺត ឬដាច់។ ប្រព័ន្ធរឹងមាំមិនអាចទប់ failure ទាំងអស់បានទេ ប៉ុន្តែអាចកំណត់ផលប៉ះពាល់ និងស្តារឡើងវិញ។

## Timeout ជាមូលដ្ឋាន
កំណត់ connect/read/request timeout លើ HTTP client និង DB pool។ បើគ្មាន timeout request អាចកាន់ thread/connection យូររហូតធ្វើឱ្យ resource អស់។ Timeout budget គួរត្រូវចែកតាម request path និង SLO; timeout របស់ downstream ត្រូវតិចជាង total request deadline។

## Retry
Retry តែ transient error និង operation ដែលអាចធ្វើឡើងវិញដោយមិនបង្ក side effect ស្ទួន។ ប្រើចំនួនកំណត់, exponential backoff និង jitter។ កុំ retry validation/authorization error។ Retry ពី client, gateway និង service ជាន់គ្នាអាចបង្ក retry storm។

## Circuit breaker និង bulkhead
Circuit breaker បញ្ឈប់ការហៅ downstream បណ្តោះអាសន្នពេល failure rate ខ្ពស់ ហើយព្យាយាមវិញក្រោយ window។ Bulkhead កំណត់ resource សម្រាប់ dependency មួយ ដើម្បី outage មិនប៉ះ service ទាំងមូល។ API/implementation ស្ថិតក្នុង library ដូច Resilience4j; ពិនិត្យ version និង configuration ជាក់ស្តែង។

## Idempotency និង fallback
សម្រាប់ payment/order use case ប្រើ idempotency key, uniqueness constraint និង transaction។ Fallback គួរបង្ហាញ degradation ដែលយល់បាន; កុំ return fake success ដែលបំភាន់ client។

## លំហាត់
1. គូរ deadline សរុប 2 វិនាទី សម្រាប់ service ដែលហៅ API ពីរ។
2. កំណត់ retry policy សម្រាប់ GET និងសរសេរមូលហេតុដែលមិនអនុវត្តដូចគ្នាទៅ charge endpoint។
3. កំណត់ circuit breaker state និង metric ដែលត្រូវ monitor។
