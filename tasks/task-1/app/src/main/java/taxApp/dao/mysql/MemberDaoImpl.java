package taxApp.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import taxApp.dao.MemberDao;
import taxApp.vo.Member;

public class MemberDaoImpl implements MemberDao {

  Connection connection;

  public MemberDaoImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void add(Member member) {
    try{
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(
          String.format("insert into member(name,tel,email,waterCd,electricCd) "
              + "values('%s','%s','%s','%s','%s')",
              member.getName(),member.getTel(),member.getEmail(),
              member.getWaterCd(),member.getElectricCd()));
    }catch (Exception e){
      throw new RuntimeException("데이터 등록 중 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try{
      Statement stmt = connection.createStatement();
      return stmt.executeUpdate(String.format("delete from member where member_no = %d", no));
    }catch (Exception e){
      throw new RuntimeException("데이터 삭제 중 오류",e);
    }
  }

  @Override
  public List<Member> findAll() {
    try{
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("select * from member");
      ArrayList<Member> list = new ArrayList<>();
      while(rs.next()){
        Member member = new Member();
        member.setNo(rs.getInt("member_no"));
        member.setName(rs.getString("name"));
        member.setTel(rs.getString("tel"));
        member.setEmail(rs.getString("email"));
        member.setEntryDate(rs.getDate("entryDate"));
        member.setWaterCd(rs.getString("waterCd"));
        member.setElectricCd(rs.getString("electricCd"));
        list.add(member);
      }
      return list;
    }catch (Exception e){
      throw new RuntimeException("데이터 조회 중 오류",e);
    }
  }

  @Override
  public Member findBy(int no) {
    try{
     Statement stmt = connection.createStatement();
     ResultSet rs = stmt.executeQuery("select * from member where member_no ="+no);
     Member member = new Member();
     rs.next();
     member.setNo(rs.getInt("member_no"));
     member.setName(rs.getString("name"));
     member.setTel(rs.getString("tel"));
     member.setEmail(rs.getString("email"));
     member.setEntryDate(rs.getDate("entryDate"));
     member.setWaterCd(rs.getString("waterCd"));
     member.setElectricCd(rs.getString("electricCd"));
     return member;
    }catch (Exception e){
      throw new RuntimeException("데이터 조회 중 오류",e);
    }
  }

  @Override
  public int update(Member member) {
    try{
      Statement stmt = connection.createStatement();
      return stmt.executeUpdate(String.format("update member set name = '%s',tel = '%s' , email = '%s' , "
          + "waterCd = '%s' , electricCd = '%s' where member_no = '%s'",
          member.getName(),member.getTel(),member.getEmail(),
          member.getWaterCd(),member.getElectricCd(),member.getNo()));
    }catch (Exception e){
      throw new RuntimeException("데이터 갱신 중 오류",e);
    }
  }
}
