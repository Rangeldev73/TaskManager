# ✅ Task Manager API

<p align="center">
  <a href="#-english-version">English Version</a> •
  <a href="#-versão-em-português">Versão em Português</a>
</p>

---

## 🇺🇸 English Version

### 📌 Project Overview

A production-ready REST API for task management, built natively with Java and Spring Boot.
Designed with a strict focus on layered architecture, SOLID principles, and professional
engineering practices, this project demonstrates a complete backend development cycle —
from domain modeling to database persistence, HTTP communication, and automated testing.

---

### 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 21+ | Core language |
| Spring Boot 3.2 | REST framework |
| Spring Data JPA | Database abstraction |
| PostgreSQL | Relational database |
| Hibernate | ORM / schema generation |
| JUnit 5 | Unit testing framework |
| Mockito | Mocking and test isolation |
| Maven | Dependency management |

---

### 🏗️ Architecture & System Design

#### 1. Layered Architecture

The system is organized into four strictly separated layers:

- **Model (`Task`, `TaskStatus`):** Domain entities mapped to database tables via JPA annotations.
- **Repository (`TaskRepository`):** Extends `JpaRepository` — all CRUD operations are provided
  automatically by Spring Data, with zero boilerplate implementation.
- **Service (`TaskService`):** Contains all business rules. The only layer that accesses the
  repository. Validates existence before mutations and returns `null` for not-found cases.
- **Controller (`TaskController`):** Receives HTTP requests, delegates to the service, and returns
  appropriate `ResponseEntity` with correct HTTP status codes.

#### 2. Dependency Injection

All components use constructor injection — the industry standard — rather than field injection.
This makes dependencies explicit and enables clean unit testing without Spring context.

```java
public TaskService(TaskRepository repository) {
    this.repository = repository;
}
```

#### 3. HTTP Semantics

The API returns semantically correct status codes on every response:

| Operation | Status Code |
|---|---|
| Task created | `201 Created` |
| Task found | `200 OK` |
| Task not found | `404 Not Found` |
| Task deleted | `204 No Content` |

#### 4. Security — Environment Variables

Database credentials are never hardcoded. The `application.properties` uses environment
variable placeholders, keeping secrets out of version control:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

#### 5. Automated Testing

Business logic is tested with JUnit 5 and Mockito. The repository layer is mocked,
enabling fast, isolated tests with zero database dependency:

```java
@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock TaskRepository repository;
    @InjectMocks TaskService service;
}
```

---

### 🗂️ API Endpoints

| Method | Endpoint | Description | Status |
|---|---|---|---|
| `POST` | `/tasks` | Create a new task | `201` |
| `GET` | `/tasks` | List all tasks | `200` |
| `GET` | `/tasks/{id}` | Get task by ID | `200` / `404` |
| `PUT` | `/tasks/{id}` | Update a task | `200` / `404` |
| `DELETE` | `/tasks/{id}` | Delete a task | `204` / `404` |

---

### 📁 Project Structure

```
src/
├── main/
│   ├── java/com/rangel/
│   │   ├── App.java
│   │   ├── controller/
│   │   │   └── TaskController.java
│   │   ├── model/
│   │   │   ├── Task.java
│   │   │   └── TaskStatus.java
│   │   ├── repository/
│   │   │   └── TaskRepository.java
│   │   └── service/
│   │       └── TaskService.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/rangel/
        └── TaskServiceTest.java
```

---

### 🚀 Running Locally

**Prerequisites:** Java 21+, PostgreSQL, Maven

**1. Clone the repository:**
```bash
git clone https://github.com/Rangeldev73/TaskManager.git
cd TaskManager
```

**2. Create the database:**
```sql
CREATE DATABASE taskmanager;
```

**3. Set environment variables:**
```bash
DB_URL=jdbc:postgresql://localhost:5432/taskmanager
DB_USERNAME=your_username
DB_PASSWORD=your_password
```

**4. Run:**
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

---

## 🇧🇷 Versão em Português

### 📌 Visão Geral do Projeto

Uma API REST para gerenciamento de tarefas, construída de forma nativa com Java e Spring Boot.
Projetada com foco rigoroso em arquitetura em camadas, princípios SOLID e boas práticas de
engenharia profissional, este projeto demonstra um ciclo completo de desenvolvimento backend —
desde a modelagem do domínio até a persistência em banco de dados, comunicação HTTP e testes
automatizados.

