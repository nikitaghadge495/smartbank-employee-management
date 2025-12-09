📌 SmartBank – Employee & Account Management System

Tech Stack: Java, Spring Boot, Angular, MySQL, REST API

SmartBank is a full-stack application designed to manage employees and handle core banking operations.
It includes features like:

🔹 Secure account creation

🔹 Deposit & withdrawal functionality

🔹 Real-time balance checking

🔹 Employee management & role-based access

🔹 MySQL-backed persistent transaction storage

🔹 REST API integration with Angular frontend

This project demonstrates full-stack development, database design, API integration, and handling real-time financial operations securely.

✅ 3. Project Architecture (Flow Diagram Explanation)

Here is a simple, clean architectural flow you can mention:

        ┌──────────────────────────────┐
        │         Angular UI           │
        │ (Account Forms, Employee UI) │
        └──────────────┬───────────────┘
                       │ REST API Calls
                       ▼
        ┌──────────────────────────────┐
        │       Spring Boot API        │
        │  (Controllers → Services →   │
        │       Repositories)          │
        └──────────────┬───────────────┘
                       │ JPA/Hibernate
                       ▼
        ┌──────────────────────────────┐
        │            MySQL             │
        │ (Account Table, Employee     │
        │     Transactions Table)      │
        └──────────────────────────────┘

Architecture Explanation (Add in Resume or Viva):

Angular UI handles user interactions like account creation and transactions.

User requests are sent via REST APIs to Spring Boot.

Spring Boot handles business logic (deposit, withdrawal, account validation).

Hibernate/JPA interacts with MySQL to store employee and account data.

Response is sent back to Angular UI with updated balance or operation status.
