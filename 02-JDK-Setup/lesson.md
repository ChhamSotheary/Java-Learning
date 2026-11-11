# Lesson 02: Install JDK and Set Up Java

## Learning objectives

After this lesson, you should be able to:

1. Understand what the JDK does.
2. Install a JDK on Windows.
3. Check whether Java is installed.
4. Set up Java support in Visual Studio Code.
5. Compile and run a Java program from the terminal.

## 1. What do we need?

To write and run Java programs, we need:

- **JDK (Java Development Kit):** Includes the Java compiler (`javac`) and tools for developing Java applications.
- **Code editor:** We will use Visual Studio Code (VS Code) to write Java code.
- **Java extensions:** These help VS Code understand, run, and debug Java programs.

> Important: Install a JDK, not only a Java runtime. The JDK includes the compiler required for this course.

## 2. Download and install the JDK on Windows

We will use Eclipse Temurin, a popular OpenJDK distribution.

1. Open the official download page: https://adoptium.net/
2. Choose the latest **LTS** release.
3. Select **Windows** and your computer architecture (most modern PCs use x64).
4. Download the **JDK** installer.
5. Open the downloaded installer.
6. Follow the installation steps. Keep the default options unless you know you need to change them.
7. Finish the installation.

You can also use another trusted JDK distribution, such as Oracle JDK. Use an LTS version for learning unless your course requires a particular version.

## 3. Check the Java installation

Open **PowerShell** or the VS Code terminal.

Check the Java runtime version:

```powershell
java -version
```

Check the Java compiler version:

```powershell
javac -version
```

If both commands show version information, Java and the compiler are available in your terminal.

### If Windows says the command is not recognized

This usually means the JDK's `bin` folder is not on your PATH, or the terminal was opened before installation finished.

Try these steps:

1. Close PowerShell and VS Code completely.
2. Open them again and repeat the version commands.
3. If the commands still fail, check that the JDK was installed.
4. On Windows, search for **Edit the system environment variables**.
5. Open **Environment Variables** and inspect the `Path` variable.
6. Add the JDK's `bin` folder if it is missing. The folder is commonly similar to `C:\Program Files\Eclipse Adoptium\jdk-<version>\bin`, but use the real folder on your computer.
7. Open a new terminal and test again.

Do not copy the example path literally: your installed folder name and version may be different.

## 4. Install Visual Studio Code

1. Visit https://code.visualstudio.com/
2. Download Visual Studio Code for Windows.
3. Run the installer and complete setup.
4. Open VS Code.

## 5. Install Java extensions in VS Code

1. Open VS Code.
2. Click the **Extensions** icon on the left, or press `Ctrl + Shift + X`.
3. Search for **Extension Pack for Java**.
4. Select the extension pack published by Microsoft.
5. Click **Install** and wait for it to finish.

The extension pack provides Java language support, debugging, testing, and project tools.

## 6. Create your first Java folder

1. Create a folder named `JavaPractice`.
2. Open VS Code.
3. Choose **File → Open Folder** and select `JavaPractice`.
4. Create a file named `SetupCheck.java`.
5. Type the code below.

```java
public class SetupCheck {
    public static void main(String[] args) {
        System.out.println("Java is installed correctly!");
        System.out.println("I am ready to learn Java.");
    }
}
```

Remember: the public class name `SetupCheck` must match the file name `SetupCheck.java`.

## 7. Compile and run using the terminal

In VS Code, open the terminal with **Terminal → New Terminal**.

Make sure the terminal is inside the folder that contains `SetupCheck.java`.

Compile the program:

```powershell
javac SetupCheck.java
```

Run the program:

```powershell
java SetupCheck
```

Expected output:

```text
Java is installed correctly!
I am ready to learn Java.
```

When compilation succeeds, Java creates a file named `SetupCheck.class`. This contains the bytecode that the JVM runs.

## 8. Useful commands

| Command | Purpose |
|---|---|
| `java -version` | Shows the Java runtime version |
| `javac -version` | Shows the Java compiler version |
| `javac SetupCheck.java` | Compiles the source file |
| `java SetupCheck` | Runs the compiled class |

## 9. Common problems

**Problem: `javac` is not recognized.**

- Check that you installed a JDK.
- Check that the JDK `bin` folder is included in PATH.
- Restart the terminal after changing PATH.

**Problem: Could not find or load main class.**

- Make sure the terminal is in the correct folder.
- Compile the file first.
- Run the class using its name without `.java` or `.class`.

**Problem: class name and file name do not match.**

- If the class is `public class SetupCheck`, the file must be `SetupCheck.java`.
- Capital letters matter.

## 10. Summary

នៅក្នុងមេរៀននេះ អ្នកបានរៀនអំពី JDK, ការដំឡើង Java លើ Windows, ការត្រួតពិនិត្យ Java version និងការប្រើ VS Code ដើម្បីសរសេរ និងដំណើរការ Java program។

**Before moving to Lesson 03:** Make sure both `java -version` and `javac -version` work, and that your `SetupCheck.java` program runs successfully.

## 11. Practice

Open [exercise.md](exercise.md) and complete the tasks.
