package algorithm.test.baekjoon.level20.exam05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static int n;

  static int[][] arr;

  public static void main(String[] args) throws NumberFormatException, IOException {

    n = Integer.parseInt(br.readLine());

    arr = new int[n][n];

    int result = solution(arr, 0, n);

    bw.write("" + result);
    bw.flush();
    br.close();
    bw.close();
  }

  /*
   * 재귀적으로 각 열에 퀸을 놓음
   * 모든 열에 퀸을 놓았을 경우 유효한 배치로 간주하여 카운트를 증가
   * 퀸을 놓을 수 있는 위치를 찾아서 재귀적으로 다음 열로 이동
   * 재귀 호출 후 퀸을 제거하여 백트래킹을 수행
   */
  private static int solution(int[][] arr, int col, int n) {

    if (col >= n) { // 모든 퀸을 놓으면 1로 리턴
      return 1;
    }

    int count = 0;

    for (int i = 0; i < n; i++) {
      if (check(arr, i, col, n)) {
        arr[i][col] = 1; // queen 위치 설정
        count += solution(arr, col + 1, n); // 재귀호출
        arr[i][col] = 0;
      }
    }

    return count;
  }

  // queen 이 놓일 수 있는지 체크
  /*
   * 주어진 위치 (row, col)에 퀸을 놓아도 되는지 확인
   * 행, 왼쪽 상단 대각선, 왼쪽 하단 대각선에 퀸이 있는지 검사
   */
  private static boolean check(int[][] arr, int row, int col, int n) {
    for (int i = 0; i < col; i++) { // 가로 체크
      if (arr[row][i] == 1) {
        return false;
      }
    }

    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) { // 왼쪽 상단 대각선 체크
      if (arr[i][j] == 1) {
        return false;
      }
    }

    for (int i = row, j = col; i < n && j >= 0; i++, j--) { // 왼쪽 하단 대각선 체크
      if (arr[i][j] == 1) {
        return false;
      }
    }

    return true;
  }
}
