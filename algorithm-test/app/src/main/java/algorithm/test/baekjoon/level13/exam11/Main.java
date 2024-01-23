package algorithm.test.baekjoon.level13.exam11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }
    HashMap<Integer, Integer> hm = chk(arr);
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      str.append(hm.get(arr[i]) + " ");
    }
    System.out.println(str);
    scanner.close();
  }

  static HashMap<Integer, Integer> chk(int[] arr) {
    // 압축 좌표값을 저장할 HashMap
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    // 파타미터로 받은 Arr를 사용하면 함수 사용전의 값까지 바뀌기 때문에 copyOf로 복사하여 정렬
    int[] newArr = Arrays.copyOf(arr, arr.length);
    Arrays.sort(newArr);
    int cursor = 0;
    for (int i = 0; i < newArr.length; i++) {
      if (hm.containsKey(newArr[i])) {
        continue; // 중복 값을 막기위해 이미 저장된 값의 경우 다음 반복으로 이동
      }
      hm.put(newArr[i], cursor++);
    }
    return hm;
  }
}
