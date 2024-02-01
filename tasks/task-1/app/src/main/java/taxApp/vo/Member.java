package taxApp.vo;

import java.sql.Date;

public class Member {
  private int no;
  private String name;
  private String tel;
  private String email;

  private String waterCd;

  private String electricCd;
  private Date entryDate;

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getWaterCd() {
    return waterCd;
  }

  public void setWaterCd(String waterCd) {
    this.waterCd = waterCd;
  }

  public String getElectricCd() {
    return electricCd;
  }

  public void setElectricCd(String electricCd) {
    this.electricCd = electricCd;
  }

  public Date getEntryDate() {
    return entryDate;
  }

  public void setEntryDate(Date entryDate) {
    this.entryDate = entryDate;
  }
}
