package bitcamp.myapp.vo;

public class AssignmentVO {

  public String title;
  public String content;
  public String deadline;

  public static boolean checkForAss() {
    if (ConstVO.iAssIndex == 0) {
      return false;
    }
    return true;
  }

  public void printAssignment() {
    System.out.println("-----------------------------------------------------------------------");
    System.out.printf("과제명: %s\n", this.title);
    System.out.printf("내용: %s\n", this.content);
    System.out.printf("제출 마감일: %s\n", this.deadline);
    System.out.println("-----------------------------------------------------------------------");
  }

  public void printAssignmentlist() {
    System.out.println("-----------------------------------------------------------------------");
    System.out.printf("%-20s\t%s\n", this.title, this.deadline);
    System.out.println("-----------------------------------------------------------------------");
  }
}
