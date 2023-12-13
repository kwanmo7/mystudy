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
      int e = d - c;
      for (int j = c - 1; j < e; j++) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
      }
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%d ", arr[i]);
    }
  }
}
