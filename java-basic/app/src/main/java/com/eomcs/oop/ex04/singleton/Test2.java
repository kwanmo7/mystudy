package com.eomcs.oop.ex04.singleton;

public class Test2 {
  public static void main(String[] args) {
    // Car2 클래스의 생성자에 접근 불가
    // Car2 x = new Car2(); // 컴파일 오류!

    Car2 x1 = Car2.getInstance();
    Car2 x2 = Car2.getInstance();
    Car2 x3 = Car2.getInstance();

    System.out.println(x1 == x2);
    System.out.println(x1 == x3);
    System.out.println(x2 == x3);
  }
}
