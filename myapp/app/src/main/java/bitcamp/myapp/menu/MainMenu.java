package bitcamp.myapp.menu;

import bitcamp.myapp.vo.ConstVO;
import bitcamp.util.Prompt;

public class MainMenu {

  Prompt prompt;

  public MainMenu(Prompt prompt) {
    this.prompt = prompt;
  }

  static void printMenu() {
    for (String menu : ConstVO.MAIN_MENU) {
      System.out.println(menu);
    }
  }

  public void execute() {
    AssignmentMenu assignmentMenu = new AssignmentMenu("과제", this.prompt);
    BoardMenu boardMenu = new BoardMenu("게시판", this.prompt);
    BoardMenu greetingMenu = new BoardMenu("가입인사", this.prompt);
    MemberMenu memberMenu = new MemberMenu("회원", this.prompt);

    printMenu();

    while (true) {
      String input = this.prompt.input("메인> ");

      switch (input) {
        case "1":
          assignmentMenu.execute();
          break;
        case "2":
          boardMenu.execute();
          break;
        case "3":
          memberMenu.execute();
          break;
        case "4":
          greetingMenu.execute();
          break;
        case "5":
          System.out.println("도움말입니다.");
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
