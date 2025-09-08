# OIBSIP_JAVADeveloper

This project contains several Java applications demonstrating various functionalities including an ATM interface, digital library management, a number guessing game, an online examination system, and a train reservation system. Below is an overview of each Java file:

## ATMInterface.java
This file implements a simple ATM interface with basic functionalities such as user authentication, deposits, withdrawals, transfers, and transaction history. The `Account` class stores user credentials, balance, and transaction history. The main loop of the `ATMInterface` allows users to select the desired operation and interact via console input.

## DigitalLibrary.java
This file manages a digital library system with two user roles: Admin and Member. It supports adding, deleting, viewing books and members, issuing and returning books both by admin and users. The classes include:
- `Book` to represent book details and issued status.
- `Member` to manage member details and list of issued books.
- `DigitalLibrary` which handles the operations with menus for admin and member functionalities.

## GuessTheNumberGame.java
This file implements a GUI-based number guessing game using `JOptionPane`. Players have multiple rounds and limited attempts each round to guess a randomly generated number between 1 and 100. Scoring is based on how quickly the correct guess is made within the allowed attempts.

## OnlineExamination.java
This Java program simulates a simple online multiple-choice exam system with user login, profile update, and timed exam functionality. It includes predefined exam questions, tracks user scores, and auto-submits when time expires. The main menu allows profile updates, taking the exam, or logging out.

## SystemMain.java
This file provides a basic train reservation system with user authentication and allows reservation and cancellation of train tickets. It includes:
- `User` class to handle username and password.
- `Reservation` class to store reservation details including unique reservation IDs.
- Main system logic for login, reservation creation, and cancellation with console interaction.

---

Each file demonstrates core Java programming concepts such as classes, objects, collections, user input handling, and basic logical constructs.

For any questions or contributions, please contact the project maintainer.
