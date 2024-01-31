package algorithm.test.baekjoon.level16.exam04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    while (true) {
      String str = scanner.nextLine();
      if (str.charAt(0) == '.') {
        break;
      }
      sb.append(chk(str) + "\n");
    }
    System.out.print(sb);
    scanner.close();
  }

  static String chk(String input) {
    int smallchk = 0;
    int bigchk = 0;

    for (int i = 0; i < input.length(); i++) {
      char comp1 = 0;
      char comp2 = 0;
      if (i != 0 && i < input.length() - 2) {
        comp1 = input.charAt(i - 1);
        comp2 = input.charAt(i + 1);
      }
      if (input.charAt(i) == '(') {
        if (i != 0 && i < (input.length() - 2)
            && (comp1 != '(' || comp1 != ')' || comp2 != '[' || comp2 != ']') && comp1 != ' '
            && comp2 != ' ') {
          return "no";
        }
        smallchk++;
      } else if (input.charAt(i) == ')') {
        if (i != 0 && i < (input.length() - 2)
            && (comp1 != '(' || comp1 != ')' || comp2 != '[' || comp2 != ']') && comp1 != ' '
            && comp2 != ' ') {
          return "no";
        }
        smallchk--;
      } else if (input.charAt(i) == '[') {
        if (i != 0 && i < (input.length() - 2)
            && (comp1 != '(' || comp1 != ')' || comp2 != '[' || comp2 != ']') && comp1 != ' '
            && comp2 != ' ') {
          return "no";
        }
        bigchk++;
      } else if (input.charAt(i) == ']') {
        if (i != 0 && i < (input.length() - 2)
            && (comp1 != '(' || comp1 != ')' || comp2 != '[' || comp2 != ']') && comp1 != ' '
            && comp2 != ' ') {
          return "no";
        }
        bigchk--;
      }
      if (smallchk < 0 || bigchk < 0) {
        return "no";
      }
    }
    System.out.println(smallchk);
    System.out.println(bigchk);
    return "yes";
  }
}
