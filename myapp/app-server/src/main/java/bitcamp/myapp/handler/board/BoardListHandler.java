package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.List;

// 게시글의 '목록'메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성
public class BoardListHandler extends AbstractMenuHandler {

  private BoardDao boardDao;

  public BoardListHandler(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  protected void action(Prompt prompt) {
    prompt.printf("%-4s\t%-20s\t%10s\t%s\n", "No", "Title", "Writer", "Date");
    List<Board> list = boardDao.findAll();
    list.forEach(item -> prompt.printf("%-4d\t%-20s\t%10s\t%4$tY-%4$tm-%4$td\n", item.getNo(),
        item.getTitle(),
        item.getWriter(), item.getCreatedDate()));
//    for (Board board : list) {
//      System.out.printf("%-20s\t%10s\t%3$tY-%3$tm-%3$td\n", board.getTitle(),
//          board.getWriter(),
//          board.getCreatedDate());
//    }
  }
}
