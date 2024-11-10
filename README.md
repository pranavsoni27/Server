# 🖧 Server-Client Connection Project

Welcome to the **Server-Client Connection Project**! This repository demonstrates various approaches to handling multiple client requests using Java sockets, covering **Single-threaded**, **Multithreaded**, and **Thread Pool** servers.

---

## 🚀 Project Overview

This project explores three server configurations to handle multiple client connections in Java, each with its own advantages and limitations:

1. **Single-threaded Server** 🧵 - Handles one client at a time.
2. **Multithreaded Server** 🤹 - Creates a new thread for each client, allowing simultaneous handling.
3. **Thread Pool Server** 🛠️ - Utilizes a fixed pool of threads for efficient resource usage.

---

## 📂 Project Structure

- **Single-threaded Server** 🧵 - Processes one client at a time.
- **Multi-threaded Server** 🤹 - Processes multiple client at a time.
- **Thread-Pool Server** 🛠️ - Uses a pool of threads to manage large numbers of client's connections.

---

## 🧵 Single-threaded Server

### How It Works
The single-threaded server processes **one client request at a time**. This straightforward model handles each client sequentially, processing a single connection before accepting the next.

### Limitations
- Handles only one client at a time.
- Limited efficiency under multiple client requests, as each must wait for the previous to complete.

---

## 🤹 Multithreaded Server

### How It Works
In the multithreaded server, each client is assigned a **dedicated thread**, allowing multiple clients to connect and be served at once. This setup improves response times for multiple clients but can consume significant system resources as the number of threads grows.

### Benefits
- Concurrent handling of multiple clients.
- Responsive, as each client connection is processed independently.

### Limitations
- High resource usage if too many clients connect, as each connection requires a new thread.

---

## 🛠️ Thread Pool Server

### How It Works
This server uses a **fixed pool of threads** to handle clients, making it efficient for managing multiple connections without creating an excessive number of threads. When a client connects, it uses an available thread from the pool, ensuring resource optimization.

### Benefits
- Efficient in resource usage by recycling threads.
- Scalable, as it can handle a large number of clients without high memory consumption.

### Limitations
- Limited to the size of the thread pool, though this can be adjusted based on system capacity.

---

## 📊 Performance Testing with Apache JMeter

**Apache JMeter** was used to evaluate the performance of each server configuration by simulating various loads and collecting data on response times and throughput.

### Why JMeter?

JMeter enables:
- **Simulating concurrent client requests**: To observe how each server handles multiple clients.
- **Comparing server efficiency**: By measuring response times, throughput, and resource usage.
- **Collecting metrics**: Provides detailed data to analyze server scalability and identify the optimal configuration.

### Testing Process

Each server type was tested under different loads with JMeter, analyzing the server’s behavior with simultaneous client connections:

1. **Single-threaded Server**: Demonstrated significant delays with multiple client connections, as it processes requests sequentially.
2. **Multi-threaded Server**: Handled multiple clients concurrently but showed increased resource usage when a high number of clients connected.
3. **Thread-Pool Server**: Managed high loads efficiently by using a limited number of threads, balancing responsiveness with resource management.

---

## 🏆 Performance Comparison

| Server Type         | Maximum Clients | Description                                               |
|---------------------|-----------------|-----------------------------------------------------------|
| 🧵 Single-threaded  | 1               | Best for testing; poor for multiple clients               |
| 🤹 Multi-threaded    | Many            | Great for multiple clients; higher memory usage           |
| 🛠️ Thread-Pool      | Limited by pool | Best for real-world apps; efficient and resource-friendly |

### Which is Best?
- **Single-threaded**: Simple setup for testing but unsuitable for handling multiple clients.
- **Multi-threaded**: Good for moderate loads but requires significant resources as the client number grows.
- **Thread-Pool**: Ideal for high-demand environments, offering a balance between performance and efficient resource management.

---

## 📘 Glossary

- **Socket**: A connection endpoint for communication between two machines.
- **Port**: A specific channel where the server listens for connections.
- **Thread**: A small, independent part of a program running concurrently.
- **Thread Pool**: A collection of pre-created threads available for handling multiple tasks.

---

## 🎉 Conclusion

Each server type has specific strengths and is suited to different workloads. By using JMeter for testing, this project provides insights into the performance and scalability of each configuration. 
