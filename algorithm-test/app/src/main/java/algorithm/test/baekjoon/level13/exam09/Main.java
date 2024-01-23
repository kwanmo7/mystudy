package algorithm.test.baekjoon.level13.exam09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      if (list.contains(str)) {
        continue;
      }
      list.add(str);
    }
    Collections.sort(list, (o1, o2) -> {
      if (o1.length() == o2.length()) {
        return o1.compareTo(o2);
      } else {
        return o1.length() - o2.length();
      }
    });
    StringBuilder strbild = new StringBuilder();
    for (String s : list) {
      strbild.append(s + "\n");
    }
    System.out.print(strbild);
    br.close();
  }
}
