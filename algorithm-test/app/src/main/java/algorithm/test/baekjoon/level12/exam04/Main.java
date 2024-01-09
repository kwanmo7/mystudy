package algorithm.test.baekjoon.level12.exam04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int m;
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] in = br.readLine().split(" ");
    int a = Integer.parseInt(in[0]);
    int b = Integer.parseInt(in[1]);
    char B = 'B';
    char W = 'W';
    int cntB = 0;
    int cntW = 0;
    String[] input = new String[a];
    for (int i = 0; i < a; i++) {
      input[i] = br.readLine();
    }
    chkstartPoint(input, a, b);
    a -= m;
    b -= n;\

    System.out.println();
  }

  static void chkstartPoint(String[] input, int a, int b) {
    for (int i = 0; i < a; i++) {
      if (input[i].contains("BW") || input[i].contains("WB")) {
        for (int j = 0; j < b - 1; j++) {
          if (input[i].substring(j, j + 1).equals("BW")
              || input[i].substring(j, j + 1).equals("WB")) {
            m = i;
            n = j;
            return;
          }
        }
      }
    }
    return;
  }
}
