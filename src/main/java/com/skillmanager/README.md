# Enterprise Resource Allocation & Skill Management System (ERASM)

## Project Overview

The Enterprise Resource Allocation & Skill Management System (ERASM) is a Spring Boot REST API application developed to manage employees, skills, projects, and resource allocation within an organization. The system provides secure authentication using JWT and role-based authorization to manage different user responsibilities.

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- REST APIs
- BCrypt Password Encoder

---

## Features

### Authentication
- User Registration
- User Login
- JWT Token Authentication
- Role-Based Authorization

### User Management
- Create User
- View User
- Update User
- Delete User

### Employee Management
- Employee CRUD Operations

### Skill Management
- Skill CRUD Operations

### Employee Skill Management
- Assign Skills to Employees
- Update Employee Skills

### Project Management
- Create Project
- Update Project
- Delete Project
- View Projects

### Resource Management
- Resource Requests
- Resource Allocation

### Dashboard
- Employee Dashboard
- Utilization Summary

### Audit Management
- Audit Log APIs

### Exception Handling
- Global Exception Handler
- Custom Error Responses

### Security
- JWT Authentication
- BCrypt Password Encryption
- Spring Security
- Role-Based Access Control (RBAC)

---

## Project Structure

```
src
 ├── controller
 ├── service
 ├── service/impl
 ├── repository
 ├── entity
 ├── dto
 ├── security
 ├── exception
 ├── config
 └── util
```

---

## Database

MySQL Database

Main Tables

- users
- roles
- employees
- skills
- employee_skills
- projects
- resource_requests
- allocations
- audit_logs

---

## API Endpoints

### Authentication
- POST /auth/register
- POST /auth/login

### Users
- GET /users
- POST /users
- PUT /users/{id}
- DELETE /users/{id}

### Employees
- GET /employees
- POST /employees

### Skills
- GET /skills
- POST /skills

### Projects
- GET /projects
- POST /projects

### Resource Requests
- GET /resourceRequests
- POST /resourceRequests

### Allocations
- GET /allocations
- POST /allocations

---

## Security

- Spring Security
- JWT Authentication
- BCrypt Password Encoder
- Role-Based Authorization

---

## Author

Kavyashree R
