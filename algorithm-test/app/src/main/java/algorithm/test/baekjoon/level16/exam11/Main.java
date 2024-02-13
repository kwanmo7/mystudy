package algorithm.test.baekjoon.level16.exam11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main { // 24511번 queuestack
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    Deque<Integer> deque = new ArrayDeque<Integer>();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken()); // queuestack 구조 정보 0 - queue , 1 - stack
    }
    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      int temp = Integer.parseInt(st2.nextToken());
      if (arr[i] == 0) { // queue 구조일때만 deque에 값을 담아줌
        deque.offer(temp);
      }
    }

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");
    for (int k = 0; k < m; k++) {
      int value = Integer.parseInt(st.nextToken());
      deque.offerFirst(value); // deque에 가장 앞에 넣고 가장 뒤에것을 출력
      bw.write(deque.pollLast() + " ");
    }
    br.close();
    bw.flush();
    bw.close();
  }
}
