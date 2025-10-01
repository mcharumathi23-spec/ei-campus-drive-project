# ei-campus-drive-project
a simple real-time chat application where users can join different chat rooms or create their own chat rooms. Users should be able to send and receive messages in real-time.
Realtime Chat Application
Overview

This project is a Realtime Chat Application that enables users to send and receive messages instantly. The system leverages design patterns such as Singleton, Observer, and Factory to provide a scalable, modular, and maintainable architecture. The chat application supports multiple users, message broadcasting, and real-time updates.

Design Patterns
Singleton Pattern

The Singleton pattern ensures that only one instance of critical components exists across the application, allowing shared resources and consistent state management.

ChatServer: Maintains the central server instance responsible for managing all connected clients and message broadcasting.

DatabaseConnection: Manages database interactions such as storing user details and chat history.

Observer Pattern

The Observer pattern is used to notify clients about new messages or user events. When one user sends a message, all connected observers (other users) receive real-time updates.

ClientHandler: Acts as an observer for incoming messages from the server.

ChatServer: Acts as the subject, notifying all subscribed clients of new messages.

Factory Pattern

The Factory pattern is used to create different types of messages or clients dynamically, without tightly coupling the code to specific classes.

MessageFactory: Creates different message types such as TextMessage, ImageMessage, or SystemMessage.

ClientFactory: Generates client objects with roles like AdminClient or RegularClient.

Features
User Authentication

Users authenticate with unique usernames before joining the chat. Authentication ensures proper user identification and role management.

Realtime Messaging

Messages sent by one user are instantly broadcast to all other connected users using the Observer pattern.

Multiple Clients

The server handles multiple clients simultaneously, allowing group chat functionality.

Message Types

Supports multiple message formats (text, system notifications, images) through the Factory pattern.

Chat History

Messages are stored in the database for retrieval, providing users with persistent chat history.

Edge Cases

Duplicate Usernames: The server rejects login attempts with duplicate usernames.

Server Crash: Singleton ensures that only one server instance is created and restarted if needed.

Connection Drop: If a user disconnects unexpectedly, the system cleans up the session and notifies other users.

Invalid Message Format: Factory pattern prevents malformed message objects by validating before creation.

Getting Started
Prerequisites

Java JDK 17+

IntelliJ IDEA / Eclipse

Maven or Gradle

Installation

Clone the repository:

git clone https://github.com/mcharumathi23-spec/ei-campus-drive-project.git


Navigate to the project directory:

cd RealtimeChatApplication


Build the project:

mvn clean install

Running the Application

Start the chat server:

java -cp target/realtime-chat-app.jar com.ei.chat.ChatServer


Start client instances:

java -cp target/realtime-chat-app.jar com.ei.chat.ChatClient

Inputs

Login

login <username>


Logs in a user with the specified username.

Send Message

send <message>


Sends a text message to all connected users.

Logout

logout


Logs out the user from the chat.

Outputs

Login: Displays confirmation that the user joined the chat.

Send Message: Broadcasts the message to all connected clients.

Logout: Displays confirmation that the user left the chat.

System Notifications: Informs users when someone joins or leaves.

Error Handling

Invalid Username: Displays an error if username is empty or already in use.

Connection Failure: Displays an error message if the server is unreachable.

Invalid Command: Prompts users with available commands if input is invalid.

Unexpected Disconnect: Server automatically removes the client and notifies others.

Conclusion

This project demonstrates the implementation of a Realtime Chat Application using Java and design patterns. It supports multiple clients, real-time communication, and extensible message types. By leveraging Singleton, Observer, and Factory patterns, the system ensures scalability, modularity, and maintainability.
