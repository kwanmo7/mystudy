package bitcamp.myapp.servlet.board;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.TransactionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/update")
public class BoardupdateServlet extends HttpServlet {

  private TransactionManager txManager;
  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  @Override
  public void init() throws ServletException {
    txManager = (TransactionManager) getServletContext().getAttribute("txManager");
    boardDao = (BoardDao) getServletContext().getAttribute("boardDao");
    attachedFileDao = (AttachedFileDao) getServletContext().getAttribute("attachedFileDao");
  }

  @Override
  public void service(HttpServletRequest req, HttpServletResponse resp)
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
    Member member = (Member) req.getSession().getAttribute("loginUser");
    if (member == null) {
      out.println("<p>로그인하시기 바랍니다</p>");
      out.println("</body>");
      out.println("</html>");
      return;
    }
    try {
      int no = Integer.parseInt(req.getParameter("no"));
      Board board = boardDao.findBy(no);
      if (board == null) {
        out.println("<p>번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      } else if (board.getWriter().getNo() != member.getNo()) {
        out.println("<p>게시글 권한이 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }
      board.setCategory(category);
      board.setTitle(req.getParameter("title"));
      board.setContent(req.getParameter("content"));
      List<AttachedFile> filelist = new ArrayList<>();
      if (category == 1) {
        String[] files = req.getParameterValues("files");
        if (files != null) {
          for (String file : files) {
            if (file.length() == 0) {
              continue;
            }
            filelist.add(new AttachedFile().filePath(file));
          }
        }
      }

      txManager.startTransaction();
      boardDao.update(board);
      if (filelist.size() > 0) {
        filelist.forEach(file -> file.setBoardNo(board.getNo()));
        attachedFileDao.addAll(filelist);
      }
      txManager.commit();
      out.println("<p>변경했습니다</p>");
    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {

      }
      out.println("<p>변경 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
