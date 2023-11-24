package bitcamp.myapp;

public class App {

  // 콘솔 출력 텍스트 색상 기본으로 변경
  public static final String RESET = "\u001B[0m";
  // 콘솔 출력 텍스트 빨간색으로 변경
  public static final String FONT_RED = "\033[0;31m";
  // 폰트 볼드&RED
  public static final String FONT_BOLD_RED = "\033[1;31m";

  // \u001B = \033 같은 값
  public static void main(String[] args) {
    // 콘솔 로그 출력 & 폰트 및 색상 변경
    print_color_font();
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
}
