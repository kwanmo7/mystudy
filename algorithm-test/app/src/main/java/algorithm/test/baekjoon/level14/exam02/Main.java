package algorithm.test.baekjoon.level14.exam02;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = Integer.parseInt(scanner.nextLine().trim());
    HashSet<String> hs = new HashSet<String>();
    for (int i = 0; i < n; i++) {
      hs.add(scanner.nextLine());
    }
    int rlt = 0;
    for (int i = 0; i < m; i++) {
      if (hs.contains(scanner.nextLine())) {
        rlt++;
      }
    }
    System.out.println(rlt);
    scanner.close();
  }
}
