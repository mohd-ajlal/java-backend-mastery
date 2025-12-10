# Day 2: Java Basics, Control Flow & Operators

---

## 📚 Topics Covered

1. Variable Naming Rules & Best Practices
2. Data Types Deep Dive (Hands-On)
3. Control Flow Statements
4. Methods in Java
5. Operators in Java

---

## 1. Variable Naming Rules & Best Practices

### Naming Rules (Must Follow)

**Valid Variable Names:**
```java
// Letters, digits, underscore, dollar sign
int age;
int age2;
int _age;
int $age;
int studentAge;
int student_age;
```

**Invalid Variable Names:**
```java
int 2age;           // ERROR: Cannot start with digit
int student-age;    // ERROR: Hyphen not allowed
int student age;    // ERROR: Space not allowed
int int;            // ERROR: Cannot use keyword
int class;          // ERROR: Cannot use keyword
int #age;           // ERROR: Special character not allowed
```

### Java Keywords (Reserved Words)

Cannot be used as variable names:
```
abstract    assert      boolean     break       byte
case        catch       char        class       const
continue    default     do          double      else
enum        extends     final       finally     float
for         goto        if          implements  import
instanceof  int         interface   long        native
new         package     private     protected   public
return      short       static      strictfp    super
switch      synchronized this       throw       throws
transient   try         void        volatile    while
```

### Naming Conventions (Best Practices)

**1. Variables & Methods: camelCase**
```java
// First word lowercase, subsequent words capitalized
int studentAge;
String firstName;
double accountBalance;
boolean isActive;

// Methods
void calculateTotal() { }
String getUserName() { }
```

**2. Classes & Interfaces: PascalCase**
```java
// Each word capitalized
class Student { }
class BankAccount { }
interface Drawable { }
class UserAuthentication { }
```

**3. Constants: UPPER_SNAKE_CASE**
```java
// All uppercase with underscores
final int MAX_VALUE = 100;
final double PI = 3.14159;
final String DATABASE_URL = "jdbc:mysql://localhost/db";
static final int DEFAULT_TIMEOUT = 30;
```

**4. Packages: lowercase**
```java
package com.company.project;
package utils.database;
package models.user;
```

### Meaningful Variable Names

**Good Examples:**
```java
// Descriptive and clear
int studentCount = 50;
String customerName = "John Doe";
double totalPrice = 1500.50;
boolean isLoggedIn = true;
int maxAttempts = 3;

// For loops (acceptable short names)
for (int i = 0; i < 10; i++) { }
for (int j = 0; j < array.length; j++) { }
```

**Bad Examples:**
```java
// Too short, not descriptive
int a = 50;
String s = "John";
double x = 1500.50;
boolean b = true;

// Too long
int numberOfStudentsInTheClassroom = 50;
String userFirstNameFromDatabase = "John";
```

### Special Cases

**Boolean Variables:**
```java
// Use is, has, can, should prefix
boolean isActive;
boolean hasPermission;
boolean canEdit;
boolean shouldValidate;
boolean isValid;
boolean hasAccess;
```

**Collections:**
```java
// Use plural names
List<String> students;
ArrayList<Integer> numbers;
Map<String, Integer> scores;
Set<String> uniqueNames;
```

**Constants for Configuration:**
```java
public class Config {
    public static final String DB_HOST = "localhost";
    public static final int DB_PORT = 3306;
    public static final int MAX_CONNECTIONS = 100;
    public static final long TIMEOUT_MS = 5000;
}
```

---

## 2. Data Types Hands-On

### Primitive Data Types

Java has 8 primitive data types:

**1. Integer Types**

```java
// byte: 8-bit signed (-128 to 127)
byte age = 25;
byte temperature = -10;
byte maxByte = 127;
byte minByte = -128;

// short: 16-bit signed (-32,768 to 32,767)
short year = 2025;
short population = 30000;
short maxShort = 32767;

// int: 32-bit signed (-2,147,483,648 to 2,147,483,647)
int salary = 50000;
int population = 1000000;
int maxInt = 2147483647;

// long: 64-bit signed (very large numbers)
long worldPopulation = 8000000000L;  // Note: L suffix
long distance = 149597870700L;       // Earth to Sun in km
long maxLong = 9223372036854775807L;
```

