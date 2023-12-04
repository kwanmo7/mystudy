package bitcamp.myapp;

import java.util.Scanner;

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

  static void execute(Scanner keyin) {
    printMenu();
    loopBoard:
    while (true) {
      String strInput = Prompt.promptBoard(keyin);
      switch (strInput) {
        case "1":
          System.out.println("게시글 등록입니다.");
          break;
        case "2":
          System.out.println("게시글 조회입니다.");
          break;
        case "3":
          System.out.println("게시글 변경입니다.");
          break;
        case "4":
          System.out.println("게시글 삭제입니다.");
          break;
        case "0":
          break loopBoard;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }
}
