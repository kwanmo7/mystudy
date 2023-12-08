package algorithm.test.baekjoon.level04.exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine());
    String[] b = br.readLine().split(" ");
    int rlt1 = Integer.parseInt(b[0]);
    int rlt2 = 0;
    int max = Integer.parseInt(b[0]);
    for (int i = 0; i < b.length; i++) {
      rlt2 = Integer.parseInt(b[i]);
      if (rlt1 > rlt2) {
        rlt1 = rlt2;
      }
      if (max < rlt2) {
        max = rlt2;
      }
    }
    System.out.printf("%s %s", rlt1, max);
    br.close();
  }
}
