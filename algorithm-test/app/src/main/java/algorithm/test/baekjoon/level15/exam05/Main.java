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
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(calc(arr[i]) + "\n");
    }
    System.out.print(sb);
    scanner.close();
  }

  static long calc(long input) {
    long i = input;
    while (true) {
      if (i < 2) {
        return 2;
      }
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
      i++;
    }
  }
}
