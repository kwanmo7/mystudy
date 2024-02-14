package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;
import java.util.List;

public class AssignmentListHandler extends AbstractMenuHandler {

  private AssignmentDao assignmentDao;

  public AssignmentListHandler(AssignmentDao assignmentDao) {
    this.assignmentDao = assignmentDao;
  }

  @Override
  protected void action(Prompt prompt) {
    prompt.printf("%4s\t%-20s\t%s\n", "No", "과제", "제출마감일");
    try {
      List<Assignment> list = assignmentDao.findAll();
      list.forEach(item -> prompt.printf("%4d\t%-20s\t%s\n", item.getNo(), item.getTitle(),
          item.getDeadline()));
    } catch (Exception e) {
      prompt.println("조회 오류");
    }
  }
}
