package algorithm.test.baekjoon.level16.exam09;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(scanner.nextLine(), " ");
      switch (Integer.parseInt(st.nextToken())) {
        case 1:
          deque.offerFirst(Integer.parseInt(st.nextToken()));
          break;
        case 2:
          deque.offerLast(Integer.parseInt(st.nextToken()));
          break;
        case 3:
          if (deque.isEmpty()) {
            sb.append("-1\n");
          } else {
            sb.append(deque.pollFirst() + "\n");
          }
          break;
        case 4:
          if (deque.isEmpty()) {
            sb.append("-1\n");
          } else {
            sb.append(deque.pollLast() + "\n");
          }
          break;
        case 5:
          sb.append(deque.size() + "\n");
          break;
        case 6:
          if (deque.isEmpty()) {
            sb.append("1\n");
          } else {
            sb.append("0\n");
          }
          break;
        case 7:
          if (deque.isEmpty()) {
            sb.append("-1\n");
          } else {
            sb.append(deque.peekFirst() + "\n");
          }
          break;
        case 8:
          if (deque.isEmpty()) {
            sb.append("-1\n");
          } else {
            sb.append(deque.peekLast() + "\n");
          }
          break;
      }
    }
    System.out.print(sb);
    scanner.close();
  }
}
