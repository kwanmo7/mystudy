package algorithm.test.baekjoon.level20.exam07;

import java.util.Scanner;

public class Main {

  static int n;
  static int[] numbers;
  static int[] operators = new int[4];
  static int maxValue = Integer.MIN_VALUE;
  static int minValue = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    numbers = new int[n];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = sc.nextInt();
    }
    for (int i = 0; i < operators.length; i++) {
      operators[i] = sc.nextInt();
    }

    calc(numbers[0], 1);
    System.out.println(maxValue);
    System.out.println(minValue);

    sc.close();
  }

  private static void calc(int result, int index) {
    if (index == n) {
      maxValue = Math.max(maxValue, result);
      minValue = Math.min(minValue, result);
      return;
    }
    for (int i = 0; i < operators.length; i++) {
      if (operators[i] > 0) {
        operators[i]--; // 연산자 사용
        switch (i) { // switch 문 안에서 재귀호출을 통해 모든 경우의 수 탐색
          case 0:
            calc(result + numbers[index], index + 1);
            break;
          case 1:
            calc(result - numbers[index], index + 1);
            break;
          case 2:
            calc(result * numbers[index], index + 1);
            break;
          case 3:
            calc(result / numbers[index], index + 1);
            break;
        }
        operators[i]++; // 연산자 사용후 복구
      }
    }
  }
}
