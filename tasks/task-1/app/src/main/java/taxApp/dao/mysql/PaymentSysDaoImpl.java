package taxApp.dao.mysql;

import java.sql.Connection;
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
    try{
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(String.format(
          "insert into waterPayMent(srvCd,fee) values('%s',%d)"
          ,paymentSys.getSrvCdForWater(),paymentSys.getFeeForWater()));

    }catch (Exception e){
      throw new RuntimeException("데이터 등록 중 오류",e);
    }
  }

  @Override
  public void addForElectric(PaymentSys paymentSys) {
    try{
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(String.format(
          "insert into electricPayMent(srvCd,fee) values('%s',%d)"
          ,paymentSys.getSrvCdForElectric(),paymentSys.getFeeForElectric()));
    }catch (Exception e){
      throw new RuntimeException("데이터 등록 중 오류",e);
    }
  }

  @Override
  public int deleteForWater(int no) {
    try{
      Statement stmt = connection.createStatement();
      return stmt.executeUpdate(String.format(
          "delete from waterPayMent where no = %d",no));
    }catch (Exception e){
      throw new RuntimeException("데이터 삭제 중 오류",e);
    }
  }

  @Override
  public int deleteForElectric(int no) {
    try{
      Statement stmt = connection.createStatement();
      return stmt.executeUpdate(String.format(
          "delete from electricPayMent where no = %d",no));
    }catch (Exception e){
      throw new RuntimeException("데이터 삭제 중 오류",e);
    }
  }

  @Override
  public List<PaymentSys> findAll() {
    try{
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery(
          "select t1.no wNo, t1.srvCd wCd, t1.fee wFee,t2.no eNo, t2.srvCd eCd, t2.fee eFee"
              + " from waterPayMent t1 , electricPayMent t2");
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
    try{
      Statement stmt = connection.createStatement();
      return stmt.executeUpdate(String.format(
          "update waterPayMent set srvCd = '%s', fee = '%s' where no = %d",
      paymentSys.getSrvCdForWater(),paymentSys.getFeeForWater(),paymentSys.getNoForWater()));
    }catch (Exception e){
      throw new RuntimeException("데이터 갱신 중 오류",e);
    }
  }

  @Override
  public int updateForElectric(PaymentSys paymentSys) {
    try{
      Statement stmt = connection.createStatement();
      return stmt.executeUpdate(String.format(
          "update electricPayMent set srvCd = '%s', fee = '%s' where no = %d",
          paymentSys.getSrvCdForElectric(),paymentSys.getFeeForElectric(),paymentSys.getNoForElectric()));
    }catch (Exception e){
      throw new RuntimeException("데이터 갱신 중 오류",e);
    }
  }
  @Override
  public PaymentSys findForWater(int no) {
    try{
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("select * from waterPayMent where no ="+no);
      rs.next();
      PaymentSys paymentSys = new PaymentSys();
      paymentSys.setNoForWater(rs.getInt("no"));
      paymentSys.setSrvCdForWater(rs.getString("srvCd"));
      paymentSys.setFeeForWater(rs.getInt("fee"));
      return paymentSys;
    }catch (Exception e){
      throw new RuntimeException("데이터 조회 중 오류",e);
    }
  }

  @Override
  public PaymentSys findFowElectric(int no) {
    try{
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("select * from electricPayMent where no ="+no);
      rs.next();
      PaymentSys paymentSys = new PaymentSys();
      paymentSys.setNoForElectric(rs.getInt("no"));
      paymentSys.setSrvCdForElectric(rs.getString("srvCd"));
      paymentSys.setFeeForElectric(rs.getInt("fee"));
      return paymentSys;
    }catch (Exception e){
      throw new RuntimeException("데이터 조회 중 오류",e);
    }
  }
}
