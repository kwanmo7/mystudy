package algorithm.test.baekjoon.level21.exam02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int[][][] sol = new int[21][21][21];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      if (a == -1 && b == -1 && c == -1) {
        break;
      }
      bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
      bw.newLine();
    }

    bw.flush();
    br.close();
    bw.close();
  }

  private static boolean checkRange(int a, int b, int c) { // 범위 체크
    return a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20;
  }

  private static int w(int a, int b, int c) {
    if (checkRange(a, b, c) && sol[a][b][c] != 0) { // 중복 체크로 인해 계산 시간 감소
      return sol[a][b][c];
    }
    if (a <= 0 || b <= 0 || c <= 0) {
      return 1;
    }

    if (a > 20 || b > 20 || c > 20) {
      return sol[20][20][20] = w(20, 20, 20);
    }

    if (a < b && b < c) {
      sol[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
      return sol[a][b][c];
    }

    sol[a][b][c] =
        w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    return sol[a][b][c];
  }
}
