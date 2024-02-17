package bitcamp.myapp.servlet.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/assignment/list")
public class AssignmentListServlet extends HttpServlet {

  private AssignmentDao assignmentDao;

  public AssignmentListServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://db-ld2a3-kr.vpc-pub-cdb.ntruss.com/studydb", "study",
        "Bitcamp123!@#");
    this.assignmentDao = new AssignmentDaoImpl(connectionPool);
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
    out.println("<h1>과제</h1>");
    out.println("<a href='/assignment/form.html'>새 과제</a>");
    try {
      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr><th>No</th><th>과제</th><th>제출마감일</th></tr>");
      out.println("</thead>");
      List<Assignment> list = assignmentDao.findAll();
      list.forEach(item -> out.printf("<tr><td><a href='/assignment/view?no=%d'>%1$d</a></td> <td>%s</td> <td>%s</td></tr>\n",
          item.getNo(), item.getTitle(),
          item.getDeadline()));
      out.println("</tbody>");
      out.println("</table>");
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
