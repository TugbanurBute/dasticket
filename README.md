# DasTicket

DasTicket is a backend application for managing concerts and events.

The project is being developed step by step to demonstrate how a real-world backend application evolves from a simple CRUD service into a production-ready system.

---

## Tech Stack

- Java 21
- Spring Boot 4
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- Maven

---

## Features

### Implemented

- Create, update and delete events
- Event search by keyword
- Dynamic filtering (city, artist, venue, price and date range)
- Pagination
- Sorting
- Bean Validation
- Dockerized application
- PostgreSQL persistence with Docker Volume

### Planned

- Global Exception Handling
- Swagger / OpenAPI
- Unit & Integration Tests
- Redis Cache
- RabbitMQ
- JWT Authentication
- GitHub Actions CI/CD

---

## Running with Docker

Build and start the application

```bash
docker compose up --build
```

The API will be available at

```
http://localhost:8080
```

---

## API Examples

Create Event

```
POST /events
```

Get Events

```
GET /events
```

Filter Events

```
GET /events?city=Berlin&artist=Coldplay&page=0&size=10
```

---

## Decision Log

- Dynamic filtering implemented using Spring Data JPA Specifications.
- Case-insensitive filtering supported for text fields.
- Docker Compose used to run both PostgreSQL and the application.
- Database configuration externalized using environment variables.
- Search endpoint kept separate from advanced filtering for clarity.


--- 


                            Bruno / Postman
                                   │
                                   ▼
                          Spring Boot REST API
                                   │
                                   ▼
                            Spring Data JPA
                                   │
                                   ▼
                               PostgreSQL
        
                  ┌──────────────────────────────┐
                  │        Docker Compose        │
                  ├──────────────┬───────────────┤
                  │ Spring Boot  │ PostgreSQL    │
                  └──────────────┴───────────────┘