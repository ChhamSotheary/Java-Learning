# Spring Boot មេរៀនទី ១៩៖ Production Security Review

## Boundary ត្រូវពិនិត្យ
Review HTTP routes, authentication provider, authorization rules, resource ownership, CSRF/CORS, SQL access, file handling, deserialization, outbound HTTP, actuator endpoints, logs, secrets និង deployment permissions។

## Common failure modes
- endpoint ថ្មីមិនបានដាក់ authorization test។
- user authenticated អាចទាញ resource របស់ tenant ផ្សេងដោយប្តូរ ID។
- actuator/env ឬ debug page បង្ហាញ config។
- CORS wildcard ប្រើជាមួយ credential។
- HTTP client មិនកំណត់ timeout។
- request body size/file upload គ្មាន limit។
- log មាន token ឬ PII។
- DB user មាន privilege ខ្ពស់ពេក។
- dependency/JDK មិន update។

## Security tests
សម្រាប់ endpoint នីមួយៗ សាក unauthenticated, authenticated but insufficient authority, valid role, wrong tenant/owner, invalid input និង rate-limit behavior។ MockMvc/Spring Security test support អាចសាក request authorization; integration test ប្រើ test identity/provider តាមផ្លូវដែលសម។

## Secret, keys, rotation
ដឹងថា secret មកពីណា, អ្នកណាអាចអាន, រយៈពេលរស់ និងរបៀប rotate/revoke។ កុំចាត់ទុក environment variables ថាមានសុវត្ថិភាពដោយស្វ័យប្រវត្តិ; control process/host access និង exposure តាម diagnostic dump ផង។

## Security headers និង TLS
បង្ហោះពីក្រោយ TLS termination ត្រូវយល់ថា proxy/trusted headers ត្រូវ configure យ៉ាងណា។ កុំទុក app ទុកចិត្ត X-Forwarded-* ពី client ដោយគ្មាន trusted proxy allowlist។ Headers គួរត្រូវតាម client type និង deployment។

## លំហាត់
ធ្វើ checklist security review របស់ capstone ហើយបង្កើត issue សម្រាប់រាល់ finding មាន severity, evidence, remediation និង retest condition។
