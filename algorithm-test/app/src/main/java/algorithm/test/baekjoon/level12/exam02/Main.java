package algorithm.test.baekjoon.level12.exam02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int size = Integer.toString(a).length();
    int n = 0;
    ArrayList<Integer> list = new ArrayList<Integer>();
    int[] arr = new int[size];
    for (int i = 1; i < a; i++) {
      n = a - i;
      int sum = 0;
      String str = Integer.toString(n);
      for (int j = 0; j < str.length(); j++) {
        arr[j] = Integer.parseInt(String.valueOf(str.charAt(j)));
        sum += arr[j];
      }
      if (a == sum + n) {
        list.add(n);
      } else {
        n = 0;
      }
    }
    Collections.sort(list);
    if (list.size() != 0) {
      n = list.get(0);
    }
    System.out.println(n);
    scanner.close();
  }
}
