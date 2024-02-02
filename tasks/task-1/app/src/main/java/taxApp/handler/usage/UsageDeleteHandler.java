package taxApp.handler.usage;

import java.sql.Date;
import taxApp.dao.UsageDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;

public class UsageDeleteHandler extends AbstractMenuHandler {
  private UsageDao usageDao;

  public UsageDeleteHandler(Prompt prompt, UsageDao usageDao) {
    super(prompt);
    this.usageDao = usageDao;
  }

  @Override
  protected void action() {
    try{
      int no = prompt.inputInt("삭제할 회원 번호 : > ");
      String date = prompt.input("삭제할 년월 : >");
      usageDao.delete(no,date);
    }catch (NumberFormatException e) {
      System.out.println("숫자를 입력하세요.");
    }catch (IndexOutOfBoundsException e){
      System.out.println("회원 번호 오류");
    }catch (Exception e){
      System.out.println("회원 삭제 오류");
    }
  }
}
