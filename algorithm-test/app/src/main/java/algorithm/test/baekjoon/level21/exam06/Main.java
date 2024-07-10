package algorithm.test.baekjoon.level21.exam06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static int[][] arr;

  public static void main(String[] args) throws NumberFormatException, IOException {
    int n = Integer.parseInt(br.readLine());
    arr = new int[n][3];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 동적 배열 , 첫 번째 비용 그대로 사용
    int[][] dp = new int[n][3];
    dp[0][0] = arr[0][0];
    dp[0][1] = arr[0][1];
    dp[0][2] = arr[0][2];

    // 두 번째 집부터 비용 계산
    for (int i = 1; i < n; i++) {
      dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
      dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
      dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
    }

    // 최소 비용 찾기
    int min = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    bw.write(min + "");
    bw.flush();

    br.close();
    bw.close();
  }
}
