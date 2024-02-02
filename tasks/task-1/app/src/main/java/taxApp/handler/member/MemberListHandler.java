package taxApp.handler.member;

import java.util.List;
import taxApp.dao.MemberDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;
import taxApp.vo.Member;

public class MemberListHandler extends AbstractMenuHandler {
  private MemberDao memberDao;

  public MemberListHandler(Prompt prompt, MemberDao memberDao) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    List<Member> list = memberDao.findAll();
    for( Member member : list ){
      System.out.println("====================================");
      System.out.printf("회원번호 : %d\n",member.getNo());
      System.out.printf("이름 : %s\n",member.getName());
      System.out.printf("전화번호 : %s\n",member.getTel());
      System.out.printf("이메일 : %s\n",member.getEmail());
      System.out.printf("가입일 : %1$tY-%1$tm-%1$td\n",member.getEntryDate());
      System.out.printf("수도코드 : %s\n",member.getWaterCd());
      System.out.printf("전기코드 : %s\n",member.getElectricCd());
    }
    System.out.println("====================================");
  }
}
