package algorithm.test.baekjoon.level19.exam01;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    System.out.println(calc(n));
    scanner.close();
  }

  static long calc(long n) {
    if (n > 1) {
      n = n * calc(--n);
      return n;
    } else {
      return 1;
    }
  }
}
