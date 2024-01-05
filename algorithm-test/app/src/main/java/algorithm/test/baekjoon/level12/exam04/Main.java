package algorithm.test.baekjoon.level12.exam04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    String[][] arr = new String[a][b];

    String B = "B";
    String W = "W";

    int cnt = 0;

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {

        if (arr[i][j].equals(B)) {
          cnt++;
        } else {
          cnt--;
        }
      }
    }
    System.out.println(cnt);
    System.out.println(Math.abs(cnt));
    br.close();
  }
}
