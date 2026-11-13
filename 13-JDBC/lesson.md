# មេរៀនទី ១៣៖ Database Programming ជាមួយ JDBC

## គោលបំណង
យល់ពី JDBC driver, connection, PreparedStatement, ResultSet, transaction, resource cleanup និងការការពារ SQL injection/secret leak។

## ១. ផ្នែកដែលពាក់ព័ន្ធ
JDBC ជា API ក្នុង JDK; database vendor ឬ driver provider ផ្តល់ JDBC driver ជាក់លាក់។ កម្មវិធីបង្កើត Connection តាម JDBC URL, បញ្ជូន SQL តាម Statement/PreparedStatement ហើយអាន ResultSet។ ត្រូវបន្ថែម driver dependency ទៅ build tool; URL និង SQL syntax ខុសតាម database។

## ២. Query ដោយ PreparedStatement

~~~java
String sql = "SELECT id, name FROM students WHERE id = ?";
try (Connection connection = DriverManager.getConnection(url, user, password);
     PreparedStatement statement = connection.prepareStatement(sql)) {
    statement.setInt(1, studentId);
    try (ResultSet result = statement.executeQuery()) {
        while (result.next()) {
            long id = result.getLong("id");
            String name = result.getString("name");
            System.out.println(id + " " + name);
        }
    }
}
~~~

Placeholder ? សម្រាប់ value parameters មិនមែនឈ្មោះ table/column ឬ SQL keyword ទេ។ ប្រសិនបើត្រូវជ្រើស sort column ត្រូវប្រើ allowlist របស់កម្មវិធី មិនយក input ទៅ concatenate។

## ៣. CRUD
- SELECT ប្រើ executeQuery ហើយទទួល ResultSet។
- INSERT/UPDATE/DELETE ប្រើ executeUpdate ដែលត្រឡប់ចំនួន rows ប៉ះពាល់។
- ត្រួតពិនិត្យចំនួន rows និង constraint; កុំសន្មតថា update បានមួយ row ជានិច្ច។

## ៤. Transaction
Transaction រួមបញ្ចូលការងារជាច្រើនឱ្យ commit ជាក្រុម។ ពេលមាន failure ត្រូវ rollback ដើម្បីជៀស partial state។

~~~java
connection.setAutoCommit(false);
try {
    // run related prepared statements
    connection.commit();
} catch (SQLException exception) {
    connection.rollback();
    throw exception;
}
~~~

ក្នុង application ពិត ការគ្រប់គ្រង transaction អាចធ្វើដោយ framework; កុំបើក transaction យូរពេក ព្រោះវាចាក់ lock និងកាន់ connection។ រៀន ACID និង isolation levels មុនរចនា concurrent updates។

## ៥. SQL Injection និង Secret
ការបញ្ចូល text ត្រង់ទៅ SQL អាចប្ដូរអត្ថន័យ query។ PreparedStatement ចង value ជា data។ កុំដាក់ DB password ក្នុង source, Git, README ឬ log។ ប្រើ env/secret manager ក្នុង lab/production តាម deployment; ផ្តល់ least-privilege database user និងបិទ DB port ដែលមិនត្រូវការចេញក្រៅ។

## ៦. Resource និង connection pooling
Connection, Statement, ResultSet ត្រូវបិទ។ try-with-resources គ្រប់គ្រងវា។ Server app ជាទូទៅប្រើ DataSource/connection pool ជំនួសការបើក connection ថ្មីសម្រាប់រាល់ request។ Pool size គួរត្រូវគ្នានឹង DB capacity និង request concurrency; pool ធំពេកអាចធ្វើឱ្យ DB overload។

## ៧. លំហាត់
ធ្វើ [exercise.md](exercise.md)។ មេរៀនបង្ហាញ API ស្តង់ដារ; ដើម្បី run ពិត ត្រូវបន្ថែម driver និង test database ផ្ទាល់ខ្លួន។
