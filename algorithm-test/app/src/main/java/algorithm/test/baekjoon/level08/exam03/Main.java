package algorithm.test.baekjoon.level08.exam03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int cnt = scanner.nextInt();
    int[] arr1 = {25, 10, 5, 1};
    int[] arr2 = new int[4];
    for (int j = 0; j < cnt; j++) {
      int input = scanner.nextInt();
      for (int i = 0; i < arr2.length; i++) {
        arr2[i] = input / arr1[i];
        input %= arr1[i];
      }
      for (int i = 0; i < arr2.length; i++) {
        System.out.printf("%s ", arr2[i]);
      }
    }
    scanner.close();
  }
}
