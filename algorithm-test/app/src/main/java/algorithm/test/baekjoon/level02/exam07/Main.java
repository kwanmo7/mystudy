package algorithm.test.baekjoon.level02.exam07;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    int d;
    if (a == b && b == c) {
      d = 10000 + (a * 1000);
      System.out.print(d);
    } else if ((a == b && b != c) || (b == c && a != b) || (a == c && a != b)) {
      int calc = 1000 + (a * 100);
      int calc2 = 1000 + (b * 100);
      int calc3 = 1000 + (c * 100);
      if (calc == calc2 || calc == calc3) {
        d = calc;
      } else {
        d = calc2;
      }
      System.out.print(d);
    } else {
      int calc = a * 100;
      int calc2 = b * 100;
      int calc3 = c * 100;
      if (calc > calc2 && calc > calc3) {
        System.out.print(calc);
      } else if (calc2 > calc && calc2 > calc3) {
        System.out.print(calc2);
      } else {
        System.out.print(calc3);
      }
    }
    scanner.close();
  }
}
