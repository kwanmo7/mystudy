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
    System.out.println("게시글 조회:");
    System.out.printf("제목: %s\n", stBul.title);
    System.out.printf("내용: %s\n", stBul.content);
    System.out.printf("작성자: %s\n", stBul.writer);
    System.out.printf("작성일: %s\n", stBul.date);
  }

  static void modify(BulletinVO stBul) {
    Prompt.modifyBulletin(stBul);
    stBul.modifyBulletin(stBul);
  }

  static void delete(BulletinVO stBul) {
    System.out.println("게시글 삭제:");
    stBul.delete();
  }
}
