# Task Management Console App

## 🌍 Languages
- **EN / PT**

---

## 📌 Project Overview

This project is the first in a series of projects where I combine **practice with study**, with the goal of building a **Junior Java Developer portfolio**.

It is a **Task Management console application**, where the user can choose actions from a menu such as:
- adding tasks
- removing tasks
- listing tasks
- changing task characteristics

---

## 🏗️ Architecture

Since this is a **pre–Spring Boot project**, I chose to use a **Layered Architecture** composed of:

- Main  
- UI  
- Service  
- Repository  
- Model  

Implementing this architecture before Spring Boot brought some challenges, especially understanding:
- how layers communicate with each other
- what each layer’s responsibility is

To overcome this, I researched forums, watched videos, and used AI to clarify these concepts.  
The architecture is much clearer now, although I know that continued practice is necessary to solidify this knowledge.

---

## 🔍 Layer-by-Layer Explanation

Below is a brief explanation of each part of the project, from user input to data storage.

### Main
Although the `Main` class is not considered a layer, it plays an important role.  
Understanding that its responsibility is **only to instantiate objects and start the console application** was the key moment that made the communication between layers finally make sense to me.

### UI
The UI layer represents the **“frontend”** of the application.  
Here, the user interacts with the app through a console menu, inputs are received, and basic validation is performed before passing data to the Service layer.

### Service
The Service layer handles:
- business logic
- Java Streams operations

This was the layer I was most interested in, as I wanted to put **Java Streams** into practice — a feature that previously made me uncomfortable, but is now much clearer.

### Repository
Since there is no data persistence yet, the Repository layer is responsible for managing data **in memory**, using a `HashSet`.

### Model
The Model layer contains the domain classes.  
I considered adding more complexity to the enums, but after evaluating the value this would bring, I decided to keep the model **simple and focused**.

---

## 📋 Console Menu Features

The application allows the user to:

- Add a task  
- Remove a task  
- List all tasks  
- List tasks by status (**TODO**, **ONGOING**, **DONE**)  
- Exit the application  

---

## 🚀 Final Notes

This project represents my **first step** in building a structured Java portfolio and in understanding **layered architecture** before moving on to **Spring Boot**.
