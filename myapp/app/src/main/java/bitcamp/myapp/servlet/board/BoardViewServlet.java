package bitcamp.myapp.servlet.board;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/view")
public class BoardViewServlet extends HttpServlet {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  @Override
  public void init() throws ServletException {
    boardDao = (BoardDao) getServletContext().getAttribute("boardDao");
    attachedFileDao = (AttachedFileDao) getServletContext().getAttribute("attachedFileDao");
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int category = Integer.parseInt(req.getParameter("category"));
    String title = category == 1 ? "게시글" : "가입인사";
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>비트캠프 DevOps 5</title>");
    out.println("</head>");
    out.println("<body>");
    out.printf("<h1>%s</h1>\n", title);
    try {
      int no = Integer.parseInt(req.getParameter("no"));
      Board board = boardDao.findBy(no);
      if (board == null) {
        out.println("<p>게시글 번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }
      List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);

      out.println("<form action='/board/update'>");
      out.printf("<input name='category' type='text' value='%d'\n", category);
      out.println("<div>");
      out.printf("번호<input readonly name='no' type='text' value='%d'>\n", board.getNo());
      out.println("</div>");
      out.println("<div>");
      out.printf("제목<input name='title' type='text' value='%s'>\n", board.getTitle());
      out.println("</div>");
      out.println("<div>");
      out.printf("내용<textarea name='content'>%s</textarea>\n", board.getContent());
      out.println("</div>");
      out.println("<div>");
      out.printf("작성자<input readonly type='text' value='%s'>\n", board.getWriter().getName());
      out.println("</div>");
      if (category == 1) {
        out.println("<div>");
        out.println("첨부파일<input multiple name='files' type='file'>");
        out.println("<ul>");
        files.forEach(
            file -> out.printf("<li>%s <a href='/board/file/delete?category=%d&no=%d'>삭제</li>\n",
                file.getFilePath(), category, file.getNo()));
        out.println("</ul>");
        out.println("</div>");
      }
      out.println("<div>");
      out.println("<button>변경</button>");
      out.printf("<a href='/board/delete?category=%d&no=%d'>[삭제]</a>\n", category, no);
      out.println("</div>");
      out.println("</form>");

    } catch (Exception e) {
      out.println("<p>조회 오류</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
