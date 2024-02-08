package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

  Connection connection;

  public MemberDaoImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void add(Member member) {
    try (PreparedStatement pstmt = connection.prepareStatement(
        "insert into members(email,name,password) values(?,?,sha2(?,256))")) {
      pstmt.setString(1, member.getEmail());
      pstmt.setString(2, member.getName());
      pstmt.setString(3, member.getPassword());
      pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 등록 중 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement pstmt = connection.prepareStatement(
        "delete from members where member_no=?")) {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 삭제 중 오류", e);
    }
  }

  @Override
  public List<Member> findAll() {
    try (PreparedStatement pstmt = connection.prepareStatement(
        "select * from members order by member_no");
        ResultSet rs = pstmt.executeQuery()) {
      ArrayList<Member> list = new ArrayList<>();
      while (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_no"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setCreatedDate(rs.getDate("created_date"));
        list.add(member);
      }
      return list;
    } catch (Exception e) {
      throw new DaoException("데이터 조회 중 오류", e);
    }
  }

  @Override
  public Member findBy(int no) {
    try (PreparedStatement pstmt = connection.prepareStatement(
        "select * from members where member_no=?")) {
      pstmt.setInt(1, no);
      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Member member = new Member();
          member.setNo(rs.getInt("member_no"));
          member.setName(rs.getString("name"));
          member.setEmail(rs.getString("email"));
          member.setCreatedDate(rs.getDate("created_date"));
          return member;
        }
        return null;
      }
    } catch (Exception e) {
      throw new DaoException("데이터 조회 중 오류", e);
    }
  }

  @Override
  public int update(Member member) {
    try (PreparedStatement pstmt = connection.prepareStatement(
        "update members set email = ?, name = ?, password = sha2(?,256) where member_no =?")) {
      pstmt.setString(1, member.getEmail());
      pstmt.setString(2, member.getName());
      pstmt.setString(3, member.getPassword());
      pstmt.setInt(4, member.getNo());
      return pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 갱신 중 오류", e);
    }
  }
}
