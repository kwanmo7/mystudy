package taxApp.handler.taxStub;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import taxApp.dao.MemberDao;
import taxApp.dao.PaymentSysDao;
import taxApp.dao.TaxStubDao;
import taxApp.dao.UsageDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;
import taxApp.vo.Member;
import taxApp.vo.PaymentSys;
import taxApp.vo.TaxStub;
import taxApp.vo.Usage;

public class TaxStubAddHandler extends AbstractMenuHandler {
  private TaxStubDao taxStubDao;
  private UsageDao usageDao;
  private MemberDao memberDao;
  private PaymentSysDao paymentSysDao;

  public TaxStubAddHandler(Prompt prompt, TaxStubDao taxStubDao, UsageDao usageDao,
      MemberDao memberDao, PaymentSysDao paymentSysDao) {
    super(prompt);
    this.taxStubDao = taxStubDao;
    this.usageDao = usageDao;
    this.memberDao = memberDao;
    this.paymentSysDao = paymentSysDao;
  }

  @Override
  protected void action() {
    try{
      TaxStub taxStub = new TaxStub();
      System.out.println("[명세서 등록]");
      int no = prompt.inputInt("등록할 회원 번호 : >");
      String date = prompt.input("등록할 사용년월 : >");
      Member member = memberDao.findBy(no);
      Usage usage = usageDao.findBy(no,date);
      List<PaymentSys> paymentSysList = paymentSysDao.findAll();

      taxStub.setMem_no(no);
      taxStub.setWaterCd(member.getWaterCd());
      taxStub.setElectricCd(member.getElectricCd());
      taxStub.setUsageWater(usage.getWaterUsage());
      taxStub.setUsageElectric(usage.getElectricUsage());
      taxStub.setTaxStub_date(date);

      int feeWater = 0;
      int feeElectric = 0;
      for( int i = 0; i < paymentSysList.size(); i++ ){
        if( member.getWaterCd().equals(paymentSysList.get(i).getSrvCdForWater()) ){
          feeWater = paymentSysList.get(i).getFeeForWater();
        }
        if( member.getElectricCd().equals(paymentSysList.get(i).getSrvCdForElectric()) ){
          feeElectric = paymentSysList.get(i).getFeeForElectric();
        }
      }
      feeWater = ((feeWater * usage.getWaterUsage())/1000);
      feeElectric = ((feeElectric * usage.getElectricUsage())/1000);
      taxStub.setWaterCost(feeWater);
      taxStub.setElectricCost(feeElectric);
      int total = feeWater+feeElectric;
      taxStub.setTotalCost(total);

      taxStubDao.add(taxStub);
    }catch (Exception e){
      System.out.println("사용량 등록 중 오류 발생");
      System.out.println("다시 시도하시기 바랍니다.");
      e.printStackTrace();
    }
  }
}
