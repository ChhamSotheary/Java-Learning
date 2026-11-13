# Spring Boot មេរៀនទី ៣៖ REST Controller និង HTTP

## Request flow
HTTP request ចូល embedded servlet container → Spring Security filters (បើមាន) → DispatcherServlet → handler mapping ជ្រើស controller method → argument resolvers បង្កើត parameter → controller/service ដំណើរការ → message converter serialize response ជា JSON → HTTP response ត្រឡប់។

## Controller
~~~java
@RestController
@RequestMapping("/api/books")
public class BookController {
    @GetMapping("/{id}")
    public BookResponse getOne(@PathVariable long id) {
        return new BookResponse(id, "Java");
    }

    @GetMapping
    public List<BookResponse> search(
            @RequestParam(required = false) String title) {
        return List.of(new BookResponse(1, title == null ? "Java" : title));
    }
}
record BookResponse(long id, String title) {}
~~~

@RestController បញ្ជាក់ថា return value ជា response body ជាទូទៅ JSON តាម message converter។ @PathVariable ទាញ path segment; @RequestParam ទាញ query parameter; @RequestBody អាន body។

## HTTP methods/status
GET អាន, POST បង្កើត, PUT ជំនួស resource, PATCH កែផ្នែកខ្លះ, DELETE លុប។ ជ្រើស status ត្រឹមត្រូវ៖ 200 OK, 201 Created (អាចមាន Location), 204 No Content, 400 invalid input, 404 missing, 409 conflict។ Status មិនមែន decoration; client ប្រើវាសម្រេចការបន្ត។

## Controller មិនគួរផ្ទុក business logic ទាំងអស់
Controller គួរបម្លែង HTTP input/output និងហៅ service។ Service គ្រប់គ្រង use case; repository/data access គ្រប់គ្រង persistence។ Layering មិនមែនច្បាប់ថាត្រូវមាន class មួយរាល់ CRUD ទេ; ប្រើពេលវាបំបែក responsibility។

## Idempotency
GET គួរមិនបង្ក side effects។ PUT ត្រូវបានរចនាឱ្យ idempotent តាម semantics; POST ជាទូទៅមិន idempotent ដោយស្វ័យប្រវត្តិ។ Network retry អាចបង្ក duplicate creation/payment; API មាន side effect គួរពិចារណា idempotency key និង deduplication។

## សាក API
ប្រើ curl/Postman/HTTP client លើ local app។ សាក method, path, query, headers, JSON body, status និង malformed input។ កុំដាក់ secret ក្នុង request collection ដែល commit សាធារណៈ។

## លំហាត់
1. បង្កើត GET /api/books/{id} និង GET /api/books?title=...
2. បង្កើត POST endpoint ដែលទទួល DTO ហើយត្រឡប់ 201។
3. សរសេរ test matrix សម្រាប់ 200, 201, 400 និង 404។
4. ពន្យល់ request flow តាមជំហាន។

ឯកសារយោង៖ [Spring Boot Servlet Web Applications](https://docs.spring.io/spring-boot/reference/web/servlet.html)
