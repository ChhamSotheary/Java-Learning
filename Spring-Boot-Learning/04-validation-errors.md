# Spring Boot មេរៀនទី ៤៖ DTO, Validation និង Error Handling

## ហេតុអ្វីប្រើ DTO?
កុំទទួល persistence entity ផ្ទាល់ជា request ហើយបញ្ជូនវាទៅ response ដោយស្វ័យប្រវត្តិ។ DTO កំណត់ public API និងបំបែក database schema ពី HTTP contract។ វាការពារការបង្ហាញ internal fields និងការកែ field ដែល client មិនគួរគ្រប់គ្រង។

## Validation
បន្ថែម Bean Validation dependency របស់ project រួច annotate request DTO៖

~~~java
public record CreateBookRequest(
    @NotBlank String title,
    @Min(1) int pageCount
) {}
~~~

ក្នុង controller ប្រើ @Valid ជាមួយ @RequestBody។ Validation បញ្ជាក់ format/range មូលដ្ឋាន; service នៅតែត្រូវអនុវត្ត business rules ដូចជា title duplicate ឬ user permission។

## Centralized error response
ប្រើ @RestControllerAdvice និង @ExceptionHandler ដើម្បីបម្លែង exception ទៅ error payload ស្ថិរភាព។ Error គួរមាន code/message/field errors/trace ID តាមតម្រូវការ ប៉ុន្តែមិនបង្ហាញ stack trace, SQL, secret ឬ filesystem path ទៅ client។ កំណត់ status ឱ្យសម៖ invalid payload 400, resource missing 404, state conflict 409។

## Validation vs sanitization
Validation ពិនិត្យថាទិន្នន័យស្របនឹង rule; escaping/encoding ប្រែតាម output context ដើម្បីកុំឱ្យទិន្នន័យបកស្រាយជាកូដ។ កុំសន្មតថា input ដែល valid សម្រាប់ database មានសុវត្ថិភាពសម្រាប់ HTML ឬ shell។

## Error boundary
កុំ catch Exception នៅ controller ទាំងអស់ហើយត្រឡប់ 200។ កុំបង្ក error response ផ្សេងគ្នាដែលបង្ហាញថា account មាន/មិនមាននៅ endpoint sensitive ប្រសិនបើវាបង្ក user enumeration។ Log exception នៅ layer មួយដែលមាន context គ្រប់គ្រាន់ ដោយលាក់ personal data។

## លំហាត់
1. បង្កើត CreateBookRequest មាន title, pageCount និង author។
2. បន្ថែម @Valid និងសាក body ត្រឹមត្រូវ/ខុស។
3. បង្ក error schema ដែលមាន code, message និង field errors។
4. សរសេរមុខងារដែលមិនត្រូវដាក់ក្នុង DTO validation ព្រោះវាជា business rule។

ឯកសារយោង៖ [Spring MVC validation/reference](https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-validation.html)
