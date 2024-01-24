package algorithm.test.baekjoon.level14.exam05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    // StringTokenizer 한줄을 읽고 delim(구분자) 단위로 끊어서 Token으로 저장
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      int value = 0;
      int key = Integer.parseInt(st.nextToken()); // Token 값 꺼내기
      if (map.get(key) == null) {
        map.put(key, 1); // 첫 입력시 value에 key의 갯수를 1개로 저장
      } else {
        value = map.get(key); // key가 이미 있는경우 value 값(갯수)를 가져옴
        map.put(key, ++value); // 갯수를 한개 증가시켜서 넣어줌
      }
    }
    int m = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < m; i++) {
      int key = Integer.parseInt(st.nextToken());
      if (map.get(key) != null) {
        sb.append(map.get(key) + " ");
      } else {
        sb.append("0 ");
      }
    }
    System.out.print(sb);
    br.close();
  }
}
