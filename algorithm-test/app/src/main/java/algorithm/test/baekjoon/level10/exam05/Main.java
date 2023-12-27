package algorithm.test.baekjoon.level10.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int[] arrX = new int[a];
    int[] arrY = new int[a];
    for (int i = 0; i < a; i++) {
      arrX[i] = scanner.nextInt();
      arrY[i] = scanner.nextInt();
    }
    int x = calc(arrX);
    int y = calc(arrY);

    System.out.println(x * y);
    scanner.close();
  }

  static int calc(int[] arr) {
    int min = arr[0];
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (min > arr[i]) {
        min = arr[i];
      }
      if (max < arr[i]) {
        max = arr[i];
      }
    }
    return max - min;
  }
}
