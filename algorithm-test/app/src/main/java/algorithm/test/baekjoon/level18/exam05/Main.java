package algorithm.test.baekjoon.level18.exam05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int len = Integer.parseInt(st.nextToken());
    HashMap<String, Integer> hm = new HashMap<String, Integer>();
    String[] key = new String[n];
    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      if (input.length() < len) {
        continue;
      }
      if (hm.containsKey(input)) {
        int cnt = hm.get(input);
        hm.replace(input, ++cnt);
      } else {
        hm.put(input, 1);
        key[i] = input;
      }
    }
    String[][] arr = new String[hm.size()][2];
    for (int i = 0; i < hm.size(); i++) {
      arr[i][0] = key[i];
      arr[i][1] = String.valueOf(hm.get(key[i]));
    }

    System.out.println(arr.toString());
  }
}
