package algorithm.test.baekjoon.level15.exam01;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < n; i++) {
      int m = scanner.nextInt();
      int k = Integer.parseInt(scanner.nextLine().trim());
    }

    scanner.close();
  }

  static int calc(int a, int b) {
    if (a == 1 || b == 1) {
      return a * b;
    }
    return 0;
  }
}
