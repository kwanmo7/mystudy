package bitcamp.myapp;

import bitcamp.myapp.vo.AssignmentVO;
import bitcamp.myapp.vo.ConstVO;

public class AssignmentMenu {

  static void printmenu() {
    for (String menus : ConstVO.ASSIGNMENT_MENU) {
      System.out.println(menus);
    }
  }

  static void execute(AssignmentVO[] stAss) {
    printmenu();
    loopBoard:
    while (true) {
      String strInput = Prompt.input("메인/과제> ");
      switch (strInput) {
        case "1":
          add(stAss);
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
        case "5":
          list(stAss);
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

  static void add(AssignmentVO[] stAss) {
    if (ConstVO.iAssIndex == stAss.length) {
      // 배열 늘리기
      int ioldSize = stAss.length;
      int inewSize = ioldSize + (ioldSize / 2);
      AssignmentVO[] stNewAss = new AssignmentVO[inewSize];
      // 이전 배열에 들어 있는 값을 복사
      for (int i = 0; i < ioldSize; i++) {
        stNewAss[i] = stAss[i];
      }
      // 새 배열을 가리키도록 배열 래퍼런스 변경
      stAss = stNewAss;
    }
    Prompt.addAssignment(stAss);
  }

  static void view(AssignmentVO[] stAss) {
    System.out.println("과제 조회:");
    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= ConstVO.iAssIndex) {
      System.out.println("과제 번호가 유효하지 않습니다.");
    }
    stAss[index].printAssignment();
  }


  static void modify(AssignmentVO[] stAss) {
    Prompt.modifyAssignment(stAss);
  }

  static void delete(AssignmentVO[] stAss) {
    System.out.println("과제 삭제:");
    if (!AssignmentVO.checkForAss()) {
      System.out.println("등록된 과제가 없습니다.");
      return;
    }
    int index = Integer.parseInt(Prompt.input("삭제할 번호? "));
    if (index < 0 || index >= ConstVO.iAssIndex) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }
    for (int i = 0; i < (stAss.length - 1); i++) {
      stAss[i] = stAss[i + 1];
    }

    stAss[--ConstVO.iAssIndex] = null;
  }

  static void list(AssignmentVO[] stAss) {
    System.out.println("과제 목록:");
    System.out.printf("%-20s\t%s\n", "과제", "제출마감일");
    for (int i = 0; i != ConstVO.iAssIndex; i++) {
      stAss[i].printAssignmentlist();
    }
  }

}
