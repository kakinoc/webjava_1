package jp.co.systena.tigerscave.SpringShopping.application.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ListForm {

  @NotNull
  @Size(min = 1, max = 255)
  private Item item;

  @NotNull
  @Size(min = 1, max = 255)
  private int num;

  public Item getItem() {
    return item;
  }
  public void setItem(Item item) {
    this.item = item;
  }
  public int getNum() {
    return num;
  }
  public void setNum(int num) {
    this.num = num;
  }

}
