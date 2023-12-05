package bitcamp.myapp;

import bitcamp.myapp.vo.AssignmentVO;
import bitcamp.myapp.vo.Bulletin;
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

  static void addAssignment(AssignmentVO stAss) {
    System.out.println("과제 등록:");
    stAss.title = Prompt.input("과제명? ");
    stAss.content = Prompt.input("내용? ");
    stAss.deadline = Prompt.input("제출 마감일? ");
  }

  static void modifyAssignment(AssignmentVO stAss) {
    System.out.println("과제 변경:");
    stAss.title = Prompt.input("과제명(%s)? ", stAss.title);
    stAss.content = Prompt.input("내용(%s)? ", stAss.content);
    stAss.deadline = Prompt.input("제출 마감일(%s)? ", stAss.deadline);
  }

  static void addBulletin(Bulletin stBul) {
    System.out.println("게시글 등록:");
    stBul.title = input("제목? ");
    stBul.content = input("내용? ");
    stBul.writer = input("작성자? ");
    stBul.date = input("작성일? ");
  }

  static void modifyBulletin(Bulletin stBul) {
    System.out.println("게시글 변경:");
    stBul.title = input("제목(%s)? \n", stBul.title);
    stBul.content = input("내용(%s)? \n", stBul.content);
    stBul.writer = input("작성자(%s)? \n", stBul.writer);
    stBul.date = input("작성일(%s)? \n", stBul.date);
  }
}
