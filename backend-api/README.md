# ClipzConnect Backend API

**Version:** 1.0
**Last Updated:** July 10, 2026

**Base URL:**

- local: http://localhost:8080
- production: //

## Table of Contents

1. [Overview](#1-overview)
2. [UML Class Diagram](#2-uml-class-diagram)
3. [API Endpoints](#3-api-endpoints)
   - [Customer Endpoints](#31-customer-endpoints)
   - [Barber Endpoints](#32-barber-endpoints)
   - [Barber Service Endpoints](#33-barber-service-endpoints)
   - [Timeslot Endpoints](#34-timeslot-endpoints)
   - [Hair Appointment Endpoints](#35-hair-appointment-endpoints)
   - [Review Endpoints](#36-review-endpoints)
4. [Use Case Mapping](#4-use-case-mapping)

---

## 1. Overview

The ClipzConnect backend exposes a RESTful API for the hair appointment booking platform described in the SRS. It supports customer registration and profile management, barber discovery, service catalog management, timeslot availability, basic barber lookup, and review management.

---

## 2. UML Class Diagram

![UML Class Diagram](Waiting team member UlisesMartinezz upload)

---

## 3. API Endpoints

### 3.1 Customer Endpoints

#### Create a customer

```http
POST /api/customers
```

Request body:

```json
{
  "name": "John Doe",
  "email": "johndoe@demo.com",
  "phoneNumber": "(555) 555-5555",
  "password": "password123",
  "accountStatus": "active",
  "location": "123Drive",
}
```

Example response:

```json
{
  "id": 1,
  "name": "John Doe",
  "email": "johndoe@demo.com",
  "phoneNumber": "(555) 555-5555",
  "password": "password123",
  "accountStatus": "active",
  "location": "123Drive",
  "reviews": [],
  "hairAppointments": []
}
```

#### Get all customers

```http
GET /api/customers
```

**Response:**

```json
[
    {
        "id": 1,
        "name": "John Doe",
        "email": "johndoe@demo.com",
        "phoneNumber": "(555) 555-5555",
        "password": "password123",
        "accountStatus": "active",
        "location": "123Drive",
        "reviews": [],
        "hairAppointments": []
    }
]
```

#### Get a customer by id

```http
GET /api/customers/{id}
```

**Response:**

```json
{
    "id": 1,
    "name": "John Doe",
    "email": "johndoe@demo.com",
    "phoneNumber": "(555) 555-5555",
    "password": "password123",
    "accountStatus": "active",
    "location": "123Drive",
    "reviews": [],
    "hairAppointments": []
}
```

#### Get a customer by email

```http
GET /api/customers/email/{email}
```

**Response:**

```json
{
    "id": 1,
    "name": "John Doe",
    "email": "johndoe@demo.com",
    "phoneNumber": "(555) 555-5555",
    "password": "password123",
    "accountStatus": "active",
    "location": "123Drive",
    "reviews": [],
    "hairAppointments": []
}
```


#### Update customer personal information

```http
PUT /api/customers/{id}/personal-info
```

Example request body:

```json
{
  "name": "Jane Doe",
  "email": "janedoe@demo.com",
  "phoneNumber": "(555) 555-5556",
  "location": "456 Main Street"
}
```

**Response:**

```json
{
  "id": 1,
  "name": "Jane Doe",
  "email": "janedoe@demo.com",
  "phoneNumber": "(555) 555-5556",
  "password": "password123",
  "accountStatus": "active",
  "location": "456 Main Street",
  "reviews": [],
  "hairAppointments": []
}
```


#### Delete a customer

```http
DELETE /api/customers/{id}
```
**Response:** <Empty>

### Update customer account

```http
DELETE /api/customers/{id}
```

Example request body:

```json
{
  "email": "newemail@demo.com",
  "password": "newPassword123",
  "accountStatus": "active"
}
```
**Response:**

```json
{
  "id": 1,
  "name": "John Doe",
  "email": "newemail@demo.com",
  "phoneNumber": "(555) 555-5555",
  "password": "newPassword123",
  "accountStatus": "active",
  "location": "123Drive",
  "reviews": [],
  "hairAppointments": []
}
```

---

### 3.2 Barber Endpoints

Waiting team member UlisesMartinezz response

---

### 3.3 Barber Service Endpoints

Waiting team member UlisesMartinezz response

---

### 3.4 Timeslot Endpoints

#### Create a timeslot

```http
POST /api/timeslots
```

Request body:

```json
{
  "barber": {
    "id": 1
  },
  "startTime": "2026-07-10 09:00",
  "endTime": "2026-07-10 10:00",
  "isAvailable": true
}
```

**Response:**

```json
{
  "id": 1,
  "barber": {
    "id": 1
  },
  "startTime": "2026-07-15 09:00",
  "endTime": "2026-07-15 09:30",
  "isAvailable": true
}
```

#### Get all timeslots for a barber

```http
GET /api/timeslots/barber/{barberId}
```

Example response:

```json
[
  {
    "id": 1,
    "barber": {
      "id": 1
    },
    "startTime": "2026-07-15 09:00",
    "endTime": "2026-07-15 09:30",
    "isAvailable": true
  },
  {
    "id": 2,
    "barber": {
      "id": 1
    },
    "startTime": "2026-07-15 09:30",
    "endTime": "2026-07-15 10:00",
    "isAvailable": false
  }
]
```

#### Get available timeslots for a barber

```http
GET /api/timeslots/barber/{barberId}/available
```

Example response:

```json
[
  {
    "id": 1,
    "barber": {
      "id": 1
    },
    "startTime": "2026-07-15 09:00",
    "endTime": "2026-07-15 09:30",
    "isAvailable": true
  }
]
```

#### Get a timeslot by id

```http
GET /api/timeslots/{id}
```

Example response:

```json
[
  {
    "id": 10,
    "trainer": {
      "id": 1
    },
    "startTime": "2026-07-10 09:00",
    "endTime": "2026-07-10 10:00",
    "isAvailable": true
  }
]
```

### Update a timeslot

```http
PUT /api/timeslots/{id}
```

Request body:

```json
{
  "barber": {
    "id": 1
  },
  "startTime": "2026-07-15 10:00",
  "endTime": "2026-07-15 10:30",
  "isAvailable": true
}
```

**Response:**

```json
{
  "id": 1,
  "barber": {
    "id": 1
  },
  "startTime": "2026-07-15 10:00",
  "endTime": "2026-07-15 10:30",
  "isAvailable": true
}
```

### Delete a timeslot
```http
DELETE /api/timeslots/{id}
```
**Response:** <Empty>

---

### 3.5 Hair Appointment Endpoints

#### Book a hair appointment

```http
POST /api/hair-appointments
```

Request body:

```json
{
  "customer": {
    "id": 1
  },
  "barberService": {
    "id": 2
  },
  "timeslot": {
    "id": 5
  },
  "notes": "Please trim the beard as well.",
  "status": "Scheduled",
  "location": "123 Barber Street"
}
```

**Response:**

```json
{
  "id": 1,
  "customer": {
    "id": 1
  },
  "barberService": {
    "id": 2
  },
  "timeslot": {
    "id": 5
  },
  "notes": "Please trim the beard as well.",
  "status": "Scheduled",
  "location": "123 Barber Street"
}
```

#### Get a hair appointment by id

```http
GET /api/hair-appointments/{id}
```

Example response:

```json
[
  {
    "id": 1,
    "customer": {
        "id": 1
    },
    "barberService": {
        "id": 2
    },
    "timeslot": {
        "id": 5
    },
    "notes": "Please trim the beard as well.",
    "status": "Scheduled",
    "location": "123 Barber Street"
  }
]
```

### Get all hair appointments for a customer

```http
GET /api/hair-appointments/customer/{customerId}
```

Example response:

```json
[
  {
    "id": 1,
    "customer": {
      "id": 1
    },
    "barberService": {
      "id": 2
    },
    "timeslot": {
      "id": 5
    },
    "notes": "Please trim the beard as well.",
    "status": "Scheduled",
    "location": "123 Barber Street"
  },
  {
    "id": 2,
    "customer": {
      "id": 1
    },
    "barberService": {
      "id": 3
    },
    "timeslot": {
      "id": 8
    },
    "notes": "Fade haircut.",
    "status": "Completed",
    "location": "123 Barber Street"
  }
]
```

### Update a hair appointment

```http
PUT /api/hair-appointments/{id}
```

Request body:

```json
{
  "customer": {
    "id": 1
  },
  "barberService": {
    "id": 3
  },
  "timeslot": {
    "id": 6
  },
  "notes": "Please include a beard trim.",
  "status": "Scheduled",
  "location": "123 Barber Street"
}
```

**Response:**

```json
{
  "id": 1,
  "customer": {
    "id": 1
  },
  "barberService": {
    "id": 3
  },
  "timeslot": {
    "id": 6
  },
  "notes": "Please include a beard trim.",
  "status": "Scheduled",
  "location": "123 Barber Street"
}
```

### Cancel a hair appointment

```http
PUT /api/hair-appointments/{id}/cancel
```

Example response:

```json
{
  "id": 1,
  "customer": {
    "id": 1
  },
  "barberService": {
    "id": 2
  },
  "timeslot": {
    "id": 5
  },
  "notes": "Please trim the beard as well.",
  "status": "Cancelled",
  "location": "123 Barber Street"
}
```

### Delete a hair appointment

```http
DELETE /api/hair-appointments/{id}
```

**Response:** <Empty>

---

### 3.6 Review Endpoints

#### Create a review

```http
POST /api/reviews
```

Request body:

```json
{
  "customer": {
    "id": 1
  },
  "barber": {
    "id": 2
  },
  "rating": 9,
  "comments": "Excellent haircut and friendly service!",
  "replyText": ""
}
```

**Response:**

```json
{
  "id": 1,
  "customer": {
    "id": 1
  },
  "barber": {
    "id": 2
  },
  "rating": 9,
  "comments": "Excellent haircut and friendly service!",
  "replyText": ""
}
```

### Get a review by id

```http
GET /api/reviews/{id}
```

**Response:**

```json
{
  "id": 1,
  "customer": {
    "id": 1
  },
  "barber": {
    "id": 2
  },
  "rating": 9,
  "comments": "Excellent haircut and friendly service!",
  "replyText": ""
}
```

### Get all reviews by customer

```http
GET /api/reviews/customer/{customerId}
```

**Response:**

```json
[
  {
    "id": 1,
    "customer": {
      "id": 1
    },
    "barber": {
      "id": 2
    },
    "rating": 9,
    "comments": "Excellent haircut and friendly service!",
    "replyText": ""
  },
  {
    "id": 2,
    "customer": {
      "id": 1
    },
    "barber": {
      "id": 3
    },
    "rating": 8,
    "comments": "Great fade haircut.",
    "replyText": "Thank you for your feedback!"
  }
]
```

### Get all reviews for a barber

```http
GET /api/reviews/barber/{barberId}
```

**Response:**

```json
[
  {
    "id": 1,
    "customer": {
      "id": 1
    },
    "barber": {
      "id": 2
    },
    "rating": 9,
    "comments": "Excellent haircut and friendly service!",
    "replyText": ""
  },
  {
    "id": 3,
    "customer": {
      "id": 4
    },
    "barber": {
      "id": 2
    },
    "rating": 10,
    "comments": "Best barber I've ever had!",
    "replyText": "Thank you! Hope to see you again soon."
  }
]
```

### Update a review

```http
PUT /api/reviews/{id}
```

Request body:

```json
{
  "rating": 10,
  "comments": "Outstanding haircut and excellent customer service!",
  "replyText": "Thank you for your kind review!"
}
```

**Response:**

```json
{
  "id": 1,
  "customer": {
    "id": 1
  },
  "barber": {
    "id": 2
  },
  "rating": 10,
  "comments": "Outstanding haircut and excellent customer service!",
  "replyText": "Thank you for your kind review!"
}
```

### Delete a review

```http
DELETE /api/reviews/{id}
```

**Response:** <Empty>

---

## 4. Use Case Mapping

The API endpoints support the following SRS user stories and acceptance flows described in the requirements document.

### Customer use cases

| SRS use case                          | Related Endpoints                                                                                         |
| ------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| US-1 Register and manage profile      | `POST /api/customers`, `GET /api/customers/{id}`, `GET /api/customers/email/{email}`, `PUT /api/customers/{id}`, `PUT /api/customers/{id}/personal-info`, `DELETE /api/customers/{id}` |
| US-2 Browse barbers with filter | `GET /api/timeslots/barber/{barberId}`, `GET /api/timeslots/barber/{barberId}/available`                                          |
| US-3 Book an appointment with a barber         | `GET /api/timeslots/barber/{barberId}/available`, `POST /api/hair-appointments`, `GET /api/hair-appointments/{id}`                                                                             |
| US-4 Write a review after an appointment   | `POST /api/reviews`, `GET /api/reviews/{id}`, `PUT /api/reviews/{id}`, `DELETE /api/reviews/{id}`                                                                                       |
| US-5 View appointment history  | `GET /api/hair-appointments/customer/{customerId}`, `GET /api/hair-appointments/{id}`   |

### Provider use cases - (Waiting team member UlisesMartinezz response)

| SRS use case                           | Related Endpoints                                                                                      |
| -------------------------------------- | ------------------------------------------------------------------------------------------------------ |
| Waiting team member UlisesMartinezz response  | Waiting team member UlisesMartinezz response   |
| Waiting team member UlisesMartinezz response        | Waiting team member UlisesMartinezz response  |
| Waiting team member UlisesMartinezz response                 | Waiting team member UlisesMartinezz response                                                                                 |
| Waiting team member UlisesMartinezz response           | Waiting team member UlisesMartinezz response                                                                    |

