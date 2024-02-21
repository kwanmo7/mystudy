package algorithm.test.baekjoon.level19.exam03;

import java.util.Scanner;

public class Main {
  public static int recursion(String s, int l, int r, int[] arr) {
    arr[1]++;
    if (l >= r) {
      return 1;
    } else if (s.charAt(l) != s.charAt(r)) {
      return 0;
    } else {
      return recursion(s, l + 1, r - 1, arr);
    }
  }

  public static int[] isPalindrome(String s, int[] arr) {
    arr[0] = recursion(s, 0, s.length() - 1, arr);
    return arr;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < n; i++) {
      String input = scanner.nextLine();
      int[] arr = new int[2];
      arr = isPalindrome(input, arr);
      System.out.printf("%d %d\n", arr[0], arr[1]);
    }
    scanner.close();
  }
}
