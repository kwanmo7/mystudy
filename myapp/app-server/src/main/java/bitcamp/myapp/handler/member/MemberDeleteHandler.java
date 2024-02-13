package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.sql.Connection;

public class MemberDeleteHandler extends AbstractMenuHandler {

  private DBConnectionPool connectionPool;
  private MemberDao memberDao;

  public MemberDeleteHandler(DBConnectionPool connectionPool, MemberDao memberDao) {
    this.connectionPool = connectionPool;
    this.memberDao = memberDao;
  }

  @Override
  protected void action(Prompt prompt) {
    Connection connection = null;
    try {
      connection = connectionPool.getConnection();
      int no = prompt.inputInt("번호? ");
      if (memberDao.delete(no) == 0) {
        prompt.println("회원 번호가 유효하지 않습니다.");
      } else {
        prompt.println("삭제 했습니다.");
      }
    } catch (Exception e) {
      prompt.println("삭제 오류");
    } finally {
      connectionPool.returnConnection(connection);
    }
  }
}
