# មេរៀនទី ២៤៖ Java Security និង Secure Coding

## ១. Threat model មុន API
កំណត់ទិន្នន័យដែលការពារ, attacker capabilities, trust boundaries និងផលប៉ះពាល់។ បន្ទាប់មកជ្រើស control ដែលកាត់បន្ថយហានិភ័យ។ Security មិនមែនជាការបន្ថែម crypto ដោយចៃដន្យទេ។

## ២. Input និង injection
Validate input តាម allowlist និង business rules នៅ boundary។ ប្រើ PreparedStatement សម្រាប់ SQL និង URI/HTTP APIs ដែល encode parameter ត្រឹមត្រូវ។ កុំ concatenate user input ជា SQL, shell command ឬ filesystem path។ Encode output តាម context ដើម្បីទប់ injection ក្នុង HTML/JSON/log។

## ៣. Secret និង password
កុំដាក់ secret ក្នុង source, repo, test fixture ឬ log។ ផ្ទុកក្នុង secret manager/environment injection ហើយកំណត់ rotation/access policy។ Password មិនត្រូវ encrypt reversibly សម្រាប់ login; ប្រើ password hashing algorithm មាន salt និង work factor តាម library/security guidance បច្ចុប្បន្ន។ កុំបង្កើត hash algorithm ផ្ទាល់ខ្លួន។

## ៤. Cryptography
ប្រើ Java Cryptography Architecture និង vetted library/standard algorithm។ ជៀស algorithm ផុតសម័យ ឬ mode ដែលមិនបាន authenticate។ ត្រូវគ្រប់គ្រង key, randomness, nonce/IV និង certificate validation ឱ្យត្រឹម។ Crypto API ខុសតិចតួចអាចបំផ្លាញការការពារទាំងមូល; អនុវត្តតាមអ្នកជំនាញ security សម្រាប់ production។

## ៥. Deserialization និង dependencies
កុំ deserialize object ពី source មិនទុកចិត្តដោយសេរី។ កំណត់ type allowlist ឬប្រើ data format ដែល schema ច្បាស់។ តាមដាន dependency vulnerabilities, update JDK/framework, pin versions និងពិនិត្យ artifact provenance។

## ៦. Least privilege និង error handling
ដំណើរការ app ដោយ user ដែលមានសិទ្ធិអប្បបរមា។ Error response មិនគួរបញ្ចេញ stack trace, SQL, secret ឬ internal path។ Log ត្រូវ sanitize input ដើម្បីកុំឱ្យ log injection។

## លំហាត់
1. សរសេរ threat model សម្រាប់ CLI app ដែលអាន file និង DB។
2. រកចំណុចក្នុង code ដែល user input អាចចូល SQL/path/shell។
3. បង្កើត checklist សម្រាប់ secret, dependency update, logging និង error responses។
