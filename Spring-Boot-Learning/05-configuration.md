# Spring Boot មេរៀនទី ៥៖ Configuration, Profiles និង Secrets

## Externalized configuration
កំណត់ properties ដាច់ពី source ដើម្បីឱ្យ artifact ដូចគ្នាអាចដំណើរការក្នុង local/test/prod ជាមួយ config ផ្សេង។ Spring Boot អាន properties ពី sources ច្រើន ដូចជា command line, environment variables និង config files តាម precedence របស់វា។ ពិនិត្យ precedence ក្នុង docs មិនសន្មតថា file ណាឈ្នះ។

## application.yaml

~~~yaml
server:
  port: 8080

app:
  page-size: 20
~~~

អាន config ដោយ @ConfigurationProperties class ជំនួស @Value ច្រើនកន្លែង ដើម្បីបាន type-safe binding និង validation។ កុំដាក់ password/token ក្នុង YAML ដែល commit ទៅ repo។

## Profiles
Profile ជួយបែងចែក config/beans តាម environment ឧ. local, test, prod។ Profile មិនមែនជា security boundary; user អាចកំណត់ profile ផ្សេង។ កុំដាក់ secret ឬ debug endpoint ដោយសារគិតថា profile production នឹងមិនត្រូវ activate ខុស។

## Secrets
ក្នុង local development ប្រើ environment injection ឬ secret store; production ប្រើ platform secret manager។ កុំបង្ហាញ secret ពេល log config, error message ឬ actuator env endpoint។ កំណត់ least privilege, rotation និងចូលប្រើតាម identity។ បើ secret បាន commit ទៅ git ត្រូវ rotate វា; លុប commit មិនធ្វើឱ្យវាមិនទាន់ត្រូវបានប៉ះពាល់ទេ។

## Configuration validation
បញ្ជាក់ required properties និង ranges ដូចជា timeout > 0, pool size មានដែនកំណត់។ Fail fast ពេល startup ប្រសើរជាងដំណើរការដោយ config ខុស ហើយបរាជ័យពេលមាន request។

## លំហាត់
1. បង្កើត AppProperties មាន timeout និង max-page-size។
2. បង្ក config local និង production ដោយគ្មាន credential ក្នុង Git។
3. បង្ហាញថាតម្លៃ environment variable អាច override config file តាម precedence។
4. រៀបចំវិធី rotate secret និងផ្ទៀងផ្ទាត់ថា logs មិនបង្ហាញវា។

ឯកសារយោង៖ [Spring Boot Externalized Configuration](https://docs.spring.io/spring-boot/reference/features/external-config.html)
