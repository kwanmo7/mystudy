package algorithm.test.baekjoon.level17.exam05;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(scanner.nextLine(), " ");
      System.out.println(calc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
    scanner.close();
  }

  static long calc(int a, int b) { // b C a - Combination으로 계산
    long rlt = 1;
    for (int i = b, j = 1; i > b - a; i--, j++) {
      rlt *= i;
      if (j <= a) {
        rlt /= j;
      }
    }
    return rlt;
  }
}
