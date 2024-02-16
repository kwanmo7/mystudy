package algorithm.test.baekjoon.level17.exam04;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    StringTokenizer st = new StringTokenizer(scanner.nextLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = 1;
    for (int i = 1; i <= n; i++) {
      if (i <= n - m) {
        continue;
      }
      k *= i;
    }
    for (int i = 1; i <= m; i++) {
      k /= i;
    }
    System.out.println(k);
    scanner.close();
  }
}
