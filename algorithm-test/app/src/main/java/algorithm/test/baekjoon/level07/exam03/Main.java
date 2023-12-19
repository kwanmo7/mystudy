package algorithm.test.baekjoon.level07.exam03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    char[][] arr = new char[5][15];
    for (int i = 0; i < 5; i++) {
      String input = scanner.nextLine();
      for (int j = 0; j < input.length(); j++) {
        arr[i][j] = input.charAt(j);
      }
    }
    int i = 0;
    while (i < 15) {
      for (int j = 0; j < 5; j++) {
        if (arr[j][i] != '\0') {
          System.out.printf("%s", arr[j][i]);
        }
      }
      i++;
    }
    scanner.close();
  }
}
