# មេរៀនទី ២១៖ JVM Internals — Bytecode, Class Loading និង JIT

## គោលដៅ
ពន្យល់ពីផ្លូវ source code → bytecode → class loading/linking/initialization → interpreter/JIT; ប្រើ tool ដើម្បី inspect class ដោយមិនសន្និដ្ឋានថា JVM មាន implementation តែមួយ។

## ១. Compile និង Bytecode
javac បម្លែង Java source ទៅ class files ដែលផ្ទុក bytecode និង metadata។ Bytecode ជា instruction set សម្រាប់ JVM, មិនមែន machine code របស់ CPU ជាក់លាក់ទេ។ JVM implementation អាចដំណើរការវាតាម interpreter ឬ compile ទៅ native code។

~~~java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
~~~

~~~text
javac Hello.java
javap -c -p Hello
java Hello
~~~

javap បង្ហាញ bytecode ដើម្បីសិក្សា។ កុំកែ class file ដោយដៃក្នុង project ពិត។

## ២. Class loading, linking, initialization
Class loader ស្វែងរក និង load class។ Linking រួមមាន verification, preparation និង resolution។ Initialization ដំណើរការ static initializers និង field initializers តាមលំដាប់ដែល JLS កំណត់។ ការប្រើ class ពី library អាច trigger load/initialize នៅពេលខុសគ្នា; static initialization ដែលធ្វើ network/file I/O ធ្វើឱ្យ startup ពិបាក troubleshoot។

## ៣. Class loader hierarchy
Bootstrap, platform និង application loaders ជាផ្នែកនៃ loader arrangement ក្នុង HotSpot/JDK។ Application servers និង plugin systems អាចបង្កើត classloader ផ្ទាល់។ Class identity មិនមែនគ្រាន់តែ class name ទេ—វាពាក់ព័ន្ធនឹង defining class loader។ ដូច្នេះ class ឈ្មោះដូចគ្នាពី loader ផ្សេងអាចមិនអាច cast គ្នាបាន។

## ៤. Interpreter និង JIT
JVM អាចចាប់ផ្តើមដោយបកស្រាយ bytecode ហើយ compile hot code paths ទៅ native code។ JIT ប្រើ profile feedback ដើម្បី optimize; assumptions អាចត្រូវ deoptimize បើអាកប្បកិរិយា runtime ប្រែ។ នេះជាមូលហេតុដែល microbenchmark ត្រូវ warmup និង tool សមស្រប។

## ៥. Inspect runtime
ប្រើ javap, java -version និង jcmd/jstack/jmap តាម JDK/environment។ Tool attach អាចមាន privilege/security constraints; ជ្រើស process ផ្ទាល់ខ្លួន។ Classpath/module path និង JDK vendor/version អាចប៉ះ behavior។

## លំហាត់
1. Compile class មួយ ហើយរក method bytecode ដោយ javap -c។
2. ពន្យល់ថា bytecode ខុសពី machine code ដូចម្តេច។
3. តើហេតុអ្វី class name ដូចគ្នាមិនធានាថា class identity ដូចគ្នា?
4. គូរដំណើរការ load → verify/link → initialize → execute។
