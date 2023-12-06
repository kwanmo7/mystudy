package bitcamp.myapp;

import bitcamp.myapp.vo.BulletinVO;
import bitcamp.myapp.vo.ConstVO;

public class BoardMenu {

  static void printMenu() {
    for (String menus : ConstVO.BOARD_MENU) {
      System.out.println(menus);
    }
  }

  static void execute(BulletinVO[] stBul) {
    printMenu();
    loopBoard:
    while (true) {
      String strInput = Prompt.input("메인/게시글> ");
      switch (strInput) {
        case "1":
          add(stBul);
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
        case "5":
          list(stBul);
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

  static void add(BulletinVO[] stBul) {
    if (ConstVO.iBoardIndex == stBul.length) {
      int iOldIndex = ConstVO.iBoardIndex;
      int iNewIndex = iOldIndex + (iOldIndex / 2);
      BulletinVO[] stNewBul = new BulletinVO[iNewIndex];
      for (int i = 0; i < iOldIndex; i++) {
        stNewBul[i] = stBul[i];
      }
      stBul = stNewBul;
    }
    Prompt.addBulletin(stBul);
  }

  static void view(BulletinVO[] stBul) {
    System.out.println("게시글 조회");
    int index = Integer.parseInt(Prompt.input("번호? :"));
    if (0 < index || index >= ConstVO.iBoardIndex) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }
    stBul[index].printBulletin();
  }

  static void list(BulletinVO[] stBul) {
    System.out.println("게시글 목록");
    System.out.printf("%-20s\t%-20s\t%s\n", "제목", "작성자", "작성일");
    for (int i = 0; i != ConstVO.iBoardIndex; i++) {
      stBul[i].printBulletinList();
    }
  }

  static void modify(BulletinVO[] stBul) {
    Prompt.modifyBulletin(stBul);
  }

  static void delete(BulletinVO[] stBul) {
    System.out.println("게시글 삭제: ");
    if (!BulletinVO.checkForBoard()) {
      System.out.println("등록된 게시글이 없습니다.");
      return;
    }
    int index = Integer.parseInt(Prompt.input("번호? "));
    if (0 > index || index >= ConstVO.iBoardIndex) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }
    for (int i = 0; i < (stBul.length - 1); i++) {
      stBul[i] = stBul[i + 1];
    }

    stBul[--ConstVO.iBoardIndex] = null;
  }
}
