package algorithm.test.baekjoon.level09.exam03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      int input = scanner.nextInt();
      if (input == -1) {
        break;
      }
      int temp = 0;
      for (int i = 1; i < input; i++) {
        if (input % i == 0) {
          temp += i;
        }
      }

      if (temp != input) {
        System.out.printf("%d is NOT perfect.\n", input);
      } else {
        System.out.printf("%d = 1 ", input);
        for (int i = 2; i < input; i++) {
          if (input % i == 0) {
            System.out.printf("+ %d ", i);
          }
          if (i == input - 1) {
            System.out.println();
          }
        }
      }
    }
    scanner.close();
  }
}
