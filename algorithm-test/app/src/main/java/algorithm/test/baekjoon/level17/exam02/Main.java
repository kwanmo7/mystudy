package algorithm.test.baekjoon.level17.exam02;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    System.out.println((int) Math.pow(2, n));
    scanner.close();
  }
}
