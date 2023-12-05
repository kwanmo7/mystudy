package com.eomcs.oop.ex02.step14;

/*
 * 0) 낱개 변수 사용 1) 성적 데이터를 저장할 메모리를 새로 정의: '사용자 정의 데이터 타입(User-Defined Data Type)'이라 부른다. - 특정 데이터들을
 * 저장할 전용 메모리를 만들면 관리하기 쉽다. 2) 리팩토링 : 메소드 추출 - 중복되는 코드가 있으면 별도의 메소드로 분리
 */
public class App {
  public static void main(String[] args) {
    Score s1 = new Score();
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 85;

    Score s2 = new Score();
    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 80;
    s2.math = 75;

    Score s3 = new Score();
    s3.name = "유관순";
    s3.kor = 80;
    s3.eng = 70;
    s3.math = 65;

    // 합계,평균 계산
    compute(s1);
    compute(s2);
    compute(s3);
    // 출력
    printScore(s1);
    printScore(s2);
    printScore(s3);
  }

  // 합계와 평균, 출력 코드를 분리하여 별도의 메소드로 정의 / 중복코드 제거
  static void printScore(Score s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }

  static void compute(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = (float) s.sum / 3; // (s.sum / 3f) 로도 가능
  }
}
