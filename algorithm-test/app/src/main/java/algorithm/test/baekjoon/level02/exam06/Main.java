package algorithm.test.baekjoon.level02.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    if (c >= 60) {
      int d = c / 60;
      int e = c % 60;
      if (a + d >= 24) {
        a = d - (24 - a);
      } else {
        a = a + d;
      }
      b = e + b;
      if (b >= 60) {
        a++;
        b %= 60;
      }
      System.out.printf("%s %s", a, b);
    } else if (c < 60) {
      b = b + c;
      if (b >= 60) {
        a++;
        b = b - 60;
      }
      if (a == 24) {
        a = 0;
      }
      System.out.printf("%s %s", a, b);
    }
    scanner.close();
  }
}
