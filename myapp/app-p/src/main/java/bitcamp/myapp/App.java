package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.myapp.handler.HelpHandler;
import bitcamp.myapp.handler.assignment.AssignmentAddHandler;
import bitcamp.myapp.handler.assignment.AssignmentDeleteHandler;
import bitcamp.myapp.handler.assignment.AssignmentListHandler;
import bitcamp.myapp.handler.assignment.AssignmentModifyHandler;
import bitcamp.myapp.handler.assignment.AssignmentViewHandler;
import bitcamp.myapp.handler.board.BoardAddHandler;
import bitcamp.myapp.handler.board.BoardDeleteHandler;
import bitcamp.myapp.handler.board.BoardListHandler;
import bitcamp.myapp.handler.board.BoardModifyHandler;
import bitcamp.myapp.handler.board.BoardViewHandler;
import bitcamp.myapp.handler.member.MemberAddHandler;
import bitcamp.myapp.handler.member.MemberDeleteHandler;
import bitcamp.myapp.handler.member.MemberListHandler;
import bitcamp.myapp.handler.member.MemberModifyHandler;
import bitcamp.myapp.handler.member.MemberViewHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.ArrayList;
import bitcamp.util.LinkedList;
import bitcamp.util.List;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) throws Exception {
    Prompt prompt = new Prompt(System.in);

    List<Board> boardRepository = new LinkedList<>();
    List<Assignment> assignmentRepository = new LinkedList<>();
    List<Member> memberRepository = new ArrayList<>();
    List<Board> greetingRepository = new ArrayList<>();

    MenuGroup mainMenu = MenuGroup.getInstance("메인");

    MenuGroup assignmentMenu = mainMenu.addMenuGroup("과제");
    assignmentMenu.addMenuItem("등록", new AssignmentAddHandler(assignmentRepository, prompt));
    assignmentMenu.addMenuItem("조회", new AssignmentViewHandler(assignmentRepository, prompt));
    assignmentMenu.addMenuItem(
        "변경", new AssignmentModifyHandler(assignmentRepository, prompt));
    assignmentMenu.addMenuItem(
        "삭제", new AssignmentDeleteHandler(assignmentRepository, prompt));
    assignmentMenu.addMenuItem("목록", new AssignmentListHandler(assignmentRepository, prompt));

    MenuGroup boardMenu = mainMenu.addMenuGroup("게시글");
    boardMenu.addMenuItem("등록", new BoardAddHandler(boardRepository, prompt));
    boardMenu.addMenuItem("조회", new BoardViewHandler(boardRepository, prompt));
    boardMenu.addMenuItem("변경", new BoardModifyHandler(boardRepository, prompt));
    boardMenu.addMenuItem("삭제", new BoardDeleteHandler(boardRepository, prompt));
    boardMenu.addMenuItem("목록", new BoardListHandler(boardRepository, prompt));

    MenuGroup memberMenu = mainMenu.addMenuGroup("회원");
    memberMenu.addMenuItem("등록", new MemberAddHandler(memberRepository, prompt));
    memberMenu.addMenuItem("조회", new MemberViewHandler(memberRepository, prompt));
    memberMenu.addMenuItem("변경", new MemberModifyHandler(memberRepository, prompt));
    memberMenu.addMenuItem("삭제", new MemberDeleteHandler(memberRepository, prompt));
    memberMenu.addMenuItem("목록", new MemberListHandler(memberRepository, prompt));

    MenuGroup greetingMenu = mainMenu.addMenuGroup("가입인사");
    greetingMenu.addMenuItem("등록", new BoardAddHandler(greetingRepository, prompt));
    greetingMenu.addMenuItem("조회", new BoardViewHandler(greetingRepository, prompt));
    greetingMenu.addMenuItem("변경", new BoardModifyHandler(greetingRepository, prompt));
    greetingMenu.addMenuItem("삭제", new BoardDeleteHandler(greetingRepository, prompt));
    greetingMenu.addMenuItem("목록", new BoardListHandler(greetingRepository, prompt));

    mainMenu.addMenuItem("도움말", new HelpHandler(prompt));

    // 프로그램을 실행하다가 어느 지점에서 예외가 발생하면 해당 위치에서 적절한 조치를 취할 것이다.
    // 다만 그에 벗어나서 조치가 되지 않은 예외가 보고 되는 경우를 대비해
    // 마지막 보루인 main()에서는 예외를 처리해야 한다.
    // main()에서 마저 처리하지 않는다면 JVM에게 보고될 것이고,
    // JVM은 개발자나 알아 볼 메시지를 출력하고 종료할 것이다.
    //
    while (true) {
      try {
        mainMenu.execute(prompt);
        prompt.close();
        break;
      } catch (Exception e) {
        System.out.println("예외 발생!");
      }
    }
  }
}
