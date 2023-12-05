package com.eomcs.oop.ex02.step16;

public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;

  void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3; // (s.sum / 3f) 로도 가능
  }
}
