package algorithm.test.baekjoon.level14.exam04;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = Integer.parseInt(scanner.nextLine().trim());
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    HashMap<String, Integer> map2 = new HashMap<String, Integer>();
    for (int i = 1; i <= n; i++) {
      String in = scanner.nextLine();
      map.put(i, in);
      map2.put(in, i);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      String input = scanner.nextLine();
      char chk = input.charAt(0);
      if (chk > 64 && chk < 91) {
        sb.append(map2.get(input) + "\n");
      } else if (chk > 47 && chk < 58) {
        sb.append(map.get(Integer.parseInt(input)) + "\n");
      }
    }
    System.out.print(sb);
    scanner.close();
  }
}
