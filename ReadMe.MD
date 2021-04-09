Content Review Database:

This backend will allow the client to save users who then proceed to provide
their reviews on subjects and content of their choice. Each user can leave a
review that will fall under any particular category of the users choosing. Under
 each review, other users can leave comments as well.

In consideration of the user experience, users will only be able to use a First
and Last name and not a custom defined user name. This will provide a communal
experience that lends itself towards a sense of community.

##Domain Models

User, UserProfile, Category, Review, Comments

User
id
Password
email


UserProfile
id
userId
First Name String
Last Name String
Credentials List<String>

-----

Category
id
fk(Review )
Title
Description

----------

Review
id
Category (One to Many)
Title
Images
Text
Date
User
Category

----------

Comments
Text
Dates


-------


Application Set up
-IntelliJ spring set up
-application.properties
-application-dev.properties
-database set up
-project structure
-git hub set up
    -Testing a working git hub workflow
-pom.xml
----------------

MileStone:
HelloWorld rest end point api
localhost:9092/api/helloworld

----------------


Milestone: Basic Models in place
User
User Profile
Category
Review
Comments

--------

Milestone: Controller / Services / Exceptions
Category > Reviews > Comments

---------

Milestone: Spring Security

----------
BONUS
Milestone: JWT token implementation

Deploying Heroku

Integration Test






Exception Handling with Spring native features:
https://www.baeldung.com/exception-handling-for-rest-with-spring


