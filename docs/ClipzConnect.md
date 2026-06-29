
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

  _Story:_ As a customer, I want to create a fitness profile, so that trainers can understand my goals and constraints.

  _Acceptance:_
  ```gherkin
  Scenario: Register with valid credentials
    Given I am not registered
    When I provide valid registration details
    Then I should be successfully registered and logged in
  ```

- **US‑2 - Browse trainers by goal category**

  _Story:_ As a customer, I want to browse trainers by goal category so that I can quickly find relevant matches.

  _Acceptance:_
  ```gherkin
  Scenario: Browse trainers by goal category
    Given I am logged in as a customer
    When I select a goal category
    Then I should see a list of trainers who specialize in that category
  ```

- **US-3 - Book a training session**

  _Story:_ As a customer, I want to book a training session with a trainer so that I can receive personalized guidance.

  _Acceptance:_
  ```gherkin
  Scenario: Book a training session
    Given I am logged in as a customer
    When I select a trainer and choose an available time slot
    Then I should receive a confirmation of the booked session
  ```

- **US-4 - Write a review after a session**

    _Story:_ As a customer, I want to write a review after a session so that others can benefit from my experience.

    _Acceptance:_
  ```gherkin
    Scenario: Write a review after a session
      Given I have completed a training session with a trainer
      When I submit a review for that session
      Then the review should be saved and visible to other customers
  ```

### 2.2 Provider (Barber) Stories

- **US-5 - View and manage appointments**
  _Story:_ As a provider, I want to be able to view and manage my appointments.

  _Acceptance:_
  ```gherkin
  Scenario: View and manage appointments
    Given I can not view my appointmnets
    When I click on 'Manage Appointments'
    Then my appointments will become visible to me
    And I will be able to view past, current and future appointments. As well as modify them to my needs.
  ```

- **US-6 - Define services and pricing**

  _Story:_ As a trainer, I want to define my services and pricing, so that customers understand my offerings.

  _Acceptance:_
  ```gherkin
  Scenario: Define services and pricing
    Given I am logged in as a trainer
    When I add my services and set pricing
    Then the services should be saved and visible to customers
  ```

- **US-7 - Respond to reviews**

  _Story:_ As a trainer, I want to respond to reviews, so that I can engage with clients.

  _Acceptance:_
  ```gherkin
  Scenario: Respond to reviews
    Given I am logged in as a trainer
    When I receive a review for one of my sessions
    Then I should be able to submit a response to the review
  ```

- **US-8 - View customer statistics**

  _Story:_ As a trainer, I want to view customer statistics so that I can tailor my coaching.

  _Acceptance:_
  ```gherkin
  Scenario: View customer statistics
    Given I am logged in as a trainer
    When I access the dashboard
    Then I should see relevant data about my customers' progress and engagement
  ```

  - **US-9 - View customer statistics**

  _Story:_ As a trainer, I want to view customer statistics so that I can tailor my coaching.

  _Acceptance:_
  ```gherkin
  Scenario: View customer statistics
    Given I am logged in as a trainer
    When I access the dashboard
    Then I should see relevant data about my customers' progress and engagement
  ```

  - **US-10 - View customer statistics**

  _Story:_ As a trainer, I want to view customer statistics so that I can tailor my coaching.

  _Acceptance:_
  ```gherkin
  Scenario: View customer statistics
    Given I am logged in as a trainer
    When I access the dashboard
    Then I should see relevant data about my customers' progress and engagement
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