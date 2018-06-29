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

## 4. Installation / Startup server
1. Clone the repository and change into the repository via command line.
2. Build the project using the 'mvn clean package' command.
3. Check that your docker daemon is up and ready.
4. Start a command line and navigate into the 'sqsdemoserver' directory. 
5. Execute 'docker-compose up --build' to start all the necessary containers.

Additional:
- Docker-compose will pull a docker image of PostgreSQL database and a java-jre-slim image in order to execute the .jar file.
- The containers will be linked together in a virtual docker network
- In the 'sqsdemoserver' folder you will see a shell script 'wait-for-it.sh'. Due to some problems in the development process i needed this file that the Spring-Boot Server will only be started if the PostgreSQL container is running and all required tables are created. The script is not part of my own project (see [this repository](https://github.com/vishnubob/wait-for-it)).
