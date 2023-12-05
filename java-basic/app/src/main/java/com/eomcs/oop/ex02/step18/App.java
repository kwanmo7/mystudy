package com.eomcs.oop.ex02.step18;

import com.eomcs.oop.ex02.step18.vo.Score;

public class App {
  public static void main(String[] args) {
    Score s1 = new Score("홍길동", 100, 90, 85);
    Score s2 = new Score("임꺽정", 90, 80, 75);
    Score s3 = new Score("유관순", 80, 70, 65);

    s2.kor = 100;
    s2.compute();
    // 출력
    printScore(s1);
    printScore(s2);
    printScore(s3);
  }

  // 합계와 평균, 출력 코드를 분리하여 별도의 메소드로 정의 / 중복코드 제거
  static void printScore(Score s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
}
