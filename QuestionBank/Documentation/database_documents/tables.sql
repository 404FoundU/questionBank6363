drop table Answer;
drop table Question;
drop table Teaches;
drop table Person;
drop table Course;

CREATE TABLE Person(
  per_id varchar(7),
  first_name varchar(50),
  last_name varchar(50),
  user_name varchar(7),
  password varchar(20),
  primary key (per_id)
);

create table Course(
  id              MEDIUMINT NOT NULL AUTO_INCREMENT,
  course_number   varchar(10),
  course_name     varchar(20),
  title           varchar(50),
  dept_name       varchar(30),
  credit          int,
  primary key (id)
);

create table Teaches
(per_id varchar(7),
course_id MEDIUMINT,
primary key (per_id, course_id),
foreign key (per_id) references Person(per_id) on delete cascade,
foreign key (course_id) references Course(id) on delete cascade
);

create table Question
(question_id varchar(7),
course_id MEDIUMINT,
chapter varchar(7),
primary key (question_id),
foreign key (course_id) references Course(id)
);

create table Answer
(answer_id varchar(7),
question_id varchar(7),
answer_text varchar(200),
primary key (answer_id),
foreign key (question_id) references Question(question_id)
);

