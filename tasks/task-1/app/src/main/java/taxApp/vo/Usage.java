package taxApp.vo;

import java.sql.Date;

public class Usage {
  private int no;
  private int waterUsage;
  private int electricUsage;
  private String usageYM;

  public String getUsageYM() {
    return usageYM;
  }

  public void setUsageYM(String usageYM) {
    this.usageYM = usageYM;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getWaterUsage() {
    return waterUsage;
  }

  public void setWaterUsage(int waterUsage) {
    this.waterUsage = waterUsage;
  }

  public int getElectricUsage() {
    return electricUsage;
  }

  public void setElectricUsage(int electricUsage) {
    this.electricUsage = electricUsage;
  }
}
