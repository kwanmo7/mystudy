package algorithm.test.baekjoon.level16.exam10;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    StringTokenizer st = new StringTokenizer(scanner.nextLine(), " ");
    ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    for (int i = 1; i <= n; i++) {
      int m = Integer.parseInt(st.nextToken());
      deque.offer(i);
      hm.put(i, m);
    }
    StringBuilder sb = new StringBuilder();
    int temp = 1;
    for (int i = 0; i < n - 1; i++) {
      int k = hm.get(temp);
      sb.append(temp + " ");
      if (k > 0) {
        for (int j = 0; j < k; j++) {
          deque.offer(deque.poll());
        }
        deque.remove(temp);
        temp = deque.peek();
      } else {
        for (int j = 0; j > k; j--) {
          deque.offerFirst(deque.pollLast());
        }
        deque.remove(temp);
        temp = deque.peek();
      }
    }
    sb.append(deque.peek());
    System.out.print(sb);
    scanner.close();
  }
}
// 반례 - https://www.acmicpc.net/board/view/127751
