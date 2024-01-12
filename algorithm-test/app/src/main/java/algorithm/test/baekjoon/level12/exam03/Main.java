package algorithm.test.baekjoon.level12.exam03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // 첫번째 식
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    // 두번째 식
    int d = scanner.nextInt();
    int e = scanner.nextInt();
    int f = scanner.nextInt();

    int x = ((c * e - b * f) / (a * e - b * d));
    int y = (((c * d - a * f)) / ((b * d - a * e)));

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
// 가감법
// ex) a = 1 , b = 3 , c = -1 , d = 4 , e = 1 , f = 7 의 경우
// x + 3y = -1
// 4x + y = 7
// x 값 --> x + 3y = -1
// - 3(4x) + 3y = 21 3을 곱해준뒤 뺀다
// -11x = -22 => x = 2
// y 값 --> 4(x + 3y = -1) 양변에 4를 곱해준다
// - 4x + y = 7
// 11y = -11 => y = -1
// 구하려는 값 x 또는 y 에 대해 양 게산식에 일정 수를 곱해서 x 또는 y의 값을 같게해준뒤 두식을 빼서 게산 한다.
