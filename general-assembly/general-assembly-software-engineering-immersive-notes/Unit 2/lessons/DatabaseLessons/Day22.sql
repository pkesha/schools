-- CREATE TABLE students (
-- 	student_id SERIAL PRIMARY KEY,
-- 	name TEXT NOT NULL,
-- 	age INT NOT NULL,
-- 	mobile VARCHAR(50)
-- );

-- The table was already created ----------------------------------------------

-- INSERT INTO students VALUES (DEFAULT, 'Jack Sparrow', 28, '999-999-9999');

-- INSERT INTO students VALUES (DEFAULT, 'Jilly Cakes', 30, '910-111-1111');
-- INSERT INTO students VALUES (DEFAULT, 'Johnny Bananas', 25, '678-111-1234');
-- INSERT INTO students VALUES (DEFAULT, 'Jackie Lackie', 101, '910-456-7890');
-- INSERT INTO students VALUES (DEFAULT, 'Slaggy McRaggy', 28, NULL);

-- SELECT and display students -----------------------------------------------
-- SELECT * FROM students
-- SELECT name FROM students
-- SELECT name, mobile FROM students

-- SELECT using WHERE --------------------------------------------------------
-- SELECT name FROM students WHERE age < 38;

-- Ordering results ----------------------------------------------------------
-- SELECT name, age FROM students ORDER BY age DESC;

-- Selects any mobile with 910 for the first 3 letters -----------------------
-- SELECT name, age FROM students WHERE mobile LIKE '%910%';

-- Remove entry
-- First create mistake
--INSERT INTO students VALUES (DEFAULT, 'Miss Take', 500, 'adsfklajkl;dfasjkl;kfjdls');

--How to fix mistake -------------------------------------------------------------
-- update => table name
-- SET => new Value that we would like to set
-- WHERE => under what condition

-- UPDATE students 
-- SET mobile = '000-000-0000'
-- WHERE name = 'Miss Take';

-- Delete MISTAKE --------------------------------------------------------------
-- DELETE FROM students WHERE name = 'Miss Take';

-- SELECT COUNT(*) FROM students
-- WHERE mobile IS NULL;

-- Practice ---------------------------------------------------------------------
INSERT INTO students VALUES (DEFAULT, 'Nancy Gong', 40, '789-786-6383');
INSERT INTO students VALUES (DEFAULT, 'Laura Rossi', 70, NULL);
INSERT INTO students VALUES (DEFAULT, 'David Daniele', 28, '876-345-6785');
INSERT INTO students VALUES (DEFAULT, 'Greg Fitzgerald', 25, NULL);
INSERT INTO students VALUES (DEFAULT, 'Randi Fitz', 28, '123-090-7648');

UPDATE students
SET mobile = '123-090-7646'
WHERE name = 'Randi Fitz'

SELECT * from students
WHERE age > 30
ORDER BY name ASC

SELECT name, age FROM students WHERE name LIKE '%J%'
SELECT * FROM students 
WHERE mobile IS NULL




