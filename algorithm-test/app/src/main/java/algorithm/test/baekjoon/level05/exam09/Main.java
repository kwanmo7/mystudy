package algorithm.test.baekjoon.level05.exam09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] a = br.readLine().split(" ");
    char[] c = a[0].toCharArray();
    char[] d = a[1].toCharArray();
    char temp = c[0];
    c[0] = c[c.length - 1];
    c[c.length - 1] = temp;
    temp = d[0];
    d[0] = d[d.length - 1];
    d[d.length - 1] = temp;
    String e = String.valueOf(c);
    String f = String.valueOf(d);
    if (Integer.parseInt(e) > Integer.parseInt(f)) {
      bw.write(e);
    } else {
      bw.write(f);
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
