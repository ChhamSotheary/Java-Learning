# Spring Boot មេរៀនទី ៧៖ Transaction និង Data Modeling

## Transaction ជាអ្វី?
Transaction គឺជាក្រុម database operations ដែលចង់ឱ្យ commit ជាមួយគ្នា ឬ rollback ជាមួយគ្នា។ គិតពីការកាត់លុយពីគណនី A និងបន្ថែមទៅ B៖ បើបានកាត់ A ប៉ុន្តែបន្ថែម B មិនបាន នោះទិន្នន័យមិនស្របគ្នា។ Transaction ជួយរក្សា invariant នេះ។

## @Transactional
Spring អាចគ្រប់គ្រង transaction តាម proxy។ ដាក់ @Transactional លើ service method ដែលកំណត់ business operation មួយ ជាទូទៅល្អជាងដាក់លើ controller/repository គ្រប់ទីកន្លែង។

~~~java
@Service
public class TransferService {
    private final AccountRepository accounts;

    public TransferService(AccountRepository accounts) {
        this.accounts = accounts;
    }

    @Transactional
    public void transfer(long fromId, long toId, BigDecimal amount) {
        // validate amount and accounts
        // debit source and credit target
    }
}
~~~

នេះគ្រាន់តែបង្ហាញ transaction boundary។ ត្រូវមាន validation, lock/concurrency strategy និង repository operations ពិត។ Spring transaction គ្រប់គ្រងការចាប់ផ្តើម/commit/rollback តាម proxy; self-invocation (method ក្នុង object ហៅ method @Transactional ក្នុង object ដដែល) អាចមិនឆ្លង proxy ហើយមិនមាន behavior ដែលរំពឹង។

## Rollback rules
តាម default ទូទៅ runtime exceptions និង errors trigger rollback; checked exception behavior អាចត្រូវកំណត់។ ពិនិត្យ version និង rollbackFor configuration។ កុំ catch exception ក្នុង method ហើយ return success ដោយគិតថា Spring នឹងដឹងថាត្រូវ rollback។ បើចង់បន្តក្រោយ error ត្រូវកំណត់ rollback semantics ដោយចេតនា។

## Isolation និង locking
Database isolation level កំណត់អ្វីដែល transaction មើលឃើញពេល concurrent updates។ ការប្រើ isolation ខ្ពស់អាចបង្ក lock/wait/deadlock។ Optimistic locking ដោយ version column រក conflict នៅ update; pessimistic lock អាចចាក់សោ row។ ជ្រើសតាម invariant និង load test មិនមែនតាមចំណូលចិត្តទេ។

## Boundary រវាង DB និង external calls
កុំកាន់ DB transaction យូរពេលហៅ remote API។ Network call អាចយឺត ខណៈ lock/connection នៅតែត្រូវកាន់។ សម្រាប់ workflow ឆ្លងប្រព័ន្ធ សិក្សា outbox/saga និង idempotency ជំនួសការសន្មត distributed transaction មានសុវត្ថិភាព។

## លំហាត់
1. សរសេរ transaction សម្រាប់កែ inventory និងបង្ក order ជាមួយគ្នា។
2. បង្ក simulation ដែលជំហានទីពីរបរាជ័យ ហើយកំណត់ rollback behavior។
3. ពន្យល់ self-invocation និងរបៀបរចនា service boundaries ដើម្បីជៀស។
