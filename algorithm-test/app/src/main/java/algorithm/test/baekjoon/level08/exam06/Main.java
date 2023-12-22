package algorithm.test.baekjoon.level08.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    int[] arr = {1, 1};
    StringBuffer buf = new StringBuffer();
    int begin = 1;
    int end = 2;
    int cnt = 1;
    for (int i = begin; i < input; i++) {
      begin = begin + i;
      end = begin + i;
      if (begin <= input && input <= end) {
        cnt += i + 1;
        break;
      }
    }
    boolean chk = false;
    if (input != 1) {
      if (cnt % 2 == 0) {
        arr[0] = cnt - 1;
        arr[1] = 1;
        chk = true;
      } else {
        arr[0] = 1;
        arr[1] = cnt - 1;
      }
    }

    for (int i = begin; i < input; i++) {
      if (chk) {
        arr[0]--;
        arr[1]++;
      } else {
        arr[0]++;
        arr[1]--;
      }
    }

    buf.append(arr[0] + "/" + arr[1]);
    System.out.println(buf);
    scanner.close();
  }
}
