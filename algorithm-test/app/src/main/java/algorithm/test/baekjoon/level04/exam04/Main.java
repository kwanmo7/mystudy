package algorithm.test.baekjoon.level04.exam04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] str = new int[9];
    int cnt = 1;
    for (int i = 0; i < 9; i++) {
      str[i] = scanner.nextInt();
    }
    int max = str[0];
    for (int i = 0; i < 9; i++) {
      if (max < str[i]) {
        max = str[i];
        cnt = i + 1;
      }
    }
    System.out.println(max);
    System.out.println(cnt);
    scanner.close();
  }
}
