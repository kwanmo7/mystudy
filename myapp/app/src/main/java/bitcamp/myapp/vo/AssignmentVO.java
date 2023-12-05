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
  public void delete(){
    this.title = "";
    this.content = "";
    this.deadline = "";
  }

}
