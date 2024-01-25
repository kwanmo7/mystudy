package algorithm.test.baekjoon.level14.exam06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = Integer.parseInt(scanner.nextLine().trim());
    HashSet<String> hs = new HashSet<String>();
    for (int i = 0; i < n; i++) {
      hs.add(scanner.nextLine());
    }
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < m; i++) {
      String input = scanner.nextLine();
      if (hs.contains(input)) {
        list.add(input);
      }
    }
    Collections.sort(list);
    System.out.println(list.size());
    list.forEach(item -> System.out.println(item));
    scanner.close();
  }
}
