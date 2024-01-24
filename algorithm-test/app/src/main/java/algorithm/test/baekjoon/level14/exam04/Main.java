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
    for (int i = 1; i <= n; i++) {
      map.put(i, scanner.nextLine());
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      String input = scanner.nextLine();
      char chk = input.charAt(0);
      if (chk > 64 && chk < 91) {
        // sb.append(entry.getKey() + "\n");
      } else if (chk > 47 && chk < 58) {
        // sb.append(entry.getValue() + "\n");
      }
    }
    System.out.print(sb);
    scanner.close();
  }
}
