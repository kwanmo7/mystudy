package algorithm.test.baekjoon.level13.exam08;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[][] arr = new int[n][2];
    for (int i = 0; i < n; i++) {
      arr[i][0] = scanner.nextInt();
      arr[i][1] = scanner.nextInt();
    }
    // 이중배열 {x,y}라 할때
    // y값에 대해서 먼저 오름차순 정렬
    // y값이 같을 경우 x 값에 대해 오름차순 정렬
    Arrays.sort(arr, (v1, v2) -> {
      return v1[1] != v2[1] ? v1[1] - v2[1] : v1[0] - v2[0];
    });
    StringBuilder str = new StringBuilder();
    for (int[] a : arr) {
      str.append(a[0] + " " + a[1] + "\n");
    }
    System.out.println(str);
    scanner.close();
  }
}
