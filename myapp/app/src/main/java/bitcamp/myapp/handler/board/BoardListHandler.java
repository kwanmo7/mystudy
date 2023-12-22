package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.ArrayList;

// 게시글의 '목록'메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성
public class BoardListHandler extends AbstractMenuHandler {

  private ArrayList<Board> objectRepository;

  public BoardListHandler(ArrayList<Board> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");
    // 방법1
    //Board[] boards = new Board[this.objectRepository.size()];
    //this.objectRepository.toArray(boards);
    // 방법2
    Board[] boards = this.objectRepository.toArray(new Board[0]);
    for (Board board : boards) {
      System.out.printf("%-20s\t%10s\t%3$tY-%3$tm-%3$td\n", board.getTitle(),
          board.getWriter(),
          board.getCreatedDate());
    }
  }
}
