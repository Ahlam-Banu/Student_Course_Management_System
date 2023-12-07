# Student Course Management System

## 1. Introduction
This project is the culmination of the Java Server Programming Course, focusing on developing a streamlined student and course management system using Java Spring.

## 2. Project Requirements

### Basic Requirements
- Creation of REST API for user authentication and management of students and courses.
- Access control: Only authorized users can edit and add student/course data; others can view data and perform searches by ID.

### Bonus Requirements
- User interface development using ReactJS.
- REST API integration to list students enrolled in a course.
- User registration with username and password.
- Secure password storage using Hash format.

## 3. Database Structure
### Student and Course Diagram
<img width="452" alt="scms_ds" src="https://github.com/Ahlam-Banu/Student_Course_Management_System/assets/102663986/23568760-179b-4f35-8388-505ead77615f">

![scms_ds_user](https://github.com/Ahlam-Banu/Student_Course_Management_System/assets/102663986/2397d739-80f8-4c5a-827e-749080b70eea)

## 4. Use Case Diagrams

### Authentication API
#### Authentication Use Case Diagrams
- User registration with a new username and password.
- User login using a username and password.
![ucd](https://github.com/Ahlam-Banu/Student_Course_Management_System/assets/102663986/c0cb64a5-5eaf-459a-9391-45291e8c9ce6)

### Student / Course API
#### Student and Course Use Case Diagram
- Access for all users to view course and student data.
- Limited access for authorized users to update, add, modify, or delete data.
![ucd_sc](https://github.com/Ahlam-Banu/Student_Course_Management_System/assets/102663986/b4e4ac5d-277c-4252-830c-e81d84a466e4)

## 5. API Endpoints

### Student API
- GET /students: Get all students.
- AUTH POST /students: Add a new student (JSON in the request body).
- GET /students/{id}: Get a student by ID.
- AUTH PUT /students/{id}: Update a student by ID.
- AUTH DELETE /students/{id}: Delete a student by ID.

### Course API
- GET /courses: Get all courses.
- AUTH POST /courses: Add a new course (JSON in the request body).
- GET /courses/{id}: Get a course by ID (bonus: return a list of enrolled students).
- AUTH PUT /courses/{id}: Update a course by ID.
- AUTH DELETE /courses/{id}: Delete a course by ID.

### Authentication API
- POST /register: Register a new user with username and password (JSON in the request).
- POST /login: Check username and password; if correct, return a JWT token.

## API Gateways

| Gateway         | Endpoint               | Purpose                       | Authentication Required |
| --------------- | ---------------------- | ----------------------------- | ------------------------ |
| Users API       | `/api/users`           | Manage user information      | Yes                      |
| Students API    | `/api/students`        | CRUD operations on students  | No (Read operations), Yes (Create, Update, Delete) |
| Courses API     | `/api/courses`         | CRUD operations on courses   | Yes                      |
| Authentication  | `/login` or `/users/login` | User login and authentication | No                      |

## Authentication Details

- **Users API:**
  - Requires authentication for all operations.
  - Uses JWT for authentication.

- **Students API:**
  - Requires authentication for Create, Update, and Delete operations.
  - No authentication required for Read operations.
  - Uses JWT for authentication.

- **Courses API:**
  - Requires authentication for all CRUD operations.
  - Uses JWT for authentication.

- **Authentication:**
  - Handles user login and provides JWT tokens.
  - No authentication required for the authentication endpoint.

## Usage

1. **Users API:**
   - Endpoint: `/api/users`
   - Methods: GET, POST, PUT, DELETE

2. **Students API:**
   - Endpoint: `/api/students`
   - Methods: GET (No authentication), POST, PUT, DELETE (Requires authentication)

3. **Courses API:**
   - Endpoint: `/api/courses`
   - Methods: GET, POST, PUT, DELETE

4. **Authentication:**
   - Endpoint: `/login` or `/users/login`
   - Method: POST
   - Provide username and password in the request body to obtain a JWT token.

## Demo Images

### Front-End Views
#### Students

#### Courses

#### Login 

This revised presentation should provide a clearer overview of your Student Management System project. Feel free to adjust any specific details or sections further as needed!
