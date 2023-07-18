Project Name  # employee_globalassignment
=======================

This Readme file provides instructions for running the Spring Boot project, setting up the database, accessing the API, and includes basic API documentation for every route.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Installation and Setup](#installation-and-setup)
- [Running the Project](#running-the-project)
- [Database Setup](#database-setup)
- [API Documentation](#api-documentation)

## Prerequisites
- Java Development Kit (JDK) installed
- Maven build tool installed
- MongoDB database setup (if using MongoDB)

## Installation and Setup
1. create the spring boot project using spring initializer

2. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).

3. If using Maven, let it resolve the project dependencies automatically.

4. Update the database configuration properties in the `application.properties` file.

5. Save any necessary API keys or credentials in the `application.properties` file.

## Running the Project
1. Build the project using Maven:
    
3. Run the project using Maven or your IDE's run configuration.

4. The Spring Boot application will start, and you can access the API endpoints.

## Database Setup
- If using MongoDB, ensure that MongoDB is installed and running.
- Update the `application.properties` file with the appropriate database connection details.
- # MongoDB connection properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=employeedb
#spring.data.mongodb.authentication-database=admin
#spring.data.mongodb.username=<your-username>
#spring.data.mongodb.password=<your-password>

# Logging configuration
logging.level.org.springframework.data.mongodb=DEBUG
logging.level.com.mongodb=DEBUG


## API Documentation
Below is the basic API documentation for each route in the project:

1. Get All Employees
- Method: GET
- Endpoint: http://localhost:8080/api
- Description: Retrieve all employees from the database.
- Request Parameters: None
- Response: List of Employee objects

2. Add Employee
- Method: POST
- Endpoint: http://localhost:8080/api/employees
- Description: Add a new employee to the database.
- Request Body: Employee JSON object
- Response: ID of the newly added employee

3. Get Employee by ID
- Method: GET
- Endpoint: api/employees/{id}
- Description: Retrieve an employee by their ID.
- Request Parameters: Employee ID
- Response: Employee object

4. Update Employee by ID
- Method: PUT
- Endpoint: http://localhost:8080/api/{id}
- Description: Update an existing employee by their ID.
- Request Parameters: Employee ID
- Request Body: Updated Employee JSON object
- Response: Updated Employee object

5. Delete Employee by ID
- Method: DELETE
- Endpoint: http://localhost:8080/api/{id}
- Description: Delete an employee from the database by their ID.
- Request Parameters: Employee ID
- Response: None
#pagination
  Get Employees with Pagination and Sorting
- Method: GET
- Endpoint: http://localhost:8080/api?pageNo=__&pageSize=__&sortBy=__&sortOrder=__
- Description: Retrieve employees with pagination and sorting options.
- Request Parameters:
  - pageNo: Page number (default: 0)
  - pageSize: Number of items per page (default: 0)
  - sortBy: Sorting field (default: 0)
  - sortOrder: Sorting order (default: 0)
- Response: Paginated list of Employee objects

## GitHub
To upload the project to a GitHub repository, follow these steps:

1. Create a GitHub account: If you don't have one already, visit the GitHub website (https://github.com/) and sign up for a free account.

2. Create a new repository: Once you're signed in to GitHub, click on the "+" icon in the top-right corner and choose "New repository" from the dropdown menu. # my repository name employee_globalassignment

3. Initialize your local repository: If you haven't already done so, initialize your local project directory as a Git repository. Open your project in IntelliJ IDEA, open the terminal, and navigate to the project directory. Run the following command: git init
   
5. Add files to the repository: Use the following command to stage all the files in your project for commit: git add .

6. Connect your local repository to the GitHub repository: Copy the URL of your GitHub repository (e.g., `https://github.com/your-username/your-repo.git`). In the terminal, run the following command, replacing `<repository-url>` with the actual URL:
 git remote add origin  https://github.com/Masroofl/employee_globalassignment/pull/new/master

7. Commit the changes with the following command: Commit the staged files with a meaningful commit message in double coutes:
    git commit -m "sourceapp"
  
8. Push your code to GitHub: Push the committed changes to the GitHub repository: git push origin master

For any further assistance or questions, please contact [Your Name or Contact Information].


