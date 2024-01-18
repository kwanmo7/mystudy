package algorithm.test.baekjoon.level12.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int cnt = scanner.nextInt();
    int rlt = 0;
    int num = 666;
    while (true) {
      if (calc(num) == 1) {
        rlt++;
      }
      if (rlt == cnt) {
        break;
      }
      num++;
    }
    System.out.println(num);
    scanner.close();
    /*
     * 666 1666 2666 3666 4666 5666 6660 6661 6662 6663 6664 6665 6666 6667 6668 6669 7666 8666 9666
     * 10666 11666 12666 13666 14666 15666 16660 16661 16662 16663 16664 16665 16666 16667 16668
     * 16669 17666 18666 19666
     */
  }

  static int calc(int n) {
    int i = 1;
    do {
      if ((n / i) - (n / (i * 1000)) * 1000 == 666) {
        return 1;
      }
      i *= 10;
    } while (n / i != 0);

    return 0;
  }
}
