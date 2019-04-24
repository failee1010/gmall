package com.lee.gmall.bean;


public class OrderDetail {

  private long id;
  private long orderId;
  private long skuId;
  private String skuName;
  private String imgFileName;
  private double orderPrice;
  private String skuNums;
  private long logisticsId;
  private String imgUrl;
  private String skuNum;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public long getSkuId() {
    return skuId;
  }

  public void setSkuId(long skuId) {
    this.skuId = skuId;
  }


  public String getSkuName() {
    return skuName;
  }

  public void setSkuName(String skuName) {
    this.skuName = skuName;
  }


  public String getImgFileName() {
    return imgFileName;
  }

  public void setImgFileName(String imgFileName) {
    this.imgFileName = imgFileName;
  }


  public double getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(double orderPrice) {
    this.orderPrice = orderPrice;
  }


  public String getSkuNums() {
    return skuNums;
  }

  public void setSkuNums(String skuNums) {
    this.skuNums = skuNums;
  }


  public long getLogisticsId() {
    return logisticsId;
  }

  public void setLogisticsId(long logisticsId) {
    this.logisticsId = logisticsId;
  }


  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }


  public String getSkuNum() {
    return skuNum;
  }

  public void setSkuNum(String skuNum) {
    this.skuNum = skuNum;
  }

}
