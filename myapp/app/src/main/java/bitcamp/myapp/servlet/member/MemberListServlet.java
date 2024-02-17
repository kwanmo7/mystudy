package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {

  private MemberDao memberDao;

  public MemberListServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://db-ld2a3-kr.vpc-pub-cdb.ntruss.com/studydb", "study",
        "Bitcamp123!@#");
    this.memberDao = new MemberDaoImpl(connectionPool);
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>비트캠프 DevOps 5</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원</h1>");
    out.println("<a href='/member/form.html'>회원 가입</a>");
    try {
      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr> <th>번호</th> <th>이름</th> <th>이메일</th> <th>가입일</th></tr>");
      out.println("</thead>");
      out.println("<tbody>");
      List<Member> list = memberDao.findAll();
      list.forEach(
          item -> out.printf(
              "<tr> <td>%d</td> <td><a href='/member/view?no=%1$d'>%s</td> <td>%s</td> <td>%s</td></tr>",
              item.getNo(), item.getName(), item.getEmail(),
              item.getCreatedDate()));
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
