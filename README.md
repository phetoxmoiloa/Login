# QuickChat — PROG5121 POE Part 1 & 2

## Project Overview

QuickChat is a Java-based console messaging application developed as part of the PROG5121 Portfolio of Evidence at the Independent Institute of Education (IIE). The application allows registered users to log in and send messages to recipients via a menu-driven interface.

---

## Features

### Part 1 — User Login
- User registration with username, password, first name, last name, and cell number
- Password validation (must contain a capital letter, a number, and a special character, and be no more than 8 characters)
- Username validation (must contain an underscore and be no more than 5 characters)
- Login authentication with success/failure feedback
- Returns a personalised welcome message upon successful login

### Part 2 — Sending Messages
- Login-gated access to the messaging system
- Welcome screen displaying "Welcome to QuickChat."
- Numeric menu with options: Send Messages, Show Recently Sent Messages (Coming Soon), and Quit
- User-defined message limit per session
- Message composition with:
  - Auto-generated 10-digit Message ID
  - Recipient cell number validation (international code required, max 12 characters)
  - Message length validation (max 250 characters)
  - Auto-generated Message Hash (format: `XX:N:FIRSTWORDLASTWORD`)
  - Options to Send, Disregard, or Store each message
- Display of full message details after sending (Message ID, Hash, Recipient, Message)
- Total message count displayed at end of session

---

## Project Structure

```
login/
│
├── Login.java          - Handles user registration and authentication
├── Messages.java       - Handles message creation, validation, and sending
└── runnerClass.java    - Main entry point; runs the application
```

---

## Classes and Methods

### Login.java
| Method | Description |
|---|---|
| `checkUserName()` | Validates username format |
| `checkPasswordComplexity()` | Validates password strength |
| `registerUser()` | Returns registration status |
| `returnLoginStatus()` | Authenticates user and returns status message |

### Messages.java
| Method | Description |
|---|---|
| `checkMessageID()` | Validates message ID is not more than 10 characters |
| `checkRecipientCell()` | Validates recipient number format and international code |
| `createMessageHash()` | Generates the message hash |
| `checkMessages()` | Validates message does not exceed 250 characters |
| `sentMessages()` | Allows user to send, disregard, or store a message |
| `printMessages()` | Returns all messages sent during the session |
| `returnTotalMessages()` | Returns the total number of messages sent |
| `generateMessageID()` | Auto-generates a random 10-digit message ID |

---

## Unit Tests

Unit tests are written using JUnit and cover the following:

- Message length validation (success and failure)
- Recipient number format validation (success and failure)
- Message hash correctness
- Message ID generation
- Send, Disregard, and Store message options

---

## How to Run

1. Clone the repository from GitHub
2. Open the project in NetBeans (or any Java IDE)
3. Run `runnerClass.java`
4. Follow the on-screen prompts to register, log in, and send messages

---

## Technologies Used

- Java (JDK 17+)
- NetBeans IDE
- JUnit 5 (unit testing)
- GitHub (version control and CI/CD via GitHub Actions)

---

## GitHub Actions (CI/CD)

This project uses GitHub Actions to automatically run unit tests on every push to the repository, ensuring code quality is maintained across all branches.

Reference: [https://youtu.be/oz0Qd5H4Onk](https://youtu.be/oz0Qd5H4Onk)

---

## References

- Deitel, P. & Deitel, H. (2020). *Java How to Program, Early Objects* (11th ed.). Pearson.
- Oracle. (2024). *Java SE Documentation*. Retrieved from https://docs.oracle.com/en/java/
- JUnit Team. (2024). *JUnit 5 User Guide*. Retrieved from https://junit.org/junit5/docs/current/user-guide/
- GitHub Docs. (2024). *Understanding GitHub Actions*. Retrieved from https://docs.github.com/en/actions
- The Independent Institute of Education. (2026). *PROG5121 Portfolio of Evidence Brief*. IIE.
