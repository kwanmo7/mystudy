package algorithm.test.baekjoon.level06.exam03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    scanner.close();
    for (int i = 1; i <= a; i++) {
      for (int j = a; i < j; j--) {
        System.out.print(" ");
      }
      for (int j = 0; j < i * 2 - 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    for (int i = a - 1; 1 <= i; i--) {
      for (int j = a; i < j; j--) {
        System.out.print(" ");
      }
      for (int j = 0; j < i * 2 - 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
