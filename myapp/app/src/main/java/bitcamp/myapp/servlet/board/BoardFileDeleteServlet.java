package bitcamp.myapp.servlet.board;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.mysql.AttachedFileDaoImpl;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/file/delete")
public class BoardFileDeleteServlet extends HttpServlet {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  public BoardFileDeleteServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://db-ld2a3-kr.vpc-pub-cdb.ntruss.com/studydb", "study",
        "Bitcamp123!@#");
    this.boardDao = new BoardDaoImpl(connectionPool, 1);
    this.attachedFileDao = new AttachedFileDaoImpl(connectionPool);
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>비트캠프 DevOps 5</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글</h1>");
    Member member = (Member) req.getSession().getAttribute("loginUser");
    if (member == null) {
      out.println("<p>로그인하시기 바랍니다</p>");
      out.println("</body>");
      out.println("</html>");
      return;
    }
    try {
      int no = Integer.parseInt(req.getParameter("no"));

      AttachedFile file = attachedFileDao.findByNo(no);
      if (file == null) {
        out.println("<p>첨부파일 번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }
      Member writer = boardDao.findBy(file.getBoardNo()).getWriter();

      if (writer.getNo() != member.getNo()) {
        out.println("<p>게시글 권한이 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      attachedFileDao.delete(no);
      out.println("<p>첨부파일을 삭제했습니다</p>");
      out.println("<script>");
      out.println("location.href= document.referrer;");
      out.println("</script>");

    } catch (Exception e) {
      out.println("삭제 오류");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
