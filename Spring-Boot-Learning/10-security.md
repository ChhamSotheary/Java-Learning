# Spring Boot មេរៀនទី ១០៖ Authentication និង Authorization

## ពាក្យសំខាន់
Authentication បញ្ជាក់ថា user/client ជានរណា។ Authorization សម្រេចថា identity នោះអាចធ្វើ action អ្វី។ ការមាន login មិនស្មើនឹង permission ត្រឹមត្រូវទេ។

## Spring Security filter chain
Spring Security ជាទូទៅដាក់ filter chain មុន MVC controller។ Filter អាចអាន credentials, បង្កើត Authentication និងរក្សា SecurityContext; បន្ទាប់មក authorization rules អនុញ្ញាត/បដិសេធ request។ ប្រសិនបើបង្ក SecurityFilterChain bean, Spring Boot auto config អាច back off ហើយអ្នកទទួលខុសត្រូវកំណត់ rules ដោយច្បាស់។

~~~java
@Bean
SecurityFilterChain appSecurity(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth -> auth
        .requestMatchers("/public/**").permitAll()
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .anyRequest().authenticated()
    );
    return http.build();
}
~~~

Syntax/API អាចខុសតាម Spring Security version; code នេះបង្ហាញគំនិត rules ordering។ បង្ក explicit policy សម្រាប់ routes ទាំងអស់; កុំទុក admin route ឱ្យចូលបានដោយចៃដន្យ។

## Session, CSRF និង CORS
Browser app ដែលប្រើ cookie/session ត្រូវយល់ CSRF protection; កុំបិទ CSRF តាមចម្លង tutorial API ដោយមិនវាយតម្លៃ client model។ CORS គ្រប់គ្រង browser cross-origin policy មិនមែន authentication ឬ authorization។ Allowlist origin ត្រឹមត្រូវ និងកុំប្រើ wildcard ជាមួយ credential។

## Password និង login
កុំរក្សាទុក plaintext password។ ប្រើ PasswordEncoder ដែលសមស្រប និង configured work factor; កុំបង្កើត hashing ផ្ទាល់ខ្លួន។ គ្រប់គ្រង rate limits, account recovery, session expiration និង audit events។ Error responses កុំបង្ហាញថា username មាន/មិនមាន ប្រសិនបើវាអាចបង្ក enumeration។

## Method authorization និង ownership
Route-level role មិនគ្រប់គ្រាន់សម្រាប់ resource ownership។ អ្នកប្រើធម្មតាអាច request object ID របស់អ្នកផ្សេង; service ត្រូវ validate owner/tenant។ បន្ថែម tests សម្រាប់ unauthenticated, insufficient role និង access to another user's resource។

## លំហាត់
បង្ក policy មាន public health endpoint, authenticated user endpoints និង admin-only route។ សរសេរ security test matrix ហើយបញ្ជាក់ CSRF/CORS decision តាម client type។
