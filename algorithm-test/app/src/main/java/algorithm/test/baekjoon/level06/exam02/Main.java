package algorithm.test.baekjoon.level06.exam02;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int[] a = new int[6];
    Scanner scanner = new Scanner(System.in);

    for (int i = 0; i < a.length; i++) {
      a[i] = scanner.nextInt();
    }
    int[] rlt = new int[6];

    rlt[0] = kingqueen(a[0]);
    rlt[1] = kingqueen(a[1]);
    rlt[2] = rbk(a[2]);
    rlt[3] = rbk(a[3]);
    rlt[4] = rbk(a[4]);
    rlt[5] = pawn(a[5]);
    for (int i = 0; i < rlt.length; i++) {
      System.out.printf("%s ", rlt[i]);
    }
    scanner.close();
  }

  static int kingqueen(int i) {
    int a = 1;
    int rlt = 0;

    if (a == i) {
      return rlt;
    } else {
      rlt = a - i;
    }
    return rlt;
  }

  static int rbk(int i) {
    int a = 2;
    int rlt = 0;
    if (a == i) {
      return rlt;
    } else {
      rlt = a - i;
    }
    return rlt;
  }

  static int pawn(int i) {
    int a = 8;
    int rlt = 0;
    if (a == i) {
      return rlt;
    } else {
      rlt = a - i;
    }
    return rlt;
  }
}
