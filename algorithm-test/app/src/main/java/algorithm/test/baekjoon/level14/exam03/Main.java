package algorithm.test.baekjoon.level14.exam03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    HashMap<String, String> hm = new HashMap<String, String>();
    for (int i = 0; i < n; i++) {
      String[] str = scanner.nextLine().split(" ");
      if (str[1].equals("enter")) {
        hm.put(str[0], str[1]);
      } else if (str[1].equals("leave")) {
        if (hm.containsKey(str[0])) {
          hm.remove(str[0]);
        }
      }
    }
    ArrayList<String> list = new ArrayList<String>();
    for (String s : hm.keySet()) {
      list.add(s);
    }
    Collections.sort(list, Collections.reverseOrder());
    list.forEach(v -> System.out.println(v));
    scanner.close();
  }
}
