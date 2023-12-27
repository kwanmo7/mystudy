package algorithm.test.baekjoon.level10.exam03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] arrX = new int[3];
    int[] arrY = new int[3];
    for (int i = 0; i < 3; i++) {
      arrX[i] = scanner.nextInt();
      arrY[i] = scanner.nextInt();
    }
    int x = calc(arrX);
    int y = calc(arrY);
    System.out.printf("%d %d", x, y);

    scanner.close();
  }

  static int calc(int[] arr) {
    if (arr[0] == arr[1]) {
      return arr[2];
    } else if (arr[0] == arr[2]) {
      return arr[1];
    } else {
      return arr[0];
    }
  }
}
