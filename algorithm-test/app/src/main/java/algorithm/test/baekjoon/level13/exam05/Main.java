package algorithm.test.baekjoon.level13.exam05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n]; // ArrayList 보다 메모리를 적게 잡아 먹음
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    br.close();
    Arrays.sort(arr); // List배열이 아닌경우 Arrays 함수에 sort를 사용
    StringBuilder str = new StringBuilder(); // BufferedWriter보다 StringBuilder에 append하는 것이 더 빠름
    for (int a : arr) {
      str.append(a + "\n");
    }
    System.out.println(str);
  }
}
