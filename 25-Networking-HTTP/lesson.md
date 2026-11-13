# មេរៀនទី ២៥៖ Networking និង HTTP Client ក្នុង Java

## ១. TCP socket និង HTTP
Java network APIs អនុញ្ញាតឱ្យកម្មវិធីភ្ជាប់ remote services។ TCP ផ្តល់ byte stream ដែលមានលំដាប់ ប៉ុន្តែមិនផ្តល់ message boundaries ដោយខ្លួនឯង។ HTTP កំណត់ request/response semantics លើ transport។ កម្មវិធីត្រូវគ្រប់គ្រង timeout, error status, retry និង resource limits។

## ២. Java HttpClient

~~~java
var client = java.net.http.HttpClient.newBuilder()
    .connectTimeout(java.time.Duration.ofSeconds(3))
    .build();

var request = java.net.http.HttpRequest.newBuilder()
    .uri(java.net.URI.create("https://example.com"))
    .timeout(java.time.Duration.ofSeconds(5))
    .GET()
    .build();

var response = client.send(request,
    java.net.http.HttpResponse.BodyHandlers.ofString());
System.out.println(response.statusCode());
~~~

HttpClient មាននៅ Java 11+។ Example បង្ហាញ status តែ application ត្រូវពិនិត្យ 2xx/4xx/5xx និងកំណត់ response size/body handling តាម use case។

## ៣. Timeout និង retry
Connect timeout និង per-request timeout ជួយកុំឱ្យ resource ត្រូវបានកាន់រហូត។ Retry គួរតែ bounded, មាន backoff/jitter និងតែសម្រាប់ operation ដែលអាច retry ដោយសុវត្ថិភាព។ POST/charge operation អាចបង្ក duplicate side effect បើ retry ដោយគ្មាន idempotency strategy។

## ៤. TLS និង trust
ប្រើ HTTPS និងកុំបិទ certificate verification ដើម្បីជៀស error។ TLS បញ្ជាក់ channel security តែ app នៅតែត្រូវ validate server identity, protect secrets និង handle data safely។

## ៥. លំហាត់
1. បន្ថែម connect/request timeout ទៅ client។
2. ពិនិត្យ status code និងបង្ហាញ message សមស្របសម្រាប់ 2xx, 4xx, 5xx។
3. ពន្យល់ហេតុអ្វី retry POST អាចបង្កការប្រតិបត្តិពីរដង។
