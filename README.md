# 🧳 Trip Management API

## A RESTful web service built with Spring Boot 3, Hibernate (JPA), and MySQL  
to manage trips — including CRUD operations, search, filtering, pagination, and Swagger documentation.

---

## 🚀 Features

✅ CRUD operations (Create / Read / Update / Delete)  
✅ Search trips by destination  
✅ Filter trips by status (PLANNED, ONGOING, COMPLETED)  
✅ Pagination & sorting support  
✅ Custom validations & global exception handling  
✅ Swagger (OpenAPI 3.0) documentation  
✅ Unit tests (JUnit + Mockito)

---

## 🧠 Tech Stack

| Component | Technology |
|------------|-------------|
| **Language** | Java 17 |
| **Framework** | Spring Boot 3.x |
| **ORM** | Hibernate / Spring Data JPA |
| **Database** | MySQL |
| **Build Tool** | Maven |
| **Docs** | Swagger / OpenAPI |
| **Tests** | JUnit + Mockito |

---

## 📚 Important Note

🟡 **Project Version Compatibility:**
- Use **Spring Boot 3.1.4**
- Use **Swagger (springdoc-openapi) version 2.3.0**

If versions don’t match, Swagger UI or some endpoints may not work properly.

👉 After running the application, access it using the link in the **Access API** section below.

---

## ⚙️ Setup Instructions

### 1️⃣ Prerequisites
Install **Java 17+**, **Maven 3.8+**, and **MySQL**  
Then create a database:
```sql
CREATE DATABASE tripdb;

      
---


#📚 *Improtant Note
Firstly if you create your spring boot project choose version 3.1.4.
Also If you use Swagger UI so choose dependecy version 2.3.0.
Because some times version are different so your appliction are not work properly 

And Also if you used this code and run in your application throw the link that i provide in below at Access point


---
      

#⚙️ Setup Instructions

1️⃣ Prerequisites

Install Java 17+, Maven 3.8+, and MySQL
Create a database:
CREATE DATABASE tripdb;


---


2️⃣ Configure Database

Edit your src/main/resources/application.properties:

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


---

 
3️⃣ Run the Application
mvn clean spring-boot:run
or in your IDE → run TripManagementApplication.java
you can use any IDE for this project like eclips and IntelliJ IDEA 


---


#🌐 Access API

Once running, open:

🧭 Swagger UI: http://localhost:8080/swagger-ui.html

📄 OpenAPI JSON: http://localhost:8080//swagger/api-point


---


#📚 API Endpoints

Method	    Endpoint	                                            Description
POST	      /api/trips	                                          Create a new trip
GET	        /api/trips	                                          Get all trips (with pagination)
GET       	/api/trips/{id}                                     	Get trip by ID
PUT       	/api/trips/{id}     	                                Update a trip
DELETE	    /api/trips/{id}                                     	Delete a trip
GET	        /api/trips/search?destination=Paris	                  Search by destination
GET	        /api/trips/filter?status=PLANNED	                    Filter by status
GET	        /api/trips/daterange?start=2025-09-01&end=2025-09-30	Get trips in date range
GET	        /api/trips/summary	                                  Get total/min/max/avg price summary


---


#🧾 Sample Request that you can use for test the project are worked 
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


---     


#🧪 Testing

Run unit tests:

mvn test


Unit tests are written with JUnit 5 and Mockito for service-layer verification.


---


#🗃️ Database Script

SQL file: src/main/resources/tripdb.sql

CREATE DATABASE tripdb;

INSERT INTO trips (destination, start_date, end_date, price, status)
VALUES
('Paris', '2025-09-10', '2025-09-20', 1500.00, 'PLANNED'),
('London', '2025-08-01', '2025-08-10', 1200.00, 'COMPLETED');


---


# 🧪 Postman Collection

A ready-to-use Postman collection is included for easy API testing.

📄 **File:** `TripManagementAPI.postman_collection.json`  
📍 **Path:** Project Root Folder  

To use:
1. Open Postman → Import → Upload Files  
2. Choose `TripManagementAPI.postman_collection.json`  
3. Start testing your endpoints

📥 [Download Collection (from GitHub)](https://github.com/Sumit4113/DS-SEP-2025-4113/raw/main/TripManagementAPI.postman_collection.json)


👨‍💻 Author

Sumit Jamod
📧 jdsumit01@gmail.com

🗓️ October 2025
Assignment by Badkul Technology Pvt. Ltd.
