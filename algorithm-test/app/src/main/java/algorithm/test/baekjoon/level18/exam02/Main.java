package algorithm.test.baekjoon.level18.exam02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int cnt = 0;
    /*
     * 중복검사의 경우 String 이나 Array , ArrayList보다 Hash를 이용하여 찾는것이
     * 실행속도가 더 빠르다
     */
    HashSet<String> hs = new HashSet<String>();
    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      if (input.equals("ENTER")) {
        hs.clear();
      } else if (!hs.contains(input)) {
        hs.add(input);
        cnt++;
      }
    }
    bw.write("" + cnt);
    bw.flush();
    br.close();
    bw.close();
  }
}
