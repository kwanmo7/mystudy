package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.TransactionManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

  private TransactionManager txManager;
  private MemberDao memberDao;

  @Override
  public void init() throws ServletException {
    txManager = (TransactionManager) getServletContext().getAttribute("txManager");
    memberDao = (MemberDao) getServletContext().getAttribute("memberDao");
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
    out.println("<h1>회원</h1>");
    Member user = (Member) req.getSession().getAttribute("loginUser");
    if (user == null) {
      out.println("<p>로그인하시기 바랍니다</p>");
      out.println("</body>");
      out.println("</html>");
      return;
    }

    if (user.getNo() != Integer.parseInt(req.getParameter("no"))) {
      out.println("<p>변경 권한이 없습니다.</p>");
      out.println("</body>");
      out.println("</html>");
      return;
    }

    Member member = new Member();
    member.setNo(Integer.parseInt(req.getParameter("no")));
    member.setName(req.getParameter("name"));
    member.setEmail(req.getParameter("email"));
    member.setPassword(req.getParameter("password"));

    try {
      txManager.startTransaction();
      memberDao.update(member);
      txManager.commit();
      out.println("<p>회원 정보를 변경했습니다</p>");
    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
      out.println("<p>회원 변경 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
