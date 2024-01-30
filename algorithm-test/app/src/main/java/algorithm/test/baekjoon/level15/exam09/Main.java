package algorithm.test.baekjoon.level15.exam09;

import java.util.Scanner;

// 창문 닫기
/*
 * 예를 들어 현재 3개의 창문이 있고 3명의 사람이 있을 때,
 *
 * 1번째 사람은 1의 배수인 1,2,3번 창문을 연다. (1, 1, 1) 2번째 사람은 2의 배수인 2번 창문을 닫는다. (1, 0, 1) 3번째 사람은 3의 배수인 3번
 * 창문을 닫는다. (1, 0, 0)
 *
 * 결과적으로 마지막에 열려 있는 창문의 개수는 1개 이다.
 */
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    int cnt = 0;
    for (int i = 1; i * i <= n; i++) { // 입력값안에서 제곱근으로 증가하는 반복문 , 소수의 갯수
      cnt++; // 반복문이 돌아가는 동안 cnt 증가 (소수의 갯수)
    }
    System.out.println(cnt);
    scanner.close();
  }
}
