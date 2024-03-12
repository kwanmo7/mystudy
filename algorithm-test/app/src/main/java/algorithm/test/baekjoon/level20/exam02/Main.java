package algorithm.test.baekjoon.level20.exam02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static int[] arr;
  static int n;
  static int m;

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[m];
    calc(1, 0);
    bw.flush();
  }

  static void calc(int at, int cursor) throws IOException {
    if (cursor == m) { // arr에 값이 다 들어갔을때 출력
      for (int rlt : arr) {
        bw.write(rlt + " ");
      }
      bw.newLine();
      return;
    }

    for (int i = at; i <= n; i++) { // 파라미터로 받은 at으로 값의 중복이 발생하지 않음
      arr[cursor] = i;
      calc(i + 1, cursor + 1); // arr[1]에 값을 넣기 위해 재귀호출
    }
    return;
  }
}
