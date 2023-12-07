package algorithm.test.baekjoon.level03.exam12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException, NumberFormatException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String strs;

    while ((strs = br.readLine()) != null) {
      String[] arr = strs.split(" ");
      int sum = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
      bw.write(sum + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
