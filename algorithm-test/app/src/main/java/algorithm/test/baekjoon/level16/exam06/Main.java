package algorithm.test.baekjoon.level16.exam06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      // scanner & 배열로 입력값을 받는 것보다 버퍼와 token으로 받는것이 더 빠르다
      // 배열에 split으로 받는 것이 시간을 더 오래 걸리게함
      StringTokenizer token = new StringTokenizer(br.readLine(), " ");
      switch (token.nextToken()) {
        case "push":
          queue.offer(Integer.parseInt(token.nextToken()));
          break;
        case "pop":
          if (queue.isEmpty()) {
            bw.write("-1\n");
          } else {
            bw.write(queue.poll() + "\n");
          }
          break;
        case "size":
          bw.write(queue.size() + "\n");
          break;
        case "empty":
          if (queue.isEmpty()) {
            bw.write("1\n");
          } else {
            bw.write("0\n");
          }
          break;
        case "front":
          if (queue.isEmpty()) {
            bw.write("-1\n");
          } else {
            bw.write(queue.peek() + "\n");
          }
          break;
        case "back":
          if (queue.isEmpty()) {
            bw.write("-1\n");
          } else {
            bw.write(queue.peekLast() + "\n");
          }
          break;
      }
    }
    br.close();
    bw.flush();
    bw.close();
  }
}
