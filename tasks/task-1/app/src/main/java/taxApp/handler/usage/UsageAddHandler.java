package taxApp.handler.usage;

import taxApp.dao.UsageDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;
import taxApp.vo.Usage;

public class UsageAddHandler extends AbstractMenuHandler {
  private UsageDao usageDao;

  public UsageAddHandler(Prompt prompt, UsageDao usageDao) {
    super(prompt);
    this.usageDao = usageDao;
  }

  @Override
  protected void action() {
    try{
      Usage usage = new Usage();
      System.out.println("[사용량 등록]");
      usage.setUsageYM(prompt.input("사용년월 : >"));
      usage.setWaterUsage(prompt.inputInt("수도 사용량 : >"));
      usage.setElectricUsage(prompt.inputInt("전기 사용량 : >"));
      usageDao.add(usage);
    }catch (Exception e){
      System.out.println("사용량 등록 중 오류 발생");
      System.out.println("다시 시도하시기 바랍니다.");
    }
  }
}