**When to Use Which Integer Type:**
- `byte` - Small numbers, memory-sensitive (images, file operations)
- `short` - Medium-range numbers (rarely used)
- `int` - Default choice for integers (most common)
- `long` - Very large numbers (timestamps, large calculations)

**2. Floating-Point Types**

```java
// float: 32-bit (6-7 decimal digits precision)
float price = 99.99f;           // Note: f suffix required
float temperature = 36.6f;
float pi = 3.14f;

// double: 64-bit (15 decimal digits precision)
double salary = 50000.75;       // No suffix needed (default)
double pi = 3.14159265359;
double scientificNotation = 1.23e5;  // 123000.0
```

**Floating-Point Best Practices:**
```java
// Use double as default for decimals
double price = 99.99;

// Use float only when memory is critical
float coordinate = 12.34f;

// Avoid for precise calculations (money)
// Use BigDecimal instead
import java.math.BigDecimal;
BigDecimal money = new BigDecimal("99.99");
```

**3. Character Type**

```java
// char: 16-bit Unicode character (0 to 65,535)
char grade = 'A';
char symbol = '$';
char digit = '5';
char newline = '\n';
char tab = '\t';

// Unicode representation
char heart = '\u2764';  // ❤
char smiley = '\u263A'; // ☺

// Character operations
char letter = 'A';
System.out.println((int) letter);  // 65 (ASCII value)
```

**4. Boolean Type**

```java
// boolean: true or false only
boolean isActive = true;
boolean hasPermission = false;
boolean isValid = (10 > 5);  // true
boolean isEmpty = "".isEmpty();  // true

// Common use in conditions
if (isActive) {
    System.out.println("User is active");
}
```

### Reference Data Types

**1. String (Most Common)**

```java
// String: sequence of characters (not primitive!)
String name = "John Doe";
String message = "Hello, World!";
String empty = "";

// String is immutable
String text = "Hello";
text = text + " World";  // Creates new String object

// String methods
String name = "John Doe";
System.out.println(name.length());        // 8
System.out.println(name.toUpperCase());   // JOHN DOE
System.out.println(name.toLowerCase());   // john doe
System.out.println(name.substring(0, 4)); // John
System.out.println(name.contains("John"));// true
System.out.println(name.charAt(0));       // J
System.out.println(name.replace("John", "Jane")); // Jane Doe
```

**2. Arrays**

```java
// Array declaration and initialization
int[] numbers = {1, 2, 3, 4, 5};
String[] names = {"John", "Jane", "Bob"};

// Array with size
int[] scores = new int[5];  // Creates array of size 5

// Accessing elements
System.out.println(numbers[0]);  // 1
numbers[2] = 10;                 // Modify element

// Array length
System.out.println(numbers.length);  // 5

// Multi-dimensional arrays
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
System.out.println(matrix[0][0]);  // 1
```

### Type Conversion

**1. Implicit Conversion (Widening)**

```java
// Automatic conversion (smaller to larger)
byte b = 10;
int i = b;        // byte → int (automatic)
long l = i;       // int → long (automatic)
float f = l;      // long → float (automatic)
double d = f;     // float → double (automatic)

// Order: byte → short → int → long → float → double
```

**2. Explicit Conversion (Narrowing)**

```java
// Manual conversion (larger to smaller) - may lose data
double d = 99.99;
int i = (int) d;     // 99 (decimal part lost)

long l = 100L;
int i2 = (int) l;    // 100

// Be careful with overflow
int bigNumber = 130;
byte b = (byte) bigNumber;  // -126 (overflow!)
```

**3. String Conversion**

```java
// Number to String
int age = 25;
String ageStr = String.valueOf(age);
String ageStr2 = Integer.toString(age);
String ageStr3 = "" + age;  // Quick way

// String to Number
String numStr = "123";
int num = Integer.parseInt(numStr);
double decimal = Double.parseDouble("99.99");
long bigNum = Long.parseLong("1000000");

// Handle exceptions
try {
    int invalid = Integer.parseInt("abc");
} catch (NumberFormatException e) {
    System.out.println("Invalid number format");
}
```

