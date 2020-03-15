# Test project for self-education
  
## Topics for education    
  
  - Java 8
  - Spring (mvc, rest, data, ...)
  - Spring-boot
  - CI/CD with Jenkins
  - Docker
  - Testcontainer
  - ... to be continued ...

### local start SpringRestSimpleApplication for testing and debugging
profile 'dev'

### Default endpoint for local start
http://localhost:8081/books

### Run maven build with image creating (without push)
mvn compile jib:dockerBuild

### Run container into docker with port 8082
docker run -p 8082:8081 -it -d spring-rest-simple