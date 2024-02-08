package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberModifyHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberModifyHandler(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  protected void action(Prompt prompt) {
    int no = prompt.inputInt("번호? ");
    Member old = memberDao.findBy(no);
    if (old == null) {
      prompt.println("번호가 올바르지 않습니다.");
      return;
    }
    Member member = new Member();
    member.setNo(old.getNo());
    member.setEmail(prompt.input("이메일(%s)? ", old.getEmail()));
    member.setName(prompt.input("이름(%s)? ", old.getName()));
    member.setPassword(prompt.input("새 암호(%s)? ", old.getPassword()));
    member.setCreatedDate(old.getCreatedDate());
    this.memberDao.update(member);
    prompt.println("변경 했습니다.");
  }
}