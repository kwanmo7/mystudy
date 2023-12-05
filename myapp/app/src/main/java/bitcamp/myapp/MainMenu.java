package bitcamp.myapp;

import bitcamp.myapp.vo.AssignmentVO;
import bitcamp.myapp.vo.Bulletin;

public class MainMenu {

  // class field(변수) or static field
  // 콘솔 출력 텍스트 색상 기본으로 변경
  public static final String RESET = "\u001B[0m";
  // 콘솔 출력 텍스트 빨간색으로 변경
  public static final String FONT_RED = "\033[0;31m";
  // 폰트 볼드&RED
  // \u001B = \033 같은 값
  // final - 값의 변경 불가 , 한번 선언한 값만 사용
  public static final String FONT_BOLD_RED = "\033[1;31m";
  // 고정 값을 갖는 변수의 경우 메소드 밖에 class쪽에 생성해두는 것이 좋음
  // Menu Array
  public static final String[] MAIN_MENU = {
      FONT_BOLD_RED + "[과제관리 시스템]" + RESET,
      "1. 과제",
      "2. 게시글",
      "3. 도움말",
      FONT_RED + "4. 종료" + RESET};

  static void printMainMenu() {
    // Menu 출력
    for (String menus : MAIN_MENU) {
      System.out.println(menus);
    }
  }

  static void execute() {
    printMainMenu();
    AssignmentVO stAss = new AssignmentVO();
    Bulletin stBul = new Bulletin();
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

