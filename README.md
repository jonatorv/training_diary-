[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/8WbEQaRE)
# Portfolio project IDATG1003
This file uses Mark Down syntax. For more information see [here](https://www.markdownguide.org/basic-syntax/).

[//]: # (TODO: Fill inn your name and student ID)

STUDENT NAME = Jonas Torvanger  
STUDENT ID = "Your ID"

## Project description

This projects implements a console-based training diary where a user can register, view and delete training sessions. A session contains information such as: 

- Title of the session
- Author
- Description
- Duration in minutes
- Exercise type
- Date (automatic or custom)

The goal of the projects has been to implement a solution with high cohesion and low coupling, using clean class reponsibilities, input validation and exception handling. 

## Project structure

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





[//]: # (TODO: Describe the structure of your project here. How have you used packages in your structure. Where are all sourcefiles stored. Where are all JUnit-test classes stored. etc.)

## Link to repository

[//]: # (TODO: Include a link to your GitHub repository here.)

## How to run the project

[//]: # (TODO: Describe how to run your project here. What is the main class? What is the main method?
What is the input and output of the program? What is the expected behaviour of the program?)

## How to run the tests

[//]: # (TODO: Describe how to run the tests here.)

## References

[//]: # (TODO: Include references here, if any. For example, if you have used code from the course book, include a reference to the chapter.
Or if you have used code from a website or other source, include a link to the source.)
