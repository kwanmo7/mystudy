package algorithm.test.baekjoon.level15.exam08;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    int[] arr = new int[n];
    StringBuilder sb = new StringBuilder();
    int max = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(scanner.nextLine());
      if (max < arr[i]) {
        max = arr[i];
      }
    }
    ArrayList<Integer> list = get(max);

    for (int i = 0; i < arr.length; i++) {
      sb.append(calc(list, arr[i]) + "\n");
    }

    System.out.print(sb);
    scanner.close();
  }

  static ArrayList<Integer> get(int n) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = 2; i < n; i++) {
      boolean chk = true;
      for (int j = 2; j * j <= i; j++) {
        if ((i % j) == 0) {
          chk = false;
          break;
        }
      }
      if (chk == true) {
        list.add(i);
      }
    }
    return list;
  }

  static int calc(ArrayList<Integer> list, int n) {
    int rlt = 0;
    for (int i = 0; i < list.size(); i++) {
      int temp = list.get(i);
      if (temp > n / 2) {
        return rlt;
      } else if (temp * 2 == n) {
        rlt++;
      } else if (list.contains((n - temp))) {
        rlt++;
      }
    }
    return rlt;
  }
}
