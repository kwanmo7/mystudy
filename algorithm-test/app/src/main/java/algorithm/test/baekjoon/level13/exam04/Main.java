package algorithm.test.baekjoon.level13.exam04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      arr.add(scanner.nextInt());
    }
    Collections.sort(arr);
    StringBuilder a = new StringBuilder();
    arr.forEach(v -> a.append(v + "\n")); // System.out.println 을 최소화하기위해 StringBuilder를 사용
    System.out.println(a); // System.out.println의 사용이 최소화되면 실행시간이 단축된다
    scanner.close();
  }
}
