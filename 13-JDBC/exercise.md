# លំហាត់មេរៀនទី ១៣៖ JDBC

1. ពន្យល់តួនាទី JDBC driver និង connection URL។
2. សរសេរ SQL SELECT ដែលស្វែងរក student តាម id ដោយ placeholder។
3. សរសេរ PreparedStatement binding int parameter; កុំ concatenate input។
4. ពន្យល់ transaction, commit និង rollback។
5. រៀបរាប់វិធីរក្សា DB password ដោយមិនដាក់ក្នុង Git។
6. Challenge: ក្នុង local database ដែលអ្នកគ្រប់គ្រង បង្កើត transaction ផ្ទេរប្រាក់ពីគណនី A ទៅ B ដោយ rollback ប្រសិនបើជំហានណាមួយបរាជ័យ។

អនុវត្តលើ database សាកល្បងប៉ុណ្ណោះ។ មេរៀនមិនភ្ជាប់ driver ពិសេសទេ; សូមជ្រើស driver តាម database និងបន្ថែមតាម build tool របស់អ្នក។
