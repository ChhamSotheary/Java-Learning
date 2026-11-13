# Spring Boot មេរៀនទី ១២៖ API Documentation និង Versioning

## Contract ជាអ្វី?
API contract បញ្ជាក់ path, HTTP method, request/response schema, status codes, validation, authentication និង error behavior។ Contract ច្បាស់ជួយ client និង server អភិវឌ្ឍដោយស្របគ្នា។ OpenAPI ជា format ពិពណ៌នា API ដែលអាច generate docs/client បាន។

## Documentation
ប្រើ Springdoc ឬ tooling ដែលគាំទ្រ Spring Boot version របស់ project។ បង្កើត OpenAPI spec ពី annotations/code ឬ maintain spec-first តាមក្រុម។ កុំឱ្យ documentation បង្ហាញ internal DTO/entity ឬ private endpoints។ ពិនិត្យ generated schema ថា enum/nullability/validation/status ត្រូវគ្នា។

## API compatibility
បន្ថែម optional field ជាទូទៅងាយ backward-compatible ជាង rename/remove field។ ប្តូរ meaning, enum value ឬ validation rule ក៏អាចបំបែក client ទោះ schema មិនផ្លាស់ក៏ដោយ។ Versioning អាចប្រើ URI, header ឬ media type; គ្មានវិធីមួយល្អសម្រាប់គ្រប់ប្រព័ន្ធទេ។ កំណត់ deprecation window និង migration instructions។

## Pagination, filtering, sorting
កំណត់ maximum page size និង allowlist sort fields។ API មិនគួរអនុញ្ញាត query arbitrary fields/sort ដែលបង្ក expensive database query។ Pagination response គួរបង្ហាញ metadata តាមតម្រូវការ និងគិតពី dataset ដែលកំពុងផ្លាស់ប្តូរ។

## Error schema
ប្រើ format ស្ថិរភាព ដើម្បី client អាចបកស្រាយ code/field errors/correlation ID។ កុំបញ្ចេញ stack trace ឬ SQL។ Documentation បញ្ជាក់ 400/401/403/404/409/429/5xx តាម endpoint។

## លំហាត់
1. សរសេរ contract សម្រាប់ POST /orders: request, response, statuses, errors។
2. កំណត់ថាតើការដក field មួយចេញមានផលប៉ះពាល់អ្វីដល់ client ចាស់។
3. សរសេរ deprecation/migration strategy។
