package algorithm.test.baekjoon.level06.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    int chk = input.length();
    int rlt = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == 'c' && i != input.length() - 1) {
        rlt = chk1(input.charAt(i + 1));
        chk -= rlt;
        chk++;
        if (rlt == 2) {
          i++;
        }
      } else if (input.charAt(i) == 'j' && i != 0) {
        chk -= chk2(input.charAt(i - 1));
        chk++;
      } else if (input.charAt(i) == '=' && i != 0) {
        chk -= chk3(input, i);
        chk++;
      } else if (input.charAt(i) == 'd' && i != input.length() - 1) {
        rlt = chk4(input.charAt(i + 1));
        chk -= rlt;
        chk++;
        if (rlt == 2) {
          i++;
        }
      }
    }
    System.out.println(chk);
    scanner.close();
  }

  static int chk1(char input) {
    if (input == '=' || input == '-') {
      return 2;
    }
    return 1;
  }

  static int chk2(char input) {
    if (input == 'l' || input == 'n') {
      return 2;
    }
    return 1;
  }

  static int chk3(String input, int i) {
    if (i >= 1 && input.substring(i - 1, i + 1).equals("s=")) {
      return 2;
    } else if (i >= 1 && input.substring(i - 1, i + 1).equals("z=")) {
      if (i >= 2 && input.substring(i - 2, i + 1).equals("dz=")) {
        return 3;
      }
      return 2;
    }
    return 1;
  }

  static int chk4(char input) {
    if (input == '-') {
      return 2;
    }
    return 1;
  }
}
