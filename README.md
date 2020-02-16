springboot Transaction Parser Application
=========================================

What is it?
-----------

The `springboot-parser-app`, provides REST end-point for uploading 
transactions into postgres database. And provides another endpoint
for generating SummaryReport for the transactions in the Database, 

There are 2 endpoints exposed by this app

* `upload` - for uploading transactions file data to postgres DB
* `report` - generating Summary Report for the transactions 


System Requirements
-------------------

All you need to build this project is 

* Java 11 (Java SDK 1.11).
*  Maven 3.3.8 or later.
*  Docker and Docker-Compose

Build and Run the springboot-parser-app
--------------------------------------------

1. Open a terminal and navigate to the root directory of this springboot-parser-app.

2. Build application
   ```
    mvn clean install
    ```
2. Build docker image and run the application 

   ```
   docker-compose up --build

   ```
3. Check App and postgres db is up and running
   
   ```
   docker ps
   ```   
   
4. Uploading the transaction Data
   
   ```
   curl -v -X POST -H "Content-Type: multipart/form-data" -F "file=@Input.txt" http://localhost:8080/upload
   
   ```
5. Generating Report 
 
   ```
   curl -v http://localhost:8080/report
   
   ```
 
