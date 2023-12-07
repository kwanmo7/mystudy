package algorithm.test.baekjoon.level03.exam11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException, NumberFormatException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = "0";
    while (true) {
      String[] strs = br.readLine().split(" ");
      if (strs[0].compareTo(s) == 0 && strs[1].compareTo(s) == 0) {
        break;
      }
      int sum = (Integer.parseInt(strs[0]) + Integer.parseInt(strs[1]));
      bw.write(sum + "\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
