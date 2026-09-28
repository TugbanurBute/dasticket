# DasTicket

> A software engineering journey showing how a simple monolithic application evolves into a production-ready distributed system.

DasTicket is a backend-focused ticket sales platform built from scratch. The project follows the evolution of a real software product, where every architectural decision is driven by an actual business problem instead of adding technologies just for demonstration.

This repository is accompanied by a blog series that documents the engineering decisions behind each milestone.

---

## Philosophy

Every technology in this repository exists because a real problem required it.

The goal is not to build a project with as many technologies as possible.

The goal is to understand when and why those technologies become necessary.

---

# Current Tech Stack

- Java 21
- Spring Boot 4.1
- Spring Data JPA
- PostgreSQL
- Docker
- Maven
- Lombok

---

# Current Features

## Event Management

- Create Event
- Get All Events
- Get Event by Id
- Update Event
- Delete Event

## Search

- Search by title
- Search by artist
- Search by venue
- Search by city

## Pagination

- Pageable support
- Configurable page size
- Page metadata

## Validation

- Bean Validation
- Future event validation
- Global exception handling

---

# Project Progress

| Status | Feature |
|--------|---------|
| ✅ | Spring Boot project setup |
| ✅ | Dockerized PostgreSQL |
| ✅ | Event CRUD |
| ✅ | Validation |
| ✅ | Global Exception Handler |
| ✅ | Search |
| ✅ | Pagination |
| ⏳ | Sorting |
| ⏳ | Advanced Filtering |
| ⏳ | Swagger Documentation |
| ⏳ | Authentication |
| ⏳ | Ticket Purchase |
| ⏳ | Payment Integration |
| ⏳ | Redis |
| ⏳ | RabbitMQ |
| ⏳ | Outbox Pattern |
| ⏳ | Docker Image |
| ⏳ | GitHub Actions |
| ⏳ | Monitoring |
| ⏳ | Microservice Migration |

---

# Roadmap

The project intentionally starts as a simple monolith.

Instead of introducing modern technologies from day one, each new component will be added only when the application reaches a point where the current solution becomes insufficient.

The goal is to demonstrate **why** a technology is introduced, not only **how** to configure it.

---

# Blog Series

Each engineering decision will be documented in a companion blog series.

Episode 1 — Bootstrap the Backend

Episode 2 — CRUD & Validation

Episode 3 — Search

Episode 4 — Pagination

Episode 5 — Sorting

...
