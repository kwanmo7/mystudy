package algorithm.test.baekjoon.level19.exam06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static char[][] arr; // 별을 찍을 이중배열

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    arr = new char[n][n];
    calc(0, 0, n, false);

    // 배열 출력
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        bw.write(arr[i][j]);
      }
      bw.newLine();
    }
    bw.flush();
  }


  static void calc(int x, int y, int n, boolean chk) {
    if (chk) { // chk를 통해 공백을 찍어줌
      for (int i = x; i < x + n; i++) {
        for (int j = y; j < y + n; j++) {
          arr[i][j] = ' ';
        }
      }
      return;
    }

    if (n == 1) { // 별을 찍어줌
      arr[x][y] = '*';
      return;
    }

    int size = n / 3;
    int cnt = 0;
    for (int i = x; i < x + n; i += size) {
      for (int j = y; j < y + n; j += size) {
        cnt++;
        if (cnt == 5) { // true , false로 공백 찍는곳 호출, 다섯번째 마다 공백을 찍음
          calc(i, j, size, true); // 공백이 들어가야할 곳에서 재귀호출로 공백 찍기
        } else {
          calc(i, j, size, false); // 별을 찍는부분 재귀호출
        }
      }
    }
    // 일렬로 먼저 찍는것이 아닌 3*3 사이즈 단위로 별을 찍음 , 그것을 위해 이중배열 사용
  }
}
