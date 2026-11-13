# Spring Boot មេរៀនទី ១៖ Project Setup និង Bootstrapping

## គោលបំណង
បង្កើត project ដែលអាច run, ស្គាល់ Maven/Gradle structure, យល់ពី starter និង auto-configuration ដោយមិនចាត់ទុក Boot ជា magic។

## ១. បង្កើត project
ប្រើ Spring Initializr ពី browser ឬ IDE។ ជ្រើស៖
- Java និង JDK ដែល version របស់ Spring Boot គាំទ្រ។
- Maven ឬ Gradle។
- Dependency Spring Web សម្រាប់ servlet MVC REST app។
- Test dependency ដែល starter project ផ្តល់។

Version number ផ្លាស់ប្តូរ; ប្រើ stable release តាម Spring Boot Reference នៅពេលបង្កើត។ កុំ copy version ចាស់ពី tutorial ដោយមិនពិនិត្យ compatibility។

## ២. រចនាសម្ព័ន្ធទូទៅ
- build file កំណត់ plugins, dependencies និង Java target។
- src/main/java មាន production code។
- src/main/resources មាន config/static resources។
- src/test/java មាន test code។
- main class មាន @SpringBootApplication និង main()។

~~~java
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
~~~

@SpringBootApplication ប្រមូល configuration, component scanning និង auto-configuration behavior ជាចម្បង។ Component scan ជាទូទៅចាប់ផ្តើមពី package របស់ main class; ដាក់ class ក្រោម root package ដូចគ្នា។

## ៣. Run និង package
~~~text
./mvnw spring-boot:run
./mvnw test
./mvnw package
java -jar target/demo-0.0.1-SNAPSHOT.jar
~~~

លើ Windows ប្រើ mvnw.cmd; Gradle ប្រើ gradlew/gradlew.bat។ Wrapper ធានាថាប្រើ build tool version របស់ project។

## ៤. Starter និង auto-configuration
Starter ជាកញ្ចប់ dependency ដែលសម្របសម្រួល library ជាញឹកញាប់។ Auto-configuration ពិនិត្យ classpath និង configuration រួចផ្តល់ bean defaults។ វាមិនបង្កើត feature ដោយមិនមាន dependency ឬ condition ទេ។ អ្នកអាច define bean ផ្ទាល់ ហើយ auto-config មួយចំនួន back off។ ប្រើ condition report/debug logs ពេលចង់ដឹងហេតុអ្វីបាន config មួយ។

## ៥. កំហុសដំបូងដែលជួបញឹកញាប់
- main class នៅ package ខុស ធ្វើឱ្យ component មិនត្រូវ scan។
- JDK មិនត្រូវនឹង Spring Boot release។
- dependency version ច្របល់ដោយមិនប្រើ Boot dependency management។
- port ដែលចង់ប្រើកំពុង occupied។
- application start បាន មិនមានន័យថា endpoint/database ត្រឹមត្រូវ។

## លំហាត់
1. បង្កើត project មាន Spring Web និង test starter។
2. រត់វា ហើយកត់ JDK/build tool/Boot version។
3. បង្កើត endpoint GET /hello ហើយសាកតាម browser/curl។
4. សរសេរថា auto-configuration អ្វីដែលអ្នកគិតថា Boot បានផ្គត់ផ្គង់ និងភស្តុតាងណាបញ្ជាក់។

ឯកសារយោង៖ [Spring Boot Reference](https://docs.spring.io/spring-boot/reference/)
