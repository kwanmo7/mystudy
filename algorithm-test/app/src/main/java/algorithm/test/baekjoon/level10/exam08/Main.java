package algorithm.test.baekjoon.level10.exam08;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] arr = new int[3];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scanner.nextInt();
    }
    int rlt = calc(arr);
    System.out.println(rlt);
    scanner.close();
  }

  static int calc(int[] arr) {
    int max = arr[0];
    int sum = arr[1] + arr[2];
    if (arr[0] == arr[1] && arr[0] == arr[2]) {
      return arr[0] * 3;
    } else if ((arr[0] == arr[1] && arr[0] != arr[2]) || (arr[0] == arr[2] && arr[0] != arr[1])
        || (arr[1] == arr[2] && arr[1] != arr[0])) {
      if (max < arr[1]) {
        max = arr[1];
        sum = arr[0] + arr[2];
      }
      if (max < arr[2]) {
        max = arr[2];
        sum = arr[0] + arr[1];
      }

      if (max >= sum) {
        max = sum - 1;
        return max + sum;
      }
      return arr[0] + arr[1] + arr[2];
    }
    if (max < arr[1]) {
      max = arr[1];
      sum = arr[0] + arr[2];
    }
    if (max < arr[2]) {
      max = arr[2];
      sum = arr[0] + arr[1];
    }
    if (max >= sum) {
      max = sum - 1;
      return max + sum;
    }
    return max + sum;
  }
}
