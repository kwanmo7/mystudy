package taxApp.vo;

import java.util.Date;

public class Statement {
  private int stmt_no;

  private int mem_no;

  private int use_water;

  private int use_electric;

  private Date stmt_date;

  private int cost;

  public int getStmt_no() {
    return stmt_no;
  }

  public void setStmt_no(int stmt_no) {
    this.stmt_no = stmt_no;
  }

  public int getMem_no() {
    return mem_no;
  }

  public void setMem_no(int mem_no) {
    this.mem_no = mem_no;
  }

  public int getUse_water() {
    return use_water;
  }

  public void setUse_water(int use_water) {
    this.use_water = use_water;
  }

  public int getUse_electric() {
    return use_electric;
  }

  public void setUse_electric(int use_electric) {
    this.use_electric = use_electric;
  }

  public Date getStmt_date() {
    return stmt_date;
  }

  public void setStmt_date(Date stmt_date) {
    this.stmt_date = stmt_date;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }
}
