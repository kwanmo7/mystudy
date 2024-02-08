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
        deque.remove(temp); // 오른쪽 이동의 경우 값을 하나 없앤 시점에서 오른쪽으로 한칸 이동한 것과 같다
        for (int j = 1; j < k; j++) {
          deque.offer(deque.poll());
        }
        temp = deque.peek();
      } else {
        deque.remove(temp);
        for (int j = 0; j > k; j--) {
          deque.offerFirst(deque.pollLast());
        }
        temp = deque.peek();
      }
    }
    sb.append(deque.peek());
    System.out.print(sb);
    scanner.close();
  }
}