### Practical Examples

```java
public class DataTypesDemo {
    public static void main(String[] args) {
        // Student information
        String studentName = "Alice Johnson";
        int studentAge = 20;
        char grade = 'A';
        double gpa = 3.85;
        boolean isEnrolled = true;
        
        // Display information
        System.out.println("Student Name: " + studentName);
        System.out.println("Age: " + studentAge);
        System.out.println("Grade: " + grade);
        System.out.println("GPA: " + gpa);
        System.out.println("Enrolled: " + isEnrolled);
        
        // Calculations
        int totalStudents = 150;
        double averageAge = 21.5;
        double totalAge = totalStudents * averageAge;
        
        System.out.println("Total Age: " + totalAge);
    }
}
```

---

## 3. Control Flow Statements

Control flow statements determine the order in which code executes.

### If Statement

**Basic If:**
```java
int age = 18;

if (age >= 18) {
    System.out.println("You are an adult");
}
```

**If-Else:**
```java
int marks = 75;

if (marks >= 50) {
    System.out.println("Pass");
} else {
    System.out.println("Fail");
}
```

**If-Else-If Ladder:**
```java
int marks = 85;

if (marks >= 90) {
    System.out.println("Grade: A+");
} else if (marks >= 80) {
    System.out.println("Grade: A");
} else if (marks >= 70) {
    System.out.println("Grade: B");
} else if (marks >= 60) {
    System.out.println("Grade: C");
} else if (marks >= 50) {
    System.out.println("Grade: D");
} else {
    System.out.println("Grade: F");
}
```

**Nested If:**
```java
int age = 25;
boolean hasLicense = true;

if (age >= 18) {
    if (hasLicense) {
        System.out.println("You can drive");
    } else {
        System.out.println("You need a license");
    }
} else {
    System.out.println("You are too young");
}
```

### Switch Statement

**Basic Switch:**
```java
int day = 3;

switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    case 4:
        System.out.println("Thursday");
        break;
    case 5:
        System.out.println("Friday");
        break;
    case 6:
        System.out.println("Saturday");
        break;
    case 7:
        System.out.println("Sunday");
        break;
    default:
        System.out.println("Invalid day");
}
```

**Switch with String:**
```java
String month = "January";

switch (month) {
    case "January":
    case "February":
    case "December":
        System.out.println("Winter");
        break;
    case "March":
    case "April":
    case "May":
        System.out.println("Spring");
        break;
    case "June":
    case "July":
    case "August":
        System.out.println("Summer");
        break;
    case "September":
    case "October":
    case "November":
        System.out.println("Autumn");
        break;
    default:
        System.out.println("Invalid month");
}
```

**Enhanced Switch (Java 14+):**
```java
int day = 3;

String dayName = switch (day) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 3 -> "Wednesday";
    case 4 -> "Thursday";
    case 5 -> "Friday";
    case 6 -> "Saturday";
    case 7 -> "Sunday";
    default -> "Invalid";
};

System.out.println(dayName);
```

### For Loop

**Basic For Loop:**
```java
// Print numbers 1 to 10
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}

// Syntax: for (initialization; condition; update)
```

**For Loop Examples:**
```java
// Count down
for (int i = 10; i >= 1; i--) {
    System.out.println(i);
}

// Even numbers
for (int i = 0; i <= 20; i += 2) {
    System.out.println(i);
}

// Multiplication table
int num = 5;
for (int i = 1; i <= 10; i++) {
    System.out.println(num + " x " + i + " = " + (num * i));
}

// Array traversal
int[] numbers = {10, 20, 30, 40, 50};
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

**Enhanced For Loop (For-Each):**
```java
// Array iteration
int[] numbers = {1, 2, 3, 4, 5};
for (int num : numbers) {
    System.out.println(num);
}

