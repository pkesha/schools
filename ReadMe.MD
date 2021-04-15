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


-------

Phase 3 -> 
Anyone can view all the categories and they are owned by no one and created 
by everyone.

Making Reviews and Comments publicly viewable by anyone.
Also making it so that a user is owner of each review / comment

Unit Testing 

| REQUEST TYPE     | END POINT | PAYLOAD | RESULTS |
| ----------- | ----------- | ----------- |----------- |
| GET | http://localhost:9092/api/categories|n/a|Categories List
|POST| http://localhost:9092/api/categories|Category|Create Category|

###
GET http://localhost:9092/api/categories/{{categoryId}}

###
PUT http://localhost:9092/api/categories/{{categoryId}}

###
DELETE http://localhost:9092/api/categories/{{categoryId}}

###
GET http://localhost:9092/api/categories/{{categoryId}}/reviews

###
POST http://localhost:9092/api/categories/{{categoryId}}/reviews

###
GET http://localhost:9092/api/categories/{{categoryId}}/reviews/{{reviewId}}

###
PUT http://localhost:9092/api/categories/{{categoryId}}/reviews/{{reviewId}}

###
DELETE http://localhost:9092/api/categories/{{categoryId}}/reviews/{{reviewId}}

###
GET http://localhost:9092/api/categories/{{categoryId}}/reviews/{{reviewId}}/comments

###
POST http://localhost:9092/api/categories/{{categoryId}}/reviews/{{reviewId}}/comments

###
GET http://localhost:9092/api/categories/{{categoryId}}/reviews/{{reviewId}}/comments/{{commentId}}

###
PUT http://localhost:9092/api/categories/{{categoryId}}/reviews/{{reviewId}}/comments/{{commentId}}

###
DELETE http://localhost:9092/api/categories/{{categoryId}}/reviews/{{reviewId}}/comments/{{commentId}}

###
POST http://localhost:9092/auth/users/create

###
POST http://localhost:9092/auth/users/login

###
POST http://localhost:9092/auth/users/register

###
GET http://localhost:9092/categories

###
GET http://localhost:9092/categories/{{categoryId}}

###
GET | http://localhost:9092/categories/{{categoryId}}/reviews |

###
GET http://localhost:9092/categories/{{categoryId}}/reviews/{{reviewId}}

###
GET http://localhost:9092/categories/{{categoryId}}/reviews/{{reviewId}}/comments

###
GET http://localhost:9092/categories/{{categoryId}}/reviews/{{reviewId}}/comments/{{commentId}}




