--DDl(Data Definition Language)

create table boards(
  board_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  writer varchar(30) not null,
  created_date datetime null default now()
);

insert into boards(board_no,title,content,writer)
  values(1,'제목1','내용1','홍길동');
insert into boards(board_no,title,content,writer)
  values(2,'제목2','내용2','임꺽정');
insert into boards(board_no,title,content,writer)
  values(3,'제목3','내용3','유관순');
insert into boards(board_no,title,content,writer)
  values(4,'제목4','내용4','안중근');
insert into boards(board_no,title,content,writer)
  values(5,'제목5','내용5','윤봉길');

update boards set
  title = 'okok',
  content='nono',
  writer='hoho'
where board_no = 3;

delete from boards where board_no = 3;

create table assignment(
  assignment_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  deadline date null
);

drop table assignment;

insert into assignment(title,content,deadline)
  values('과제1','내용1','2023-11-2');
insert into assignment(title,content,deadline)
  values('과제2','내용2','2023-11-3');
insert into assignment(title,content,deadline)
  values('과제3','내용3','2023-11-4');
insert into assignment(title,content,deadline)
  values('과제4','내용4','2023-11-5');
insert into assignment(title,content,deadline)
  values('과제5','내용5','2023-11-6');

create table members(
  member_no int primary key auto_increment,
  email varchar(255) not null,
  name varchar(255) not null,
  password varchar(100) not null,
  created_date datetime null default now()
);

drop table member;

insert into members(email,name,password)
  values('이메일1','이름1','비밀번호1');
insert into members(email,name,password)
  values('이메일2','이름2','비밀번호2');
insert into members(email,name,password)
  values('이메일3','이름3','비밀번호3');
insert into members(email,name,password)
  values('이메일4','이름4','비밀번호4');
insert into members(email,name,password)
  values('이메일5','이름5','비밀번호5');

alter table boards
  add column category int not null;

update boards set category=1;