// String array
String[] names = {"John", "Jane", "Bob"};
for (String name : names) {
    System.out.println(name);
}
```

**Nested For Loops:**
```java
// Pattern printing
for (int i = 1; i <= 5; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
// Output:
// * 
// * * 
// * * * 
// * * * * 
// * * * * * 

// Multiplication table (all)
for (int i = 1; i <= 5; i++) {
    for (int j = 1; j <= 10; j++) {
        System.out.print(i + "x" + j + "=" + (i*j) + "\t");
    }
    System.out.println();
}
```

### While Loop

**Basic While Loop:**
```java
int i = 1;
while (i <= 5) {
    System.out.println(i);
    i++;
}

// Syntax: while (condition) { ... }
```

**While Loop Examples:**
```java
// Sum of numbers
int sum = 0;
int n = 1;
while (n <= 10) {
    sum += n;
    n++;
}
System.out.println("Sum: " + sum);  // 55

// User input validation (conceptual)
Scanner scanner = new Scanner(System.in);
int age = -1;
while (age < 0 || age > 150) {
    System.out.print("Enter valid age: ");
    age = scanner.nextInt();
}

// Finding factorial
int num = 5;
int factorial = 1;
int i = num;
while (i > 0) {
    factorial *= i;
    i--;
}
System.out.println("Factorial: " + factorial);  // 120
```

### Do-While Loop

**Basic Do-While:**
```java
int i = 1;
do {
    System.out.println(i);
    i++;
} while (i <= 5);

// Executes at least once, then checks condition
```

**Do-While Examples:**
```java
// Menu system
int choice;
do {
    System.out.println("1. Add");
    System.out.println("2. Delete");
    System.out.println("3. Exit");
    System.out.print("Enter choice: ");
    choice = scanner.nextInt();
    
    switch (choice) {
        case 1:
            System.out.println("Adding...");
            break;
        case 2:
            System.out.println("Deleting...");
            break;
        case 3:
            System.out.println("Exiting...");
            break;
        default:
            System.out.println("Invalid choice");
    }
} while (choice != 3);

// At least one execution guaranteed
int num = 10;
do {
    System.out.println("This prints once");
} while (num < 5);  // Condition false, but executes once
```

### Break and Continue

**Break Statement:**
```java
// Exit loop prematurely
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break;  // Exit loop when i is 5
    }
    System.out.println(i);
}
// Output: 1 2 3 4

// Find first even number
int[] numbers = {1, 3, 5, 8, 9, 11};
for (int num : numbers) {
    if (num % 2 == 0) {
        System.out.println("First even: " + num);
        break;
    }
}
```

**Continue Statement:**
```java
// Skip current iteration
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) {
        continue;  // Skip even numbers
    }
    System.out.println(i);
}
// Output: 1 3 5 7 9

// Skip specific values
for (int i = 1; i <= 10; i++) {
    if (i == 5 || i == 7) {
        continue;  // Skip 5 and 7
    }
    System.out.println(i);
}
```

### Practical Examples

**Example 1: Grade Calculator**
```java
public class GradeCalculator {
    public static void main(String[] args) {
        int marks = 75;
        char grade;
        
        if (marks >= 90) {
            grade = 'A';
        } else if (marks >= 80) {
            grade = 'B';
        } else if (marks >= 70) {
            grade = 'C';
        } else if (marks >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        System.out.println("Grade: " + grade);
    }
}
```

**Example 2: Prime Number Checker**
```java
public class PrimeChecker {
    public static void main(String[] args) {
        int num = 29;
        boolean isPrime = true;
        
        if (num <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        
        if (isPrime) {
            System.out.println(num + " is prime");
        } else {
            System.out.println(num + " is not prime");
        }
    }
}
```

**Example 3: Pattern Printing**
```java
public class PatternPrinter {
    public static void main(String[] args) {
        int rows = 5;
        
        // Right-angled triangle
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        System.out.println();
        
        // Inverted triangle
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
```

---

## 4. Methods in Java

Methods (also called functions) are reusable blocks of code that perform specific tasks.

### Method Syntax

```java
accessModifier returnType methodName(parameters) {
    // method body
    return value;  // if returnType is not void
}
```

### Method Declaration

**Basic Method:**
```java
public class Calculator {
    // Method with no parameters, no return
    public void greet() {
        System.out.println("Hello!");
    }
    
    // Method with parameters, no return
    public void printSum(int a, int b) {
        System.out.println("Sum: " + (a + b));
    }
    
    // Method with parameters and return value
    public int add(int a, int b) {
        return a + b;
    }
    
    // Method with return type
    public String getMessage() {
        return "Welcome to Java";
    }
}
```

### Calling Methods

```java
public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        // Call method with no return
        calc.greet();
        
        // Call method with parameters
        calc.printSum(5, 10);
        
        // Call method and store return value
        int result = calc.add(15, 25);
        System.out.println("Result: " + result);
        
        // Call method with return value directly
        String message = calc.getMessage();
        System.out.println(message);
    }
}
```

### Static Methods

```java
public class MathUtils {
    // Static method - can be called without creating object
    public static int square(int num) {
        return num * num;
    }
    
