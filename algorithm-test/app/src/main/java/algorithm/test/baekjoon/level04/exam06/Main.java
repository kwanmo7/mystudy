package algorithm.test.baekjoon.level04.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = i + 1;
    }
    int m = scanner.nextInt();
    for (int i = 0; i < m; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int temp = arr[a - 1];
      arr[a - 1] = arr[b - 1];
      arr[b - 1] = temp;
    }
    for (int j = 0; j < n; j++) {
      System.out.printf("%d ", arr[j]);
    }
    scanner.close();
  }
}
