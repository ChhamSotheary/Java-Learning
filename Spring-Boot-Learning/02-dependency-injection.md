# Spring Boot មេរៀនទី ២៖ Spring Container និង Dependency Injection

## គំនិត
Spring IoC container បង្កើត និងគ្រប់គ្រង objects ដែលហៅថា beans។ Dependency injection (DI) មានន័យថា class ប្រកាស dependency ដែលខ្លួនត្រូវការ ហើយ container ផ្គត់ផ្គង់វា។ វាជំនួស class បង្កើត dependency ដោយខ្លួនឯងគ្រប់កន្លែង ហើយជួយដាច់ coupling និង test។

## Constructor injection
~~~java
@Service
public class GreetingService {
    private final Clock clock;

    public GreetingService(Clock clock) {
        this.clock = clock;
    }

    public String greet(String name) {
        return "សួស្តី " + name;
    }
}
~~~

Clock អាចផ្តល់ជា bean ដោយ @Bean ក្នុង @Configuration។ Constructor injection ធ្វើឱ្យ required dependency មើលឃើញ និង field អាច final បាន។ សម្រាប់ bean មាន constructor តែមួយ Spring ជាទូទៅអាចប្រើវាដោយមិនចាំបាច់ @Autowired។

## Bean registration
@Component, @Service, @Repository, @Controller/@RestController សម្គាល់ class សម្រាប់ component scanning។ @Bean ប្រើក្នុង @Configuration ដើម្បីបង្កើត object ពី library ឬកំណត់ object ដែលមិនអាច annotate class ផ្ទាល់។ Stereotype annotations ស្រដៀងគ្នាសម្រាប់ registration តែបញ្ជាក់តួនាទីឱ្យអ្នកអាន។

## Scope និង lifecycle
Singleton ជា scope default: container ផ្តល់ instance មួយក្នុង ApplicationContext មួយ។ Singleton មិនមានន័យថា class មាន static fields ទេ។ Bean singleton គួរតែ stateless ឬ thread-safe ព្រោះ request ច្រើនអាចប្រើវាជាន់គ្នា។ Prototype/request/session scopes មាន use case ផ្សេង និងត្រូវយល់ lifecycle មុនប្រើ។

## Circular dependency
A ត្រូវការ B ហើយ B ត្រូវការ A បង្ក circular dependency ដែលបង្ហាញថា boundary/design អាចមិនស្អាត។ កុំដោះស្រាយភ្លាមដោយ setter injection/lazy proxy; បំបែក service ឬបង្កើត orchestrator ដែលទទួល responsibility ត្រឹមត្រូវ។

## Testability
Constructor injection អនុញ្ញាតឱ្យ unit test បង្កើត service ជាមួយ fake Clock/Repository ដោយមិនចាប់ផ្តើម Spring context។ ប្រើ Spring test context ពេលត្រូវពិនិត្យ wiring ឬ integration behavior។

## លំហាត់
1. បង្កើត GreetingService និង Clock bean។
2. សរសេរ unit test ដោយ inject Clock fixed ដើម្បីឱ្យលទ្ធផល deterministic។
3. បង្កើត bean មួយដោយ @Bean និងមួយដោយ @Service; ប្រៀបធៀប។
4. ពន្យល់ហេតុអ្វី singleton mutable state អាចបង្ក race condition។

ឯកសារយោង៖ [Dependency Injection ក្នុង Spring Framework](https://docs.spring.io/spring-framework/reference/core/beans/dependencies/factory-collaborators.html)
