# Social Network REST API 🚀

[![Java](https://img.shields.io/badge/Java-23-orange?style=flat-square&logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=flat-square&logo=spring-boot)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring_Security-Protected-success?style=flat-square&logo=spring-security)](https://spring.io/projects/spring-security)
[![JWT](https://img.shields.io/badge/JWT-Auth-black?style=flat-square&logo=json-web-tokens)](https://jwt.io/)
[![Hibernate](https://img.shields.io/badge/Hibernate-ORM-59666C?style=flat-square&logo=hibernate)](https://hibernate.org/)
[![MariaDB/MySQL](https://img.shields.io/badge/Database-MariaDB/MySQL-4479A1?style=flat-square&logo=mariadb)](https://mariadb.org/)

A robust, production-oriented REST API engineered to manage the backend infrastructure of a social media platform. Built with **Spring Boot 3**, this system features stateless **JWT authentication**, role-based access, complex relationship mapping, and automated unit testing to ensure a highly scalable and secure architecture.

## ✨ Key Features

* **Stateless Security:** Implemented Spring Security with custom JWT filters to authenticate and authorize HTTP requests.
* **Clean Architecture:** Strict separation of concerns following the Controller-Service-Repository pattern.
* **Unit Testing:** Core business logic is covered using **JUnit 5** and **Mockito** to ensure data integrity and prevent regressions.
* **Relational Mapping:** Advanced ORM handling via Hibernate (One-to-One, One-to-Many, Many-to-Many) for Users, Profiles, Posts, and Comments.
* **SOLID Principles:** High cohesion and loose coupling across all service implementations.

## 🏗 System Architecture

The project relies on a modular, tiered approach:

* **Security Layer:** Intercepts incoming requests, validates JWT tokens, and manages `CustomUserDetailsService` for authentication.
* **Controller Layer:** Manages REST endpoints and HTTP request/response flow.
* **Service Layer:** Encapsulates core business logic, transactional operations, and entity mapping.
* **Repository Layer:** Handles data persistence and SQL communication via Spring Data JPA interfaces.

## 📖 API Reference (Endpoints)

> 🔒 **Security Note:** All business endpoints require a valid JWT Bearer Token in the `Authorization` header (`Authorization: Bearer <token>`).

### 🔑 Authentication (`/auth`)
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **POST** | `/auth/login` | Authenticate user credentials and generate a JWT token. |

### 👤 User Controller (`/usuario`)
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/usuario/todos` | Retrieve a list of all registered users. |
| **GET** | `/usuario/{id}` | Fetch specific user details by unique ID. |
| **POST** | `/usuario` | Register a new user account. |
| **DELETE** | `/usuario/{id}` | Permanently delete a user from the system. |

### 📝 Post Controller (`/publicacion`)
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/publicacion/todos` | Fetch all posts across the platform. |
| **POST** | `/publicacion` | Create a new post linked to a user. |
| **DELETE** | `/publicacion/{id}` | Delete a specific post. |

### 💬 Comment Controller (`/comentario`)
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/comentario/todos` | Fetch all user comments. |
| **POST** | `/comentario` | Post a new comment on a publication. |
| **DELETE** | `/comentario/{id}` | Remove a comment by ID. |

### 🖼️ Profile & Role Controllers (`/perfil`, `/rol`)
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/perfil/todos` | Retrieve all public profiles (1:1 with User). |
| **GET** | `/rol/todos` | Fetch available system roles (e.g., ADMIN, USER). |

## 🛠 Tech Stack

* **Language:** Java 23
* **Framework:** Spring Boot 3.x
* **Security:** Spring Security, JSON Web Tokens (JWT)
* **Database:** MariaDB / MySQL
* **ORM:** Hibernate / Spring Data JPA
* **Testing:** JUnit 5, Mockito
* **Logging:** Logback (SLF4J)

## 🚀 Setup & Installation

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/sanchezardev/api_rest_RedSocial.git](https://github.com/sanchezardev/api_rest_RedSocial.git)
    ```
2.  **Configure Environment:**
    Update `src/main/resources/application.properties` with your SQL database credentials and your JWT Secret Key:
    ```properties
    spring.datasource.url=jdbc:mariadb://localhost:3306/your_database
    spring.datasource.username=your_user
    spring.datasource.password=your_password
    ```
3.  **Build & Run:**
    Using Maven wrapper:
    ```bash
    ./mvnw clean install
    ./mvnw spring-boot:run
    ```

---
**Developed by Óscar Sánchez**
[Portfolio](https://sanchezardev.github.io/) | [LinkedIn](https://www.linkedin.com/in/sanchezar/)