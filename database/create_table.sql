use test;

create table user (
	id bigint primary key auto_increment,
    username varchar(10) unique not null,
    password varchar(30) not null,
    name varchar(50) not null,
    dob date not null,
    email varchar(50) not null,
    role varchar(30) not null
);

create table subject (
	id bigint primary key auto_increment,
    subject_id varchar(10) unique not null,
    subject_title varchar(50) unique not null
);

create table question (
	id bigint primary key auto_increment,
    subject bigint not null,
    topic text not null,
    content text not null,
    answer_a text,
    answer_b text,
    answer_c text,
    answer_d text,
    true_answer varchar(1) not null,
    creator bigint not null,
    createdDate timestamp not null,
    lastModified timestamp not null,
    status int not null,
    constraint fk_question_teacher foreign key (creator) references user(id),
    constraint fk_question_subject foreign key (subject) references subject(id)
);

create table exam (
	id bigint primary key auto_increment,
    subject bigint not null,
    time bigint not null,
    semester varchar(10) not null,
    creator bigint not null,
    createdDate timestamp not null,
    lastModified timestamp not null,
    status INT NOT NULL,
    constraint fk_exam_teacher foreign key (creator) references user(id),
    constraint fk_exam_subject foreign key (subject) references subject(id)
);

create table exam_question (
	exam_id bigint not null,
    question_id bigint not null,
    constraint pk_exam_question primary key (exam_id, question_id),
    constraint fk_examid foreign key (exam_id) references exam(id),
    constraint fk_questionid foreign key (question_id) references question(id)
);

create table teacher_subject (
	teacherId bigint not null,
    subjectId bigint not null,
    constraint pk_teacher_subject primary key (teacherId, subjectId),
    constraint fk_teacherId foreign key (teacherId) references user(id),
    constraint fk_subjectId foreign key (subjectId) references subject(id)
);
