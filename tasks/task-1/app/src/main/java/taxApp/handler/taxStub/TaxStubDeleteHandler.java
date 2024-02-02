package taxApp.handler.taxStub;

import java.sql.Date;
import taxApp.dao.TaxStubDao;
import taxApp.dao.UsageDao;
import taxApp.menu.AbstractMenuHandler;
import taxApp.util.Prompt;
import taxApp.vo.TaxStub;

public class TaxStubDeleteHandler extends AbstractMenuHandler {
  private TaxStubDao taxStubDao;

  public TaxStubDeleteHandler(Prompt prompt, TaxStubDao taxStubDao) {
    super(prompt);
    this.taxStubDao = taxStubDao;
  }

  @Override
  protected void action() {
    try{
      int no = prompt.inputInt("삭제할 회원 번호 : > ");
      String date = prompt.input("삭제할 년월 : >");
      taxStubDao.delete(no,date);
    }catch (NumberFormatException e) {
      System.out.println("숫자를 입력하세요.");
    }catch (IndexOutOfBoundsException e){
      System.out.println("회원 번호 오류");
    }catch (Exception e){
      System.out.println("회원 삭제 오류");
    }
  }
}
