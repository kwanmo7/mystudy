package algorithm.test.baekjoon.level05.exam10;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    String[] dial = {" ", " ", " ", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
    int time = 0;
    for (int i = 0; i < input.length(); i++) {
      char temp = input.charAt(i);
      for (int j = 0; j < dial.length; j++) {
        if (compare(dial[j], temp)) {
          time += j;
        }
      }
    }
    System.out.println(time);
  }

  static boolean compare(String str, char ch) {
    char[] cmp = str.toCharArray();
    for (int i = 0; i < cmp.length; i++) {
      if (cmp[i] == ch) {
        return true;
      }
    }
    return false;
  }
}
