# Student Management System

## Overview

The Student Management System is a Spring Boot REST API project that allows users to manage student records. It supports complete CRUD (Create, Read, Update, Delete) operations and uses Oracle Database for data storage.

## Features

* Add a new student
* Get student details by ID
* Get all students
* Update student information
* Delete a student
* RESTful API design
* Layered architecture (Controller, Service, Repository)
* DTO implementation
* Exception handling
* Input validation

## Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* Oracle Database
* Maven
* Postman
* Git & GitHub

## Project Structure

```
src
 ├── controller
 ├── dto
 ├── entity
 ├── repository
 ├── service
 ├── serviceimpl
 ├── exception
 └── StudentManagementSystemApplication.java
```

## API Endpoints

| Method | Endpoint         | Description        |
| ------ | ---------------- | ------------------ |
| POST   | `/students`      | Register a student |
| GET    | `/students`      | Get all students   |
| GET    | `/students/{id}` | Get student by ID  |
| PUT    | `/students/{id}` | Update student     |
| DELETE | `/students/{id}` | Delete student     |

## Database

* Oracle Database
* Spring Data JPA
* Hibernate ORM

## Testing

All APIs were tested successfully using Postman.

## Screenshots

Project screenshots are available in the `screenshots` folder.

## Future Enhancements

* Swagger/OpenAPI documentation
* Spring Security with JWT Authentication
* Pagination and Sorting
* Search and Filter APIs
* Unit Testing

## Author

Kolla Supraja
