package taxApp.dao;

import java.sql.Date;
import java.util.List;
import taxApp.vo.Usage;

public interface UsageDao {
  void add(Usage usage);
  int delete(int no, String usageYM);
  List<Usage> findAll();
  List<Usage> findForYM(String usageYM);
  Usage findBy(int no,String usageYM);
  int update(Usage usage);
}
