delete from Course;

INSERT INTO Course (course_name, course_number, title, dept_name, credit) 
VALUES ('Test 1', 'TST1000', 'Test Course 1 Title', 'Test', 3),
	   ('Test 2', 'TST2003', 'Test Course 2 Title', 'Test', 3),
	   ('Test 3', 'TST3500', 'Test Course 3 Title', 'Test', 1),
	   ('Intro', 'CSCI1000', 'Intro to Computer Science', 'Computer Science', 3),
	   ('Pattern Recognition', 'CSCI6635', 'Theory & Computer Applications for Pattern Recognition', 'Computer Science', 3),
	   ('Data Structures', 'CSCI2025', 'Data Structures and Applications', 'Computer Science', 3),
	   ('Calculus 1', 'MATH2114', null, 'Math', 3),
	   ('Calculus 2', 'MATH2124', null, 'Math', 3);