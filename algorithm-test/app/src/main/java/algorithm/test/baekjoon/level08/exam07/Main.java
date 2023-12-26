package algorithm.test.baekjoon.level08.exam07;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int v = scanner.nextInt();
    int rlt = 0;
    if (v != a) {
      v = v - b;
      int temp = a - b;
      rlt = v / temp;
      if (v % temp != 0) {
        rlt++;
      }
    } else {
      rlt = 1;
    }
    System.out.println(rlt);
    scanner.close();
  }
}
