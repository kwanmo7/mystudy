package algorithm.test.baekjoon.level02.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int H = scanner.nextInt();
    int M = scanner.nextInt();
    if (M >= 45) {
      M -= 45;
    } else if (M < 45) {
      M = (45 - M);
      M = (60 - M);
      if (H == 0) {
        H = 23;
      } else {
        H--;
      }
    }
    System.out.printf("%s %s", H, M);
  }
}
