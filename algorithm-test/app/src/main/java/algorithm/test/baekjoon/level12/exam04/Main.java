package algorithm.test.baekjoon.level12.exam04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;



public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] in = br.readLine().split(" ");
    int x = Integer.parseInt(in[0]);
    int y = Integer.parseInt(in[1]);
    String[] input = new String[x];
    for (int i = 0; i < x; i++) {
      input[i] = br.readLine();
    }
    ArrayList<Integer> arrlist = new ArrayList<>();
    for (int i = 0; i <= (x - 8); i++) {
      for (int j = 0; j <= (y - 8); j++) {
        arrlist.add(calc(input, i, j));
      }
    }
    Collections.sort(arrlist);
    System.out.println(arrlist.get(0));
  }

  static int calc(String[] input, int x, int y) {
    int cnt = 0;
    char chk = input[x].charAt(y);
    System.out.println("--------------------------------");
    System.out.printf("chk=%s x=%d y=%d\n", String.valueOf(chk), x, y);
    for (int i = x; i < (8 + x); i++) {
      for (int j = y; j < (8 + y); j++) {
        if (chk == 'B') {
          if (i % 2 == 0 && j % 2 != 0 && input[i].charAt(j) == chk) {
            cnt++;
            System.out.printf("i=%s,j=%s,cnt=%s, %s\n", i, j, cnt, input[i].charAt(j));
          }
          if (i % 2 == 0 && j % 2 == 0 && input[i].charAt(j) != chk) {
            cnt++;
            System.out.printf("i=%s,j=%s,cnt=%s, %s\n", i, j, cnt, input[i].charAt(j));
          }
          if (i % 2 != 0 && j % 2 != 0 && input[i].charAt(j) != chk) {
            cnt++;
            System.out.printf("i=%s,j=%s,cnt=%s, %s\n", i, j, cnt, input[i].charAt(j));
          }
          if (i % 2 != 0 && j % 2 == 0 && input[i].charAt(j) == chk) {
            cnt++;
            System.out.printf("i=%s,j=%s,cnt=%s, %s\n", i, j, cnt, input[i].charAt(j));
          }
        }
        if (chk == 'W') {
          if (i % 2 == 0 && j % 2 != 0 && input[i].charAt(j) == chk) {
            cnt++;
            System.out.printf("i=%s,j=%s,cnt=%s, %s\n", i, j, cnt, input[i].charAt(j));
          }
          if (i % 2 == 0 && j % 2 == 0 && input[i].charAt(j) != chk) {
            cnt++;
            System.out.printf("i=%s,j=%s,cnt=%s, %s\n", i, j, cnt, input[i].charAt(j));
          }
          if (i % 2 != 0 && j % 2 != 0 && input[i].charAt(j) != chk) {
            cnt++;
            System.out.printf("i=%s,j=%s,cnt=%s, %s\n", i, j, cnt, input[i].charAt(j));
          }
          if (i % 2 != 0 && j % 2 == 0 && input[i].charAt(j) == chk) {
            cnt++;
            System.out.printf("i=%s,j=%s,cnt=%s, %s\n", i, j, cnt, input[i].charAt(j));
          }
        }
      }
    }
    return cnt;
  }
}
