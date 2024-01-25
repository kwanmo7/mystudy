package algorithm.test.baekjoon.level14.exam08;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    HashSet<String> hs = new HashSet<String>();
    for (int i = 0; i < input.length(); i++) {
      for (int j = i + 1; j <= input.length(); j++) {
        String str = input.substring(i, j);
        if (hs.contains(str)) {
          continue;
        }
        hs.add(str);
      }
    }
    System.out.println(hs.size());
    scanner.close();
  }
}
