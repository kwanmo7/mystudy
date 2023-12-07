package algorithm.test.baekjoon.level02.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    b = b + c;
    a += b / 60;
    a %= 24;
    b %= 60;
    System.out.printf("%s %s", a, b);

    scanner.close();
  }
}
