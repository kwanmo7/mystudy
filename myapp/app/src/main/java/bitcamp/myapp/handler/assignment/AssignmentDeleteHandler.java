package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;
import java.util.List;

public class AssignmentDeleteHandler extends AbstractMenuHandler {

  private List<Assignment> objectRepository;

  public AssignmentDeleteHandler(List<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    try {
      int index = this.prompt.inputInt("번호? ");
      if (objectRepository.remove(index) == null) {
        System.out.println("과제 번호가 유효하지 않습니다.");
      }
    } catch (Exception e) {
      System.out.println("삭제 오류");
    }
  }
}
