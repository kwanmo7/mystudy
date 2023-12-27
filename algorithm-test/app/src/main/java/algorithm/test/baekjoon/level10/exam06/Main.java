package algorithm.test.baekjoon.level10.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] output = {"Equilateral", "Isosceles", "Scalene", "Error"};
    int[] arr = new int[3];
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scanner.nextInt();
      sum += arr[i];
    }
    if (sum == 180) {
      if (arr[0] == arr[1] && arr[0] == arr[2]) {
        System.out.println(output[0]);
      } else if ((arr[0] == arr[1] && arr[0] != arr[2]) || (arr[1] == arr[2] && arr[1] != arr[0])
          || (arr[0] == arr[2] && arr[0] != arr[1])) {
        System.out.println(output[1]);
      } else if (arr[0] != arr[1] && arr[0] != arr[2] && arr[1] != arr[2]) {
        System.out.println(output[2]);
      }
    } else {
      System.out.println(output[3]);
    }
    scanner.close();
  }
}
