package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.vo.Assignment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDaoImpl implements AssignmentDao {

  Connection connection;

  public AssignmentDaoImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void add(Assignment assignment) {
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(
          String.format("insert into assignment(title,content,deadline) values('%s','%s','%s')",
              assignment.getTitle(), assignment.getContent(), assignment.getDeadline()));
    } catch (Exception e) {
      throw new DaoException("데이터 등록 중 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = connection.createStatement();
      return stmt.executeUpdate(
          String.format("delete from assignment where assignment_no = %d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 삭제 중 오류", e);
    }
  }

  @Override
  public List<Assignment> findAll() {
    try {
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("select * from assignment");
      ArrayList<Assignment> list = new ArrayList<>();
      while (rs.next()) {
        Assignment assignment = new Assignment();
        assignment.setNo(rs.getInt("assignment_no"));
        assignment.setTitle(rs.getString("title"));
        assignment.setContent(rs.getString("content"));
        assignment.setDeadline(rs.getDate("deadline"));
        list.add(assignment);
      }
      return list;
    } catch (Exception e) {
      throw new DaoException("데이터 조회 중 오류", e);
    }
  }

  @Override
  public Assignment findBy(int no) {
    try {
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("select * from assignment where assignment_no =" + no);
      rs.next();
      Assignment assignment = new Assignment();
      assignment.setNo(rs.getInt("assignment_no"));
      assignment.setTitle(rs.getString("title"));
      assignment.setContent(rs.getString("content"));
      assignment.setDeadline(rs.getDate("deadline"));
      return assignment;
    } catch (Exception e) {
      throw new DaoException("데이터 조회 중 오류", e);
    }
  }

  @Override
  public int update(Assignment assignment) {
    try {
      Statement stmt = connection.createStatement();
      return stmt.executeUpdate(String.format(
          "update assignment set title = '%s', content = '%s', deadline = '%s' where assignment_no = %d",
          assignment.getTitle(), assignment.getContent(), assignment.getDeadline(),
          assignment.getNo()));
    } catch (Exception e) {
      throw new DaoException("데이터 갱신 중 오류", e);
    }
  }
}
