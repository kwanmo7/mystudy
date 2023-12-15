package algorithm.test.baekjoon.level06.exam04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    int chk = 1;
    for (int i = 0; i < (input.length() / 2); i++) {
      if (input.charAt(i) != input.charAt(input.length() - (1 + i))) {
        chk = 0;
        break;
      }
    }
    System.out.print(chk);
    scanner.close();
  }
}
