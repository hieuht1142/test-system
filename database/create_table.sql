use test;

create table student (
	id bigint primary key auto_increment,
    username varchar(10) unique not null,
    password varchar(30) not null,
    name nvarchar(50) not null,
    dob date not null,
    email varchar(50) not null
);

create table teacher (
	id bigint primary key auto_increment,
    username varchar(10) unique not null,
    password varchar(30) not null,
    name nvarchar(50) not null,
    dob date not null,
    email varchar(50) not null
);

create table question (
	id bigint primary key auto_increment,
    subject_id varchar(10) not null,
    subject_title varchar(50) not null,
    topic text not null,
    content text not null,
    creator bigint not null,
    createdDate timestamp not null,
    lastModified timestamp not null,
    constraint fk_question_teacher foreign key (creator) references teacher(id)
);

create table exam (
	id bigint primary key auto_increment,
    subject_id varchar(10) not null,
    subject_title varchar(50) not null,
    time bigint not null,
    semester varchar(10) not null,
    creator bigint not null,
    createdDate timestamp not null,
    lastModified timestamp not null,
    constraint fk_exam_teacher foreign key (creator) references teacher(id)
);

create table answer (
	id bigint primary key auto_increment,
    question_id bigint not null,
    content text not null,
    result int not null,
    constraint fk_answer_question foreign key (question_id) references question(id)
);

create table exam_question (
	exam_id bigint not null,
    question_id bigint not null,
    constraint pk_exam_question primary key (exam_id, question_id),
    constraint fk_examid foreign key (exam_id) references exam(id),
    constraint fk_questionid foreign key (question_id) references question(id)
);
