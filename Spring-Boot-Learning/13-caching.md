# Spring Boot មេរៀនទី ១៣៖ Caching និង Consistency

## Cache ជាអ្វី?
Cache រក្សាច្បាប់ចម្លងទិន្នន័យដែលទាញមកវិញងាយ/លឿន ដើម្បីកាត់ latency ឬ load។ Cache មិនមែន source of truth ជាធម្មតាទេ ហើយបង្កបញ្ហា consistency, eviction និង stale data។

## Spring Cache abstraction
@EnableCaching បើក annotation-driven caching។ @Cacheable អាច cache result តាម key; @CacheEvict លុប entry; @CachePut update cache តែបន្តឱ្យ method ដំណើរការ។

~~~java
@Cacheable(cacheNames = "books", key = "#id")
public BookDto findBook(long id) {
    return repository.findDtoById(id)
        .orElseThrow(() -> new BookNotFoundException(id));
}
~~~

Cache provider/backend ត្រូវបាន configure ផ្សេងគ្នា។ Simple in-memory cache មិនចែករំលែករវាង application instances ទេ។ កុំ cache method result មាន user-specific data ដោយ key មិនបញ្ចូល tenant/user context។

## Key, TTL និង invalidation
ជ្រើស key ដែលតំណាង input ទាំងអស់ដែលប៉ះ output។ កំណត់ TTL/size/eviction ដើម្បីកុំឱ្យ memory កើនគ្មានដែន។ Invalidation ពេល write ជាការលំបាកធម្មតា; កំណត់ behavior នៅ update/delete និង concurrent requests។ Cache stampede អាចកើតពេល entries ផុតកំណត់พร้อมគ្នា។

## Proxy limitations
Annotation caching ជាញឹកញាប់អនុវត្តតាម proxy; self-invocation ក្នុង bean ដដែលអាចមិន intercept method។ private/final method មាន limitations អាស្រ័យលើ proxy type។ ត្រូវ test behavior តាម runtime configuration មិនមើល annotation តែប៉ុណ្ណោះ។

## Security និង observability
កុំ cache credential ឬ response private ទៅ shared key space ដោយមិនបែងចែក scope។ វាស់ hit/miss, size, eviction និង stale behavior។ បើ cache ដាច់ app ត្រូវមាន fallback និង load protection; កុំឱ្យ cache outage បញ្ជូន load ចូល DB ទាំងអស់ក្នុងពេលតែមួយ។

## លំហាត់
1. ជ្រើស read-only endpoint មួយសម្រាប់ cache ហើយកំណត់ key/TTL។
2. បញ្ជាក់ invalidation នៅ create/update/delete។
3. សាកល្បងថា user A មិនទទួល cached data របស់ user B។
