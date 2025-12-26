# Task Management Console App

## 🌍 Languages
- **EN / PT**

---
### (en)
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

---






### (pt-br)
## 📌 Visão geral do projeto

Este projeto é o primeiro de uma série de projetos em que **combino prática com estudo**, com o objetivo de construir um portfólio como **Desenvolvedor Java Júnior**.

Trata-se de uma **aplicação de gerenciamento de tarefas em console**, onde o usuário pode escolher ações a partir de um menu, como:

- adicionar tarefas 
- remover tarefas 
- listar tarefas 
- alterar suas características.

---

## 🏗️ Arquitetura

Como este é um **projeto pré–Spring Boot**, optei por utilizar uma **Arquitetura em Camadas** com:
- Main
- UI
- Service
- Repository
- Model 

Implementar essa arquitetura antes do Spring Boot trouxe alguns desafios:
- Entender como as camadas se comunicam 
- Qual é a responsabilidade de cada uma das camadas

Pesquisei em fóruns, vídeos e utilizei IA para esclarecer esses conceitos. 
 Hoje tudo está muito mais claro, mas sei que ainda preciso de prática para consolidar esse conhecimento.

---

## 🔍 Explicando cada camada

Agora vou comentar um pouco camada por camada, desde a entrada do usuário até o salvamento dos dados:

### Main
Mesmo a classe `Main` não sendo uma camada em si, achei importante comentá-la. 
Entender que seu papel é **“apenas” instanciar objetos e iniciar a aplicação em console** foi o que fez a comunicação entre as camadas finalmente fazer sentido para mim.

### UI
A camada de UI representa o **“frontend”** da aplicação. É nela que o usuário interage com o sistema através do menu em console, onde as entradas são recebidas e validações básicas são feitas antes de os dados serem enviados para a camada de serviço.

### Service
A camada de Service é responsável pela lógica de negócio e pelas operações com streams. Foi a parte que mais me interessou, pois queria colocar em prática o uso de **Java Streams** — um recurso que antes me deixava um pouco “em alerta”.

### Repository
Como ainda não estou utilizando persistência de dados, a camada Repository é responsável por gerenciar os dados **em memória** utilizando um HashSet.

### Model
A camada Model contém as classes que representam o domínio da aplicação. Considerei adicionar mais complexidade aos enums, mas após avaliar o valor que isso agregaria, decidi manter o modelo **simples e focado**.

---

## 📋 Funções do menu do console

Funcionalidades disponíveis no menu em console:

- Adicionar uma tarefa  
- Remover uma tarefa  
- Listar todas as tarefas  
- Listar tarefas por status (**TODO**, **ONGOING**, **DONE**)  
- Encerrar a aplicação  

---

## 🚀 Notas finais

Este projeto representa meu **primeiro passo** na construção de um portfólio Java estruturado e no entendimento de **arquitetura em camadas** antes de avançar para o **Spring Boot**.

