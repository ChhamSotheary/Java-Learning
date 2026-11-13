# Spring Boot មេរៀនទី ២១៖ WebFlux និង Reactive Programming

## Reactive គឺអ្វី?
Reactive programming ដំណើរការលើ asynchronous streams និង backpressure។ Spring WebFlux ផ្តល់ non-blocking web stack; វាអាចសមស្របសម្រាប់ workload ដែលមាន concurrent I/O ខ្ពស់ និង dependency stack ដែល non-blocking ពេញលេញ។

## Mono និង Flux
Mono តំណាងលទ្ធផល 0 ឬ 1; Flux តំណាងលទ្ធផល 0 ដល់ច្រើន។ Operator ដូច map/flatMap បង្កើត pipeline ដែលអាច subscribe និង signal async។

~~~java
@GetMapping("/{id}")
public Mono<BookDto> getBook(@PathVariable long id) {
    return bookService.findById(id);
}
~~~

## កុំលាយ blocking ដោយមិនគិត
ការហៅ JDBC/blocking file I/O ក្នុង event-loop thread អាចរារាំង requests ផ្សេងៗ។ ប្រើ reactive driver/client ពីចុងដល់ចុង ឬដាក់ blocking calls លើ scheduler ដាច់ដោយគ្រប់គ្រង capacity។ WebFlux មិនធ្វើឱ្យ code ណាក៏ non-blocking ដោយស្វ័យប្រវត្តិទេ។

## WebFlux ឬ MVC?
Spring MVC ជម្រើសល្អសម្រាប់ application blocking ធម្មតា និង ecosystem JDBC។ WebFlux សមពេល reactive flow/streaming និង non-blocking dependencies មានតម្លៃ។ កុំជ្រើសដោយសារគិតថា reactive តែងតែលឿនជាង; វាធ្វើឱ្យ debugging/context propagation កាន់តែស្មុគស្មាញផង។

## Backpressure និង error
Backpressure ជួយ consumer សុំទិន្នន័យតាមល្បឿនអាចទទួល។ Error handling ត្រូវដាក់ក្នុង reactive pipeline; try/catch ជុំវិញ method មិនចាប់ asynchronous error បន្ទាប់ពី return publisher។ តេស្ត cancellation, timeout និង client disconnect។

## លំហាត់
1. បង្ក endpoint Flux សម្រាប់ list និង Mono សម្រាប់ item។
2. កំណត់ថា data client របស់អ្នក blocking ឬ non-blocking។
3. ពន្យល់ហានិភ័យនៃការហៅ JDBC លើ event loop។
4. ប្រៀបធៀប MVC និង WebFlux ដោយ requirement មិនមែន benchmark ស្មាន។
