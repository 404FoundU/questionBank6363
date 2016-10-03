delete from Teaches;
delete from Person;
delete from Answer;
delete from Question;
delete from Course;
 
drop sequence seq_per;
create sequence seq_per
start with 10001
increment by 1
maxvalue 19999 
nocycle;


INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);

drop sequence seq_course;
create sequence seq_course
start with 1001
increment by 1
maxvalue 1999
nocycle;
INSERT INTO Course (course_number, course_name, title, dept_name, credit) VALUES('T'||seq_course.nextval, 'Test 1', 'Test Course 1 Title', 'Test', 3);
INSERT INTO Course (course_number, course_name, title, dept_name, credit) VALUES('T'||seq_course.nextval, 'Test 2', 'Test Course 2 Title', 'Test', 3);
INSERT INTO Course (course_number, course_name, title, dept_name, credit) VALUES('T'||seq_course.nextval, 'Test 3', 'Test Course 3 Title', 'Test', 1);
INSERT INTO Course (course_number, course_name, title, dept_name, credit) VALUES('C'||seq_course.nextval, 'Databases', 'Database Administration', 'Computer Science', 3);
INSERT INTO Course (course_number, course_name, title, dept_name, credit) VALUES('C'||seq_course.nextval, 'AI', 'Artificial Intelligence: Pattern Recognition', 'Computer Science', 3);
INSERT INTO Course (course_number, course_name, title, dept_name, credit) VALUES('C'||seq_course.nextval, 'IA', 'Information Assurance: Network Security', 'Computer Science', 3);
INSERT INTO Course (course_number, course_name, title, dept_name, credit) VALUES('M'||seq_course.nextval, 'Geometry', 'Geometry 2', 'Math', 3);
INSERT INTO Course (course_number, course_name, title, dept_name, credit) VALUES('M'||seq_course.nextval, 'Calculus', 'Calculus 3', 'Math', 5);
INSERT INTO Course (course_number, course_name, title, dept_name, credit) VALUES('B'||seq_course.nextval, 'Accounting', 'Accounting Ethics', 'Business Administration', 3);
INSERT INTO Course (course_number, course_name, title, dept_name, credit) VALUES('E'||seq_course.nextval, 'English', 'Shakespearean Literature', 'Liberal Arts', 3);

INSERT INTO Teaches VALUES('P10001', (
  select id from (
    select row_number() over (order by id asc) as rownumber, id 
    from Course
  ) where rownumber = 1) );
INSERT INTO Teaches VALUES('P10002', (
  select id from (
    select row_number() over (order by id asc) as rownumber, id 
    from Course
  ) where rownumber = 2));
INSERT INTO Teaches VALUES('P10003', (
  select id from (
    select row_number() over (order by id asc) as rownumber, id 
    from Course
  ) where rownumber = 3));
INSERT INTO Teaches VALUES('P10004', (
  select id from (
    select row_number() over (order by id asc) as rownumber, id 
    from Course
  ) where rownumber = 4));
INSERT INTO Teaches VALUES('P10005', (
  select id from (
    select row_number() over (order by id asc) as rownumber, id 
    from Course
  ) where rownumber = 5));
INSERT INTO Teaches VALUES('P10006', (
  select id from (
    select row_number() over (order by id asc) as rownumber, id 
    from Course
  ) where rownumber = 6));


drop sequence seq_question;
create sequence seq_question
start with 1001
increment by 1
maxvalue 1999 
nocycle;


INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);


drop sequence seq_answer;
create sequence seq_answer
start with 1001
increment by 1
maxvalue 1999
nocycle;

INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);