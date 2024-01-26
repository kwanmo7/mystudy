package algorithm.test.baekjoon.level15.exam01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < n; i++) {
      int m = scanner.nextInt();
      int k = Integer.parseInt(scanner.nextLine().trim());
      System.out.println(calc(m, k));
    }
    scanner.close();
  }

  static int calc(int a, int b) {
    if (a == 1 || b == 1) {
      return a * b;
    }
    HashSet<Integer> hm = new HashSet<Integer>();
    for (int i = 1; i <= a; i++) {
      if (a % i == 0) {
        hm.add(i);
      }
    }
    Iterator<Integer> it = hm.iterator();
    int rlt = a * b;
    while (it.hasNext()) {
      int bb = it.next();
      int temp = bb * b;
      if (temp % a == 0) {
        if (rlt > temp) {
          rlt = temp;
        }
      }
    }
    return rlt;
  }
}
