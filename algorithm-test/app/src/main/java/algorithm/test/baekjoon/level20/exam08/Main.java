package algorithm.test.baekjoon.level20.exam08;

import java.util.Scanner;

public class Main {

  static int n;
  static int[][] value;
  static boolean[] visited;
  static int minDiff = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    value = new int[n][n];
    visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        value[i][j] = sc.nextInt();
      }
    }

    makeTeam(0, 0);
    System.out.println(minDiff);
    sc.close();
  }

  private static void makeTeam(int index, int count) {
    if (count == n / 2) {
      int[] startTeam = new int[n / 2];
      int[] linkTeam = new int[n / 2];
      int startIndex = 0;
      int linkIndex = 0;

      for (int i = 0; i < n; i++) {
        if (visited[i]) {
          startTeam[startIndex++] = i;
        } else {
          linkTeam[linkIndex++] = i;
        }
      }

      // 각 팀의 능력치 계산
      int startPower = calcPower(startTeam);
      int linkPower = calcPower(linkTeam);

      int diff = Math.abs(startPower - linkPower);
      if (diff < minDiff) {
        minDiff = diff;
      }
      return;
    }
    // 조합 구하기
    for (int i = index; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        makeTeam(i + 1, count + 1);
        visited[i] = false;
      }
    }
  }

  // 능력치 합 계산
  private static int calcPower(int[] team) {
    int power = 0;
    for (int i = 0; i < team.length; i++) {
      for (int j = i + 1; j < team.length; j++) {
        power += value[team[i]][team[j]] + value[team[j]][team[i]];
      }
    }
    return power;
  }
}