    public static double average(int a, int b) {
        return (a + b) / 2.0;
    }
}

// Calling static methods
public class Main {
    public static void main(String[] args) {
        // Call using class name
        int result = MathUtils.square(5);
        System.out.println(result);  // 25
        
        double avg = MathUtils.average(10, 20);
        System.out.println(avg);  // 15.0
    }
}
```

### Method Parameters

**1. No Parameters:**
```java
public void displayMessage() {
    System.out.println("No parameters needed");
}
```

**2. Single Parameter:**
```java
public void greetUser(String name) {
    System.out.println("Hello, " + name);
}
```

**3. Multiple Parameters:**
```java
public int multiply(int a, int b) {
    return a * b;
}

public String getFullName(String firstName, String lastName) {
    return firstName + " " + lastName;
}
```

**4. Variable Arguments (Varargs):**
```java
public int sum(int... numbers) {
    int total = 0;
    for (int num : numbers) {
        total += num;
    }
    return total;
}

// Usage
sum(1, 2, 3);           // 6
sum(10, 20, 30, 40);    // 100
sum(5);                 // 5
```

### Return Types

**void - No Return:**
```java
public void printMessage(String msg) {
    System.out.println(msg);
    // No return statement needed
}
```

**Primitive Return Types:**
```java
public int getAge() {
    return 25;
}

public double getPrice() {
    return 99.99;
}

public boolean isValid() {
    return true;
}

public char getGrade() {
    return 'A';
}
```

**Reference Return Types:**
```java
public String getName() {
    return "John Doe";
}

public int[] getNumbers() {
    return new int[]{1, 2, 3, 4, 5};
}
```

### Method Overloading

Same method name, different parameters:

```java
public class Calculator {
    // Different number of parameters
    public int add(int a, int b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // Different parameter types
    public double add(double a, double b) {
        return a + b;
    }
    
    public String add(String a, String b) {
        return a + b;
    }
}

// Usage
Calculator calc = new Calculator();
System.out.println(calc.add(5, 10));           // 15
System.out.println(calc.add(5, 10, 15));       // 30
System.out.println(calc.add(5.5, 10.5));       // 16.0
System.out.println(calc.add("Hello", "World"));// HelloWorld
```

### Method Best Practices

**1. Single Responsibility:**
```java
// Good - each method does one thing
public double calculateArea(double radius) {
    return Math.PI * radius * radius;
}

public void printArea(double area) {
    System.out.println("Area: " + area);
}

// Bad - method does multiple things
public void calculateAndPrintArea(double radius) {
    double area = Math.PI * radius * radius;
    System.out.println("Area: " + area);
}
```

**2. Meaningful Names:**
```java
// Good
public int calculateTotal(int price, int quantity) {
    return price * quantity;
}

// Bad
public int calc(int a, int b) {
    return a * b;
}
```

**3. Keep Methods Short:**
```java
// Good - concise and clear
public boolean isEligible(int age) {
    return age >= 18;
}

// Avoid overly long methods with too much logic
```

### Practical Examples

**Example 1: Temperature Converter**
```java
public class TemperatureConverter {
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
    
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
    
