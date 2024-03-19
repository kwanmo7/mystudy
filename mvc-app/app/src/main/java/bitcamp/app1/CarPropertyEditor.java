package bitcamp.app1;

import java.beans.PropertyEditorSupport;

public class CarPropertyEditor extends PropertyEditorSupport {
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    String[] values = text.split(",");

    Car car = new Car();
    car.setModel(values[0]);
    car.setMaker(values[1]);
    car.setCapacity(Integer.parseInt(values[2]));
    car.setAuto(Boolean.parseBoolean(values[3]));
    car.setCreatedDate(java.sql.Date.valueOf(values[4]));

    setValue(car);
  }
}
