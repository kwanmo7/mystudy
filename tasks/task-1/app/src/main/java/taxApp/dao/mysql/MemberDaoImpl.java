package taxApp.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    try(PreparedStatement pstmt = connection.prepareStatement("insert into member(name,tel,email,waterCd,electricCd) "
        + "values(?,?,?,?,?)")){
      pstmt.setString(1,member.getName());
      pstmt.setString(2,member.getTel());
      pstmt.setString(3,member.getEmail());
      pstmt.setString(4,member.getWaterCd());
      pstmt.setString(5,member.getElectricCd());
      pstmt.executeUpdate();
    }catch (Exception e){
      throw new RuntimeException("데이터 등록 중 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try(PreparedStatement pstmt = connection.prepareStatement("delete from member where member_no = ?")){
      pstmt.setInt(1,no);
      return pstmt.executeUpdate();
    }catch (Exception e){
      throw new RuntimeException("데이터 삭제 중 오류",e);
    }
  }

  @Override
  public List<Member> findAll() {
    try(PreparedStatement pstmt = connection.prepareStatement("select * from member");
        ResultSet rs = pstmt.executeQuery()){
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
    try(PreparedStatement pstmt = connection.prepareStatement("select * from member where member_no =?")){
     pstmt.setInt(1,no);
     try(ResultSet rs = pstmt.executeQuery()){
        Member member = new Member();
        if(rs.next()){
          member.setNo(rs.getInt("member_no"));
          member.setName(rs.getString("name"));
          member.setTel(rs.getString("tel"));
          member.setEmail(rs.getString("email"));
          member.setEntryDate(rs.getDate("entryDate"));
          member.setWaterCd(rs.getString("waterCd"));
          member.setElectricCd(rs.getString("electricCd"));
          return member;
        }
        return null;
     }
    }catch (Exception e){
      throw new RuntimeException("데이터 조회 중 오류",e);
    }
  }

  @Override
  public int update(Member member) {
    try(PreparedStatement pstmt = connection.prepareStatement("update member set name = ?,tel = ? , email = ? , "
        + "waterCd = ? , electricCd = ? where member_no = ?")){
      pstmt.setString(1,member.getName());
      pstmt.setString(2,member.getTel());
      pstmt.setString(3,member.getEmail());
      pstmt.setString(4,member.getWaterCd());
      pstmt.setString(5,member.getElectricCd());
      pstmt.setInt(6,member.getNo());
      return pstmt.executeUpdate();
    }catch (Exception e){
      throw new RuntimeException("데이터 갱신 중 오류",e);
    }
  }
}
