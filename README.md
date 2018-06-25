# Restful WebService 'Car Management'

## 1. Overview
A simple Spring-Boot based Java application to manage some cars. Comes along with a docker-compose file that first creates the necessary PostgreSQL database, followed by starting the Spring application.

## 2. Development
Used IDEs, frameworks and tools:
- IntelliJ IDEA 2018.1 Ultimate
- Docker CE for Windows Version 18.03.1-ce-win65 (17513)
- Java JDK 1.8.0_171
- Docker Compose Version 3
- Maven as Build Tool

## 3. Available Endpoints
The following endpoints will be offered by the webservice (base-url: http://localhost:8080):
- /cars -> Return all cars from the PostgreSQL database
- /cars/{vin} -> Returns a car with the given vin
