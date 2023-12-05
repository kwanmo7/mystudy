package bitcamp.myapp.vo;

public class BulletinVO {

  public String title;
  public String content;
  public String writer;
  public String date;

  public void modifyBulletin(BulletinVO stBul) {
    this.title = stBul.title;
    this.content = stBul.content;
    this.writer = stBul.writer;
    this.date = stBul.date;
  }
  public void delete(){
    this.title = "";
    this.content = "";
    this.writer = "";
    this.date = "";
  }
}
