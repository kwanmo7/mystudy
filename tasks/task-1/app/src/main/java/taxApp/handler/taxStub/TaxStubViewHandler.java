package taxApp.handler.taxStub;

import java.sql.Date;
import java.text.SimpleDateFormat;
import taxApp.dao.TaxStubDao;
import taxApp.dao.UsageDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;
import taxApp.vo.TaxStub;
import taxApp.vo.Usage;

public class TaxStubViewHandler extends AbstractMenuHandler {
  private TaxStubDao taxStubDao;

  public TaxStubViewHandler(Prompt prompt, TaxStubDao taxStubDao) {
    super(prompt);
    this.taxStubDao = taxStubDao;
  }

  @Override
  protected void action() {
    try{
      int no = prompt.inputInt("조회할 회원 번호 : > ");
      String date = prompt.input("조회할 년월 : > ");
      TaxStub taxStub = taxStubDao.findBy(no,date);
      System.out.println("====================================");
      System.out.printf("명세번호 : %d\n" , taxStub.getTaxStub_no());
      System.out.printf("회원번호 : %d\n" , taxStub.getMem_no());
      System.out.printf("명세년월 : %s\n" , taxStub.getTaxStub_date());
      System.out.printf("수도코드 : %s\n" , taxStub.getWaterCd());
      System.out.printf("전기코드 : %s\n" , taxStub.getElectricCd());
      System.out.printf("수도사용량 : %d\n" , taxStub.getUsageWater());
      System.out.printf("수도요금 : %d\n" , taxStub.getWaterCost());
      System.out.printf("전기사용량 : %d\n" , taxStub.getUsageElectric());
      System.out.printf("전기요금 : %d\n" , taxStub.getElectricCost());
      System.out.printf("전체요금 : %d\n" , taxStub.getTotalCost());
      System.out.println("====================================");
    }catch (NumberFormatException e){
      System.out.println("숫자를 입력 하세요");
    }catch (IndexOutOfBoundsException e){
      System.out.println("회원 번호가 유효하지 않습니다.");
    }catch (Exception e){
      System.out.println("회원 조회 중 오류");
    }
  }
}
