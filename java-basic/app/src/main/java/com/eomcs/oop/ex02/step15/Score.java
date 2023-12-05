package com.eomcs.oop.ex02.step15;

public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;

  static void compute(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = (float) s.sum / 3; // (s.sum / 3f) 로도 가능
  }
}
