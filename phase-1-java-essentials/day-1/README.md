# Day 1: Java Fundamentals & Development Environment Setup

---

## 📚 Topics Covered

1. Introduction to Java
2. Java Installation (Windows, Mac, Linux)
3. JDK vs JVM vs JRE
4. Java Code Execution Process
5. IntelliJ IDEA Setup
6. First Java Program
7. Variables & Constants
8. Comments in Java

---

## 1. Introduction to Java 

### What is Java?

Java is a high-level, object-oriented programming language designed to be platform-independent. It follows the principle of "Write Once, Run Anywhere" (WORA).

### Key Features of Java

- **Platform Independent:** Java bytecode can run on any platform with JVM
- **Object-Oriented:** Everything in Java is an object (except primitives)
- **Secure:** Built-in security features and sandbox execution
- **Robust:** Strong memory management and exception handling
- **Multithreaded:** Built-in support for concurrent programming
- **High Performance:** Just-In-Time (JIT) compiler improves performance

### Why Learn Java?

- Enterprise application development
- Android app development
- Web applications (Spring Boot)
- Cloud-native applications
- Microservices architecture
- Large community and ecosystem

---

## 2. Installing Java on Different Platforms

### Windows Installation 

**Steps:**

1. **Download JDK**
   - Visit [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://adoptium.net/)
   - Download the appropriate Windows installer (.exe or .msi)

2. **Install JDK**
   - Run the installer
   - Choose installation directory (default: `C:\Program Files\Java\jdk-[version]`)
   - Complete installation

3. **Set Environment Variables**
   - Open System Properties → Environment Variables
   - Add new System Variable:
     - Variable name: `JAVA_HOME`
     - Variable value: `C:\Program Files\Java\jdk-[version]`
   - Edit PATH variable:
     - Add: `%JAVA_HOME%\bin`

4. **Verify Installation**
   ```bash
   java -version
   javac -version
   ```

### Mac Installation

**Using Homebrew (Recommended):**

1. **Install Homebrew** (if not installed)
   ```bash
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   ```

2. **Install Java**
   ```bash
   brew install openjdk@21
   ```

3. **Setup PATH**
   ```bash
   echo 'export PATH="/opt/homebrew/opt/openjdk@21/bin:$PATH"' >> ~/.zshrc
   source ~/.zshrc
   ```

4. **Verify Installation**
   ```bash
   java -version
   javac -version
   ```

### Linux Installation

**Ubuntu/Debian (apt):**

```bash
# Update package index
sudo apt update

# Install OpenJDK
sudo apt install openjdk-21-jdk

# Verify installation
java -version
javac -version
```

**RHEL/CentOS/Fedora (yum/dnf):**

```bash
# Install OpenJDK
sudo yum install java-21-openjdk-devel
# OR
sudo dnf install java-21-openjdk-devel

# Verify installation
java -version
javac -version
```

**Setting JAVA_HOME (Linux):**

```bash
# Add to ~/.bashrc or ~/.zshrc
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH

# Reload configuration
source ~/.bashrc
```

---

## 3. JDK vs JVM vs JRE 

### Understanding the Java Ecosystem

```
┌─────────────────────────────────┐
│            JDK                  │
│  (Java Development Kit)         │
│                                 │
│  ┌───────────────────────────┐ │
│  │         JRE               │ │
│  │  (Java Runtime Env)       │ │
│  │                           │ │
│  │  ┌─────────────────────┐ │ │
│  │  │       JVM           │ │ │
│  │  │  (Java Virtual      │ │ │
│  │  │   Machine)          │ │ │
│  │  └─────────────────────┘ │ │
│  │                           │ │
│  │  + Core Libraries         │ │
│  └───────────────────────────┘ │
│                                 │
│  + Development Tools            │
│    (javac, javadoc, jar, etc)  │
└─────────────────────────────────┘
```

### JVM (Java Virtual Machine)

- **Purpose:** Executes Java bytecode
- **Platform-specific:** Different JVM for each OS
- **Key Functions:**
  - Loads bytecode
  - Verifies code
  - Executes instructions
  - Provides runtime environment
- **Components:**
  - Class Loader
  - Bytecode Verifier
  - Execution Engine (Interpreter + JIT Compiler)
  - Garbage Collector

### JRE (Java Runtime Environment)

- **Purpose:** Provides environment to run Java applications
- **Includes:**
  - JVM
  - Core libraries (java.lang, java.util, etc.)
  - Supporting files
- **Use Case:** End users running Java applications
- **Cannot:** Compile Java code

### JDK (Java Development Kit)

- **Purpose:** Complete development environment
- **Includes:**
  - JRE (which includes JVM)
  - Development tools
    - `javac` - Java compiler
    - `java` - Java launcher
    - `javadoc` - Documentation generator
    - `jar` - Archive tool
    - `jdb` - Debugger
- **Use Case:** Developers writing and compiling Java code

### Key Differences

| Feature | JVM | JRE | JDK |
|---------|-----|-----|-----|
| **Purpose** | Execute bytecode | Run applications | Develop applications |
| **Includes** | Execution engine | JVM + Libraries | JRE + Dev tools |
| **For** | Platform execution | End users | Developers |
| **Can compile?** | ❌ | ❌ | ✅ |
| **Can run?** | ✅ | ✅ | ✅ |

---

## 4. Behind the Scenes: Java Code Execution 

### Compilation and Execution Process

```
1. Source Code (.java)
        ↓
2. Java Compiler (javac)
        ↓
3. Bytecode (.class)
        ↓
4. Class Loader (JVM)
        ↓
5. Bytecode Verifier
        ↓
6. Execution Engine
   ├── Interpreter
   └── JIT Compiler
        ↓
7. Runtime (Machine Code)
```

### Step-by-Step Process

**Step 1: Write Source Code**
```java
// HelloWorld.java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

**Step 2: Compilation**
```bash
javac HelloWorld.java
```
- Compiler checks syntax
- Converts source code to bytecode
- Creates `HelloWorld.class` file

**Step 3: Bytecode Generation**
- Platform-independent intermediate code
- Not machine code, not source code
- Can be executed on any platform with JVM

**Step 4: Class Loading**
- JVM loads `.class` file
- Class Loader subsystem loads classes into memory
- Three types of class loaders:
  - Bootstrap ClassLoader
  - Extension ClassLoader
  - Application ClassLoader

**Step 5: Bytecode Verification**
- Verifies bytecode is valid
- Checks for security violations
- Ensures code follows Java language rules

**Step 6: Execution**
```bash
java HelloWorld
```
- **Interpreter:** Executes bytecode line by line
- **JIT Compiler:** Compiles frequently used code to native machine code
- Optimizes performance during runtime

**Step 7: Garbage Collection**
- Automatic memory management
- Removes unused objects
- Frees up memory

### Why This Matters

- **Platform Independence:** Bytecode runs on any JVM
- **Security:** Verification step prevents malicious code
- **Performance:** JIT compilation optimizes hot code paths
- **Portability:** Write once, run anywhere

---

## 5. Installing IntelliJ IDEA 

### What is IntelliJ IDEA?

IntelliJ IDEA is a powerful Integrated Development Environment (IDE) for Java development by JetBrains.

### Installation Steps

**1. Download IntelliJ IDEA**
- Visit [JetBrains Website](https://www.jetbrains.com/idea/download/)
- Choose version:
  - **Community Edition** (Free, open-source)
  - **Ultimate Edition** (Paid, more features)
- For learning, Community Edition is sufficient

**2. Install**
- **Windows:** Run `.exe` installer
- **Mac:** Drag to Applications folder
- **Linux:** Extract `.tar.gz` and run `bin/idea.sh`

**3. Initial Configuration**
- Choose UI theme (Light/Dark)
- Select keymap (Default/Eclipse/VS Code)
- Configure plugins
- Create desktop entry (Linux)

### First Launch Setup

1. Accept terms and conditions
2. Choose theme preference
3. Install featured plugins (optional)
4. Select plugins for frameworks (can be done later)

---

## 6. First Java Program in IntelliJ 

### Creating a New Project

**Step 1: Create Project**
1. File → New → Project
2. Select "Java" from left panel
3. Configure:
   - **Project name:** HelloWorld
   - **Location:** Choose directory
   - **Language:** Java
   - **Build system:** IntelliJ (or Maven/Gradle)
   - **JDK:** Select installed JDK
4. Click "Create"

**Step 2: Project Structure**
```
HelloWorld/
├── .idea/          # IntelliJ configuration
├── src/            # Source code directory
│   └── Main.java
└── HelloWorld.iml  # Module file
```

**Step 3: Create Java Class**
1. Right-click on `src` folder
2. New → Java Class
3. Name: `Main`
4. Click OK

**Step 4: Write Code**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

**Step 5: Run Program**
- Click green play button (▶️) next to main method
- Or: Right-click → Run 'Main.main()'
- Or: Shift + F10 (Windows/Linux), Ctrl + R (Mac)

**Output:**
```
Hello, World!
```

### Understanding the Code

```java
public class Main {                    // Class declaration
    public static void main(String[] args) {  // Main method
        System.out.println("Hello, World!");  // Print statement
    }
}
```

- **`public class Main`:** Defines a public class named Main
- **`public static void main(String[] args)`:** Entry point of program
- **`System.out.println()`:** Prints to console with newline

---

## 7. Enhancing IntelliJ IDEA Experience 

### Essential Plugins

**1. Key Promoter X**
- Shows keyboard shortcuts for mouse actions
- Helps learn shortcuts faster

**2. Rainbow Brackets**
- Colors matching brackets
- Easier to track nested code

**3. SonarLint**
- Code quality analysis
- Detects bugs and code smells

**4. GitToolBox**
- Enhanced Git integration
- Inline blame, auto-fetch

**5. String Manipulation**
- Case switching
- Text transformations

### Productivity Tips

**Keyboard Shortcuts (Windows/Linux | Mac):**
- `Ctrl + Space | Ctrl + Space` - Code completion
- `Ctrl + / | Cmd + /` - Comment/uncomment line
- `Shift + F10 | Ctrl + R` - Run program
- `Alt + Enter | Option + Enter` - Show intention actions
- `Ctrl + Alt + L | Cmd + Option + L` - Format code
- `Shift + Shift` - Search everywhere
- `Ctrl + N | Cmd + O` - Go to class
- `Ctrl + B | Cmd + B` - Go to declaration

**Code Generation:**
- `psvm` + Tab → `public static void main`
- `sout` + Tab → `System.out.println()`
- `fori` + Tab → for loop

**Settings to Configure:**
1. Editor → Font (size, ligatures)
2. Editor → Color Scheme
3. Editor → Auto Import
4. Keymap (choose preferred shortcuts)
5. Plugins (install helpful plugins)

---

## 8. Main Method in Java 25 

### Traditional Main Method

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Traditional main method");
    }
}
```

### Java 21+ Preview: Unnamed Classes and Instance Main Methods

**Simplified Main Method (Preview Feature):**

```java
// No class declaration needed (unnamed class)
void main() {
    System.out.println("Simplified main method");
}
```

**To enable preview features:**
```bash
javac --enable-preview --release 21 Main.java
java --enable-preview Main
```

**In IntelliJ:**
1. File → Project Structure → Project
2. Set Language Level to "21 - Preview"
3. Settings → Build, Execution, Deployment → Compiler → Java Compiler
4. Add to "Additional command line parameters": `--enable-preview`

### Understanding Main Method Components

```java
public static void main(String[] args)
```

- **`public`:** Accessible from anywhere (JVM needs to call it)
- **`static`:** Can be called without creating object
- **`void`:** Doesn't return any value
- **`main`:** Method name (entry point)
- **`String[] args`:** Command-line arguments

### Command-Line Arguments Example

```java
public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Hello, " + args[0] + "!");
        } else {
            System.out.println("Hello, World!");
        }
    }
}
```

**Running with arguments:**
```bash
java Main John
# Output: Hello, John!
```

---

## 9. Variables in Java 

### What is a Variable?

A variable is a named storage location in memory that holds a value. The value can be changed during program execution.

### Variable Declaration

```java
// Syntax: dataType variableName;
int age;
String name;
double salary;
boolean isActive;
```

### Variable Initialization

```java
// Declaration and initialization
int age = 25;
String name = "John";
double salary = 50000.50;
boolean isActive = true;

// Declaration first, initialization later
int count;
count = 10;
```

### Types of Variables

**1. Local Variables**
```java
public class Main {
    public static void main(String[] args) {
        int localVar = 10;  // Local variable
        System.out.println(localVar);
    }
    // localVar not accessible here
}
```
- Declared inside methods
- Must be initialized before use
- Scope limited to the block/method
- No default values

**2. Instance Variables (Non-static)**
```java
public class Person {
    String name;      // Instance variable
    int age;          // Instance variable
    
    public void display() {
        System.out.println(name + " is " + age + " years old");
    }
}
```
- Declared inside class, outside methods
- Each object has its own copy
- Default values assigned if not initialized
- Accessed using object reference

**3. Static Variables (Class Variables)**
```java
public class Counter {
    static int count = 0;  // Static variable
    
    public Counter() {
        count++;
    }
}
```
- Declared with `static` keyword
- Shared among all instances
- Only one copy exists
- Accessed using class name

### Primitive Data Types

```java
// Integer types
byte b = 127;           // 8-bit: -128 to 127
short s = 32000;        // 16-bit: -32,768 to 32,767
int i = 2147483647;     // 32-bit: -2^31 to 2^31-1
long l = 9223372036854775807L;  // 64-bit: -2^63 to 2^63-1

// Floating-point types
float f = 3.14f;        // 32-bit: ~6-7 decimal digits
double d = 3.14159265359;  // 64-bit: ~15 decimal digits

// Character type
char c = 'A';           // 16-bit: Unicode character

// Boolean type
boolean flag = true;    // true or false
```

### Reference Data Types

```java
// String (most commonly used)
String text = "Hello, World!";

// Arrays
int[] numbers = {1, 2, 3, 4, 5};
String[] names = new String[10];

// Objects
Person person = new Person();
```

### Variable Naming Rules

**Rules (Must Follow):**
- Start with letter, underscore (_), or dollar sign ($)
- Cannot start with digit
- No spaces allowed
- Cannot use Java keywords (int, class, public, etc.)
- Case-sensitive

**Conventions (Should Follow):**
- Use camelCase for variables: `firstName`, `totalAmount`
- Use PascalCase for classes: `Person`, `BankAccount`
- Use UPPER_SNAKE_CASE for constants: `MAX_VALUE`, `PI`
- Use meaningful names: `age` not `a`, `studentName` not `sn`

**Examples:**
```java
// Good variable names
int studentAge;
String firstName;
double accountBalance;
boolean isValid;

// Bad variable names (but valid)
int a;
String s;
double x123;

// Invalid variable names
int 1student;        // Cannot start with digit
String first-name;   // Cannot use hyphen
int class;           // Cannot use keyword
```

### Type Inference with `var` (Java 10+)

```java
// Compiler infers the type
var age = 25;              // int
var name = "John";         // String
var salary = 50000.50;     // double
var isActive = true;       // boolean

// Must initialize when declaring
var count;  // ERROR: Cannot infer type
count = 10;
```

---

## 10. Constants in Java

### What is a Constant?

A constant is a variable whose value cannot be changed once assigned.

### Declaring Constants

```java
// Use 'final' keyword
final int MAX_AGE = 100;
final double PI = 3.14159;
final String COMPANY_NAME = "TechCorp";

// Attempting to change will cause error
MAX_AGE = 150;  // ERROR: Cannot assign value to final variable
```

### Naming Convention

Constants use UPPER_SNAKE_CASE:
```java
final int MAX_VALUE = 100;
final double TAX_RATE = 0.18;
final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
```

### Class-Level Constants

```java
public class MathConstants {
    public static final double PI = 3.14159265359;
    public static final double E = 2.71828182846;
    public static final int MAX_ITERATIONS = 1000;
}

// Usage
System.out.println(MathConstants.PI);
```

### Benefits of Constants

1. **Readability:** Named values are easier to understand
2. **Maintainability:** Change value in one place
3. **Type Safety:** Compile-time checking
4. **Prevention of Errors:** Cannot accidentally modify

### Example: Using Constants

```java
public class Circle {
    private static final double PI = 3.14159;
    
    public static double calculateArea(double radius) {
        return PI * radius * radius;
    }
    
    public static double calculateCircumference(double radius) {
        return 2 * PI * radius;
    }
}
```

### Blank Final Variables

```java
public class Example {
    final int VALUE;  // Blank final
    
    public Example(int value) {
        VALUE = value;  // Must initialize in constructor
    }
}
```

---

## 11. Comments in Java 

### Types of Comments

**1. Single-line Comments**
```java
// This is a single-line comment
int age = 25;  // Age of the person

// Use for brief explanations
// Can appear on separate line or at end of code line
```

**2. Multi-line (Block) Comments**
```java
/*
 * This is a multi-line comment
 * Used for longer explanations
 * Can span multiple lines
 */
int calculate() {
    /* 
     * Complex calculation here
     * Step 1: ...
     * Step 2: ...
     */
    return 0;
}
```

**3. Javadoc Comments**
```java
/**
 * Calculates the area of a circle.
 * This method uses the formula: π × r²
 *
 * @param radius the radius of the circle
 * @return the area of the circle
 * @throws IllegalArgumentException if radius is negative
 * @author Your Name
 * @version 1.0
 * @since 2025-01-01
 */
public double calculateArea(double radius) {
    if (radius < 0) {
        throw new IllegalArgumentException("Radius cannot be negative");
    }
    return Math.PI * radius * radius;
}
```

### Javadoc Tags

Common Javadoc tags:
- `@param` - Parameter description
- `@return` - Return value description
- `@throws` or `@exception` - Exception description
- `@author` - Author name
- `@version` - Version information
- `@since` - Since which version
- `@see` - Reference to other elements
- `@deprecated` - Marks deprecated elements

### Generating Javadoc

**Command Line:**
```bash
javadoc -d docs src/*.java
```

**IntelliJ IDEA:**
1. Tools → Generate JavaDoc
2. Select scope
3. Choose output directory
4. Click OK

### Best Practices for Comments

**DO:**
```java
// Calculate total price including tax
double totalPrice = price * (1 + TAX_RATE);

/**
 * Validates email format using regex pattern.
 * Ensures email contains @ symbol and domain.
 */
public boolean isValidEmail(String email) {
    // Implementation
}
```

**DON'T:**
```java
// This adds 1 to i
i = i + 1;  // BAD: Obvious from code

// This is a variable
int x;  // BAD: Useless comment
```

### Comment Shortcuts in IntelliJ

- `Ctrl + /` (Windows/Linux) or `Cmd + /` (Mac) - Toggle line comment
- `Ctrl + Shift + /` (Windows/Linux) or `Cmd + Shift + /` (Mac) - Toggle block comment

---

## 📝 Key Takeaways

1. ✅ Java is platform-independent due to bytecode and JVM
2. ✅ JDK includes JRE, which includes JVM
3. ✅ Java code goes through compilation (`.java` → `.class`) and execution (JVM)
4. ✅ IntelliJ IDEA is a powerful IDE for Java development
5. ✅ Variables store data; constants store unchangeable values
6. ✅ Use meaningful names and follow naming conventions
7. ✅ Comments explain code; use appropriately

---

## 🎯 Practice Exercises

### Exercise 1: Variables Practice
Create a program that declares variables for:
- Student name (String)
- Student age (int)
- Student GPA (double)
- Is enrolled (boolean)

Print all values.

### Exercise 2: Constants Usage
Create a class with constants for:
- Maximum students in a class
- Minimum passing grade
- School name

Use these constants in calculations.

### Exercise 3: Complete Program
Write a program that:
1. Declares variables for circle radius
2. Uses PI constant
3. Calculates area and circumference
4. Prints results with proper comments

---

## 🔗 Resources

- [Official Java Documentation](https://docs.oracle.com/en/java/)
- [IntelliJ IDEA Documentation](https://www.jetbrains.com/idea/documentation/)
- [Java Naming Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html)

---

## ✅ Completed Topics Checklist

- [x] Java installation
- [x] Understanding JDK, JRE, JVM
- [x] IntelliJ IDEA setup
- [x] First Java program
- [x] Variables and data types
- [x] Constants
- [x] Comments

---

**Next:** Day 2 - Data Types and Operators

**Status:** ✅ Day 1 Complete