package algorithm.test.baekjoon.level05.exam08;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    char[] input = scanner.nextLine().toCharArray();
    int cnt = 1;
    if (input[0] == 0x20) {
      cnt--;
    }
    if (input[input.length - 1] == 0x20) {
      cnt--;
    }
    for (int i = 0; i < input.length; i++) {
      if (input[i] == 0x20) {
        cnt++;
      }
    }
    System.out.println(cnt);
    scanner.close();
  }
}
