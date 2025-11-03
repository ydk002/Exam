Car Service Intake — Java 6 OOP Exam

This project is a console-based Java application designed to meet the requirements of a Java 6 OOP exam. The application simulates the intake process for a car service center by parsing a data.json file, applying business logic, and generating a summary report.

This solution was developed with a "pass-focused" strategy, prioritizing the core OOP, data processing, and business logic requirements over the optional GUI.

Core Requirements Implemented

Language: Pure Java 6 (No Java 8+ features like streams, lambdas, or java.time).

OOP Model:

BaseEntity abstract class with equals(), hashCode(), and businessKey().

Billable and Schedulable interfaces used in logic.

Class hierarchy with ReportedIssue as a base class (extended by MechanicalIssue and ElectricalIssue).

Static counter used in WorkOrder.

Method overloading (in Intake constructor) and overriding (toString(), equals(), etc.).

Collections: ArrayList is used as the primary collection structure.

Sorting: Collections.sort() is used with a custom IssueSeverityComparator.

I/O:

FileReader is used to read data.json.

FileWriter / PrintWriter is used to generate report.txt.

Error Handling:

Custom checked DomainValidationException is used.

Defensive Parsing: The parser gracefully handles a "trap" entry in the JSON (the corrupted SRV-INVALID-999 object) by using a try-catch block inside the main parsing loop, allowing it to skip bad data without crashing.

Business Tasks Completed

Costing: Labor and parts costs are calculated polymorphically using the Billable interface (Task, Part) and summed by each WorkOrder.

Courtesy Car: The 15 EUR/day fee (max 5 days) is applied.

"Do Not Release" Flag: Intakes are flagged if diagnostics contain "P0420" or an "Oil pressure" test is not ok.

Prioritized Issues: Issues are sorted by severity (HIGH > MEDIUM > LOW) using the Comparator before being written to the report.

How to Run the Project

Place data.json: Ensure the data.json file provided by the instructor is in the root directory of the NetBeans project (the same level as the src and nbproject folders).

Run: Execute the Main.java file (or com.mycompany.exam.Main.java).

Check Output:

The console will display a live summary of the parsing and logic steps.

A new file, report.txt, will be generated in the project's root directory with the full, detailed results.

Project Scope

This project successfully implements all mandatory console, OOP, and data-processing logic. The final (optional) Swing GUI wizard was intentionally not implemented to ensure all core requirements were met perfectly within the time limit.
