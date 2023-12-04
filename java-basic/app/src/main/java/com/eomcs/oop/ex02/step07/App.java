package com.eomcs.oop.ex02.step07;

import com.eomcs.oop.ex02.step07.util.Calculator;

// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입
// 4) 클래스 변수의 한계 확인
// 5) 인스턴스 변수 도입
// 6) 인스턴스 메소드 활용
// 7) 클래스를 역할에 따라 패키지로 분류하기
public class App {
  public static void main(String[] args) {

    // import를 하지 않을경우 패키지명을 클래스 이름과 함께 지정해 줘야함
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    // 계산을 수행할 때 계산 결과를 보관할 메모리를 전달한다.
    c1.plus(2); // + 2
    c2.plus(3); // + 3

    c1.plus(3); // + 2 + 3
    c2.multiple(2); // + 3 * 2

    c1.minus(1); // + 2 + 3 - 1
    c2.plus(7); // + 3 * 2 + 7

    c1.multiple(7); // + 2 + 3 - 1 * 7
    c2.divide(4); // + 3 * 2 + 7 / 4

    c1.divide(3); // + 2 + 3 - 1 * 7 / 3 = ?
    c2.minus(5); // + 3 * 2 + 7 / 4 - 5 = ?

    // 식1의 계산 결과는 c1 인스턴스의 result 변수에 들어 있고,
    // 식2의 계산 결과는 c2 인스턴스의 result 변수에 들어 있다.
    System.out.printf("c1.result = %d\n", c1.result);
    System.out.printf("c2.result = %d\n", c2.result);

    System.out.printf("c2.result = %d\n", c2.abs());

  }
}

