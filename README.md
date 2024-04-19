# Client and Server Programs Using TCP - Project Overview

## Introduction
This project, designed for the CPCS-371 course at King Abdul Aziz University, involves creating a pair of client and server programs that communicate over TCP. The client sends a character and a string to the server, which then calculates and returns the number of occurrences of the character within the string.

## Key Features

- **TCP Communication**: Implements a reliable communication channel between the client and server using TCP.
- **Input Validation**: Ensures robust handling of user inputs and provides appropriate warning messages for bad inputs.
- **Repetition Control**: Allows the user to repeat the operation or terminate the session based on their input after each interaction.
- **Dynamic Interaction**: The server continues to service the client until a termination request is received, making the interaction dynamic and persistent.

## Technical Requirements

- **Java Implementation**: Both client and server are implemented in Java, making use of sockets for TCP communication.
- **Error Handling**: Includes comprehensive error checking to prevent crashes and ensure smooth operation under all input conditions.
- **Code Quality**: Focuses on readability, good coding practices such as appropriate use of comments, indentation, and naming conventions.

## Objective

To demonstrate the creation and handling of network communications using TCP in Java. This project provides practical experience with network programming, focusing on client-server interactions, data transmission, and handling TCP connections.

## How to Use

1. **Setup and Compilation**: Compile the Java source files `GroupName_client.java` and `GroupName_server.java`.
2. **Running the Server**: Start the server program first so it can listen for incoming client connections.
3. **Running the Client**: Launch the client program and follow the prompts to input a character and a string.
4. **Interaction**: The server calculates the occurrences of the specified character in the string and sends the result back to the client.
5. **Repetition Decision**: After receiving the output, the client can decide to repeat the process or terminate the connection.

This README provides a detailed guide to setting up, running, and interacting with the client-server programs developed for this project. It is designed for students and educators interested in learning about network programming and TCP communications.

Explore the code to gain insights into handling network connections, performing data exchanges, and implementing robust client-server interactions in Java.

