package algorithm.test.baekjoon.level06.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    int[] arr = new int[26];
    int index = 0;
    for (int i = 0; i < input.length(); i++) {
      index = chk(input.charAt(i));
      arr[index]++;
    }
    int rlt = getResult(arr);
    if (rlt == 100) {
      System.out.print("?");
    } else {
      System.out.printf("%s", (char) (rlt + 65));
    }
    scanner.close();
  }

  static int chk(char input) {
    int uni1 = 65;
    int uni2 = 97;

    for (int i = 0; i <= 25; i++) {
      if (uni1 + i == input) {
        return ((uni1 + i) - 65);
      }
      if (uni2 + i == input) {
        return ((uni2 + i) - 97);
      }
    }
    return 0;
  }

  static int getResult(int[] arr) {
    int temp = arr[0];
    int rlt = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > temp) {
        temp = arr[i];
        rlt = i;
      } else if (arr[i] == temp && temp != 0) {
        rlt = 100;
      }
    }
    return rlt;
  }
}
