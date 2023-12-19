package algorithm.test.baekjoon.level07.exam04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    int[][] arr = new int[100][100];
    for (int i = 0; i < input; i++) {
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      for (int j = x - 1; j < x + 9; j++) {
        for (int k = y - 1; k < y + 9; k++) {
          if (arr[j][k] == 0) {
            arr[j][k]++;
          }
        }
      }
    }
    int rlt = 0;
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (arr[i][j] == 1) {
          rlt++;
        }
      }
    }
    System.out.println(rlt);
    scanner.close();
  }
}
