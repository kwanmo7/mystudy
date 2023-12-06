package bitcamp.myapp;

import bitcamp.myapp.vo.AssignmentVO;
import bitcamp.myapp.vo.BulletinVO;
import bitcamp.myapp.vo.ConstVO;
import bitcamp.myapp.vo.MemberVO;

public class MainMenu {

  static AssignmentVO[] stAss = new AssignmentVO[3];
  static BulletinVO[] stBul = new BulletinVO[3];
  static MemberVO[] stMem = new MemberVO[3];

  static void printMainMenu() {
    // Menu 출력
    for (String menus : ConstVO.MAIN_MENU) {
      System.out.println(menus);
    }
  }

  static void execute() {
    printMainMenu();
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
          MemberMenu.execute(stMem);
          break;
        case "4":
          System.out.println("도움말입니다.");
          break;
        case "0":
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

