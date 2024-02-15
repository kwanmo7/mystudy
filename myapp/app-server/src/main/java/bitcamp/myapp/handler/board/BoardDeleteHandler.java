package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

// 게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성
public class BoardDeleteHandler extends AbstractMenuHandler {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  public BoardDeleteHandler(BoardDao boardDao, AttachedFileDao attachedFileDao) {
    this.boardDao = boardDao;
    this.attachedFileDao = attachedFileDao;
  }

  @Override
  protected void action(Prompt prompt) {
    Member member = (Member) prompt.getSession().getAttribute("loginUser");
    if (member == null) {
      prompt.println("로그인하시기 바랍니다");
      return;
    }
    try {
      int no = prompt.inputInt("번호? ");
      Board board = boardDao.findBy(no);
      if (board == null) {
        prompt.println("게시글 번호가 유효하지 않습니다.");
        return;
      } else if (board.getWriter().getNo() != member.getNo()) {
        prompt.println("게시글 삭제 권한이 없습니다.");
        return;
      }
      attachedFileDao.deleteAll(no);
      boardDao.delete(no);

      prompt.println("삭제했습니다!");

    } catch (Exception e) {
      prompt.println("삭제 오류");
    }
  }
}
