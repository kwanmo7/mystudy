package algorithm.test.baekjoon.level14.exam07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    HashSet<Integer> hs1 = new HashSet<Integer>();
    HashSet<Integer> hs2 = new HashSet<Integer>();
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      hs1.add(Integer.parseInt(st.nextToken()));
    }
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < m; i++) {
      hs2.add(Integer.parseInt(st.nextToken()));
    }
    int rlt = calc(hs1, hs2);
    System.out.println(rlt);
    br.close();
  }

  static int calc(HashSet<Integer> hs1, HashSet<Integer> hs2) {
    int cnt = 0;
    Iterator<Integer> it = hs1.iterator();
    while (it.hasNext()) {
      if (!hs2.contains(it.next())) {
        cnt++;
      }
    }
    it = hs2.iterator();
    while (it.hasNext()) {
      if (!hs1.contains(it.next())) {
        cnt++;
      }
    }
    return cnt;
  }
}
