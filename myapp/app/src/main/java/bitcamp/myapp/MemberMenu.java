package bitcamp.myapp;

import bitcamp.myapp.vo.ConstVO;
import bitcamp.myapp.vo.MemberVO;

public class MemberMenu {

  static void printMemberMenu() {
    for (String menu : ConstVO.MEMBER_MENU) {
      System.out.println(menu);
    }
  }

  static void execute(MemberVO[] stMem) {
    printMemberMenu();
    loopMember:
    while (true) {
      String strInput = Prompt.input("메인/회원> ");
      switch (strInput) {
        case "1":
          add(stMem);
          break;
        case "2":
          view(stMem);
          break;
        case "3":
          modify(stMem);
          break;
        case "4":
          delete(stMem);
          break;
        case "5":
          list(stMem);
          break;
        case "0":
          break loopMember;
        case "menu":
          printMemberMenu();
          break;
        default:
          System.out.println("번호가 올바르지 않습니다.");
      }
    }
  }

  static void add(MemberVO[] stMem) {
    if (stMem.length == ConstVO.iMemberIndex) {
      int iOldIndex = ConstVO.iMemberIndex;
      int iNewIndex = iOldIndex + (iOldIndex / 2);
      MemberVO[] stNewMem = new MemberVO[iNewIndex];
      for (int i = 0; i < iOldIndex; i++) {
        stNewMem[i] = stMem[i];
      }
      stMem = stNewMem;
    }
    Prompt.addMember(stMem);
  }

  static void view(MemberVO[] stMem) {
    System.out.println("회원 조회:");
    if (!MemberVO.checkForMem()) {
      System.out.println("등록된 회원이 없습니다.");
      return;
    }
    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= ConstVO.iMemberIndex) {
      System.out.println("번호가 올바르지 않습니다.");
      return;
    }
    stMem[index].printMember();
  }

  static void modify(MemberVO[] stMem) {
    Prompt.modifyMember(stMem);
  }

  static void delete(MemberVO[] stMem) {
    System.out.println("회원 삭제:");
    if (!MemberVO.checkForMem()) {
      System.out.println("등록된 회원이 없습니다.");
      return;
    }
    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= ConstVO.iMemberIndex) {
      System.out.println("번호가 올바르지 않습니다.");
      return;
    }
    for (int i = 0; i < (stMem.length - 1); i++) {
      stMem[i] = stMem[i + 1];
    }

    stMem[--ConstVO.iMemberIndex] = null;
  }

  static void list(MemberVO[] stMem) {
    System.out.println("회원 목록:");
    System.out.printf("%-20s\t%-20s\t%s\n", "이메일", "이름", "가입일");
    for (int i = 0; i != ConstVO.iMemberIndex; i++) {
      stMem[i].printMemberList();
    }
  }
}
