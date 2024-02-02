package taxApp.vo;

import java.util.Date;

public class TaxStub {
  private int taxStub_no;

  private int mem_no;

  private String waterCd;
  private String electricCd;

  private int usageWater;

  private int usageElectric;

  private String taxStub_date;

  private int totalCost;
  private int waterCost;
  private int electricCost;

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

  public int getWaterCost() {
    return waterCost;
  }

  public void setWaterCost(int waterCost) {
    this.waterCost = waterCost;
  }

  public int getElectricCost() {
    return electricCost;
  }

  public void setElectricCost(int electricCost) {
    this.electricCost = electricCost;
  }

  public int getTaxStub_no() {
    return taxStub_no;
  }

  public void setTaxStub_no(int taxStub_no) {
    this.taxStub_no = taxStub_no;
  }

  public int getMem_no() {
    return mem_no;
  }

  public void setMem_no(int mem_no) {
    this.mem_no = mem_no;
  }

  public int getUsageWater() {
    return usageWater;
  }

  public void setUsageWater(int usageWater) {
    this.usageWater = usageWater;
  }

  public int getUsageElectric() {
    return usageElectric;
  }

  public void setUsageElectric(int usageElectric) {
    this.usageElectric = usageElectric;
  }

  public String getTaxStub_date() {
    return taxStub_date;
  }

  public void setTaxStub_date(String taxStub_date) {
    this.taxStub_date = taxStub_date;
  }

  public int getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(int totalCost) {
    this.totalCost = totalCost;
  }
}
