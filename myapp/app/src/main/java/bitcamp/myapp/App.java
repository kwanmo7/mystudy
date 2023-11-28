package bitcamp.myapp;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

  // 콘솔 출력 텍스트 색상 기본으로 변경
  public static final String RESET = "\u001B[0m";
  // 콘솔 출력 텍스트 빨간색으로 변경
  public static final String FONT_RED = "\033[0;31m";
  // 폰트 볼드&RED
  // final - 값의 변경 불가 , 한번 선언한 값만 사용
  public static final String FONT_BOLD_RED = "\033[1;31m";

  // \u001B = \033 같은 값
  public static void main(String[] args) {
    // 콘솔 로그 출력 & 폰트 및 색상 변경
    print_color_font();
    loop();
    //test();
  }

  static void print_color_font() {
    /*
     * 콘솔 로그 출력 & 폰트 및 색상 변경
     */
    String appTitle = "[과제관리 시스템]";
    String menu1 = "1. 과제", menu2 = "2. 게시글", menu3 = "3. 도움말", menu4 = "4. 종료";
    System.out.println("-------------------------------");
    System.out.println(FONT_BOLD_RED + appTitle + RESET + "\n");
    System.out.println(menu1);
    System.out.println(menu2);
    System.out.println(menu3);
    System.out.println(FONT_RED + menu4 + RESET);
    System.out.println("-------------------------------");
  }

  static void test() {
    // scanner - 키보드 입력 받기
    Scanner scanner = new Scanner(System.in);
    // 키보드에서 입력 받는 값을 String 형태의 input에 저장
    String input = scanner.nextLine();
    // 출력
    System.out.println(input);
    // scanner 사용 종료시 close로 닫아줘야함
    scanner.close();
  }

  static void loop() {
    // 배열의 경우 아래와 같이 다양하게 선언가능
    String[] strA = new String[3];
    String[] strB = {"aa", "bb", "cc"};
    String[] strC;
    strC = new String[]{"aaa", "bbb"};

    ArrayList arrA = new ArrayList();
    ArrayList<String> arrB = new ArrayList<>();
    arrA.add("aa");
    arrA.add(1);
    arrA.add(3.3);
    arrA.add(true);

    arrB.add("aa");
    arrB.add("bb");

    for (String output : strA) {
      System.out.println(output);
    }
    for (int i = 0; i < strB.length; i++) {
      System.out.println(strB[i]);
    }

    loop1:
    while (true) {
      while (true) {
        System.out.println(strC[1]);
        break loop1; // 이중 반복문을 한번에 벗어날 수 있음
      }
    }

    for (int i = 0; i < arrA.size(); i++) {
      System.out.println(arrA.get(i));
    }
  }
}
