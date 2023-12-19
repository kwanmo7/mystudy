package algorithm.test.baekjoon.level07.exam02;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scanner.nextInt();
      }
    }

    int temp = 0;
    int index1 = 1;
    int index2 = 1;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (arr[i][j] > temp) {
          if (arr[i][j] == temp) {
            continue;
          }
          temp = arr[i][j];
          index1 = i + 1;
          index2 = j + 1;
        }
      }
    }
    System.out.println(temp);
    System.out.printf("%d %d", index1, index2);
    scanner.close();
  }
}
