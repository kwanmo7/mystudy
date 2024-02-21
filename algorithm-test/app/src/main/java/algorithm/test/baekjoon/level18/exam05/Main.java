package algorithm.test.baekjoon.level18.exam05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int len = Integer.parseInt(st.nextToken());
    HashMap<String, Integer> hm = new HashMap<String, Integer>();
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
      }
    }
    List<String> keyset = new ArrayList<String>(hm.keySet());
    keyset.sort((v1, v2) -> {
      // 자주 나오는 단어 앞 배치 정렬
      if ((hm.get(v2) - hm.get(v1)) == 0) {
        // 자주 나오는 빈도가 같을때, 길이가 긴 것을 앞 배치
        if (v1.length() == v2.length()) {
          return v1.compareTo(v2); // 길이가 같을 때 알파벳 사전 순으로 정렬
        }
        return v2.length() - v1.length();
      }
      return hm.get(v2) - hm.get(v1);
    });
    for (String rlt : keyset) {
      bw.write(rlt + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
