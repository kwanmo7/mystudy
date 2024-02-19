package algorithm.test.baekjoon.level18.exam01;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    StringTokenizer st = new StringTokenizer(scanner.nextLine(), " ");
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    System.out.println(arr[0] * arr[n - 1]);
    scanner.close();
  }
}
