drop table Answer;
drop table Question;
drop table Teaches;
drop table Person;
drop table Course;

CREATE TABLE Person(
  per_id MEDIUMINT NOT NULL AUTO_INCREMENT,
  first_name varchar(50),
  last_name varchar(50),
  user_name varchar(20),
  password varchar(20),
  primary key (per_id)
);

create table Course(
  course_id   MEDIUMINT NOT NULL AUTO_INCREMENT,
  course_name     varchar(50),
  title           varchar(50),
  dept_name       varchar(20),
  credit          int,
  primary key (course_id)
);

create table Teaches(
per_id MEDIUMINT,
course_id MEDIUMINT,
primary key (per_id, course_id),
foreign key (per_id) references Person(per_id) on delete cascade,
foreign key (course_id) references Course(course_id) on delete cascade
);

create table Question(
question_id MEDIUMINT NOT NULL AUTO_INCREMENT,
course_id MEDIUMINT,
chapter varchar(7),
primary key (question_id),
foreign key (course_id) references Course(course_id)
);

create table Answer
(answer_id MEDIUMINT NOT NULL AUTO_INCREMENT,
question_id MEDIUMINT,
answer_text varchar(200),
primary key (answer_id),
foreign key (question_id) references Question(question_id)
);

