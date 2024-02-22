package algorithm.test.baekjoon.level19.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = "-";
    StringBuffer bf = new StringBuffer();
    StringBuilder sb = new StringBuilder();
    while (true) {
      int n = Integer.parseInt(scanner.nextLine());
      for (int i = 0; i < Math.pow(3, n); i++) {
        sb.append(str);
      }
      System.out.println(calc(sb));
      break;
    }
  }

  static StringBuilder calc(StringBuilder sb) {
    int n = (sb.length() / 3);

    return sb;
  }
}