    public static void main(String[] args) {
        double temp = 25;
        System.out.println(temp + "°C = " + 
            celsiusToFahrenheit(temp) + "°F");
        
        double tempF = 77;
        System.out.println(tempF + "°F = " + 
            fahrenheitToCelsius(tempF) + "°C");
    }
}
```

**Example 2: Number Utilities**
```java
public class NumberUtils {
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
    
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    public static int factorial(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("Is 4 even? " + isEven(4));
        System.out.println("Is 7 prime? " + isPrime(7));
        System.out.println("Factorial of 5: " + factorial(5));
    }
}
```

---

## 5. Operators in Java

Operators are symbols that perform operations on variables and values.

### Arithmetic Operators

```java
int a = 10;
int b = 3;

// Addition
int sum = a + b;        // 13

// Subtraction
int diff = a - b;       // 7

// Multiplication
int product = a * b;    // 30

// Division
int quotient = a / b;   // 3 (integer division)
double result = a / (double)b;  // 3.333...

// Modulus (remainder)
int remainder = a % b;  // 1

// Increment
int x = 5;
x++;    // x = 6 (post-increment)
++x;    // x = 7 (pre-increment)

// Decrement
int y = 10;
y--;    // y = 9 (post-decrement)
--y;    // y = 8 (pre-decrement)
```

**Pre vs Post Increment/Decrement:**
```java
int a = 5;
int b = a++;    // b = 5, a = 6 (use then increment)

int c = 5;
int d = ++c;    // d = 6, c = 6 (increment then use)

int e = 10;
int f = e--;    // f = 10, e = 9 (use then decrement)

int g = 10;
int h = --g;    // h = 9, g = 9 (decrement then use)
```

### Relational (Comparison) Operators

```java
int a = 10;
int b = 5;

// Equal to
boolean isEqual = (a == b);      // false

// Not equal to
boolean notEqual = (a != b);     // true

// Greater than
boolean greater = (a > b);       // true

// Less than
boolean less = (a < b);          // false

// Greater than or equal to
boolean greaterOrEqual = (a >= b);  // true

// Less than or equal to
boolean lessOrEqual = (a <= b);     // false

// Usage in conditions
if (a > b) {
    System.out.println("a is greater than b");
}
```

### Logical Operators

Used to combine multiple conditions:

```java
int age = 25;
boolean hasLicense = true;

// AND (&&) - both conditions must be true
if (age >= 18 && hasLicense) {
    System.out.println("Can drive");
}

// OR (||) - at least one condition must be true
boolean isWeekend = true;
boolean isHoliday = false;
if (isWeekend || isHoliday) {
    System.out.println("No work today");
}

// NOT (!) - reverses the boolean value
boolean isRaining = false;
if (!isRaining) {
    System.out.println("Go for a walk");
}

// Complex conditions
int marks = 75;
boolean hasAttendance = true;
if (marks >= 50 && hasAttendance && !isAbsent) {
    System.out.println("Eligible for exam");
}
```

**Short-circuit Evaluation:**
```java
int x = 5;
int y = 0;

// && stops if first condition is false
if (y != 0 && x / y > 2) {  // Safe: doesn't divide by zero
    System.out.println("Division successful");
}

// || stops if first condition is true
if (x > 0 || y / x > 2) {  // Safe: doesn't evaluate second part
    System.out.println("At least one condition is true");
}
```

**Truth Tables:**
```java
// AND (&&)
true  && true  = true
true  && false = false
false && true  = false
false && false = false

// OR (||)
true  || true  = true
true  || false = true
false || true  = true
false || false = false

// NOT (!)
!true  = false
!false = true
```

### Assignment Operators

```java
int x = 10;  // Simple assignment

// Compound assignment operators
x += 5;   // x = x + 5  → 15
x -= 3;   // x = x - 3  → 12
x *= 2;   // x = x * 2  → 24
x /= 4;   // x = x / 4  → 6
x %= 4;   // x = x % 4  → 2

// Examples
int score = 100;
score += 50;  // score = 150
score -= 20;  // score = 130
score *= 2;   // score = 260
score /= 10;  // score = 26
score %= 5;   // score = 1

// String concatenation with +=
String message = "Hello";
message += " World";  // "Hello World"
message += "!";       // "Hello World!"
```

### Ternary Operator

Shorthand for if-else statement:

```java
// Syntax: condition ? valueIfTrue : valueIfFalse

int age = 20;
String result = (age >= 18) ? "Adult" : "Minor";
System.out.println(result);  // Adult

// Traditional if-else equivalent
String result2;
if (age >= 18) {
    result2 = "Adult";
} else {
    result2 = "Minor";
}

// More examples
int a = 10, b = 20;
int max = (a > b) ? a : b;  // 20

int marks = 75;
String grade = (marks >= 50) ? "Pass" : "Fail";

// Nested ternary (use sparingly)
int num = 0;
String sign = (num > 0) ? "Positive" : (num < 0) ? "Negative" : "Zero";
```

### Bitwise Operators

Work on binary representation of numbers:

```java
int a = 5;   // Binary: 0101
int b = 3;   // Binary: 0011

// Bitwise AND (&)
int and = a & b;  // 0001 = 1

// Bitwise OR (|)
int or = a | b;   // 0111 = 7

// Bitwise XOR (^)
int xor = a ^ b;  // 0110 = 6

// Bitwise NOT (~)
int not = ~a;     // Inverts all bits

// Left Shift (<<)
int leftShift = a << 1;   // 1010 = 10 (multiply by 2)
int leftShift2 = a << 2;  // 10100 = 20 (multiply by 4)

// Right Shift (>>)
int rightShift = a >> 1;  // 0010 = 2 (divide by 2)

// Unsigned Right Shift (>>>)
int unsignedRight = a >>> 1;  // Same as >> for positive numbers
```

**Practical Uses:**
```java
// Check if number is even
boolean isEven = (num & 1) == 0;

// Multiply by 2
int doubled = num << 1;

// Divide by 2
int halved = num >> 1;

// Swap two numbers without temp variable
a = a ^ b;
b = a ^ b;
a = a ^ b;

// Check if power of 2
boolean isPowerOf2 = (num & (num - 1)) == 0;
```

### Operator Precedence

Order of operations (highest to lowest):

```java
// 1. Postfix: expr++, expr--
// 2. Prefix: ++expr, --expr, +expr, -expr, !
// 3. Multiplicative: *, /, %
// 4. Additive: +, -
// 5. Shift: <<, >>, >>>
// 6. Relational: <, >, <=, >=
// 7. Equality: ==, !=
// 8. Bitwise AND: &
// 9. Bitwise XOR: ^
// 10. Bitwise OR: |
// 11. Logical AND: &&
// 12. Logical OR: ||
// 13. Ternary: ? :
// 14. Assignment: =, +=, -=, etc.

// Examples
int result = 10 + 5 * 2;      // 20 (multiplication first)
int result2 = (10 + 5) * 2;   // 30 (parentheses first)

boolean b = 5 > 3 && 10 < 20; // true (relational then logical)
int x = 5 + 3 > 7 ? 10 : 20;  // 10 (arithmetic, relational, ternary)

// Use parentheses for clarity
int calculation = ((a + b) * c) / (d - e);
```

### Practical Operator Examples

**Example 1: Calculator**
```java
public class SimpleCalculator {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 3;
        
