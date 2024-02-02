package taxApp.dao;

import java.sql.Date;
import java.util.List;
import taxApp.vo.TaxStub;

public interface TaxStubDao {
  void add(TaxStub taxStub);

  int delete(int no, String taxStubYm);

  List<TaxStub> findAll();

  List<TaxStub> findForYM(String date);

  TaxStub findBy(int no, String data);

  int update(TaxStub taxStub);
}
