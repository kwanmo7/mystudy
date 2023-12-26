package algorithm.test.baekjoon.level09.exam04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int cnt = 0;
    int[] arr = new int[a];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scanner.nextInt();
      cnt += chk(arr[i]);
    }
    scanner.close();
    System.out.println(cnt);
  }

  static int chk(int input) {
    if (input < 2) {
      return 0;
    }
    for (int i = 2; i * i <= input; i++) {
      if (input % i == 0) { // 소수가 아니므로 리턴 0
        return 0;
      }
    }
    return 1;
  }
}
