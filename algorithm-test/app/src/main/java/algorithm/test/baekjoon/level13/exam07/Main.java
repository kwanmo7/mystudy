package algorithm.test.baekjoon.level13.exam07;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[][] arr = new int[n][2];
    for (int i = 0; i < n; i++) {
      arr[i][0] = scanner.nextInt();
      arr[i][1] = scanner.nextInt();
    }
    // 이중배열 sort에 경우 Comparator 익명클래스를 선언하여 compare 함수를 오버라이딩해서 사용
    // 익명클래스에서 하나의 함수를 오버라이드 하는 것이기 때문에 람다식으로 사용
    Arrays.sort(arr, (o1, o2) -> {
      // 이중배열 Sort - {x,y}라고 하였을때 x값을 먼저 비교하여 sort
      // x값이 같을 경우 y값을 이용하여 정렬한다
      // 오름차순 정렬
      return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
    });
    StringBuilder str = new StringBuilder();
    for (int[] a : arr) {
      str.append(a[0] + " " + a[1] + "\n");
    }
    System.out.println(str);
    scanner.close();
  }
}
