package algorithm.test.baekjoon.level15.exam04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(scanner.nextLine());
    }
    int rlt = 0; // 나무간의 간격의 최대 공약수

    for (int i = 0; i < arr.length - 1; i++) {
      int distance = arr[i + 1] - arr[i]; // 나무간의 간격 계산
      rlt = calc(distance, rlt); // 나무간의 간격의 최대공약수 계산
    }
    // 최대값 - 최소값 / 최대공약수 + 1 - 심어져있는 나무의 갯수
    rlt = (arr[n - 1] - arr[0]) / rlt + 1 - arr.length;
    System.out.println(rlt);
    scanner.close();
  }

  static int calc(int a, int b) { // 재귀호출 - 유클리드 호제법(최대공약수 구하기)
    if (b == 0) {
      return a;
    }
    return calc(b, a % b);
  }
}
