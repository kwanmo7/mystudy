package taxApp.util;

import java.io.InputStream;
import java.sql.Date;
import java.util.Scanner;

public class Prompt {
  private Scanner keyin;

  public Prompt(InputStream in) {
    this.keyin = new Scanner(in);
  }

  public String input( String title, Object... args ){
    System.out.print( String.format(title, args) );
    return this.keyin.nextLine();
  }

  public int inputInt( String title, Object... args ){
    return Integer.parseInt(input(title, args));
  }

  public Date inputDate( String title, Object... args ){
    return Date.valueOf(input(title, args));
  }

  public void close(){
    this.keyin.close();
  }
}
