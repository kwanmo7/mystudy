package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.sql.Connection;

public class MemberAddHandler extends AbstractMenuHandler {

  private DBConnectionPool connectionPool;
  private MemberDao memberDao;

  public MemberAddHandler(DBConnectionPool connectionPool, MemberDao memberDao) {
    this.connectionPool = connectionPool;
    this.memberDao = memberDao;
  }

  @Override
  protected void action(Prompt prompt) {
    Connection connection = null;
    try {
      connection = connectionPool.getConnection();
      connection.setAutoCommit(false);
      Member member = new Member();
      member.setEmail(prompt.input("이메일? "));
      member.setName(prompt.input("이름? "));
      member.setPassword(prompt.input("암호? "));

      memberDao.add(member);
    } catch (Exception e) {
      try {
        connection.rollback();
        prompt.println("등록 오류");
      } catch (Exception e2) {
      }
    } finally {
      connectionPool.returnConnection(connection);
    }
  }
}
