package algorithm.test.baekjoon.level15.exam03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = Integer.parseInt(scanner.nextLine().trim());
    int c = scanner.nextInt();
    int d = Integer.parseInt(scanner.nextLine().trim());

    int n = (a * d) + (b * c); // 분자 계산 - 두 분수를 합쳐줌
    int m = (b * d); // 분모 계산 - 두 분수를 합쳐줌

    int rlt = calc(n, m); // 유클리드 호제법으로 최대 공약수를 구해줌

    System.out.printf("%d %d", (n / rlt), (m / rlt)); // 각 수에 최대 공약수를 나눠서 약분
    scanner.close();
  }

  static int calc(int a, int b) { // 유클리드 호제법 - 재귀호출로 최대 공약수를 구해줌
    if (b == 0) {
      return a;
    }
    return calc(b, a % b);
  }
}
