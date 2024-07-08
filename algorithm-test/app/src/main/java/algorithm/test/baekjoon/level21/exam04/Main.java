package algorithm.test.baekjoon.level21.exam04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      int m = sc.nextInt();
      System.out.println(padoban(m));
    }
  }

  private static long padoban(int n) {
    if (n < 3) {
      return 1;
    }

    // int의 최대치를 넘기기때문에 long으로 선언
    long[] arr = new long[n + 1];
    arr[0] = 1;
    arr[1] = 1;
    arr[2] = 1;
    for (int i = 3; i <= n; i++) {
      arr[i] = arr[i - 2] + arr[i - 3];
    }
    return arr[n - 1];
  }
}

/*
 * 파도반 수열(Padovan Sequence)은 수학적 수열의 하나로, 다음과 같은 점화식으로 정의됩니다:
 *
 * P(n)=P(n−2)+P(n−3)P(n)=P(n−2)+P(n−3)
 *
 * 여기서 초기 조건은 다음과 같습니다:
 *
 * P(0)=P(1)=P(2)=1P(0)=P(1)=P(2)=1
 *
 * 즉, 파도반 수열의 첫 번째 몇 항은 다음과 같이 계산됩니다:
 *
 * P(0) = 1 P(1) = 1 P(2) = 1 P(3) = P(1) + P(0) = 1 + 1 = 2 P(4) = P(2) + P(1) = 1 + 1 = 2 P(5) =
 * P(3) + P(2) = 2 + 1 = 3 P(6) = P(4) + P(3) = 2 + 2 = 4
 *
 * 이와 같이 계속해서 계산할 수 있습니다.
 *
 * 파도반 수열은 종종 건축 및 예술에서 나타나는 비율과 관련이 있으며, 나선형 패턴이나 자연에서 발견되는 특정 형태에서 발견될 수 있습니다. 수열의 성질은 그 자체로 흥미롭고,
 * 파도반 수열의 비율이 점근적으로 일정한 값에 접근하는 등 수학적으로 흥미로운 특성을 가지고 있습니다.
 *
 */
