package com.lee.gmall.bean;


public class CartInfo {

  private long id;
  private long userId;
  private long skuId;
  private double cartPrice;
  private long quantity;
  private String imgUrl;
  private String isChecked;
  private double skuPrice;
  private double skuNum;
  private String skuName;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getSkuId() {
    return skuId;
  }

  public void setSkuId(long skuId) {
    this.skuId = skuId;
  }


  public double getCartPrice() {
    return cartPrice;
  }

  public void setCartPrice(double cartPrice) {
    this.cartPrice = cartPrice;
  }


  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }


  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }


  public String getIsChecked() {
    return isChecked;
  }

  public void setIsChecked(String isChecked) {
    this.isChecked = isChecked;
  }


  public double getSkuPrice() {
    return skuPrice;
  }

  public void setSkuPrice(double skuPrice) {
    this.skuPrice = skuPrice;
  }


  public double getSkuNum() {
    return skuNum;
  }

  public void setSkuNum(double skuNum) {
    this.skuNum = skuNum;
  }


  public String getSkuName() {
    return skuName;
  }

  public void setSkuName(String skuName) {
    this.skuName = skuName;
  }

}
