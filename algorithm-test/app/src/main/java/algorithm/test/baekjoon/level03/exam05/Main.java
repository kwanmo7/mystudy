package algorithm.test.baekjoon.level03.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    for (int i = 1; i <= a; i++) {
      if (i % 4 == 0) {
        System.out.print("long ");
      }
    }
    System.out.print("int");
    scanner.close();
  }
}
