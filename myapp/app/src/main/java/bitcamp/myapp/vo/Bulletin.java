package bitcamp.myapp.vo;

public class Bulletin {

  public String title;
  public String content;
  public String writer;
  public String date;

  public void modifyBulletin(Bulletin stBul) {
    this.title = stBul.title;
    this.content = stBul.content;
    this.writer = stBul.writer;
    this.date = stBul.date;
  }
}
