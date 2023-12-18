package algorithm.test.baekjoon.level06.exam07;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = Integer.parseInt(scanner.nextLine());
    int rlt = 0;
    for (int i = 0; i < a; i++) {
      String input = scanner.nextLine();
      rlt += chk(input);
    }
    System.out.println(rlt);
    scanner.close();
  }

  static int chk(String input) {
    char[] temp = new char[input.length()];
    int index = 0;
    temp[0] = input.charAt(0);
    for (int i = 0; i < input.length(); i++) {
      if (temp[index] != input.charAt(i)) {
        temp[index + 1] = input.charAt(i);
        index++;
      }
    }
    for (int i = 0; i <= index; i++) {
      for (int j = i + 1; j <= index; j++) {
        if (temp[i] == temp[j]) {
          return 0;
        }
      }
    }
    return 1;
  }
}
