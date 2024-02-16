package algorithm.test.baekjoon.level17.exam03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    int rlt = 1;
    for (int i = 1; i <= n; i++) {
      rlt *= i;
    }
    System.out.println(rlt);
    scanner.close();
  }
}
