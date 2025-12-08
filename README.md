# Portfolio project IDATG1003

STUDENT NAME = Jonas Torvanger  
STUDENT ID = 10033

## Project description

This project implements a console-based training diary where a user can register, view and delete training sessions. A session contains information such as: 

- Title of the session
- Author
- Description
- Duration in minutes
- Exercise type
- Date (automatic or custom)

The goal of the project has been to implement a solution with high cohesion and low coupling, using clean class reponsibilities, input validation and exception handling. 

## Project structure

The project follows a Model–View–Controller (MVC) structure.

````markdown


```plaintext
.
├── .github/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── edu/
│   │           └── ntnu/
│   │               └── iir/
│   │                   └── bidata/
│   │                       ├── Main.java
│   │                       ├── controller/
│   │                       │   └── menus/
│   │                       │       ├── EntryAdministrations.java
│   │                       │       ├── EntryOverview.java
│   │                       │       └── MainMenu.java
│   │                       ├── view/
│   │                       │   ├── DiaryPrinter.java
│   │                       │   └── Ui.java
│   │                       └── model/
│   │                           ├── DiaryEntry.java
│   │                           └── DiaryRegister.java
│   └── test/
│       └── java/
│           └── edu/
│               └── ntnu/
│                   └── iir/
│                       └── bidata/
│                           ├── DiaryEntryTest.java
│                           └── DiaryRegisterTest.java
├── .gitignore
├── README.md
└── pom.xml
````

### Package usage

- Model: contains domain objects and business logic
- View: prints to the console
- Controller/menus: handles program flow and user interaction
- Test: contains JUnit tests

## Link to repository

https://github.com/NTNU-IE-IDI-IDATG1003-2025/mappe-idatg1003-2025-jonatorv

## How to run the project

### Requirements
- Java 21 (or newer)
- Maven

### Run with IntelliJ (recommended)
1. Download or clone the project from GitHub.
2. Open the project folder in IntelliJ IDEA.
3. In the project view, locate the class: edu.ntnu.iir.bidata.Main
4. Right-click the file and choose: Run 'Main.main()'

The console menu will appear in the Run window.

### Program behaviour
When the program starts, a console menu is displayed.
Available actions:
- View all diary entries
- View entries from a specific date
- View entries sorted by date (newest → oldest)
- Create a new entry (automatic or custom date)
- Delete entries from a selected date
- Exit application

The program reads input from the keyboard and prints information to the console. 

If If IntelliJ reports “No JDK” or “JDK missing”, set the Project SDK to Java 21: 

- File → Project Structure → Project → Project SDK = 21

Then reload Maven: 

- Maven → Reload All Maven Projects



## How to run the tests

The project uses JUnit 5 for unit testing.
All test classes are located under: src/test/java/edu/ntnu/iir/bidata/

To run the tests in IntelliJ:

1. Open the project in IntelliJ IDEA
2. Right-click the test folder
3. Choose Run 'Tests in bidata' (or Run 'All Tests')

This will execute:
- DiaryEntryTest
- DiaryRegisterTest

All tests are expected to run without errors.

## References

Java Platform SE 21 Documentation. (2024). Oracle.
https://docs.oracle.com/en/java/javase/21/

JUnit 5 User Guide. (2024).
https://junit.org/junit5/docs/current/user-guide/

Maven Documentation. (2024). Apache Software Foundation.
https://maven.apache.org/

Google Java Style Guide. (2024).
https://google.github.io/styleguide/javaguide.html

CheckStyle Documentation. (2024).
https://checkstyle.sourceforge.io/

GitHub Documentation. (2024).
https://docs.github.com/
