package algorithm.test.baekjoon.level05.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = Integer.parseInt(scanner.nextLine());
    int sum = 0;
    char[] input = scanner.nextLine().toCharArray();
    for (int i = 0; i < a; i++) {
      sum += (input[i] - 48);
    }
    System.out.print(sum);
    scanner.close();
  }
}
