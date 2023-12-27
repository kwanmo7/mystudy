package algorithm.test.baekjoon.level10.exam07;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] output = {"Equilateral", "Isosceles", "Scalene", "Invalid"};
    while (true) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int c = scanner.nextInt();
      if (a == 0 && b == 0 && c == 0) {
        break;
      }
      int rlt = chk(a, b, c);
      System.out.println(output[rlt]);
    }
    scanner.close();
  }

  static int chk(int a, int b, int c) {
    int max = a;
    int sum = b + c;
    if (max < b) {
      max = b;
      sum = a + c;
    }
    if (max < c) {
      max = c;
      sum = a + b;
    }
    if (max >= sum) {
      return 3;
    }

    if (a == b && a == c) {
      return 0;
    } else if ((a == b && a != c) || (a == c && a != b) || (b == c && b != a)) {
      return 1;
    } else if (a != b && b != c && a != c) {
      return 2;
    }
    return 0;
  }
}
