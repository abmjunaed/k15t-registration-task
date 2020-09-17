# Registration API and client (JavaScript)

## Summary:
* Input validation in Java side 
** If the provided email already exists
** Name should not be number
** Password match
** Mandatory fields are not null or empty etc.
* Input validation is also done on client side using HTML's required Attribute
* Data is saved into in memory DB, on every start up of the app the DB is newly created, which is not good for production, but used only for demo purpose


## API documentation 
I used Swagger to document the API. 
It can be seen from here:
 http://localhost:8080/swagger-ui/#/registration-api-controller/addUserUsingPOST

 ### Request body
 - Click on the POST button from above link
 - Now look at the Request body section. Here you can see all the fields, the required fields as well.
 - At the right side of "Request body", you can see that the method accepts "application/x-www-form-urlencoded"

 ### Response 
 Responses section shows the response code and their messages 
 - 400 Bad request sends the errors of all fields. So thee the message format, please click on the "Schema".
 There I have written the detail of the message format
 
 ## How to run
 
 * Run following commands
 
 ```
	mvn compile
	mvn package
	>java -jar target\k15t-full-stack-dev-tasks-0.1.0.jar
 ```
 * Goto http://localhost:8080/registration
 * Fill the forms and press submit button
 * If there is any error, it will be shown beside the fields of the form
 * If the registration is successful, you will see an alert with success message 

## Code structure
 * *com.k15t.pat.client.controller* contains the MVC controller for serving the registration page  
 * *com.k15t.pat.server.api.RegistrationApiController* contains the Rest API
 * All the packages and class names are self explanatory
 
## Some decisions  
* Instead of using JAX-RS, I am using Spring for REST endpoint. 
The reason is, since I am using Spring Eco system, it is better not to mix Spring Rest and JAX-RS
in the same project, if I have the choice. Since the code was very easy to migrate, I did so.
* Original templating was done using velocity. Since Thymeleaf is more popular and I already knew it,
it was less time consuming for me to switch to thymeleaf instead of looking up the syntax of velocity
* I used swagger for easy documenting of the API. For large API I would also generate the initial code using Swagger
* I changed the original registraion link from http://localhost:8080/registration.html to http://localhost:8080/registration, 
i.e. I removed the .html part. User doesn't need to know if it is .html or.php...

## But *what* should I do exactly?
Extend the form with the required fields (see registration.vm for further details) and 
store the entered information by using a REST endpoint. Giv the user feedback if the
save was successful or in case of an error. Ensure mandatory fields will be entered
and verify the entered values are reasonable e.g. the name must not contains numbers.

To start with, please see the already created files and classes. Especially:

* com.k15t.pat.registration: The package includes a REST endpoint and a controller
* resources/templates: The folder includes the initial velocity templates for the registration page 

The Maven build creates a executable jar which includes the whole runtime (tomcat) to run the app.
You can start it with java -jar registration-0.1.0.jar. If the application is started the pages are
available under http://localhost:8080/registration.html

## A few words about the technology stack
The application is build on top of Spring Boot (http://projects.spring.io/spring-boot/) providing a runtime container. 
Furthermore Jersey for implementing REST resources, Velocity for templating pages and jQuery/Bootstrap is included and 
can be used as well. Building and packaging the application is done with Maven. 

## What's expected of me?
When our engineers receive your final result, we'll be looking at the following things:

* The documentation provided. Please consider to document assumptions or decisions you made (e.g. technologies used). Clear and concise documentation is a must for a senior role. The documentation should start in the README.md, which can then contain links/pointers into any further documentation.
* The ability to build it out of the box using maven
* Improvements you made around the main task
* The quality and style of code written
* The tests and their structure and coverage
* The choice of technologies used to complete the task. You are free to use whatever you think is needed and helps you to get it done!

Typically we expect it to compile and run on a Mac environment with Java 8. If your set up is any different, do let us know!
When you are done share the result via GitHub or Bitbucket.

## How to use git ##

To use git to get repository contents run the following git command:

```
#!bash
git clone https://bitbucket.org/K15t/k15t-full-stack-dev-tasks.git
```

Afterwards create a repository in your github or Bitbucket account and configure this empty repository as the remote origin:

```
#!bash
git remote set-url origin git@github.com:you/yourrepo.git
git push
```
In this way you have now a clean repository and can start to commit to it and we will be able to distinguish between what was your contribution and what was already there. Please do not copy everything into an empty repo and then add all files, this will make the git log and diff a mess.

Tip: Use git as you would in a product environment - small, meaningful commits with descriptive commit messages. This makes it easy for the reviewer to follow your steps and comprehend what you are doing.

Good luck!