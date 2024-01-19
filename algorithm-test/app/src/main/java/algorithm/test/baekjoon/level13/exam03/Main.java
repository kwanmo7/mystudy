package algorithm.test.baekjoon.level13.exam03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      arr.add(scanner.nextInt());
    }
    Collections.sort(arr, Collections.reverseOrder());
    System.out.println(arr.get(m - 1));
    scanner.close();
  }
}
