package algorithm.test.baekjoon.level16.exam05;

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }
    System.out.println(func(arr));
    scanner.close();
  }

  static String func(int[] arr) {
    Stack<Integer> stack = new Stack<Integer>();
    int cnt = 1;
    int cursor = 1;
    stack.push(arr[0]);
    while (cursor < arr.length - 1) {
      if (!stack.isEmpty() && stack.peek() == cnt) {
        stack.pop();
        cnt++;
        continue;
      }
      if (cnt == arr[cursor]) {
        cnt++;
        cursor++;
        continue;
      }
      if (stack.isEmpty()) {
        stack.push(arr[cursor]);
      }
      if (!stack.isEmpty() && stack.peek() > arr[cursor]) {
        stack.push(arr[cursor]);
      }
      if (!stack.isEmpty() && stack.peek() < arr[cursor]) {
        return "Sad";
      }
      cursor++;
    }
    return "Nice";
  }
}
