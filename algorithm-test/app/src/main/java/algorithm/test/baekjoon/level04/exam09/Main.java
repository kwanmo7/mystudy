package algorithm.test.baekjoon.level04.exam09;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int[] arr = new int[a];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i + 1;
    }
    for (int i = 0; i < b; i++) {
      int c = scanner.nextInt();
      int d = scanner.nextInt();
      int k = d - 1;
      for (int j = c - 1; j < k; j++) {
        int temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
        k--;
      }
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%d ", arr[i]);
    }
  }
}
