package algorithm.test.baekjoon.level16.exam03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < n; i++) {
      String str = scanner.nextLine();
      int chk = 0;
      if (str.charAt(0) == ')' || str.charAt(str.length() - 1) == '(') {
        sb.append("NO\n");
        continue;
      } else {
        for (int j = 0; j < str.length(); j++) {
          if (str.charAt(j) == '(') {
            chk++;
          } else {
            chk--;
          }
          if (chk < 0) {
            break;
          }
        }
        if (chk == 0) {
          sb.append("YES\n");
        } else {
          sb.append("NO\n");
        }
      }
    }
    System.out.print(sb);
    scanner.close();
  }
}
