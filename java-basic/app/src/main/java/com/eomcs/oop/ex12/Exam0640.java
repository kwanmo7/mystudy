// 메서드 레퍼런스 - 활용예
package com.eomcs.oop.ex12;

import java.util.function.Predicate;

public class Exam0640 {

  static class My {
    public boolean m() {
      return true;
    }
  }

  public static void main(String[] args) {

    // Predicate<String> p1 = My::m; // 컴파일 오류
    // 1) My의 m()는 스태틱 메서드가 아니다.
    // 2) My의 m()는 파라미터가 없다.



    // My obj = new My();
    // Predicate<String> p2 = obj::m; // 컴파일 오류
    // 1) My의 m();는 파라미터를 받지 못한다.

    Predicate<My> p3 = My::m; // OK
    // 타입 파라미터의 클래스가 인스턴스 메서드의 클래스와 같다면
    // 다음과 같이 람다 문법으로 변경 된다
    // => Predicate<My> p3 = (My value) -> {return value.m(); };
    // => Predicate<My> p3 = value -> value.m();
    System.out.println(p3.test(new My()));
  }

}


