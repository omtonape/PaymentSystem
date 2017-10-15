# REST based Payment Transfer service

This is simple rest based payment transfer service using spring boot 1.5.6 maven 3.x java 1.8 .
This service allows you to create account and transfer money from one account to another account

## How to Run 

This application is packaged as a jar which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository 
* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
```
        java -jar -Dspring.profiles.active=test target/PaymentTransferSystem-0.0.1-SNAPSHOT.jar
or
        mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"
```
* Check the stdout or .log file to make sure no exceptions are thrown

Once the application runs you should see something like this

```
2017-08-30 17:31:23.091  INFO 19387 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8090 (http)
2017-08-30 17:31:23.097  INFO 19387 --- [           main] com.com.ingenico.payment.PaymentSystemApplication        : Started Application in 22.285 seconds (JVM running for 23.032)
```

## About the Service

The service is just a simple amount transfer REST service. It uses an in-memory database (H2) to store the data. You can also do with a relational database like MySQL or PostgreSQL. You can test rest api's defined in class ```com.ingenico.payment.api.rest.AccountController``` on **port 8090**. (see below)

You can use this sample service to understand the conventions and configurations that allow you to create a DB-backed RESTful service. Once you understand and get comfortable with the sample app you can add your own services following the same patterns as the sample service.
 
Here are some endpoints you can call:


### Create a account resource

```
POST /ingenico/v1/account
Accept: application/json
Content-Type: application/json

{
"name" : "Mahendra",
"balance" : 7000
}

RESPONSE: HTTP 201 (Created)
AccountID: 1
```

### Retrieve all accounts in system

```
GET : /ingenico/v1/account

Response: HTTP 200
Content: [
  {
"name": "Vishal",
"balance": 4500
},
  {
"name": "priya",
"balance": 3500
},
  {
"name": "Sanket",
"balance": 100
},
  {
"name": "Shubham",
"balance": 6900
}
],

### Transfer Balance

```
POST ingenico/v1/account/transferAmount
Accept: application/json
Content-Type: application/json

{
"srcName" : "Sanket",
"destName" : "Shubham",
"amount" : "1900"
}

RESPONSE: HTTP 201 (Created)
Header : Successfully transfered amount :1900 from account : Sanket to Shubham```
### To view Swagger 2 API docs

Run the server and browse to localhost:8090/swagger-ui.html

Limitations:

Spring boot acutator provides apis for monitoring health, metrics of application in production environment this is not configured in application due to time constraints.

Very few test cases are present in application if get more time will add more test cases 
and improve existing test cases.

REST API is not secured.