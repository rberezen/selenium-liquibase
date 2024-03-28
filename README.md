The repository demonstrates how to integrate Liquibase into a test framework to efficiently manage and reset test data within your database.

There are three ways to integrate Liquibase into your test framework: by using the Liquibase Maven plugin, by adding Liquibase Core and using its API in automated tests, and by utilizing Liquibase CLI capabilities.
This repository demonstrates how to integrate Liquibase into a Java + Maven + Selenium WebDriver framework, a popular combination nowadays.

# Preconditions for running tests in the repository
1. Have docker
2. Have maven
3. Have php
4. Have chrome

# Steps to run tests 
1. Navigate to docker folder and run MySQL docker database `docker-compose -f docker-compose-my-sql.yml up`
2. Navigate to web folder and start a built-in PHP web server `php -S localhost:8000`
3. Navigate to root folder and run tests `mvn test`

# Repository structure
1. /bin folder contains Liquibase CLI
2. /docker folder contains MySQL docker-compose file
3. /src/main/java folder contains source code files
4. /src/main/resources folder contains configuration files and chromedriver
5. /src/main/test folder contains test classes 
6. /web folder contains a test PHP webpage

