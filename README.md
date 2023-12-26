# Springboot Students
Springboot students is a project to help me practice Spring concepts such as Repositories, Template Engines, CommandLine Runners, and many more.

## Features
<hr />

* Automatically creates a `student` PostgreSQL table inside the `Playground` database with the following columns:
  * Student ID
  * First Name
  * Last name
  * Email Address
  * Birthday
  * Grade
* Pre-populate the `students` database using CommandLine Runner
* User should be able to list all students in the database
* User should be able to list a specific student in the database
* User should be able to view list of students using Thymeleaf template. 
* User should be able to create a student
* User should be able to update a student's information
* User should be able to delete a student
* User should be able to get top 5 highest grade students
* User should be able to get top 5 oldest students

## Running and Usage
<hr />

``` 
Note: This method uses the built-in run function of an IDE. You may choose to run and execute this project in anyway you want (e.g. Through CommandLine). 
```
1. Clone git repository
2. Setup Maven through IntelliJ IDE
3. Run the `SprigbootStudentsApplication`
4. Access it through `http://localhost:8080`

## Endpoints
<hr />

| Method | Endpoint                               | Description                                               |
|-------|----------------------------------------|-----------------------------------------------------------|
| `N/A`   | http://localhost:8080                  | Display project welcome banner and list of all endpoints  |
| `N/A`   | http://localhost:8080/students         | Display list of all students in the database              |
| `GET`   | http://localhost:8080/api/students     | List down all students in the database                    |
| `GET`   | http://localhost:8080/api/student/:id  | Find a student with the specific id                       |
| `POST`  | http://localhost:8080/api/student/     | Inserts a new instance of student in the database         |
| `PATCH` | http://localhost:8080/api/student/:id  | Update information of a student                           |
| `DELETE`| http://localhost:8080/api/student/:id  | Deletes a student from the database                       |