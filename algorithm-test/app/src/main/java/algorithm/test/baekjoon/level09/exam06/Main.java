package algorithm.test.baekjoon.level09.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    int i = 2;
    while (input > 1) {
      if (input % i == 0) {
        input /= i;
        System.out.println(i);
      } else {
        i++;
      }
    }
    scanner.close();
  }
}
