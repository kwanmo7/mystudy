package taxApp.dao;

import java.util.List;
import taxApp.vo.PaymentSys;

public interface PaymentSysDao {
  void addForWater(PaymentSys paymentSys);

  void addForElectric(PaymentSys paymentSys);

  int deleteForWater(int no);
  int deleteForElectric(int no);

  List<PaymentSys> findAll();

  int updateForWater(PaymentSys paymentSys);

  int updateForElectric(PaymentSys paymentSys);

  PaymentSys findForWater(int no);

  PaymentSys findFowElectric(int no);
}
