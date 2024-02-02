package taxApp.handler.member;

import taxApp.dao.MemberDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;
import taxApp.vo.Member;

public class MemberAddHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberAddHandler(Prompt prompt, MemberDao memberDao) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    try{
      Member member = new Member();
      System.out.println("[회원 등록]");
      member.setName(prompt.input("이름 : >"));
      member.setTel(prompt.input("전화번호 : >"));
      member.setEmail(prompt.input("이메일 : >"));
      member.setWaterCd(prompt.input("수도코드 : >"));
      member.setElectricCd(prompt.input("전기코드 : >"));
      memberDao.add(member);
    }catch (Exception e){
      System.out.println("회원 등록 중 오류 발생");
      System.out.println("다시 시도하시기 바랍니다.");
    }
  }
}
