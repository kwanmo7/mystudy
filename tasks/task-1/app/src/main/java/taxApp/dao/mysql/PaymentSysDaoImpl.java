package taxApp.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import taxApp.dao.PaymentSysDao;
import taxApp.vo.PaymentSys;

public class PaymentSysDaoImpl implements PaymentSysDao {

  Connection connection;

  public PaymentSysDaoImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void addForWater(PaymentSys paymentSys) {
    try(PreparedStatement pstmt = connection.prepareStatement(
        "insert into waterPayMent(srvCd,fee) values(?,?)")){
      pstmt.setString(1,paymentSys.getSrvCdForWater());
      pstmt.setInt(2,paymentSys.getFeeForWater());
      pstmt.executeUpdate();
    }catch (Exception e){
      throw new RuntimeException("데이터 등록 중 오류",e);
    }
  }

  @Override
  public void addForElectric(PaymentSys paymentSys) {
    try(PreparedStatement pstmt = connection.prepareStatement(
        "insert into electricPayMent(srvCd,fee) values(?,?)")){
      pstmt.setString(1,paymentSys.getSrvCdForElectric());
      pstmt.setInt(2,paymentSys.getFeeForElectric());
      pstmt.executeUpdate();
    }catch (Exception e){
      throw new RuntimeException("데이터 등록 중 오류",e);
    }
  }

  @Override
  public int deleteForWater(int no) {
    try(PreparedStatement pstmt = connection.prepareStatement("delete from waterPayMent where no = ?")){
      pstmt.setInt(1,no);
      return pstmt.executeUpdate();
    }catch (Exception e){
      throw new RuntimeException("데이터 삭제 중 오류",e);
    }
  }

  @Override
  public int deleteForElectric(int no) {
    try(PreparedStatement pstmt = connection.prepareStatement("delete from electricPayMent where no = ?")){
      pstmt.setInt(1,no);
      return pstmt.executeUpdate();
    }catch (Exception e){
      throw new RuntimeException("데이터 삭제 중 오류",e);
    }
  }

  @Override
  public List<PaymentSys> findAll() {
    try(PreparedStatement pstmt = connection.prepareStatement("select t1.no wNo, t1.srvCd wCd, t1.fee wFee,t2.no eNo, t2.srvCd eCd, t2.fee eFee"
        + " from waterPayMent t1 , electricPayMent t2");
        ResultSet rs = pstmt.executeQuery()){
      ArrayList<PaymentSys> list = new ArrayList<>();
      while(rs.next()){
        PaymentSys paymentSys = new PaymentSys();
        paymentSys.setNoForWater(rs.getInt("wNo"));
        paymentSys.setSrvCdForWater(rs.getString("wCd"));
        paymentSys.setFeeForWater(rs.getInt("wFee"));
        paymentSys.setNoForElectric(rs.getInt("eNo"));
        paymentSys.setSrvCdForElectric(rs.getString("eCd"));
        paymentSys.setFeeForElectric(rs.getInt("eFee"));
        list.add(paymentSys);
      }
      return list;
    }catch (Exception e){
      throw new RuntimeException("데이터 조회 중 오류",e);
    }
  }

  @Override
  public int updateForWater(PaymentSys paymentSys) {
    try(PreparedStatement pstmt = connection.prepareStatement(
        "update waterPayMent set srvCd = ?, fee = ? where no = ?")){
      pstmt.setString(1,paymentSys.getSrvCdForWater());
      pstmt.setInt(2,paymentSys.getFeeForWater());
      pstmt.setInt(3,paymentSys.getNoForWater());
      return pstmt.executeUpdate();
    }catch (Exception e){
      throw new RuntimeException("데이터 갱신 중 오류",e);
    }
  }

  @Override
  public int updateForElectric(PaymentSys paymentSys) {
    try(PreparedStatement pstmt = connection.prepareStatement(
        "update electricPayMent set srvCd = ?, fee = ? where no = ?")){
      pstmt.setString(1,paymentSys.getSrvCdForElectric());
      pstmt.setInt(2,paymentSys.getFeeForElectric());
      pstmt.setInt(3,paymentSys.getNoForElectric());
      return pstmt.executeUpdate();
    }catch (Exception e){
      throw new RuntimeException("데이터 갱신 중 오류",e);
    }
  }
  @Override
  public PaymentSys findForWater(int no) {
    try(PreparedStatement pstmt = connection.prepareStatement("select * from waterPayMent where no =?")){
      pstmt.setInt(1,no);
      try(ResultSet rs = pstmt.executeQuery()){
        if(rs.next()){
          PaymentSys paymentSys = new PaymentSys();
          paymentSys.setNoForWater(rs.getInt("no"));
          paymentSys.setSrvCdForWater(rs.getString("srvCd"));
          paymentSys.setFeeForWater(rs.getInt("fee"));
          return paymentSys;
        }
        return null;
      }
    }catch (Exception e){
      throw new RuntimeException("데이터 조회 중 오류",e);
    }
  }

  @Override
  public PaymentSys findFowElectric(int no) {
    try(PreparedStatement pstmt = connection.prepareStatement("select * from electricPayMent where no =?")){
      pstmt.setInt(1,no);
      try(ResultSet rs = pstmt.executeQuery()){
        if(rs.next()){
          PaymentSys paymentSys = new PaymentSys();
          paymentSys.setNoForElectric(rs.getInt("no"));
          paymentSys.setSrvCdForElectric(rs.getString("srvCd"));
          paymentSys.setFeeForElectric(rs.getInt("fee"));
          return paymentSys;
        }
        return null;
      }
    }catch (Exception e){
      throw new RuntimeException("데이터 조회 중 오류",e);
    }
  }
}
