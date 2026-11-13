# មេរៀនទី ១៣៖ Database Programming ជាមួយ JDBC

JDBC ជា API ស្តង់ដាររបស់ Java សម្រាប់ទាក់ទង relational database។ ត្រូវការ JDBC driver របស់ database ដែលប្រើ ហើយបន្ថែមវាទៅ classpath/build configuration។ API មួយ មិនមានន័យថា driver ឬ SQL dialect ទាំងអស់ដូចគ្នាទេ។

## Connection និង PreparedStatement

~~~java
String url = System.getenv("DB_URL");
String user = System.getenv("DB_USER");
String password = System.getenv("DB_PASSWORD");

String sql = "SELECT id, name FROM students WHERE id = ?";
try (var connection = java.sql.DriverManager.getConnection(url, user, password);
     var statement = connection.prepareStatement(sql)) {
    statement.setInt(1, 1);
    try (var result = statement.executeQuery()) {
        while (result.next()) {
            System.out.println(result.getInt("id") + " " + result.getString("name"));
        }
    }
}
~~~

PreparedStatement បែងចែក SQL structure ពី parameter values ហើយជួយការពារការបញ្ចូល input ជា SQL code។ កុំបង្កើត query ដោយ concatenate user input។

## Transaction
Transaction រួមបញ្ចូលការងារច្រើនឱ្យ commit ជាក្រុម ឬ rollback ពេលមានបញ្ហា។ JDBC connection មាន auto-commit តាម default ជាទូទៅ; ការបិទវា និងគ្រប់គ្រង commit/rollback ត្រូវមានការប្រុងប្រយ័ត្ន។

## Secrets និង Database
កុំ hardcode password ក្នុង source ឬ commit វាទៅ GitHub។ ប្រើ environment/secret manager សម្រាប់ lab; production ត្រូវប្រើការគ្រប់គ្រង secret របស់ deployment។ កុំបង្ហាញ connection URL ដែលមាន credential ក្នុង log។

## លំហាត់
ធ្វើ [exercise.md](exercise.md)។ ព័ត៌មាន driver និង setup អាស្រ័យលើ database ដែលអ្នកជ្រើស។
