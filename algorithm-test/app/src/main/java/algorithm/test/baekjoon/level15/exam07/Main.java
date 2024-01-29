package algorithm.test.baekjoon.level15.exam07;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      int n = Integer.parseInt(scanner.nextLine());
      if (n == 0) {
        break;
      }
      System.out.println(calc(n));
    }
    scanner.close();
  }

  static int calc(int input) {
    int rlt = 0;
    for (int i = input + 1; i <= input * 2; i++) {
      if (i < 2) {
        continue;
      }
      boolean chk = true;
      for (int j = 2; j * j <= i; j++) {
        if ((i % j) == 0) {
          chk = false;
          break;
        }
      }
      if (chk == true) {
        rlt++;
      }
    }
    return rlt;
  }
}
