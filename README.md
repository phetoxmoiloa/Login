# QuickChat — PROG5121 POE Part 1, 2 & 3

**GitHub:** https://github.com/phetoxmoiloa/Login

## Project Overview

QuickChat is a Java-based console messaging application developed as part of the PROG5121 Portfolio of Evidence at the Independent Institute of Education (IIE). The application allows registered users to log in, send messages to recipients, and manage stored messages via a menu-driven interface.

---

## Features

### Part 1 — User Login
- User registration with username, password, first name, last name, and cell number
- Password validation (must contain a capital letter, a number, and a special character, and be no more than 8 characters)
- Username validation (must contain an underscore and be no more than 5 characters)
- Login authentication with success/failure feedback and retry loop
- Returns a personalised welcome message upon successful login

### Part 2 — Sending Messages
- Login-gated access to the messaging system
- Welcome screen displaying "Welcome to QuickChat."
- Numeric menu with options: Send Messages, Show Recently Sent Messages (Coming Soon), Stored Messages, and Quit
- User-defined message limit per session
- Message composition with:
  - Auto-generated 10-digit Message ID
  - Recipient cell number validation (international code required, max 12 characters)
  - Message length validation (max 250 characters)
  - Auto-generated Message Hash (format: `XX:N:FIRSTWORDLASTWORD`)
  - Options to Send, Disregard, or Store each message
- Display of full message details after sending (Message ID, Hash, Recipient, Message)
- Total message count displayed at end of session

### Part 3 — Store Data and Display Task Report
- Five dynamic ArrayLists tracking all sent, disregarded, and stored messages
- Messages stored in JSON file via `storeMessage()`
- Fourth menu option: **Stored Messages** with the following sub-features:
  - Display sender and recipient of all stored messages
  - Display the longest stored message
  - Search for a message by ID and display recipient and message
  - Search all messages for a particular recipient
  - Delete a message using its message hash
  - Display a full report of all stored messages

---

## Project Structure

```
login/
│
├── Login.java            - Handles user registration and authentication
├── Messages.java         - Handles message creation, validation, sending, and storage
└── runnerClass.java      - Main entry point; runs the application

test/login/
├── MessagesTest.java     - Unit tests for Part 2 functionality
└── MessageTestPart3.java - Unit tests for Part 3 functionality
```

---

## Classes and Methods

### Login.java
| Method | Description |
|---|---|
| `checkUserName()` | Validates username format |
| `checkPasswordComplexity()` | Validates password strength |
| `checkCellPhoneNumber()` | Validates cell number format |
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
| `getLongestMessage()` | Returns the longest message from stored messages |
| `searchMessageID()` | Searches for a message by ID and returns recipient and message |
| `searchRecipientMessages()` | Returns all messages for a given recipient |
| `deleteMessage()` | Deletes a message using its hash |
| `displayReport()` | Returns a full report of all stored messages |
| `storeMessage()` | Saves message details to a JSON file |
| `addTestMessage()` | Adds test data to ArrayLists for unit testing |

---

## Unit Tests

### MessagesTest (Part 2)
- Message length validation (success and failure)
- Recipient number format validation (success and failure)
- Message hash correctness
- Message ID generation
- Send, Disregard, and Store message options

### MessageTestPart3 (Part 3)
- Sent messages array correctly populated
- Longest message correctly identified
- Search by message ID returns correct result
- Search by recipient returns all matching messages
- Delete message using hash returns confirmation
- Display report returns full message details

---

## How to Run

1. Clone the repository: `git clone https://github.com/phetoxmoiloa/Login.git`
2. Open the project in NetBeans (or any Java IDE)
3. Run `runnerClass.java`
4. Follow the on-screen prompts to register, log in, and send messages

---

## Technologies Used

- Java (JDK 17+)
- NetBeans IDE
- JUnit 4 (unit testing)
- GitHub (version control and CI/CD via GitHub Actions)

---

## GitHub Actions (CI/CD)

This project uses GitHub Actions to automatically run unit tests on every push to the repository, ensuring code quality is maintained across all branches.

Reference: [https://youtu.be/oz0Qd5H4Onk](https://youtu.be/oz0Qd5H4Onk)

---

## References

- Deitel, P. & Deitel, H. (2020). *Java How to Program, Early Objects* (11th ed.). Pearson.
- Oracle. (2024). *Java SE Documentation*. Retrieved from https://docs.oracle.com/en/java/
- JUnit Team. (2024). *JUnit 4 Documentation*. Retrieved from https://junit.org/junit4/
- GitHub Docs. (2024). *Understanding GitHub Actions*. Retrieved from https://docs.github.com/en/actions
- The Independent Institute of Education. (2026). *PROG5121 Portfolio of Evidence Brief*. IIE.
