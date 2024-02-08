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

create table member(
  member_no int primary key auto_increment,
  name varchar(20) not null,
  tel varchar(20) not null,
  email varchar(30) not null,
  entryDate date null default (CURRENT_DATE),
  waterCd varchar(10) null,
  electricCd varchar(10) null
);

create table waterPayMent(
  no int primary key auto_increment,
  srvCd varchar(10),
  fee int not null,
  constraint waterPayMent_uk unique key(srvCd)
);

create table electricPayMent(
  no int primary key auto_increment,
  srvCd varchar(10),
  fee int not null,
  constraint electricPayMent_uk unique key(srvCd)
);

create table usage(
  no int primary key auto_increment,
  waterUsage int,
  electricUsage int,
  usageYM varchar(6)
);
  

create table usage_t(
  no int primary key auto_increment,
  waterUsage int,
  electricUsage int,
  usageYM varchar(6)
);

create table taxStub(
  no int primary key auto_increment,
  mem_no int,
  taxStubYM varchar(6),
  srvCdForWater varchar(10),
  srvCdForElectric varchar(10),
  usageWater int,
  usageElectric int,
  waterCost int,
  electricCost int,
  totalCost int
);

alter table taxStub
    add constraint taxStub_mem_no_fk foreign key (mem_no) references member(member_no);

alter table taxStub
    add constraint taxStub_waterCd_fk foreign key (srvCdForWater) references waterPayMent(srvCd);

alter table taxStub
    add constraint taxStub_electricCd_fk foreign key (srvCdForElectric) references electricPayMent(srvCd);

alter table taxStub
    add constraint taxStub_fk foreign key (taxStubYM) references usage_t(usageYM);



select t1.no wNo, t1.srvCd wCd, t1.fee wFee,t2.no eNo, t2.srvCd eCd, t2.fee eFee from waterPayMent t1 , electricPayMent t2;


insert into taxStub(mem_no,taxStubYM,srvCdForWater,srvCdForElectric,usageWater,usageElectric,waterCost,electricCost,totalCost) values( 1,'202401','test2','test3',100,100,200,200,300 );