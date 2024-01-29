package algorithm.test.baekjoon.level15.exam08;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    int[] arr = new int[n];
    int max = 1;
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(scanner.nextLine());
      if (max < arr[i]) {
        max = arr[i];
      }
    }
    // 소수구하기 - 에라토스테네스의 체
    boolean[] chk = new boolean[max + 1]; // 소수를 담을 배열 - 소수의 경우 false
    chk[0] = chk[1] = true;
    for (int i = 2; i * i <= chk.length; i++) { // 제곱 배수로 소수를 찾는다
      if (!chk[i]) { // 소수를 찾은 경우
        for (int j = i + i; j < chk.length; j += i) {
          chk[j] = true; // 위에서 찾은 소수의 배수는 소수가 아니므로 전부 true
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      int rlt = 0;
      for (int j = 2; j <= arr[i] / 2; j++) { // 중복 케이스 제거를 위해 절반만 시행
        if (!chk[j] && !chk[arr[i] - j]) {
          rlt++;
        }
      }
      sb.append(rlt + "\n");
    }
    System.out.print(sb);
    scanner.close();
  }
}
