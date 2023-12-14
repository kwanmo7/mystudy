package algorithm.test.baekjoon.level05.exam07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int a = Integer.parseInt(br.readLine());
    for (int i = 0; i < a; i++) {
      int b = (br.read() - 48);
      String input = br.readLine().trim();
      char[] d = new char[b * input.length()];
      int index = 0;
      for (int j = 0; j < input.length(); j++) {
        for (int k = 0; k < b; k++) {
          d[index] = input.charAt(j);
          index++;
        }
      }
      bw.write(d);
      bw.newLine();
    }
    bw.flush();
    br.close();
    bw.close();
  }
}
