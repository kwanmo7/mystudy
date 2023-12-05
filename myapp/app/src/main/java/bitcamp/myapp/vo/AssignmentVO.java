package bitcamp.myapp.vo;

public class AssignmentVO {

  public String title;
  public String content;
  public String deadline;

  public void modifyAssignment(AssignmentVO stAss) {
    this.title = stAss.title;
    this.content = stAss.content;
    this.deadline = stAss.deadline;
  }
  public void printAssignment(){
    System.out.printf("과제명: %s\n", this.title);
    System.out.printf("내용: %s\n", this.content);
    System.out.printf("제출 마감일: %s\n", this.deadline);
  }
  public void delete(){
    this.title = "";
    this.content = "";
    this.deadline = "";
  }

}
