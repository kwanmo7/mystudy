package algorithm.test.baekjoon.level01.exam10;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String a = scanner.nextLine();
    String b = scanner.nextLine();

    int c = Integer.parseInt(a);
    int d = Integer.parseInt(b.substring(2, 3));
    System.out.println(c * d);
    d = Integer.parseInt(b.substring(1, 2));
    System.out.println(c * d);
    d = Integer.parseInt(b.substring(0, 1));
    System.out.println(c * d);
    System.out.println(c * (Integer.parseInt(b)));
    scanner.close();
  }
}
