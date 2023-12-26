package algorithm.test.baekjoon.level10.exam02;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    int d = scanner.nextInt();
    int[] arr = new int[2];

    if (a > Math.abs(a - c)) {
      arr[0] = Math.abs(a - c);
    } else {
      arr[0] = a;
    }

    if (b > Math.abs(b - d)) {
      arr[1] = Math.abs(b - d);
    } else {
      arr[1] = b;
    }
    if (arr[0] > arr[1]) {
      System.out.println(arr[1]);
    } else {
      System.out.println(arr[0]);
    }
    scanner.close();
  }
}
