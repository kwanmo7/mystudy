package com.eomcs.lang.ex99;

import java.io.InputStream;
import java.util.Scanner;

public class Test1 {
  public static void main(String[] args) throws Exception {
    InputStream in = System.in;
    Scanner scanner = new Scanner(in);
    String strInput = scanner.nextLine();
    System.out.println("===> " + strInput);
    scanner.close();
  }
}
