package taxApp.handler.usage;

import java.sql.Date;
import java.text.SimpleDateFormat;
import taxApp.dao.UsageDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;
import taxApp.vo.Usage;

public class UsageViewHandler extends AbstractMenuHandler {
  private UsageDao usageDao;

  public UsageViewHandler(Prompt prompt, UsageDao usageDao) {
    super(prompt);
    this.usageDao = usageDao;
  }

  @Override
  protected void action() {
    try{
      int no = prompt.inputInt("조회할 회원 번호 : > ");
      String date = prompt.input("조회할 년월 : > ");
      Usage usage = usageDao.findBy(no,date);
      System.out.println("====================================");
      System.out.printf("No : %d\n",usage.getNo());
      System.out.printf("수도 사용량 : %d\n",usage.getWaterUsage());
      System.out.printf("전기 사용량 : %d\n",usage.getElectricUsage());
      System.out.printf("사용년월 : %s\n",usage.getUsageYM());
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
