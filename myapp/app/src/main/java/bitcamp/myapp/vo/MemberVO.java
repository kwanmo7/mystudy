package bitcamp.myapp.vo;

public class MemberVO {

  public String email;
  public String name;
  public String password;
  public String date;

  public static boolean checkForMem() {
    if (ConstVO.iMemberIndex == 0) {
      return false;
    }
    return true;
  }

  public void printMember() {
    System.out.println("------------------------------------------------------------------");
    System.out.printf("이메일: %s\n", this.email);
    System.out.printf("이름: %s\n", this.name);
    System.out.printf("비밀번호: %s\n", this.password);
    System.out.printf("가입일: %s\n", this.date);
    System.out.println("------------------------------------------------------------------");
  }

  public void printMemberList() {
    System.out.println("------------------------------------------------------------------");
    System.out.printf("%-20s\t%-20s\t%s\n", this.email, this.name, this.date);
    System.out.println("------------------------------------------------------------------");
  }
}
