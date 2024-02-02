package taxApp.handler.paymentSys;

import java.util.ArrayList;
import java.util.List;
import taxApp.dao.PaymentSysDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;
import taxApp.vo.PaymentSys;

public class PaymentSysListHandler extends AbstractMenuHandler {

  private PaymentSysDao paymentSysDao;

  public PaymentSysListHandler(Prompt prompt, PaymentSysDao paymentSysDao) {
    super(prompt);
    this.paymentSysDao = paymentSysDao;
  }

  @Override
  protected void action() {
    try {
      System.out.println("[요금제 조회]");
      System.out.println("1. 전체 요금제 조회");
      System.out.println("2. 수도 요금제 조회");
      System.out.println("3. 전기 요금제 조회");
      int no = prompt.inputInt("> ");
      List<PaymentSys> list =  paymentSysDao.findAll();
      if (no == 1) {
        for(PaymentSys paymentSys : list){
          System.out.println("====================================");
          System.out.println("수도 요금제");
          System.out.printf("No : %d\n",paymentSys.getNoForWater());
          System.out.printf("서비스 코드 : %s\n",paymentSys.getSrvCdForWater());
          System.out.printf("요금 : %d\n",paymentSys.getFeeForWater());
          System.out.println("====================================");
          System.out.println("전기 요금제");
          System.out.printf("No : %d\n",paymentSys.getNoForElectric());
          System.out.printf("서비스 코드 : %s\n",paymentSys.getSrvCdForElectric());
          System.out.printf("요금 : %d\n",paymentSys.getFeeForElectric());
        }
        System.out.println("====================================");
      } else if (no == 2) {
        for(PaymentSys paymentSys : list) {
          System.out.println("====================================");
          System.out.println("수도 요금제");
          System.out.printf("No : %d\n", paymentSys.getNoForWater());
          System.out.printf("서비스 코드 : %s\n", paymentSys.getSrvCdForWater());
          System.out.printf("요금 : %d\n", paymentSys.getFeeForWater());
        }
        System.out.println("====================================");
      } else if (no == 3) {
        for( PaymentSys paymentSys : list ){
          System.out.println("====================================");
          System.out.println("전기 요금제");
          System.out.printf("No : %d\n",paymentSys.getNoForElectric());
          System.out.printf("서비스 코드 : %s\n",paymentSys.getSrvCdForElectric());
          System.out.printf("요금 : %d\n",paymentSys.getFeeForElectric());
        }
        System.out.println("====================================");
      }
    } catch (NumberFormatException e) {
      System.out.println("숫자를 입력 하세요.");
    } catch (Exception e) {
      System.out.println("데이터 조회 오류");
      e.printStackTrace();
    }
  }
}

