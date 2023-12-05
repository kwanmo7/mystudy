package com.eomcs.oop.ex02.step17.vo;

public class Score {
  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3; // (s.sum / 3f) 로도 가능
  }
}
