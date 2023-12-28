package algorithm.test.baekjoon.level11.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    long sum = 0;
    for (int i = 1; i <= a - 2; i++) {
      for (int j = i + 1; j <= a - 1; j++) {
        for (int k = j + 1; k <= a; k++) {
          sum++;
        }
      }
    }
    System.out.println(sum);
    System.out.println(3);
    scanner.close();
  }
}
