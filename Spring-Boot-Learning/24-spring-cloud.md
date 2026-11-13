# Spring Boot មេរៀនទី ២៤៖ Microservices និង Spring Cloud

## មុនបំបែក services
Microservices បន្ថែម network failure, latency, versioning និង operational cost។ ចាប់ផ្តើមពី modular monolith ប្រសិនបើ ownership/team/deployment boundaries មិនទាន់ត្រូវការបំបែក។ Service boundary គួរផ្អែកលើ domain capability និង data ownership មិនមែនតាម table មួយៗ។

## Distributed system fundamentals
Service-to-service calls ត្រូវមាន timeout, bounded retry, authentication, versioned contract និង observability context។ Database មិនគួរត្រូវ shared schema ដោយគ្មាន ownership។ Cross-service business process អាចត្រូវ saga/outbox និង eventual consistency។

## Spring Cloud components
Spring Cloud មាន modules ដូច Config, Gateway, Circuit Breaker, Stream និង Kubernetes integrations។ ជ្រើសតែ component ដែលត្រូវការ ហើយផ្គូផ្គង release train ជាមួយ Spring Boot version តាម compatibility matrix ផ្លូវការ។ កុំប្រើ tutorial មួយដែលមិនបញ្ជាក់ version។

## Config និង discovery
Config server/service discovery មាន trade-offs ដូចជា bootstrap dependency, cache/stale state និង failure mode។ Cloud platform អាចផ្តល់ native DNS/discovery/config mechanisms ដែលធ្វើឱ្យ Spring Cloud component មិនចាំបាច់។

## Gateway
Gateway អាចធ្វើ routing, auth policy, rate limits និង request shaping។ វាមិនគួរផ្ទុក business logic ទាំងអស់ ឬក្លាយជា single point of failure។ ការផ្លាស់ប្តូរ routing/auth ត្រូវ test និង monitor។

## លំហាត់
1. គូរ modular monolith និង microservice decomposition សម្រាប់ order system។
2. បញ្ជាក់ data ownership និង cross-service consistency។
3. ជ្រើស Spring Cloud component មួយ ហើយផ្ទៀងផ្ទាត់ compatibility matrix។
4. សរសេរ failure modes ប្រសិនបើ config/discovery/gateway ដាច់។
