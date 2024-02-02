package taxApp.handler.usage;

import java.sql.Date;
import java.text.SimpleDateFormat;
import taxApp.dao.UsageDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;
import taxApp.vo.Member;
import taxApp.vo.Usage;

public class UsageUpdateHandler extends AbstractMenuHandler {
  private UsageDao usageDao;

  public UsageUpdateHandler(Prompt prompt, UsageDao usageDao) {
    super(prompt);
    this.usageDao = usageDao;
  }

  @Override
  protected void action() {
    try{
      int no = prompt.inputInt("수정할 회원 번호 : >");
      SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM");
      String date = prompt.input("수정할 년월 : >");
      Usage old = usageDao.findBy(no,date);
      Usage usage = new Usage();
      usage.setNo(old.getNo());
      usage.setUsageYM(old.getUsageYM());
      usage.setWaterUsage(prompt.inputInt("수도사용량(%d) : > ",old.getWaterUsage()));
      usage.setElectricUsage(prompt.inputInt("전기사용량(%d) : > ",old.getElectricUsage()));
      usageDao.update(usage);
    }catch (NumberFormatException e){
      System.out.println("숫자를 입력 하세요");
    }catch (IndexOutOfBoundsException e){
      System.out.println("회원 번호가 유효하지 않습니다.");
    } catch (Exception e){
      System.out.println("회원 변경 오류");
    }
  }
}
