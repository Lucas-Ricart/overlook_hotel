# Overlook Hotel Project

## Description
The Overlook Hotel project is a web application designed for managing hotel reservations. It features two types of users: clients and managers (employers). Clients can register, log in, and manage their reservations, while managers can oversee hotel operations.

## Technologies Used
- Java
- Spring Boot
- Spring Security
- JPA (Java Persistence API)
- PostgreSQL
- Thymeleaf
- Lombok

## Project Structure
```
overlook-hotel
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── joel_lucas_thibault
│   │   │           └── overlook_hotel
│   │   │               ├── entity
│   │   │               │   ├── Client.java
│   │   │               │   └── Employer.java
│   │   │               ├── repository
│   │   │               │   ├── ClientRepository.java
│   │   │               │   └── EmployerRepository.java
│   │   │               ├── controller
│   │   │               │   └── AuthController.java
│   │   │               └── security
│   │   │                   ├── CustomUserDetails.java
│   │   │                   ├── CustomUserDetailsService.java
│   │   │                   └── SecurityConfig.java
│   │   └── resources
│   │       ├── templates
│   │       │   ├── login.html
│   │       │   └── register.html
│   │       └── application.properties
├── pom.xml
└── README.md
```

## Features
- **User Registration**: Clients can create an account with email and password.
- **User Authentication**: Both clients and managers can log in to access their respective dashboards.
- **Role-Based Access Control**: Different access levels for clients and managers.
- **Password Security**: Passwords are hashed using BCrypt for secure storage.

## Setup Instructions
1. Clone the repository:
   ```
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```
   cd overlook-hotel
   ```
3. Update the `application.properties` file with your PostgreSQL database credentials.
4. Run the application:
   ```
   mvn spring-boot:run
   ```
5. Access the application at `http://localhost:8080/login?type=client`.

## Contribution
Feel free to fork the repository and submit pull requests for any improvements or features you would like to add.