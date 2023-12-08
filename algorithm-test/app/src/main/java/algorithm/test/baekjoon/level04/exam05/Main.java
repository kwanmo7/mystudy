package algorithm.test.baekjoon.level04.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int[] f = new int[a];
    for (int i = 0; i < b; i++) {
      int c = scanner.nextInt();
      int d = scanner.nextInt();
      int e = scanner.nextInt();
      for (int j = c - 1; j < d; j++) {
        f[j] = e;
      }
    }
    for (int i = 0; i < a; i++) {
      System.out.printf("%s ", f[i]);
    }
    scanner.close();
  }
}
