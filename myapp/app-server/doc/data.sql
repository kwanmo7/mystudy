-- boards 테이블 데이터
insert into boards(board_no,title,content,writer,category)
  values(1,'제목1','내용1','홍길동',1);
insert into boards(board_no,title,content,writer,category)
  values(2,'제목2','내용2','임꺽정',1);
insert into boards(board_no,title,content,writer,category)
  values(3,'제목3','내용3','유관순',2);
insert into boards(board_no,title,content,writer,category)
  values(4,'제목4','내용4','안중근',2);
insert into boards(board_no,title,content,writer,category)
  values(5,'제목5','내용5','윤봉길',2);

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
