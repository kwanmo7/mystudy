package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;
import java.util.List;

public class MemberListHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberListHandler(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  protected void action(Prompt prompt) {
    prompt.printf("%s\t%-10s\t%30s\t%s\n", "No", "이름", "이메일", "가입일");
    try {
      List<Member> list = memberDao.findAll();
      list.forEach(item -> prompt.printf("%4d\t%-10s\t%30s\t%4$tY-%4$tm-%4$td\n", item.getNo(),
          item.getName(), item.getEmail(),
          item.getCreatedDate()));
    } catch (Exception e) {
      prompt.println("조회 오류");
    }
  }
}
