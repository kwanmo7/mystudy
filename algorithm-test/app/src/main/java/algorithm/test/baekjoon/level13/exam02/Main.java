package algorithm.test.baekjoon.level13.exam02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int avg = 0;
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int i = 0; i < 5; i++) {
      int input = scanner.nextInt();
      arr.add(input);
      avg += input;
    }
    Collections.sort(arr);
    System.out.println(avg / 5);
    System.out.println(arr.get(2));
    scanner.close();
  }
}
