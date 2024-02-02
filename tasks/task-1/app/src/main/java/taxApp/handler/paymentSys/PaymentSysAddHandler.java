package taxApp.handler.paymentSys;

import taxApp.dao.PaymentSysDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;
import taxApp.vo.PaymentSys;

public class PaymentSysAddHandler extends AbstractMenuHandler {
  private PaymentSysDao paymentSysDao;

  public PaymentSysAddHandler(Prompt prompt, PaymentSysDao paymentSysDao) {
    super(prompt);
    this.paymentSysDao = paymentSysDao;
  }

  @Override
  protected void action() {
    try{
      System.out.println("[요금제 등록]");
      System.out.println("1. 수도 요금");
      System.out.println("2. 전기 요금");
      int no = prompt.inputInt("> ");
      if( no == 1 ){
        addForWater();
      }
      else if( no == 2 ){
        addForElectric();
      }
    }catch (NumberFormatException e){
      System.out.println("숫자를 입력하세요.");
    }
    catch (Exception e){
      System.out.println("요금제 등록 중 오류 발생");
      System.out.println("다시 시도하시기 바랍니다.");
    }
  }
  private void addForWater(){
    PaymentSys paymentSys = new PaymentSys();
    paymentSys.setSrvCdForWater(prompt.input("서비스 코드 : >"));
    paymentSys.setFeeForWater(prompt.inputInt("요금 : >"));
    paymentSysDao.addForWater(paymentSys);
  }
  private void addForElectric(){
    PaymentSys paymentSys = new PaymentSys();
    paymentSys.setSrvCdForElectric(prompt.input("서비스 코드 : >"));
    paymentSys.setFeeForElectric(prompt.inputInt("요금 : >"));
    paymentSysDao.addForElectric(paymentSys);
  }
}
