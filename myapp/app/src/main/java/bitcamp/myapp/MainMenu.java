package bitcamp.myapp;

import bitcamp.myapp.vo.*;

public class MainMenu {
  static AssignmentVO stAss = new AssignmentVO();
  static BulletinVO stBul = new BulletinVO();
  static void printMainMenu() {
    // Menu 출력
    for (String menus : ConstVO.MAIN_MENU) {
      System.out.println(menus);
    }
  }

  static void execute() {
    printMainMenu();
//    AssignmentVO stAss = new AssignmentVO();
//    BulletinVO stBul = new BulletinVO();
    loop1:
    while (true) {
      String strInput = Prompt.input("메인> ");
      switch (strInput) {
        case "1":
          AssignmentMenu.execute(stAss);
          break;
        case "2":
          BoardMenu.execute(stBul);
          break;
        case "3":
          System.out.println("도움말입니다.");
          break;
        case "4":
          System.out.println("종료입니다.");
          break loop1;
        case "menu":
          printMainMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }
}

