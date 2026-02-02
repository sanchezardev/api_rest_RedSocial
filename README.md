# Social Network REST API 🚀

[![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=flat-square&logo=spring-boot)](https://spring.io/projects/spring-boot)
[![Hibernate](https://img.shields.io/badge/Hibernate-ORM-59666C?style=flat-square&logo=hibernate)](https://hibernate.org/)
[![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=flat-square&logo=mysql)](https://www.mysql.com/)

A professional Backend REST API designed to manage the infrastructure of a social media platform. The system implements a robust separation between user accounts, public profiles, and interaction logic using **Spring Boot**.

## 🏗 System Architecture

The project follows a **Layered Architecture** (Controller, Service, Repository) to ensure modularity and scalability:

* **Controller Layer:** Manages REST endpoints and HTTP request/response flow.
* **Service Layer:** Encapsulates core business logic and cross-entity operations.
* **Repository Layer:** Handles data persistence and SQL communication via Spring Data JPA.

## 📖 API Reference (Endpoints)

All requests and responses are handled in **JSON** format.

### 👤 Usuario Controller (`/usuario`)
*Manages core account data and user registration.*

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/usuario/todos` | Retrieve a list of all registered users. |
| **GET** | `/usuario/{id}` | Fetch specific user details by unique ID. |
| **POST** | `/usuario` | Create and register a new user account. |
| **DELETE** | `/usuario/{id}` | Permanently delete a user from the system. |

### 🖼️ Perfil Controller (`/perfil`)
*Handles public-facing profile information (One-to-One relationship with User).*

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/perfil/todos` | Retrieve all public profiles. |
| **GET** | `/perfil/{id}` | Fetch a specific profile by ID. |
| **POST** | `/perfil` | Create a new public profile. |
| **DELETE** | `/perfil/{id}` | Delete a profile record. |

### 💬 Comentario Controller (`/comentario`)
*Manages user interactions and feedback logic.*

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/comentario/todos` | Fetch all comments across the platform. |
| **GET** | `/comentario/{id}` | Get details of a specific comment. |
| **POST** | `/comentario` | Post a new comment. |
| **DELETE** | `/comentario/{id}` | Remove a comment by ID. |

## 🛠 Tech Stack

* **Language:** Java 17
* **Framework:** Spring Boot 3.x (Spring Web, Spring Data JPA)
* **Database:** MySQL / MariaDB
* **ORM:** Hibernate
* **Testing:** Postman (Integration Testing)

## 🚀 Setup & Installation

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/sanchezardev/api_rest_RedSocial.git](https://github.com/sanchezardev/api_rest_RedSocial.git)
    ```
2.  **Configure Environment:**
    Update `src/main/resources/application.properties` with your SQL database credentials.
3.  **Build & Run:**
    ```bash
    mvn spring-boot:run
    ```

---
**Developed by Óscar Sánchez**
[Portfolio](https://sanchezardev.github.io/) | [LinkedIn](https://www.linkedin.com/in/sanchezar/)
