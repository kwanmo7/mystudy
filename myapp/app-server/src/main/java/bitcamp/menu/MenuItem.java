package bitcamp.menu;

import bitcamp.util.Prompt;

// Composite 패턴에서 leaf 역할을 수행하는 클래스
// leaf - 하위 항목을 포함하지 않는 말단 객체
// ex) 파일 시스템에서 '파일'에 해당
public class MenuItem extends AbstractMenu {

  private MenuHandler menuHandler;

  public MenuItem(String title) {
    super(title);
  }

  public MenuItem(String title, MenuHandler menuHandler) {
    this(title);
    this.menuHandler = menuHandler;
  }

  public void execute(Prompt prompt) {
    if (this.menuHandler != null) {
      try {
        this.menuHandler.action(this, prompt);
      } catch (Exception e) {
        prompt.println("실행 오류");
      }
    }
  }
}