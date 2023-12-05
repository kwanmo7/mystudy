package algorithm.test.baekjoon.level01.exam11;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 첫 번째 줄에 A, B, C (1 ≤ A, B, C ≤ 10(12제곱))이 공백을 사이에 두고 주어진다.
    // 조건에 주의
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextLong();
    a += scanner.nextLong();
    a += scanner.nextLong();
    System.out.print(a);
    scanner.close();
  }
}
