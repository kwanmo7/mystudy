package algorithm.test.baekjoon.level11.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextInt();
    long rlt = (n - 2) * (n - 1) * n / 6;
    System.out.println(rlt);
    System.out.println(3);
    scanner.close();
  }
}
/*
 * MenOfPassion(A[], n) {
    sum <- 0;
    for i <- 1 to n - 2
        for j <- i + 1 to n - 1
            for k <- j + 1 to n
                sum <- sum + A[i] × A[j] × A[k]; # 코드1
    return sum;
}
 * n : 최대 몇개까지의 숫자인지(입력값)
 * r : 뽑는 숫자의 갯수
 * nCr = n! / (n-r)!*r!
 * 위의 식으로 풀이
 */
