package algorithm.test.baekjoon.level18.exam04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    double sum = 0;
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      sum += arr[i];
      if (hm.containsKey(arr[i])) {
        int value = hm.get(arr[i]);
        hm.replace(arr[i], ++value);
      } else {
        hm.put(arr[i], 1);
      }
    }
    double avg = sum / n;
    bw.write("" + Math.round(avg) + "\n");
    Arrays.sort(arr);
    bw.write(arr[n / 2] + "\n");
    int range = arr[n - 1] - arr[0];
    int temp = 0;
    int rlt = 0;
    int cnt = 0;;
    for (int i = 0; i < n; i++) {
      if (temp == hm.get(arr[i])) {
        if (rlt < arr[i] && cnt < 1) {
          cnt++;
          rlt = arr[i];
        }
      } else if (temp < hm.get(arr[i])) {
        temp = hm.get(arr[i]);
        rlt = arr[i];
        cnt = 0;
      }
    }
    bw.write(rlt + "\n");
    bw.write(range + "");
    bw.flush();
    bw.close();
    br.close();
  }
}
