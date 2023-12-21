package algorithm.test.baekjoon.level08.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    int cnt = 1;
    int begin = 2;
    int end = 7;
    int i = 1;
    while (true) {
      if (input == 1) {
        break;
      }
      if (begin <= input && input <= end) {
        cnt++;
        break;
      }
      begin += (6 * i);
      end += (6 * (i + 1));
      cnt++;
      i++;
    }
    System.out.println(cnt);
    scanner.close();
  }
}
