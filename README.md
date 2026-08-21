# Placement Management System

## Project Overview

The Placement Management System is a Spring Boot based application designed to manage the college placement process.

The system manages students, companies, job drives, eligibility checking, applications, interviews, selection status, and placement analytics.

## Technologies Used

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL 8
* Maven
* Spring Security
* REST APIs
* Git & GitHub

## Main Features

### Student Management

* Add students
* View students
* View student details
* Manage student academic information

### Eligibility Checking

Students can be checked against placement criteria such as:

* Minimum CGPA
* Maximum backlogs
* Allowed branch

### Company Management

* Add companies
* View companies
* Manage company information

### Job Drive Management

* Create job drives
* View job drives
* Manage placement opportunities

### Application Management

Students can apply for available job drives.

Application statuses include:

* APPLIED
* SHORTLISTED
* SELECTED
* OFFERED

### Interview Management

The system supports interview scheduling with:

* Application ID
* Round name
* Interview date
* Interview time
* Interviewer
* Mode
* Interview status

Interview statuses include:

* SCHEDULED
* COMPLETED
* CANCELLED

### Placement Analytics

The analytics API provides information such as:

* Total students
* Total companies
* Total job drives
* Total applications
* Selected students
* Offered students

## Project Structure

```text
src/main/java/com/college/placement
│
├── config
│   └── SecurityConfig.java
│
├── controller
│   ├── AnalyticsController.java
│   ├── ApplicationController.java
│   ├── CompanyController.java
│   ├── EligibilityController.java
│   ├── InterviewController.java
│   ├── JobDriveController.java
│   └── StudentController.java
│
├── entity
│   ├── Application.java
│   ├── Company.java
│   ├── EligibilityCriteria.java
│   ├── Interview.java
│   ├── JobDrive.java
│   └── Student.java
│
├── repository
│   ├── ApplicationRepository.java
│   ├── CompanyRepository.java
│   ├── InterviewRepository.java
│   ├── JobDriveRepository.java
│   └── StudentRepository.java
│
└── service
    ├── ApplicationService.java
    ├── CompanyService.java
    ├── InterviewService.java
    ├── JobDriveService.java
    ├── StudentEligibilityService.java
    └── StudentService.java
```

## Database

The application uses MySQL.

Database name:

```text
college_placement
```

MySQL version tested:

```text
8.0.46
```

## Running the Application

### 1. Clone the repository

```bash
git clone https://github.com/pojjuruhepsiba/placement-management.git
```

### 2. Open the project

Open the project folder in VS Code or another Java IDE.

### 3. Configure MySQL

Create the database:

```sql
CREATE DATABASE college_placement;
```

Update the database username and password in:

```text
src/main/resources/application.properties
```

### 4. Start the application

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

The application runs on:

```text
http://localhost:8080
```

## API Endpoints

### Students

```text
GET    /api/students
POST   /api/students
GET    /api/students/{id}
```

### Eligibility

```text
POST   /api/eligibility/{studentId}
```

### Companies

```text
GET    /api/companies
POST   /api/companies
GET    /api/companies/{id}
```

### Job Drives

```text
GET    /api/job-drives
POST   /api/job-drives
GET    /api/job-drives/{id}
```

### Applications

```text
GET    /api/applications
POST   /api/applications
GET    /api/applications/{id}
PUT    /api/applications/{id}/status
DELETE /api/applications/{id}
```

### Interviews

```text
GET    /api/interviews
POST   /api/interviews
GET    /api/interviews/{id}
PUT    /api/interviews/{id}/status
DELETE /api/interviews/{id}
```

### Analytics

```text
GET    /api/analytics
```

## Application Flow

```text
Student
   ↓
Eligibility Check
   ↓
Job Drive
   ↓
Application
   ↓
Shortlisted
   ↓
Interview
   ↓
Selected
   ↓
Offer
```
---
## Screenshots

### Application Running

![Application Running](Screenshot%202026-08-20%20204019.png)

### Students API

![Students API](Screenshot%202026-08-20%20202736.png)

### Eligibility Check

![Eligibility API](Screenshot%202026-08-20%20202933.png)

### Applications API

![Applications API](Screenshot%202026-08-20%20203748.png)

### Interviews API

![Interviews API](Screenshot%202026-08-20%20203847.png)

### Placement Analytics

![Placement Analytics](Screenshot%202026-08-20%20203931.png)

### Additional Analytics View

![Analytics View](Screenshot%202026-08-20%20204011.png)

### Security Login

![Security Login](Screenshot%202026-08-20%20185847.png)

---
## Testing

The REST APIs were tested using PowerShell `Invoke-RestMethod`.

The application was successfully tested with:

* Student retrieval
* Eligibility checking
* Application creation
* Application status update
* Interview scheduling
* Interview status update
* Selection and offer status
* Placement analytics

## Version Control

The project is maintained using Git and GitHub.

Repository:

https://github.com/pojjuruhepsiba/placement-management

## Project Status

**Backend implementation and API testing completed.**
