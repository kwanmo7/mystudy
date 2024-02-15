package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;
import bitcamp.util.TransactionManager;
import java.util.ArrayList;
import java.util.List;

// 게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성
public class BoardAddHandler extends AbstractMenuHandler {

  private TransactionManager txManager;
  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  public BoardAddHandler(TransactionManager txManager, BoardDao boardDao,
      AttachedFileDao attachedFileDao) {
    this.txManager = txManager;
    this.boardDao = boardDao;
    this.attachedFileDao = attachedFileDao;
  }

  @Override
  protected void action(Prompt prompt) {
    // MenuHandler 인터페이스에 선언된 메서드 대신
    // AbstractMenuHandler 클래스에 선언된 action() 추상 메서드를 구현
    Member member = (Member) prompt.getSession().getAttribute("loginUser");
    if (member == null) {
      prompt.println("로그인하시기 바랍니다");
      return;
    }
    Board board = new Board();
    board.setTitle(prompt.input("제목? "));
    board.setContent(prompt.input("내용? "));
    board.setWriter(member);

    List<AttachedFile> files = new ArrayList<>();
    while (true) {
      String filepath = prompt.input("파일?(종료 : 그냥 엔터)");
      if (filepath.length() == 0) {
        break;
      }
      files.add(new AttachedFile().filePath(filepath));
    }
    try {
      txManager.startTransaction();
      boardDao.add(board);
      if (files.size() > 0) {
        files.forEach(file -> file.setBoardNo(board.getNo()));
        attachedFileDao.addAll(files);
      }
      txManager.commit();
    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
      prompt.println("게시글 등록 오류!");
    }
  }
}
