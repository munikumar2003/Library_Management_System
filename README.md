# Library Management System

This is a Spring Boot-based project that provides RESTful APIs to manage a library's books. It includes functionalities to add, update, retrieve, and delete books from the library. The `publicationYear` field is stored using the `Year` type from `java.time`.
<br>
```diff
+ The Test Rport file is uploaded so that anyone can check the output
```

## Features
- Add a new book.
- Get details of all available books.
- Borrow the book.
- Return the book.
- Update the details of the book.
- Delete a book by ID.

---

## Prerequisites

Before you begin, ensure you have the following installed on your machine:
- Java Development Kit (JDK 17 or later)
- Apache Maven (for managing dependencies)
- MYSQL Database
- An IDE such as IntelliJ IDEA, Eclipse, or VS Code

---

## Project Setup

Follow these steps to set up and run the project:

### 1. Clone the Repository
```bash
git clone https://github.com/munikumar2003/library-management-system.git
cd library-management-system
```

### 2. Configure the Database
* Install and start MYSQL.
* Create a database named library_db.
```sql
CREATE DATABASE library_db;
```
* Update the database credentials in src/main/resources/application.properties:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
### 3. Build the Project
Run the following command to build the project:
```bash
mvn clean install
```
### 4. Run the Project
Run the application with:
```bash
mvn spring-boot:run
```
The application will start on http://localhost:8080.

### API Endpoints

### 1. Add a New Book
POST /books/add-book/
Request Body (JSON):
```json
{
  "isbn": "Book id",
  "title": "Book Title",
  "author": "Author Name",
  "publicationYear": "year"
  "available": "true or false",
  "borrowed": "true or false"
}
```
### 2. Get All Books
GET /books/view-available-books/

### 3. Borrow the Book
POST /books/borrow/{id}

### 4. Return the Book
POST /books/return/{id}

### 5. Update a Book
PUT /books/update-book/{id}
* Request Body (JSON):
```json
{
  "isbn": "Book id",
  "title": "Book Title",
  "author": "Author Name",
  "publicationYear": "year"
  "available": "true or false",
  "borrowed": "true or false"
}
```
### 6. Delete a Book
DELETE /books/delete-book/{id}

---

## Project Structure
```bash
library-management-system/
│
├── src/main/java/com/library/library_management_system
│   ├── Controller
│   │   └── BookController.java  # Handles API requests
│   ├── Model
│   │   └── Book.java            # Represents the Book entity
│   ├── Repository
│   │   └── BookRepository.java  # Manages database interactions
│   └── Service
│       └── BookService.java     # Contains business logic
│
├── src/main/resources
│   ├── application.properties   # Project configurations
│   └── data.sql                 # Initial data for testing (optional)
│
├── pom.xml                      # Maven dependencies
└── README.md                    # Project documentation
```
---

## Dependencies
The project uses the following dependencies, managed via Maven:

* Spring Boot Starter Web: For building REST APIs.
* Spring Boot Starter Data JPA: For database interaction.
* MYSQL Driver: For connecting to the MYSQL database.
* Spring Boot Starter Test: For testing the application.
  
# Running the Application
Ensure MYSQL is running.<br>
Build and run the application as described in the setup section.<br>
Use tools like Postman or cURL to test the API endpoints.

# Future Enhancements
Add user authentication and authorization.<br>
Implement pagination and sorting for book listings.<br>
Add a front-end interface for users to interact with the system.

## Author
 **CHEMURU MUNI KUMAR <br>
 Email: munikumarchemuru2003@gmail.com**
