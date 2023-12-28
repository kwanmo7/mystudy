package algorithm.test.baekjoon.level11.exam04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    long sum = 0;
    for (int i = 1; i <= a - 1; i++) {
      for (int j = i + 1; j < a; j++) {
        sum++;
      }
      sum++;
    }
    System.out.println(sum);
    System.out.println(2);
    scanner.close();
  }
}
