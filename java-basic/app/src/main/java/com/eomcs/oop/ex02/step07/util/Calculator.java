package com.eomcs.oop.ex02.step07.util;

public class Calculator {

  public int result = 0;

  // 다른 패키지에서 이 클래스와 멤버(필드 및 메서드)를 접근할 수 있도록
  // public으로 선언해야함
  public void plus(int value) {
    this.result += value; // result = result + value
  }

  public void minus(int value) {
    this.result -= value; // result = result - value
  }

  public void multiple(int value) {
    this.result *= value; // result = result * value
  }

  public void divide(int value) {
    this.result /= value; // result = result / value
  }

  // this를 이용한 절대값 산출
  public int abs() {
    return this.result >= 0 ? this.result : this.result * -1;
  }
}
