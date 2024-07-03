package algorithm.test.baekjoon.level19.exam07;

import java.util.Scanner;

public class Main {

  static int moveCount = 0; // 이동횟수

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    StringBuilder sb = new StringBuilder();

    hanoi(n, 1, 3, 2, sb);
    System.out.println(moveCount);
    System.out.println(sb.toString());
  }

  private static void hanoi(int n, int start, int end, int aux, StringBuilder sb) {
    if (n == 1) { // 원판이 하나인 경우
      sb.append(start).append(" ").append(end).append("\n");
      moveCount++;
      return;
    }

    // 원판이 하나 이상인 경우
    // n - 1개의 원판을 start 에서 aux 로 옮김
    // 가장 큰 원판은 start 에서 end 로 옮김
    // n - 1개의 원판을 aux 에서 end 로 옮김
    hanoi(n - 1, start, aux, end, sb);
    sb.append(start).append(" ").append(end).append("\n");
    moveCount++;
    hanoi(n - 1, aux, end, start, sb);
  }
}
