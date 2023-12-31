package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
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
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class App {

  Prompt prompt = new Prompt(System.in);

  List<Assignment> assignmentRepository;
  List<Board> boardRepository;
  List<Member> memberRepository;
  List<Board> greetingRepository;
  MenuGroup mainMenu;

  App() {
//    loadData("assignment.data", assignmentRepository);
//    loadData("board.data", boardRepository);
//    loadData("member.data", memberRepository);
//    loadData("greeting.data", greetingRepository);
    assignmentRepository = loadData("assignment.json", Assignment.class);
    boardRepository = loadData("board.json", Board.class);
    memberRepository = loadData("member.json", Member.class);
    greetingRepository = loadData("greeting.json", Board.class);
    prepareMenu();
  }

  public static void main(String[] args) {
    new App().run();
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");
    MenuGroup assignmentMenu = mainMenu.addGroup("과제");

    assignmentMenu.addItem("등록", new AssignmentAddHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("조회", new AssignmentViewHandler(assignmentRepository, prompt));
    assignmentMenu.addItem(
        "변경", new AssignmentModifyHandler(assignmentRepository, prompt));
    assignmentMenu.addItem(
        "삭제", new AssignmentDeleteHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("목록", new AssignmentListHandler(assignmentRepository, prompt));

    MenuGroup boardMenu = mainMenu.addGroup("게시글");
    boardMenu.addItem("등록", new BoardAddHandler(boardRepository, prompt));
    boardMenu.addItem("조회", new BoardViewHandler(boardRepository, prompt));
    boardMenu.addItem("변경", new BoardModifyHandler(boardRepository, prompt));
    boardMenu.addItem("삭제", new BoardDeleteHandler(boardRepository, prompt));
    boardMenu.addItem("목록", new BoardListHandler(boardRepository, prompt));

    MenuGroup memberMenu = mainMenu.addGroup("회원");
    memberMenu.addItem("등록", new MemberAddHandler(memberRepository, prompt));
    memberMenu.addItem("조회", new MemberViewHandler(memberRepository, prompt));
    memberMenu.addItem("변경", new MemberModifyHandler(memberRepository, prompt));
    memberMenu.addItem("삭제", new MemberDeleteHandler(memberRepository, prompt));
    memberMenu.addItem("목록", new MemberListHandler(memberRepository, prompt));

    MenuGroup greetingMenu = mainMenu.addGroup("가입인사");
    greetingMenu.addItem("등록", new BoardAddHandler(greetingRepository, prompt));
    greetingMenu.addItem("조회", new BoardViewHandler(greetingRepository, prompt));
    greetingMenu.addItem("변경", new BoardModifyHandler(greetingRepository, prompt));
    greetingMenu.addItem("삭제", new BoardDeleteHandler(greetingRepository, prompt));
    greetingMenu.addItem("목록", new BoardListHandler(greetingRepository, prompt));

    MenuGroup helpMenu = mainMenu.addGroup("도움말");
    helpMenu.addItem("도움말", new HelpHandler(prompt));
  }

  void run() {
    while (true) {
      try {
        mainMenu.execute(prompt);
        prompt.close();
        break;
      } catch (Exception e) {
        System.out.println("예외 발생!");
      }
    }
    saveData("assignment.json", assignmentRepository);
    saveData("board.json", boardRepository);
    saveData("member.json", memberRepository);
    saveData("greeting.json", greetingRepository);
  }

//  <E> void loadData(String filepath, List<E> dataList) {
//    try (ObjectInputStream in = new ObjectInputStream(
//        new BufferedInputStream(new FileInputStream(filepath)))) {
//      List<E> list = (List<E>) in.readObject();
//      dataList.addAll(list);
//    } catch (Exception e) {
//      System.out.printf("%s 파일 로딩 중 오류 발생!\n", filepath);
//      e.printStackTrace();
//    }
//  }

  <E> List<E> loadData(String filepath, Class<E> clazz) {
    try (BufferedReader in = new BufferedReader(new FileReader(filepath))) {
      // File에서 Json 문자열을 모두 읽어서 버퍼에 저장
      StringBuilder stringBuilder = new StringBuilder();
      String str;
      while ((str = in.readLine()) != null) {
        stringBuilder.append(str);
      }
      // 버퍼에 저장된 JSON 문자열을 가지고 컬렉션 객체를 생성
      return (List<E>) new GsonBuilder().setDateFormat("yyyy-MM-dd").create()
          .fromJson(stringBuilder.toString(),
              TypeToken.getParameterized(ArrayList.class, clazz));
    } catch (Exception e) {
      System.out.printf("%s 파일 로딩 중 오류 발생!\n", filepath);
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

  void saveData(String filepath, List<?> datalist) {
    try (BufferedWriter out = new BufferedWriter(new FileWriter(filepath))) {
      out.write(new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(datalist));
    } catch (Exception e) {
      System.out.printf("%s 파일 저장 중 오류 발생!\n", filepath);
      e.printStackTrace();
    }
  }

//  void saveData(String filepath, List<?> dataList) {
//    try (ObjectOutputStream out = new ObjectOutputStream(
//        new BufferedOutputStream(new FileOutputStream(filepath)))) {
//      out.writeObject(dataList);
//    } catch (Exception e) {
//      System.out.printf("%s 파일 저장 중 오류 발생!\n", filepath);
//      e.printStackTrace();
//    }
//  }
}
