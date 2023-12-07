package algorithm.test.baekjoon.level03.exam08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int cnt = Integer.parseInt(br.readLine());
    for (int i = 1; i <= cnt; i++) {
      String[] strs = br.readLine().split(" ");
      int b = Integer.parseInt(strs[0]);
      int c = Integer.parseInt(strs[1]);
      bw.write("Case #" + i + ": " + b + " + " + c + " = " + (b + c) + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
