# 🐾 Manopata API

Backend API for a pet adoption and animal welfare management platform. Developed as Full Stack Development Master's final project.

## 📋 Overview

Manopata API provides a complete RESTful backend for managing pet adoptions, animal profiles, user authentication, and administrative operations for animal shelters and adoption centers.

## 🛠️ Tech Stack

- **Framework:** Spring Boot 3.x
- **Language:** Java 17+
- **Build Tool:** Gradle
- **Database:** PostgreSQL
- **Architecture:** RESTful API
- **Authentication:** JWT (JSON Web Tokens)

## ✨ Features

- 🔐 User authentication and authorization
- 🐕 Pet profile management (CRUD operations)
- 📝 Adoption request workflow
- 👥 User management (adopters, shelters, admins)
- 🏥 Animal health records tracking
- 📊 Administrative dashboard endpoints
- 🔍 Advanced search and filtering
- 📧 Email notifications

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- PostgreSQL 14+
- Gradle 8.x

### Installation

1. Clone the repository:
```bash
git clone https://github.com/IsabellaTobon/Manopata-API.git
cd Manopata-API
```

2. Configure database connection in `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/manopata
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Build the project:
```bash
./gradlew build
```

4. Run the application:
```bash
./gradlew bootRun
```

The API will be available at `http://localhost:8080`

## 📚 API Documentation

### Base URL
```
http://localhost:8080/api/v1
```

### Main Endpoints

#### Authentication
- `POST /auth/register` - Register new user
- `POST /auth/login` - User login
- `POST /auth/refresh` - Refresh JWT token

#### Pets
- `GET /pets` - List all pets
- `GET /pets/{id}` - Get pet details
- `POST /pets` - Create new pet profile
- `PUT /pets/{id}` - Update pet information
- `DELETE /pets/{id}` - Delete pet profile

#### Adoptions
- `GET /adoptions` - List adoption requests
- `POST /adoptions` - Create adoption request
- `PUT /adoptions/{id}/status` - Update adoption status

#### Users
- `GET /users/profile` - Get current user profile
- `PUT /users/profile` - Update user profile
- `GET /users/{id}` - Get user by ID (admin only)

## 🗄️ Database Schema

The application uses PostgreSQL with the following main entities:

- **Users** - User accounts and authentication
- **Pets** - Animal profiles and information
- **Adoptions** - Adoption request records
- **Shelters** - Animal shelter information
- **HealthRecords** - Medical history for pets

## 🧪 Testing

Run tests with:
```bash
./gradlew test
```

## 📦 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/manopata/
│   │       ├── config/          # Configuration classes
│   │       ├── controller/      # REST controllers
│   │       ├── dto/             # Data Transfer Objects
│   │       ├── entity/          # JPA entities
│   │       ├── repository/      # Data repositories
│   │       ├── service/         # Business logic
│   │       └── security/        # Security configuration
│   └── resources/
│       ├── application.properties
│       └── data.sql
└── test/
    └── java/
        └── com/manopata/        # Unit and integration tests
```

## 🔒 Security

- JWT-based authentication
- Password encryption with BCrypt
- Role-based access control (USER, SHELTER, ADMIN)
- CORS configuration for frontend integration
- Input validation and sanitization

## 🤝 Contributing

This is an academic project developed as a Master's thesis. Contributions, issues, and feature requests are welcome for educational purposes.

## 👥 Authors

- **Isabella Tobón** - [@IsabellaTobon](https://github.com/IsabellaTobon)
- **Inazio Claver** - [@inazense](https://github.com/inazense) - Project Advisor

## 📄 License

This project was developed as part of a Full Stack Development Master's program.

## 📬 Contact

For questions or feedback about this project, please open an issue or contact the repository owner.

---

**Master's Thesis Project** | Full Stack Development | 2024
