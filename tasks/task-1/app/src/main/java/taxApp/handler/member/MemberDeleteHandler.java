package taxApp.handler.member;

import taxApp.dao.MemberDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;

public class MemberDeleteHandler extends AbstractMenuHandler {
  private MemberDao memberDao;

  public MemberDeleteHandler(Prompt prompt, MemberDao memberDao) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    try{
      int no = prompt.inputInt("삭제할 회원 번호 : > ");
      memberDao.delete(no);
    }catch (NumberFormatException e) {
      System.out.println("숫자를 입력하세요.");
    }catch (IndexOutOfBoundsException e){
      System.out.println("회원 번호 오류");
    }catch (Exception e){
      System.out.println("회원 삭제 오류");
    }
  }
}
