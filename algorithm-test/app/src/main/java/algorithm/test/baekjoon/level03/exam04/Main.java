package algorithm.test.baekjoon.level03.exam04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextLong();
    int b = scanner.nextInt();
    long sum = 0;
    for (int i = 0; i < b; i++) {
      int c = scanner.nextInt();
      int d = scanner.nextInt();
      sum += (c * d);
    }
    if (a == sum) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
    scanner.close();
  }
}
