# stack
Initial starter project stack with a sample shopping list application:

* SpringBoot - Java
* Maven
* Docker
* GraphQL
* MongoDB

# Steps to start the application 
* Create a mongoDB instance either local or on Atlas and add the URI to the application.properties file
* Built and run the application
* Access the Graphiql using  http://localhost:8080/graphiql?path=/graphql

# To package the application (to be fixed)
* mvn package - produces artifact and build a docker image
* docker-compose up - starts mongodb, and the api service
