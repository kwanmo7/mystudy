package algorithm.test.baekjoon.level20.exam06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static int[][] arr = new int[9][9];

  public static void main(String[] args) throws IOException {

    for (int i = 0; i < arr.length; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    if (solveSudoku()) {
      for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
          bw.write(arr[i][j] + " ");
        }
        bw.newLine();
      }
      bw.flush();
    }

    br.close();
    bw.close();
  }

  private static boolean solveSudoku() {
    for (int row = 0; row < arr.length; row++) {
      for (int col = 0; col < arr[row].length; col++) {
        if (arr[row][col] == 0) {
          for (int num = 1; num <= 9; num++) {
            if (checkSafe(row, col, num)) {
              arr[row][col] = num;
              if (solveSudoku()) { // 재귀 호출을 통해 빈칸 채워넣기, 넣은 숫자가 제대로 맞는지 재확인을 위해 재귀호출
                return true;
              }
              arr[row][col] = 0; // 재귀호출로 재검사를 통해 잘못된 것이 있으면 0으로 다시 초기화
            }
          }
          return false; // 스도쿠 퍼즐에 맞는 숫자가 아닌 경우 false 리턴
        }
      }
    }
    return true;
  }

  private static boolean checkSafe(int row, int col, int num) {

    // 가로줄 검사
    for (int i = 0; i < 9; i++) {
      if (arr[row][i] == num) {
        return false;
      }
    }

    // 세로줄 검사
    for (int i = 0; i < 9; i++) {
      if (arr[i][col] == num) {
        return false;
      }
    }

    // 3*3 박스 검사
    int startRow = row - row % 3;
    int startCol = col - col % 3;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (arr[startRow + i][startCol + j] == num) {
          return false;
        }
      }
    }

    return true;
  }
}
