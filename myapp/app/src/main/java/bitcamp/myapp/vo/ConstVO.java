package bitcamp.myapp.vo;

import bitcamp.myapp.MainMenu;

public class ConstVO {
  // 폰트 RESET
  public static final String RESET = "\u001B[0m";
  // 폰트 변경 - 붉은색
  public static final String FONT_RED = "\033[0;31m";
  // 폰트 변경 - 붉은색 볼드체
  public static final String FONT_BOLD_RED = "\033[1;31m";
  public static final String[] MAIN_MENU = {
      FONT_BOLD_RED + "[과제관리 시스템]" + RESET,
      "1. 과제",
      "2. 게시글",
      "3. 도움말",
      FONT_RED + "4. 종료" + RESET};
  public static final String[] BOARD_MENU = {
      "[" + FONT_RED + "게시글" + RESET + "]",
      "1. 등록",
      "2. 조회",
      "3. 변경",
      "4. 삭제",
      "0. 이전"
  };
  public static final String[] ASSIGNMENT_MENU = {
      "[" + FONT_RED + "과제" + RESET + "]",
      "1. 등록",
      "2. 조회",
      "3. 변경",
      "4. 삭제",
      "0. 이전"
  };

}
