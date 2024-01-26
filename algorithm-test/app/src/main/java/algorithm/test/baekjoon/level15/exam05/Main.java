package algorithm.test.baekjoon.level15.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    long[] arr = new long[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(scanner.nextLine());
    }

    for (int i = 0; i < n; i++) {
      System.out.println(calc(arr[i]));
    }
    scanner.close();
  }

  static long calc(long input) {
    for (long i = input; i <= 4 * Math.pow(10, 9); i++) {
      boolean chk = true;
      for (long j = 2; j * j <= i; j++) {
        if ((i % j) == 0) {
          chk = false;
          break;
        }
      }
      if (chk == true) {
        return i;
      }
    }
    return 0;
  }
}
