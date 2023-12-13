package bitcamp.myapp.handler.member;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class MemberModifyHandler implements MenuHandler {

  ArrayList<Member> objectRepository;
  Prompt prompt;

  public MemberModifyHandler(ArrayList<Member> objectRepository, Prompt prompt) {
    this.objectRepository = objectRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.RESET, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    Member old = objectRepository.get(index);
    if (old == null) {
      System.out.println("회원 번호가 올바르지 않습니다.");
      return;
    }

    Member member = new Member();
    member.email = this.prompt.input("이메일(%s)? ", old.email);
    member.name = this.prompt.input("이름(%s)? ", old.name);
    member.password = this.prompt.input("새 암호(%s)? ", old.password);
    member.createdDate = this.prompt.input("가입일(%s)? ", old.createdDate);
    this.objectRepository.set(index, member);
  }
}
