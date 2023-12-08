package algorithm.test.baekjoon.level03.exam12;

import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args)
      throws IOException, NumberFormatException, NullPointerException {
    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNext()) {
      String a = scanner.next();
      String b = scanner.next();
      int sum = Integer.parseInt(a) + Integer.parseInt(b);
      System.out.println(sum);
      // if (a.isEmpty() || b.isEmpty()) {
      // break;
      // }
    }
    scanner.close();
  }
}
