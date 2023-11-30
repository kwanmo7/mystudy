package bitcamp.myapp;

import java.util.Scanner;

public class App {

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
  public static final String[] MENU = {
      FONT_BOLD_RED + "[과제관리 시스템]" + RESET,
      "1. 과제",
      "2. 게시글",
      "3. 도움말",
      FONT_RED + "4. 종료" + RESET};

  public static void main(String[] args) {
    Scanner keyin = new Scanner(System.in);
    //test();
    // Menu 출력
    printMenu();
    // while / if
    useWhileIf(keyin);

    // while / switch
    useWhileSwitch(keyin);

    // 콘솔 로그 출력 & 폰트 및 색상 변경 , scanner로 입력 받고 if문 , switch문으로 처리
    //print_color_font();
    keyin.close();
  }

  static void printMenu() {
    // Menu 출력
    for (String menus : MENU) {
      System.out.println(menus);
    }
  }

  static String prompt(Scanner keyin) {
    System.out.print("> ");
    return keyin.nextLine();
  }

  static void useWhileIf(Scanner keyin) {
    while (true) {
      String strInput = prompt(keyin);
      // compareTo - ()안에 문자와 비교 모두 같은 경우 0을 리턴 , 다른경우 다른 갯수만큼의 숫자를 리턴
      // switch문으로 할 경우 case "": 만으로 가능
      if (strInput.compareTo("1") == 0) {
        System.out.println("과제입니다.");
      } else if (strInput.equals("2")) {
        System.out.println("게시글입니다.");
      } else if (strInput.equals("3")) {
        System.out.println("도움말입니다.");
      } else if (strInput.equals("4")) {
        System.out.println("종료입니다.");
        break;
      } else if (strInput.equals("menu")) {
        // menu 출력
        printMenu();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }

  static void useWhileSwitch(Scanner keyin) {
    loop1:
    while (true) {
      String strInput = prompt(keyin);
      switch (strInput) {
        case "1":
          System.out.println("과제입니다.");
          break;
        case "2":
          System.out.println("게시글입니다.");
          break;
        case "3":
          System.out.println("도움말입니다.");
        case "4":
          System.out.println("종료입니다.");
          break loop1;
        case "menu":
          printMenu();
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }

  static void print_color_font() {
    /*
     * 콘솔 로그 출력 & 폰트 및 색상 변경
     */
    String appTitle = "[과제관리 시스템]";
    String menu1 = "1. 과제", menu2 = "2. 게시글", menu3 = "3. 도움말", menu4 = "4. 종료";
    System.out.println(FONT_BOLD_RED + appTitle + RESET + "\n");
    System.out.println(menu1);
    System.out.println(menu2);
    System.out.println(menu3);
    System.out.println(FONT_RED + menu4 + RESET);
    System.out.print("> ");
    Scanner scanner = new Scanner(System.in);
    // int로 받고 if문으로 처리
    int menuNo = scanner.nextInt();
    if (menuNo == 1) {
      System.out.println("과제입니다.");
    } else if (menuNo == 2) {
      System.out.println("게시글입니다.");
    } else if (menuNo == 3) {
      System.out.println("도움말입니다.");
    } else if (menuNo == 4) {
      System.out.println("종료입니다.");
    } else {
      System.out.println("메뉴 번호가 옳지 않습니다.");
    }
    // String으로 받고 switch로 처리
    String strInput = scanner.nextLine();
    switch (strInput) {
      case "1":
        System.out.println("과제입니다.");
        break;
      case "2":
        System.out.println("게시글입니다.");
        break;
      case "3":
        System.out.println("도움말입니다.");
        break;
      case "4":
        System.out.println("종료합니다.");
        break;
    }
    scanner.close();
  }
}
