package bitcamp.myapp.handler.assignment;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public class AssignmentDeleteHandler implements MenuHandler {

  AssignmentRepository assignmentRepository;
  Prompt prompt;

  public AssignmentDeleteHandler(AssignmentRepository assignmentRepository, Prompt prompt) {
    this.assignmentRepository = assignmentRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.RESET, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    if (assignmentRepository.remove(index) == null) {
      System.out.println("과제 번호가 유효하지 않습니다.");
    }
  }
}
