package bitcamp.myapp.vo;

import bitcamp.util.AnsiEscape;

public class ConstVO {

  public static final String[] MAIN_MENU = {
      AnsiEscape.ANSI_BOLD_RED + "[과제관리 시스템]" + AnsiEscape.RESET,
      "1. 과제",
      "2. 게시글",
      "3. 회원",
      "4. 가입인사",
      "5. 도움말",
      AnsiEscape.ANSI_RED + "0. 종료" + AnsiEscape.RESET};
  public static final String[] BOARD_MENU = {
      "1. 등록",
      "2. 조회",
      "3. 변경",
      "4. 삭제",
      "5. 목록",
      "0. 이전"
  };
  public static final String[] ASSIGNMENT_MENU = {
      "1. 등록",
      "2. 조회",
      "3. 변경",
      "4. 삭제",
      "5. 목록",
      "0. 이전"
  };
  public static final String[] MEMBER_MENU = {
      "1. 등록",
      "2. 조회",
      "3. 변경",
      "4. 삭제",
      "5. 목록",
      "0. 이전"
  };
}
