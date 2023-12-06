package bitcamp.myapp.vo;

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
      "3. 회원",
      "4. 도움말",
      FONT_RED + "0. 종료" + RESET};
  public static final String[] BOARD_MENU = {
      "[" + FONT_RED + "게시글" + RESET + "]",
      "1. 등록",
      "2. 조회",
      "3. 변경",
      "4. 삭제",
      "5. 목록",
      "0. 이전"
  };
  public static final String[] ASSIGNMENT_MENU = {
      "[" + FONT_RED + "과제" + RESET + "]",
      "1. 등록",
      "2. 조회",
      "3. 변경",
      "4. 삭제",
      "5. 목록",
      "0. 이전"
  };
  public static final String[] MEMBER_MENU = {
      "[" + FONT_RED + "회원" + RESET + "]",
      "1. 입력",
      "2. 조회",
      "3. 변경",
      "4. 삭제",
      "5. 목록",
      "0. 이전"
  };
  public static int iAssIndex = 0;
  public static int iBoardIndex = 0;
  public static int iMemberIndex = 0;

}
