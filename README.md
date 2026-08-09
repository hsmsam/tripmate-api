# TripMate API

A RESTful backend API for managing travel experiences. Built with Java and Spring Boot, TripMate allows travellers to log destinations, plan trips, and record experiences — with automatic calculations for trip summaries, budget tracking, and experience ratings.

## Features

- Manage destinations, trips, and experiences with full CRUD operations
- Filter trips by destination and budget range
- Filter experiences by activity type
- Automatic trip summary generation — total spent, remaining budget, average rating, best experience, and most common activity
- Top rated experience lookup per trip
- Activity categories enforced via enum — Food, Hiking, Shopping, Beach, Culture, Nightlife, Adventure, Sightseeing

## Tech Stack

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Docker**
- **Maven**

## Getting Started

### Prerequisites

- Java 17+
- Docker and Docker Compose
- Maven

### Database Setup

Start the PostgreSQL database using Docker Compose:

```bash
docker-compose up -d
```

### Running the Application

```bash
mvn spring-boot:run
```

The API starts on `http://localhost:8080`.

---

## API Endpoints

### Destinations

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/destination` | Get all destinations |
| GET | `/api/v1/destination/{id}` | Get destination by ID |
| GET | `/api/v1/destination/country/{country}` | Get destinations by country |
| POST | `/api/v1/destination` | Add a new destination |
| PUT | `/api/v1/destination/{id}` | Update destination details |
| DELETE | `/api/v1/destination/{id}` | Remove a destination |

### Trips

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/trip` | Get all trips |
| GET | `/api/v1/trip/{id}` | Get trip by ID |
| GET | `/api/v1/trip/destination/{id}` | Get trips by destination |
| GET | `/api/v1/trip/budget/{max}` | Get trips within a budget |
| GET | `/api/v1/trip/{id}/summary` | Get full trip summary |
| GET | `/api/v1/trip/{id}/total-cost` | Get total experience cost |
| GET | `/api/v1/trip/{id}/total-spent` | Get total amount spent |
| GET | `/api/v1/trip/{id}/remaining-budget` | Get remaining budget |
| GET | `/api/v1/trip/{id}/average-rating` | Get average experience rating |
| GET | `/api/v1/trip/{id}/number-of-experiences` | Get number of experiences |
| POST | `/api/v1/trip` | Add a new trip |
| PUT | `/api/v1/trip/{id}` | Update trip details |
| DELETE | `/api/v1/trip/{id}` | Remove a trip |

### Experiences

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/experience` | Get all experiences |
| GET | `/api/v1/experience/{id}` | Get experience by ID |
| GET | `/api/v1/experience/type/{type}` | Get experiences by activity type |
| GET | `/api/v1/experience/trip/{tripId}/top-rated` | Get top rated experience for a trip |
| POST | `/api/v1/experience` | Add a new experience |
| PUT | `/api/v1/experience/{id}` | Update experience details |
| DELETE | `/api/v1/experience/{id}` | Remove an experience |

---

## Example Requests

### Add a Destination

```json
POST /api/v1/destination
Content-Type: application/json

{
  "city": "Melbourne",
  "country": "Australia",
  "description": "Melbourne is Australia's cultural capital, known for its coffee, street art, and vibrant food scene."
}
```

### Add a Trip

```json
POST /api/v1/trip
Content-Type: application/json

{
  "tripName": "Summer 2027",
  "travellerName": "Sam",
  "destination": { "id": 1 },
  "startDate": "2027-07-01",
  "endDate": "2027-07-14",
  "budget": 3000
}
```

### Add an Experience

```json
POST /api/v1/experience
Content-Type: application/json

{
  "trip": { "id": 1 },
  "title": "Visit Federation Square",
  "activity": "SIGHTSEEING",
  "price": 0,
  "rating": 4.5,
  "review": "A stunning public space in the heart of Melbourne. Free to visit and packed with culture, events, and great views of the Yarra River."
}
```

### Get Trip Summary

```
GET /api/v1/trip/1/summary
```

Example response:

```json
{
  "tripName": "Summer 2027",
  "budget": 3000,
  "totalSpent": 450.00,
  "remainingBudget": 2550.00,
  "numberOfExperiences": 5,
  "averageRating": 4.3,
  "bestRatedExperience": { ... },
  "mostCommonActivity": "SIGHTSEEING"
}
```

---

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/project/tripmateapi/
│   │       ├── Destination.java
│   │       ├── DestinationController.java
│   │       ├── DestinationRepository.java
│   │       ├── DestinationService.java
│   │       ├── Trip.java
│   │       ├── TripController.java
│   │       ├── TripRepository.java
│   │       ├── TripService.java
│   │       ├── TripSummary.java
│   │       ├── Experience.java
│   │       ├── ExperienceController.java
│   │       ├── ExperienceRepository.java
│   │       ├── ExperienceService.java
│   │       └── ActivityType.java
│   └── resources/
│       └── application.properties
├── docker-compose.yml
```

---

## What I Learned

- Designing and building a multi-entity REST API from scratch
- Implementing JPA relationships — ManyToOne and OneToMany — across three connected entities
- Writing derived query methods in Spring Data JPA for custom filtering
- Using Java Streams and Collectors for business logic calculations — average ratings, total costs, most common category
- Building a Trip Summary response object that derives multiple metrics automatically from related data
- Structuring a Spring Boot application cleanly using the Controller, Service, and Repository pattern
- Managing a PostgreSQL database locally using Docker Compose

---

## Author

Hafez Sam — [github.com/hsmsam](https://github.com/hsmsam)
