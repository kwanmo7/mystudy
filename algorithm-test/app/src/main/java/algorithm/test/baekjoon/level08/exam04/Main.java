package algorithm.test.baekjoon.level08.exam04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    int cnt = 2;
    int calc = (int) Math.pow(cnt, input);
    calc++;
    System.out.println(calc * calc);
    scanner.close();
  }
}
