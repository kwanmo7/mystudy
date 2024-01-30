package algorithm.test.baekjoon.level16.exam02;

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < n; i++) {
      int in = Integer.parseInt(scanner.nextLine());
      if (in != 0) {
        stack.push(in);
      } else {
        stack.pop();
      }
    }
    int sum = 0;
    while (!stack.isEmpty()) {
      sum += stack.pop();
    }
    System.out.println(sum);
    scanner.close();
  }
}
