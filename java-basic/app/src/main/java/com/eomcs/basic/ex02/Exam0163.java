// StringBuffer vs StringBuilder
package com.eomcs.basic.ex02;

public class Exam0163 {
  public static void main(String[] args) throws Exception {
    // StringBuilder 객체는 mutable 객체이다.
    // 인스턴스의 데이터를 변경할 수 있다.
    // 원래의 문자열을 변경하고 싶을 때 사용하는 클래스이다.
    //
    StringBuffer strBuf = new StringBuffer();

    Worker w1 = new Worker(strBuf, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    Worker w2 = new Worker(strBuf, "--------------------------------------------------");
    Worker w3 = new Worker(strBuf, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    Worker w4 = new Worker(strBuf, "**************************************************");

    // 순차적으로 작업을 시키지 않고 동시에 진행
    // -> Thread 객체에 대해 start()를 호출하면 run() 메서드를 실행시키고 즉시 리턴
    // run() 메서드의 작업이 끝날 때까지 기다리지 않는다.
    w1.start();
    w2.start();
    w3.start();
    w4.start();

    // 이전에 실행시킨 작업이 끝날 때까지
    // 2초 기다렸다가 다음 명령을 실행
    Thread.currentThread().sleep(2000);
    System.out.println("실행 끝!");
    System.out.println(strBuf.length());
  }

  // 주어진 메시지를 버퍼에 담는다
  static class Worker extends Thread {
    String message;
    StringBuffer buf;

    public Worker(StringBuffer buf, String message) {
      this.buf = buf;
      this.message = message;
    }

    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        buf.append(message);
      }
      System.out.printf("'%s' 메시지 저장 끝!\n", message);
    }
  }
}


