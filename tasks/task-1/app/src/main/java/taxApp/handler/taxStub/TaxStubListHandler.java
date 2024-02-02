package taxApp.handler.taxStub;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import taxApp.dao.TaxStubDao;
import taxApp.dao.UsageDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;
import taxApp.vo.TaxStub;
import taxApp.vo.Usage;

public class TaxStubListHandler extends AbstractMenuHandler {
  private TaxStubDao taxStubDao;

  public TaxStubListHandler(Prompt prompt, TaxStubDao taxStubDao) {
    super(prompt);
    this.taxStubDao = taxStubDao;
  }

  @Override
  protected void action() {
    System.out.println("[명세서 조회]");
    System.out.println("1. 전체 조회");
    System.out.println("2. 월별 조회");
    int no = prompt.inputInt("입력 > ");
    if( no == 1 ){
      printList(taxStubDao.findAll());
    }
    else if( no == 2 ){
      String date = prompt.input("조회할 년월 : >");
      printList(taxStubDao.findForYM(date));
    }
  }

  private void printList(List<TaxStub> list){
    for( TaxStub taxStub : list ){
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
    }
    System.out.println("====================================");
  }
}
