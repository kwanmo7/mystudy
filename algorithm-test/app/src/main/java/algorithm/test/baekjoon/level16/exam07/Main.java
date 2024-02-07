package algorithm.test.baekjoon.level16.exam07;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
    for (int i = 1; i <= n; i++) {
      queue.offer(i);
    }

    while (queue.size() > 1) {
      queue.poll();
      queue.offerLast(queue.poll());
    }
    System.out.println(queue.peek());
    scanner.close();
  }
}
