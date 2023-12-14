package algorithm.test.baekjoon.level05.exam01;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();
    int i = scanner.nextInt();

    System.out.print(input.charAt(i - 1));
    scanner.close();
  }
}
