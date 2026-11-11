# Lesson 01: Introduction to Java

## 1. What is Java?

Java គឺជា Programming Language មួយដែលប្រើសម្រាប់បង្កើតកម្មវិធីកុំព្យូទ័រ គេហទំព័រ Backend កម្មវិធី Android និងប្រព័ន្ធធំៗជាច្រើន។

Java ត្រូវបានបង្កើតឡើងដោយក្រុមហ៊ុន Sun Microsystems ហើយបច្ចុប្បន្នត្រូវបានគ្រប់គ្រងដោយ Oracle។

**English:** Java is a high-level, class-based, object-oriented programming language.

## 2. Why learn Java?

- **Platform independent:** Java programs run on systems that have a compatible Java runtime.
- **Object-oriented:** Programs can be organized using classes and objects.
- **Strongly typed:** Variables have declared types.
- **Large ecosystem:** Java has many libraries, tools, and frameworks.
- **Widely used:** Java is used in backend services, business software, and Android development.

## 3. How does Java work?

Java source code is saved in a file ending with `.java`. The Java compiler converts it into bytecode in a `.class` file. The Java Virtual Machine (JVM) executes that bytecode.

The main parts are:

1. **JDK (Java Development Kit):** Tools for developing Java programs, including the compiler.
2. **JRE (Java Runtime Environment):** Runtime components needed to run Java applications. Modern JDK distributions include the runtime.
3. **JVM (Java Virtual Machine):** Executes Java bytecode.

## 4. Your first Java program

Create a file named `HelloWorld.java`.

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### Explanation line by line

- `public class HelloWorld`: Declares a class named `HelloWorld`. The public class name must match the filename.
- `public static void main(String[] args)`: The main method is the entry point used to start this program.
- `System.out.println()`: Prints a line of text to the console.
- `"Hello, World!"`: The text that will be printed.
- `;`: Ends a Java statement.

## 5. How to compile and run

Open a terminal in the folder containing `HelloWorld.java`.

Compile:

```bash
javac HelloWorld.java
```

Run:

```bash
java HelloWorld
```

Expected output:

```text
Hello, World!
```

Note: Run `java HelloWorld`, not `java HelloWorld.java`, when using the compile-then-run method above.

## 6. Important vocabulary

| English term | Khmer explanation |
|---|---|
| Programming Language | ភាសាសរសេរកម្មវិធី |
| Source Code | កូដដើមដែលអ្នកសរសេរ |
| Compiler | កម្មវិធីបម្លែង Source Code |
| Bytecode | កូដដែល Compiler បង្កើត |
| Class | គំរូសម្រាប់បង្កើត Objects |
| Method | បណ្ដុំសេចក្ដីបញ្ជាដែលធ្វើការងារមួយ |
| Output | លទ្ធផលដែលកម្មវិធីបង្ហាញ |

## 7. Summary

នៅក្នុងមេរៀននេះ អ្នកបានស្គាល់ Java, JDK, JVM, Compiler និងរបៀបសរសេរកម្មវិធីដំបូង។

**Remember:** Practice by typing the code yourself instead of only copying it.

## 8. Practice

Open [exercise.md](exercise.md) and complete the exercises before looking at the answers.
