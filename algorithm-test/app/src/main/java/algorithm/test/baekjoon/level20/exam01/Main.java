package algorithm.test.baekjoon.level20.exam01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static int[] arr;
  static boolean[] chk;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    arr = new int[m];
    chk = new boolean[n + 1];

    calc(n, m, 0);
    bw.flush();
    br.close();
    bw.close();
  }

  static void calc(int n, int m, int strt) throws IOException {
    if (strt == m) { // 재귀호출시 arr에 숫자를 모두 담았을때
      for (int out : arr) {
        bw.write(out + " "); // 출력
      }
      bw.newLine();
      return; // arr의 배열에 담은 것을 출력했으므로 이전 상태로 리턴 --> 44번째 Line으로 이동
    }

    for (int i = 1; i <= n; i++) {
      if (!chk[i]) {
        chk[i] = true;
        arr[strt] = i; // 배열에 숫자 담기
        calc(n, m, strt + 1); // 재귀 호출 / 가장 처음 arr 0번째에 넣고 그다음 1번째 ... arr의 길이만큼 호출
        chk[i] = false; // 백트래킹 (재귀 호출이 끝난뒤 원래 상태로 되돌림)
      }
    }
    return;
  }
}
