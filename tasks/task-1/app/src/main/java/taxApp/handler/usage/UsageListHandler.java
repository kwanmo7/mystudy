package taxApp.handler.usage;

import java.util.List;
import taxApp.dao.UsageDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;
import taxApp.vo.Usage;

public class UsageListHandler extends AbstractMenuHandler {
  private UsageDao usageDao;

  public UsageListHandler(Prompt prompt, UsageDao usageDao) {
    super(prompt);
    this.usageDao = usageDao;
  }

  @Override
  protected void action() {
    List<Usage> list = usageDao.findAll();
    for( Usage usage : list ){
      System.out.println("====================================");
      System.out.printf("No : %d\n" , usage.getNo());
      System.out.printf("수도사용량 : %d\n" , usage.getWaterUsage());
      System.out.printf("전기사용량 : %d\n" , usage.getElectricUsage());
      System.out.printf("사용년월 : %s\n" , usage.getUsageYM());
    }
    System.out.println("====================================");
  }
}
