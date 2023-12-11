package algorithm.test.baekjoon.level04.exam08;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] arr = new int[10];
    int[] arr2 = new int[10];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(scanner.nextLine());
    }
    int cnt = 0;
    for (int i = 0; i < arr.length; i++) {
      arr2[i] = arr[i] % 42;
    }
    for (int i = 0; i < arr2.length - 1; i++) {
      boolean chk = false;
      for (int j = 1; j < arr2.length; j++) {
        if (arr2[i] == arr2[j]) {
          chk = false;
        } else {
          chk = true;
        }
      }
      if (chk == true) {
        cnt++;
      }
    }

    System.out.print(cnt);
  }
}
