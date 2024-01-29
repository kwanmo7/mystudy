package algorithm.test.baekjoon.level15.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = Integer.parseInt(scanner.nextLine().trim());
    for (int i = n; i <= m; i++) {
      boolean chk = true;
      if (i < 2) {
        continue;
      }
      for (int j = 2; j * j <= i; j++) {
        if ((i % j) == 0) {
          chk = false;
          break;
        }
      }
      if (chk == true) {
        System.out.println(i);
      }
    }
    scanner.close();
  }
}
