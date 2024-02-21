package algorithm.test.baekjoon.level19.exam02;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    System.out.println(calc(n));
    scanner.close();
  }

  static int calc(int n) {
    if (n <= 1) {
      return n;
    } else {
      return calc(n - 1) + calc(n - 2);
    }
  }
}
