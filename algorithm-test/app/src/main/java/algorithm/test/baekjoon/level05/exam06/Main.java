package algorithm.test.baekjoon.level05.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    char[] input = scanner.nextLine().toCharArray();
    for (int i = 97; i <= 122; i++) {
      for (int j = 0; j < input.length; j++) {
        if (input[j] == i) {
          System.out.printf("%s ", j);
          break;
        }
        if (j == input.length - 1) {
          System.out.print("-1 ");
        }
      }
    }
    scanner.close();
  }
}
