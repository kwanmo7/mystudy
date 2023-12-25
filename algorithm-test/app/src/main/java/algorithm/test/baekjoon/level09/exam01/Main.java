package algorithm.test.baekjoon.level09.exam01;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] arr = {"factor", "multiple", "neither"};
    while (true) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      if (a == 0 && b == 0) {
        break;
      }
      if (a % b == 0) {
        System.out.println(arr[1]);
      } else if (b % a == 0) {
        System.out.println(arr[0]);
      } else {
        System.out.println(arr[2]);
      }
    }
    scanner.close();
  }
}
