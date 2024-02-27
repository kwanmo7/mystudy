package algorithm.test.baekjoon.level19.exam06;

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

    n = Integer.parseInt(br.readLine());
    sb = new StringBuilder();
    for (int i = 0; i < Math.pow(3, n); i++) {
      sb.append("*");
    }
    System.out.println(sb);
    System.out.println(calc(sb));
  }


  static String calc(StringBuilder sb) {
    int n = (sb.length() / 3);
    StringBuilder a = new StringBuilder();
    a.append(sb.substring(0, n));
    StringBuilder c = new StringBuilder();
    c.append(sb.substring(n + n, sb.length()));
    for (int i = n; i < n + n; i++) {
      sb.replace(i, i + 1, " ");
    }
    System.out.println(sb);
    if (n % 3 == 0) {
      sb.replace(0, n, calc(a));
      sb.replace(n + n, sb.length(), calc(c));
    }
    return sb.toString();
  }
}
