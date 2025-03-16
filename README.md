# Java Employee Management System (JEMS1)

## Project Overview
JEMS1 is a simple Employee Management System developed in Java with a Swing-based GUI and MySQL as the database. It allows users to manage employee records, including adding, removing, updating, and viewing employees. 

## Features
- Employee Authentication and Login System
- Add, Remove, Update, and View Employee Details
- Database Connectivity with MySQL
- Graphical User Interface (GUI) using Swing
- Secure Data Handling with MySQL Connector

## Project Structure
```
JEMS1/
│── src/
│   ├── pkg/
│   │   ├── AddEmp.java
│   │   ├── Conn.java
│   │   ├── Login.java
│   │   ├── MainSc.java
│   │   ├── RemEmp.java
│   │   ├── Splash.java
│   │   ├── UpdateEmp.java
│   │   ├── ViewEmp.java
│   ├── mysql-connector-java-8.0.28.jar
│   ├── jcalendar-tz-1.3.3-4.jar
│   ├── ResultSet2xml.jar
│── out/
│── .gitignore
│── JEMS1.iml
│── README.md
```

## Installation and Setup
### Prerequisites
- Java Development Kit (JDK) 8 or higher
- MySQL Database Server
- MySQL Connector (`mysql-connector-java-8.0.28.jar`)
- An Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse

### Database Configuration
1. Open MySQL and create a database:
   ```sql
   CREATE DATABASE empmansys;
   ```
2. Switch to the newly created database:
   ```sql
   USE empmansys;
   ```
3. Create the employee table:
   ```sql
   CREATE TABLE employees (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       age INT NOT NULL,
       department VARCHAR(100),
       salary DECIMAL(10,2)
   );
   ```
4. Update `Conn.java` with your MySQL credentials:
   ```java
   String url = "jdbc:mysql://localhost:3306/empmansys";
   String user = "root"; 
   String password = "your_password";
   ```

### Running the Project
1. Open the project in an IDE.
2. Ensure `mysql-connector-java-8.0.28.jar` is added to the classpath.
3. Run `MainSc.java` or `Splash.java` to launch the application.

## Future Enhancements
- Role-based Access Control (Admin, HR, Employee)
- Improved GUI with JavaFX
- Export Employee Data to CSV or PDF
- Cloud Database Integration

This project serves as a basic employee management system and can be extended to include more advanced features.
