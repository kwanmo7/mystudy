package algorithm.test.baekjoon.level16.exam06;

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    Stack<Integer> stack = new Stack<Integer>();

    for (int i = 0; i < n; i++) {
      String[] str = scanner.nextLine().split(" ");
      if (str[0].equals("push")) {
        stack.push(Integer.parseInt(str[1]));
      } else if (str[0].equals("pop")) {
        if (stack.isEmpty()) {
          System.out.println(-1);
        } else {
          System.out.println(stack.remove(stack.get(0)));
        }
      } else if (str[0].equals("size")) {
        System.out.println(stack.size());
      } else if (str[0].equals("empty")) {
        if (stack.isEmpty()) {
          System.out.println(1);
        } else {
          System.out.println(0);
        }
      } else if (str[0].equals("front")) {
        if (stack.isEmpty()) {
          System.out.println(-1);
        } else {
          System.out.println(stack.get(0));
        }
      } else if (str[0].equals("back")) {
        if (stack.isEmpty()) {
          System.out.println(-1);
        } else {
          System.out.println(stack.peek());
        }
      }
    }
    scanner.close();
  }
}
