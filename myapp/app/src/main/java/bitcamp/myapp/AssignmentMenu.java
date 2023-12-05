package bitcamp.myapp;

import bitcamp.myapp.vo.AssignmentVO;
import bitcamp.myapp.vo.ConstVO;

public class AssignmentMenu {
  static void printmenu() {
    for (String menus : ConstVO.ASSIGNMENT_MENU) {
      System.out.println(menus);
    }
  }

  static void execute(AssignmentVO stAss) {
    printmenu();
    loopBoard:
    while (true) {
      String strInput = Prompt.input("메인/과제> ");
      switch (strInput) {
        case "1":
          Prompt.addAssignment(stAss);
          break;
        case "2":
          view(stAss);
          break;
        case "3":
          modify(stAss);
          break;
        case "4":
          delete(stAss);
          break;
        case "0":
          break loopBoard;
        case "menu":
          printmenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }

  static void view(AssignmentVO stAss) {
    System.out.println("과제 조회:");
    System.out.printf("과제명: %s\n", stAss.title);
    System.out.printf("내용: %s\n", stAss.content);
    System.out.printf("제출 마감일: %s\n", stAss.deadline);
  }

  static void modify(AssignmentVO stAss) {
    Prompt.modifyAssignment(stAss);
    stAss.modifyAssignment(stAss);
  }

  static void delete(AssignmentVO stAss) {
    System.out.println("과제 삭제:");
    stAss.delete();
  }
}
