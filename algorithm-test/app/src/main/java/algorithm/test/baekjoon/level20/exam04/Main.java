package algorithm.test.baekjoon.level20.exam04;

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

    br.close();
    bw.close();
  }

  private static void calc(int at, int cursor) throws IOException {
    if (cursor == m) {
      for (int i : arr) {
        bw.write(i + " ");
      }
      bw.newLine();
      bw.flush();
      return;
    }

    for (int i = at; i <= n; i++) {
      arr[cursor] = i;
      calc(i, cursor + 1);
    }
    return;
  }
}
