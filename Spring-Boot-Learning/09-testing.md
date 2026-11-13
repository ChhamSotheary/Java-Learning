# Spring Boot មេរៀនទី ៩៖ Testing Strategy

## កម្រិត test
- Unit test ពិនិត្យ pure business logic ដោយមិនចាប់ Spring context។
- Slice test ពិនិត្យផ្នែក framework មួយ ដូចជា MVC controller ឬ repository។
- Integration test ចាប់ application context និង dependencies ពិត/ test containers តាមគោលបំណង។
- End-to-end test ពិនិត្យ user flow ពេញ ប៉ុន្តែចំណាយពេល និងថែទាំខ្ពស់។

## Unit test service
ប្រើ constructor injection ដើម្បីបង្កើត service ជាមួយ fake/mock repository។ បញ្ជាក់ behavior និង edge case ដូចជា not found, duplicate, invalid state។ Avoid verifying internal method call ប្រសិនបើ output behavior ជាចំណុចសំខាន់។

## MVC slice test
@WebMvcTest ជាទូទៅសាក controller + MVC infrastructure ដោយមិនចាប់ database ទាំងមូល។ Mock service dependency ហើយពិនិត្យ status, JSON body, validation និង error schema។ Spring Boot version ថ្មីអាចប្តូរ testing annotation/dependency; ប្រើ docs version ត្រូវគ្នា។

## Integration test
@SpringBootTest ចាប់ context ច្រើនជាង ហើយអាចសាក configuration, bean wiring, database integration។ ប្រើ database test ជាក់ស្តែងដូច Testcontainers ពេលត្រូវ verify SQL behavior; in-memory DB ខុសគ្នាពី PostgreSQL/MySQL ហើយអាចលាក់ bug។ កុំ share state រវាង test ឱ្យមិន deterministic។

## Test data និង secrets
ប្រើ fixture test បង្កើតទិន្នន័យដែលអាចធ្វើឡើងវិញ។ កុំប្រើ production snapshot មាន personal data ដោយមិន anonymize/authorize។ Test credential ត្រូវ fake និងមានសិទ្ធិតិច។

## លំហាត់
1. Unit test service សម្រាប់ happy path និង not-found។
2. MVC test POST invalid DTO ឱ្យបាន 400។
3. Integration test repository ជាមួយ database container ឬ local test DB។
4. សរសេរថា test មួយណាអ្នកនឹងប្រើសម្រាប់ bug query N+1 និងមូលហេតុ។
