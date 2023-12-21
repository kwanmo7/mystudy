package algorithm.test.baekjoon.level08.exam01;

import java.util.Scanner;

public class Main {
  static char[] arr =
      {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
          'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();
    int a = scanner.nextInt();
    int rlt = 0;
    int pow = input.length() - 1;
    int conv = 0;
    for (int i = 0; i < input.length(); i++) {
      conv = convert(input.charAt(i));
      rlt += (conv * Math.pow(a, pow));
      pow--;
    }
    System.out.println(rlt);
    scanner.close();
  }

  static int convert(char input) {
    for (int i = 0; i < arr.length; i++) {
      if (input == arr[i]) {
        return i;
      }
    }
    return input;
  }
}
