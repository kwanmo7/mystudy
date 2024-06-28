package algorithm.test.baekjoon.level20.exam03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static int n;
  static int m;

  static int[] arr;

  public static void main(String[] args) throws IOException {

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[m];

    calc(1, 0);
    bw.flush();
  }

  private static void calc(int at, int cursor) throws IOException {
    if (cursor == m) { // arr 배열 한줄이 완성된 경우 출력
      for (int num : arr) {
        bw.write(num + " ");
      }
      bw.newLine();
      return;
    }

    for (int i = 1; i <= n; i++) {
      arr[cursor] = i;
      calc(at, cursor + 1); // 뒤쪽 배열에 값을 넣기위해 재귀호출
    }
    return;
  }
}
