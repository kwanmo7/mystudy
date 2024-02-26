package algorithm.test.baekjoon.level19.exam05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static int n;
  static StringBuilder sb;

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String str = "-";
    String input;
    while ((input = br.readLine()) != null) {
      n = Integer.parseInt(input);
      sb = new StringBuilder();
      if (n == 0) {
        System.out.println(str);
        continue;
      }
      int len = (int) Math.pow(3, n);
      for (int i = 0; i < len; i++) {
        sb.append(str);
      }
      calc(0, len);
      bw.write(sb + "\n");
      bw.flush();
    }
    br.close();
    bw.close();
  }

  static void calc(int start, int size) {
    if (size == 1) {
      return;
    }
    int newSize = size / 3;
    for (int i = start + newSize; i < start + 2 * newSize; i++) {
      sb.setCharAt(i, ' ');
    }
    calc(start, newSize);
    calc(start + 2 * newSize, newSize);
  }

  // 시간초과
  // static String calc(StringBuilder sb) {
  // int n = (sb.length() / 3);
  // StringBuilder a = new StringBuilder();
  // a.append(sb.substring(0, n));
  // StringBuilder c = new StringBuilder();
  // c.append(sb.substring(n + n, sb.length()));
  // for (int i = n; i < n + n; i++) {
  // sb.replace(i, i + 1, " ");
  // }
  // if (n % 3 == 0) {
  // sb.replace(0, n, calc(a));
  // sb.replace(n + n, sb.length(), calc(c));
  // }
  // return sb.toString();
  // }
}
