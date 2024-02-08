package bitcamp.menu;

import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public abstract class AbstractMenuHandler implements MenuHandler {

  protected Menu menu;

  @Override
  public void action(Menu menu, Prompt prompt) {
    printMenuTitle(menu.getTitle(), prompt);
    this.menu = menu;
    action(prompt);
  }

  private void printMenuTitle(String title, Prompt prompt) {
    prompt.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.RESET, title);
  }

  // 서브 클래스가 구현해야 할 메서드
  // 수퍼 클래스의 action(Menu)을 실행할 때 호출되는 메서드
  // 외부에서 호출할 메서드 x
  // 접근 범위를 서브 클래스에서 접근할 수 있도록 제한한다.
  protected abstract void action(Prompt prompt);
}
