# Squad Manager API

A REST API built with Spring Boot 4 to manage football teams, players, matches, and match sheets.

This project is the backend rewrite of [gestion-equipe-foot](https://github.com/leul-mulugeta/gestion-equipe-foot), transitioning from a PHP prototype to an API supporting multiple teams with isolated data.

## Features
- **Authentication & Roles**: JWT-based authentication with role-based access control.
- **Data Isolation**: Coaches manage strictly their own team and matches; moderators have global access.
- **Squad & Player Management**: Track players, positions, and active statuses.
- **Match Sheets**: Roster selection and lineup validation rules (starters, substitutes, minimum player requirements).
- **Public Endpoints**: Open access for match schedules and results.

## Tech Stack
- **Language**: Java 21
- **Framework**: Spring Boot 4.1.1
- **Database**: MySQL
- **Containerization**: Docker Compose
- **Build Tool**: Maven Wrapper

## Getting Started

### Prerequisites
- JDK 21+
- A running MySQL database, either:
  - **Docker** (recommended: Spring Boot starts the database automatically via Docker Compose)
  - **A standalone MySQL server**

### Run Locally
1. Clone the repository:
```powershell
git clone https://github.com/leul-mulugeta/squad-manager-api.git
cd squad-manager-api
```

2. Create your `.env` configuration file:
```powershell
cp .env.example .env
```

3. Start the application (PowerShell):
```powershell
.\mvnw.cmd spring-boot:run
```

The application runs by default on `http://localhost:8080`.

4. Test the verification endpoint:
```powershell
curl http://localhost:8080/bonjour
# Output: Bonjour le monde !
```

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
