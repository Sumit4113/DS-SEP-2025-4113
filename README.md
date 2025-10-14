🧳 Trip Management API
A RESTful web service built with Spring Boot 3, Hibernate (JPA), and MySQL to manage trips. It includes comprehensive features like CRUD operations, search, filtering, pagination, and Swagger documentation.

🧠 Tech Stack
This project utilizes a modern Java-based stack:

Component	Technology
Language	Java 17
Framework	Spring Boot 3.x
ORM	Hibernate / Spring Data JPA
Database	MySQL
Build Tool	Maven
Docs	Swagger / OpenAPI
Tests	JUnit + Mockito

Export to Sheets
🚀 Features
The API provides the following core functionalities:

✅ CRUD Operations: Create, Read, Update, and Delete trips.

✅ Search & Filtering:

Search trips by destination.

Filter trips by status (PLANNED, ONGOING, COMPLETED).

✅ Data Handling:

Pagination & sorting support.

Custom validations & global exception handling.

✅ Documentation & Testing:

Swagger (OpenAPI 3.0) documentation.

Unit tests (JUnit + Mockito).

⚠️ Important Version Note
To ensure proper functionality, especially for the Swagger UI, adhere to these specific versions:

Use Spring Boot 3.1.4.

Use Swagger (springdoc-openapi) version 2.3.0.

If these versions do not match, the Swagger UI or some endpoints may not work correctly.

⚙️ Setup Instructions
1️⃣ Prerequisites
You must have the following installed:

Java 17+

Maven 3.8+

MySQL

Create the necessary database in MySQL:

SQL

CREATE DATABASE tripdb;
2️⃣ Configure Database
Edit the configuration file at src/main/resources/application.properties with your MySQL details:

Properties

#SERVER
server.port=8080

#MYSQL
spring.datasource.url=jdbc:mysql://localhost:3306/tripdb
spring.datasource.username=root
spring.datasource.password=your_password

#JPA
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
3️⃣ Run the Application
You can start the Spring Boot application using one of the following methods:

Maven: Run the command:

Bash

mvn clean spring-boot:run
IDE: Run the main class, TripManagementApplication.java, from your preferred IDE (e.g., Eclipse, IntelliJ IDEA).

🌐 Access API
Once the application is running, you can access the API documentation and endpoints:

🧭 Swagger UI: http://localhost:8080/swagger-ui.html

📄 OpenAPI JSON: http://localhost:8080/swagger/api-point

📚 API Endpoints
Method	Endpoint	Description
POST	/api/trips	Create a new trip
GET	/api/trips	Get all trips (with pagination)
GET	/api/trips/{id}	Get trip by ID
PUT	/api/trips/{id}	Update a trip
DELETE	/api/trips/{id}	Delete a trip
GET	/api/trips/search?destination=Paris	Search by destination
GET	/api/trips/filter?status=PLANNED	Filter by status
GET	/api/trips/daterange?start=2025-09-01&end=2025-09-30	Get trips in date range
GET	/api/trips/summary	Get total/min/max/avg price summary

Export to Sheets
🧾 Sample Request
Use this sample payload to test the POST /api/trips endpoint:

Request Body:

JSON

{
  "destination": "Paris",
  "startDate": "2025-09-10",
  "endDate": "2025-09-20",
  "price": 1500.00,
  "status": "PLANNED"
}
Successful Response:

JSON

{
  "id": 1,
  "destination": "Paris",
  "startDate": "2025-09-10",
  "endDate": "2025-09-20",
  "price": 1500.0,
  "status": "PLANNED"
}
🧪 Testing
Unit Tests
Unit tests are written with JUnit 5 and Mockito for service-layer verification.

To run the unit tests, use:

Bash

mvn test
Postman Collection
A ready-to-use Postman collection is provided for easy API testing:

File: TripManagementAPI.postman_collection.json

Path: Project Root Folder

To Use:

Open Postman → Import → Upload Files.

Choose TripManagementAPI.postman_collection.json.

Start testing your endpoints.

📥 Download Collection (from GitHub)

🗃️ Database Script
The following SQL script is available at src/main/resources/tripdb.sql for initial setup and sample data:

SQL

CREATE DATABASE tripdb;

INSERT INTO trips (destination, start_date, end_date, price, status)
VALUES
('Paris', '2025-09-10', '2025-09-20', 1500.00, 'PLANNED'),
('London', '2025-08-01', '2025-08-10', 1200.00, 'COMPLETED');

👨‍💻 Author
Sumit Jamod

📧 jdsumit01@gmail.com

Project Details:

🗓️ October 2025

Assignment by Badkul Technology Pvt. Ltd.
