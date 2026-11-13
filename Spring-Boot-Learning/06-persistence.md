# Spring Boot មេរៀនទី ៦៖ SQL, JPA និង Repository

## ជ្រើស data access style
Spring Boot អាចប្រើ JdbcClient/JdbcTemplate, JPA/Hibernate ឬ Spring Data repositories។ JDBC បង្ហាញ SQL និង control ច្រើន; JPA map object ទៅ relational tables និងគ្រប់គ្រង persistence context; repository abstraction កាត់ boilerplate ប៉ុន្តែមិនធ្វើឱ្យ SQL, transaction ឬ query cost បាត់ទៅទេ។

## Entity និង Repository
~~~java
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    protected Book() { }

    public Book(String title) {
        this.title = title;
    }
    public Long getId() { return id; }
    public String getTitle() { return title; }
}

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);
}
~~~

Entity មាន constructor គ្មាន argument តាមតម្រូវការរបស់ provider។ កុំបង្ហាញ entity ទៅ API; map ទៅ DTO។ Naming conventions អាច generate query ប៉ុន្តែ complex queries គួរមើល SQL ដែលបង្កើត និង query plan។

## Schema និង migration
សម្រាប់ learning/test អាចប្រើ in-memory database។ Production schema គួរគ្រប់គ្រងដោយ Flyway/Liquibase migration ដែល versioned; កុំឱ្យ Hibernate update production schema ដោយស្វ័យប្រវត្តិដោយគ្មាន change review។

## Transaction និង lazy loading
JPA entity អាចមាន relationships និង lazy loading។ ការចូល property ក្រោយ transaction/context បិទអាចបរាជ័យ; ការទាញទំនាក់ទំនងដោយមិនគិតអាចបង្ក N+1 queries។ បង្កើត DTO projection/query តាម use case ហើយ inspect SQL/metrics។

## Pagination និង sorting
កុំទាញ records ទាំងអស់មក memory សម្រាប់ table ធំ។ ប្រើ Pageable/Page ឬ slice/cursor design តាម dataset។ Validate page size និង sort fields ពី client ដោយ allowlist ដើម្បីការពារ expensive/unexpected query។

## លំហាត់
1. បង្ក Entity Book និង Repository។
2. បង្ក service ដែលអាន/រក្សាទុក ហើយ controller ត្រឡប់ DTO។
3. សាក pagination និងសង្កេត SQL។
4. ពន្យល់ lazy loading និង N+1 query។
5. កំណត់របៀប migration សម្រាប់ schema change។

ឯកសារយោង៖ [Spring Boot SQL Databases](https://docs.spring.io/spring-boot/reference/data/sql.html)
