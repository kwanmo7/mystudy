package algorithm.test.baekjoon.level04.exam08;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] arr = new int[10];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(scanner.nextLine()) % 42;
    }
    int cnt = 0;
    for (int i = 0; i < arr.length; i++) {
      int chk = 0;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          chk++;
        }
      }
      if (chk > 0) {
        cnt++;
      }
    }
    scanner.close();
    System.out.print(arr.length - cnt);
  }
}
