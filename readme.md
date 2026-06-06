# Signmod

A user management and notification API built with Java and Spring Boot. It uses **Spring Modulith** to implement a modular monolithic architecture driven by events.

## I. Technologies

* **Java 17+**
* **Spring Boot 3.x**
* **Spring Modulith** (Module isolation and event management)
* **Spring Data JPA** (Data persistence)
* **Mailtrap** (Email delivery simulation)
* **Maven** (Dependency manager)

---

## II. Project Structure & Modules

The project is structured into isolated logical modules that communicate asynchronously via events managed by Spring Modulith:

```text
io.github.matheus_fsantos.signmod
├── 📂 users          # User domain module (Registration, persistence, and encryption)
├── 📂 notification   # Notification domain module (Email delivery via Mailtrap)
└── 📄 SignmodApplication.java
```

### Event Workflow
1. The `UserController` receives the request and triggers the `CreateUserUseCase`.
2. After persisting the user data, the adapter publishes a `UserCreatedEvent`.
3. Spring Modulith ensures complete decoupling: the `notification` module listens to this event using the `NotificationEventListener`.
4. The `SendEmailUseCase` runs next, sending out the email via `MailTrapAdapter`.

---

## III. How to Run

### Prerequisites
* Java 17 or higher installed.
* Maven installed (or use the included `mvnw`).

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com
   cd signmod
   ```

2. Set up your Mailtrap credentials inside the `src/main/resources/application.yaml` file.

3. Install dependencies and build the project:
   ```bash
   ./mvnw clean install
   ```

4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

---

## IV. Modulith Validation Tests

To ensure that isolation rules between `users` and `notification` modules are strictly followed (preventing cyclic dependencies or invalid access to internal packages), you can run the Modulith structural verification tests:

```bash
./mvnw test
```
