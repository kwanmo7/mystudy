package algorithm.test.baekjoon.level16.exam01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < n; i++) {
      String[] str = br.readLine().split(" ");
      switch (str[0]) {
        case "1":
          for (int k = 1; k < str.length; k++) {
            stack.push(Integer.parseInt(str[k])); // 스택에 값 넣기
          }
          break;
        case "2":
          if (!stack.isEmpty()) {
            bw.write(stack.pop() + "\n"); // 스택의 가장 위의 값을 꺼내오기(스택에서 값이 빠짐)
          } else {
            bw.write("-1\n");
          }
          break;
        case "3":
          bw.write(stack.size() + "\n");
          break;
        case "4":
          if (stack.isEmpty()) {
            bw.write("1\n");
          } else {
            bw.write("0\n");
          }
          break;
        case "5":
          if (!stack.isEmpty()) {
            bw.write(stack.peek() + "\n"); // 스택의 가장 위의 값 가져오기
          } else {
            bw.write("-1\n");
          }
          break;
        default:
      }
    }
    bw.flush();
    br.close();
    bw.close();
  }
}
