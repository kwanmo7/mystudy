package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.handler.Help.HelpHandler;
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
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class App {

  public static void main(String[] args) {
    Prompt prompt = new Prompt(System.in);
//    new MainMenu(prompt).execute();
    ArrayList<Assignment> assignmentRepository = new ArrayList<>();
    ArrayList<Board> boardRepository = new ArrayList<>();
    ArrayList<Member> memberRepository = new ArrayList<>();
    ArrayList<Board> greetingRepository = new ArrayList<>();

    MenuGroup mainMenu = new MenuGroup("메인");
    MenuGroup assignmentMenu = new MenuGroup("과제");

    assignmentMenu.add(new MenuItem("등록", new AssignmentAddHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem("조회", new AssignmentViewHandler(assignmentRepository, prompt)));
    assignmentMenu.add(
        new MenuItem("변경", new AssignmentModifyHandler(assignmentRepository, prompt)));
    assignmentMenu.add(
        new MenuItem("삭제", new AssignmentDeleteHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem("목록", new AssignmentListHandler(assignmentRepository, prompt)));
    mainMenu.add(assignmentMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    boardMenu.add(new MenuItem("등록", new BoardAddHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("조회", new BoardViewHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("변경", new BoardModifyHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("삭제", new BoardDeleteHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("목록", new BoardListHandler(boardRepository, prompt)));
    mainMenu.add(boardMenu);

    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new MenuItem("등록", new MemberAddHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("조회", new MemberViewHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("변경", new MemberModifyHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("삭제", new MemberDeleteHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("목록", new MemberListHandler(memberRepository, prompt)));
    mainMenu.add(memberMenu);

    MenuGroup greetingMenu = new MenuGroup("가입인사");
    greetingMenu.add(new MenuItem("등록", new BoardAddHandler(greetingRepository, prompt)));
    greetingMenu.add(new MenuItem("조회", new BoardViewHandler(greetingRepository, prompt)));
    greetingMenu.add(new MenuItem("변경", new BoardModifyHandler(greetingRepository, prompt)));
    greetingMenu.add(new MenuItem("삭제", new BoardDeleteHandler(greetingRepository, prompt)));
    greetingMenu.add(new MenuItem("목록", new BoardListHandler(greetingRepository, prompt)));
    mainMenu.add(greetingMenu);

    MenuGroup helpMenu = new MenuGroup("도움말");
    helpMenu.add(new MenuItem("도움말", new HelpHandler(prompt)));
    mainMenu.add(helpMenu);

    // Exception 처리를 하지 않은 부분에서 에러가 발생했을때 프로그램이 종료되지 않도록
    // 최종적으로 가장 먼저 실행되는 곳에서 try ~ catch 문을 반복문안에 두어서 프로그램 종료를 방지
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
