package algorithm.test.baekjoon.level13.exam10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[][] arr = new String[n][2];
    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine().split(" ");
    }

    Arrays.sort(arr, (o1, o2) -> {
      if (o1[0].equals(o2[0])) {
        return 0;
      } else {
        return (Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]));
      }
    });
    StringBuilder str = new StringBuilder();
    for (String[] s : arr) {
      str.append(s[0] + " " + s[1] + "\n");
    }
    System.out.print(str);
    br.close();
  }
}
