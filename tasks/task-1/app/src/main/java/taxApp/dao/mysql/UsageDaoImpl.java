package taxApp.dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import taxApp.dao.UsageDao;
import taxApp.vo.Usage;

public class UsageDaoImpl implements UsageDao {
  Connection connection;

  public UsageDaoImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void add(Usage usage) {
    try{
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(String.format(
          "insert into usage_t(waterUsage,electricUsage,usageYM) values(%d,%d,%s)"
          ,usage.getWaterUsage(),usage.getElectricUsage(),usage.getUsageYM()));
    }catch (Exception e){
      throw new RuntimeException("데이터 등록 중 오류",e);
    }
  }

  @Override
  public int delete(int no,String usageYM) {
    try{
      Statement stmt = connection.createStatement();
      return stmt.executeUpdate(String.format("delete from usage_t where no=%d and usageYM =",no,usageYM));
    }catch (Exception e){
      throw new RuntimeException("데이터 삭제 중 오류",e);
    }
  }

  @Override
  public List<Usage> findAll() {
    try{
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("select * from usage_t");
      List<Usage> list = new ArrayList<>();
      while(rs.next()){
        Usage usage = new Usage();
        usage.setNo(rs.getInt("no"));
        usage.setWaterUsage(rs.getInt("waterUsage"));
        usage.setElectricUsage(rs.getInt("electricUsage"));
        usage.setUsageYM(rs.getString("usageYM"));
        list.add(usage);
      }
      return list;
    }catch (Exception e){
      throw new RuntimeException("데이터 조회 중 오류",e);
    }
  }

  @Override
  public List<Usage> findForYM(String usageYM) {
    try{
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("select * from usage_t where usageYM ='"+usageYM+"'");
      List<Usage> list = new ArrayList<>();
      while(rs.next()){
        Usage usage = new Usage();
        usage.setNo(rs.getInt("no"));
        usage.setWaterUsage(rs.getInt("waterUsage"));
        usage.setElectricUsage(rs.getInt("electricUsage"));
        usage.setUsageYM(rs.getString("usageYM"));
        list.add(usage);
      }
      return list;
    }catch (Exception e){
      throw new RuntimeException("데이터 조회 중 오류",e);
    }
  }

  @Override
  public Usage findBy(int no, String  usageYM) {
    try{
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("select * from usage_t where no="+no+" and usageYM = '"+usageYM+"'");
      rs.next();
      Usage usage = new Usage();
      usage.setNo(rs.getInt("no"));
      usage.setWaterUsage(rs.getInt("waterUsage"));
      usage.setElectricUsage(rs.getInt("electricUsage"));
      usage.setUsageYM(rs.getString("usageYM"));
      return usage;
    }catch (Exception e){
      throw new RuntimeException("데이터 조회 중 오류",e);
    }
  }

  @Override
  public int update(Usage usage) {
    try{
      Statement stmt = connection.createStatement();
      SimpleDateFormat date = new SimpleDateFormat("yyyy-MM");
      return stmt.executeUpdate(String.format(
          "update usage_t set waterUsage = %d , electricUsage = %d "
              + "where no = %d and usageYM = '%s'"
          ,usage.getWaterUsage(),usage.getElectricUsage(),
          usage.getNo(),date.format(usage.getUsageYM())));
    }catch (Exception e){
      throw new RuntimeException("데이터 갱신 중 오류",e);
    }
  }
}
