package algorithm.test.baekjoon.level15.exam02;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextLong();
    long b = Long.parseLong(scanner.nextLine().trim());
    long rlt = euclid(a, b); // 최대 공약수를 구함
    System.out.println(a * b / rlt); // 입력 받은 두 값을 곱하고 최대 공약수로 나누면 최소 공배수가 됨
    scanner.close();
  }

  // 유클리드 호제법 - 재귀호출식
  static long euclid(long a, long b) {
    if (b == 0) {
      return a; // b가 0이될때 a가 최대 공약수가 됨
    }
    return euclid(b, a % b); // b가 0이 될때까지 재귀 호출
  }

  // 유클리드 호제법 - 반복문 방식
  static long euclidloop(long a, long b) {
    while (b != 0) { // b가 0이 될때 반복문 종료
      long temp = b; // temp에 b 값을 저장
      b = a % b; // b 값을 a와 b를 나눈 나머지 값을 저장
      a = temp; // a를 위에서 나머지 값을 나누기전의 b 값으로 저장
    }
    return a; // b가 0이 됐을때 a는 최대 공약수가 됨
  }
}
