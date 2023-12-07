package bitcamp.myapp.vo;

public class BoardVO {

  public String title;
  public String content;
  public String writer;
  public String date;

  public static boolean checkForBoard() {
    if (ConstVO.iBoardIndex == 0) {
      return false;
    }
    return true;
  }

  public void printBoard() {
    System.out.println("-----------------------------------------------------------------------");
    System.out.printf("제목: %s\n", this.title);
    System.out.printf("내용: %s\n", this.content);
    System.out.printf("작성자: %s\n", this.writer);
    System.out.printf("작성일: %s\n", this.date);
    System.out.println("-----------------------------------------------------------------------");
  }

  public void printBoardList() {
    System.out.println("-----------------------------------------------------------------------");
    System.out.printf("%-20s\t%-20s\t%s\n", this.title, this.writer, this.date);
    System.out.println("-----------------------------------------------------------------------");
  }
}
