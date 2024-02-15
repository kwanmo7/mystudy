-- boards 테이블 데이터
insert into boards(board_no,title,content,writer,category)
  values(1,'제목1','내용1',101,1);
insert into boards(board_no,title,content,writer,category)
  values(2,'제목2','내용2',102,1);
insert into boards(board_no,title,content,writer,category)
  values(3,'제목3','내용3',102,2);
insert into boards(board_no,title,content,writer,category)
  values(4,'제목4','내용4',104,2);
insert into boards(board_no,title,content,writer,category)
  values(5,'제목5','내용5',104,2);

-- board_files 테이블 데이터
insert into board_files(file_no,file_path,board_no)
  values (1,'a1.gif',1 ),(2,'a2.git',1),(3,'a3.git',1),
  (4,'b1.gif',2 ),(5,'b2.git',2),
  (6,'c1.git',4),(7,'c2.gif',4),(8,'c3.git',4),(9,'c4.git',4),
  (10,'d1.gif',5);

-- assignment 테이블 데이터
insert into assignments(title,content,deadline)
  values('과제1','내용1','2023-11-2');
insert into assignments(title,content,deadline)
  values('과제2','내용2','2023-11-3');
insert into assignments(title,content,deadline)
  values('과제3','내용3','2023-11-4');
insert into assignments(title,content,deadline)
  values('과제4','내용4','2023-11-5');
insert into assignments(title,content,deadline)
  values('과제5','내용5','2023-11-6');

-- members 테이블 데이터
insert into members(member_no,email,name,password,created_date)
  values(101,'이메일1','이름1',sha2('1111',256),'2024-01-01');
insert into members(member_no,email,name,password,created_date)
  values(102,'이메일2','이름2',sha2('1111',256),'2024-02-01');
insert into members(member_no,email,name,password,created_date)
  values(103,'이메일3','이름3',sha2('1111',256),'2024-03-01');
insert into members(member_no,email,name,password,created_date)
  values(104,'이메일4','이름4',sha2('1111',256),'2024-04-01');
insert into members(member_no,email,name,password,created_date)
  values(105,'이메일5','이름5',sha2('1111',256),'2024-05-01');
