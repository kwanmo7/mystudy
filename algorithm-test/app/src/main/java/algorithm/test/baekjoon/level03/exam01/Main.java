package algorithm.test.baekjoon.level03.exam01;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    for (int i = 1; i < 10; i++) {
      System.out.printf("%s * %s = %s\n", a, i, a * i);
    }
    scanner.close();
  }
}
