package algorithm.test.baekjoon.level04.exam10;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();

    int[] arr = new int[a];
    int sum = 0;
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scanner.nextInt();
      sum += arr[i];
      if (max < arr[i]) {
        max = arr[i];
      }
    }
    float avg = (((float) sum / (float) a) / max) * 100;
    System.out.print(avg);
    scanner.close();
  }
}
