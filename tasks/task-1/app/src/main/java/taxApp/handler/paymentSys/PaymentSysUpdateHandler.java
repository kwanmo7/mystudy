package taxApp.handler.paymentSys;

import taxApp.dao.PaymentSysDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;
import taxApp.vo.PaymentSys;

public class PaymentSysUpdateHandler extends AbstractMenuHandler {
  private PaymentSysDao paymentSysDao;

  public PaymentSysUpdateHandler(Prompt prompt, PaymentSysDao paymentSysDao) {
    super(prompt);
    this.paymentSysDao = paymentSysDao;
  }

  @Override
  protected void action() {
    try{
      System.out.println("[요금제 변경]");
      System.out.println("1. 수도 요금");
      System.out.println("2. 전기 요금");
      int no = Integer.parseInt(prompt.input("> "));
      if( no == 1 ){
        uptForWater();
      }
      else if( no == 2 ){
        uptForElectric();
      }
    }catch (NumberFormatException e){
      System.out.println("숫자를 입력하세요.");
    }
    catch (Exception e){
      System.out.println("요금제 변경 중 오류 발생");
      System.out.println("다시 시도하시기 바랍니다.");
    }
  }
  private void uptForWater(){
    int no = Integer.parseInt(prompt.input("변경할 요금제 번호 : > "));
    PaymentSys old = paymentSysDao.findForWater(no);
    PaymentSys paymentSys = new PaymentSys();
    paymentSys.setNoForWater(old.getNoForWater());
    paymentSys.setSrvCdForWater(prompt.input("서비스 코드(%s) : > ",old.getSrvCdForWater()));
    paymentSys.setFeeForWater(prompt.inputInt("요금(%s) : > ",old.getFeeForWater()));
    paymentSysDao.updateForWater(paymentSys);
  }
  private void uptForElectric(){
    int no = Integer.parseInt(prompt.input("변경할 요금제 번호 : > "));
    PaymentSys old = paymentSysDao.findFowElectric(no);
    PaymentSys paymentSys = new PaymentSys();
    paymentSys.setFeeForElectric(old.getNoForElectric());
    paymentSys.setSrvCdForElectric(prompt.input("서비스 코드(%s) : > ",old.getSrvCdForElectric()));
    paymentSys.setFeeForElectric(prompt.inputInt("요금(%s) : > ",old.getFeeForElectric()));
    paymentSysDao.updateForWater(paymentSys);
  }

}
