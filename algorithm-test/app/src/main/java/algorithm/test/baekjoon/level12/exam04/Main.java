package algorithm.test.baekjoon.level12.exam04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
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
    int start = chkstartPoint(input, b);
    for (int i = start; i < b; i++) {

    }

    System.out.println();
  }

  static int chkstartPoint(String[] input, int b) {
    for (int i = 0; i < b - 1; i++) {
      if (input[i].substring(i, i + 1).equals("BW") || input[i].substring(i, i + 1).equals("WB")) {
        return i;
      }
    }

    return 0;
  }
}
