package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

  Connection connection;

  public MemberDaoImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void add(Member member) {
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(
          String.format("insert into members(email,name,password) values('%s','%s',sha2('%s',256))",
              member.getEmail(), member.getName(), member.getPassword()));
    } catch (Exception e) {
      throw new DaoException("데이터 등록 중 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = connection.createStatement();
      return stmt.executeUpdate("delete from members where =" + no);
    } catch (Exception e) {
      throw new DaoException("데이터 삭제 중 오류", e);
    }
  }

  @Override
  public List<Member> findAll() {
    try {
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("select * from members");
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
    try {
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("select * from members where =" + no);
      rs.next();
      Member member = new Member();
      member.setNo(rs.getInt("member_no"));
      member.setName(rs.getString("name"));
      member.setEmail(rs.getString("email"));
      member.setCreatedDate(rs.getDate("created_data"));
      return member;
    } catch (Exception e) {
      throw new DaoException("데이터 조회 중 오류", e);
    }
  }

  @Override
  public int update(Member member) {
    try {
      Statement stmt = connection.createStatement();
      return stmt.executeUpdate(
          String.format("update members set email = '%s', name = '%s', password = sha2('%s',256)",
              member.getEmail(), member.getName(), member.getPassword()));
    } catch (Exception e) {
      throw new DaoException("데이터 갱신 중 오류", e);
    }
  }

//  public String encrypt(String text, ResultSet rs) throws NoSuchAlgorithmException, SQLException {
//    MessageDigest md = MessageDigest.getInstance("SHA-256");
//    md.update(rs.getString("password").getBytes());
//    byte[] bytes = md.digest();
//    StringBuilder sb = new StringBuilder();
//    for (byte b : bytes) {
//      sb.append(String.format("%02x", b));
//    }
//    return sb.toString();
//  }
}
