# Spring Boot មេរៀនទី ១៥៖ Actuator, Metrics, Logs និង Tracing

## Observability ជាអ្វី?
Logs រៀបរាប់ event; metrics សង្ខេបលេខតាមពេល; traces បង្ហាញ request path រវាង services។ ទាំងបីជួយឆ្លើយសំណួរផ្សេងគ្នា។ Health check បង្ហាញថាសេវាអាចទទួល traffic ឬពឹង dependency សំខាន់បានឬទេ។

## Actuator
Spring Boot Actuator ផ្តល់ endpoints និង integration សម្រាប់ health, metrics, info និង management។ ដាក់ Actuator dependency ហើយ expose តែ endpoints ដែលត្រូវការ។ កុំ expose env/config/heapdump/metrics detail ទៅ public network ដោយមិនការពារ។

~~~yaml
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics
~~~

ការកំណត់ពិតត្រូវគ្នានឹង Boot version និង deployment។ Health endpoint មាន liveness/readiness semantics; កុំដាក់ dependency ទាំងអស់ក្នុង liveness ប្រសិនបើ database outage នឹងធ្វើឱ្យ orchestration restart instances ជារង្វង់។

## Metrics
ប្រើ Micrometer meter ដែលមាន bounded tag cardinality។ កុំដាក់ user ID, request ID ឬ URL មាន arbitrary path ជា tag ព្រោះ cardinality អាចផ្ទុះ memory/storage។ Metrics មិនគួរមាន sensitive label។ វាស់ request count, error, latency, DB pool, JVM heap/GC និង queue depth តាម use case។

## Logs
ប្រើ structured logs មាន timestamp, level, service/version និង correlation/trace ID។ កុំ log password, bearer token, session ID ឬ body មាន personal data។ កំណត់ retention/access និង sanitize newline/control characters ដើម្បីទប់ log injection។

## Tracing
Trace context ភ្ជាប់ spans ឆ្លង service call។ Instrumentation អាចមកពី Micrometer Tracing/OpenTelemetry តាម ecosystem/version។ Sampling មាន trade-off cost/coverage; error traces គួរមានប្រូបាបខ្ពស់ជាងសម្រាប់រកបញ្ហាតាម policy។

## លំហាត់
1. បើក health/info តែក្នុង local app។
2. បន្ថែម metric ដែលមាន tags cardinality ទាប។
3. សរសេរ log example ដែលមិនបញ្ចូល token/user password។
4. រចនា liveness/readiness សម្រាប់ app ដែលពឹង DB។
