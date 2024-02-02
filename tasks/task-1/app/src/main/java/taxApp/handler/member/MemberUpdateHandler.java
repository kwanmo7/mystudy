package taxApp.handler.member;

import taxApp.dao.MemberDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;
import taxApp.vo.Member;

public class MemberUpdateHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberUpdateHandler(Prompt prompt, MemberDao memberDao) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    try{
      int no = prompt.inputInt("수정할 회원 번호 : >");
      Member old = memberDao.findBy(no);
      Member newMember = new Member();
      newMember.setNo(old.getNo());
      newMember.setName(prompt.input("이름(%s) : >",old.getName()));
      newMember.setTel(prompt.input("전화번호(%s) : >",old.getTel()));
      newMember.setEmail(prompt.input("이메일(%s) : >",old.getEmail()));
      newMember.setWaterCd(prompt.input("수도코드(%s) : >",old.getWaterCd()));
      newMember.setElectricCd(prompt.input("전기코드(%s) : >",old.getElectricCd()));
      memberDao.update(newMember);
    }catch (NumberFormatException e){
      System.out.println("숫자를 입력 하세요");
    }catch (IndexOutOfBoundsException e){
      System.out.println("회원 번호가 유효하지 않습니다.");
    } catch (Exception e){
      System.out.println("회원 변경 오류");
    }
  }
}
