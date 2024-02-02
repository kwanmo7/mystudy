package taxApp.handler.paymentSys;

import taxApp.dao.PaymentSysDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;
import taxApp.vo.PaymentSys;

public class PaymentSysDeleteHandler extends AbstractMenuHandler {
  private PaymentSysDao paymentSysDao;

  public PaymentSysDeleteHandler(Prompt prompt, PaymentSysDao paymentSysDao) {
    super(prompt);
    this.paymentSysDao = paymentSysDao;
  }

  @Override
  protected void action() {
    try{
      System.out.println("[요금제 삭제]");
      System.out.println("1. 수도 요금");
      System.out.println("2. 전기 요금");
      int no = Integer.parseInt(prompt.input(" > "));
      if( no == 1 ){
        delForWater();
      }
      else if( no == 2 ){
        delForElectric();
      }
    }catch (NumberFormatException e){
      System.out.println("숫자를 입력하세요.");
    }
    catch (Exception e){
      System.out.println("요금제 삭제 중 오류 발생");
      System.out.println("다시 시도하시기 바랍니다.");
    }
  }
  private void delForWater(){
    int no = Integer.parseInt(prompt.input("삭제할 요금제 번호 : > "));
    paymentSysDao.deleteForWater(no);
  }
  private void delForElectric(){
    int no = Integer.parseInt(prompt.input("삭제할 요금제 번호 : > "));
    paymentSysDao.deleteForElectric(no);
  }
  
}
