
# Springboot ToDoList Application

### Technologies

 * Springboot
 * Maven
 * Java corretto 11
 * Spring JPA
 * MariaDB
 * Spring Security
 * Thymeleaf

### Business Requirement:

The Todolist Application enables a user to Show the item list as the Home page. Edit and delete item
on the Home page. Add item and Add Group for the item on different pages. Change the theme to dark
light mode in the navbar.

### Work-Flow:

homepage/
Show item list

Add item

Edit item in service

saveOrUpdateGroup in groupservice

getGroupList in groupservice

findAllByUserID in todoitem service

starter dependencies:

 * Spring web
* Spring Boot DevTools
* Lombok
* Thymeleaf
* Mariadb Driver
* Spring Data JPA
* Validation

### Requirement 1 - Models:

no args constructor

all args constructor

required args constructor

setters and getter

toString (exclude collections to avoid infinite loops)

override equals and hashcode methods (don't use lombok here)

helper methods

### Requirement 2 - Data Access Object(Repositories) interfaces:

GroupRepository

TodolistRepository

statusRepository

UserRepository


### Requirement 3 - Service layer:

implement interfaces:

GroupService: implement GroupRepository required methods.
TodolistService: implement TodolistRepository required methods.

### Requirement 4 - Controllers

HomeController

    general endpoints
StudentController

    mapping for services
CourseController

    mapping for services

### Requirement 5 - View using Thymeleaf

    build a template using thymeleaf fragments

### Requirement 6 - Spring Security

      implement spring security

### Requirement 7 - Testing

     use mock database H2 to test data
     AssertJ tests
