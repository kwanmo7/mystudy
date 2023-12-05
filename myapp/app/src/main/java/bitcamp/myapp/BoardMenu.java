package bitcamp.myapp;

import bitcamp.myapp.vo.Bulletin;

public class BoardMenu {

  public static final String[] BOARD_MENU = {
      "[" + MainMenu.FONT_RED + "게시글" + MainMenu.RESET + "]",
      "1. 등록",
      "2. 조회",
      "3. 변경",
      "4. 삭제",
      "0. 이전"
  };

  static void printMenu() {
    for (String menus : BOARD_MENU) {
      System.out.println(menus);
    }
  }

  static void execute(Bulletin stBul) {
    printMenu();
    loopBoard:
    while (true) {
      String strInput = Prompt.input("메인/게시글> ");
      switch (strInput) {
        case "1":
          Prompt.addBulletin(stBul);
          break;
        case "2":
          view(stBul);
          break;
        case "3":
          modify(stBul);
          break;
        case "4":
          delete(stBul);
          break;
        case "0":
          break loopBoard;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }

  static void view(Bulletin stBul) {
    System.out.println("게시글 조회:");
    System.out.printf("제목: %s\n", stBul.title);
    System.out.printf("내용: %s\n", stBul.content);
    System.out.printf("작성자: %s\n", stBul.writer);
    System.out.printf("작성일: %s\n", stBul.date);
  }

  static void modify(Bulletin stBul) {
    Prompt.modifyBulletin(stBul);
    stBul.modifyBulletin(stBul);
  }

  static void delete(Bulletin stBul) {
    System.out.println("게시글 삭제:");
    stBul.title = "";
    stBul.content = "";
    stBul.writer = "";
    stBul.date = "";
    stBul.modifyBulletin(stBul);
  }
}
