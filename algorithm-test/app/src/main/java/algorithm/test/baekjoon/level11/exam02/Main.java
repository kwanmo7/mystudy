package algorithm.test.baekjoon.level11.exam02;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    System.out.println(a);
    System.out.println(1);
  }
}
/*
MenOfPassion(A[], n) {
  sum <- 0;
  for i <- 1 to n
      sum <- sum + A[i]; # 코드1
  return sum;
}


첫째 줄에 코드1 의 수행 횟수를 출력한다.

둘째 줄에 코드1의 수행 횟수를 다항식으로 나타내었을 때, 최고차항의 차수를 출력한다. 단, 다항식으로 나타낼 수 없거나 최고차항의 차수가 3보다 크면 4를 출력한다.

*/