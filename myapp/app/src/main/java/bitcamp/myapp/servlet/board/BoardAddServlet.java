package bitcamp.myapp.servlet.board;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.mysql.AttachedFileDaoImpl;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
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

@WebServlet("/board/add")
public class BoardAddServlet extends HttpServlet {

  private TransactionManager txManager;
  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  public BoardAddServlet() {
    DBConnectionPool dbConnectionPool = new DBConnectionPool(
        "jdbc:mysql://db-ld2a3-kr.vpc-pub-cdb.ntruss.com/studydb", "study",
        "Bitcamp123!@#");
    txManager = new TransactionManager(dbConnectionPool);
    this.boardDao = new BoardDaoImpl(dbConnectionPool, 1);
    this.attachedFileDao = new AttachedFileDaoImpl(dbConnectionPool);
  }

  @Override
  public void service(HttpServletRequest req, HttpServletResponse resp)
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
      Board board = boardDao.findBy(no);
      if (board == null) {
        out.println("<p>게시글 번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }
      board.setTitle(req.getParameter("title"));
      board.setContent(req.getParameter("content"));
      List<AttachedFile> filelist = new ArrayList<>();
      String[] files = req.getParameterValues("files");
      if (files != null) {
        for (String file : files) {
          if (file.length() == 0) {
            continue;
          }
          filelist.add(new AttachedFile().filePath(file));
        }
      }

      txManager.startTransaction();
      boardDao.update(board);
      if (filelist.size() > 0) {
        filelist.forEach(file -> file.setBoardNo(board.getNo()));
        attachedFileDao.addAll(filelist);
      }
      txManager.commit();
      out.println("<p>게시글을 변경했습니다</p>");
    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {

      }
      out.println("<p>게시글 변경 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
