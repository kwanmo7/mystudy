package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.sql.Connection;
import java.util.List;

// 게시글의 '목록'메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성
public class BoardListHandler extends AbstractMenuHandler {

  private DBConnectionPool connectionPool;
  private BoardDao boardDao;

  public BoardListHandler(DBConnectionPool connectionPool, BoardDao boardDao) {
    this.connectionPool = connectionPool;
    this.boardDao = boardDao;
  }

  @Override
  protected void action(Prompt prompt) {
    Connection connection = null;
    try {
      connection = connectionPool.getConnection();
      prompt.printf("%-4s\t%-20s\t%10s\t%s\n", "No", "Title", "Writer", "Date");
      List<Board> list = boardDao.findAll();
      list.forEach(item -> prompt.printf("%-4d\t%-20s\t%10s\t%4$tY-%4$tm-%4$td\n", item.getNo(),
          item.getTitle(),
          item.getWriter(), item.getCreatedDate()));
    } catch (Exception e) {
      prompt.println("조회 오류");
    } finally {
      connectionPool.returnConnection(connection);
    }
  }
}
