package jp.co.systena.tigerscave.SpringShopping.application.model;

import java.util.ArrayList;

public class Cart {

  private ArrayList<Order> orderList;

  public ArrayList<Order> getOrderList() {
    return orderList;
  }

  public void setOrderList(ArrayList<Order> orderList) {
    this.orderList = orderList;
  }



}
