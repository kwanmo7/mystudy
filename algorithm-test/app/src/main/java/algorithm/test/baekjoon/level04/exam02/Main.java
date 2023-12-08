package algorithm.test.baekjoon.level04.exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] a = br.readLine().split(" ");
    String[] b = br.readLine().split(" ");
    for (int i = 0; i < b.length; i++) {
      if (Integer.parseInt(a[1]) > Integer.parseInt(b[i])) {
        System.out.printf("%s ", b[i]);
      }
    }
    br.close();
  }
}
