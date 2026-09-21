# Squad Manager API

A REST API built with Spring Boot 3 to manage football teams, players, matches, and match sheets.

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
- **Build Tool**: Maven Wrapper

## Getting Started

### Prerequisites
- JDK 21+

### Run Locally
1. Clone the repository:
```bash
git clone https://github.com/leul-mulugeta/squad-manager-api.git
cd squad-manager-api
```

2. Start the application (PowerShell):
```bash
.\mvnw.cmd spring-boot:run
```

The application runs by default on `http://localhost:8080`.

3. Test the verification endpoint:
```bash
curl http://localhost:8080/bonjour
# Output: Bonjour le monde !
```

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
