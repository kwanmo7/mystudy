package taxApp.handler.taxStub;

import java.sql.Date;
import java.text.SimpleDateFormat;
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

public class TaxStubUpdateHandler extends AbstractMenuHandler {
  private TaxStubDao taxStubDao;
  private UsageDao usageDao;
  private MemberDao memberDao;
  private PaymentSysDao paymentSysDao;

  public TaxStubUpdateHandler(Prompt prompt, TaxStubDao taxStubDao, UsageDao usageDao,
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
      int no = prompt.inputInt("명세서 갱신할 회원 번호 : >");
      String date = prompt.input("갱신할 년월 : >");
      TaxStub old = taxStubDao.findBy(no,date);
      TaxStub taxStub = new TaxStub();
      taxStub.setMem_no(old.getMem_no());
      taxStub.setTaxStub_date(old.getTaxStub_date());
      Member member = memberDao.findBy(no);
      Usage usage = usageDao.findBy(no,date);
      List<PaymentSys> paymentSysList = paymentSysDao.findAll();
      taxStub.setWaterCd(member.getWaterCd());
      taxStub.setElectricCd(member.getElectricCd());
      taxStub.setUsageWater(usage.getWaterUsage());
      taxStub.setUsageElectric(usage.getElectricUsage());
      int feeWater = 100;
      int feeElectric = 100;
      for (PaymentSys paymentSys : paymentSysList) {
        if (member.getWaterCd().equals(paymentSys.getSrvCdForWater())) {
          feeWater = paymentSys.getFeeForWater();
        }
        if (member.getElectricCd().equals(paymentSys.getSrvCdForElectric())) {
          feeElectric = paymentSys.getFeeForElectric();
        }
      }
      feeWater = ((feeWater * usage.getWaterUsage()));
      feeElectric = ((feeElectric * usage.getElectricUsage()));
      taxStub.setWaterCost(feeWater);
      taxStub.setElectricCost(feeElectric);
      int total = feeWater+feeElectric;
      taxStub.setTotalCost(total);
      taxStubDao.update(taxStub);
    }catch (NumberFormatException e){
      System.out.println("숫자를 입력 하세요");
    }catch (IndexOutOfBoundsException e){
      System.out.println("회원 번호가 유효하지 않습니다.");
    } catch (Exception e){
      System.out.println("회원 변경 오류");
    }
  }
}
