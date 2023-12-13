package algorithm.test.baekjoon.level04.exam07;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] arr = new int[28];
    for (int i = 0; i < 28; i++) {
      arr[i] = Integer.parseInt(scanner.nextLine());
    }
    int[] arr2 = new int[2];
    int index = 0;
    for (int i = 1; i <= 30; i++) {
      boolean chk = false;
      for (int j = 0; j < 28; j++) {
        if (i == arr[j]) {
          chk = true;
          break;
        }
      }
      if (chk == false) {
        arr2[index] = i;
        index++;
      }
    }
    if (arr2[0] > arr2[1]) {
      int temp = arr2[0];
      arr2[0] = arr2[1];
      arr2[1] = temp;
    }
    for (int i = 0; i < arr2.length; i++) {
      System.out.println(arr2[i]);
    }
    scanner.close();
  }
}
