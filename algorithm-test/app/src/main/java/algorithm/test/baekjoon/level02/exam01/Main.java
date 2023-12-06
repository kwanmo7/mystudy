package algorithm.test.baekjoon.level02.exam01;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int a = scanner.nextInt();
    int b = scanner.nextInt();

    if (a > b) {
      System.out.print(">");
    } else if (a < b) {
      System.out.print("<");
    } else {
      System.out.print("==");
    }
    scanner.close();
  }
}
