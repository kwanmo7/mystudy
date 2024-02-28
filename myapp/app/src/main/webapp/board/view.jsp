<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    import="bitcamp.myapp.vo.Board"
    import="bitcamp.myapp.vo.AttachedFile"
    import="java.util.List"
%>

<!DOCTYPE html>
   <html lang='en'>
   <head>
     <meta charset='UTF-8'>
     <title>비트캠프 데브옵스 5기</title>
   </head>
   <body>
    <jsp:include page="/header.jsp"></jsp:include>
<%
    String title = (String) request.getAttribute("title");
    int category = (int) request.getAttribute("category");
    Board board = (Board) request.getAttribute("board");
    List<AttachedFile> files = (List<AttachedFile>) request.getAttribute("files");
%>
      <h1><%=title%></h1>
      <form action='/board/update' method='post'>
      <input name='category' type='hidden' value='<%=category%>'>
      <div>
        번호: <input readonly name='no' type='text' value='<%=board.getNo()%>'>
      </div>
      <div>
        제목: <input name='title' type='text' value='<%=board.getTitle()%>'>
      </div>
      <div>
        내용: <textarea name='content'><%=board.getContent()%></textarea>
      </div>
      <div>
        작성자: <input readonly type='text' value='<%=board.getWriter().getName()%>'>
      </div>
<%
      if (category == 1) { %>
        <div>
          첨부파일: <input multiple name='files' type='file'>
          <ul>
<%      for (AttachedFile file : files) { %>
              <li><%=file.getFilePath()%>
              <a href='/board/file/delete?category=<%=category%>&no=<%=file.getNo()%>'>삭제</a>
              </li>
<%      } %>
          </ul>
        </div>
<%    } %>
      <div>
        <button>변경</button>
        <a href='/board/delete?category=<%=category%>&no=<%=board.getNo()%>'>[삭제]</a>
      </div>
      </form>
    <jsp:include page="/footer.jsp"></jsp:include>
    </body>
    </html>
