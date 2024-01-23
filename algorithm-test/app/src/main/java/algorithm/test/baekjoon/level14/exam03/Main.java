package algorithm.test.baekjoon.level14.exam03;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    HashMap<String, String> hm = new HashMap<String, String>();
    for (int i = 0; i < n; i++) {
      String[] str = scanner.nextLine().split(" ");
      hm.put(str[0], str[1]);
    }

  }
}