---

### 🛠️ Tecnologias

| Tecnologia | Finalidade |
|---|---|
| Java 21+ | Linguagem principal |
| Spring Boot 3.2 | Framework REST |
| Spring Data JPA | Abstração de banco de dados |
| PostgreSQL | Banco de dados relacional |
| Hibernate | ORM / geração de esquema |
| JUnit 5 | Framework de testes unitários |
| Mockito | Mocks e isolamento de testes |
| Maven | Gerenciamento de dependências |

---

### 🏗️ Arquitetura e Design do Sistema

#### 1. Arquitetura em Camadas

O sistema é organizado em quatro camadas estritamente separadas:

- **Model (`Task`, `TaskStatus`):** Entidades de domínio mapeadas para tabelas do banco via anotações JPA.
- **Repository (`TaskRepository`):** Estende `JpaRepository` — todas as operações CRUD são fornecidas
  automaticamente pelo Spring Data, sem nenhuma implementação manual.
- **Service (`TaskService`):** Contém todas as regras de negócio. É a única camada que acessa o
  repositório. Valida a existência antes de mutações e retorna `null` para casos não encontrados.
- **Controller (`TaskController`):** Recebe requisições HTTP, delega ao service e retorna
  `ResponseEntity` com os códigos de status HTTP corretos.

#### 2. Injeção de Dependência

Todos os componentes utilizam injeção por construtor — o padrão de mercado — em vez de injeção
por campo. Isso torna as dependências explícitas e viabiliza testes unitários limpos sem contexto
do Spring.

```java
public TaskService(TaskRepository repository) {
    this.repository = repository;
}
```

#### 3. Semântica HTTP

A API retorna códigos de status semanticamente corretos em todas as respostas:

| Operação | Código de Status |
|---|---|
| Task criada | `201 Created` |
| Task encontrada | `200 OK` |
| Task não encontrada | `404 Not Found` |
| Task deletada | `204 No Content` |

#### 4. Segurança — Variáveis de Ambiente

As credenciais do banco nunca são inseridas diretamente no código. O `application.properties`
utiliza variáveis de ambiente, mantendo os dados sensíveis fora do controle de versão:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

#### 5. Testes Automatizados

A lógica de negócio é testada com JUnit 5 e Mockito. A camada de repositório é simulada,
permitindo testes rápidos e isolados sem dependência de banco de dados:

```java
@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock TaskRepository repository;
    @InjectMocks TaskService service;
}
```

---

### 🗂️ Endpoints da API

| Método | Endpoint | Descrição | Status |
|---|---|---|---|
| `POST` | `/tasks` | Criar uma nova task | `201` |
| `GET` | `/tasks` | Listar todas as tasks | `200` |
| `GET` | `/tasks/{id}` | Buscar task por ID | `200` / `404` |
| `PUT` | `/tasks/{id}` | Atualizar uma task | `200` / `404` |
| `DELETE` | `/tasks/{id}` | Deletar uma task | `204` / `404` |

---

### 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/rangel/
│   │   ├── App.java
│   │   ├── controller/
│   │   │   └── TaskController.java
│   │   ├── model/
│   │   │   ├── Task.java
│   │   │   └── TaskStatus.java
│   │   ├── repository/
│   │   │   └── TaskRepository.java
│   │   └── service/
│   │       └── TaskService.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/rangel/
        └── TaskServiceTest.java
```

---

### 🚀 Executando Localmente

**Pré-requisitos:** Java 21+, PostgreSQL, Maven

**1. Clone o repositório:**
```bash
git clone https://github.com/Rangeldev73/TaskManager.git
cd TaskManager
```

**2. Crie o banco de dados:**
```sql
CREATE DATABASE taskmanager;
```

**3. Configure as variáveis de ambiente:**
```bash
DB_URL=jdbc:postgresql://localhost:5432/taskmanager
DB_USERNAME=seu_usuario
DB_PASSWORD=sua_senha
```

**4. Execute:**
```bash
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

---

<p align="center">
  Desenvolvido como projeto prático de portfólio acadêmico em Ciência da Computação — UFT.
</p>