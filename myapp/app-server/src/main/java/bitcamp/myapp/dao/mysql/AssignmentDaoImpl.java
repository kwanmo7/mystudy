package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.vo.Assignment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDaoImpl implements AssignmentDao {

  Connection connection;

  public AssignmentDaoImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void add(Assignment assignment) {
    try (PreparedStatement pstmt = connection.prepareStatement(
        "insert into assignment(title,content,deadline) values(?,?,?)")) {

      pstmt.setString(1, assignment.getTitle());
      pstmt.setString(2, assignment.getContent());
      pstmt.setDate(3, assignment.getDeadline());
      pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 등록 중 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement pstmt = connection.prepareStatement(
        "delete from assignment where assignment_no = ?")) {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 삭제 중 오류", e);
    }
  }

  @Override
  public List<Assignment> findAll() {
    try (PreparedStatement pstmt = connection.prepareStatement(
        "select * from assignment order by assignment_no desc");
        ResultSet rs = pstmt.executeQuery()) {
      ArrayList<Assignment> list = new ArrayList<>();
      while (rs.next()) {
        Assignment assignment = new Assignment();
        assignment.setNo(rs.getInt("assignment_no"));
        assignment.setTitle(rs.getString("title"));
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
    try (PreparedStatement pstmt = connection.prepareStatement(
        "select * from assignment where assignment_no =?")) {
      pstmt.setInt(1, no);
      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Assignment assignment = new Assignment();
          assignment.setNo(rs.getInt("assignment_no"));
          assignment.setTitle(rs.getString("title"));
          assignment.setContent(rs.getString("content"));
          assignment.setDeadline(rs.getDate("deadline"));
          return assignment;
        }
        return null;
      }
    } catch (Exception e) {
      throw new DaoException("데이터 조회 중 오류", e);
    }
  }

  @Override
  public int update(Assignment assignment) {
    try (PreparedStatement pstmt = connection.prepareStatement(
        "update assignment set title = ?, content = ?, deadline = ? where assignment_no = ?")) {
      pstmt.setString(1, assignment.getTitle());
      pstmt.setString(2, assignment.getContent());
      pstmt.setDate(3, assignment.getDeadline());
      pstmt.setInt(4, assignment.getNo());
      return pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 갱신 중 오류", e);
    }
  }
}