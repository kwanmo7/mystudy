package algorithm.test.baekjoon.level04.exam07;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] arr = new int[30];
    for (int i = 0; i < 28; i++) {
      arr[i] = Integer.parseInt(scanner.nextLine());
    }
    int[] arr2 = new int[2];
    for (int i = 0; i < arr2.length; i++) {
      for (int j = 1; j <= 30; j++) {
        boolean chk = false;
        for (int k = 0; k < arr.length; k++) {
          if (arr[k] == j) {
            chk = true;
            break;
          }
        }
        if (chk == false) {
          arr2[i] = j;
          break;
        }
      }
    }
    for (int i = 0; i < arr2.length; i++) {
      System.out.println(arr2[i]);
    }
    scanner.close();
  }
}
