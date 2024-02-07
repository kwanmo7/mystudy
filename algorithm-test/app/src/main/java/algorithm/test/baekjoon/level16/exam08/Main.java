package algorithm.test.baekjoon.level16.exam08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
    for (int i = 1; i <= n; i++) {
      queue.offer(i);
    }
    bw.write("<");
    int m = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < m - 1; j++) {
        queue.offerLast(queue.poll());
      }
      bw.write(queue.poll() + ", ");
    }
    bw.write(queue.poll() + ">");
    bw.flush();
    br.close();
    bw.close();
  }
}
