package com.eomcs.oop.ex02.test.util;

public class Calculator {
  public int result = 0;

  public void plus(int a) {
    this.result += a;
  }

  public void minus(int a) {
    this.result -= a;
  }

  public void multiple(int a) {
    this.result *= a;
  }

  public void divide(int a) {
    this.result /= a;
  }

  public int abs() {
    if (this.result >= 0) {
      return this.result;
    } else {
      return this.result * -1;
    }
  }
}
