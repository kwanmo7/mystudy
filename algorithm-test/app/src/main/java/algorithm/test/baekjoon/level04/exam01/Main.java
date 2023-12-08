package algorithm.test.baekjoon.level04.exam01;

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
    String[] b = new String[a];
    b = br.readLine().split(" ");
    String c = br.readLine();
    int cnt = 0;
    for (int i = 0; i < a; i++) {
      if (b[i].equals(c)) {
        cnt++;
      }
    }
    bw.write(cnt + "");
    bw.flush();
    bw.close();
    br.close();
  }
}
