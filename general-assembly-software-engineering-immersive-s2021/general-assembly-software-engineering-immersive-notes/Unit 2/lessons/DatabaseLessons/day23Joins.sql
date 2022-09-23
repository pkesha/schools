{\rtf1\ansi\ansicpg1252\cocoartf2578
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fnil\fcharset0 Monaco;}
{\colortbl;\red255\green255\blue255;\red22\green21\blue22;\red22\green21\blue22;}
{\*\expandedcolortbl;;\cssrgb\c11373\c10980\c11373;\cssrgb\c11373\c10980\c11373\c3922;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\sl360\partightenfactor0

\f0\fs24 \cf2 \cb3 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 -- CREATE TABLE address(\cb1 \
\cb3 -- 	address_id SERIAL PRIMARY KEY,\cb1 \
\cb3 -- 	street VARCHAR(150),\cb1 \
\cb3 -- 	city VARCHAR(50),\cb1 \
\cb3 -- 	state VARCHAR(10)\cb1 \
\cb3 -- );\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- ALTER TABLE students ADD COLUMN student_address_id INT;\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT * FROM students;\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- ALTER TABLE students \cb1 \
\cb3 -- ADD CONSTRAINT fk_student_address \cb1 \
\cb3 -- FOREIGN KEY (student_address_id) \cb1 \
\cb3 -- REFERENCES address (address_id);\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- INSERT INTO address VALUES (DEFAULT, '200 Horton Ave', 'Lynbrook', 'NY');\cb1 \
\cb3 -- INSERT INTO address VALUES (DEFAULT, '123 Webdev Dr', 'Boston', 'MA');\cb1 \
\cb3 -- INSERT INTO address VALUES (DEFAULT, '555 Five St', 'Fivetowns', 'NY');\cb1 \
\cb3 -- INSERT INTO address VALUES (DEFAULT, '2 OldForThis Ct', 'Fivetowns', 'NY');\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT * FROM students;\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- update students set student_address_id = 1 where student_id = 1;\cb1 \
\cb3 -- update students set student_address_id = 2 where student_id = 2;\cb1 \
\cb3 -- update students set student_address_id = 3 where student_id = 3;\cb1 \
\cb3 -- update students set student_address_id = 4 where student_id = 4;\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT * FROM students, address \cb1 \
\cb3 -- WHERE address_id = student_address_id; \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT * FROM students;\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- CREATE TABLE courses (\cb1 \
\cb3 -- 	course_id SERIAL PRIMARY KEY,\cb1 \
\cb3 -- 	course_code VARCHAR(10),\cb1 \
\cb3 -- 	course_name VARCHAR(100)\cb1 \
\cb3 -- );\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- INSERT INTO courses VALUES (DEFAULT, 'SEI', 'Software Engineering Immersive');\cb1 \
\cb3 -- INSERT INTO courses VALUES (DEFAULT, 'DSI', 'Data Science Immersive');\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT * FROM courses;\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- CREATE TABLE instructors (\cb1 \
\cb3 -- 	instructor_id SERIAL PRIMARY KEY, \cb1 \
\cb3 -- 	name VARCHAR(255) NOT NULL, \cb1 \
\cb3 -- 	email VARCHAR(200) NOT NULL, \cb1 \
\cb3 -- 	instructor_course_id INT REFERENCES courses(course_id) NOT NULL DEFAULT (0)\cb1 \
\cb3 -- );\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- INSERT INTO instructors VALUES (DEFAULT, 'Suresh', 'suresh@msi.com', 1);\cb1 \
\cb3 -- INSERT INTO instructors VALUES (DEFAULT, 'Marc', 'marc@msi.com', 2);\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT * FROM instructors;\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- INSERT INTO instructors VALUES (DEFAULT, 'Thiago', 'Thiago@msi.com');\cb1 \
\cb3 -- -- INSERT INTO courses VALUES (0, 'NO COURSE', 'NO COURSE');\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT * FROM courses;\cb1 \
\cb3 -- INSERT INTO courses VALUES (0, 'NO COURSE', 'NO COURSE');\cb1 \
\cb3 -- INSERT INTO instructors VALUES (DEFAULT, 'Thiago', 'Thiago@msi.com');\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- INSERT INTO instructors VALUES (DEFAULT, 'Leo', 'leo@msi.com');\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT * FROM instructors;\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- INSERT INTO instructors VALUES (DEFAULT, 'Marc', 'marc@msi.com', 2);\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT  name, course_name FROM courses, instructors\cb1 \
\cb3 -- WHERE instructor_id = 1 AND course_id = instructor_course_id;\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT  name, course_name FROM courses, instructors\cb1 \
\cb3 -- WHERE instructor_id = 1;\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- CREATE TABLE student_course_enrollment (\cb1 \
\cb3 -- 	enrollment_id SERIAL PRIMARY KEY,\cb1 \
\cb3 -- 	student_id INT REFERENCES students(student_id) NOT NULL,\cb1 \
\cb3 -- 	course_id INT REFERENCES courses(course_id) NOT NULL,\cb1 \
\cb3 -- 	UNIQUE (student_id, course_id)\cb1 \
\cb3 -- );\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- INSERT INTO student_course_enrollment VALUES (DEFAULT, 1, 1);\cb1 \
\cb3 -- INSERT INTO student_course_enrollment VALUES (DEFAULT, 2, 2);\cb1 \
\cb3 -- INSERT INTO student_course_enrollment VALUES (DEFAULT, 3, 1);\cb1 \
\cb3 -- INSERT INTO student_course_enrollment VALUES (DEFAULT, 4, 2);\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT * FROM student_course_enrollment;\cb1 \
\cb3 -- SELECT * FROM courses;\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- Find out the name of the students and which city and state each student lives in.\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT city, state, name\cb1 \
\cb3 -- FROM students\cb1 \
\cb3 -- INNER JOIN address\cb1 \
\cb3 -- ON student_address_id = address_id;\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT city, state, s.name\cb1 \
\cb3 -- FROM students as s\cb1 \
\cb3 -- INNER JOIN address\cb1 \
\cb3 -- ON student_address_id = address_id;\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT ad.city, ad.state, s.name as "First Name"\cb1 \
\cb3 -- FROM students as s\cb1 \
\cb3 -- INNER JOIN address as ad\cb1 \
\cb3 -- ON student_address_id = address_id;\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\
\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT city, state, name\cb1 \
\cb3 -- FROM address\cb1 \
\cb3 -- INNER JOIN students\cb1 \
\cb3 -- ON student_address_id = address_id;\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- Write a query that returns the name and email of all the instructors that are teaching SEI\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT name, email\cb1 \
\cb3 -- FROM instructors\cb1 \
\cb3 -- INNER JOIN courses\cb1 \
\cb3 -- ON course_id = instructor_course_id\cb1 \
\cb3 -- WHERE course_id = 1;\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- Find out which course Jack Sparrow is taking.\cb1 \
\cb3 -- Jack is student\cb1 \
\cb3 -- Jack is taking a course, so I need to grab the course table\cb1 \
\cb3 -- The only way I know which course is Jack is taking through the student_course_enrollment table\cb1 \
\cb3 -- I must project the course name\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb1 \
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \cb3 -- SELECT c.course_name\cb1 \
\cb3 -- FROM student_course_enrollment AS sce\cb1 \
\cb3 -- INNER JOIN courses AS c ON sce.course_id = c.course_id\cb1 \
\cb3 -- INNER JOIN students AS s ON sce.student_id = s.student_id\cb1 \
\cb3 -- WHERE s.student_id = 1\
}