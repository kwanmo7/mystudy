package algorithm.test.baekjoon.level02.exam04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    if (x > 0 && y > 0) {
      System.out.print("1");
    } else if (x < 0 && y > 0) {
      System.out.print("2");
    } else if (x < 0 && y < 0) {
      System.out.print("3");
    } else if (x > 0 && y < 0) {
      System.out.print("4");
    }
    scanner.close();
  }
}
