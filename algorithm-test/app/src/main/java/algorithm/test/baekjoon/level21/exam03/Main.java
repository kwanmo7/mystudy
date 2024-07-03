package algorithm.test.baekjoon.level21.exam03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    if (n < 3) {
      System.out.println(n);
    } else {
      int mod = 15746;
      int[] arr = new int[n + 1];

      // 기본값 설정
      arr[1] = 1;
      arr[2] = 2;

      for (int i = 3; i <= n; i++) {
        // 배열을 채워나가면서 각 길이에 대한 값을 점화식을 이용해 계산
        arr[i] = (arr[i - 1] + arr[i - 2]) % mod;
      }
      System.out.println(arr[n]);
    }
  }
}
/*
 * 점화식은 재귀적인 관계를 나타내는 식으로, 수열의 n번째 항을 이전 항들을 이용해서 표현하는 수학적 표현
 * 피보나치 수열의 변형을 사용합니다. 길이가 N인 2진 수열을 만들 수 있는 가짓수를 구하는 방법
 * f(n) = f(n-1) + f(n-2)
 * 여기서 f(n)은 길이가 N인 2진 수열의 개수입니다. 이 식은 길이가 N인 2진 수열이 다음 두 가지 경우 중 하나로 끝날 수 있다는 것을 나타냅니다:

    길이가 N-1인 2진 수열의 뒤에 '1'을 붙이는 경우.
    길이가 N-2인 2진 수열의 뒤에 '00'을 붙이는 경우.

    따라서 f(n)은 f(n-1)과 f(n-2)의 합으로 표현
 */