        System.out.println("Addition: " + (num1 + num2));
        System.out.println("Subtraction: " + (num1 - num2));
        System.out.println("Multiplication: " + (num1 * num2));
        System.out.println("Division: " + (num1 / num2));
        System.out.println("Modulus: " + (num1 % num2));
        
        // Using ternary for max/min
        int max = (num1 > num2) ? num1 : num2;
        int min = (num1 < num2) ? num1 : num2;
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
```

**Example 2: Grade Evaluator**
```java
public class GradeEvaluator {
    public static void main(String[] args) {
        int marks = 75;
        int attendance = 80;
        
        // Using logical operators
        boolean isEligible = marks >= 50 && attendance >= 75;
        
        if (isEligible) {
            // Using ternary for grade
            String grade = (marks >= 90) ? "A" :
                          (marks >= 80) ? "B" :
                          (marks >= 70) ? "C" :
                          (marks >= 60) ? "D" : "F";
            
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Not eligible for grading");
        }
    }
}
```

**Example 3: Number Properties**
```java
public class NumberProperties {
    public static void main(String[] args) {
        int num = 24;
        
        // Check if even using modulus
        boolean isEven = (num % 2 == 0);
        System.out.println(num + " is even: " + isEven);
        
        // Check if even using bitwise
        boolean isEvenBitwise = (num & 1) == 0;
        System.out.println("Even (bitwise): " + isEvenBitwise);
        
        // Check if divisible by 3 and 5
        boolean divisibleBy3And5 = (num % 3 == 0) && (num % 5 == 0);
        System.out.println("Divisible by 3 and 5: " + divisibleBy3And5);
        
        // Check if divisible by 3 or 5
        boolean divisibleBy3Or5 = (num % 3 == 0) || (num % 5 == 0);
        System.out.println("Divisible by 3 or 5: " + divisibleBy3Or5);
        
        // Quick multiply by 2 using left shift
        int doubled = num << 1;
        System.out.println("Doubled: " + doubled);
        
        // Quick divide by 2 using right shift
        int halved = num >> 1;
        System.out.println("Halved: " + halved);
    }
}
```

---

## 📝 Key Takeaways

1. ✅ Follow naming conventions: camelCase for variables, PascalCase for classes
2. ✅ Choose appropriate data types: int for integers, double for decimals
3. ✅ Use control flow statements to make decisions and repeat actions
4. ✅ Methods make code reusable and organized
5. ✅ Understand operator precedence and use parentheses for clarity
6. ✅ Logical operators (&&, ||, !) combine conditions
7. ✅ Assignment operators (+=, -=) are shortcuts for common operations
8. ✅ Ternary operator provides concise if-else alternative
9. ✅ Practice regularly to master these fundamentals

---

## 🎯 Practice Exercises

### Exercise 1: Variable Practice
Create a program with properly named variables for:
- Student details (name, age, grade, GPA)
- Use appropriate data types
- Print all information

### Exercise 2: Control Flow Challenge
Write a program that:
- Takes a number as input
- Checks if it's positive, negative, or zero
- Checks if it's even or odd
- Prints whether it's prime

### Exercise 3: Method Creation
Create a utility class with methods for:
- `isEven(int num)` - returns boolean
- `isPrime(int num)` - returns boolean
- `factorial(int num)` - returns int
- `fibonacci(int n)` - returns nth Fibonacci number

### Exercise 4: Pattern Printing
Use nested loops to print:
```
1. Right-angled triangle
*
**
***
****
*****

2. Pyramid
    *
   ***
  *****
 *******
*********

3. Number pattern
1
12
123
1234
12345
```

### Exercise 5: Operator Mastery
Write a program that:
- Takes two numbers
- Performs all arithmetic operations
- Uses relational operators to compare them
- Uses logical operators for complex conditions
- Uses ternary operator to find max/min

### Exercise 6: Grade System
Create a complete grading system:
- Input: marks and attendance percentage
- Calculate final grade (A, B, C, D, F)
- Check eligibility (marks >= 40 AND attendance >= 75%)
- Use methods, control flow, and operators

### Exercise 7: Calculator with Methods
Build a calculator with methods:
- `add(int a, int b)`
- `subtract(int a, int b)`
- `multiply(int a, int b)`
- `divide(int a, int b)` - handle division by zero
- Use method overloading for double parameters

---

## 🔗 Additional Resources

- [Java Naming Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html)
- [Java Operators Tutorial](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)
- [Control Flow Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)
- [Java Methods Documentation](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)

---

## ✅ Completed Topics Checklist

- [x] Variable naming rules and conventions
- [x] Data types (primitive and reference)
- [x] Type conversion and casting
- [x] If-else statements
- [x] Switch statements
- [x] For loops (regular and enhanced)
- [x] While and do-while loops
- [x] Break and continue
- [x] Methods declaration and calling
- [x] Method overloading
- [x] Arithmetic operators
- [x] Relational operators
- [x] Logical operators
- [x] Assignment operators
- [x] Ternary operator
- [x] Bitwise operators
- [x] Operator precedence

---

**Previous:** Day 1 - Java Fundamentals & Setup  
**Next:** Day 3 - Object-Oriented Programming Basics

**Status:** ✅ Day 2 Complete