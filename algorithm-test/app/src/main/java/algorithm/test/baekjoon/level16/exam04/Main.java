package algorithm.test.baekjoon.level16.exam04;

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    while (true) {
      String str = scanner.nextLine();
      if (str.charAt(0) == '.') {
        break;
      }

      sb.append(chk(str) + "\n");
    }
    System.out.print(sb);
    scanner.close();
  }

  static String chk(String input) {
    if (!input.endsWith(".")) {
      return "no";
    }
    Stack<String> stack = new Stack<String>();
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '(' || input.charAt(i) == '[') {
        stack.push(String.valueOf(input.charAt(i)));
      } else if (stack.isEmpty() && (input.charAt(i) == ')' || input.charAt(i) == ']')) {
        return "no";
      } else if (!stack.isEmpty() && ((stack.peek().equals("(") && input.charAt(i) == ')')
          || (stack.peek().equals("[") && input.charAt(i) == ']'))) {
        stack.pop();
      } else if (!stack.isEmpty() && ((stack.peek().equals("(") && input.charAt(i) == ']')
          || (stack.peek().equals("[") && input.charAt(i) == ')'))) {
        return "no";
      }
    }
    if (!stack.isEmpty()) {
      return "no";
    }
    return "yes";
  }
}
