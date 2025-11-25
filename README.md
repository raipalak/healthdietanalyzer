# healthdietanalyzer
# Health & Diet Analyzer for Hostel Students (Java)

Student: PALAK RAI
Reg: 24BCE10391

This is a Java console application skeleton for the course project "Health & Diet Analyzer for Hostel Students".

## What is included
- A simple Maven-like Java project structure under `src/`
- Core Java classes implementing Users, FoodItems, Meals, Nutrition aggregation, and a simple JSON-based datastore
- Sample data files in `data/`
- `pom.xml` for reference (no external dependencies)
- Scripts to compile and run with `javac` and `java`

## How to compile & run (Linux / macOS / Windows with Git Bash)
1. Open terminal in project root.
2. Compile:
   javac -d out $(find src -name "*.java")
   (On Windows, use PowerShell or adapt the find command.)
3. Run:
   java -cp out com.healthdiet.Main
4. The app shows a console menu to add meals and view today's summary.

## Sample Output


![Program Output](Screenshot 2025-11-25 170840.png)

## Notes
- This is a single-user console demo. Data is persisted to `data/db.json`.
- For submission, include this project ZIP on GitHub and add diagrams/report as required by the course.

## Maven usage (recommended)
This project is configured as a Maven project. To build and run:

1. Ensure Maven and Java 17+ are installed.
2. From project root:
   - mvn clean compile
   - mvn exec:java -Dexec.mainClass=com.healthdiet.Main

To run tests:
   - mvn test

You can also run ./run.sh (Unix) or run.bat (Windows) to compile and execute.
