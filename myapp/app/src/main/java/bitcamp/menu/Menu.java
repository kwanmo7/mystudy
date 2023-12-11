package bitcamp.menu;

import bitcamp.util.Prompt;

// menu를 처리하는 객체의 사용법을 정의
public interface Menu {

  // 객체를 실행할 때 호출할 메소드를 선언
  // 구현을 해서는 안된다.
  // -> 추상 메소드
  public abstract void execute(Prompt promt);

  public abstract String getTitle();
}
