# Spring Boot មេរៀនទី ១១៖ OAuth 2.0 និង JWT Resource Server

## Roles និង flow
OAuth 2.0 បំបែក resource owner, client, authorization server និង resource server។ JWT ជា format token មួយ; OAuth មិនមែនមានន័យថា JWT ជានិច្ចទេ។ Spring Boot API ជាច្រើនធ្វើជា Resource Server ដែល validate bearer access token ពី trusted issuer; កុំបង្កើត authorization server ឬ JWT signing design ផ្ទាល់ដោយមិនមានតម្រូវការ។

## Resource server validation
បន្ថែម Spring Security OAuth2 Resource Server dependency តាម Boot/Security docs។ Configuration ជាទូទៅកំណត់ issuer URI ឬ JWK Set URI; framework អាច validate signature, issuer, timestamps និង map scopes ទៅ authorities តាម configuration។ កុំទទួល token ដែល signature មិនបាន verify ឬ accept issuer ណាក៏បាន។

## Claims និង authorization
JWT header/payload អាច base64url-decode បាន; វាមិន encrypted ដោយ default ទេ។ កុំដាក់ password, secret ឬទិន្នន័យរសើបក្នុង claims។ ពិនិត្យ exp, iss, aud និង scope/role តាម trust contract។ Authorization ត្រូវសម្រេចពី claim ដែល issuer ទុកចិត្ត និង policy របស់ API។

## Key rotation និង revocation
JWK set អនុញ្ញាត key identifiers/rotation, តែ cache និង rollout ត្រូវយល់។ JWT stateless អាចពិបាក revoke មុន expiry; access token ខ្លី, token revocation/denylist ឬ introspection មាន trade-offs។ កុំសន្មតថា logout លុប JWT ដែលចម្លងទៅកន្លែងផ្សេង។

## Browser និង bearer token
រក្សា token ដោយប្រុងប្រយ័ត្ន; XSS អាចលួច token ដែល browser JavaScript ចូលដល់។ Cookie-based sessions មាន CSRF considerations; bearer header មាន storage/leak concerns។ ជ្រើសដោយ threat model, មិនចម្លង architecture មួយសម្រាប់គ្រប់ app។

## លំហាត់
1. គូរ OAuth roles និង token flow សម្រាប់ mobile client → API។
2. សរសេរ claims ដែល API ត្រូវពិនិត្យ និងហេតុផល។
3. រាយហានិភ័យនៃការបញ្ចូល secret ក្នុង JWT payload។
4. សាក API ដោយ expired/invalid issuer token ក្នុង test environment។
