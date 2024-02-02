package taxApp.handler.member;

import taxApp.dao.MemberDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;
import taxApp.vo.Member;

public class MemberViewHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberViewHandler(Prompt prompt, MemberDao memberDao) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    try{
      int no = prompt.inputInt("조회할 회원 번호 : >");
      Member member = memberDao.findBy(no);
      System.out.println("====================================");
      System.out.printf("회원번호 : %d\n",member.getNo());
      System.out.printf("이름 : %s\n",member.getName());
      System.out.printf("전화번호 : %s\n",member.getTel());
      System.out.printf("이메일 : %s\n",member.getEmail());
      System.out.printf("가입일 : %1$tY-%1$tm-%1$td\n",member.getEntryDate());
      System.out.printf("수도코드 : %s\n",member.getWaterCd());
      System.out.printf("전기코드 : %s\n",member.getElectricCd());
      System.out.println("====================================");
    }catch (NumberFormatException e){
      System.out.println("숫자를 입력 하세요");
    }catch (IndexOutOfBoundsException e){
      System.out.println("회원 번호가 유효하지 않습니다.");
    }catch (Exception e){
      System.out.println("회원 조회 중 오류");
    }
  }
}
