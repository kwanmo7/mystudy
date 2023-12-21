package algorithm.test.baekjoon.level08.exam02;

import java.util.Scanner;

public class Main {
  static char[] arr =
      {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
          'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    int a = scanner.nextInt();
    int conv = 0;
    StringBuffer aa = new StringBuffer();
    while (a <= input) {
      conv = input % a;
      input /= a;
      aa.append(arr[conv]);
    }
    aa.append(arr[input]);
    aa.reverse();
    System.out.println(aa);
    scanner.close();
  }
}
