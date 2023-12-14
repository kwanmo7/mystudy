package algorithm.test.baekjoon.level05.exam03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < a; i++) {
      String input = scanner.nextLine();
      if (input.charAt(0) >= 65 && input.charAt(0) <= 90) {
        System.out.printf("%s%s\n", input.charAt(0), input.charAt(input.length() - 1));
      }
    }
    scanner.close();
  }
}
