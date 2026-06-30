
# Requirements – FitMatch

**Project Name:** ClipzConnect \
**Team:** Your name - Provider, Bryan Martinez-Bautista - Customer \
**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-06-29

---

## 1. Overview
**Vision.** ClipzConnect provides an enviroment for clients and barbers to connect. Clients will able to select a barber that best suits their needs through a series of filters, i.e. location, prices, services provided, etc. Clients will also be able to leave reviews and rate their experience. Barbers will to demonstrate the work and services they provide.

**Glossary** Terms used in the project
- **Barber:** A professional who provides Haircuting & hair-related services to customers.
- **Customer:** A person seeking haircut services.
- **Profile:** A collection of information about a user, including personal details, and preferences.
- **Services:** The haircut services provided by a barber.
- **Session:** A scheduled appointment between a customer and a barber for haircut.

**Primary Users / Roles.**
- **Customer** - Find barbers aligned with their interests and needs.
- **Barber** — Attract clients, publish services and manage profile.

**Scope (this semester).**
- User profiles (customers & barbers)
- Search/browse barbers by constraints
- Booking haircut appointments
- Basic progress tracking of haircuts(customers & barbers)
- Reviews and ratings

**Out of scope (deferred).**
- Communication between customers and barbers
- In-app payments
- Extra fees

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)

### 2.1 Customer Stories
- **US‑1 - Register & manage profile**

  _Story:_ As a customer, I want to create a profile, so that I can Book appointments with a barber and manage my account.

  _Acceptance:_
  ```gherkin
  Scenario: Register with valid credentials
    Given I am not registered
    When I provide valid registration details
    Then I should be successfully registered and logged in
  ```

- **US‑2 - Browse barbers with filter**

  _Story:_ As a customer, I want to be able to filter when browesing for barbers.

  _Acceptance:_
  ```gherkin
  Scenario: Browse for barbers with filter
    Given I am logged in as a customer
    When I select a filter option
    Then I should see a list of barbers who provide those services
  ```

- **US-3 - Book an appointment with a barber**

  _Story:_ As a customer, I want to book an appointment with a barber who meets my needs.

  _Acceptance:_
  ```gherkin
  Scenario: Book a haircut appointment
    Given I am logged in as a customer
    When I select a barber and choose an available time slot
    Then I should receive a confirmation of the booked session
  ```

- **US-4 - Write a review after an appointment**

    _Story:_ As a customer, I want to write a review after an appointment so that others can see the
    quality of the service.

    _Acceptance:_
  ```gherkin
    Scenario: Write a review after an appointment
      Given I have finished with my haircut appointment
      When I submit a review for that appointment
      Then the review should be saved and visible to other customers
  ```

- **US-5 - View appointment history**

    _Story:_ As a customer, I want to view my appointment history so that I can verify past billing or scheduling issue.

    _Acceptance:_
  ```gherkin
    Scenario: View appointment history to verify billing
      Given I have finished with my haircut appointment
      When I check my appointment log
      Then I should see the billing details for my recent and previous appointments
  ```

### 2.2 Provider (Barber) Stories

- **US-6 - View and manage appointments**
  _Story:_ As a provider, I want to be able to view and manage my appointments.

  _Acceptance:_
  ```gherkin
  Scenario: View and manage appointments
    Given I can not view my appointmnets
    When I click on 'Manage Appointments'
    Then my appointments will become visible to me
    And I will be able to view past, current and future appointments. I will be able to modify them to my needs.
  ```

- **US-7 - Define services and pricing**

  _Story:_ As a provider, I want to be able to post pictures of my work. 

  _Acceptance:_
  ```gherkin
  Scenario: Post pictures of haircuts and other hair services
    Given I am logged in as a provider
    When I click upload and/or take picture
    Then picture will be available for customers to view on my provider page
  ```

- **US-8 - Respond to reviews**

  _Story:_ As a provider, I want to be able to manage my availability

  _Acceptance:_
  ```gherkin
  Scenario: Edit the times/dates I am available
    Given I am logged in as a provider
    When I click to 'availability'
    Then I should be able to edit the times/dates I am available 
  ```

- **US-9 - View customer statistics**

  _Story:_ As a provider, I want to be able to reply to reviews

  _Acceptance:_
  ```gherkin
  Scenario: Respond to reviews
    Given I am logged in as a provider
    When I receive a review for one of my services
    Then I should be able to submit a response to the review
  ```

  - **US-10 - View customer statistics**

  _Story:_ As a provider, I want to define my services and pricing, so that customers understand my offerings..

  _Acceptance:_
  ```gherkin
  Scenario: Publish services and prices
    Given I am logged in as a provider
    When I access the dashboard
    Then I should be able to update services/prices
  ```
---

## 3. Non‑Functional Requirements
- **Performance:** 95% of discovery responses should be returned in < 2 seconds under typical load.
- **Availability/Reliability:** The system should be available 99.5% of the time, with planned maintenance windows communicated in advance.
- **Security/Privacy:** The system must implement secure authentication and authorization mechanisms. All sensitive data should be encrypted in transit and at rest.
- **Usability:** New users should be able to complete the registration process and book a session within 5 minutes without external assistance.

---

## 4. Assumptions, Constraints, and Policies
- Modern browsers (latest Chrome/Firefox/Edge/Safari); stable connectivity.
- Course timeline & campus infrastructure constraints apply.

---

## 5. Milestones (course‑aligned)
- **M1 Requirements** — this file + stories opened as issues.
- **M2 High‑fidelity prototype** — core customer/provider UI flows fully interactive.
- **M3 Design** — architecture, schema, API outline.
- **M4 Backend API** — key endpoints + tests.
- **M5 Increment** — ≥2 use cases end‑to‑end.
- **M6 Final** — complete system & documentation.

---

## 6. Change Management
- Stories are living artifacts; changes are tracked via repository issues and linked pull requests.
- Major changes should update this SRS.