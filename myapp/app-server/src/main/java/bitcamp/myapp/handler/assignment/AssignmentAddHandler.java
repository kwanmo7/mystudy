package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.sql.Connection;

public class AssignmentAddHandler extends AbstractMenuHandler {

  DBConnectionPool connectionPool;
  private AssignmentDao assignmentDao;

  public AssignmentAddHandler(DBConnectionPool connectionPool, AssignmentDao assignmentDao) {
    this.connectionPool = connectionPool;
    this.assignmentDao = assignmentDao;
  }

  @Override
  protected void action(Prompt prompt) {
    Connection connection = null;
    try {
      Assignment assignment = new Assignment();
      assignment.setTitle(prompt.input("과제명? "));
      assignment.setContent(prompt.input("내용? "));
      assignment.setDeadline(prompt.inputDate("제출 마감일?(예: 2023-12-25) "));
      connection = connectionPool.getConnection();
      connection.setAutoCommit(false);
      assignmentDao.add(assignment);
      connection.commit();
    } catch (Exception e) {
      try {
        connection.rollback();
      } catch (Exception e2) {
      }
      prompt.println("과제 입력 중 오류 발생!");
      prompt.println("다시 시도하시기 바랍니다.");
    } finally {
      try {
        connection.setAutoCommit(true);
      } catch (Exception e) {
      }
      connectionPool.returnConnection(connection);
    }
  }
}
