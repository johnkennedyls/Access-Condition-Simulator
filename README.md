# README: Access Conditions Simulator

## Description
This project implements an interactive access conditions simulator based on Boolean logic. The application evaluates access based on the formula: `(isAdmin && correctKey) || specialAccess` and displays all possible combinations in a truth table.

## Prerequisites
- Java 17 or higher
- Gradle

## Technologies Used
- Spring Boot
- Thymeleaf (template engine)
- Lombok
- HTML/CSS

## Project Structure
```
src/
├── main/
│ ├── java/
│ │ └── com/
│ │ └── example/
│ │ └── demo/
│ │ ├── DemoApplication.java
│ │ ├── controller/
│ │ │ └── AccessController.java
│ │ └── model/
│ │ └── AccessCondition.java
│ └── resources/
│ ├── application.properties
│ ├── static/
│ └── templates/
│ ├── access-form.html
│ ├── access-result.html
│ └── truth-table.html
```

## How to run the application
1. Clone this repository:
```
git clone https://github.com/johnkennedyls/Access-Condition-Simulator.git
```

2. Navigate to the project directory:
```
cd Access-Condition-Simulator
```

3. Run the application with Gradle:
```
./gradlew bootRun
```
(On Windows: `gradlew.bat bootRun`)

4. Open your browser and go to:
```
http://localhost:8080/
```

## Main Features

### 1. Access Simulator
- Allows you to select/unselect three Boolean conditions:
- Is an administrator
- Correct password
- Special access
- Evaluates whether access is allowed or denied based on the logical formula

### 2. Truth Table
- Displays all possible combinations (8 in total)
- Clearly visualizes which combinations allow or deny access


## About the Project
This simulator was developed as part of an exercise to demonstrate Boolean logic concepts in an interactive web environment using Spring Boot and the Spring Boot architecture MVC.

## Author
johnkennedyls

---

For any questions or suggestions, please open an issue in this repository.
