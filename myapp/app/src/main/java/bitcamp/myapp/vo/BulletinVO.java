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

  public void printBulletin() {
    System.out.println("게시글 조회:");
    System.out.printf("제목: %s\n", this.title);
    System.out.printf("내용: %s\n", this.content);
    System.out.printf("작성자: %s\n", this.writer);
    System.out.printf("작성일: %s\n", this.date);
  }

  public void delete() {
    System.out.println("게시글 삭제:");
    this.title = "";
    this.content = "";
    this.writer = "";
    this.date = "";
  }
}
