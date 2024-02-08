package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.util.Prompt;

// 게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성
public class BoardDeleteHandler extends AbstractMenuHandler {

  private BoardDao boardDao;

  public BoardDeleteHandler(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  protected void action(Prompt prompt) {
    int no = prompt.inputInt("번호? ");
    if (boardDao.delete(no) == 0) {
      prompt.println("게시글 번호가 유효하지 않습니다.");
    } else {
      prompt.println("삭제했습니다!");
    }
  }
}