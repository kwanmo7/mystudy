package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.sql.Connection;

public class AssignmentViewHandler extends AbstractMenuHandler {

  private DBConnectionPool connectionPool;
  private AssignmentDao assignmentDao;

  public AssignmentViewHandler(DBConnectionPool connectionPool, AssignmentDao assignmentDao) {
    this.connectionPool = connectionPool;
    this.assignmentDao = assignmentDao;
  }

  @Override
  protected void action(Prompt prompt) {
    Connection connection = null;
    try {
      connection = connectionPool.getConnection();
      int no = prompt.inputInt("번호? ");
      Assignment assignment = assignmentDao.findBy(no);
      prompt.printf("번호: %s\n", assignment.getNo());
      prompt.printf("과제명: %s\n", assignment.getTitle());
      prompt.printf("내용: %s\n", assignment.getContent());
      prompt.printf("제출 마감일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", assignment.getDeadline());
    } catch (Exception e) {
      prompt.println("조회 오류.");
    } finally {
      connectionPool.returnConnection(connection);
    }
  }
}
