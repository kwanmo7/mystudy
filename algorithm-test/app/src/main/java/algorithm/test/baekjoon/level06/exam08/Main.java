package algorithm.test.baekjoon.level06.exam08;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    float sum = 0.0f;
    float cnt = 0;
    for (int i = 0; i < 20; i++) {
      String[] input = new String[3];
      input = scanner.nextLine().split(" ");
      if (!input[2].equals("P")) {
        sum += (Float.parseFloat(input[1]) * calc(input[2]));
        cnt += Float.parseFloat(input[1]);
      }
    }
    float avg = sum / cnt;
    System.out.println(avg);
    scanner.close();
  }

  static float calc(String input) {
    if (input.equals("A+")) {
      return 4.5f;
    } else if (input.equals("A0")) {
      return (float) 4.0;
    } else if (input.equals("B+")) {
      return (float) 3.5;
    } else if (input.equals("B0")) {
      return (float) 3.0;
    } else if (input.equals("C+")) {
      return (float) 2.5;
    } else if (input.equals("C0")) {
      return (float) 2.0;
    } else if (input.equals("D+")) {
      return (float) 1.5;
    } else if (input.equals("D0")) {
      return (float) 1.0;
    } else if (input.equals("F")) {
      return (float) 0.0;
    }
    return 0;
  }
}
