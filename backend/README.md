## Backend

*	Default active profile is **`dev`**. When the application is running, it will create the necessary tables and system data along with sample data. In the **`dev`** profile, the application uses **H2** database (data in memory).

* 	URL to access application UI which is Swagger UI: **http://localhost:8080/**

* 	Other profile called **`prod`** is also available for production set up. Although, it uses a real database which should be running.

#### Running the application with IDE

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method from your IDE.

* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open IDE
	* Open the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application

#### Running the application with Maven

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
$ mvn spring-boot:run
```

#### Running the application with Executable JAR

The code can also be built into a jar and then executed/run. Once the jar is built, run the jar by double clicking on it or by using the command 

```shell
$ mvn package
$ java -jar target/{name of the file}.jar --spring.profiles.active=dev
```

#### Accessing Data in H2 Database using console

URL to access H2 console: **http://localhost:8080/h2-console/** 

Fill the login form as follows and click on Connect:

* 	Saved Settings: **Generic H2 (Embedded)**
* 	Setting Name: **Generic H2 (Embedded)**
* 	Driver class: **org.h2.Driver**
* 	JDBC URL: **jdbc:h2:mem:sbat;MODE=MySQL**
* 	User Name: **sa**
* 	Password:

<img src="https://raw.githubusercontent.com/Spring-Boot-Framework/Spring-Boot-Application-Template/master/documents/images/h2db/h2-console-login.PNG"/>
