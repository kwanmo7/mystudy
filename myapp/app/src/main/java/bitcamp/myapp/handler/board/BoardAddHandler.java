package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.ArrayList;
import java.util.Date;

// 게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성
public class BoardAddHandler extends AbstractMenuHandler {

  private ArrayList<Board> objectRepository;

  public BoardAddHandler(ArrayList<Board> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    // MenuHandler 인터페이스에 선언된 메서드 대신
    // AbstractMenuHandler 클래스에 선언된 action() 추상 메서드를 구현
    Board board = new Board();
    board.setTitle(this.prompt.input("제목? "));
    board.setContent(this.prompt.input("내용? "));
    board.setWriter(this.prompt.input("작성자? "));
    board.setCreatedDate(new Date());

    // 목록에 객체를 추가시키는 코드를 BoardRepository가 감췄다.(캡슐화 했다)
    // 대신 목록에 객체를 추가시킬 수 있도록 메소드를 제공
    // 아래와 같이 BoardRepository가 제공하는 메소드를 사용하여 게시글 객체를 추가
    objectRepository.add(board);
  }
}
