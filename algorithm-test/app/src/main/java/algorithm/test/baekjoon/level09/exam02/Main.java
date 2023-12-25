package algorithm.test.baekjoon.level09.exam02;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int cnt = 0;
    for (int i = 1; i <= a; i++) {
      if (a % i == 0) {
        cnt++;
        if (cnt == b) {
          System.out.println(i);
        }
      }
    }
    if (cnt < b) {
      System.out.println(0);
    }
    scanner.close();
  }
}
