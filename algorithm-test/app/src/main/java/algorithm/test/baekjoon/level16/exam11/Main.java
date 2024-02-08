package algorithm.test.baekjoon.level16.exam11;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    boolean[] boolArr = new boolean[n];
    int[] intArr = new int[n];
    StringTokenizer st = new StringTokenizer(scanner.nextLine(), " ");
    StringTokenizer st2 = new StringTokenizer(scanner.nextLine(), " ");
    for (int i = 0; i < n; i++) {
      intArr[i] = Integer.parseInt(st2.nextToken());
      String val = st.nextToken();
      if (val.equals("1")) {
        boolArr[i] = true;
      }
    }
    int m = Integer.parseInt(scanner.nextLine());



    StringBuilder sb = new StringBuilder();

    System.out.print(sb);
    scanner.close();
  }
}
