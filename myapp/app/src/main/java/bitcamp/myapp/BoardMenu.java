package bitcamp.myapp;

import bitcamp.myapp.vo.BulletinVO;
import bitcamp.myapp.vo.ConstVO;

public class BoardMenu {

  static void printMenu() {
    for (String menus : ConstVO.BOARD_MENU) {
      System.out.println(menus);
    }
  }

  static void execute(BulletinVO stBul) {
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

  static void view(BulletinVO stBul) {
    stBul.printBulletin();
  }

  static void modify(BulletinVO stBul) {
    Prompt.modifyBulletin(stBul);
    stBul.modifyBulletin(stBul);
  }

  static void delete(BulletinVO stBul) {
    stBul.delete();
  }
}
