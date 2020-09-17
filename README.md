# Registration API and client (JavaScript)

## Summary:
* Registration form can be reached via http://localhost:8080/registration
* There is an endpoint for POST http://localhost:8080/api/v1/registration
* Input validation in Java side 
  * If the provided email already exists
  * Name should not be number
  * Password match
  * Mandatory fields are not null or empty etc.
* Input validation is also done on client side using HTML's required Attribute
* JavaScript Client
* Api Documentation using Swagger
* Data is saved into in memory DB, on every start up of the app the DB is newly created, which is not good for production, but used only for demo purpose


## API documentation 
I used Swagger to document the API. 
After running the application it can be seen from here:
 http://localhost:8080/swagger-ui/#/registration-api-controller/addUserUsingPOST

 ### Request body
 - Click on the POST button from above link
 ![Request body](/doc/post-button-request-body-detail.png)
 - Now look at the Request body section. Here you can see all the fields, the required fields as well.
 - At the right side of "Request body", you can see that the method accepts "application/x-www-form-urlencoded"

 ### Response 
 - Responses section shows the response code and their messages.
 - Please click on the "Schema". There I have written the detail of the message format
 ![Response](/doc/response.png)
 
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
The reason is, since I am using Spring Eco-system, it is better not to mix Spring Rest and JAX-RS
in the same project if possible. Since the code was very easy to migrate, I did so.
* Original templating was done using velocity. Since Thymeleaf is more popular and I already knew it,
it was less time consuming for me to switch to thymeleaf instead of looking up the syntax of velocity. And switching to Thymeleaf doesn't lower the quality and since it is faster for me, I did so.
* I used swagger for easy documenting of the API. For large API I would also consider generating the initial code using Swagger
* I changed the original registraion link from http://localhost:8080/registration.html to http://localhost:8080/registration, 
i.e. I removed the .html part. User doesn't need to know if it is .html or.php or anything else.
* Updated Spring boot to the latest version

## Future improvements
- For production we should not recreate the DB on each startup
- Add password strength check on the JavaScript side 
- Send email to the user

If you have any questions or feedback, I will be happy to hear it.
