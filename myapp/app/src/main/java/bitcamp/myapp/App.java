package bitcamp.myapp;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner keyin = new Scanner(System.in);
    //test();
    MainMenu.execute(keyin);

    keyin.close();
  }
}
