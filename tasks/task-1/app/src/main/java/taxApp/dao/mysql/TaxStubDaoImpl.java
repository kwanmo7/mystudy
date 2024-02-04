package taxApp.dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import taxApp.dao.TaxStubDao;
import taxApp.vo.TaxStub;


public class TaxStubDaoImpl implements TaxStubDao {
  Connection connection;

  public TaxStubDaoImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void add(TaxStub taxStub) {
    try{
      Statement stmt = connection.createStatement();
      StringBuilder sb = new StringBuilder();
      sb.append("insert into taxStub(mem_no,srvCdForWater,"
          + "srvCdForElectric,taxStubYM,usageWater,"
          + "waterCost,usageElectric,electricCost,totalCost) values("+taxStub.getMem_no()+",'"+taxStub.getWaterCd()+"','"+taxStub.getElectricCd()+"','"
          +taxStub.getTaxStub_date()+"',"+taxStub.getUsageWater()+","+taxStub.getWaterCost()+","+taxStub.getUsageElectric()+","+taxStub.getElectricCost()
          +","+taxStub.getTotalCost()+")");
      stmt.executeUpdate(String.valueOf(sb));
    }catch (Exception e){
      throw new RuntimeException("데이터 등록 중 오류",e);
    }
  }

  @Override
  public int delete(int no, String taxStubYm) {
    try{
      Statement stmt = connection.createStatement();
      return stmt.executeUpdate(String.format("delete from taxStub where mem_no = %d and taxStubYM ='%s'",no,taxStubYm));
    }catch (Exception e){
      throw new RuntimeException("데이터 삭제 중 오류",e);
    }
  }

  @Override
  public List<TaxStub> findAll() {
    try{
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("select * from taxStub");
      SimpleDateFormat date = new SimpleDateFormat("yyyy-MM");
      List<TaxStub> list = new ArrayList<>();
      while(rs.next()){
        TaxStub taxStub = new TaxStub();
        taxStub.setTaxStub_no(rs.getInt("no"));
        taxStub.setMem_no(rs.getInt("mem_no"));
        taxStub.setWaterCd(rs.getString("srvCdForWater"));
        taxStub.setElectricCd(rs.getString("srvCdForElectric"));
        taxStub.setUsageWater(rs.getInt("usageWater"));
        taxStub.setUsageElectric(rs.getInt("usageElectric"));
        taxStub.setWaterCost(rs.getInt("waterCost"));
        taxStub.setElectricCost(rs.getInt("electricCost"));
        taxStub.setTotalCost(rs.getInt("totalCost"));
        taxStub.setTaxStub_date(rs.getString("taxStubYM"));
        list.add(taxStub);
      }
      return list;
    }catch (Exception e){
      throw new RuntimeException("데이터 조회 중 오류",e);
    }
  }

  @Override
  public List<TaxStub> findForYM(String date) {
    try{
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("select * from taxStub where taxStubYM = "+date);
      List<TaxStub> list = new ArrayList<>();
      while(rs.next()){
        TaxStub taxStub = new TaxStub();
        taxStub.setTaxStub_no(rs.getInt("no"));
        taxStub.setMem_no(rs.getInt("mem_no"));
        taxStub.setWaterCd(rs.getString("srvCdForWater"));
        taxStub.setElectricCd(rs.getString("srvCdForElectric"));
        taxStub.setUsageWater(rs.getInt("usageWater"));
        taxStub.setUsageElectric(rs.getInt("usageElectric"));
        taxStub.setWaterCost(rs.getInt("waterCost"));
        taxStub.setElectricCost(rs.getInt("electricCost"));
        taxStub.setTotalCost(rs.getInt("totalCost"));
        taxStub.setTaxStub_date(rs.getString("taxStubYM"));
        list.add(taxStub);
      }
      return list;
    }catch (Exception e){
      throw new RuntimeException("데이터 조회 중 오류",e);
    }
  }

  @Override
  public TaxStub findBy(int no, String date) {
    try{
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("select * from taxStub where mem_no="+no+" and taxStubYM = '"+date+"'");
      rs.next();
      TaxStub taxStub = new TaxStub();
      taxStub.setTaxStub_no(rs.getInt("no"));
      taxStub.setMem_no(rs.getInt("mem_no"));
      taxStub.setWaterCd(rs.getString("srvCdForWater"));
      taxStub.setElectricCd(rs.getString("srvCdForElectric"));
      taxStub.setUsageWater(rs.getInt("usageWater"));
      taxStub.setUsageElectric(rs.getInt("usageElectric"));
      taxStub.setWaterCost(rs.getInt("waterCost"));
      taxStub.setElectricCost(rs.getInt("electricCost"));
      taxStub.setTotalCost(rs.getInt("totalCost"));
      taxStub.setTaxStub_date(rs.getString("taxStubYM"));
      return taxStub;
    }catch (Exception e){
      throw new RuntimeException("데이터 조회 중 오류",e);
    }
  }

  @Override
  public int update(TaxStub taxStub) {
    try{
      Statement stmt = connection.createStatement();
      StringBuilder sb = new StringBuilder();
      sb.append("update taxStub set srvCdForWater = '").append(taxStub.getWaterCd())
          .append("', srvCdForElectric = '").append(taxStub.getElectricCd())
          .append("', usageWater = ").append(taxStub.getUsageWater()).append(", usageElectric = ")
          .append(taxStub.getUsageElectric()).append(" , waterCost = ")
          .append(taxStub.getWaterCost()).append(" , electricCost = ")
          .append(taxStub.getElectricCost()).append(" , totalCost = ")
          .append(taxStub.getTotalCost()).append(" ").append("where mem_no = ")
          .append(taxStub.getMem_no()).append(" and taxStubYM = '")
          .append(taxStub.getTaxStub_date()).append("'");
      return stmt.executeUpdate(String.valueOf(sb));
      /*
      * String.format(
          "update taxStub set srvCdForWater = '%s' , srvCdForElectric = '%s' , usageWater = %d , "
              + "usageElectric = %d, waterCost = %d , electricCost = %d, totalCost = %d "
              + "where mem_no = %d and taxStubYM = '%s'"
          ,taxStub.getWaterCd(),taxStub.getElectricCd(),taxStub.getUsageWater(),
          taxStub.getUsageElectric(),taxStub.getWaterCost(),taxStub.getElectricCost(),
          taxStub.getTotalCost(),taxStub.getMem_no(),
          taxStub.getTaxStub_date())*/
    }catch (Exception e){
      throw new RuntimeException("데이터 갱신 중 오류",e);
    }
  }
}
