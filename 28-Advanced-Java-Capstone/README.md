# Capstone កម្រិតខ្ពស់៖ Java Service ពី Requirement ដល់ Production

## គោលដៅ
បង្កើតកម្មវិធី service មួយដែលអាចរក្សាទុកទិន្នន័យ, ទទួល network requests, មាន test, security model, observability និង deployment plan។ អ្នកអាចប្រើ Spring Boot ក្នុង track បន្ទាប់ ឬធ្វើ Java core service ផ្ទាល់ខ្លួន។

## ជំហាន
1. សរសេរ requirement, non-goals និង acceptance criteria។
2. រចនា domain model, API និង database schema។
3. បំបែក domain logic ពី I/O និង framework។
4. បន្ថែម validation, error model និង transaction boundaries។
5. សរសេរ unit, integration និង API tests។
6. បង្កើត authn/authz និង secret handling ផ្អែកលើ threat model។
7. បន្ថែម logs, metrics, health check និង tracing context។
8. វាស់ latency/throughput/memory; profile មុន optimize។
9. រៀបចំ package/deploy, configuration និង rollback។
10. សរសេរ README/runbook ហើយបង្ហាញ limitations។

## គម្រោងអាចជ្រើស
- Task management API
- Library inventory service
- Expense tracker
- Course registration system

## Rubric
- API និង validation មាន behavior ច្បាស់។
- DB updates មាន transaction និងគ្មាន SQL concatenation។
- Tests ពិនិត្យ positive, negative និង boundary cases។
- Secret មិននៅក្នុង repository និង logs មិនបង្ហាញ credential។
- Configuration ខុសគ្នារវាង local/test/production ដោយគ្មាន source edits។
- មាន health/metrics និង runbook សម្រាប់ failure។
- Performance claims មាន benchmark/profiling evidence។
