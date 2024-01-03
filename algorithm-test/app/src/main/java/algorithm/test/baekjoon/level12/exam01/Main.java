package algorithm.test.baekjoon.level12.exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    int reach = scanner.nextInt();

    int[] arr = new int[input];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scanner.nextInt();
    }
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < arr.length - 2; i++) {
      for (int j = i + 1; j < arr.length - 1; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          int sum = arr[i] + arr[j] + arr[k];
          if (sum == reach) {
            System.out.println(sum);
            return;
          } else if (sum < reach) {
            list.add(sum);
          }
        }
      }
    }
    Collections.sort(list, Collections.reverseOrder());
    System.out.println(list.get(0));
    scanner.close();
  }
}
