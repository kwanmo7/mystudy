package algorithm.test.baekjoon.level21.exam01;

import java.util.Scanner;

public class Main {

  static int rlt1 = 0;

  static int rlt2 = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    fib(n);
    fibonacci(n);

    System.out.printf("%s %s", rlt1, rlt2);

  }

  private static int fib(int n) {
    if (n == 1 || n == 2) {
      rlt1++;
      return 1;
    } else {
      return (fib(n - 1) + fib(n - 2));
    }
  }

  private static int fibonacci(int n) {
    int[] f = new int[n + 1];
    f[1] = 1;
    f[2] = 1;

    for (int i = 3; i <= n; i++) {
      f[i] = f[i - 1] + f[i - 2];
      rlt2++;
    }
    return f[n];
  }
}
