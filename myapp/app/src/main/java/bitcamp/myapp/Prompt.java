package bitcamp.myapp;

import java.util.Scanner;

public class Prompt {

  static String promptMain(Scanner keyin) {
    System.out.print("메인> ");
    return keyin.nextLine();
  }

  static String promptReg(Scanner keyin) {
    System.out.print("메인/과제> ");
    return keyin.nextLine();
  }

  static String promptBoard(Scanner keyin) {
    System.out.print("메인/게시글> ");
    return keyin.nextLine();
  }
  
}
