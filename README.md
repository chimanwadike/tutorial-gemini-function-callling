# Gemini Function Calling - A Java SpringBoot Sample Project

### A simple illustration of Gemini Function Calling during my talk @ GDG I/O Extended Event

Please add these properties inside the application.properties file
Create a mysql database and update the database values

## application.properties

````
spring.application.name=FC
spring.datasource.url=jdbc:mysql://localhost/db-name
spring.datasource.username=db-username
spring.datasource.password=db-password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.open-in-view=false
spring.ai.vertex.ai.gemini.credentialsUri=classpath:path-to-credentials
spring.ai.vertex.ai.gemini.location=us-central1
spring.ai.vertex.ai.gemini.project-id=project-id
spring.ai.vertex.ai.gemini.apiEndpoint=us-central1-aiplatform.googleapis.com
spring.ai.vertex.ai.gemini.chat.options.model=gemini-1.5-pro-001
spring.ai.vertex.ai.gemini.chat.options.temperature=0.5
````
PS: Running the project should execute all database migrations
