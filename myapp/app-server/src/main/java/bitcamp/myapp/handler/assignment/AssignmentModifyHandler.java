package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.sql.Connection;

public class AssignmentModifyHandler extends AbstractMenuHandler {

  private DBConnectionPool connectionPool;
  private AssignmentDao assignmentDao;

  public AssignmentModifyHandler(DBConnectionPool connectionPool, AssignmentDao assignmentDao) {
    this.connectionPool = connectionPool;
    this.assignmentDao = assignmentDao;
  }

  @Override
  protected void action(Prompt prompt) {
    Connection connection = null;
    try {
      connection = connectionPool.getConnection();
      int no = prompt.inputInt("번호? ");
      Assignment old = assignmentDao.findBy(no);
      Assignment assignment = new Assignment();
      assignment.setNo(old.getNo());
      assignment.setTitle(prompt.input("과제명(%s)? ", old.getTitle()));
      assignment.setContent(prompt.input("내용(%s)? ", old.getContent()));
      assignment.setDeadline(prompt.inputDate("제출 마감일(%s)? ", old.getDeadline()));
      assignmentDao.update(assignment);
    } catch (NumberFormatException e) {
      prompt.println("숫자를 입력 하세요");
    } catch (IndexOutOfBoundsException e) {
      prompt.println("과제 번호가 유효하지 않습니다.");
    } catch (IllegalArgumentException e) {
      prompt.println("과제 변경 오류!");
      prompt.println("다시 시도 하세요.");
    } catch (Exception e) {
      prompt.println("실행 오류");
    } finally {
      connectionPool.returnConnection(connection);
    }
  }
}
