package algorithm.test.baekjoon.level13.exam11;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    long[] arr = new long[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextLong();
    }
    chk(arr);
    scanner.close();
  }

  static long[] chk(long[] arr) {
    long[] newArr = arr;
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
    return null;
  }
}
