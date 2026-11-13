# មេរៀនទី ២៦៖ Java Modules, Annotations និង Reflection

## ១. JPMS modules
Java Platform Module System (JPMS) អនុញ្ញាត module ប្រកាស dependencies និង packages ដែល export។ module-info.java អាចមាន requires, exports, opens និង uses/provides។ Classpath នៅតែមានសម្រាប់ project ជាច្រើន; module path បន្ថែម encapsulation និង resolution rules។ កុំប្ដូរ project ទៅ modules ដោយគ្មានតម្រូវការ និងការយល់ពី library compatibility។

~~~java
module com.example.app {
    requires java.sql;
    exports com.example.api;
}
~~~

## ២. Annotations
Annotation ជា metadata ដែល compiler/tool/runtime អាចប្រើ។ Retention policy កំណត់ថា annotation មានត្រឹម source, class file ឬ runtime។ Annotation មួយមិនធ្វើអ្វីដោយខ្លួនឯងទេ; framework/processor ត្រូវអានវា។

## ៣. Reflection
Reflection អាច inspect class/method/field នៅ runtime និងហៅ method តាម metadata។ វាមានប្រយោជន៍សម្រាប់ framework, plugin និង tooling ប៉ុន្តែបង្ក coupling ទៅ implementation detail, type-safety ទាប និង startup/runtime overhead។ Strong encapsulation/module access អាចរារាំង reflective access ទៅ package ដែលមិនបាន open។

## ៤. Annotation processing
Annotation processor ដំណើរការក្នុង compile time ដើម្បីបង្កើត code ឬ validate declarations។ វាខុសពី runtime reflection។ Compile-time generation អាចផ្តល់ error លឿន និងចៀស reflective scanning ខ្លះៗ។

## ៥. ការរចនា
ប្រើ public interfaces/ServiceLoader សម្រាប់ plugin boundary ជំនួសការស្វែងរក class name តាម string ប្រសិនបើសម។ កុំអនុញ្ញាតឱ្យ input មិនទុកចិត្តកំណត់ class/method ដែល reflection នឹងហៅ។

## លំហាត់
1. បង្កើត module-info.java ដែល requires java.sql និង exports package api។
2. ពន្យល់ runtime retention ខុសពី source retention។
3. រាយ pros/cons របស់ reflection និងសរសេរជម្រើស compile-time ឬ interface-based។
