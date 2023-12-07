package algorithm.test.baekjoon.level03.exam06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int a = Integer.parseInt(br.readLine());
    for (int i = 0; i < a; i++) {
      String[] strs = br.readLine().split(" ");
      int b = Integer.parseInt(strs[0]);
      int c = Integer.parseInt(strs[1]);
      bw.write((b + c) + "");
      bw.newLine();
    }
    bw.flush();
    br.close();
    bw.close();
  }
}

