package algorithm.test.baekjoon.level12.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    int rlt = 0;
    rlt = calc(input);
    System.out.println(rlt);
    scanner.close();
  }

  static int calc(int input) {
    int rlt = 0;
    for (int i = 0; i <= 1000; i++) {
      for (int j = 0; j <= 1000; j++) {
        rlt = (3 * i) + (5 * j);
        if (rlt == input) {
          return i + j;
        }
        if (rlt > input) {
          break;
        }
      }
    }
    return -1;
  }
}

