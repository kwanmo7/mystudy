package bitcamp.myapp.menu;

import bitcamp.menu.Menu;
import bitcamp.myapp.vo.ConstVO;
import bitcamp.util.Prompt;

public class MainMenu implements Menu {

  Prompt prompt;

  public MainMenu(Prompt prompt) {
    this.prompt = prompt;
  }

  static void printMenu() {
    for (String menu : ConstVO.MAIN_MENU) {
      System.out.println(menu);
    }
  }

  @Override
  public String getTitle() {
    return null;
  }

  public void execute(Prompt prompt) {
    Menu assignmentMenu = new AssignmentMenu("과제", this.prompt);
    Menu boardMenu = new BoardMenu("게시판", this.prompt);
    Menu greetingMenu = new BoardMenu("가입인사", this.prompt);
    Menu memberMenu = new MemberMenu("회원", this.prompt);
    Menu helpMenu = new HelpMenu("도움말", this.prompt);

    printMenu();

    while (true) {
      String input = this.prompt.input("메인> ");

      switch (input) {
        case "1":
          assignmentMenu.execute(prompt);
          break;
        case "2":
          boardMenu.execute(prompt);
          break;
        case "3":
          memberMenu.execute(prompt);
          break;
        case "4":
          greetingMenu.execute(prompt);
          break;
        case "5":
          helpMenu.execute(prompt);
          break;
        case "0":
          System.out.println("종료합니다.");
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }
}
