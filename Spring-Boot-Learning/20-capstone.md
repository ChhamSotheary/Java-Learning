# Spring Boot មេរៀនទី ២០៖ Capstone REST Service

## គម្រោង
បង្កើត REST API សម្រាប់ task management ឬ library inventory។ ធ្វើជាដំណាក់កាល ហើយ commit ជាញឹកញាប់ក្នុង branch ផ្ទាល់ខ្លួន។

## Requirements
- CRUD API មាន DTO និង validation។
- SQL database ជាមួយ migration versioned។
- Service layer មាន transaction ត្រឹម use-case។
- Pagination/filter ដែលមាន bounds។
- Authentication និង authorization; user ម្នាក់មិនអាចអាន/កែ resource របស់អ្នកដទៃ។
- Unit, MVC/security, repository និង integration tests។
- Error response ស្ថិរភាព និងមិនបង្ហាញ internal details។
- Configuration/secrets ក្រៅ source control។
- Actuator health/metrics មាន exposure តិចបំផុត។
- Container/deployment instructions និង rollback plan។

## ដំណាក់កាល
1. សរសេរ requirement និង API contract មុន code។
2. បង្ក schema migration និង domain model។
3. បង្ក service/DTO/controller ហើយសាកល្បង flow មូលដ្ឋាន។
4. បន្ថែម validation/errors និង pagination។
5. បន្ថែម authn/authz និង tenant/ownership tests។
6. បន្ថែម integration tests ជាមួយ database សាកល្បង។
7. បន្ថែម observability, timeouts និង graceful shutdown។
8. Build image និងសរសេរ deploy/runbook។
9. ធ្វើ security review និង load-test ក្នុង environment ដែលអនុញ្ញាត។
10. សរសេរ README ជាមួយ decisions, trade-offs និង known limitations។

## ចំណុចដែលត្រូវបង្ហាញ
- Architecture diagram និង request flow។
- DB schema/migrations និង transaction boundary។
- Test report និងរបៀប run។
- Security threat model។
- Metrics/log/tracing examples ដែលលុប secret។
- Deployment/rollback runbook។
- Performance evidence និង limitation។

កុំ deploy public ឬប្រើទិន្នន័យពិតមុនមាន security review, backup និងការអនុម័តចាំបាច់។
