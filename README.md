# Enrollees Services using Java & Sprint Boot

Coding completed by [Kunal Bhatia](https://github.com/bhatia4/), as as part of coding challenge (Challenge details [here](https://github.com/bhatia4/enrollee-services-spring/blob/master/backend-challenge.md))

Implemented using Spring framework libraries - Spring Boot, Spring Boot Validation and Spring JPA (as ORM impl.). Also used Springfox Swagger libraries to setup Swagger API documentation & testing platform for the API. Goto [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/) to view/test using Swagger UI for any respective API endpoint.

## Installation

* For deployment/testing right away use the enrollee-services-0.0.1-SNAPSHOT.jar file found under target folder. You can run the jar as is since its implemented as standalone microservice (w/ embedded undertow library). Run the scripts/execute-enrollee-services.bat or scripts/execute-enrollee-services.sh based on your OS for starting up the services and testing.

* For setup as project. The project has maven build framework and can be imported as maven project in any IDE. The code also has mvnw and mvnw.cmd files which are Maven wrappers and allow you to run the Maven project in command line. The mvnw file is for Linux (bash) and the mvnw.cmd is for the Windows environment.

## Testing

Once deployment is successful, using postman or any services client you can test against following endpoints:
* Add a new enrollee - HTTP POST localhost:8080/api/v1/enrollees/
* Modify an existing enrollee - HTTP PUT localhost:8080/api/v1/enrollees/:enrolleeid/
* Remove an enrollee entirely - HTTP DELETE localhost:8080/api/v1/enrollees/:enrolleeid/
* Add dependent to an enrollee - HTTP POST localhost:8080/api/v1/enrollees/:enrolleeid/dependent
* Modify existing dependent - HTTP PUT localhost:8080/api/v1/enrollees/:enrolleeid/dependent/:dependent
* Remove existing dependent from an enrollee - HTTP DELETE localhost:8080/api/v1/enrollees/:enrolleeid/dependent/:dependent

## Example JSON Request - Add a new enrollee / Modify an existing enrollee
```
{
  "activationStatus": true,
  "birthDate": "1987-02-29",
  "name": "Kenny Gee",
  "phoneNumber": "548-828-6089"
}
```

## Example JSON Request - Add dependent to an enrollee / Remove existing dependent from an enrollee
```
{
  "birthDate": "2020-09-10",
  "name": "John Smith"
}
```

## Requirements

Tested and run against Java SE 11 

## Database Documentation
* Database model shown below:
<img src="https://raw.githubusercontent.com/bhatia4/enrollee-services-spring/master/db/enrolleesdb%20DB%20model%20diagram.png">

* More details on tables above [here](https://htmlpreview.github.io/?https://github.com/bhatia4/enrollee-services-spring/blob/master/db/enrolleesdb.html)
* DDL scripts on creating above tables on your own Postgres database server [here](https://github.com/bhatia4/enrollee-services-spring/blob/master/db/enrolleesdb.sql)
* To update database server and client connection goto application.properties file found [here](https://github.com/bhatia4/enrollee-services-spring/blob/master/src/main/resources/application.properties). Change properties spring.datasource.url, spring.datasource.username & spring.datasource.password

## Links used as reference while coding
* [https://spring.io/guides/gs/spring-boot/#scratch](https://spring.io/guides/gs/spring-boot/#scratch)
* [https://start.spring.io/](https://start.spring.io/)
* [https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)
* [https://stackoverflow.com/questions/52612241/spring-jpa-crud-repository-save-not-returning-uuid-field](https://stackoverflow.com/questions/52612241/spring-jpa-crud-repository-save-not-returning-uuid-field)
* [https://spring.io/guides/gs/accessing-data-jpa/](https://spring.io/guides/gs/accessing-data-jpa/)
* [https://stackoverflow.com/questions/34317503/ids-for-this-class-must-be-manually-assigned-before-calling-save-with-string](https://stackoverflow.com/questions/34317503/ids-for-this-class-must-be-manually-assigned-before-calling-save-with-string)
* [https://stackoverflow.com/questions/37976632/how-to-search-by-multiple-columns](https://stackoverflow.com/questions/37976632/how-to-search-by-multiple-columns)
* [https://zetcode.com/springboot/postgresql/](https://zetcode.com/springboot/postgresql/)
* [https://www.baeldung.com/spring-data-partial-update](https://www.baeldung.com/spring-data-partial-update)
* [https://www.baeldung.com/spring-data-crud-repository-save](https://www.baeldung.com/spring-data-crud-repository-save)
