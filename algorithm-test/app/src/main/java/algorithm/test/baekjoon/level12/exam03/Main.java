package algorithm.test.baekjoon.level12.exam03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    int d = scanner.nextInt();
    int e = scanner.nextInt();
    int f = scanner.nextInt();

    int x = 0;
    int y = 0;

    ?????????

    System.out.printf("%d %d", x, y);


    scanner.close();
  }
}
/*
 * ax+by=c // dx+ey=f --> (a-d)x+(b-e)y = c-f 정수 a, b, c, d, e, f가 공백으로 구분되어 차례대로 주어진다. (-999 <=
 * a,b,c,d,e,f <= 999)
 *
 * 문제에서 언급한 방정식을 만족하는 (x,y)가 유일하게 존재하고, 이 때 x와 y가 각각 -999 이상 999 이하의 정수인 경우만 입력으로 주어짐이 보장된다.
 */
