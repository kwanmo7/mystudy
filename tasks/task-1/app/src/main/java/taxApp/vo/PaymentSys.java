package taxApp.vo;

public class PaymentSys {
  private int noForWater;
  private String srvCdForWater;
  private int feeForWater;
  private int noForElectric;
  private String srvCdForElectric;
  private int feeForElectric;

  public int getNoForWater() {
    return noForWater;
  }

  public void setNoForWater(int noForWater) {
    this.noForWater = noForWater;
  }

  public int getNoForElectric() {
    return noForElectric;
  }

  public void setNoForElectric(int noForElectric) {
    this.noForElectric = noForElectric;
  }

  public String getSrvCdForWater() {
    return srvCdForWater;
  }

  public void setSrvCdForWater(String srvCdForWater) {
    this.srvCdForWater = srvCdForWater;
  }

  public int getFeeForWater() {
    return feeForWater;
  }

  public void setFeeForWater(int feeForWater) {
    this.feeForWater = feeForWater;
  }

  public String getSrvCdForElectric() {
    return srvCdForElectric;
  }

  public void setSrvCdForElectric(String srvCdForElectric) {
    this.srvCdForElectric = srvCdForElectric;
  }

  public int getFeeForElectric() {
    return feeForElectric;
  }

  public void setFeeForElectric(int feeForElectric) {
    this.feeForElectric = feeForElectric;
  }
}
