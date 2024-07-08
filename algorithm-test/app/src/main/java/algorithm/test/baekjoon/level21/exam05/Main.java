package algorithm.test.baekjoon.level21.exam05;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    // 카데인 알고리즘을 사용하여 최대 부분합을 구함
    int maxCurrent = arr[0];
    int maxGlobal = arr[0];

    for (int i = 1; i < n; i++) {
      maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);
      if (maxCurrent > maxGlobal) {
        maxGlobal = maxCurrent;
      }
    }

    System.out.println(maxGlobal);
    sc.close();
  }
}

/*
 * 카데인 알고리즘: 데인 알고리즘은 O(n)의 시간 복잡도를 가지며, 주어진 문제 조건에서 매우 효율적
 *
 * maxCurrent는 현재 위치까지의 부분 수열 중 가장 큰 합을 저장하고, maxGlobal은 지금까지 찾은 부분 수열 중 가장 큰 합을 저장합니다.
 * 수열의 두 번째 원소부터 시작하여 반복문을 통해 현재 위치까지의 부분 수열의 최대 합을 업데이트합니다. 
 * 이때 maxCurrent는 현재 원소 자체와 이전 위치까지의 최대 합에 현재 원소를
 * 더한 값 중 큰 값을 선택합니다. maxGlobal을 계속 업데이트하여 전체 수열 중 가장 큰 부분 수열의 합을 유지합니다.
 */
