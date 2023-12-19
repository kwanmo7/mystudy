package algorithm.test.baekjoon.level07.exam01;

import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    int[][] arr1 = new int[a][b];
    int[][] arr2 = new int[a][b];
    for (int i = 0; i < a; i++) {
      for (int j = 0; j < b; j++) {
        arr1[i][j] = scanner.nextInt();
      }
    }
    for (int i = 0; i < a; i++) {
      for (int j = 0; j < b; j++) {
        arr2[i][j] = scanner.nextInt();
      }
    }
    scanner.close();
    for (int i = 0; i < a; i++) {
      for (int j = 0; j < b; j++) {
        System.out.printf("%d ", arr1[i][j] + arr2[i][j]);
      }
      System.out.println();
    }
  }
}
