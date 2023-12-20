package algorithm.test.baekjoon.level08.exam01;

import java.util.Scanner;

public class Main {
  static char[] arr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
      'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();
    int a = scanner.nextInt();
    int rlt = 1;

    for (int i = 0; i < input.length(); i++) {
      rlt *= convert(input.charAt(i), a);
    }

    System.out.println(rlt - 1);
    scanner.close();
  }

  static int convert(char input, int a) {
    for (int i = 0; i < arr.length; i++) {
      if (input == arr[i]) {
        return i + 11;
      }
    }
    return input;
  }
}
