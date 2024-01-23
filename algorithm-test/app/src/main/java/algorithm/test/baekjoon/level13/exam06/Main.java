package algorithm.test.baekjoon.level13.exam06;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    char[] arr = new char[10];
    arr = scanner.nextLine().toCharArray();
    Arrays.parallelSort(arr);
    StringBuilder str = new StringBuilder();
    for (int i = arr.length - 1; i >= 0; i--) {
      str.append(arr[i]);
    }
    System.out.println(str);
    scanner.close();
  }
}
