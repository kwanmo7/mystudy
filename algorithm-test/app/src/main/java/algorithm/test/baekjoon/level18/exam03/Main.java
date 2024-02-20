package algorithm.test.baekjoon.level18.exam03;

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
    HashSet<String> hs = new HashSet<String>();
    hs.add("ChongChong");
    for (int i = 0; i < n; i++) {
      String[] arr = br.readLine().split(" ");
      if (hs.contains(arr[0]) || hs.contains(arr[1])) {
        // 중복된 값을 add해도 두개 들어가지않음
        hs.add(arr[0]);
        hs.add(arr[1]);
      }
    }
    bw.write("" + hs.size());
    bw.flush();
    br.close();
    bw.close();
  }
}
