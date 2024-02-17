package bitcamp.myapp.servlet.assignment;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.dao.mysql.AttachedFileDaoImpl;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
import bitcamp.myapp.vo.Assignment;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.TransactionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/assignment/update")
public class AssignmentUpdateServlet extends HttpServlet {

  private TransactionManager txManager;
  private AssignmentDao assignmentDao;

  public AssignmentUpdateServlet() {
    DBConnectionPool dbConnectionPool = new DBConnectionPool(
        "jdbc:mysql://db-ld2a3-kr.vpc-pub-cdb.ntruss.com/studydb", "study",
        "Bitcamp123!@#");
    txManager = new TransactionManager(dbConnectionPool);
    assignmentDao = new AssignmentDaoImpl(dbConnectionPool);
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
    out.println("<h1>과제</h1>");
    Member member = (Member) req.getSession().getAttribute("loginUser");
    if (member == null) {
      out.println("<p>로그인하시기 바랍니다</p>");
      out.println("</body>");
      out.println("</html>");
      return;
    }

    Assignment assignment = new Assignment();
    assignment.setNo(Integer.parseInt(req.getParameter("no")));
    assignment.setTitle(req.getParameter("title"));
    assignment.setContent(req.getParameter("content"));
    assignment.setDeadline(Date.valueOf(req.getParameter("date")));
   
    try {
      txManager.startTransaction();
      assignmentDao.update(assignment);
      txManager.commit();
      out.println("<p>과제를 변경했습니다</p>");
    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
      out.println("<p>과제 변경 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
