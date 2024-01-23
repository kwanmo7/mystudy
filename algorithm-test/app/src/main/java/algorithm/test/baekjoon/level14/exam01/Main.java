package algorithm.test.baekjoon.level14.exam01;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    HashSet<Integer> hs = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
      hs.add(scanner.nextInt());
    }
    int m = scanner.nextInt();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      if (hs.contains(scanner.nextInt())) {
        sb.append("1 ");
      } else {
        sb.append("0 ");
      }
    }
    System.out.println(sb);
    scanner.close();
  }
}
