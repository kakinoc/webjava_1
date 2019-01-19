package jp.co.systena.tigerscave.SpringShopping.application.model;

public class Order {

  private Item item;
  private int num;

  public Object getItem() {
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
