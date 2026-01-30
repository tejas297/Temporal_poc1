
How to run the project
=======================

It is plain java project. You can run it using the `javac` and `java` commands.

Make sure you have Java Development Kit (JDK) installed on your machine. You can download it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

How to Run:

1. Run docker compose for Temporal server and UI (7233 for server, 8088 for UI)
2. Run the Worker class to start the worker.
3. Run the Client class to start the client.
4. You can monitor the workflow execution in the Temporal UI at `http://localhost:8088`.
