package algorithm.test.baekjoon.level21.exam07;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] triangle = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        triangle[i][j] = sc.nextInt();
      }
    }

    // dp 배열 생성 , 첫 번째 값을 삼각형의 첫 요소로 초기화
    int[][] dp = new int[n][n];
    dp[0][0] = triangle[0][0];

    // 최대합 계산
    // 삼각형의 각 요소를 순회하면서 현재 위치의 값과 이전 위치들의 최대 합을 비교하여 배열에 넣어줌
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0) {
          dp[i][j] = dp[i - 1][j] + triangle[i][j];
        } else if (j == i) {
          dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
        }
      }
    }
    // 가장 큰 수 추출
    int maxSum = 0;
    for (int i = 0; i < n; i++) {
      if (dp[n - 1][i] > maxSum) {
        maxSum = dp[n - 1][i];
      }
    }
    System.out.println(maxSum);
  }
}

/*
 * O(n^2) 의 시간 복잡도를 가짐
 */
