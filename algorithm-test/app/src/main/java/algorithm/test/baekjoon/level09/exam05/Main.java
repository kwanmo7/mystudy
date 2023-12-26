package algorithm.test.baekjoon.level09.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int[] arr = new int[2];
    for (int i = a; i <= b; i++) {
      int temp = chk(i);
      if (temp > 0) {
        arr[0] += temp;
      }
      if (arr[1] == 0) {
        arr[1] = temp;
      } else if (arr[1] > temp && temp != 0) {
        arr[1] = temp;
      }
    }
    if (arr[0] == 0 && arr[1] == 0) {
      System.out.println(-1);
    } else {
      System.out.println(arr[0]);
      System.out.println(arr[1]);
    }
    scanner.close();
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
    return input;
  }
}
