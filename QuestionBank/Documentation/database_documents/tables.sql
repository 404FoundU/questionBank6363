drop table Answer;
drop table Question;
drop table Teaches;
drop table Person;
drop table Course;

CREATE TABLE Person(
  id MEDIUMINT NOT NULL AUTO_INCREMENT,
  first_name varchar(50),
  last_name varchar(50),
  user_name varchar(20),
  password varchar(20),
  primary key (id)
);

create table Course(
  id   MEDIUMINT NOT NULL AUTO_INCREMENT,
  course_name     varchar(64),
  course_number	  varchar(8),
  dept_name       varchar(8),
  credit          int,
  primary key (id)
);

create table Teaches(
per_id MEDIUMINT,
course_id MEDIUMINT,
primary key (per_id, course_id),
foreign key (per_id) references Person(id) on delete cascade,
foreign key (course_id) references Course(id) on delete cascade
);

create table Question(
id MEDIUMINT NOT NULL AUTO_INCREMENT,
course_id MEDIUMINT,
question varchar(256),
chapter varchar(7),
question_text varchar(256),
primary key (id),
foreign key (course_id) references Course(id)
);

create table Answer
(id MEDIUMINT NOT NULL AUTO_INCREMENT,
question_id MEDIUMINT,
answer_text varchar(256),
primary key (id),
foreign key (question_id) references Question(id)
);

