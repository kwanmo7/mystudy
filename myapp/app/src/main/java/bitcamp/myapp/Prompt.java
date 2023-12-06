package bitcamp.myapp;

import bitcamp.myapp.vo.AssignmentVO;
import bitcamp.myapp.vo.BulletinVO;
import bitcamp.myapp.vo.ConstVO;
import bitcamp.myapp.vo.MemberVO;
import java.util.Scanner;

public class Prompt {

  static Scanner scanner = new Scanner(System.in);
  
  static String input(String title, Object... args) {
    System.out.print(String.format(title, args));
    return scanner.nextLine();
  }

  static void close() {
    scanner.close();
  }

  static void addAssignment(AssignmentVO[] stAss) {
    System.out.println("과제 등록:");
    stAss[ConstVO.iAssIndex] = new AssignmentVO();
    stAss[ConstVO.iAssIndex].title = Prompt.input("과제명? ");
    stAss[ConstVO.iAssIndex].content = Prompt.input("내용? ");
    stAss[ConstVO.iAssIndex].deadline = Prompt.input("제출 마감일? ");
    ConstVO.iAssIndex++;
  }

  static void modifyAssignment(AssignmentVO[] stAss) {
    System.out.println("과제 변경:");
    if (!AssignmentVO.checkForAss()) {
      System.out.println("등록된 과제가 없습니다.");
      return;
    }
    int index = Integer.parseInt(input("번호? "));
    if (index < 0 || index >= ConstVO.iAssIndex) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }
    stAss[index].title = input("과제명(%s)? ", stAss[index].title);
    stAss[index].content = input("내용(%s)? ", stAss[index].content);
    stAss[index].deadline = input("제출 마감일(%s)? ", stAss[index].deadline);
  }

  static void addBulletin(BulletinVO[] stBul) {
    System.out.println("게시글 등록:");
    stBul[ConstVO.iBoardIndex] = new BulletinVO();
    stBul[ConstVO.iBoardIndex].title = input("제목? ");
    stBul[ConstVO.iBoardIndex].content = input("내용? ");
    stBul[ConstVO.iBoardIndex].writer = input("작성자? ");
    stBul[ConstVO.iBoardIndex].date = input("작성일? ");
    ConstVO.iBoardIndex++;
  }

  static void modifyBulletin(BulletinVO[] stBul) {
    System.out.println("게시글 변경:");
    if (!BulletinVO.checkForBoard()) {
      System.out.println("등록된 게시글이 없습니다.");
      return;
    }
    int index = Integer.parseInt(input("번호? "));
    if (0 < index || index >= ConstVO.iBoardIndex) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }
    stBul[index].title = input("제목(%s)? \n", stBul[index].title);
    stBul[index].content = input("내용(%s)? \n", stBul[index].content);
    stBul[index].writer = input("작성자(%s)? \n", stBul[index].writer);
    stBul[index].date = input("작성일(%s)? \n", stBul[index].date);
  }

  static void addMember(MemberVO[] stMem) {
    System.out.println("회원 입력: ");
    stMem[ConstVO.iMemberIndex] = new MemberVO();
    stMem[ConstVO.iMemberIndex].email = input("이메일: ");
    stMem[ConstVO.iMemberIndex].name = input("이름: ");
    stMem[ConstVO.iMemberIndex].password = input("비밀번호: ");
    stMem[ConstVO.iMemberIndex].date = input("가입일: ");
    ConstVO.iMemberIndex++;
  }

  static void modifyMember(MemberVO[] stMem) {
    System.out.println("회원 변경:");
    if (!MemberVO.checkForMem()) {
      System.out.println("등록된 회원이 없습니다.");
      return;
    }
    int index = Integer.parseInt(input("번호? "));
    if (0 < index || index >= ConstVO.iMemberIndex) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }
    stMem[index].email = input("이메일(%s)? \n", stMem[index].email);
    stMem[index].name = input("이름(%s)? \n", stMem[index].name);
    stMem[index].password = input("비밀번호(%s)? \n", stMem[index].password);
    stMem[index].date = input("가입일(%s)? \n", stMem[index].date);
  }
}
