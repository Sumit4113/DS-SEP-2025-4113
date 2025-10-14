
#🧳 Trip Management API

A RESTful web service built with Spring Boot 3, Hibernate (JPA), and MySQL to manage trips — including CRUD operations, search, filtering, pagination, and Swagger documentation.





🚀 Features

✅ CRUD operations (Create / Read / Update / Delete)
✅ Search trips by destination
✅ Filter trips by status (PLANNED, ONGOING, COMPLETED)
✅ Pagination & sorting support
✅ Custom validations & global exception handling
✅ Swagger (OpenAPI 3.0) documentation
✅ Unit tests (JUnit + Mockito)



🧠 Tech Stack
Component	Technology
Language	Java 17
Framework	Spring Boot 3.x
ORM	Hibernate / Spring Data JPA
Database	MySQL
Build Tool	Maven
Docs	Swagger / OpenAPI
Tests	JUnit + Mockito



⚙️ Setup Instructions

1️⃣ Prerequisites

Install Java 17+, Maven 3.8+, and MySQL
Create a database:
CREATE DATABASE tripdb;



2️⃣ Configure Database

Edit your src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/tripdb?useSSL=false
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

3️⃣ Run the Application
mvn clean spring-boot:run


or in your IDE → run TripManagementApplication.java

🌐 Access API

Once running, open:

🧭 Swagger UI: http://localhost:8080/swagger-ui.html

📄 OpenAPI JSON: http://localhost:8080/v3/api-docs

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


🧾 Sample Request
POST /api/trips

{
  "destination": "Paris",
  "startDate": "2025-09-10",
  "endDate": "2025-09-20",
  "price": 1500.00,
  "status": "PLANNED"
}


Response:

{
  "id": 1,
  "destination": "Paris",
  "startDate": "2025-09-10",
  "endDate": "2025-09-20",
  "price": 1500.0,
  "status": "PLANNED"
}

🧪 Testing

Run unit tests:

mvn test


Unit tests are written with JUnit 5 and Mockito for service-layer verification.

🗃️ Database Script

SQL file: src/main/resources/tripdb.sql

CREATE DATABASE tripdb;

INSERT INTO trips (destination, start_date, end_date, price, status)
VALUES
('Paris', '2025-09-10', '2025-09-20', 1500.00, 'PLANNED'),
('London', '2025-08-01', '2025-08-10', 1200.00, 'COMPLETED');

📸 Swagger Preview

👨‍💻 Author

Sumit Jamod
📧 jdsumit01@gmail.com

🗓️ October 2025
Assignment by Badkul Technology Pvt. Ltd.
